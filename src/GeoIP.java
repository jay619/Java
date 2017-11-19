/*
 * Shah Jaynish
 * CSCI-211
 * FINAL PROJECT
 * Geolocating an IP address
 * shahjaynish@gmail.com
 * May 4th, 2015
 * On my honor as a student, I pledge that I have not received or given any unauthorized assistance in this exam.
 */
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
 
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class GeoIP extends Application {
        private TextField a = new TextField();
        private TextField b = new TextField();
        private TextField c = new TextField();
        private TextField d = new TextField();
        private Button locate = new Button("Locate");
        private Button rset = new Button("Reset");
        private TextArea result = new TextArea();
        private Label dot1 = new Label(".");
        private Label dot2 = new Label(".");
        private Label dot3 = new Label(".");
        private Label ip = new Label("Enter IP:");
        private Statement preparedStatement;
        private String queryString;
 
        @Override
        public void start(Stage primaryStage) {
 
                initializeDB();
 
                result.setPrefColumnCount(35);
                result.setPrefRowCount(10);
 
                BorderPane bPane = new BorderPane();
                bPane.setLeft(new Label("Result:"));
                bPane.setBottom(result);
 
                FlowPane fPane = new FlowPane();
                fPane.setPadding(new Insets(10, 10, 10, 10));
                fPane.setHgap(5);
                fPane.setVgap(5);
 
                fPane.getChildren().addAll(ip, a, dot1, b, dot2, c, dot3, d, locate,
                                rset);
                a.setPrefColumnCount(3);
                b.setPrefColumnCount(3);
                c.setPrefColumnCount(3);
                d.setPrefColumnCount(3);
                fPane.getChildren().addAll(bPane);
                fPane.setAlignment(Pos.CENTER);
 
                locate.setOnAction(e -> {
                        geoLocation();
                });
 
                rset.setOnAction(e -> {
                        reset();
                });
 
                Scene scene = new Scene(fPane, 480, 250);
                primaryStage.setTitle("Geolocate an IP address.");
                primaryStage.setScene(scene);
                primaryStage.show();
                primaryStage.setResizable(false);
        }
 
        private void reset() {
                a.setText("");
                b.setText("");
                c.setText("");
                d.setText("");
                result.setText("");
        }
 
        private void initializeDB() {
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        System.out.println("Driver Loaded");
 
                        final String url = "jdbc:mysql://cs.stcc.edu/silvestri";
                        final String user = "shah";
                        final String password = "0282289";
 
                        Connection connection = DriverManager.getConnection(url, user,
                                        password);
                        System.out.println("Database Connected");
 
                        preparedStatement = connection.createStatement();
 
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
 
        }
 
        public String cityFormater(String unformattedCity) {
                String pattern = "(^[A-Za-z]+)(\\W)*(\\d)*([A-Za-z]+)(\\W)*(\\d)*([A-Za-z]{0,2})";
                Pattern ci = Pattern.compile(pattern);
                Matcher cityMatcher = ci.matcher(unformattedCity);
                String cityFormatted = "Not available";
 
                if (cityMatcher.find()) { // to check if the city is one worded or two.
                        int x = cityMatcher.group(4).length();// group(4) checks for the
                                                                                                        // second word.
                        if (x <= 1) { // if city = Holyoke%2C%20MA
                                cityFormatted = cityMatcher.group(1);
                        } else if (x > 1) // if city = Los%20Angeles%2C%20CA
                                cityFormatted = cityMatcher.group(1) + " "
                                                + cityMatcher.group(4);
                }
                return cityFormatted;
        }
 
        private void geoLocation() {
 
                try {
 
                        int a1 = Integer.parseInt(a.getText());
                        int b1 = Integer.parseInt(b.getText());
                        int c1 = Integer.parseInt(c.getText());
                        int d1 = Integer.parseInt(d.getText());
 
                        if (a1 < 0 || a1 > 255) {
                                result.setText("Please enter a valid IP (0-255)");
                        } else if (b1 < 0 || b1 > 255) {
                                result.setText("Please enter a valid IP (0-255)");
                        } else if (c1 < 0 || c1 > 255) {
                                result.setText("Please enter a valid IP (0-255)");
                        } else if (d1 < 0 || d1 > 255) {
                                result.setText("Please enter a valid IP (0-255)");
                        } else {
 
                                // if there are no error in the input this else block is
                                // executed.
 
                                String aOct = a.getText();
                                String bOct = b.getText();
                                String cOct = c.getText();
 
                                String ip4 = "ip4_" + aOct;
 
                                queryString = "select countries.name, cityByCountry.name, state from countries, cityByCountry,"
                                                + ip4
                                                + " where b = '"
                                                + bOct
                                                + "'and c = '"
                                                + cOct
                                                + "' and "
                                                + " countries.id = "
                                                + ip4
                                                + ".country "
                                                + " and cityByCountry.city = " + ip4 + ".city";
                                ResultSet rset = preparedStatement.executeQuery(queryString);
 
                                String state = "Not Found";
                                String city = "Not Found";
                                String country = "Not Found";
 
                                if (rset.next()) {
                                        country = rset.getString(1);
                                        city = rset.getString(2);
                                        state = rset.getString(3);
 
                                        result.setText("Country: " + country + "\n State: " + state
                                                        + "\n City: " + cityFormater(city));
 
                                } else
                                        result.setText("Not found in the database.");
                        }
                } catch (NumberFormatException en) {
                        result.setText("Wrong format. IP should consist of 4 octets between (0-255)");
                } catch (SQLException ex) {
                        ex.printStackTrace();
                }
        }
 
        public static void main(String[] args) {
                launch(args);
        }
 
}
/*
 * Jaynish Shah
 * CSCI-211
 * Assignment 10
 * April 2, 2015
 * shahjaynish@gmail.com
 * Control Polygon Sides
 */

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControlPolygon2 extends Application {
	@Override
	public void start(Stage primaryStage) {

		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btIncrease = new Button("Increase Sides(+)");
		Button btDecrease = new Button("Decrease Sides(-)");
		hBox.getChildren().add(btIncrease);
		hBox.getChildren().add(btDecrease);

		Text control = new Text("Press Increase to start adding sides.");

		PolygonPane polygonPane = new PolygonPane();

		BorderPane borderPane = new BorderPane();
		borderPane.setTop(control);
		borderPane.setCenter(polygonPane);
		borderPane.setBottom(hBox);

		btIncrease.setOnAction(e -> polygonPane.increase());

		btDecrease.setOnAction(e -> polygonPane.decrease());

		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 300, 250);
		primaryStage.setTitle("Polygon Control"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support.
	 * Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}

}

class PolygonPane extends BorderPane {

	private Polygon polygon = new Polygon();
	private int minSides = 3;

	public PolygonPane() {
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();

		double centerX = this.getWidth() / 2, centerY = this.getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// Add points to the polygon list
		for (int i = 0; i < 3; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / 3));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / 3));
		}

		getChildren().clear();
		getChildren().add(polygon);
	}

	public void increase() {
		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		polygon.setFill(Color.WHITE);
		polygon.setStroke(Color.BLACK);
		ObservableList<Double> list = polygon.getPoints();

		double centerX = this.getWidth() / 2, centerY = this.getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// Add points to the polygon list
		for (int i = 0; i < minSides; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / minSides));
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / minSides));
		}

		getChildren().clear();
		minSides++; // This would increase the sides
		getChildren().add(polygon);
	}

	public void decrease() {
		// Let the polygon be with the least sides ie. 3 (triangle)
		if (minSides <= 2) {
		}

		else {
			// Create a polygon and place polygon to pane
			Polygon polygon = new Polygon();
			polygon.setFill(Color.WHITE);
			polygon.setStroke(Color.BLACK);
			ObservableList<Double> list = polygon.getPoints();

			double centerX = this.getWidth() / 2, centerY = this.getHeight() / 2;
			double radius = Math.min(getWidth(), getHeight()) * 0.4;

			// Add points to the polygon list
			for (int i = 0; i < minSides; i++) {
				list.add(centerX + radius
						* Math.cos(2 * i * Math.PI / minSides));
				list.add(centerY - radius
						* Math.sin(2 * i * Math.PI / minSides));
			}

			getChildren().clear();
			getChildren().add(polygon);
			minSides--; // This would decrease the sides

		}
	}

}
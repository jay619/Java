/*
 Shah Jaynish
 CSCI-211
 Rendering South Park's Butterscotch
 Assignment 9
 March 24th, 2015
 shahjaynish@gmail.com
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Butterscotch extends Application {
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(new layout(), 600, 400);
		primaryStage.setTitle("South Park's Butterscotch!!");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	class layout extends Pane {
		public layout() {

			// Generate the colors
			Color shorts = new Color(0.15, 0.41, 0.33, 1);
			Color skin = new Color(1.00, 0.88, 0.77, 1);
			Color shirt = new Color(0.36, 0.88, 0.78, 0.85);
			Color hair = new Color(1.00, 1.00, 0.00, 1);

			// Using arc to generate feet, smile, and arms
			Arc footL = new Arc(315, 315, 80, 80, 65, 50);
			footL.setFill(Color.BLACK);
			footL.setType(ArcType.CHORD);
			footL.setStroke(Color.BLACK);

			Arc footR = new Arc(250, 315, 80, 80, 65, 50);
			footR.setFill(Color.BLACK);
			footR.setType(ArcType.CHORD);
			footR.setStroke(Color.BLACK);

			Arc smile = new Arc(277, 100, 30, 30, 255, 35);
			smile.setType(ArcType.OPEN);
			smile.setFill(Color.WHITE);
			smile.setStroke(Color.BLACK);

			Arc armsL = new Arc(277, 192, 35, 35, 160, 30);
			armsL.setStroke(Color.BLACK);
			armsL.setType(ArcType.OPEN);
			armsL.setFill(Color.WHITE);

			Arc armsR = new Arc(277, 192, 35, 35, 350, 30);
			armsR.setStroke(Color.BLACK);
			armsR.setFill(Color.WHITE);
			armsR.setType(ArcType.OPEN);

			// Using circle to generate head, pupils, hands and thumbs
			Circle head = new Circle();
			head.setCenterX(278);
			head.setCenterY(100);
			head.setRadius(50);
			// head.setStroke(Color.BLACK);
			head.setFill(skin);

			Circle pupilR = new Circle();
			pupilR.setCenterX(265);
			pupilR.setCenterY(100);
			pupilR.setRadius(2);
			pupilR.setStroke(Color.BLACK);
			pupilR.setFill(Color.BLACK);

			Circle pupilL = new Circle();
			pupilL.setCenterX(290);
			pupilL.setCenterY(100);
			pupilL.setRadius(2);
			pupilL.setStroke(Color.BLACK);
			pupilL.setFill(Color.BLACK);

			Circle righthand = new Circle();
			righthand.setCenterX(232);
			righthand.setCenterY(205);
			righthand.setRadius(12);
			righthand.setFill(skin);

			Circle lefthand = new Circle();
			lefthand.setCenterX(321);
			lefthand.setCenterY(205);
			lefthand.setRadius(12);
			lefthand.setFill(skin);

			Circle thumbL = new Circle();
			thumbL.setCenterX(240);
			thumbL.setCenterY(202);
			thumbL.setRadius(6);
			thumbL.setFill(skin);
			thumbL.setStroke(Color.BLACK);

			Circle thumbR = new Circle();
			thumbR.setCenterX(313);
			thumbR.setCenterY(202);
			thumbR.setRadius(6);
			thumbR.setFill(skin);
			thumbR.setStroke(Color.BLACK);

			// Using ellipse to generate eyes and torso/shirt
			Ellipse eyeR = new Ellipse(265, 100, 15, 10);
			eyeR.setRotate(90 + 40);
			eyeR.setFill(Color.WHITE);

			Ellipse eyeL = new Ellipse(290, 100, 15, 10);
			eyeL.setRotate(50);
			eyeL.setFill(Color.WHITE);

			Ellipse torso = new Ellipse(277, 180, 62, 50);
			// torso.setStroke(Color.BLACK);
			torso.setFill(shirt);
			torso.setRotate(90);

			// Using line to generate eyebrows and shirt line
			Line eyebrow1 = new Line(294, 80, 308, 100);
			eyebrow1.setStrokeWidth(2);
			eyebrow1.setStroke(Color.BLACK);

			Line eyebrow2 = new Line(261, 80, 247, 100);
			eyebrow2.setStrokeWidth(2);
			eyebrow2.setStroke(Color.BLACK);

			Line shirtLine = new Line(277, 215, 277, 150);
			shirtLine.setStroke(Color.BLACK);
			shirtLine.setStrokeWidth(2.5);

			// Using rectangle to generate pants
			Rectangle pants = new Rectangle(235, 215, 84, 26);
			// pants.setStroke(Color.BLACK);
			pants.setFill(shorts);

			// Using polygon to generate hairs
			Polygon hairs = new Polygon(244, 38, 277, 48, 320, 38, 305, 52,
					340, 67, 310, 64, 324, 88, 280, 68, 246, 84, 252, 66, 216,
					63, 250, 52);
			hairs.setFill(hair);
			// hairs.setStroke(Color.BLACK);

			Group group = new Group();
			group.getChildren().addAll(torso, shirtLine, head, eyeR, eyeL,
					pupilR, pupilL, eyebrow1, eyebrow2, smile, pants, footL,
					footR, righthand, lefthand, armsL, armsR, hairs, thumbL,
					thumbR);
			this.getChildren().add(group);

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
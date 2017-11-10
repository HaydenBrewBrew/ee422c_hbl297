/*
 * EE 422C Spring 2017, Quiz 6
 * Name: Hayden Lydick
 * UT EID: hbl297
 * Unique: 
 */

/*
 * Other comments that will help the TA looking at your code.
 */
package quiz6_javafx;


/**
 * Starter code for Java FX program to increment and display a counter every time a button 
 * is pressed.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Counter_starter extends Application {
	
	//IT ALL WORKS ON MY COMPUTER

	public static void main(String[] args) {
		launch(args);
	}

	private static int counter = 0;
	
	@Override
	public void start(Stage primaryStage) {
		//create buttons
		primaryStage.setTitle("Counter");
		Button increm = new Button();
		increm.setLayoutX(100);
		increm.setLayoutY(100);
		increm.setText("Increment Counter");
		//create and initialize the text fields 
		TextField countView = new TextField(Integer.toString(counter));
		
		increm.setOnAction(new EventHandler<ActionEvent>() {//handles the press by incrementing the counter and updating the text field 
			@Override
			public void handle(ActionEvent event) {
				counter++;
				countView.setText(Integer.toString(counter));
			}
		});
		//sets the text field view
		countView.setLayoutX(70);
		countView.setLayoutY(150);
		//add all objects to the group and display
		Group root = new Group();
		root.getChildren().add(increm);
		root.getChildren().add(countView);
		primaryStage.setScene(new Scene(root,300, 250));
		primaryStage.show();
	}
}
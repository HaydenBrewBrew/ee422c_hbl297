package quiz6_javafx;

/*
 * EE 422C Spring 2017, Quiz 6
 * Name: Hayden Lydick
 * UT EID: hbl297
 * Unique: 
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application {

	
	//IT ALL WORKS!!
	
	
	@Override
	public void start(Stage primarystage) throws Exception {
		//set the title of the stage
		primarystage.setTitle("Hello World!");
		Button butt = new Button();//creates button
		butt.setText("Say 'Hello World'");//set text
		butt.setOnAction(new EventHandler<ActionEvent>() {//handle the event of being pressed
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		
		StackPane root = new StackPane();//create the stack pane for viewing 
		root.getChildren().add(butt);//add the button to stack pane
		primarystage.setScene(new Scene(root, 300, 250));//set the scene of the 
		primarystage.show();//display te stack pain
	}
	
	public static void main(String[] arg) {
		launch(arg);
	}
	
}

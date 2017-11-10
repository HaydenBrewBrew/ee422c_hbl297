package assignment5;


/*
 * EE 422C Spring 2017, Quiz 6_Extracredit
 * Name: Hayden Lydick
 * UT EID: hbl297
 * Unique: 
 */


import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import assignment5.Critter;
import assignment5.InvalidCritterException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


public class CritterMenu extends Application {

	private List<String> names;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("CritterMenu");
		String packageName = "assignment5";
		ComboBox<String> critSelect = new ComboBox<String>();
		critSelect.setPromptText("Select Critter");
		//handle the event of selection of critter
		critSelect.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					//make a new critter and display the world
					Critter.makeCritter(critSelect.getSelectionModel().getSelectedItem());
					Critter.displayWorld();
				} catch (InvalidCritterException e) {
					e.printStackTrace();
				}
			}
		});
        List<Class<Critter>> critters = new ArrayList<Class<Critter>>();
        URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));//gets package name
        // Filter .class files.
        File[] files = new File(root.getFile()).listFiles(new FilenameFilter() {//create list of files
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });

        // Find classes that are Critters
        for (File file : files) {
            String className = file.getName().replaceAll(".class$", "");
            Class<?> cls = null;
			try {
				cls = Class.forName(packageName + "." + className);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            if (Critter.class.isAssignableFrom(cls) && !(Modifier.isAbstract(cls.getModifiers()) ) && (cls.getSimpleName() != "TestCritter") ) {
                critters.add((Class<Critter>) cls);
            }
        }
        //makes list of names as strings
        names =new ArrayList<String>();
        for(Class<Critter> crit : critters) {//adds names to list
        		names.add(crit.getSimpleName());
        }
        
        //list of observables 
        ObservableList<String> oname = FXCollections.observableArrayList(names);
        //sets the items in the drop down
        critSelect.setItems(oname);
        //makes new group
        Group rootp = new Group();
        rootp.getChildren().add(critSelect);
        //display the results 
        primaryStage.setScene(new Scene(rootp, 300, 250));
        primaryStage.show();
		
	}
	
	public static void main(String[] arg) {
		launch(arg);
	}

}

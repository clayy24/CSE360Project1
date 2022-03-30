package application;
    
//import java.awt.Button;
//import java.awt.Label;
//import java.awt.TextField;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
<<<<<<< HEAD
	@Override
	public void start(Stage primaryStage) {
		try {
			//testing committ
			//testing again
			StackPane root = new StackPane();
			Scene scene = new Scene(root,400,400);
			Button button = new Button("Hello");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.getChildren().add(button);
			primaryStage.setScene(scene);
			primaryStage.setTitle("This is a title.");
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
=======
    private StackPane root = new StackPane();
    private Stage stage;
    @Override
    public void init() {
        try {
            //please work
            Button button = new Button("OPEN");
            VBox vBox = new VBox();
            
            vBox.setSpacing(8);
            vBox.setPadding(new Insets(10,10,10,10));
            vBox.getChildren().addAll(
                    new Label("Your Username"),
                    new TextField(),
                    new Label("Password"),
                    new PasswordField(),
                    new Button("LOGIN"));
            root.getChildren().addAll(vBox);
            
            button.setOnAction(actionEvent -> {
                if(stage!=null) {
                    stage.requestFocus();
                    return;
                }
                stage = new Stage();
                StackPane stackPane = new StackPane();
                stage.setScene(new Scene(stackPane, 200,200));
                stage.show();
            });
            
                    
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);;
        primaryStage.show();
        primaryStage.setTitle("Login Test");
        primaryStage.setAlwaysOnTop(true);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
>>>>>>> branch 'main' of https://github.com/clayy24/CSE360Project1

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//testing commit
			//hello
			// shit
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

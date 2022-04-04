package application;
    

import java.awt.event.ActionEvent;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Main extends Application {
	
	//scene1
	private Scene scene1;
	private VBox vBox1;
	private Button button1;
	private Button CreaAccButton1;
	
	//scene2
	private Scene scene2;
	private VBox vBox2;
	private Button button2;
	
	//scene3
	private Scene scene3;
	private VBox vBox3;
	private Button button3;
	
	//scene4
	private Scene scene4;
	private VBox vBox4;
	
    private Stage stage;
    

	@Override
    public void start(Stage primaryStage) {
		
		
		stage = primaryStage;
		stage.setTitle("Login screen that switches to create acoount");
		
		scene1 = createScene1();
		scene2 = createScene2();
		scene3 = createScene3();
		scene4 = createScene4();
		
		stage.setScene(scene1);
		
		stage.show();
		
        primaryStage.setScene(scene1);;
        primaryStage.show();
        primaryStage.setTitle("Login Test");
        primaryStage.setAlwaysOnTop(true);
		

        
    }
    //login screen
	private Scene createScene1() {
		
            //please work
        VBox vBox1 = new VBox();
            
        vBox1.setSpacing(8);
        vBox1.setPadding(new Insets(10,10,10,10));
        vBox1.setStyle("-fx-background-color: green");
            
        
        TextField UserName;
		PasswordField Password;
        scene1 = new Scene(vBox1, 400, 400);
        
		
		
        Label Intro;
		Intro = new Label("Welcome");
		Intro.setFont(new Font("Arial", 24));
		Intro.setMinWidth(50);
		Intro.setMinHeight(50);
		vBox1.getChildren().addAll(
				Intro,
        		new Label("Your Username"),
                UserName = new TextField(),
                new Label("Password"),
                Password = new PasswordField(),
                button1 = new Button("LOGIN"),
                CreaAccButton1 = new Button("Create a new Acccount?"));
		
            
    
			CreaAccButton1.setOnAction(event -> {
            
				switchScenes(scene2);
				
            		
			});	    
            
		       //label called status
			//login button
            button1.setOnAction(event -> {
                
            	switchScenes(scene3);
                //vBox1.getChildren().add(
                		//new Label("Yay"));
            });
            
                    
		
		return scene1;
	}
	//create account screen
    private Scene createScene2() {
    	VBox vBox2 = new VBox();
    	
    	vBox2.setSpacing(8);
        vBox2.setPadding(new Insets(10,10,10,10));
        vBox2.setStyle("-fx-background-color: grey");
        scene2 = new Scene(vBox2, 400, 400);
    	
        TextField NewUserName;
		PasswordField NewPassword;
		
		Label CIntro;
		CIntro = new Label("Let's make and account!");
		CIntro.setFont(new Font("Arial", 24));
		CIntro.setMinWidth(50);
		CIntro.setMinHeight(50);
		vBox2.getChildren().addAll(
				CIntro,
                new Label("Enter a Username"),
                NewUserName = new TextField(),
                new Label("Enter a Password"),
                NewPassword = new PasswordField(),
                button2 = new Button("Create account"));
			    
       
	       //label called status
        button2.setOnAction(event -> {
            
			switchScenes(scene1);
            vBox2.getChildren().add(
            		new Label("Yay"));
        });
        
        
		return scene2;
	}
    //home screen
    private Scene createScene3() {
    	VBox vBox3 = new VBox();
    	button3 = new Button("Menu");
    	
    	vBox3.setSpacing(8);
        vBox3.setPadding(new Insets(10,10,10,10));
        vBox3.setStyle("-fx-background-color: red");
        vBox3.getChildren().add(button3);
        scene3 = new Scene(vBox3, 400, 400);
        
        button3.setOnAction(event -> {
        	
        	switchScenes(scene4);
        });
        
    	return scene3;
    }

    private Scene createScene4()
    {
    	VBox vBox4 = new VBox();
    	
    	vBox4.setSpacing(8);
        vBox4.setPadding(new Insets(10,10,10,10));
        vBox4.setStyle("-fx-background-color: blue");
        vBox4.getChildren().add(new Label("item1"));
        
    	scene4 = new Scene(vBox4, 400, 400);
    	

    	
    	return scene4;
    }
    
	private void switchScenes(Scene scene) {
		stage.setScene(scene);
		
	}

	public static void main(String[] args) {
        Application.launch(args);
    }
}


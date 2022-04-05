package application;
    

import java.awt.List;
import java.awt.event.ActionEvent;

//import java.awt.Button;
//import java.awt.Label;
//import java.awt.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.event.ChangeListener;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	private Button menuButton;
	private Button cartButton;
	private Button addItems;
	
	//scene4
	private Scene scene4;
	private VBox vBox4;
	private Button goBack;
	
	//scene5 
	
    private Stage stage;
    private Scene scene5;
	private VBox vBox5;
	private Button add;
	
    Customer customer;
    

	@Override
    public void start(Stage primaryStage) {
		
		
		stage = primaryStage;
		stage.setTitle("Login screen that switches to create acoount");
		
		scene1 = createScene1();
		scene2 = createScene2();
		scene3 = createScene3();
		scene4 = createScene4();
		scene5 = createScene5();
		
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
                
            	if(checkAccount(UserName.getText(), Password.getText()))
            	{
            		System.out.println("Login successful");
            		switchScenes(scene3);
            	}
            	else
            	{
            		System.out.println("Login unsuccessful");
            	}
            	
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
            createAccount(NewUserName, NewPassword);
			switchScenes(scene1);
            vBox2.getChildren().add(
            		new Label("Yay"));
        });
        
        
		return scene2;
	}
    //home screen
    private Scene createScene3() {
    	//VBox vBox3 = new VBox();
    	HBox hBox3 = new HBox();
    	menuButton = new Button("Menu");
    	cartButton = new Button("Cart");
    	addItems = new Button("add Menu Items");
    	
    	hBox3.setSpacing(50);
        hBox3.setPadding(new Insets(10,10,10,10));
        hBox3.setStyle("-fx-background-color: red");
        hBox3.getChildren().addAll(menuButton, cartButton, addItems);
        //hBox3.getChildren().addAll(menuButton, cartButton);
        scene3 = new Scene(hBox3, 400, 400);
        
        menuButton.setOnAction(event -> {
        	
        	switchScenes(scene4);
        });
        
        addItems.setOnAction(event -> {
        	
        	switchScenes(scene5);
        });
        
    	return scene3;
    }

    private Scene createScene4()
    {
    	VBox vBox4 = new VBox();
    	GridPane gridpane = new GridPane();
    	goBack = new Button("Return");
    	Label label = new Label("test");
    	
    	/*
    	vBox4.setSpacing(8);
        vBox4.setPadding(new Insets(10,10,10,10));
        vBox4.setStyle("-fx-background-color: white");
        vBox4.getChildren().addAll(goBack, Displayed());
        */
    	
    	gridpane = Displayed();
    	gridpane.add(goBack, 0, 0);
        
    	
    	scene4 = new Scene(gridpane, 400, 400);
    	
    	goBack.setOnAction(event -> {
        	
        	switchScenes(scene3);
        });
    	
    	return scene4;
    }
    
    private GridPane Displayed() {
		
    	String itemName;
    	String itemPrice;
    	String allItems = "";
    	GridPane gridpane = new GridPane();
    	
    	File menu = new File("menu.txt");
    	int lines = 0;
    	

        try (Scanner scanner = new Scanner(menu)) {
            while (scanner.hasNextLine()) 
            {
            	scanner.nextLine();
            	lines++;
            }
        	scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
        System.out.println(lines);
        
    	try {
			Scanner scanner = new Scanner(menu);
			
			for(int i = 0; i < lines/3; i++)
			{

				String line1 = scanner.nextLine();
				String line2 = scanner.nextLine();
				String line3 = scanner.nextLine();
				
				allItems = line1 + " " + " $" +line2 + "\n";
				Label Item = returnLabel(allItems);
				
				FileInputStream inputStream = new FileInputStream(line3);
				Image image = new Image(inputStream);
				
				
				gridpane.add(Item, 0, i+1, 1, 1);
				gridpane.add(new ImageView(image), 1, i+1, 1, 1);
			}
			
			scanner.close();
			
			return gridpane;
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	
    	

	}
	private Label returnLabel(String items) {
		
		
		Label Item = new Label(items);
		return Item;
	}
	private Scene createScene5() {
    	VBox vBox5 = new VBox();
    	
    	vBox5.setSpacing(8);
        vBox5.setPadding(new Insets(10,10,10,10));
        vBox5.setStyle("-fx-background-color: grey");
        scene5 = new Scene(vBox5, 400, 400);
    	
        TextField NewMenuItem;
		TextField NewItemPrice;
		TextField newImagePath;
		String NumPrice;
		
		
		Label CIntro;
		CIntro = new Label("Add items to menu");
		CIntro.setFont(new Font("Arial", 24));
		CIntro.setMinWidth(50);
		CIntro.setMinHeight(50);
		vBox5.getChildren().addAll(
				CIntro,
                new Label("Enter item name"),
                NewMenuItem = new TextField(),
                new Label("Enter item price(number)"),
                NewItemPrice = new TextField(),
                new Label("Enter image path"),
                newImagePath = new TextField(),
                add = new Button("Add this item"));
			    
       
		NumPrice = NewItemPrice.getText();
	       //label called status
        add.setOnAction(event -> {
        	
        	/*
    		try{
    		    double d= Double.valueOf(NumPrice);
    		    if (d==(int)d){
    		        System.out.println("integer"+(int)d);
    		        createMenuItem(NewMenuItem, NewItemPrice);
    				switchScenes(scene3);
    		    }else{
    		        System.out.println("double"+d);
    		        createMenuItem(NewMenuItem, NewItemPrice);
    				switchScenes(scene3);
    		    }
    		}catch(Exception e){
    		    System.out.println("not number");
    		}
    		*/
        	
        		createMenuItem(NewMenuItem, NewItemPrice, newImagePath);
				switchScenes(scene3);
        	
            vBox5.getChildren().add(
            		new Label("not number"));
        });
        
        
		return scene5;
	}
    
    private void createMenuItem(TextField newMenuItem, TextField newItemPrice, TextField newImagePath) {
    	File menu = new File("menu.txt");
    	FileWriter writer = null;
		try {
			writer = new FileWriter(menu, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	String Item = newMenuItem.getText();
    	String Price = newItemPrice.getText();
    	String imagepath = newImagePath.getText();
    	
    	customer = new Customer(Item, Price);
    	
    	try {
			writer.append("item: " + Item + "\n");
			writer.append("price: " + Price + "\n");
			writer.append(imagepath + "\n");
			writer.close();
			System.out.println("successfully wrote to file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	System.out.println("item: " + Item);
    	System.out.println("price: " + Price);
		
	}
    
    private void clearMenu()
    {
    	File menu = new File("menu.txt");
    	
    	try {
			FileWriter writer = new FileWriter(menu);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	private void createAccount(TextField NewUserName, PasswordField NewPassword)
    {
    	File accounts = new File("accounts.txt");
    	FileWriter writer = null;
		try {
			writer = new FileWriter(accounts, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	String username = NewUserName.getText();
    	String password = NewPassword.getText();
    	
    	customer = new Customer(username, password);
    	
    	try {
			writer.append("username: " + username + "\n");
			writer.append("password: " + password + "\n");			
			writer.close();
			System.out.println("successfully wrote to file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	System.out.println("Username: " + username);
    	System.out.println("Password: " + password);
    }
    
    private void clearAccounts()
    {
    	File accounts = new File("accounts.txt");
    	
    	try {
			FileWriter writer = new FileWriter(accounts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private boolean checkAccount(String username, String password)
    {
    	
    	String accountUsername = "username: " + username;
    	String accountPassword = "password: " + password;
    	boolean accountExists = false;
    	boolean loginSuccessful = false;
    	
    	File accounts = new File("accounts.txt");
    	
    	try {
			Scanner scanner = new Scanner(accounts);
			
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if(line.equals(accountUsername))
				{
					System.out.println("account exists.");
					accountExists = true;
					line = scanner.nextLine();
					if(line.equals(accountPassword))
					{
						System.out.println("login successful");
						loginSuccessful = true;
					}
					else
					{
						System.out.println("Incorrect password");
					}
				}
			}
			
			if(accountExists && loginSuccessful)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return false;
    }
    
	private void switchScenes(Scene scene) {
		stage.setScene(scene);
		
	}

	public static void main(String[] args) {
        Application.launch(args);
    }
}

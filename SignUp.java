package login_application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUp extends Application {
	
	FilesHandler filesHandler = new FilesHandler();
	
	public SignUp() throws Exception {
		start(new Stage());
	}
	
	// Buttons
	Button signUp = new Button("Sign Up");
	HBox hbSignUp = new HBox(10); 
	
	// Text && Fields
	Text welcome = new Text("Welcome");
	Text actionTarget = new Text();
	TextField nameInput = new TextField();
	PasswordField passwordInput = new PasswordField();
	
	// Labels
	Label userName = new Label("User Name:");
	Label password = new Label("Password:");
	
	// Grid
	GridPane pane = new GridPane();
	
	// Scene
	Scene scene = new Scene(pane,400, 350);
	
	// File Handling
	File file = new File("C:\\Users\\ks255\\eclipse-workspace-java\\Graphical User Interface Projects\\src\\login_application\\SignUpInformation.txt");
	FileWriter writer = new FileWriter(file, true);
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		 * stage.setTitle("Sign Up"); stage.setScene(signUpScene); stage.show();
		 */
		
		primaryStage.setTitle("Sign Up");
		
		// add to stage
		pane.add(welcome, 0, 0, 2, 1);
		pane.add(userName, 0, 1);
		pane.add(nameInput, 1, 1);
		pane.add(password, 0, 2);
		pane.add(passwordInput, 1, 2);
		pane.add(hbSignUp, 1, 4);
		pane.add(actionTarget, 1, 5);
		
		
		// style pane
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(5);
		pane.setHgap(5);
		pane.setPadding(new Insets(25,25,25,25));
		
		// style Text
		welcome.setFont(Font.font ("Verdana", 20));
		
		// Style Buttons
		hbSignUp.setAlignment(Pos.BOTTOM_RIGHT);
		hbSignUp.getChildren().add(signUp);
	
		
		// Event Handlers
		signUp.setOnAction(new EventHandler<ActionEvent>() {
					
			public void handle(ActionEvent e) {
				actionTarget.setFill(Color.RED);
				actionTarget.setText("Thank you for signing up!");
				try {
					if(!nameInput.getText().equals("")) {
						writer.write(nameInput.getText());
						writer.write("\\" + passwordInput.getText()+"\n");
						//filesHandler.addUsers(nameInput.getText(), passwordInput.getText());
						//filesHandler.print();
					}
					writer.close();
					new Login().openLogin();
					primaryStage.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
		// Last of stage
		primaryStage.setScene(scene);
				
		primaryStage.show();
		
	}
	

}

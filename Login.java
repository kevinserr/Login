package login_application;

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

public class Login extends Application {
	
	public Login() {
		
	}
	
	public void openLogin () throws Exception {
		start(new Stage());
	}
	
	// new text field with the text "Welcome"
	Text welcome = new Text("Welcome");
	
	Label userName = new Label("User Name:");
	Label password = new Label("Password:");
	TextField nameInput = new TextField();
	PasswordField passwordInput = new PasswordField();
	
	
	
	// defines new GridPane
	GridPane pane = new GridPane();
	
	// new scene with the grid, height, width as parameters
	
	
	
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Names the primary stage "Login"
		primaryStage.setTitle("Login");
		Scene scene = new Scene(pane,350, 275);
		
		// Sets the alignment of the grid pane
		pane.setAlignment(Pos.CENTER);
		
		Button signIn = new Button("Sign In");
		HBox hbSignIn = new HBox(10);
		
		hbSignIn.setAlignment(Pos.BOTTOM_RIGHT);
		hbSignIn.getChildren().add(signIn);
		Button signUp = new Button("Sign Up");
		
		
		
		// sets the vertical gap between the columns
		pane.setVgap(5);
		
		// sets the horizontal gaps between the rows
		pane.setHgap(5);
		
		// sets the padding of the grid
		pane.setPadding(new Insets(25,25,25,25));
		
		welcome.setFont(Font.font ("Verdana", 20));
		
		pane.add(welcome, 0, 0, 2, 1);
		pane.add(userName, 0, 1);
		pane.add(nameInput, 1, 1);
		pane.add(password, 0, 2);
		pane.add(passwordInput, 1, 2);
		pane.add(hbSignIn, 1, 4);
		pane.add(signUp, 1, 4);
		
		final Text actionTarget = new Text();
		pane.add(actionTarget,1,6);
		
		// add event handler
		signIn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				actionTarget.setFill(Color.RED);
				actionTarget.setText("Sign in button pressed");
				
			}
		});
		
		signUp.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				try {
					SignUp sg = new SignUp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				primaryStage.close();
			}
		});
		
		
		// sets the scene, scene, height, width
		primaryStage.setScene(scene);
		
		primaryStage.show();

		
	}

}

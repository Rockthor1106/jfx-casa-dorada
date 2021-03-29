package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import model.CasaDorada;

public class CasaDoradaGUI {

	@FXML
	private TextField strUsername;

	@FXML
	private PasswordField strPassword;

	@FXML
	private Label msg;

	@FXML
    private TextField registerName;

    @FXML
    private TextField registerLast_name;

    @FXML
    private TextField registerId;

    @FXML
    private TextField registerUsername;
    
    @FXML
    private TextField registerPassword;
    
    @FXML
    private BorderPane mainPane;

    @FXML
    void logIn(ActionEvent event) {

    }

    @FXML
    void logInScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent loginScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(loginScreen);
    }

    @FXML
    void registerScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent registerScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(registerScreen);
    }

    @FXML
    void showAbout(ActionEvent event) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Casa Dorada");
	    alert.setHeaderText("Creditos:");
	    alert.setContentText("Jhan Carlos Carvajal Bastidas");
	    alert.showAndWait();
    }
    
    private CasaDorada casaDorada;

	public CasaDoradaGUI(CasaDorada casaDorada) {
		this.casaDorada = casaDorada;
	}

	@FXML
	void LogIn(ActionEvent event) {
		System.out.println(new CasaDorada().getEmployees().get(0).getUsername());
		boolean username_exists = new CasaDorada().getEmployees().get(0).getUsername().equals(strUsername.getText());
		boolean password_exists = new CasaDorada().getEmployees().get(0).getPassword().equals(strPassword.getText());
		if (username_exists == true && password_exists == true) {
			msg.setText("BIENIDOOOOOOO");
		} else {
			msg.setText("ERROOOOOR");
		}
	}

	@FXML
	void createAccount(ActionEvent event) throws IOException {
		String name = registerName.getText();
		String last_name = registerLast_name.getText();
		int id = Integer.parseInt(registerId.getText());
		String username = registerUsername.getText();
		String password = registerPassword.getText();
		new CasaDorada().addEmployee(name,last_name,id,username,password);
		System.out.println(casaDorada.getEmployees().get(0).getName());
	}
	
}

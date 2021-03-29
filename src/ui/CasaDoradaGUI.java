package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
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
    private Menu menu;
    
    private CasaDorada casaDorada;

	public CasaDoradaGUI(CasaDorada casaDorada) {
		this.casaDorada = casaDorada;
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
    
	@FXML
	void LogIn(ActionEvent event) throws IOException {
		boolean logged = false;
		boolean username_exists = false;
		boolean password_exists = false;
		for(int i = 0; i < casaDorada.getEmployees().size(); i++) {
			if (casaDorada.getEmployees().get(i).getUsername().equals(strUsername.getText()) == true) {
				if (password_exists = casaDorada.getEmployees().get(i).getPassword().equals(strPassword.getText())) {
					username_exists = true;
					password_exists = true;
				}
			}

		}
		if (username_exists == true && password_exists == true) {
			msg.setText("Bienidooooo");
			logged = true;
			loggedOptions(logged);
		}
		else {
			msg.setText("Errooor");
		}
	}

	@FXML
	void createAccount(ActionEvent event) throws IOException {
		
		String name = registerName.getText();
		String last_name = registerLast_name.getText();
		String id_number = registerId.getText();
		String username = registerUsername.getText();
		String password = registerPassword.getText();

		//debo agregar la validaci�n para ver si el usuario ya existe en le sistema
		
		if(registerName.getText().equals("")&&registerLast_name.getText().equals("")&&registerId.getText().equals("")&&registerUsername.getText().equals("")&&registerPassword.getText().equals("")) {
			emptyField("Todos los campos est�n vacios, por favor llenelos con la informaci�n solicitada");
		}
		else if (registerName.getText().equals("")) {
			emptyField("Por favor ingrese un nombre");
		}
		else if (registerLast_name.getText().equals("")) {
			emptyField("Por favor ingrese un apellido");
		}
		else if (registerId.getText().equals("")) {
			emptyField("Por favor ingrese un numero de identificaci�n");
		}
		else if (registerUsername.getText().equals("")) {
			emptyField("Por favor ingrese un nombre de usuario");
		}
		else if (registerPassword.getText().equals("")) {
			emptyField("Por favor ingrese una contrase�a");
		}
		else {
			casaDorada.addEmployee(name, last_name, id_number, username, password);
			accountCreatedSuccessfully();
		}
	}
	
    @FXML
    public void accountCreatedSuccessfully() {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Creaci�n de cuenta");
	    alert.setHeaderText(":D");
	    alert.setContentText("Cuenta creada con �xito");
	
	    alert.showAndWait();
    }
    
    @FXML
    public void emptyField(String msg) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Creaci�n de cuenta");
	    alert.setHeaderText(":(");
	    alert.setContentText(msg);
	
	    alert.showAndWait();
    }
    
    public void loggedOptions(boolean logged) throws IOException {
    	if (logged == true) {
    		menu.getItems().get(2).setVisible(true); //makes the option "a�adir producto" visible
    		menu.getItems().get(3).setVisible(true); //makes the option "cerrar sesi�n" visible
		}
    }
    
    @FXML
    void addProduct(ActionEvent event) {

    }

}

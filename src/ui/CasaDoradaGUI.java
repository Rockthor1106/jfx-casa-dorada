package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import model.CasaDorada;

public class CasaDoradaGUI {

	@FXML
	private TextField strUsername;

	@FXML
	private PasswordField strPassword;

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
    
    @FXML
    private TextField registerNameProduct;

    @FXML
    private TextField registerIngredients;

    @FXML
    private TextField registerPrice;

    @FXML
    private ToggleGroup size;

    @FXML
    private ComboBox<?> registerType;

    @FXML
    private RadioButton mediano;

    @FXML
    private RadioButton familiar;

    @FXML
    private RadioButton personal;
    
    @FXML
    private ImageView image;
    
    private CasaDorada casaDorada;

	public CasaDoradaGUI(CasaDorada casaDorada) {
		this.casaDorada = casaDorada;
	}
	
	// Alerts
	@FXML
    public void logInAlert(String msg, AlertType alertType) {
	    Alert alert = new Alert(alertType);
	    alert.setTitle("Iniciar sesión");
	    alert.setHeaderText(":D");
	    alert.setContentText(msg);
	    alert.show();
    }
    @FXML
    public void accountCreatedSuccessfully() {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Crear cuenta");
	    alert.setHeaderText(":D");
	    alert.setContentText("Cuenta creada con éxito");
	
	    alert.showAndWait();
    }
    @FXML
    public void emptyField(String msg, AlertType alertType) {
	    Alert alert = new Alert(alertType);
	    alert.setTitle("Creación de cuenta");
	    alert.setHeaderText(":(");
	    alert.setContentText(msg);
	
	    alert.showAndWait();
    }
    
    @FXML
    void showAbout(ActionEvent event) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Casa Dorada");
	    alert.setHeaderText("Creditos:");
	    alert.setContentText("Jhan Carlos Carvajal Bastidas");
	    alert.showAndWait();
    }
    
	// Methods

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
			logged = true;
			showLoggedOptions(logged);
			logInAlert("Inicio de sesión exitoso", AlertType.INFORMATION);
		}
		else {
			logInAlert("Nombre de usuario o contraseña incorrectos", AlertType.ERROR);
		}
	}

	@FXML
	void createAccount(ActionEvent event) throws IOException {
		
		String name = registerName.getText();
		String last_name = registerLast_name.getText();
		String id_number = registerId.getText();
		String username = registerUsername.getText();
		String password = registerPassword.getText();
		
		if(registerName.getText().equals("")&&registerLast_name.getText().equals("")&&registerId.getText().equals("")&&registerUsername.getText().equals("")&&registerPassword.getText().equals("")) {
			emptyField("Todos los campos están vacios, por favor llenelos con la información solicitada", AlertType.WARNING);
		}
		else if (registerName.getText().equals("")) {
			emptyField("Por favor ingrese un nombre", AlertType.WARNING);
		}
		else if (registerLast_name.getText().equals("")) {
			emptyField("Por favor ingrese un apellido", AlertType.WARNING);
		}
		else if (registerId.getText().equals("")) {
			emptyField("Por favor ingrese un numero de identificación", AlertType.WARNING);
		}
		else if (registerUsername.getText().equals("")) {
			emptyField("Por favor ingrese un nombre de usuario", AlertType.WARNING);
		}
		else if (registerPassword.getText().equals("")) {
			emptyField("Por favor ingrese una contraseña", AlertType.WARNING);
		}
		else {
			casaDorada.addEmployee(name, last_name, id_number, username, password);
			accountCreatedSuccessfully();
		}
	}
	
    public void showLoggedOptions(boolean logged) throws IOException {
    	if (logged == true) {
    		menu.getItems().get(1).setVisible(false); //makes the option "iniciar sesion" invisible
    		menu.getItems().get(2).setVisible(true); //makes the option "añadir producto" visible
    		menu.getItems().get(3).setVisible(true); //makes the option "cerrar sesión" visible
		}
    }
    
    @FXML
    void singOut(ActionEvent event) {
    	menu.getItems().get(1).setVisible(true); //makes the option "iniciar sesion" visible
    	menu.getItems().get(2).setVisible(false); //makes the option "añadir producto" invisible
		menu.getItems().get(3).setVisible(false); //makes the option "cerrar sesión" invisible
    }
    
    @FXML
    void addProductScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-product.fxml"));
		fxmlLoader.setController(this);    	
		Parent addProductScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(addProductScreen);
    	
    }
    @FXML
    void addProduct(ActionEvent event) {
    	String name_product = registerNameProduct.getText();
    	String ingredients = registerIngredients.getText();
    	String size = "";
    	if (personal.isSelected() == true) {
			size = "Personal";
		}
    	else if (mediano.isSelected() == true) {
    		size = "Mediano";
		}
    	else if (familiar.isSelected() == true) {
    		size = "Familiar";
			
		}
    	
    	double price = Double.parseDouble(registerPrice.getText());
    	casaDorada.addProduct(name_product, ingredients, size, price);
    }
    
    @FXML
    void searchImage(ActionEvent event) {
   
    }

}

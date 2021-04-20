package ui;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import model.CasaDorada;
import model.Client;
import model.Employee;
import model.IngredientAvailability;
import model.Ingredients;
import model.Order;
import model.Product;

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
    private ComboBox<String> registerType;

    @FXML
    private RadioButton mediano;

    @FXML
    private RadioButton familiar;

    @FXML
    private RadioButton personal;
    
    @FXML
    private ImageView image;
    
    @FXML
    private TextField name_searched;
    
    @FXML
    private TableView<Client> tvClientList;

    @FXML
    private TableColumn<Client, String> tcName;

    @FXML
    private TableColumn<Client, String> tcLastName;

    @FXML
    private TableColumn<Client, String> tcID;
    
    @FXML
    private TableColumn<Client, String> tcAddres;

    @FXML
    private TableColumn<Client, String> tcPhone;
    
    @FXML
    private TableColumn<Client, String> tcComments;
    
    @FXML
    private TextField regNameClient;

    @FXML
    private TextField regLastNameClient;

    @FXML
    private TextField regIdClient;
    
    @FXML
    private TextField regPhoneClient;
    
    @FXML
    private TextField regAddres;
    
    @FXML
    private TextField regComments;
    
    @FXML
    private Menu time;

    @FXML
    private TextField foundName;

    @FXML
    private TextField foundIDNumber;

    @FXML
    private TextField foundPhone;

    @FXML
    private TextField foundAddres;

    @FXML
    private TextField foundComments;

    @FXML
    private TextField foundLastName;

    @FXML
    private Label nanoseconds;
    
    @FXML
    private TableView<Product> tvProductsList;

    @FXML
    private TableColumn<Product, String> tcNameProduct;

    @FXML
    private TableColumn<Product, String> tcTypeProduct;

    @FXML
    private TableColumn<Product, String> tcIngredientsProduct;

    @FXML
    private TableColumn<Product, String> tcSizeProduct;

    @FXML
    private TableColumn<Product, Double> tcPriceProduct;
    
    @FXML
    private TableView<Order> tvOrdersList;

    @FXML
    private TableColumn<Order, String> tcOrderCode;

    @FXML
    private TableColumn<Order, Integer> tcOrderState;

    @FXML
    private TableColumn<Order, String> tcOrderProducts;

    @FXML
    private TableColumn<Order, Integer> tcAmount;

    @FXML
    private TableColumn<Order, String> tcOrderClient;

    @FXML
    private TableColumn<Order, String> tcOrderDeliver;

    @FXML
    private TableColumn<Order, String> tcOrderDate;

    @FXML
    private TableColumn<Order, String> tcOrderComments;
    
    @FXML
    private Label code;

    @FXML
    private TableView<Employee> tvEmployeesList;

    @FXML
    private TableColumn<Employee, String> tcEmployeeName;

    @FXML
    private TableColumn<Employee, String> tcEmployeeLastName;

    @FXML
    private TableColumn<Employee, String> tcEmployeeId;
    
    @FXML
    private TextField employeeNameFound;

    @FXML
    private TextField employeeLastNameFound;

    @FXML
    private TextField employeeIdFound;
    
    @FXML
    private TextField employee_searched;
    
    @FXML
    private Label nanoseconds_employee;
    
    @FXML
    private TableView<Order> tvOrderProducts;

    @FXML
    private TableColumn<Order, String> tcOrderProduct;

    @FXML
    private TableColumn<Order, Integer> tcOrderAmountProduct;

    @FXML
    private TableColumn<Order, String> tcOrderSizeProduct;

    @FXML
    private TableColumn<Order, Double> tcOrderPriceProduct;
    
    @FXML
    private Label total;
    
    @FXML
    private Button deleteClientButton;

    @FXML
    private Button updateClientButton;

    @FXML
    private TextField productToAdd;
    

    @FXML
    private TextField ingredientName;

    @FXML
    private ComboBox<String> availability;
    
    @FXML
    private TableView<Ingredients> tvIngredients;

    @FXML
    private TableColumn<Ingredients, String> tcIngredientsName;

    @FXML
    private TableColumn<Ingredients, String> tcAvailability;
    
    Calendar calendar;
     
    private CasaDorada casaDorada;

	public CasaDoradaGUI(CasaDorada casaDorada) {
		this.casaDorada = casaDorada;
	}
	
    @FXML
    public void initialize() {
    	
    	updateClock();
    	runClock();
    	casaDorada.bubbleSort(casaDorada.getProducts());
    	casaDorada.selectionSort(casaDorada.getEmployees());
    	casaDorada.sortIngredientsByName(casaDorada.getIngredients());
    }
	
	
	//Bonus - clock -------------------------------------------------------------------------------------------
    public void updateClock() {
    	calendar = Calendar.getInstance(); //this line brings the system time
    	int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    	String amPM = calendar.get(Calendar.AM_PM) == Calendar.AM?"AM":"PM";
    	if (amPM.equals("PM")) {
			if (hourOfDay != 12) {
				hourOfDay = hourOfDay -12;
			}
		}
    	
        if (calendar.get(Calendar.MINUTE) < 10 && calendar.get(Calendar.SECOND) < 10) {
            time.setText(String.valueOf(hourOfDay + ":0" + calendar.get(Calendar.MINUTE) + ":0" + calendar.get(Calendar.SECOND)) + " " + amPM);
        } 
        else if (calendar.get(Calendar.MINUTE) < 10) {
            time.setText(String.valueOf(hourOfDay + ":0" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND)) + " " + amPM);
        } 
        else if (calendar.get(Calendar.SECOND) < 10) {
            time.setText(String.valueOf(hourOfDay + ":" + calendar.get(Calendar.MINUTE) + ":0" + calendar.get(Calendar.SECOND)) + " " + amPM);
        } 
        else {
            time.setText(String.valueOf(hourOfDay + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND)) + " " + amPM);
        }

    }
    public void runClock() {
    	Timeline mainTimeline = new Timeline();
    	Timeline secundaryTimeline = new Timeline();
    	secundaryTimeline.setCycleCount(Timeline.INDEFINITE);//cycle infinite in this secondary time line
    	
    	KeyFrame mainKeyFrame = new KeyFrame(new Duration(1000 - calendar.get(Calendar.MILLISECOND) % 1000),
    			(event) -> { //Lan nomenclature
    				updateClock();
    				secundaryTimeline.play();	
    			}
    	);
    	
    	KeyFrame secundaryKeyFrame = new KeyFrame(Duration.seconds(1), 
    			(event) -> { 
    				updateClock();
    			}
    	);
    	
    	mainTimeline.getKeyFrames().add(mainKeyFrame);
    	secundaryTimeline.getKeyFrames().add(secundaryKeyFrame);
    	
    	mainTimeline.play();
    	
    }
	
	// Alerts -------------------------------------------------------------------------------------------
	@FXML
    public void logInAlert(String msg, AlertType alertType, String headerText) {
	    Alert alert = new Alert(alertType);
	    alert.setTitle("Iniciar sesión");
	    alert.setHeaderText(headerText);
	    alert.setContentText(msg);
	    alert.show();
    }
	
    @FXML
    public void accountCreatedSuccessfully() {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Crear cuenta");
	    alert.setHeaderText("");
	    alert.setContentText("Cuenta creada con éxito");
	
	    alert.showAndWait();
    }
    
    @FXML
    public void clientRegisteredSuccessfully() {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Registrar cliente");
	    alert.setHeaderText("");
	    alert.setContentText("Cliente registrado exitosamente");
	
	    alert.showAndWait();
    }
    
    @FXML
    public void emptyField(String msg, AlertType alertType) {
	    Alert alert = new Alert(alertType);
	    alert.setTitle("Creación de cuenta");
	    alert.setHeaderText("Falta información");
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
    
	@FXML
    public void clientNotFound() {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Buscar cliente");
	    alert.setHeaderText(":C");
	    alert.setContentText("No hay coincidencias con el nombre y apellido ingresado");
	    alert.show();
    }
	
	@FXML
    public void ClientDeleted() {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Eliminar cliente");
	    alert.setHeaderText(":D");
	    alert.setContentText("Cliente eliminado");
	    alert.show();
    }
	
	@FXML
    public void productAdded() {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Añadir producto");
	    alert.setHeaderText(":D");
	    alert.setContentText("Producto añadido");
	    alert.show();
    }
	
	@FXML
    public void employeeNotFound() {
	    Alert alert = new Alert(AlertType.ERROR);
	    alert.setTitle("Buscar empleado");
	    alert.setHeaderText(":C");
	    alert.setContentText("No hay coincidencias con el nombre y apellido ingresado");
	    alert.show();
    }
	
	@FXML
    public void ingredientAdded() {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Agregar ingrediente");
	    alert.setHeaderText(":D");
	    alert.setContentText("Ingrediente agregado correctamente");
	    alert.show();
    }
    
	// methods to show every screen -------------------------------------------------------------------------------------------

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
    void addProductScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-product.fxml"));
		fxmlLoader.setController(this);    	
		Parent addProductScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(addProductScreen);
    	initializeComboBoxTypeProduct();
    	
    }
    
    @FXML
    void searchClientScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search-client.fxml"));
		fxmlLoader.setController(this);    	
		Parent searchClientScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(searchClientScreen);
    	
    	
    }
    
    @FXML
    void addClientScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register-client.fxml"));
		fxmlLoader.setController(this);    	
		Parent addClientScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(addClientScreen);
    	
    }
    
    @FXML
    void showClientsListScreen(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clients-list.fxml"));
		fxmlLoader.setController(this);    	
		Parent clientsListScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(clientsListScreen);
    	initializeTableViewOfClients();
    }
    
    @FXML
    void showProductsListScreen(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("products-list.fxml"));
		fxmlLoader.setController(this);    	
		Parent productsListScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(productsListScreen);
    	initializeTableViewOfProducts();
    	
    }
    
    @FXML
    void showOrdersList(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("orders-list.fxml"));
		fxmlLoader.setController(this);    	
		Parent ordersListScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(ordersListScreen);
    	initializeTableViewOfOrders();
    	
    }
    
    @FXML
    void showRegisterOrderScreen(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-order.fxml"));
		fxmlLoader.setController(this);    	
		Parent addOrdersScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(addOrdersScreen);
    	initializeTableViewOfProducts();
    	
    }
    
    
    @FXML
    void showEmployeesListScreen(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees-list.fxml"));
		fxmlLoader.setController(this);    	
		Parent employeesScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(employeesScreen);
    	initializeTableViewOfEmployees();
    	
    }
    
    @FXML
    void showAddIngredientScreen(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-ingredient.fxml"));
		fxmlLoader.setController(this);    	
		Parent addIngredientScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(addIngredientScreen);
    	initializeComboBoxIngredientAvailability();
    }
    
    
    @FXML
    void showIngredientsListScreen(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ingredients-list.fxml"));
		fxmlLoader.setController(this);    	
		Parent ingredientsListScreen = fxmlLoader.load();
    	
		mainPane.getChildren().clear();
    	mainPane.setTop(ingredientsListScreen);
    	initializeTableViewOfIngredients();
    	
    }
    
    //methods to add -------------------------------------------------------------------------------------------
    
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
	
    @FXML
    void addProduct(ActionEvent event) throws IOException {
    	String name_product = registerNameProduct.getText();
    	String ingredients = registerIngredients.getText();
    	String type = registerType.getSelectionModel().getSelectedItem();
    	String strsize = " ";
    	double price = Double.parseDouble(registerPrice.getText());
    	if (personal.isSelected()) {
			strsize = "Personal";
		}
    	else if (mediano.isSelected()) {
    		strsize = "Mediano";
		}
    	else if (familiar.isSelected()) {
    		strsize = "Familiar";
			
		}
    
    	if (name_product.equals(" ") && ingredients.equals(" ") && type.equals(" ") && strsize.equals(" ") && registerPrice.getText().equals(" ")) {
    		emptyField("Todos los campos están vacios, por favor llenelos con la información solicitada", AlertType.WARNING);
		}
    	else if (name_product.equals(" ")) {
    		emptyField("Por favor ingrese un nombre para el producto", AlertType.WARNING);
		}
    	else if (ingredients.equals(" ")) {
    		emptyField("Por favor ingrese almenos un ingrediente para el producto", AlertType.WARNING);
		}
    	else if (type.equals(" ")) {
    		emptyField("Por favor seleccione un tipo para el producto", AlertType.WARNING);
		}
    	else if (strsize.equals(" ")) {
    		emptyField("Por favor seleccione un tamaño para el producto", AlertType.WARNING);
		}
    	else if (registerPrice.getText().equals(" ")) {
    		emptyField("Por favor ingrese un precio para el producto", AlertType.WARNING);
		}
    	else {
    		casaDorada.addProduct(name_product, ingredients, type, strsize,price);
    		productAdded();
		}	 
    	
    }
    
    @FXML
	void registerClient(ActionEvent event) throws IOException {
 	
		String registerNameClient = regNameClient.getText();
		String registerLastNameClient = regLastNameClient.getText();
		String registerIdClient = regIdClient.getText();
		String registerPhoneClient = regPhoneClient.getText();
		String registerAddresClient = regAddres.getText();
		String registerCommentClient = regComments.getText();
		
		if(regNameClient.getText().equals("") && regLastNameClient.getText().equals("") && regIdClient.getText().equals("") 
			&& regPhoneClient.getText().equals(" ") && regAddres.getText().equals(" ") && regComments.getText().equals(" ")) {
			
			emptyField("Todos los campos están vacios, por favor llenelos con la información solicitada", AlertType.WARNING);
		}
		else if (regNameClient.getText().equals("")) {
			emptyField("Por favor ingrese un nombre", AlertType.WARNING);
		}
		else if (regLastNameClient.getText().equals("")) {
			emptyField("Por favor ingrese un apellido", AlertType.WARNING);
		}
		else if (regIdClient.getText().equals("")) {
			emptyField("Por favor ingrese un numero de identificación", AlertType.WARNING);
		}
		else {
			casaDorada.addClient(registerNameClient, registerLastNameClient, registerIdClient, registerPhoneClient, registerAddresClient, registerCommentClient);
			clientRegisteredSuccessfully();
		}
	}
    
    @FXML
    void addOrder(ActionEvent event) throws FileNotFoundException {

    	if (foundLastName.getText().equals(" ") && foundIDNumber.getText().equals(" ") && foundPhone.getText().equals(" ") && foundAddres.getText().equals(" ")
    			&& employeeNameFound.getText().equals(" ") && employeeIdFound.getText().equals(" ")) {
    		emptyField("Todos los campos están vacios, por favor llenelos con la información solicitada", AlertType.WARNING);	
		}
    	else if (foundName.getText().equals(" ")) {
			emptyField("Ingrese el nombre del cliente", AlertType.WARNING);
		}
    	else if (foundLastName.getText().equals(" ")) {
    		emptyField("Ingrese el apellido del cliente", AlertType.WARNING);
		}
    	else if (foundIDNumber.getText().equals(" ")) {
    		emptyField("Ingrese la identificación del cliente", AlertType.WARNING);
		}
    	else if (foundPhone.getText().equals(" ")) {
    		emptyField("Ingrese el teléfono del cliente", AlertType.WARNING);
		}
    	else if (foundAddres.getText().equals(" ")) {
    		emptyField("Ingrese la dirección del cliente", AlertType.WARNING);
		}
    	else if (employeeNameFound.getText().equals(" ")) {
    		emptyField("Ingrese el nombre del repartidor", AlertType.WARNING);
		}
    	else if (employeeLastNameFound.getText().equals(" ")) {
    		emptyField("Ingrese el apellido del repartidor", AlertType.WARNING);
		}
    	else if (employeeIdFound.getText().equals(" ")) {
    		emptyField("Ingrese la identificación del repartidor", AlertType.WARNING);
		}
    	else {
			
		}
    }	
    
    @FXML
    void addToOrder(ActionEvent event) throws FileNotFoundException {
    	int pos = searchOrderProduct(event);
    	new Order().getProducts().add(casaDorada.getProducts().get(pos).getNameProduct());
    }

    @FXML
    void removeOfOrder(ActionEvent event) {

    }
    
    @FXML
    void addIngredient(ActionEvent event) {
    	int index_availability = 0;
    	if (availability.getSelectionModel().getSelectedItem().equals("DISPONIBLE")) {
			index_availability = 0;
		}
    	else if (availability.getSelectionModel().getSelectedItem().equals("AGOTADO")) {
			index_availability = 1;
		}
    	
    	casaDorada.addIngredients(ingredientName.getText(), index_availability);
    	ingredientAdded();
    }

    
    //log in and sing out methods -------------------------------------------------------------------------------------------
    
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
			logInAlert("Inicio de sesión exitoso", AlertType.INFORMATION,":D");
		}
		else {
			logInAlert("Nombre de usuario o contraseña incorrectos", AlertType.ERROR,":C");
		}
	}

    public void showLoggedOptions(boolean logged) throws IOException {
    	if (logged == true) {
    		menu.getItems().get(1).setVisible(false); //makes the option "iniciar sesion" invisible
    		menu.getItems().get(2).setVisible(true); //makes the option "añadir producto" visible
    		menu.getItems().get(3).setVisible(true); //makes the option "agregar cliente" visible
    		menu.getItems().get(4).setVisible(true); //makes the option "registrar orden" visible
    		menu.getItems().get(5).setVisible(true); //makes the option "agregar ingrediente" visible
    		menu.getItems().get(6).setVisible(true); //makes the option "buscar cliente" visible
    		menu.getItems().get(7).setVisible(true); //makes the option "importar datos de clientes" visible
    		menu.getItems().get(8).setVisible(true); //makes the option "importar datos de productos" visible
    		menu.getItems().get(9).setVisible(true); //makes the option "importar datos de ordenes" visible
    		menu.getItems().get(10).setVisible(true); //makes the option "importar datos de ingredientes" visible
    		menu.getItems().get(11).setVisible(true); //makes the option "lista de clientes" visible
    		menu.getItems().get(12).setVisible(true); //makes the option "lista de productos" visible
    		menu.getItems().get(13).setVisible(true); //makes the option "lista de ordenes" visible
    		menu.getItems().get(14).setVisible(true); //makes the option "lista de empleados" visible
    		menu.getItems().get(15).setVisible(true); //makes the option "lista de ingredientes" visible
    		menu.getItems().get(16).setVisible(true); //makes the option "cerrar sesión" visible
		}
    }
    
    @FXML
    void singOut(ActionEvent event) {
    	menu.getItems().get(1).setVisible(true); //makes the option "iniciar sesion" visible
    	menu.getItems().get(2).setVisible(false); //makes the option "añadir producto" invisible
   		menu.getItems().get(3).setVisible(false); //makes the option "agregar cliente" invisible
		menu.getItems().get(4).setVisible(false); //makes the option "registrar orden" invisible
		menu.getItems().get(5).setVisible(false); //makes the option "agregar ingrediente" invisible
		menu.getItems().get(6).setVisible(false); //makes the option "buscar cliente" invisible
		menu.getItems().get(7).setVisible(false); //makes the option "importar datos de clientes" invisible
		menu.getItems().get(8).setVisible(false); //makes the option "importar datos de productos" invisible
		menu.getItems().get(9).setVisible(false); //makes the option "importar datos de ordenes" invisible
		menu.getItems().get(10).setVisible(false); //makes the option "importar datos de ingredientes" invisible
		menu.getItems().get(11).setVisible(false); //makes the option "lista de clientes" invisible
		menu.getItems().get(12).setVisible(false); //makes the option "lista de productos" invisible
		menu.getItems().get(13).setVisible(false); //makes the option "lista de ordenes" invisible
		menu.getItems().get(14).setVisible(false); //makes the option "lista de empleados" invisible
		menu.getItems().get(15).setVisible(false); //makes the option "lista de ingredientes" invisible
		menu.getItems().get(16).setVisible(false); //makes the option "cerrar sesión" invisible
    }


    //methods to search -------------------------------------------------------------------------------------------
    
    @FXML
    void searchImage(ActionEvent event) {
    	
    }

    @FXML
    int searchClient(ActionEvent event) {
    	String[]parts = name_searched.getText().split(" ");
    	long start = System.nanoTime();
    	int pos = casaDorada.searchClients(parts[0],parts[1]);
    	long end = System.nanoTime();
    	
    	if (pos != -1) {
        	foundName.setText(casaDorada.getClients().get(pos).getName());
        	foundLastName.setText(casaDorada.getClients().get(pos).getLastName());
        	foundIDNumber.setText(casaDorada.getClients().get(pos).getIdNumber());
        	foundPhone.setText(casaDorada.getClients().get(pos).getPhoneNumber());	
        	foundAddres.setText(casaDorada.getClients().get(pos).getAddres());
        	foundComments.setText(casaDorada.getClients().get(pos).getComments());
        	nanoseconds.setText("Busqueda realizada en " + (end - start) + " nanosegundos");
        	deleteClientButton.setVisible(true);
        	updateClientButton.setVisible(true);
        	
        	if (updateClientButton.isPressed()) {
				updateClient(event);
				
			}
		}
    	else {
			clientNotFound();
			deleteClientButton.setVisible(false);
			updateClientButton.setVisible(false);
		}
    	
    	return pos;
    }
    

    @FXML
    int searchOrderProduct(ActionEvent event) {
    	casaDorada.sortProductsByName(casaDorada.getProducts());
    	return casaDorada.searchProduct(productToAdd.getText());
    }
    
    
    @FXML
    int searchEmployee(ActionEvent event) {
    	String[]parts = employee_searched.getText().split(" ");
    	long start = System.nanoTime();
    	int pos = casaDorada.searchEmployee(parts[0],parts[1]);
    	long end = System.nanoTime();
    	
    	if (pos != -1) {
        	employeeNameFound.setText(casaDorada.getEmployees().get(pos).getName());
        	employeeLastNameFound.setText(casaDorada.getEmployees().get(pos).getLastName());
        	employeeIdFound.setText(casaDorada.getEmployees().get(pos).getIdNumber());
        	nanoseconds_employee.setText("Busqueda realizada en " + (end - start) + " nanosegundos");
    
		}
    	else {
			employeeNotFound();;
		}
    	
    	return pos;
    }
    
    //initialize tables view -------------------------------------------------------------------------------------------
    
	private void initializeTableViewOfClients() throws FileNotFoundException {
    	ObservableList<Client> observableList;
    	observableList = FXCollections.observableArrayList(casaDorada.getClients());
    	
		tvClientList.setItems(observableList);
		tcName.setCellValueFactory(new PropertyValueFactory<Client,String>("name"));
		tcLastName.setCellValueFactory(new PropertyValueFactory<Client,String>("lastName"));
		tcID.setCellValueFactory(new PropertyValueFactory<Client,String>("idNumber"));
		tcPhone.setCellValueFactory(new PropertyValueFactory<Client,String>("phoneNumber"));
		tcAddres.setCellValueFactory(new PropertyValueFactory<Client,String>("addres"));
		tcComments.setCellValueFactory(new PropertyValueFactory<Client,String>("comments"));
		
	}
	
	private void initializeTableViewOfProducts() throws FileNotFoundException {
    	ObservableList<Product> observableList;
    	observableList = FXCollections.observableArrayList(casaDorada.getProducts());
    	
		tvProductsList.setItems(observableList);
		tcNameProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("nameProduct"));
		tcTypeProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("type"));
		tcIngredientsProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("ingredient"));
		tcSizeProduct.setCellValueFactory(new PropertyValueFactory<Product,String>("size"));
		tcPriceProduct.setCellValueFactory(new PropertyValueFactory<Product,Double>("price"));
		
	}
	
	private void initializeTableViewOfOrders() throws FileNotFoundException {
    	ObservableList<Order> observableList;
    	observableList = FXCollections.observableArrayList(casaDorada.getOrders());
    	
		tvOrdersList.setItems(observableList);
		tcOrderCode.setCellValueFactory(new PropertyValueFactory<Order,String>("code"));
		tcOrderState.setCellValueFactory(new PropertyValueFactory<Order,Integer>("state"));
		tcOrderProducts.setCellValueFactory(new PropertyValueFactory<Order,String>("products"));
		tcAmount.setCellValueFactory(new PropertyValueFactory<Order,Integer>("amountProduct"));
		tcOrderClient.setCellValueFactory(new PropertyValueFactory<Order,String>("client"));
		tcOrderDeliver.setCellValueFactory(new PropertyValueFactory<Order,String>("deliver"));
		tcOrderDate.setCellValueFactory(new PropertyValueFactory<Order,String>("date"));
		tcOrderComments.setCellValueFactory(new PropertyValueFactory<Order,String>("comments"));
	}
	
	private void initializeTableViewOfEmployees() throws FileNotFoundException {
    	ObservableList<Employee> observableList;
    	observableList = FXCollections.observableArrayList(casaDorada.getEmployees());
    	
		tvEmployeesList.setItems(observableList);
		tcEmployeeName.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
		tcEmployeeLastName.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
		tcEmployeeId.setCellValueFactory(new PropertyValueFactory<Employee,String>("idNumber"));
		
	}
	
	//it is not functional yet
	@SuppressWarnings("unused")
	private void initializeTableViewOfOrderProducts() throws FileNotFoundException {
    	ObservableList<String> observableList;
    	observableList = FXCollections.observableArrayList(new Order().getProducts());
    	
//		tvOrderProducts.setItems(observableList);
		tcOrderProduct.setCellValueFactory(new PropertyValueFactory<Order,String>("products"));
		
	}
	
	private void initializeTableViewOfIngredients() throws FileNotFoundException {
    	ObservableList<Ingredients> observableList;
    	observableList = FXCollections.observableArrayList(casaDorada.getIngredients());
    	
		tvIngredients.setItems(observableList);
		tcIngredientsName.setCellValueFactory(new PropertyValueFactory<Ingredients,String>("nameIngredient"));
		tcAvailability.setCellValueFactory(new PropertyValueFactory<Ingredients,String>("availability"));
		
	}
	
	//initialize combo box -------------------------------------------------------------------------------------------
	public void initializeComboBoxTypeProduct() {
        ObservableList<String> types = FXCollections.observableArrayList("Plato principal","Adicional","Bebida");
        registerType.setValue("Seleccionar");
        registerType.setItems(types);
	}
	
	public void initializeComboBoxIngredientAvailability() {
        ObservableList<String>  availability_options = FXCollections.observableArrayList(IngredientAvailability.values()[0].name(),IngredientAvailability.values()[1].name());
        availability.setValue("Seleccionar");
        availability.setItems(availability_options);
	}
    
    //methods to import -------------------------------------------------------------------------------------------
    
    @FXML
    void importDataClients(ActionEvent event) {
    	
    	FileChooser fChooser = new FileChooser();
    	fChooser.setTitle("Importar datos de clientes");
    	File file = fChooser.showOpenDialog(mainPane.getScene().getWindow());
    	if (file != null) {
   	     Alert alert = new Alert(AlertType.INFORMATION);
   	     alert.setTitle("Importar datos de clientes");
   	     try {
   	    	 casaDorada.importDataClients(file.getAbsolutePath());
   	    	 alert.setContentText("Datos importados exitosamente");
   	    	 alert.showAndWait();
   	     }catch(IOException e) {
   	    	 alert.setContentText("Los datos no fueron importado. Ha ocurrido un error");
   	    	 alert.showAndWait();
   	    	 e.printStackTrace();

   	     }
		}
    }
    
    @FXML
    void importDataProducts(ActionEvent event) {
    	
    	FileChooser fChooser = new FileChooser();
    	fChooser.setTitle("Importar datos de productos");
    	File file = fChooser.showOpenDialog(mainPane.getScene().getWindow());
    	if (file != null) {
   	     Alert alert = new Alert(AlertType.INFORMATION);
   	     alert.setTitle("Importar datos de productos");
   	     try {
   	    	 casaDorada.importDataProducts(file.getAbsolutePath());
   	    	 alert.setContentText("Datos importados exitosamente");
   	    	 alert.showAndWait();
   	     }catch(IOException e) {
   	    	 alert.setContentText("Los datos no fueron importado. Ha ocurrido un error");
   	    	 alert.showAndWait();
   	    	 e.printStackTrace();

   	     }
		}
    }
    
    @FXML
    void importDataOrders(ActionEvent event) {
    	
    	FileChooser fChooser = new FileChooser();
    	fChooser.setTitle("Importar datos de ordenes");
    	File file = fChooser.showOpenDialog(mainPane.getScene().getWindow());
    	if (file != null) {
   	     Alert alert = new Alert(AlertType.INFORMATION);
   	     alert.setTitle("Importar datos de ordenes");
   	     try {
   	    	 casaDorada.importDataOrders(file.getAbsolutePath());
   	    	 alert.setContentText("Datos importados exitosamente");
   	    	 alert.showAndWait();
   	     }catch(IOException e) {
   	    	 alert.setContentText("Los datos no fueron importado. Ha ocurrido un error");
   	    	 alert.showAndWait();
   	    	 e.printStackTrace();

   	     }
		}
    }
    
    @FXML
    void importDataIngredients(ActionEvent event) {
    	
    	FileChooser fChooser = new FileChooser();
    	fChooser.setTitle("Importar datos de ingredientes");
    	File file = fChooser.showOpenDialog(mainPane.getScene().getWindow());
    	if (file != null) {
   	     Alert alert = new Alert(AlertType.INFORMATION);
   	     alert.setTitle("Importar datos de ingredientes");
   	     try {
   	    	 casaDorada.importDataIngredients(file.getAbsolutePath());
   	    	 alert.setContentText("Datos importados exitosamente");
   	    	 alert.showAndWait();
   	     }catch(IOException e) {
   	    	 alert.setContentText("Los datos no fueron importado. Ha ocurrido un error");
   	    	 alert.showAndWait();
   	    	 e.printStackTrace();

   	     }
		}
    }
    
    //other methods -------------------------------------------------------------------------------------------
    
    @FXML
    void deleteClient(ActionEvent event) {
    	int pos_to_delete = searchClient(event);
    	if (pos_to_delete != -1) {
    		casaDorada.getClients().remove(pos_to_delete);
    		ClientDeleted();
    	}
    }
    
    
    //it is not functional yet
    @FXML
    void updateClient(ActionEvent event) {

		foundName.setEditable(true);
		foundLastName.setEditable(true);
		foundIDNumber.setEditable(true);
		foundPhone.setEditable(true);
		foundAddres.setEditable(true);
		foundComments.setEditable(true);
		
//        if (pos_to_update != -1) {
    		casaDorada.updateClient(0, foundName.getText(),foundLastName.getText(), 
    	    foundIDNumber.getText(), foundPhone.getText(), foundAddres.getText(), foundComments.getText());
//    	}
    }
    
}
	


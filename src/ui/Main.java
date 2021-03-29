package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CasaDorada;

public class Main extends Application{
	
		private CasaDoradaGUI casaDoradaGUI;
		private CasaDorada casaDorada;
		
		public Main() {
			casaDorada = new CasaDorada();
			casaDoradaGUI = new CasaDoradaGUI(casaDorada);
		}

		public static void main (String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage primaryStage) throws Exception {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("entry.fxml"));

			fxmlLoader.setController(casaDoradaGUI);
			
			Parent root = fxmlLoader.load();
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Casa Dorada");
			primaryStage.show();
		}

}

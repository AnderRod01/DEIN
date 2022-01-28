package application;
	
import java.util.Locale;
import java.util.ResourceBundle;

import config.Propiedades;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Locale locale = new Locale (Propiedades.getValor("language"),Propiedades.getValor("region"));
			ResourceBundle bundle = ResourceBundle.getBundle("config/messages", locale);
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("/fxml/VentanaPrincipalFXML.fxml"), bundle);
			Scene scene = new Scene(root);
			primaryStage.setTitle(bundle.getString("window.title"));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

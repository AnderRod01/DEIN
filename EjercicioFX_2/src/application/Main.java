package application;
	
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Locale locale = new Locale ("en","GB");
			ResourceBundle bundle = ResourceBundle.getBundle("utils/messages", locale);
			GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("/fxml/PersonaFXML.fxml"), bundle);
			Scene scene = new Scene(root);
			primaryStage.getIcons().add(new Image("/persona.png"));
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

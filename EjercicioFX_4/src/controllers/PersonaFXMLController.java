package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;
import javafx.scene.control.TableColumn;

public class PersonaFXMLController {
	@FXML
	private TableView <Persona> tblPersona;
	@FXML
	private TableColumn <Persona,String> colNombre;
	@FXML
	private TableColumn <Persona, String> colApellidos;
	@FXML
	private TableColumn <Persona, Integer> colEdad;
	@FXML
	private Button btnAgregar;

	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregarPersona(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AgregarPersonaFXML.fxml"));
			Parent root =loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage =(Stage) this.btnAgregar.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Agregar persona");
			stage.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

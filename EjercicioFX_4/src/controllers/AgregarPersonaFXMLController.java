package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;
import javafx.event.ActionEvent;

public class AgregarPersonaFXMLController {
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellidos;
	@FXML
	private TextField txtEdad;
	@FXML
	private Button btnGuardar;
	@FXML
	private Button btnCancelar;
	
	

	// Event Listener on Button[#btnGuardar].onAction
	@FXML
	public void guardar(ActionEvent event) {
		String nombre = txtNombre.getText();
		String ape = txtApellidos.getText();
		try {
			int edad = Integer.parseInt(txtEdad.getText());
			
			Persona p = new Persona (nombre, ape, edad);
			

			if (p.getNombre() == "" || p.getApellidos()=="") {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnGuardar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Debes rellenar todos los campos");
				alert.showAndWait();
			}
			else if(p.getEdad() <0 || p.getEdad()>120) {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnGuardar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Edad no válida");
				alert.showAndWait();
			}
			else {
				
				
			}
			
			
		}
		catch (NumberFormatException e) {
			Alert alert= new Alert(Alert.AlertType.ERROR);
			alert.initOwner(this.btnGuardar.getScene().getWindow());
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("El campo edad debe ser un número");
			alert.showAndWait();
			
			
		}
	}
	
	
	
	
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
		myStage.close();
	}
}

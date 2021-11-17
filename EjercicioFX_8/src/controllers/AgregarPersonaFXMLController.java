package controllers;

import javafx.fxml.FXML;
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
	
	private Persona p;

	// Event Listener on Button[#btnGuardar].onAction
	@FXML
	public void guardar(ActionEvent event) {
		String nombre = txtNombre.getText();
		String ape = txtApellidos.getText();
		try {
			int edad = Integer.parseInt(txtEdad.getText());
			if (nombre.equals("") || ape.equals("")) {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnGuardar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Debes rellenar todos los campos");
				alert.showAndWait();
			}
			else if(edad <0 || edad>120) {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnGuardar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Edad no válida");
				alert.showAndWait();
			}
			else {
				p = new Persona (nombre, ape, edad);
				Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
				System.out.println(p);
				myStage.close();
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
	
	public Persona getPersona () {
		return p;
	}
	
	
	public void setPersona (Persona pers) {
		p = pers;
		txtNombre.setText(p.getNombre());
		txtApellidos.setText(p.getApellidos());
		txtEdad.setText(p.getEdad() + "");
	}
}

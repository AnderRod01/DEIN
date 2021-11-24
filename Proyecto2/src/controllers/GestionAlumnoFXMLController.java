package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Alumno;
import javafx.event.ActionEvent;

public class GestionAlumnoFXMLController {
	@FXML
	private TextField txtFieldDni;
	@FXML
	private TextField txtFieldNombre;
	@FXML
	private TextField txtFieldApellido1;
	@FXML
	private TextField txtFieldApellido2;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;
	
	private Alumno alum;

	// Event Listener on Button[#btnAceptar].onAction
	@FXML
	public void aceptar(ActionEvent event) {
		String dni = txtFieldDni.getText();
		String nombre = txtFieldNombre.getText();
		String ape1 = txtFieldApellido1.getText();
		String ape2 = txtFieldApellido2.getText();
		
		alum = new Alumno(dni, nombre, ape1, ape2);
		
		Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
		myStage.close();
	}
	// Event Listener on Button[#btnCancelar].onAction
	@FXML
	public void cancelar(ActionEvent event) {
		Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
		myStage.close();
	}
	
	public Alumno getAlumno () {
		return alum;
	}
	
	public void setAlumno (Alumno a) {
		alum = a;
	}
	
}

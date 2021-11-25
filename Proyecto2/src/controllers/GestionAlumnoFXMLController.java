package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Alumno;
import model.Libro;

import java.sql.SQLException;

import dao.AlumnoDAO;
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
	private AlumnoDAO cAlumno;

	// Event Listener on Button[#btnAceptar].onAction
	@FXML
	public void aceptar(ActionEvent event) {
		cAlumno = new AlumnoDAO();

		String dni = txtFieldDni.getText();
		String nombre = txtFieldNombre.getText();
		String ape1 = txtFieldApellido1.getText();
		String ape2 = txtFieldApellido2.getText();
		
		if (alum!= null) {
			String dniAntiguo = alum.getDni();
			alum = new Alumno(dni, nombre, ape1, ape2);
			
			try {
				cAlumno.updateAlumno(alum, dniAntiguo);
			} catch (SQLException e) {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnCancelar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Ha ocurrido un error en la actualizacion del alumno");
				alert.showAndWait();
			}
			
		}else {
			alum = new Alumno(dni, nombre, ape1, ape2);
			
			try {
				cAlumno.insertAlumno(alum);
			} catch (SQLException e) {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnCancelar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Ha ocurrido un error en la creacion del alumno");
				alert.showAndWait();
			}
		}
		
		
		
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

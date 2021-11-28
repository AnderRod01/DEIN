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
		

		if(nombre.equals("") || ape1.equals("") || ape2.equals("")) {
			Alert alert= new Alert(Alert.AlertType.ERROR);
			alert.initOwner(this.btnCancelar.getScene().getWindow());
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Debes rellenar todos los campos");
			alert.showAndWait();
		}
		else {
			if (alum!= null) {
				String dniAntiguo = alum.getDni();
				alum = new Alumno(dni, nombre, ape1, ape2);
				if (dniValido(dni)) {
					try {
						cAlumno.updateAlumno(alum, dniAntiguo);
						
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setTitle("Exito");
						alert.setContentText("Alumno Actualizado");
						alert.showAndWait();
						
						Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
						myStage.close();
						
					} catch (SQLException e) {
						Alert alert= new Alert(Alert.AlertType.ERROR);
						alert.initOwner(this.btnCancelar.getScene().getWindow());
						alert.setHeaderText(null);
						alert.setTitle("ERROR");
						alert.setContentText("Ha ocurrido un error en la actualizacion del alumno");
						alert.showAndWait();
					}
				}else {
					Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.initOwner(this.btnCancelar.getScene().getWindow());
					alert.setHeaderText(null);
					alert.setTitle("ERROR");
					alert.setContentText("DNI mal formado");
					alert.showAndWait();
				}
				
				
			}else {
				alum = new Alumno(dni, nombre, ape1, ape2);
				
				if (dniValido(dni)) {
					try {
						cAlumno.insertAlumno(alum);
						
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setHeaderText(null);
						alert.setTitle("Exito");
						alert.setContentText("Alumno creado");
						alert.showAndWait();
						
						Stage myStage =(Stage) this.btnCancelar.getScene().getWindow();
						myStage.close();
						
					} catch (SQLException e) {
						Alert alert= new Alert(Alert.AlertType.ERROR);
						alert.initOwner(this.btnCancelar.getScene().getWindow());
						alert.setHeaderText(null);
						alert.setTitle("ERROR");
						alert.setContentText("Ha ocurrido un error en la creacion del alumno");
						alert.showAndWait();
					}
				}
				else {
					Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.initOwner(this.btnCancelar.getScene().getWindow());
					alert.setHeaderText(null);
					alert.setTitle("ERROR");
					alert.setContentText("DNI mal formado");
					alert.showAndWait();
				}
				
			}
		}
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
		txtFieldDni.setText(a.getDni());
		txtFieldNombre.setText(a.getNombre());
		txtFieldApellido1.setText(a.getApellido1());
		txtFieldApellido2.setText(a.getApellido2());
	}
	
	private boolean dniValido (String dni) {
		
		char[] letraDni = {
                'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };
		
		String num= "";
        int ind = 0;
        
        if(dni.length() == 8) {
            dni = "0" + dni;
        }
        if (!Character.isLetter(dni.charAt(8))) {
            return false;
        }
        if (dni.length() != 9){
            return false;
        }
        for (int i=0; i<8; i++) {

            if (!Character.isDigit(dni.charAt(i))) {
                return false;
            }

            num += dni.charAt(i);
        }

        ind = Integer.parseInt(num);


        ind %= 23;


        if ((Character.toUpperCase(dni.charAt(8))) != letraDni[ind]){
            return false;
        }
        
		
		return true;
	}
	
	
}

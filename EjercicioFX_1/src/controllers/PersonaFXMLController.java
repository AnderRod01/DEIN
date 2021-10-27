package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class PersonaFXMLController implements Initializable{
	@FXML
	private Button btnAgregar;
	@FXML
	private TableView<Persona> tblPersona;
	@FXML
	private TableColumn<Persona, String> colNombre;
	@FXML
	private TableColumn<Persona, String> colApellidos;
	@FXML
	private TableColumn<Persona, Integer> colEdad;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellidos;
	@FXML
	private TextField txtEdad;
	
	private ObservableList<Persona> data;
	

	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregarPersona(ActionEvent event) {
		String nombre = txtNombre.getText();
		String ape = txtApellidos.getText();
		try {
			int edad = Integer.parseInt(txtEdad.getText());
			
			Persona p = new Persona (nombre, ape, edad);
			
			if (!data.contains(p)) {
				if (p.getNombre() == "" || p.getApellidos()=="") {
					Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.initOwner(this.btnAgregar.getScene().getWindow());
					alert.setHeaderText(null);
					alert.setTitle("ERROR");
					alert.setContentText("Debes rellenar todos los campos");
					alert.showAndWait();
				}
				else if(p.getEdad() <0 || p.getEdad()>120) {
					Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.initOwner(this.btnAgregar.getScene().getWindow());
					alert.setHeaderText(null);
					alert.setTitle("ERROR");
					alert.setContentText("Edad no válida");
					alert.showAndWait();
				}
				else {
					data.add(p);
					txtNombre.setText("");
					txtApellidos.setText("");
					txtEdad.setText("");
					
				}
				
			}else {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnAgregar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Persona existente");
				alert.showAndWait();
			}
			
		}
		catch (NumberFormatException e) {
			Alert alert= new Alert(Alert.AlertType.ERROR);
			alert.initOwner(this.btnAgregar.getScene().getWindow());
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("El campo edad debe ser un número");
			alert.showAndWait();
		}
		
		
		
		

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		data = FXCollections.observableArrayList();
		tblPersona.setItems(data);
		colNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellidos"));
		colEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
	}
}

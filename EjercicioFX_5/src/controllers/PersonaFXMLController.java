package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class PersonaFXMLController implements Initializable{
	@FXML
	private TableView <Persona> tblPersona;
	@FXML
	private TableColumn<Persona,String> colNombre;
	@FXML
	private TableColumn<Persona,String> colApellidos;
	@FXML
	private TableColumn<Persona,Integer> colEdad;
	@FXML
	private Button btnAgregar;
	@FXML
	private Button btnModificar;
	@FXML
	private Button btnEliminar;
	
	private ObservableList<Persona> data;
	private int iSeleccionado=-1;
	
	private Persona p;

	// Event Listener on TableView[#tblPersona].onMouseClicked
	@FXML
	public void seleccionarFila(MouseEvent event) {
		if (tblPersona.getSelectionModel().getSelectedItem() != null) {
			btnModificar.setDisable(false);
			btnEliminar.setDisable(false);
			iSeleccionado = tblPersona.getSelectionModel().getSelectedIndex();
			p = tblPersona.getSelectionModel().getSelectedItem();
		}
	}
	
	
	// Event Listener on Button[#btnAgregar].onAction
	@FXML
	public void agregarPersona(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AgregarPersonaFXML.fxml"));
			Parent root =loader.load();
			AgregarPersonaFXMLController controller = loader.getController();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage =(Stage) this.btnAgregar.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Agregar persona");
			stage.showAndWait();
			
			p = controller.getPersona();
			
			if (!data.contains(p)) {
				data.add(p);
			}
			
			else {
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.initOwner(this.btnAgregar.getScene().getWindow());
				alert.setHeaderText(null);
				alert.setTitle("ERROR");
				alert.setContentText("Persona existente");
				alert.showAndWait();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Event Listener on Button[#btnModificar].onAction
	@FXML
	public void modificarPersona(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AgregarPersonaFXML.fxml"));
			Parent root = loader.load();
			AgregarPersonaFXMLController controller = loader.getController();
			controller.setPersona(p);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			Stage myStage =(Stage) this.btnAgregar.getScene().getWindow();
			stage.initOwner(myStage);
			stage.setScene(scene);
			stage.setTitle("Agregar persona");
			stage.showAndWait();
			
			p=controller.getPersona();
			
			if (!data.contains(p)) {
				data.set(iSeleccionado, p);
				btnModificar.setDisable(true);
				btnEliminar.setDisable(true);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	// Event Listener on Button[#btnEliminar].onAction
	@FXML
	public void eliminarPersona(ActionEvent event) {
		data.remove(iSeleccionado);
		
		
		btnModificar.setDisable(true);
		btnEliminar.setDisable(true);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		data = FXCollections.observableArrayList();
		tblPersona.setItems(data);
		colNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		colApellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellidos"));
		colEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
		
		btnModificar.setDisable(true);
		btnEliminar.setDisable(true);
		
	}
}

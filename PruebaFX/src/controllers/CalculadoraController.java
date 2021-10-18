package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import modelo.Operaciones;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;

public class CalculadoraController {
	@FXML
	private TextField txtOperador1;
	@FXML
	private TextField txtOperador2;
	@FXML
	private RadioButton rbtnSuma;
	@FXML
	private ToggleGroup tgOperaciones;
	@FXML
	private RadioButton rbtnResta;
	@FXML
	private RadioButton rbtnDivision;
	@FXML
	private RadioButton rbtnMultiplicacion;
	@FXML
	private TextField txtResultado;

	// Event Listener on Button.onAction
	@FXML
	public void operar(ActionEvent event) {
		
		try {
			double op1= Double.parseDouble(this.txtOperador1.getText());
			double op2= Double.parseDouble(this.txtOperador2.getText());
			
			
			Operaciones operacion= new Operaciones(op1, op2);
			
			if (this.rbtnSuma.isSelected()) {
				this.txtResultado.setText(operacion.sumar()+"");
			}else if(this.rbtnResta.isSelected()) {
				this.txtResultado.setText(operacion.restar()+"");
				
			}else if(this.rbtnMultiplicacion.isSelected()) {
				this.txtResultado.setText(operacion.multiplicar()+"");
			}else {
				if (op2!=0){
					this.txtResultado.setText(operacion.dividir()+"");
				}else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("ERROR");
					alert.setContentText("El segundo operador no puede ser 0");
					alert.showAndWait();
				}
					
				
			}
		}catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("ERROR");
			alert.setContentText("Datos introducidos incorrectos");
			alert.showAndWait();
		}
		
	}
}

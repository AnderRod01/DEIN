package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DeporteDAO;
import dao.EventoDAO;
import model.Deporte;
import model.Evento;
import model.Olimpiada;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AlterEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Nombre;
	private Olimpiada olimpiada;
	private DeporteDAO cDeporte;
	private EventoDAO cEvento; 
	private JComboBox<Deporte> comboBox_Deporte;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public AlterEvento(Olimpiada olimpiada) {
		cDeporte = new DeporteDAO();
		cEvento = new EventoDAO();
		
		setTitle("Evento");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{168, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			textField_Nombre = new JTextField();
			GridBagConstraints gbc_textField_Nombre = new GridBagConstraints();
			gbc_textField_Nombre.insets = new Insets(0, 0, 5, 0);
			gbc_textField_Nombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Nombre.gridx = 1;
			gbc_textField_Nombre.gridy = 0;
			contentPanel.add(textField_Nombre, gbc_textField_Nombre);
			textField_Nombre.setColumns(10);
		}
		{
			JLabel lblDeporte = new JLabel("Deporte: ");
			GridBagConstraints gbc_lblDeporte = new GridBagConstraints();
			gbc_lblDeporte.anchor = GridBagConstraints.EAST;
			gbc_lblDeporte.insets = new Insets(0, 0, 0, 5);
			gbc_lblDeporte.gridx = 0;
			gbc_lblDeporte.gridy = 1;
			contentPanel.add(lblDeporte, gbc_lblDeporte);
		}
		{
			DefaultComboBoxModel<Deporte> mdlDeporte = new DefaultComboBoxModel<Deporte>();
			ArrayList <Deporte> lstDeporte = cDeporte.selectDeportes();
			mdlDeporte.addAll(lstDeporte);
			
			comboBox_Deporte = new JComboBox();
			comboBox_Deporte.setModel(mdlDeporte);
			if (mdlDeporte.getSize() >0) {
				comboBox_Deporte.setSelectedIndex(0);
			}
			
			GridBagConstraints gbc_comboBox_Deporte = new GridBagConstraints();
			gbc_comboBox_Deporte.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_Deporte.gridx = 1;
			gbc_comboBox_Deporte.gridy = 1;
			contentPanel.add(comboBox_Deporte, gbc_comboBox_Deporte);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Evento evento =  new Evento(0, textField_Nombre.getText(), olimpiada, (Deporte) comboBox_Deporte.getSelectedItem());
						cEvento.insertEvento(evento);
						dispose();
					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
				
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

}

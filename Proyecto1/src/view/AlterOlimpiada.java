package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.OlimpiadaDAO;
import model.Olimpiada;

public class AlterOlimpiada extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane, panel_btn;
	private JTextField textField_Anio;
	private JTextField textField_Ciudad;
	private OlimpiadaDAO cOlimpiada;
	private JButton btnAceptar, btnCancelar;
	private JComboBox comboBox_Temporada;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlterOlimpiada dialog = new AlterOlimpiada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlterOlimpiada() {
		setModal(true);
		
		cOlimpiada =  new OlimpiadaDAO();
		dibujar();
		
		gestionarEventos();

	}
	
	private void dibujar () {
		setResizable(false);
		setBounds(100, 100, 452, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_lbl_txtfield = new JPanel();
		GridBagConstraints gbc_panel_lbl_txtfield = new GridBagConstraints();
		gbc_panel_lbl_txtfield.insets = new Insets(0, 0, 5, 0);
		gbc_panel_lbl_txtfield.fill = GridBagConstraints.BOTH;
		gbc_panel_lbl_txtfield.gridx = 0;
		gbc_panel_lbl_txtfield.gridy = 0;
		contentPane.add(panel_lbl_txtfield, gbc_panel_lbl_txtfield);
		GridBagLayout gbl_panel_lbl_txtfield = new GridBagLayout();
		gbl_panel_lbl_txtfield.columnWidths = new int[]{0, 0, 0};
		gbl_panel_lbl_txtfield.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_lbl_txtfield.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_lbl_txtfield.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_lbl_txtfield.setLayout(gbl_panel_lbl_txtfield);
		
		JLabel lblAnio = new JLabel("Año:");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.anchor = GridBagConstraints.EAST;
		gbc_lblAnio.fill = GridBagConstraints.VERTICAL;
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 0;
		gbc_lblAnio.gridy = 0;
		panel_lbl_txtfield.add(lblAnio, gbc_lblAnio);
		
		textField_Anio = new JTextField();
		GridBagConstraints gbc_textField_Anio = new GridBagConstraints();
		gbc_textField_Anio.anchor = GridBagConstraints.WEST;
		gbc_textField_Anio.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Anio.gridx = 1;
		gbc_textField_Anio.gridy = 0;
		panel_lbl_txtfield.add(textField_Anio, gbc_textField_Anio);
		textField_Anio.setColumns(10);
		
		JLabel lblTemporada = new JLabel("Temporada:");
		GridBagConstraints gbc_lblTemporada = new GridBagConstraints();
		gbc_lblTemporada.anchor = GridBagConstraints.EAST;
		gbc_lblTemporada.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemporada.gridx = 0;
		gbc_lblTemporada.gridy = 1;
		panel_lbl_txtfield.add(lblTemporada, gbc_lblTemporada);
		
		JComboBox comboBox_Temporada = new JComboBox();
		comboBox_Temporada.setModel(new DefaultComboBoxModel(new String[] {"Summer", "Winter"}));
		GridBagConstraints gbc_comboBox_Temporada = new GridBagConstraints();
		gbc_comboBox_Temporada.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_Temporada.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Temporada.gridx = 1;
		gbc_comboBox_Temporada.gridy = 1;
		panel_lbl_txtfield.add(comboBox_Temporada, gbc_comboBox_Temporada);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.anchor = GridBagConstraints.EAST;
		gbc_lblCiudad.insets = new Insets(0, 0, 0, 5);
		gbc_lblCiudad.gridx = 0;
		gbc_lblCiudad.gridy = 2;
		panel_lbl_txtfield.add(lblCiudad, gbc_lblCiudad);
		
		textField_Ciudad = new JTextField();
		GridBagConstraints gbc_textField_Ciudad = new GridBagConstraints();
		gbc_textField_Ciudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Ciudad.gridx = 1;
		gbc_textField_Ciudad.gridy = 2;
		panel_lbl_txtfield.add(textField_Ciudad, gbc_textField_Ciudad);
		textField_Ciudad.setColumns(10);
		
		JPanel panel_btn = new JPanel();
		GridBagConstraints gbc_panel_btn = new GridBagConstraints();
		gbc_panel_btn.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_btn.gridx = 0;
		gbc_panel_btn.gridy = 1;
		contentPane.add(panel_btn, gbc_panel_btn);
		
		btnAceptar = new JButton("Aceptar");
		
		panel_btn.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		
		panel_btn.add(btnCancelar);
		
	}
	
	private void gestionarEventos() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Olimpiada olimp =  new Olimpiada(0,
						textField_Anio.getText() + " " + (String)comboBox_Temporada.getSelectedItem(), 
						Integer.parseInt(textField_Anio.getText()), 
						(String) comboBox_Temporada.getSelectedItem(),
						textField_Ciudad.getText());
				
				cOlimpiada.insertOlimpiada(olimp);
				dispose();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
	}
}

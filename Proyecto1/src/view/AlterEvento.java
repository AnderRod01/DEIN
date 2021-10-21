package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;

public class AlterEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Nombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlterEvento dialog = new AlterEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlterEvento() {
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
			JComboBox comboBox_Equipo = new JComboBox();
			GridBagConstraints gbc_comboBox_Equipo = new GridBagConstraints();
			gbc_comboBox_Equipo.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox_Equipo.gridx = 1;
			gbc_comboBox_Equipo.gridy = 1;
			contentPanel.add(comboBox_Equipo, gbc_comboBox_Equipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.DeporteDAO;
import model.Deporte;
import model.Equipo;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class AlterDeporte extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Nombre;
	private JPanel panel_btn;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JList list_Deporte;
	private JButton btnCerrar;
	private boolean editar;
	private DeporteDAO cDeporte;
	private DefaultListModel<Deporte> mdlDeporte;
	private boolean eliminando = false;

	
	/**
	 * Create the dialog.
	 */
	public AlterDeporte(boolean editar) {
		this.editar = editar;
		cDeporte= new DeporteDAO();
		
		if (this.editar) {
			setTitle("Editar Deporte");
			dibujarEditar();
			cargarDeportes();
			cargarTxtField();
		}else {
			setTitle("Nuevo Deporte");
			dibujarNuevo();
		}
		
		
		
	}
	
	private void dibujarEditar() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 689, 243);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{689, 0};
		gridBagLayout.rowHeights = new int[]{184, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{328, 84, 164, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		
		{
			panel_btn = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_btn.getLayout();
			flowLayout.setHgap(25);
			GridBagConstraints gbc_panel_btn = new GridBagConstraints();
			gbc_panel_btn.gridwidth = 2;
			gbc_panel_btn.fill = GridBagConstraints.HORIZONTAL;
			gbc_panel_btn.gridx = 1;
			gbc_panel_btn.gridy = 2;
			contentPanel.add(panel_btn, gbc_panel_btn);
			{
				btnActualizar = new JButton("");
				panel_btn.add(btnActualizar);
				btnActualizar.setIcon(new ImageIcon(AlterEquipo.class.getResource("/images/update.png")));
				
				btnActualizar.setActionCommand("OK");
				getRootPane().setDefaultButton(btnActualizar);
			}
			{
				btnBorrar = new JButton("");
				btnBorrar.setIcon(new ImageIcon(AlterEquipo.class.getResource("/images/trash.png")));
				panel_btn.add(btnBorrar);
			}
		}
		{
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 3;
			gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 0;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				list_Deporte = new JList();
				
				scrollPane.setViewportView(list_Deporte);
				cargarDeportes();
			}
		}
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.setActionCommand("Cancel");
			GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
			gbc_btnCerrar.gridx = 0;
			gbc_btnCerrar.gridy = 1;
			getContentPane().add(btnCerrar, gbc_btnCerrar);
		}
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 1;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			textField_Nombre = new JTextField();
			GridBagConstraints gbc_textField_Nombre = new GridBagConstraints();
			gbc_textField_Nombre.insets = new Insets(0, 0, 5, 0);
			gbc_textField_Nombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Nombre.gridx = 2;
			gbc_textField_Nombre.gridy = 0;
			contentPanel.add(textField_Nombre, gbc_textField_Nombre);
			textField_Nombre.setColumns(10);

		}
	}
		
	
	

	public void dibujarNuevo() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 372, 129);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{156, 70, 0};
		gbl_contentPanel.rowHeights = new int[]{15, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre:");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.anchor = GridBagConstraints.EAST;
			gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			textField_Nombre = new JTextField();
			GridBagConstraints gbc_textField_Nombre = new GridBagConstraints();
			gbc_textField_Nombre.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Nombre.gridx = 1;
			gbc_textField_Nombre.gridy = 0;
			contentPanel.add(textField_Nombre, gbc_textField_Nombre);
			textField_Nombre.setColumns(10);
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
	
	public void gestionarEventos () {
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cerrar();
			}
		});
		
		if (editar) {
			
			list_Deporte.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!eliminando)
						cargarTxtField();
					
					eliminando = false;
				}
			});
				
			btnBorrar.addActionListener(new ActionListener () {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					eliminando = true;
					cDeporte.deleteDeporte(list_Deporte.getSelectedValue());
					cargarDeportes();
					cargarTxtField();
				}
				
			});
			
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Equipo equipo = new Equipo(idEquipo,textField_Nombre.getText() , textField_Iniciales.getText());
					
					if (!cEquipo.existeEquipo(equipo)) {
						cEquipo.updateEquipo(equipo);
						cargarEquipos();
					}
					
				}
			});
			
		} else {
			
		}
	}
	
	
	private void cargarDeportes() {
		ArrayList<Deporte> arrDeporte = cDeporte.selectDeportes();
		
		mdlDeporte = new DefaultListModel<Deporte>();
		mdlDeporte.addAll(arrDeporte);
		list_Deporte.setModel(mdlDeporte);
		
		if (mdlDeporte.getSize()>0) {
			list_Deporte.setSelectedIndex(0);
			btnActualizar.setEnabled(true);
			btnBorrar.setEnabled(true);
		}else {
			btnActualizar.setEnabled(false);
			btnBorrar.setEnabled(false);
		}		
	}
	
	private void cargarTxtField() {
		textField_Nombre.setText(((Deporte) list_Deporte.getSelectedValue()).getNombre());
	}
	
	private void cerrar() {
		cDeporte.cerrarConexion();
		setVisible(false);
		
	}

}

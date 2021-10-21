package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class AlterParticipacion extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlterParticipacion dialog = new AlterParticipacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlterParticipacion() {
		setResizable(false);
		setModal(true);
		setTitle("Participacion");
		setBounds(100, 100, 809, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{157, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel panel_Listas = new JPanel();
			panel_Listas.setBorder(new EmptyBorder(10, 10, 10, 10));
			GridBagConstraints gbc_panel_Listas = new GridBagConstraints();
			gbc_panel_Listas.fill = GridBagConstraints.BOTH;
			gbc_panel_Listas.insets = new Insets(0, 0, 5, 0);
			gbc_panel_Listas.gridx = 0;
			gbc_panel_Listas.gridy = 0;
			contentPanel.add(panel_Listas, gbc_panel_Listas);
			GridBagLayout gbl_panel_Listas = new GridBagLayout();
			gbl_panel_Listas.columnWidths = new int[]{157, 180, 0};
			gbl_panel_Listas.rowHeights = new int[]{0, 0};
			gbl_panel_Listas.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel_Listas.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_Listas.setLayout(gbl_panel_Listas);
			{
				JScrollPane scrollPane_Deportista = new JScrollPane();
				GridBagConstraints gbc_scrollPane_Deportista = new GridBagConstraints();
				gbc_scrollPane_Deportista.fill = GridBagConstraints.VERTICAL;
				gbc_scrollPane_Deportista.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane_Deportista.gridx = 0;
				gbc_scrollPane_Deportista.gridy = 0;
				panel_Listas.add(scrollPane_Deportista, gbc_scrollPane_Deportista);
				{
					JList list_Deportista = new JList();
					list_Deportista.setBorder(new TitledBorder(null, "Deportista", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					scrollPane_Deportista.setViewportView(list_Deportista);
				}
			}
			{
				JScrollPane scrollPane_Evento = new JScrollPane();
				GridBagConstraints gbc_scrollPane_Evento = new GridBagConstraints();
				gbc_scrollPane_Evento.fill = GridBagConstraints.VERTICAL;
				gbc_scrollPane_Evento.gridx = 1;
				gbc_scrollPane_Evento.gridy = 0;
				panel_Listas.add(scrollPane_Evento, gbc_scrollPane_Evento);
				{
					JList list_Evento = new JList();
					list_Evento.setBorder(new TitledBorder(null, "Evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					scrollPane_Evento.setViewportView(list_Evento);
				}
			}
		}
		{
			JPanel panel_Combobox = new JPanel();
			GridBagConstraints gbc_panel_Combobox = new GridBagConstraints();
			gbc_panel_Combobox.fill = GridBagConstraints.BOTH;
			gbc_panel_Combobox.gridx = 0;
			gbc_panel_Combobox.gridy = 1;
			contentPanel.add(panel_Combobox, gbc_panel_Combobox);
			GridBagLayout gbl_panel_Combobox = new GridBagLayout();
			gbl_panel_Combobox.columnWidths = new int[]{266, 0, 0, 0};
			gbl_panel_Combobox.rowHeights = new int[]{0, 0, 0};
			gbl_panel_Combobox.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel_Combobox.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_Combobox.setLayout(gbl_panel_Combobox);
			{
				JLabel lblEquipo = new JLabel("Equipo:");
				GridBagConstraints gbc_lblEquipo = new GridBagConstraints();
				gbc_lblEquipo.anchor = GridBagConstraints.EAST;
				gbc_lblEquipo.insets = new Insets(0, 0, 5, 5);
				gbc_lblEquipo.gridx = 0;
				gbc_lblEquipo.gridy = 0;
				panel_Combobox.add(lblEquipo, gbc_lblEquipo);
			}
			{
				JComboBox comboBox_Equipo = new JComboBox();
				GridBagConstraints gbc_comboBox_Equipo = new GridBagConstraints();
				gbc_comboBox_Equipo.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox_Equipo.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox_Equipo.gridx = 1;
				gbc_comboBox_Equipo.gridy = 0;
				panel_Combobox.add(comboBox_Equipo, gbc_comboBox_Equipo);
			}
			{
				JLabel lblMedalla = new JLabel("Medalla:");
				GridBagConstraints gbc_lblMedalla = new GridBagConstraints();
				gbc_lblMedalla.anchor = GridBagConstraints.EAST;
				gbc_lblMedalla.insets = new Insets(0, 0, 0, 5);
				gbc_lblMedalla.gridx = 0;
				gbc_lblMedalla.gridy = 1;
				panel_Combobox.add(lblMedalla, gbc_lblMedalla);
			}
			{
				JComboBox comboBox = new JComboBox();
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.insets = new Insets(0, 0, 0, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 1;
				panel_Combobox.add(comboBox, gbc_comboBox);
			}
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

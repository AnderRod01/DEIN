package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.OlimpiadaDAO;
import model.Olimpiada;

import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Indice extends JFrame {

	private JPanel contentPane;
	private JTable table_participaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Indice frame = new Indice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Indice() {
		setTitle("Gestor de Olimpiadas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 492);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDeportista = new JMenu("Deportistas");
		menuBar.add(mnDeportista);
		
		JMenuItem mntmAniadir_deportista = new JMenuItem("Añadir");
		mntmAniadir_deportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevoDeportista frame= new NuevoDeportista();
				frame.setVisible(true);
			}
		});
		mnDeportista.add(mntmAniadir_deportista);
		
		JMenuItem mntmGestionar_deportista = new JMenuItem("Gestionar");
		mnDeportista.add(mntmGestionar_deportista);
		
		JMenu mnDeporte = new JMenu("Deportes");
		menuBar.add(mnDeporte);
		
		JMenuItem mntmAniadir_deporte = new JMenuItem("Añadir");
		mnDeporte.add(mntmAniadir_deporte);
		
		JMenuItem mntmGestionar_Deporte = new JMenuItem("Gestionar");
		mnDeporte.add(mntmGestionar_Deporte);
		
		JMenu mnEquipo = new JMenu("Equipos");
		menuBar.add(mnEquipo);
		
		JMenuItem mntmAniadir_equipo = new JMenuItem("Añadir");
		mnEquipo.add(mntmAniadir_equipo);
		
		JMenuItem mntmGestionar_equipo = new JMenuItem("Gesionar");
		mnEquipo.add(mntmGestionar_equipo);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{94, 102, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_olimpiadas = new JPanel();
		panel_olimpiadas.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_panel_olimpiadas = new GridBagConstraints();
		gbc_panel_olimpiadas.insets = new Insets(0, 0, 5, 0);
		gbc_panel_olimpiadas.fill = GridBagConstraints.BOTH;
		gbc_panel_olimpiadas.gridx = 0;
		gbc_panel_olimpiadas.gridy = 0;
		contentPane.add(panel_olimpiadas, gbc_panel_olimpiadas);
		GridBagLayout gbl_panel_olimpiadas = new GridBagLayout();
		gbl_panel_olimpiadas.columnWidths = new int[]{0, 337, 0, 0, 0, 0, 0};
		gbl_panel_olimpiadas.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_olimpiadas.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_olimpiadas.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_olimpiadas.setLayout(gbl_panel_olimpiadas);
		
		JLabel lblOlimpiadas = new JLabel("OLIMPIADAS");
		lblOlimpiadas.setForeground(SystemColor.desktop);
		GridBagConstraints gbc_lblOlimpiadas = new GridBagConstraints();
		gbc_lblOlimpiadas.insets = new Insets(0, 0, 5, 5);
		gbc_lblOlimpiadas.anchor = GridBagConstraints.EAST;
		gbc_lblOlimpiadas.gridx = 0;
		gbc_lblOlimpiadas.gridy = 1;
		panel_olimpiadas.add(lblOlimpiadas, gbc_lblOlimpiadas);
		
	
		
		
		JComboBox comboBox_Olimpiadas = new JComboBox();
		cargarComboOlimpiadas(comboBox_Olimpiadas);
		
		comboBox_Olimpiadas.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox_Olimpiadas = new GridBagConstraints();
		gbc_comboBox_Olimpiadas.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Olimpiadas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Olimpiadas.gridx = 1;
		gbc_comboBox_Olimpiadas.gridy = 1;
		panel_olimpiadas.add(comboBox_Olimpiadas, gbc_comboBox_Olimpiadas);
		
		JButton btnAniadirOlimpiada = new JButton("");
		btnAniadirOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NuevaOlimpiada frame = new NuevaOlimpiada();
				frame.setVisible(true);
				
			}
		});
		btnAniadirOlimpiada.setIcon(new ImageIcon(Indice.class.getResource("/images/new.png")));
		GridBagConstraints gbc_btnAniadirOlimpiada = new GridBagConstraints();
		gbc_btnAniadirOlimpiada.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirOlimpiada.gridx = 2;
		gbc_btnAniadirOlimpiada.gridy = 1;
		panel_olimpiadas.add(btnAniadirOlimpiada, gbc_btnAniadirOlimpiada);
		
		JButton btnEditarOlimpiada = new JButton("");
		btnEditarOlimpiada.setIcon(new ImageIcon(Indice.class.getResource("/images/edit.png")));
		GridBagConstraints gbc_btnEditarOlimpiada = new GridBagConstraints();
		gbc_btnEditarOlimpiada.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditarOlimpiada.gridx = 3;
		gbc_btnEditarOlimpiada.gridy = 1;
		panel_olimpiadas.add(btnEditarOlimpiada, gbc_btnEditarOlimpiada);
		
		JButton btnBorrarOlimpiada = new JButton("");
		btnBorrarOlimpiada.setIcon(new ImageIcon(Indice.class.getResource("/images/trash.png")));
		GridBagConstraints gbc_btnBorrarOlimpiada = new GridBagConstraints();
		gbc_btnBorrarOlimpiada.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrarOlimpiada.gridx = 4;
		gbc_btnBorrarOlimpiada.gridy = 1;
		panel_olimpiadas.add(btnBorrarOlimpiada, gbc_btnBorrarOlimpiada);
		
		JButton btnVerOlimpiada = new JButton("");
		btnVerOlimpiada.setIcon(new ImageIcon(Indice.class.getResource("/images/see.png")));
		btnVerOlimpiada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnVerOlimpiada = new GridBagConstraints();
		gbc_btnVerOlimpiada.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerOlimpiada.gridx = 5;
		gbc_btnVerOlimpiada.gridy = 1;
		panel_olimpiadas.add(btnVerOlimpiada, gbc_btnVerOlimpiada);
		
		JPanel panel_rdbtn_olimpiadas = new JPanel();
		GridBagConstraints gbc_panel_rdbtn_olimpiadas = new GridBagConstraints();
		gbc_panel_rdbtn_olimpiadas.insets = new Insets(0, 0, 0, 5);
		gbc_panel_rdbtn_olimpiadas.fill = GridBagConstraints.BOTH;
		gbc_panel_rdbtn_olimpiadas.gridx = 1;
		gbc_panel_rdbtn_olimpiadas.gridy = 2;
		panel_olimpiadas.add(panel_rdbtn_olimpiadas, gbc_panel_rdbtn_olimpiadas);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnSummer = new JRadioButton("Verano");
		rdbtnSummer.setSelected(true);
		rdbtnSummer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OlimpiadaDAO olimpDao= new OlimpiadaDAO();
				ArrayList <Olimpiada> lstOlimp= olimpDao.getOlimpiadasVerano();
				DefaultComboBoxModel<Olimpiada> mdlOlimp= new DefaultComboBoxModel<Olimpiada>();
				mdlOlimp.addAll(lstOlimp);
				comboBox_Olimpiadas.setModel(mdlOlimp);
				//comboBox_Olimpiadas.setSelectedIndex(0);
				
			}
		});
		panel_rdbtn_olimpiadas.add(rdbtnSummer);
		bg.add(rdbtnSummer);
		
		JRadioButton rdbtnWinter = new JRadioButton("Invierno");
		rdbtnWinter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OlimpiadaDAO olimpDao= new OlimpiadaDAO();
				ArrayList <Olimpiada> lstOlimp= olimpDao.getOlimpiadasInvierno();
				DefaultComboBoxModel<Olimpiada> mdlOlimp= new DefaultComboBoxModel<Olimpiada>();
				mdlOlimp.addAll(lstOlimp);
				comboBox_Olimpiadas.setModel(mdlOlimp);
				//comboBox_Olimpiadas.setSelectedIndex(0);
			}
		});
		panel_rdbtn_olimpiadas.add(rdbtnWinter);
		bg.add(rdbtnWinter);
		
		JPanel panel_Eventos = new JPanel();
		panel_Eventos.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_panel_Eventos = new GridBagConstraints();
		gbc_panel_Eventos.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Eventos.fill = GridBagConstraints.BOTH;
		gbc_panel_Eventos.gridx = 0;
		gbc_panel_Eventos.gridy = 1;
		contentPane.add(panel_Eventos, gbc_panel_Eventos);
		GridBagLayout gbl_panel_Eventos = new GridBagLayout();
		gbl_panel_Eventos.columnWidths = new int[]{588, 130, 0};
		gbl_panel_Eventos.rowHeights = new int[]{101, 0};
		gbl_panel_Eventos.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Eventos.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Eventos.setLayout(gbl_panel_Eventos);
		
		JScrollPane scrollPane_Evento = new JScrollPane();
		GridBagConstraints gbc_scrollPane_Evento = new GridBagConstraints();
		gbc_scrollPane_Evento.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_Evento.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_Evento.gridx = 0;
		gbc_scrollPane_Evento.gridy = 0;
		panel_Eventos.add(scrollPane_Evento, gbc_scrollPane_Evento);
		
		JList list_Evento = new JList();
		scrollPane_Evento.setViewportView(list_Evento);
		list_Evento.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "EVENTOS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 92, 92)));
		
		JPanel panel_btn_Evento = new JPanel();
		GridBagConstraints gbc_panel_btn_Evento = new GridBagConstraints();
		gbc_panel_btn_Evento.fill = GridBagConstraints.BOTH;
		gbc_panel_btn_Evento.gridx = 1;
		gbc_panel_btn_Evento.gridy = 0;
		panel_Eventos.add(panel_btn_Evento, gbc_panel_btn_Evento);
		GridBagLayout gbl_panel_btn_Evento = new GridBagLayout();
		gbl_panel_btn_Evento.columnWidths = new int[]{34, 0};
		gbl_panel_btn_Evento.rowHeights = new int[]{10, 0, 0, 0};
		gbl_panel_btn_Evento.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_btn_Evento.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_btn_Evento.setLayout(gbl_panel_btn_Evento);
		
		JButton btnAniadirEvento = new JButton("");
		btnAniadirEvento.setIcon(new ImageIcon(Indice.class.getResource("/images/new.png")));
		GridBagConstraints gbc_btnAniadirEvento = new GridBagConstraints();
		gbc_btnAniadirEvento.insets = new Insets(0, 0, 5, 0);
		gbc_btnAniadirEvento.gridx = 0;
		gbc_btnAniadirEvento.gridy = 0;
		panel_btn_Evento.add(btnAniadirEvento, gbc_btnAniadirEvento);
		
		JButton btnEditarEvento = new JButton("");
		btnEditarEvento.setIcon(new ImageIcon(Indice.class.getResource("/images/edit.png")));
		GridBagConstraints gbc_btnEditarEvento = new GridBagConstraints();
		gbc_btnEditarEvento.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditarEvento.gridx = 0;
		gbc_btnEditarEvento.gridy = 1;
		panel_btn_Evento.add(btnEditarEvento, gbc_btnEditarEvento);
		
		JButton btnBorrarEvento = new JButton("");
		btnBorrarEvento.setIcon(new ImageIcon(Indice.class.getResource("/images/trash.png")));
		GridBagConstraints gbc_btnBorrarEvento = new GridBagConstraints();
		gbc_btnBorrarEvento.gridx = 0;
		gbc_btnBorrarEvento.gridy = 2;
		panel_btn_Evento.add(btnBorrarEvento, gbc_btnBorrarEvento);
		
		JPanel panel_Participaciones = new JPanel();
		panel_Participaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_panel_Participaciones = new GridBagConstraints();
		gbc_panel_Participaciones.fill = GridBagConstraints.BOTH;
		gbc_panel_Participaciones.gridx = 0;
		gbc_panel_Participaciones.gridy = 2;
		contentPane.add(panel_Participaciones, gbc_panel_Participaciones);
		GridBagLayout gbl_panel_Participaciones = new GridBagLayout();
		gbl_panel_Participaciones.columnWidths = new int[]{375, 0, 0};
		gbl_panel_Participaciones.rowHeights = new int[]{16, 0};
		gbl_panel_Participaciones.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Participaciones.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Participaciones.setLayout(gbl_panel_Participaciones);
		
		table_participaciones = new JTable();
		table_participaciones.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID Deportista", "ID Evento", "ID Equipo", "Edad", "Medalla"
			}
		));
		GridBagConstraints gbc_table_participaciones = new GridBagConstraints();
		gbc_table_participaciones.insets = new Insets(0, 0, 0, 5);
		gbc_table_participaciones.anchor = GridBagConstraints.NORTHWEST;
		gbc_table_participaciones.gridx = 0;
		gbc_table_participaciones.gridy = 0;
		panel_Participaciones.add(table_participaciones, gbc_table_participaciones);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		panel_Participaciones.add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
	}
	
	private static void cargarComboOlimpiadas(JComboBox<Olimpiada> comboBox_Olimpiadas ) {
		OlimpiadaDAO olimpDao= new OlimpiadaDAO();
		ArrayList <Olimpiada> lstOlimp= olimpDao.getOlimpiadas();
		DefaultComboBoxModel<Olimpiada> mdlOlimp= new DefaultComboBoxModel<Olimpiada>();
		mdlOlimp.addAll(lstOlimp);
		comboBox_Olimpiadas.setModel(mdlOlimp);
	}

}

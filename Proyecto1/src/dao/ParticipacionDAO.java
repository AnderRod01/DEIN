package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Evento;
import model.Olimpiada;
import model.Participacion;

public class ParticipacionDAO {

	private ConexionDB cn;
	private DeportistaDAO cDeportista;
	private EquipoDAO cEquipo;
	
	public ParticipacionDAO (){
		cDeportista = new DeportistaDAO();
		cEquipo = new EquipoDAO();
		this.cn = new ConexionDB();
	}

	public ArrayList<Participacion> selectParticipacionesPorEvento(Evento evento) {
		ArrayList<Participacion> participaciones = new ArrayList<Participacion>();
		if(evento != null) {
			PreparedStatement ps;
			try {
				ps = cn.getConexion().prepareStatement("select * from Participacion where id_evento = ?");
				ps.setInt(1, evento.getId_evento());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					String medalla = rs.getString(5);
					if(rs.wasNull()) {
						medalla = "Sin medalla";
					}
					Participacion part = new Participacion(
							cDeportista.selectDeportistaPorId(rs.getInt(1)), 
							evento, 
							cEquipo.selectEquipoPorId(rs.getInt(3)), 
							rs.getInt(4), 
							medalla);
					participaciones.add(part);
				} 
			} catch(SQLException e) {
				return participaciones;
			}
		}
		return participaciones;
	}
	
	
	public void cerrarConexion() {
		cDeportista.cerrarConexion();
		cEquipo.cerrarConexion();
		cn.cerrarConexion();
	}
}

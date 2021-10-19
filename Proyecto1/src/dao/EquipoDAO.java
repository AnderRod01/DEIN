package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Deporte;
import model.Deportista;
import model.Equipo;

public class EquipoDAO {

	ConexionDB cn;


	public ArrayList<Equipo> getEquipos() {
		PreparedStatement ps;
		ArrayList <Equipo> lstEquipos = new ArrayList <Equipo>();
		
		try {
			ps=cn.getConexion().prepareStatement("select *  from Equipo");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				lstEquipos.add(new Equipo (rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lstEquipos;
	}
	//falta lo de abajo y cambiar los nombre de los getDAO
	public void insertDeporte (Deporte deporte) {
		PreparedStatement ps;
		Connection conexion = cn.getConexion();
		
		try {
			ps= cn.getConexion().prepareStatement("insert into Deporte (nombre) values (?)");
			ps.setString(1, deporte.getNombre());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateDeporte (Deporte deporte) {
		PreparedStatement ps;
		Connection conexion = cn.getConexion();
		
		try {
			ps= cn.getConexion().prepareStatement("update Deporte set nombre = ? where id_deporte = ?");
			ps.setString(1, deporte.getNombre());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

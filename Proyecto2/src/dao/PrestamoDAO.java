package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import config.ConexionDB;
import model.Alumno;
import model.Libro;
import model.Prestamo;

public class PrestamoDAO {
	private ConexionDB cn;
	private AlumnoDAO cAlumno;
	private LibroDAO cLibro;
	
	public PrestamoDAO () {
		cn = new ConexionDB();
		cAlumno = new AlumnoDAO();
		cLibro= new LibroDAO();
	}
	
	public ArrayList<Prestamo> selectPrestamos (){
		PreparedStatement ps;
		ArrayList<Prestamo> lstPrest = new ArrayList<Prestamo>();
		
		try {
			ps = cn.getConexion().prepareStatement("select id_prestamo, dni_alumno, codigo_libro, fecha_prestamo from Prestamo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Alumno alum = cAlumno.selectAlumnoPorDni(rs.getString(2));
				Libro lib = cLibro.selectLibroPorCod (rs.getInt(3));
				lstPrest.add(new Prestamo(rs.getInt(1), alum, lib,rs.getObject(4, LocalDate.class)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstPrest;
	}
	
	public void insertPrestamo (Prestamo p) throws SQLException {
		PreparedStatement ps;
		ps = cn.getConexion().prepareStatement("insert into Prestamo (dni_alumno, codigo_libro, fecha_prestamo) values (?,?,?)");
		ps.setString(1, p.getAlum().getDni());
		ps.setInt(2, p.getLib().getCodigo());
		ps.setObject(3, p.getFecha_prestamo());
		
		ps.executeUpdate();
	}
	
	public void deletePrestamo (Prestamo p) throws SQLException {
		PreparedStatement ps;
		ps = cn.getConexion().prepareStatement("delete from Prestamo where id_prestamo = ?");
		ps.setInt(1, p.getId_prestamo());
		
		ps.executeUpdate();
	}
	
	
}

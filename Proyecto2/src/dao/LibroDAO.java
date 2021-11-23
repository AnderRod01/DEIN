package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ConexionDB;
import model.Libro;

public class LibroDAO {
	private ConexionDB cn;
	
	public LibroDAO () {
		this.cn = new ConexionDB();	
	}
	
	public ArrayList<Libro> selectLibros (){
		PreparedStatement ps;
		ArrayList<Libro> lstLibros = new ArrayList<Libro>();
		
		try {
			ps= cn.getConexion().prepareStatement("select * from Libro where Baja = 0");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lstLibros.add(new Libro(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),  rs.getInt(6)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstLibros;
	}
	
	public void insertLibro (Libro libro) {
		PreparedStatement ps;
		try {
			ps = cn.getConexion().prepareStatement("insert into Libro (codigo, titulo, autor, editorial, estado, baja) values (?,?,?,?,?,?)");
			ps.setInt(1, libro.getCodigo());
			ps.setString(2, libro.getTitulo());
			ps.setString(3, libro.getAutor());
			ps.setString(4, libro.getEditorial());
			ps.setString(5, libro.getEstado());
			ps.setInt(6, libro.getBaja());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateDatosLibro (Libro libro, int cod) {
		PreparedStatement ps;
		
		try {
			ps = cn.getConexion().prepareStatement("update Libro set codigo = ?, titulo = ?, autor = ?, editorial = ?, estado = ? where codigo = ? ");
			ps.setInt(1, libro.getCodigo());
			ps.setString(2, libro.getTitulo());
			ps.setString(3, libro.getAutor());
			ps.setString(4, libro.getEditorial());
			ps.setString(5, libro.getEstado());
			ps.setInt(6, cod);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cambiarBaja (Libro lib) {
		PreparedStatement ps;
		
		if (lib.getBaja() == 0) {
			lib.setBaja(1); 
		}else {
			lib.setBaja(0);
		}
		
		try {
			ps = cn.getConexion().prepareStatement("update Libro set Baja = ?");
			ps.setInt(1, lib.getBaja());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Salle;
import connexion.Connexion;
import dao.IDao;

public class SalleService implements IDao<Salle> {

	@Override
	public boolean create(Salle o) {
		  String sql = "insert into salle values (null, ?, ?, ?)";
	        try {
	        	System.out.println("hhaa l conx");
	        	System.out.println(Connexion.getInstane().getConnection());
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);

	            ps.setString(1, o.getCode());
	            ps.setInt(2,o.getCapacite());
	            ps.setString(3, o.getType());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("create : erreur sql : " + e.getMessage());

	        }
	        return false;
	}

	@Override
	public boolean delete(Salle o) {
		String sql = "delete from salle where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean update(Salle o) {
		 String sql = "update salle set code  = ? ,capacite = ? , type = ? where id  = ?";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setString(1, o.getCode());
	            ps.setInt(2,o.getCapacite());
	            ps.setString(3, o.getType());
	            ps.setInt(4, o.getId());
	            System.out.println("********");
	            System.out.println(o.getId());
	            System.out.println(o.getCode());
	            System.out.println(o.getCapacite());
	            System.out.println(o.getType());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("update : erreur sql : " + e.getMessage());

	        }
	        return false;
	}

	@Override
	public Salle findById(int id) {
		Salle m = null;
        String sql = "select * from salle where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Salle(rs.getInt("id"), rs.getString("code"), rs.getInt("capacite"),
                        rs.getString("type"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
	}

	@Override
	public List<Salle> findAll() {
		 List<Salle> salles = new ArrayList<Salle>();

	        String sql = "select * from salle";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	salles.add(new Salle(rs.getInt("id"), rs.getString("code"), rs.getInt("capacite"),
	                        rs.getString("type")));
	            }

	        } catch (SQLException e) {
	            System.out.println("findAll " + e.getMessage());
	        }
	        return salles;
	}

}

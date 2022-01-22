package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Creneau;
import beans.Salle;
import connexion.Connexion;
import dao.IDao;

public class CreneauService implements IDao<Creneau> {

	@Override
	public boolean create(Creneau o) {
		 String sql = "insert into Creneau values (null, ?, ?)";
	        try {
	        	System.out.println("avant prepare create");
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            System.out.println("apres prepare create");
	            ps.setTime(1, o.getHeureDebut());
	            ps.setTime(2,o.getHeureFin());
	            
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("create : erreur sql : " + e.getMessage());

	        }
	        return false;
	}

	@Override
	public boolean delete(Creneau o) {
		String sql = "delete from Creneau where id  = ?";
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
	public boolean update(Creneau o) {
		 String sql = "update Creneau set heureDebut = ? , heureFin = ? where id  = ?";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setTime(1, o.getHeureDebut());
	            ps.setTime(2,o.getHeureFin());
	            ps.setInt(3, o.getId());
	           
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("update : erreur sql : " + e.getMessage());

	        }
	        return false;
	}

	@Override
	public Creneau findById(int id) {
		Creneau m = null;
        String sql = "select * from Creneau where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Creneau(rs.getInt("id"), rs.getTime("heureDebut"), rs.getTime("heureFin"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
	}

	@Override
	public List<Creneau> findAll() {
		List<Creneau> crenoms = new ArrayList<Creneau>();

        String sql = "select * from Creneau";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	crenoms.add(new Creneau(rs.getInt("id"), rs.getTime("heureDebut"), rs.getTime("heureFin")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return crenoms;
	}

}

package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Creneau;
import beans.Occupation;
import connexion.Connexion;
import dao.IDao;

public class OccupationService implements IDao<Occupation> {
	private SalleService ss=new SalleService();
	private CreneauService cs=new CreneauService();
	private ClientService cls=new ClientService();
	@Override
	public boolean create(Occupation o) {
		 String sql = "insert into occupation values (?, ?, ?, ?)";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setInt(1, o.getSalle().getId());
	            ps.setInt(2,o.getCrenom().getId());
	            ps.setDate(3,new Date(o.getDate().getTime()));
	            ps.setInt(2,o.getClient().getId());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("create : erreur sql : " + e.getMessage());

	        }
	        return false;
	}

	@Override
	public boolean delete(Occupation o) {
		String sql = "delete from occupation where idSalle  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getSalle().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean update(Occupation o) {
		 String sql = "update occupation set date = ?  where idSalle  = ? AND idCrenom  = ?";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setDate(1, new Date(o.getDate().getTime()));
	            ps.setInt(2,o.getSalle().getId());
	            ps.setInt(3, o.getCrenom().getId());
	           
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("update : erreur sql : " + e.getMessage());

	        }
	        return false;
	}

	@Override
	public Occupation findById(int id) {
		Occupation m = null;
        String sql = "select * from occupation where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Occupation(rs.getDate("Date"),ss.findById( rs.getInt("idSalle")),cs.findById(rs.getInt("idCrenom")),cls.findById(rs.getInt("idClient")));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
	}

	@Override
	public List<Occupation> findAll() {
		List<Occupation> occupations = new ArrayList<Occupation>();

        String sql = "select * from occupation";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	occupations.add(new Occupation(rs.getDate("Date"),ss.findById( rs.getInt("idSalle")),cs.findById(rs.getInt("idCrenom")),cls.findById(rs.getInt("idClient"))));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return occupations;
	}

}

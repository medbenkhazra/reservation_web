package beans;

import java.sql.Time;
import java.util.Date;

public class reservation {
	private int id;
	private int nom;
    private int code;
	private int heureDeb;
	private int heureFin;
	private Date date;
    private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNom() {
		return nom;
	}
	public void setNom(int nom) {
		this.nom = nom;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getHeureDeb() {
		return heureDeb;
	}
	public void setHeureDeb(int heureDeb) {
		this.heureDeb = heureDeb;
	}
	public int getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public reservation(int nom, int code, int heureDeb,Date date,String status) {
		super();
		this.nom = nom;
		this.code = code;
		this.heureDeb = heureDeb;
		this.date = date;
		this.status = status;
	}
	
	public reservation(int id,int code, int nom, int heureDeb,Date date,String status) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
		this.heureDeb = heureDeb;
		this.date = date;
		this.status = status;

	}
	public reservation(int id,int code, int nom, int heureDeb, int heureFin,Date date,String status) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
		this.heureFin = heureFin;
		this.heureDeb = heureDeb;
		this.date = date;
		this.status = status;
	}
	@Override
	public String toString() {
		return "reservation [nom=" + nom + ", code=" + code + ", heureDeb=" + heureDeb + ", heureFin=" + heureFin
				+ ", date=" + date + "]";
	}
	
	
}

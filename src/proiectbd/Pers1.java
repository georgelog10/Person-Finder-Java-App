package proiectbd;

import java.util.Date;

public class Pers1 {
	
	private int cnp;
    private String nume;
    private String telefon;
    private String adresa;
    private String cetatenie;
    private Date datan;
	public Pers1(int cnp, String nume, String telefon, String adresa, String cetatenie, Date datan) {
		super();
		this.cnp = cnp;
		this.nume = nume;
		this.telefon = telefon;
		this.adresa = adresa;
		this.cetatenie = cetatenie;
		this.datan = datan;
	}
	public int getCnp() {
		return cnp;
	}
	public void setCnp(int cnp) {
		this.cnp = cnp;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getCetatenie() {
		return cetatenie;
	}
	public void setCetatenie(String cetatenie) {
		this.cetatenie = cetatenie;
	}
	public Date getDatan() {
		return datan;
	}
	public void setDatan(Date datan) {
		this.datan = datan;
	}
	
	
    
    

}


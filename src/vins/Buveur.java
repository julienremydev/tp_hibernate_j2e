
/**
 * @author gilles
 *
 */
package vins;

import java.util.Set;
import java.util.HashSet;

public class Buveur {

	private Long numeroBuv;
	private String nom;
	private String prenom;
	private Set abu = new HashSet();
	
	public Buveur(String unNom, String unPrenom) {
		nom=unNom;
		prenom=unPrenom;
	}
	public Buveur() { 
		
	}

	public Set getAbu() {
		return abu;
	}

	public void setAbu(Set bu) {
		abu = bu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getNumeroBuv() {
		return numeroBuv;
	}

	public void setNumeroBuv(Long numeroBuv) {
		this.numeroBuv = numeroBuv;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}

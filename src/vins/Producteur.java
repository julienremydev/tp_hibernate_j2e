package vins;

import java.util.HashSet;
import java.util.Set;

public class Producteur {
	private Long numero;

	private String nom;
	
	private String adresse;

	private Set<Vin> lesVins = new HashSet<>();
	
	public Producteur (String unNom, String uneAdresse) {
		nom = unNom;
		adresse = uneAdresse;
		}
		
		public Producteur() {
		}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Set<Vin> getLesVins() {
		return lesVins;
	}

	public void setLesVins(Set<Vin> lesVins) {
		this.lesVins = lesVins;
	}
	
}

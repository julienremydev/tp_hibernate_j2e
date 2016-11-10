package forum;

import java.util.HashSet;
import java.util.Set;


public class Annuaire {

	private String nom;
	private Set<Abonne> topic = new HashSet<Abonne>();
	
	public Annuaire(){}
	public Annuaire(String nom){
		this.setNom(nom);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Abonne> getTopic() {
		return topic;
	}
	public void setTopic(Set<Abonne> topic) {
		this.topic = topic;
	}
}

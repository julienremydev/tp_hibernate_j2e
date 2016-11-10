package forum;

public class Particulier extends Abonne{

	private String nom;
	private String prenom;
	
	public Particulier(){}
	public Particulier(String login, String mdp, String nom, String prenom) {
		super(login, mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


}

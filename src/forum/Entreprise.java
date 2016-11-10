package forum;

public class Entreprise extends Abonne{

	private String raisonSociale;
	
	public Entreprise(){}
	public Entreprise(String login, String mdp, String raisonSociale) {
		super(login, mdp);
		this.setRaisonSociale(raisonSociale);
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
}

package vins;

public class VinDeGarde extends Vin {
	private int nbAnneeMax;
	private int nbAnneeMin;
	public VinDeGarde() {
		
	}
	public int getNbAnneeMax() {
		return nbAnneeMax;
	}
	public void setNbAnneeMax(int nbAnneeMax) {
		this.nbAnneeMax = nbAnneeMax;
	}
	public int getNbAnneeMin() {
		return nbAnneeMin;
	}
	public void setNbAnneeMin(int nbAnneeMin) {
		this.nbAnneeMin = nbAnneeMin;
	}
	public VinDeGarde(String unNom, int annee, int nbBout, float prix, int nbAnneeMax, int nbAnneeMin) {
		super(unNom, annee, nbBout, prix);
		this.nbAnneeMax = nbAnneeMax;
		this.nbAnneeMin = nbAnneeMin;
	}
	
}

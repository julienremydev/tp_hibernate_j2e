package vins;

public abstract class Vin {

	private Long numero;

	private String nom;

	private int annee;

	private int nbBouteilles;

	private float prix;
        
        private Producteur producteur;
	

	public Vin (String unNom, int annee, int nbBout, float prix) {
	nom = unNom;
	this.annee = annee;
	nbBouteilles = nbBout;
	this.prix = prix;
	}
	
	public Vin() {
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getNbBouteilles() {
		return nbBouteilles;
	}

	public void setNbBouteilles(int nbBouteilles) {
		this.nbBouteilles = nbBouteilles;
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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}
        
        public Producteur getProducteur() {
        return producteur;
         }

        public void setProducteur(Producteur producteur) {
        this.producteur = producteur;
        }

}

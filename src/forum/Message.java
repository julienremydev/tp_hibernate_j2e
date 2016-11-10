package forum;

public class Message {

	private Long id_message;
	private String objet;
	private String corps;
	private Abonne abonne;
	
	public Message(){}
	public Message(String objet, String corps){
		this.setObjet(objet);
		this.setCorps(corps);
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}
	public Long getId_message() {
		return id_message;
	}
	public void setId_message(Long id_message) {
		this.id_message = id_message;
	}
	public Abonne getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}
}

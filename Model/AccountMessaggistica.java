package Model;

/**
 * Classe che memorizza gli attributi degli Account di Messaggistica.
 */
public class AccountMessaggistica {
	
	private String nickname;
	/**Fornitore: Il fornitore è la piattaforma sulla quale è salvatoL'account di messaggistica (es: whatsapp)*/
	private String fornitore;
	
	/** Email: L'email alla quale è associato l'accoun di messaggistica */
	private String email;
	
	/** Frase benvenuto: è la frase presente nei vari account scritta dall'utente proprietario dell'account. */
	private String frase_benvenuto;
	
	/** c: è la variabile del contatto */
	private Contatto c;
	
	/**
	 * Inizializzazione di un nuovo account di messaggistica.
	 *La modifica avviene in Place
	 * @param fo è il paramentro inserito dall'utente e si riferisce al fornitore
	 * @param em è il paramentro inserito dall'utente e si riferisce all'email
	 * @param fb è il è il paramentro inserito dall'utente e si riferisce alla frase di benvenuto
	 * @param co è il paramentro inserito dall'utente e si riferisce al contatto selezionato
	 */
	//metodi:
	public AccountMessaggistica(String nick, String fo, String em, String fb, Contatto co)
	{
		this.nickname= nick;
		this.fornitore= fo;
		this.email= em;
		this.frase_benvenuto= fb;
		this.c= co;
	}

	/**
	 * Gets and Sets per la variabile fornitore
	 *
	 * @return fornitore
	 */
	public String getFornitore() {
		return fornitore;
	}

	/**
	 * Metodo per settare un fornitore, passato come parametro, all'oggetto AccountMessaggistica attuale 
	 *
	 * @param fornitore
	 */
	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	/**
	 * Gets and sets per l'attributo email
	 *
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo per settare l'email, passata come parametro, all'oggetto AccountMessaggistica attuale 
	 *
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets and sets per l'attributo frase_benvenuto
	 *
	 * @return frase benvenuto
	 */
	public String getFrase_benvenuto() {
		return frase_benvenuto;
	}

	/**
	 *Metodo per settare una frase di benvenuto, passata come parametro, all'oggetto AccountMessaggistica attuale 
	 *
	 * @param frase_benvenuto
	 */
	public void setFrase_benvenuto(String frase_benvenuto) {
		this.frase_benvenuto = frase_benvenuto;
	}

	/**
	 * Gets and sets per l'attributo contatto
	 *
	 * @return contatto
	 */
	public Contatto getC() {
		return c;
	}

	/**
	 *Metodo per settare un contatto, passato come parametro, all'oggetto AccountMessaggistica attuale 
	 *
	 * @param c il contatto
	 */
	public void setC(Contatto c) {
		this.c = c;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString()
	{
		return "Nick: " + nickname + " Fornitore: " + fornitore;
	}
	public String getInfo()
	{
		return "Nick: " + nickname + ", Fornitore: " + fornitore + ", Email: " + email + ", Frase di Benvenuto: " + frase_benvenuto;
	}
}

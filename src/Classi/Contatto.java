package Classi;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Contatto.
 */
public class Contatto {
	
	/** il nome del contatto. */
	private String nome;
	
	/** il cognome del contatto. */
	private String cognome;
	
	/** l'et� del contatto. */
	private int et�;
	
	/** il sesso del contatto; potr� assumere solo tre valori Maschio, Femmina e non binario. */
	private String sesso;
	
	/** la residenza del contatto. */
	private String residenza;
	
	/** l'email del contatto. */
	private String email;
	
	/** I gruppi nei quali il contatto � contenuto. */
	private ArrayList<Gruppo> gruppi;
	
	/**Gli account di messagistica del contatto. */
	private ArrayList<AccountMessaggistica> accountm;
	
	/**La rubrica del contatto. */
	private Rubrica rub;
	
	/**Le chiamate effettuate con questo contatto. */
	private ArrayList <Chiamata> chiamate;
	
	/** I numeritelefonici fissi del contatto. */
	private ArrayList<NumeroTelefonoFisso> numeritelefonicif;
	
	/** I numeritelefonici mobili del contatto. */
	private ArrayList<NumeroTelefonoMobile> numeritelefonicim;
	
	/**
	 * Istanziazione di un nuovo contatto.
	 * L'inserimento � effettuato in place
	 *
	 * @param nome
	 * @param cognome
	 * @param et�
	 * @param sesso 
	 * @param indirizzo di residenza
	 * @param email
	 */
	public Contatto(String name, String surname, int age, String sex, String residence, String em, Rubrica r)
	{
		this.nome= name;
		this.cognome= surname;
		this.et�= age;
		this.sesso= sex;
		this.residenza= residence;
		this.email= em;
		this.rub= r;
		numeritelefonicif = new ArrayList<NumeroTelefonoFisso>();
		numeritelefonicim = new ArrayList<NumeroTelefonoMobile>();	
		accountm = new ArrayList<AccountMessaggistica>();
		gruppi = new ArrayList<Gruppo>();
		chiamate = new ArrayList<Chiamata>();
	}
	
	/**
	* Gets and Sets della variabile rubrica.
	 *
	 * @return nome
	 */

	public Rubrica getRub() {
		return rub;
	}
	
	public void setRub(Rubrica rub) {
		this.rub = rub;
	}
	
	/**
	 * Gets and Sets della variabile nome del contatto.
	 * @return nome
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param n the new nome
	 */
	public void setNome(String n)
	{
		nome = n;
	}
	
	/**
	 * Gets and Sets della variabile cognome del contatto.
	 *
	 * @return cognome
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Setta il cognome
	 *
	 * @param c: stringa contenente il cognome
	 */
	public void setCognome(String c) {
		cognome = c;
	}
	
	/**
	 * Gets and Sets della variabile et� del contatto.
	 *
	 * @return et�
	 */
	public int getEt�() {
		return et�;
	}
	
	/**
	 * Setta l'et�
	 *
	 * @param e: intero contenente l'et� del contatto
	 */
	public void setEt�(int e) {
		et� = e;
	}
	
	/**
	 * Gets and Sets della variabile sesso del contatto.
	 *
	 * @return sesso
	 */
	public String getSesso() {
		return sesso;
	}
	
	/**
	 * Setta il sesso
	 *
	 * @param s: stringa contenente il sesso del contatto
	 */
	public void setSesso(String s) {
		sesso = s;
	}
	
	/**
	 * Gets and Sets della variabile residenza del contatto.
	 *
	 * @return residenza
	 */
	public String getResidenza() {
		return residenza;
	}
	
	/**
	 * Setta la residenza.
	 *
	 * @param r: stringa contenente la residenza del contatto
	 */
	public void setResidenza(String r) {
		this.residenza = r;
	}
	
	/**
	 * Gets and Sets della variabile email del contatto.
	 *
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setta l'email.
	 *
	 * @param e: stringa contenente l'email dell'utente
	 */
	public void setEmail(String e) {
		email = e;
	}
	
	/**
	 * Gets and Sets della variabile gruppi del contatto.
	 * @return gruppi
	 */
	public Gruppo getGruppi(int index) {
		return gruppi.get(index);
	}
	
	/**
	 * Setta il gruppi.
	 *
	 * @param g the new gruppi
	 */
	public void setGruppi(Gruppo g) {
		this.gruppi.add(g);
		g.setContatti(this);
	}
	
	/**
	 * Gets and Sets dell' array che contiene gli account di messaggistica del contatto.
	 * @return Array di account
	 */
	public ArrayList<AccountMessaggistica> getAccountm() {
		return this.accountm;
	}
	
	/**
	 * Setta l'array degli account di messaggistica
	 *
	 * @param am: stringa contenente l'account di messaggistica
	 */
	public void setAccountm(AccountMessaggistica am) {
		this.accountm.add(am);
		am.setC(this);
	}
	
	/**
	 * Gets and Sets dell'array che contiene le chiamate con il contatto.
	 * @return array di chiamate
	 */
	public Chiamata getChiamate(int index) {
		return chiamate.get(index);
	}
	
	/**
	 * Chiama.
	 */
	public void chiama() {
		
	}
	
	/**
	* Gets and Sets della variabile NumeritelefoniciF del contatto.
	 *
	 * @return il numeritelefonico fisso
	 */
	public ArrayList<NumeroTelefonoFisso> getNumeritelefonicif() {
		return numeritelefonicif;
	}
	
	/**
	 * Setta il numeritelefonico fisso.
	 *
	 * @param nt: stringa contenente il numeritelefonico fisso da aggiungere a numeri telefonici
	 */
	public void setNumeritelefonicif(NumeroTelefonoFisso nt) {
		numeritelefonicif.add(nt);
	}
	
	/**
	 * Gets and Sets della variabile NumeritelefoniciM del contatto.
	 *
	 * @return il numero telefonico mobile
	 */
	public ArrayList<NumeroTelefonoMobile> getNumeritelefonicim() {
		return numeritelefonicim;
	}
	
	/**
	 * Setta il numeritelefonico mobile.
	 *
	 * @param nt: stringa contenente il numeritelefonico mobile da aggiungere a numeri telefonici
	 **/
	public void setNumeritelefonicifm(NumeroTelefonoMobile nt) {
		this.numeritelefonicim.add(nt);
		nt.setContatti(this);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString()
	{
		return nome + " " + cognome;
	}
	
	/**
	 * Gets the info.
	 *
	 * @return the info
	 */
	public String getInfo()
	{
		return nome + ", " + cognome + ", " + email + ", " + et� + ", " + sesso + ", " + residenza + ".";
	}
}
package Classi;

import java.util.ArrayList;

public class Contatto {
	//attributi:
	private String nome;
	private String cognome;
	private int età;
	private char sesso;
	private String residenza;
	private String email;
	
	private Rubrica rub;
	private ArrayList<Gruppo> gruppi;
	private ArrayList<AccountMessaggistica> accountm;
	private ArrayList <Chiamata> chiamate;
	private ArrayList<NumeroTelefono> numeritelefonici;
	//metodi:
	public Contatto(String name, String surname, int age, char sex, String residence, String em, Rubrica r)
	{
		this.nome= name;
		this.cognome= surname;
		this.età= age;
		this.sesso= sex;
		this.residenza= residence;
		this.email= em;
		this.rub= r;
	}
	public String getNome()
	{
		return this.nome;
	}
	public void setNome(String n)
	{
		this.nome = n;
	}
	public String getCognome() {
		return this.cognome;
	}
	public void setCognome(String c) {
		this.cognome = c;
	}
	public int getEtà() {
		return this.età;
	}
	public void setEtà(int e) {
		this.età = e;
	}
	public char getSesso() {
		return this.sesso;
	}
	public void setSesso(char s) {
		this.sesso = s;
	}
	public String getResidenza() {
		return this.residenza;
	}
	public void setResidenza(String r) {
		this.residenza = r;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String e) {
		this.email = e;
	}
	
	
	public Rubrica getRub() {
		return rub;
	}
	public void setRub(Rubrica rub) {
		this.rub = rub;
	}
	public Gruppo getGruppi(int index) {
		return gruppi.get(index);
	}
	public void setGruppi(Gruppo g) {
		this.gruppi.add(g);
		g.setContatti(this);
	}
	public AccountMessaggistica getAccountm(int index) {
		return accountm.get(index);
	}
	public void setAccountm(AccountMessaggistica am) {
		this.accountm.add(am);
		am.setC(this);
	}
	public Chiamata getChiamate(int index) {
		return chiamate.get(index);
	}
	public void chiama() {
		
		
	}
	public NumeroTelefono getNumeritelefonici(int index) {
		return numeritelefonici.get(index);
	}
	public void setNumeritelefonici(NumeroTelefono nt) {
		this.numeritelefonici.add(nt);
	}

}
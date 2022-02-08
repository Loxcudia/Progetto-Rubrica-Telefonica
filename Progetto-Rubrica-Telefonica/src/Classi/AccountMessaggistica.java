package Classi;

import java.util.ArrayList;

public class AccountMessaggistica {
	//attributi:
	private String fornitore;
	private String email;
	private String frase_benvenuto;
	private Contatto c;
	
	//metodi:
	public AccountMessaggistica(String fo, String em, String fb, Contatto co)
	{
		this.fornitore= fo;
		this.email= em;
		this.frase_benvenuto= fb;
		this.c= co;
	}

	public String getFornitore() {
		return fornitore;
	}

	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFrase_benvenuto() {
		return frase_benvenuto;
	}

	public void setFrase_benvenuto(String frase_benvenuto) {
		this.frase_benvenuto = frase_benvenuto;
	}

	public Contatto getC() {
		return c;
	}

	public void setC(Contatto c) {
		this.c = c;
	}
}

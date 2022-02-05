/*
 * 
 */
package Controller;

import Classi.Rubrica;

import java.util.ArrayList;

import Classi.Contatto;
import Classi.NumeroTelefonoFisso;
import Classi.NumeroTelefonoMobile;

/**
 * The Class Controller.
 */
public class Controller {
	
	/** 'r' sarà la variabile della nostra rubrica. */
	Rubrica r;
	/**
	 * inizializzazione della rubrica
	 */
	public Controller()
	{
		r= new Rubrica("Rubrica");
	}
	
	
	/**
	 *addContatto è la funzione che aggiunge il contatto inserito dall'utente nella classe CreaC delle GUI nella rubrica 
	 *
	 * @param nome del contatto aggiunto
	 * @param cognome del contatto aggiunto
	 * @param età del contatto aggiunto
	 * @param sesso del contatto aggiunto
	 * @param residenza del contatto aggiunto
	 * @param email del contatto aggiunto
	 * @param numf : numero fisso del contatto aggiunto
	 * @param numb : numero mobile del contatto aggiunto
	 */
	public void addContatto(String nome, String cognome, int eta, String sesso, String residenza, String email, String numf, String numb)
	{
		/**
		 *@if questo controllo serve a non far aggiungere alla rubrica gli utenti ai quali non è stato inserito 
		 *il numero di telefono fisso e quello mobile e almeno una variabile tra il nome e il cognome.
		 *la modifica avviene in place
		 */
		if ((((!nome.isBlank())||(!cognome.isBlank()))&&(!numf.isBlank())&&(!numb.isBlank())))
		{
			r.aggiungiContatto(nome, cognome, eta, sesso, residenza, email, this.r, numf, numb);
		}
	}

	public ArrayList<Contatto> getRubricaContatti()
	{
		return r.contatti;
	}
	
	/**
	 * Metodo che chiama la funzione "getRubricaOrdinataDesc" 
	 * che ordinerà l'array di contatti in ordine alfabetico decrescente.
	 *
	 * @return ritorna la rubrica ordinata in maniera decrescente
	 */
	public Rubrica getRubricaOrdinataDesc()
	{
		r.mostraContattiPer("Decrescente");
		return r;
	}
	
	/**
	 * Metodo che chiama la funzione "getRubricaOrdinataCresc" 
	 * che ordinerà l'array di contatti in ordine alfabetico crescente.
	 *
	 * @return ritorna la rubrica ordinata in maniera crescente
	 */
	public Rubrica getRubricaOrdinataCresc()
	{
		r.mostraContattiPer("Crescente");
		return r;
	}
	
	/**
	 *Metodo che chiama la funzione "getNumeritelefonicif()" che restituisce i numeri telefonici fissi di un contatto passato come parametro
	 *
	 * @param in: è il contatto selezionato tramite l'interfaccia grafica dall'utente
	 * @return i numeri telefono fissi del contatto passato come parametro
	 */
	public ArrayList<NumeroTelefonoFisso> getContattiNumeriTelefonoFissi(Contatto in)
	{
		return in.getNumeritelefonicif();
	}
	
	/**
	 * Metodo che chiama la funzione "getNumeritelefonicim()" che restituisce i numeri telefonici mobili di un contatto passato come parametro
	 *
	 * @param in: è il contatto selezionato tramite l'interfaccia grafica dall'utente
	 * @return i numeri telefono mobili del contatto passato come parametro
	 */
	public ArrayList<NumeroTelefonoMobile> getContattiNumeriTelefonoMobili(Contatto in)
	{
		return in.getNumeritelefonicim();
	}
}
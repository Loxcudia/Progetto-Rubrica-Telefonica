/*
 * 
 */
package Controller;

import Classi.Rubrica;

import java.util.ArrayList;

import Classi.AccountMessaggistica;
import Classi.Contatto;
import Classi.NumeroTelefonoFisso;
import Classi.NumeroTelefonoMobile;

/**
 * The Class Controller.
 */
public class Controller {
	
	/** 'r' sar� la variabile della nostra rubrica. */
	Rubrica r;
	/**
	 * inizializzazione della rubrica
	 */
	public Controller()
	{
		r= new Rubrica("Rubrica");
	}
	
	
	/**
	 *addContatto � la funzione che aggiunge il contatto inserito dall'utente nella classe CreaC delle GUI nella rubrica 
	 *
	 * @param nome del contatto aggiunto
	 * @param cognome del contatto aggiunto
	 * @param et� del contatto aggiunto
	 * @param sesso del contatto aggiunto
	 * @param residenza del contatto aggiunto
	 * @param email del contatto aggiunto
	 * @param numf : numero fisso del contatto aggiunto
	 * @param numb : numero mobile del contatto aggiunto
	 */
	public void addContatto(String nome, String cognome, int eta, String sesso, String residenza, String email, String numf, String numb, ArrayList<String> numeriS, ArrayList<AccountMessaggistica> am)
	{
		/**
		 *@if questo controllo serve a non far aggiungere alla rubrica gli utenti ai quali non � stato inserito 
		 *il numero di telefono fisso e quello mobile e almeno una variabile tra il nome e il cognome.
		 *la modifica avviene in place
		 */
		if ((((!nome.isBlank())||(!cognome.isBlank()))&&(!numf.isBlank())&&(!numb.isBlank())))
		{
			r.aggiungiContatto(nome, cognome, eta, sesso, residenza, email, this.r, numf, numb, numeriS, am);
		}
	}
	
	public ArrayList<Contatto> getRubricaContatti()
	{
		return r.contatti;
	}
	public ArrayList<AccountMessaggistica> getContattoAccountMessaggistica(Contatto in)
	{
		return in.getAccountm();
	}
	/**
	 * Metodo che chiama la funzione "getRubricaOrdinataDesc" 
	 * che ordiner� l'array di contatti in ordine alfabetico decrescente.
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
	 * che ordiner� l'array di contatti in ordine alfabetico crescente.
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
	 * @param in: � il contatto selezionato tramite l'interfaccia grafica dall'utente
	 * @return i numeri telefono fissi del contatto passato come parametro
	 */
	public ArrayList<NumeroTelefonoFisso> getContattiNumeriTelefonoFissi(Contatto in)
	{
		return in.getNumeritelefonicif();
	}
	
	/**
	 * Metodo che chiama la funzione "getNumeritelefonicim()" che restituisce i numeri telefonici mobili di un contatto passato come parametro
	 *
	 * @param in: � il contatto selezionato tramite l'interfaccia grafica dall'utente
	 * @return i numeri telefono mobili del contatto passato come parametro
	 */
	public ArrayList<NumeroTelefonoMobile> getContattiNumeriTelefonoMobili(Contatto in)
	{
		return in.getNumeritelefonicim();
	}
	
	public boolean addNumeroContatto(Contatto coin, NumeroTelefonoFisso ntfin, NumeroTelefonoMobile nmtin)
	{
		for(int i = 0; i < r.contatti.size(); i++)
		{
			if(r.contatti.get(i) == coin)
			{
				if(ntfin == null)
				{
					if(isNumeric(nmtin.getNumero()) == true)
					{
						r.contatti.get(i).setNumeritelefonicifm(nmtin);
						return true;
					}
					else
					{
						return false;
					}
				}
				else if(nmtin == null)
				{
					if(isNumeric(ntfin.getNumero()) == true)
					{
						r.contatti.get(i).setNumeritelefonicif(ntfin);
						return true;
					}
					else
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	public void addAccountMessaggisticaContatto(Contatto cin, AccountMessaggistica amin)
	{
		for(int i = 0; i < r.contatti.size(); i++)
		{
			if(r.contatti.get(i) == cin)
			{
				r.contatti.get(i).setAccountm(amin);
			}
		}
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}

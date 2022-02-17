package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 *Classe Rubrica.
 */
public class Rubrica {
	
	/**Array list contatti. */
	public ArrayList <Contatto> contatti= new ArrayList<Contatto>();
	
	/** Array list gruppi. */
	public ArrayList<Gruppo> gruppi= new ArrayList<Gruppo>();
	
	/** nome dell'utente. */
	public String nome;
	
	/**
	 * Instanzazione della rubrica
	 *
	 * @param n: stringa presa in imput 
	 */
	public Rubrica(String n)
	{
		this.nome = n;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * getContatti
	 *
	 * @param index: indice definito
	 * @return il contatto dall'array contatti di indice index 
	 */
	public ArrayList<Contatto> getContatti() {
		return contatti;
	}

	/**
	 * Setta il .
	 *
	 * @param c: contatto
	 */
	public void setContatti(Contatto c) {
		this.contatti.add(c);
		c.setRub(this);
	}
	
	/**
	 * Gets the gruppi.
	 *
	 * @param index the index
	 * @return the gruppi
	 */
	public Gruppo getGruppi(int index) {
		return gruppi.get(index);
	}

	/**
	 * Sets the gruppi.
	 *
	 * @param g the new gruppi
	 */
	public void setGruppi(Gruppo g) {
		this.gruppi.add(g);
		g.setR(this);
	}
	
	/**
	 * Aggiungi contatto.
	 *
	 * @param nome: il nome del contatto da aggiungere
	 * @param il: cognome del contatto da aggiungere
	 * @param età: l'età del contatto da aggiungere
	 * @param sesso:il sesso  del contatto da aggiungere
	 * @param residenza: la residenza del contatto da aggiungere
	 * @param email: l'email del contatto da aggiungere
	 * @param r: l'ogetto rubrica che si sta usando
	 * @param numf: il numero di telefono fisso 
	 * @param nummob: il numero di telefono mobile
	 */
	public void aggiungiContatto(String nome, String cognome, String età, String sesso, String residenza, String email, Rubrica r, String numf, String nummob, ArrayList<String> ns, ArrayList<AccountMessaggistica> am)
	{
		NumeroTelefonoFisso n1 = new NumeroTelefonoFisso(numf);
		NumeroTelefonoMobile n2 = new NumeroTelefonoMobile(nummob);
		Contatto c = new Contatto(nome, cognome, età, sesso, residenza, email, this);
		contatti.add(c);
		contatti.get(contatti.size() - 1).setNumeritelefonicif(n1);
		contatti.get(contatti.size() - 1).setNumeritelefonicifm(n2);
		for(int i = 0; i < ns.size(); i++)
		{
			if(ns.get(i).charAt(0) == 'F')
			{
				String x = ns.get(i);
				x = x.replace("F", "");
				NumeroTelefonoFisso nf = new NumeroTelefonoFisso(x);
				contatti.get(contatti.size() - 1).setNumeritelefonicif(nf);
			}
			else
			{
				String x = ns.get(i);
				x = x.replace("M", "");
				NumeroTelefonoMobile nm = new NumeroTelefonoMobile(x);
				contatti.get(contatti.size() - 1).setNumeritelefonicifm(nm);
			}
		}
		for(int i = 0; i < am.size(); i++)
		{
			contatti.get(contatti.size() - 1).setAccountm(am.get(i));
		}
	}
	
	/**
	 * Elimina contatto.
	 *
	 * @param c: il contatto selezionato dall'utente che verrà eliminato dall'array list contatti
	 */
	public void eliminaContatto(Contatto c)
	{
		for(int i=0; i < contatti.size() - 1; i++)
		{
			if(c == contatti.get(i))
			{
				contatti.remove(contatti.get(i));
			}
		}
	}

	/**
	 * Aggiungi gruppo.
	 *
	 * @param nome the nome
	 * @param r the r
	 */
	public void aggiungiGruppo(String nome, Rubrica r, ArrayList<Contatto> in)
	{
		Gruppo g = new Gruppo(nome, this);
		gruppi.add(g);
		for(int i = 0; i < in.size(); i++)
		{
			g.setContatti(in.get(i));
		}
	}
	
	/**
	 * Elimina gruppo.
	 *
	 * @param g the g
	 */
	public void eliminaGruppo(Gruppo g)
	{
		for(int i=0; i < gruppi.size(); i++)
		{
			if(g == gruppi.get(i))
			{
				gruppi.remove(gruppi.get(i));
			}
		}
	}

	/**
	 * Mostra contatti per è un metodo che ordina la rubrica in ordine crescente o decrescente 
	 * usando la funzione Collection.sort
	 *
	 * @param scelta: scelta può assumere solo 2 valori, crescente e decrescente
	 */
	public void mostraContattiPer(String scelta)
	{
		switch(scelta)
		{
				case "Crescente":
					Collections.sort(contatti, new Comparator<Contatto>() {
						   @Override
						   public int compare(Contatto o1, Contatto o2) {
						      return o1.getNome().compareTo(o2.getNome());
						   }
						});
					break;

				case "Decrescente":
					Collections.sort(contatti, new Comparator<Contatto>() {
						   @Override
						   public int compare(Contatto o1, Contatto o2) {
						      return o2.getNome().compareTo(o1.getNome());
						   }
						});
					break; 
					}
	}
	

}

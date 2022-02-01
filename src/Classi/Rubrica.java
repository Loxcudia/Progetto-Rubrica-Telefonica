package Classi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Rubrica {
	//attributi:
	public ArrayList <Contatto> contatti= new ArrayList<Contatto>();
	public ArrayList<Gruppo> gruppi= new ArrayList<Gruppo>();
	public String nome;
	
	//metodi:
	public Rubrica(String n)
	{
		this.nome = n;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contatto getContatti(int index) {
		return contatti.get(index);
	}

	public void setContatti(Contatto c) {
		this.contatti.add(c);
		c.setRub(this);
	}
	public Gruppo getGruppi(int index) {
		return gruppi.get(index);
	}

	public void setGruppi(Gruppo g) {
		this.gruppi.add(g);
		g.setR(this);
	}
	public void aggiungiContatto(String nome, String cognome, int età, String sesso, String residenza, String email, Rubrica r, String numf, String nummob)
	{
		NumeroTelefonoFisso n1 = new NumeroTelefonoFisso(numf);
		NumeroTelefonoMobile n2 = new NumeroTelefonoMobile(nummob);
		Contatto c = new Contatto(nome, cognome, età, sesso, residenza, email, this);
		contatti.add(c);
		contatti.get(contatti.size() - 1).setNumeritelefonicif(n1);
		contatti.get(contatti.size() - 1).setNumeritelefonicifm(n2);
	}
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

	public void aggiungiGruppo(String nome, Rubrica r)
	{
		Gruppo g = new Gruppo(nome, this);
		gruppi.add(g);
	}
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

	public void mostraContattiPer(String scelta)
	{
		boolean scambio;
		Contatto tmp = null;
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

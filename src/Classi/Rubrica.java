package Classi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Rubrica {
	//attributi:
	public ArrayList <Contatto> contatti;
	public ArrayList<Gruppo> gruppi;
	public String nome;
	
	//metodi:
	public Rubrica(String n)
	{
		this.nome = n;
		Contatto t2= new Contatto("Claudio", "Simonelli", 22, "M", "Torre del Greco", "porf", this);
		Contatto t = new Contatto("Gianluca","Perna" , 20, "M", "Portici", "porfy", this);
		contatti = new ArrayList<Contatto>();
		gruppi = new ArrayList<Gruppo>();
		contatti.add(t);
		contatti.add(t2);
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
	public void modificaContatto(Contatto c, String scelta, String change)
	{
		for(int i=0; i < contatti.size() - 1; i++)
		{
			if(c == contatti.get(i))
			{
				switch(scelta)
				{
					case "Nome":
						contatti.get(i).setNome(change);
						break;
					case "Cognome":
						contatti.get(i).setCognome(change);
						break;
					case "Età":
						int x= Integer.parseInt(change);
						contatti.get(i).setEtà(x);
						break;
					case "Email":
						contatti.get(i).setEmail(change);
						break;
					case "Residenza":
						contatti.get(i).setResidenza(change);
						break;
					case "Sesso":
						contatti.get(i).setSesso(change);
						break;
				}
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
					/*if(contatti.size() > 1)
					{
						
						do {
								scambio=false;
								for(int i=0; i < contatti.size()-1; i++)
								{
									if(contatti.get(i).getCognome().compareTo(contatti.get(i+1).getCognome()) < 0) {
										tmp = contatti.get(i);
										contatti.set(i, contatti.get(i+1));
										contatti.set(i+1, tmp);
										scambio=true;
									}
								}
						} while (scambio);
					
					}*/
					Collections.sort(contatti, new Comparator<Contatto>() {
						   @Override
						   public int compare(Contatto o1, Contatto o2) {
						      return o1.getNome().compareTo(o2.getNome());
						   }
						});
					break;

				case "Decrescente":
					/*Contatto tmp2 = null;
					if(contatti.size() > 1)
					{
						do {
							scambio=false;
							for(int i=0; i < contatti.size()-1; i++)
							{
								if(contatti.get(i).getNome().compareTo(contatti.get(i+1).getNome()) > 0) {
									tmp = contatti.get(i);
									contatti.set(i, contatti.get(i+1));
									contatti.set(i+1, tmp2);
									scambio=true;
								}
							}
						} while (scambio);
					}*/
					Collections.sort(contatti, new Comparator<Contatto>() {
						   @Override
						   public int compare(Contatto o1, Contatto o2) {
						      return o2.getNome().compareTo(o1.getNome());
						   }
						});
					break; 
					}
	}
	
	
	
	/*public void eliminaDuplicati()
	{
		//ArrayList<Contatto> contatti2 = (ArrayList<Contatto>) contatti.clone();
		/*ArrayList<Contatto> contatti2 = new ArrayList<>(contatti);
		for(int i=0; i < contatti.size(); i++)
		{
			for(int j=i+1; j < contatti2.size(); j++)
			{
				if(contatti.get(i) == contatti2.get(j))
				{
					contatti.remove(i);
					contatti2.remove(j);
				}
			}
		}
		contatti = new ArrayList<>(new LinkedHashSet<Contatto>(contatti));
	}*/



}

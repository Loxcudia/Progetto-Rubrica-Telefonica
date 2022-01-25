package Classi;

import java.util.ArrayList;
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
	public void aggiungiContatto(String nome, String cognome, int età, char sesso, String residenza, String email, Rubrica r)
	{
		Contatto c = new Contatto(nome, cognome, età, sesso, residenza, email, this);
		contatti.add(c);
	}
	public void eliminaContatto(Contatto c)
	{
		for(int i=0; i < contatti.size(); i++)
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
		switch(scelta)
		{
				case "cognome":
					Contatto tmp = null;
					if(contatti.size() > 1)
					{
						for(int x=0; x < contatti.size(); x++)
						{
							for(int i=0; i < contatti.size()-x-1; i++)
							{
								if(contatti.get(i).getCognome().compareTo(contatti.get(i+1).getCognome()) < 0)
									tmp = contatti.get(i);
									contatti.set(i, contatti.get(i+1));
									contatti.set(i+1, tmp);
							}
						}
					}
					break;
				case "nome":
					Contatto tmp2 = null;
					if(contatti.size() > 1)
					{
						for(int x=0; x < contatti.size(); x++)
						{
							for(int i=0; i < contatti.size()-x-1; i++)
							{
								if(contatti.get(i).getNome().compareTo(contatti.get(i+1).getNome()) < 0)
									tmp = contatti.get(i);
									contatti.set(i, contatti.get(i+1));
									contatti.set(i+1, tmp2);
							}
						}
					}
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




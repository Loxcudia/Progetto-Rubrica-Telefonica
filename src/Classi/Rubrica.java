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
		Contatto t = new Contatto("Gianluca","Perna" , 20, "M", "Portici", "porfy", this);
		contatti = new ArrayList<Contatto>();
		gruppi = new ArrayList<Gruppo>();
		contatti.add(t);
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
	public void aggiungiContatto(String nome, String cognome, int et�, String sesso, String residenza, String email, Rubrica r, String numf, String nummob)
	{
		NumeroTelefonoFisso n1 = new NumeroTelefonoFisso(numf);
		NumeroTelefonoMobile n2 = new NumeroTelefonoMobile(nummob);
		Contatto c = new Contatto(nome, cognome, et�, sesso, residenza, email, this);
		contatti.add(c);
		contatti.get(contatti.size() - 1).setNumeritelefonicif(n1);
		contatti.get(contatti.size() - 1).setNumeritelefonicifm(n2);
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
	
	public void scambiaContatti(int i) 
	{
		Contatto tmp;
		tmp = contatti.get(i);
		contatti.set(i, contatti.get(i+1));
		contatti.set(i+1, tmp);
	}

	
	public void mostraContattiPer(String scelta)
	{
		boolean scambio;
		Contatto tmp = null;
		switch(scelta)
		{
				case "Crescente":
					if(contatti.size() > 1)
					{
						{
						do {
								scambio=false;
								for(int i=0; i < contatti.size()-1; i++)
								{
									if(contatti.get(i).getCognome().compareTo(contatti.get(i+1).getCognome()) < 0)
										tmp = contatti.get(i);
										contatti.set(i, contatti.get(i+1));
										contatti.set(i+1, tmp);
									{
										scambiaContatti(i); 
										scambio=true;
									}
								}
						} while (scambio);
					}
					break; }

				case "Decrescente":
					Contatto tmp2 = null;
					if(contatti.size() > 1)
					{
						do {
							scambio=false;
							for(int i=0; i < contatti.size()-1; i++)
							{
								if(contatti.get(i).getNome().compareTo(contatti.get(i+1).getNome()) > 0)
									tmp = contatti.get(i);
									contatti.set(i, contatti.get(i+1));
									contatti.set(i+1, tmp2);
								{	
									scambiaContatti(i); 
									scambio=true;
								}
							}
						} while (scambio);
					}
					break;}
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




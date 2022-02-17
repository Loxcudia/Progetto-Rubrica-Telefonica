package Model;

import java.util.ArrayList;

public class Gruppo {
	//attributi:
	private String nome;
	private ArrayList<Contatto> contatti;
	private Rubrica r;
	//metodi:
	public Gruppo(String name, Rubrica rub)
	{
		this.nome= name;
		this.r= rub;
		this.contatti = new ArrayList<>();
	}
	public void aggiungiContatto(String nome, String cognome, String età, String sesso, String residenza, String email, Rubrica ru)
	{
		Contatto c = new Contatto(nome, cognome, età, sesso, residenza, email, ru);
		contatti.add(c);
	}
	public void eliminaContatto(Contatto c)
	{
		for(int i=0; i < contatti.size(); i++)
		{
			if(contatti.get(i) == c)
			{
				contatti.remove(contatti.get(i));
			}
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Contatto> getContatti() {
		return contatti;
	}
	public void setContatti(Contatto c) {
		this.contatti.add(c);
	}
	public Rubrica getR() {
		return r;
	}
	public void setR(Rubrica r) {
		this.r = r;
	}
	@Override
	public String toString()
	{
		return nome;
	}
}
package Classi;

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
	}
	public void aggiungiContatto()
	{
		
	}
	public void eliminaContatto()
	{
		
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
		c.setGruppi(this);
	}
	public Rubrica getR() {
		return r;
	}
	public void setR(Rubrica r) {
		this.r = r;
	}
}
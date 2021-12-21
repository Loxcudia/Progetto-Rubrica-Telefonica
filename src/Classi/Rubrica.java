package Classi;

import java.util.ArrayList;

public class Rubrica {
	//attributi:
	private ArrayList <Contatto> contatti;
	private String nome;
	
	
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
	
}
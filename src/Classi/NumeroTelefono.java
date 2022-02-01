package Classi;

import java.util.ArrayList;

public class NumeroTelefono {
	//attributi:
	public String numero;
	public ArrayList<Contatto> contatti = new ArrayList<>();
	//metodi:
	public NumeroTelefono(String num)
	{
		this.numero= num;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Contatto getContatti(int index) {
		return contatti.get(index);
	}
	public void setContatti(Contatto c) {
		this.contatti.add(c);
	}
	@Override
	public String toString()
	{
		return numero;
	}
}
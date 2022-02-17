package Model;

import java.util.ArrayList;

/**
 * La classe NumeroTelefono è la generalizzazione delle classi figlie NumeroTelefonoFisso e NumeroTelefonoMobile
 */
public class NumeroTelefono {
	
	/** variabile che contiene il numero telefonico */
	public String numero;
	
	/** array di oggetti "contatto" che contiene i vari contatti. */
	public ArrayList<Contatto> contatti = new ArrayList<>();
	
	/**
	 * Istanziazione del numero telefonico
	 *
	 * @param num viene memorizzato nella variabile numero dell'oggetto attuale
	 */
	public NumeroTelefono(String num)
	{
		numero= num;
	}
	
	/**
	 * il metodo ritorna il numero telefonico
	 *
	 * @return numero telefonico
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Setta numero con il valore del parametro
	 *
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Gets contatti.
	 *
	 * @param index: un indice specifico
	 * @return l'ogetto conatti di indice index
	 */
	public Contatto getContatti(int index) {
		return contatti.get(index);
	}
	
	/**
	 * aggiunge il contatto all'array di contatti.
	 *
	 * @param c: contatto
	 */
	public void setContatti(Contatto c) {
		contatti.add(c);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString()
	{
		return numero;
	}
}
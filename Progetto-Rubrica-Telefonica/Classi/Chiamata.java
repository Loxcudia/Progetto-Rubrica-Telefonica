package Classi;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La Classe Chiamata, si riferisce alla chiamata tra 2 contatti.
 */
public class Chiamata {
	
	/** La data di inizio chiamata. */
	//attributi:
	private LocalDate data_inizio;
	
	/** La data di fine chiamata. */
	private LocalDate data_fine;
	
	/** l'ora di inizio chiamata. */
	private LocalTime ora_inizio;
	
	/** l'ora di fine chiamata. */
	private LocalTime ora_fine;
	
	/** il numero chiamante. */
	private Contatto numero_chiamante;
	
	/** il numero chiamato. */
	private Contatto numero_chiamato;
	
	/**
	 * Istanziare la chiamata effettuata.
	 *
	 * @param di: data inizio
	 * @param df: data fine
	 * @param oi: ora inizio
	 * @param of: ora fine
	 * @param nchiamato: numero chiamato
	 * @param nchiamante: numero chiamante
	 */
	//metodi:
	public Chiamata(LocalDate di, LocalDate df, LocalTime oi, LocalTime of, Contatto nchiamato, Contatto nchiamante)
	{
		this.data_inizio= di;
		this.data_fine= df;
		this.ora_inizio= oi;
		this.ora_fine= of;
		this.numero_chiamante= nchiamante;
		this.numero_chiamato= nchiamato;
	}
	/**
	 * Gets and Sets della variabile data inizio.
	 *
	 * @return data inizio
	 */
	public LocalDate getData_inizio() {
		return data_inizio;
	}
	
	/**
	  * Metodo per settare una data di inizio chiamata, passato come parametro, 
	  * all'oggetto attuale Chiamata
	 * @param data_inizio
	 */
	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}
	
	/**
	  * Gets and Sets della variabile data fine.
	 *
	 * @return data fine
	 */
	public LocalDate getData_fine() {
		return data_fine;
	}
	
	/**
	 * Metodo per settare una data fine, passato come parametro, all'oggetto attuale chiamata
	 *
	 * @param data_fine
	 */
	public void setData_fine(LocalDate data_fine) {
		this.data_fine = data_fine;
	}
	
	/**
	  * Gets and Sets della variabile ora inizio.
	 *
	 * @return ora inizio
	 */
	public LocalTime getOra_inizio() {
		return ora_inizio;
	}
	
	/**
	 * Metodo per settare un'oradi inizio, passato come parametro, all'oggetto attuale chiamata.
	 *
	 * @param ora_inizio.
	 */
	public void setOra_inizio(LocalTime ora_inizio) {
		this.ora_inizio = ora_inizio;
	}
	
	/**
	 * Gets and Sets della variabile ora fine.
	 *
	 * @return ora fine
	 */
	public LocalTime getOra_fine() {
		return ora_fine;
	}
	
	/**
	 * Metodo per settare un'ora di fine, passato come parametro, all'oggetto attuale chiamata
	 *
	 * @param ora_fine
	 */
	public void setOra_fine(LocalTime ora_fine) {
		this.ora_fine = ora_fine;
	}
	
	/**
	  * Gets and Sets della variabile numero chiamante.
	 *
	 * @return numero chiamante
	 */
	public Contatto getNumero_chiamante() {
		return numero_chiamante;
	}
	
	/**
	 * Metodo per settare un numero chiamante, passato come parametro, all'oggetto attuale chiamata
	 *
	 * @param numero_chiamante
	 */
	public void setNumero_chiamante(Contatto numero_chiamante) {
		this.numero_chiamante = numero_chiamante;
	}
	
	/**
	  * Gets and Sets della variabile numero chiamato.
	 *
	 * @return numero chiamato
	 */
	public Contatto getNumero_chiamato() {
		return numero_chiamato;
	}
	
	/**
	 * Metodo per settare un numero chiamato, passato come parametro, all'oggetto attuale chiamata
	 *
	 * @param numero_chiamato
	 */
	public void setNumero_chiamato(Contatto numero_chiamato) {
		this.numero_chiamato = numero_chiamato;
	}
}

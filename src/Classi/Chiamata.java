package Classi;

import java.time.LocalDate;
import java.time.LocalTime;

public class Chiamata {
	//attributi:
	private LocalDate data_inizio;
	private LocalDate data_fine;
	private LocalTime ora_inizio;
	private LocalTime ora_fine;
	private Contatto numero_chiamante;
	private Contatto numero_chiamato;
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
	public LocalDate getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(LocalDate data_inizio) {
		this.data_inizio = data_inizio;
	}
	public LocalDate getData_fine() {
		return data_fine;
	}
	public void setData_fine(LocalDate data_fine) {
		this.data_fine = data_fine;
	}
	public LocalTime getOra_inizio() {
		return ora_inizio;
	}
	public void setOra_inizio(LocalTime ora_inizio) {
		this.ora_inizio = ora_inizio;
	}
	public LocalTime getOra_fine() {
		return ora_fine;
	}
	public void setOra_fine(LocalTime ora_fine) {
		this.ora_fine = ora_fine;
	}
	public Contatto getNumero_chiamante() {
		return numero_chiamante;
	}
	public void setNumero_chiamante(Contatto numero_chiamante) {
		this.numero_chiamante = numero_chiamante;
	}
	public Contatto getNumero_chiamato() {
		return numero_chiamato;
	}
	public void setNumero_chiamato(Contatto numero_chiamato) {
		this.numero_chiamato = numero_chiamato;
	}
}

package Controller;

import Classi.Rubrica;

import java.util.ArrayList;

import Classi.Contatto;
import Classi.NumeroTelefonoFisso;
import Classi.NumeroTelefonoMobile;
public class Controller {
	
	Rubrica r;
	
	public Controller()
	{
		r= new Rubrica("Rubrica");
	}
	
	public void nuovaRubrica(String rubrica)
	{
		r = new Rubrica(rubrica);
	}
	public Rubrica getRubrica()
	{
		return r;
	}
	public void addContatto(String nome, String cognome, int eta, String sesso, String residenza, String email, String numf, String numb)
	{
		r.aggiungiContatto(nome, cognome, eta, sesso, residenza, email, this.r, numf, numb);
	}
	public ArrayList<Contatto> getRubricaContatti()
	{
		return r.contatti;
	}
	public Rubrica getRubricaOrdinataDesc()
	{
		r.mostraContattiPer("Decrescente");
		return r;
	}
	public Rubrica getRubricaOrdinataCresc()
	{
		r.mostraContattiPer("Crescente");
		return r;
	}
	public ArrayList<NumeroTelefonoFisso> getContattiNumeriTelefonoFissi(Contatto in)
	{
		return in.getNumeritelefonicif();
	}
	public ArrayList<NumeroTelefonoMobile> getContattiNumeriTelefonoMobili(Contatto in)
	{
		return in.getNumeritelefonicim();
	}
}

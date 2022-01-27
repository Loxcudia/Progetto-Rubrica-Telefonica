package Controller;
import java.awt.EventQueue;
import java.util.ArrayList;

import Classi.Contatto;
import Classi.DBConnection;
import Classi.Rubrica;
import GUI.CreaC;
import GUI.LoginFrame;
import GUI.Menu;
import GUI.SchermataContatti;
import GUI.SchermataGruppi;
public class Controller {
	//attributi:
	DBConnection dbc;
	Rubrica r;
	String nickname;
	String numero;
	boolean con;
	boolean cre;
	LoginFrame i;
	Menu m;
	SchermataContatti sc;
	SchermataGruppi sg;
	CreaC ci;
	//metodi:
	public Controller() {
		r = new Rubrica("Rubrica");
		i = new LoginFrame(this);
		i.setVisible(true);
	}
	public void tryLogin(String username, String num)
	{
		nickname = username;
		numero = num;
		m = new Menu(this);
		i.setVisible(false);
		m.setVisible(true);
	}
	public void contattiOrGruppi(boolean x, boolean y)
	{
		con = x;
		cre = y;
		if(con == true)
		{
			sc = new SchermataContatti(this);
			m.setVisible(false);
			sc.setVisible(true);
		}
		else
		{
			sg = new SchermataGruppi(this);
			m.setVisible(false);
			sg.setVisible(true);
		}
	}
	public void tryCreaC()
	{
		ci = new CreaC(this);
		sc.setVisible(false);
		ci.setVisible(true);
	}
	public void creaContatto(String nome, String cognome, int eta, String sesso, String residenza, String email, String numf, String numb)
	{
		r.aggiungiContatto(nome, cognome, eta, sesso.charAt(0), residenza, email, this.r, numf, numb);
		ci.setVisible(false);
		sc.setVisible(true);
	}
	public void riempiArrayList(ArrayList<Contatto> in)
	{
		if(r != null) {
			for(int i=0; i < r.contatti.size(); i++)
			{
				in.add(r.contatti.get(i));
			}
		}
	}
	public static void main(String[] args) {
		new Controller();
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public DBConnection getDbc() {
		return dbc;
	}
	public Rubrica getR() {
		return r;
	}
	public LoginFrame getI() {
		return i;
	}
	public Menu getM() {
		return m;
	}
	
}

package GUI;
import java.awt.EventQueue;
import java.util.ArrayList;

import Classi.Contatto;
import Classi.DBConnection;
import Classi.Rubrica;
import Controller.Controller;
public class GestioneVisibilitaGUI {
	//attributi:
	Controller c;
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
	ModificaContatto mc;
	VisualizzaContattoNumeri vcm;
	//metodi:
	public GestioneVisibilitaGUI(LoginFrame in, Controller cin) {
		i = in;
		c = cin;
		in.setVisible(true);
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
			if(cre == true)
			{
				r = c.getRubricaOrdinataCresc();
			}
			else
			{
				r = c.getRubricaOrdinataDesc();
			}
			sc = new SchermataContatti(this, this.c);
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
		ci = new CreaC(this, this.c);
		sc.setVisible(false);
		ci.setVisible(true);
	}
	public void creaContatto()
	{
		ci.setVisible(false);
		sc = new SchermataContatti(this, this.c);
		sc.setVisible(true);
	}
	public void tryModificaContatto(Contatto co)
	{
		sc.setVisible(false);
		mc = new ModificaContatto(this, co, this.r);
		mc.setVisible(true);
	}
	public void tryModificaContatto2()
	{
		mc.setVisible(false);
		sc= new SchermataContatti(this, this.c);
		sc.setVisible(true);
	}
	public void tryVisualizzaNumeri(Contatto in)
	{
		sc.setVisible(false);
		vcm = new VisualizzaContattoNumeri(this.c, this, in);
		vcm.setVisible(true);
	}
	public void tryIndietroMenu()
	{
		m.setVisible(false);
		i = new LoginFrame(this.c);
		i.setVisible(true);
	}
	public void tryIndietroSchermataContatti()
	{
		sc.setVisible(false);
		m = new Menu(this);
		m.setVisible(true);
	}
	public void tryIndietroCreaC()
	{
		ci.setVisible(false);
		sc= new SchermataContatti(this, this.c);
		sc.setVisible(true);
	}
	public void tryIndietroModificaContatto()
	{
		mc.setVisible(false);
		sc = new SchermataContatti(this, this.c);
		sc.setVisible(true);
	}
	public void tryIndietroVisualizzaContattoNumeri()
	{
		vcm.setVisible(false);
		sc= new SchermataContatti(this, this.c);
		sc.setVisible(true);
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
	
	public LoginFrame getI() {
		return i;
	}
	public Menu getM() {
		return m;
	}
	
}
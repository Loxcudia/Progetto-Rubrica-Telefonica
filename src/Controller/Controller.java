package Controller;
import java.awt.EventQueue;

import Classi.DBConnection;
import Classi.Rubrica;
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
	//metodi:
	public Controller() {
		i = new LoginFrame(this);
		i.setVisible(true);
	}
	public void nuovaRubrica(String nome)
	{
		r = new Rubrica(nome);
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

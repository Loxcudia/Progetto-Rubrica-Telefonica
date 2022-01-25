package Controller;
import java.awt.EventQueue;

import Classi.DBConnection;
import Classi.Rubrica;
import GUI.LoginFrame;
import GUI.Menu;
public class Controller {
	//attributi:
	DBConnection dbc;
	Rubrica r;
	String nickname;
	String numero;
	LoginFrame i;
	Menu m;
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
	public static void main(String[] args) {
		new Controller();
	}

}

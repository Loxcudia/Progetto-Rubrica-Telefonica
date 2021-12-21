package Classi;
public class Controller {
	//attributi:
	DBConnection dbc;
	Rubrica r;
	
	//metodi:
	public Controller() {
	}
	public void nuovaRubrica(String nome)
	{
		r = new Rubrica(nome);
	}
	public boolean tryLogin(String username, char[] password)
	{
		return true;	
	}
	public static void main(String[] args) {
		new Controller();

	}

}

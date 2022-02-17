package GUI;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.Controller;
import Model.AccountMessaggistica;
import Model.Contatto;
import Model.DBConnection;
import Model.Gruppo;
import Model.NumeroTelefonoFisso;
import Model.NumeroTelefonoMobile;
import Model.Rubrica;
public class GestioneVisibilitaGUI {
	//attributi:
	private Controller c;
	private Rubrica r;
	private String nickname;
	private String numero;
	private String nome, numeroF,numeroC; 
	private ArrayList<String> numeriSecondari = new ArrayList<>();
	private ArrayList<AccountMessaggistica> accountm = new ArrayList<>();
	private boolean con;
	private boolean cre = true;
	private LoginFrame i;
	private Menu m;
	private SchermataContatti sc;
	private SchermataGruppi sg;
	private CreaC ci;
	private ModificaContatto mc;
	private VisualizzaContattoNumeri vcm;
	private AggiungiNumeriSecondari ans;
	private ModificaNumeroTelefono mnf;
	private AggiungiNumeroTelefono anf;
	private AggiungiAccountMessaggistica aam;
	private VisualizzaContattoAccountMessaggistica vcam;
	private AggiungiAccountMessaggistica2 aam2;
	private ModificaAccountMessaggistica mam;
	private CreaGruppo cg;
	private VisualizzaContattiGruppo vcg;
	private AggiungiContattoGruppo acg;
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
		if(!((nickname.isEmpty()) || (numero.isBlank())))
		{
			m = new Menu(this);
			i.setVisible(false);
			m.setVisible(true);
		}
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
				sc = new SchermataContatti(this, this.c, true);
				m.setVisible(false);
				sc.setVisible(true);
			}
			else
			{
				r = c.getRubricaOrdinataDesc();
				sc = new SchermataContatti(this, this.c, false);
				m.setVisible(false);
				sc.setVisible(true);
			}
		}
		else
		{
			if(cre == true)
			{
				sg = new SchermataGruppi(this, this.c, true);
				m.setVisible(false);
				sg.setVisible(true);
			}
			else
			{
				sg = new SchermataGruppi(this, this.c, false);
				m.setVisible(false);
				sg.setVisible(true);
			}
		}
	}
	public void tryCreaC()
	{
		ci = new CreaC(this, this.c);
		sc.setVisible(false);
		ci.setVisible(true);
	}
	public void creaContatto(String nome, String cognome, String numf, String numc)
	{
		if ((((!nome.isBlank())||(!cognome.isBlank()))&&(!numf.isBlank())&&(!numc.isBlank())))
		{
			ci.setVisible(false);
			sc = new SchermataContatti(this, this.c, cre);
			sc.setVisible(true);
		}
	}
	public void tryModificaContatto(Contatto co)
	{
		sc.setVisible(false);
		mc = new ModificaContatto(this, co, this.r, this.c);
		mc.setVisible(true);
	}
	public void tryModificaContatto2()
	{
		mc.setVisible(false);
		sc= new SchermataContatti(this, this.c, cre);
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
		sc= new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	public void tryIndietroModificaContatto()
	{
		mc.setVisible(false);
		sc = new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	public void tryIndietroVisualizzaContattoNumeri()
	{
		vcm.setVisible(false);
		sc= new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	public void tryAggiungiNumeriSecondari()
	{
		ci.setVisible(false);
		ans = new AggiungiNumeriSecondari(this, this.c);
		ans.setVisible(true);
	}
	public void AggiuntaNumeroSecondario(String in, String in2)
	{
		ans.setVisible(false);
		numeriSecondari.add(in + in2);
		ci.setVisible(true);
	}
	
	public void tryModificaNumeroFisso(NumeroTelefonoFisso in, Contatto conin)
	{
		vcm.setVisible(false);
		mnf = new ModificaNumeroTelefono (this, this.c, in, null, conin);
		mnf.setVisible(true);
	}
	public void tryModificaNumeroMobile(NumeroTelefonoMobile in, Contatto conin)
	{
		vcm.setVisible(false);
		mnf = new ModificaNumeroTelefono (this, this.c, null, in, conin);
		mnf.setVisible(true);
	}
	public void tryIndietroModificaNumero(Contatto conin)
	{
		mnf.setVisible(false);
		vcm = new VisualizzaContattoNumeri(this.c, this, conin);
		vcm.setVisible(true);
	}
	public void tryAggiungiNumeroTelefono(Contatto conin, String scelta)
	{
		vcm.setVisible(false);
		anf = new AggiungiNumeroTelefono(this, this.c, scelta, conin);
		anf.setVisible(true);
	}
	public void tryIndietroAggiungiNumeroTelefono(Contatto conin)
	{
		anf.setVisible(true);
		vcm = new VisualizzaContattoNumeri(this.c, this, conin);
		vcm.setVisible(true);
	}
	public void tryIndietroAggiungiNumeriSecondari()
	{
		ans.setVisible(false);
		ci.setVisible(true);
	}
	public void tryAggiungiAccountMessaggistica()
	{
		ci.setVisible(false);
		aam = new AggiungiAccountMessaggistica(this, this.c);
		aam.setVisible(true);
	}
	public void tryIndietroAggiungiAccountMessaggistica(AccountMessaggistica in)
	{
		aam.setVisible(false);
		accountm.add(in);
		ci.setVisible(true);
	}
	public void tryVisualizzaContattoAccountMessaggistica(Contatto coin)
	{
		sc.setVisible(false);
		vcam = new VisualizzaContattoAccountMessaggistica(this, this.c, coin);
		vcam.setVisible(true);
	}
	public void tryAggiungiAccountMessaggistica2(Contatto coin)
	{
		vcam.setVisible(false);
		aam2 = new AggiungiAccountMessaggistica2(this, this.c, coin);
		aam2.setVisible(true);
	}
	public void tryIndietroAggiungiAccountMessaggistica2(Contatto coin)
	{
		aam2.setVisible(false);
		vcam = new VisualizzaContattoAccountMessaggistica(this, this.c, coin);
		vcam.setVisible(true);
	}
	public void tryIndietroVisualizzaContattoAccountMessaggistica()
	{
		vcam.setVisible(false);
		sc = new SchermataContatti(this, this.c, cre);
		sc.setVisible(true);
	}
	public void tryAnnullaAggiungiAccountMessaggistica()
	{
		aam.setVisible(false);
		ci.setVisible(true);
	}
	public void tryModificaAccountMessaggistica(AccountMessaggistica in)
	{
		vcam.setVisible(false);
		mam = new ModificaAccountMessaggistica(this, this.c, in);
		mam.setVisible(true);
	}
	public void tryOKModificaAccountMessaggistica(Contatto coin)
	{
		mam.setVisible(false);
		vcam = new VisualizzaContattoAccountMessaggistica(this, this.c, coin);
		vcam.setVisible(true);
	}
	public void tryAnnullaAggiungiAccountMessaggistica2()
	{
		aam2.setVisible(false);
		vcam.setVisible(true);
	}
	public void tryAnnullaModificaAccountMessaggistica()
	{
		mam.setVisible(false);
		vcam.setVisible(true);
	}
	public void tryCreaGruppo()
	{
		sg.setVisible(false);
		cg = new CreaGruppo(this, this.c);
		cg.setVisible(true);
	}
	public void tryIndietroSchermataGruppi()
	{
		sg.setVisible(false);
		m.setVisible(true);
	}
	public void tryAnnullaCreaGruppo()
	{
		cg.setVisible(false);
		sg.setVisible(true);
	}
	public void trySalvaGruppo()
	{
		cg.setVisible(false);
		sg = new SchermataGruppi(this, this.c, cre);
		sg.setVisible(true);
	}
	public void tryVisualizzaContattiGruppo(Gruppo g)
	{
		sg.setVisible(false);
		vcg = new VisualizzaContattiGruppo(this, this.c, g);
		vcg.setVisible(true);
	}
	public void tryOKVisualizzaContattiGruppo()
	{
		vcg.setVisible(false);
		sg = new SchermataGruppi(this, this.c, cre);
		sg.setVisible(true);
	}
	public void tryAggiungiContattoGruppo(Gruppo gin)
	{
		vcg.setVisible(false);
		acg = new AggiungiContattoGruppo(this, this.c, gin);
		acg.setVisible(true);
	}
	public void tryOKAggiungiContattoGruppo(Gruppo gin)
	{
		acg.setVisible(false);
		vcg = new VisualizzaContattiGruppo(this, this.c, gin);
		vcg.setVisible(true);
	}
	public void tryIndietroAggiungiContattoGruppo()
	{
		acg.setVisible(false);
		vcg.setVisible(true);
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
	public ArrayList<String> getNumeriSecondari() {
		return numeriSecondari;
	}
	public void setNumeriSecondari(ArrayList<String> numeriSecondari) {
		this.numeriSecondari = numeriSecondari;
	}
	public ArrayList<AccountMessaggistica> getAccountm() {
		return accountm;
	}
	public void setAccountm(ArrayList<AccountMessaggistica> accountm) {
		this.accountm = accountm;
	}
	
}
package Classi;
import java.util.Scanner;

import Controller.Controller;

public class Main {

	public static void main(String[] args) {
		new Controller();
		Rubrica r;
		String nome;
		Scanner scanner= new Scanner(System.in);
		System.out.println("Inserisci nome della tua rubrica:");
		nome= scanner.next();
		r= new Rubrica(nome);
		System.out.println("Nome della nuova rubrica: ");
		System.out.println(r.getNome());
	}

}

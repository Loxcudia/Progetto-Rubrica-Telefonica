package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

public class Main extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller c=new Controller();
					LoginFrame window = new LoginFrame(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

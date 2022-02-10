package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.AccountMessaggistica;
import Classi.Contatto;
import Controller.Controller;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizzaContattoAccountMessaggistica extends JFrame {

	private JPanel contentPane;
	private Controller con;
	private GestioneVisibilitaGUI c;
	private DefaultListModel<AccountMessaggistica> amModel = new DefaultListModel<>();
	private ArrayList<AccountMessaggistica> accountmess = new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public VisualizzaContattoAccountMessaggistica(GestioneVisibilitaGUI in, Controller cin, Contatto conin) {
		c = in;
		con = cin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ecco gli account di messaggistica relativi al contatto selezionato:");
		
		JList list = new JList();
		
		accountmess = con.getContattoAccountMessaggistica(conin);
		amModel.addAll(accountmess);
		list.setModel(amModel);
		contentPane.add(list, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryAggiungiAccountMessaggistica2(conin);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Modifica");
		
		JButton btnNewButton_2 = new JButton("Elimina");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				amModel.remove(x = list.getSelectedIndex());
				accountmess.remove(x);
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(113)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(133))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 64, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
					.addGap(226))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(list)
					.addContainerGap(243, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

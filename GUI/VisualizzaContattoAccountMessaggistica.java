package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.AccountMessaggistica;
import Model.Contatto;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountMessaggistica a = accountmess.get(list.getSelectedIndex());
				c.tryModificaAccountMessaggistica(a);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Elimina");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				amModel.remove(x = list.getSelectedIndex());
				accountmess.remove(x);
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		
		JButton btnNewButton_3 = new JButton("Indietro");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroVisualizzaContattoAccountMessaggistica();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Visualizza Info");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountMessaggistica n = accountmess.get(list.getSelectedIndex());
				JOptionPane.showMessageDialog(null, n.getInfo());
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 65, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(24)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)))
					.addGap(133))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton_3))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(list)
					.addContainerGap(234, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

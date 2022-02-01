package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Rubrica;
import Controller.Controller;
import Classi.Contatto;

import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class SchermataContatti extends JFrame {

	private JPanel contentPane;
	GestioneVisibilitaGUI c;
	Controller con;
	private String nomeContatto = "";
	DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
	ArrayList<Contatto> contatti = new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public SchermataContatti(GestioneVisibilitaGUI in, Controller cin) {
		c = in;
		con = cin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Crea");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryCreaC();
				contattiModel.clear();
				contattiModel.addAll(contatti);
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		
			 
		 
		
		JList<Contatto> list = new JList<>();
		

		contatti = con.getRubricaContatti();
		contattiModel.addAll(contatti);
		list.setModel(contattiModel);
		contentPane.add(list, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Visualizza Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contatto co= contatti.get(list.getSelectedIndex());
				JOptionPane.showMessageDialog(null, co.getInfo());
			}
		});
		
		JButton btnNewButton_2 = new JButton("Rimuovi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				contattiModel.remove(x = list.getSelectedIndex());
				contatti.remove(x);
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Ecco i tuoi contatti!");
		
		JButton btnNewButton_3 = new JButton("Modifica");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contatto co = contatti.get(list.getSelectedIndex());
				c.tryModificaContatto(co);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Visualizza Numeri Telefono");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contatto co = contatti.get(list.getSelectedIndex());
				c.tryVisualizzaNumeri(co);
				
			}
		});
		
		JButton btnNewButton_6 = new JButton("Visualizza Account Messaggistica");
		
		JButton btnNewButton_4 = new JButton("Indietro");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroSchermataContatti();
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
							.addGap(97))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addGap(40))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(187)
					.addComponent(lblNewLabel)
					.addGap(258)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_3)
					.addGap(35)
					.addComponent(list)
					.addGap(26)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_6)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}

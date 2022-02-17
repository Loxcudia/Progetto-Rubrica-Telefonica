package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Contatto;
import Model.NumeroTelefonoFisso;
import Model.NumeroTelefonoMobile;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;

public class VisualizzaContattoNumeri extends JFrame {

	private JPanel contentPane;
	private Controller con;
	private GestioneVisibilitaGUI c;
	private DefaultListModel<NumeroTelefonoFisso> nfModel = new DefaultListModel<>();
	private DefaultListModel<NumeroTelefonoMobile> nmModel = new DefaultListModel<>();
	private ArrayList<NumeroTelefonoFisso> numerifissi= new ArrayList<>();
	private ArrayList<NumeroTelefonoMobile> numerimobili= new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public VisualizzaContattoNumeri(Controller cin, GestioneVisibilitaGUI in, Contatto coin) {
		con = cin;
		c = in;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ecco a te i numeri per il contatto selezionato:");
		
		JList list = new JList();
		numerifissi = con.getContattiNumeriTelefonoFissi(coin);
		numerimobili = con.getContattiNumeriTelefonoMobili(coin);
		nfModel.addAll(numerifissi);
		list.setModel(nfModel);
		contentPane.add(list, BorderLayout.NORTH);
		
		JList list_1 = new JList();
		nmModel.addAll(numerimobili);
		list_1.setModel(nmModel);
		contentPane.add(list, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Numeri fissi:");
		
		JLabel lblNewLabel_2 = new JLabel("Numeri mobili:");
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroVisualizzaContattoNumeri();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Modifica");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumeroTelefonoMobile n = numerimobili.get(list_1.getSelectedIndex());
				c.tryModificaNumeroMobile(n, coin);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Elimina");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nmModel.size() <= 1)
				{
					JOptionPane.showMessageDialog(null, "Deve esistere almeno un numero, impossibile cancellare");
				}
				else
				{
					int x;
					nmModel.remove(x = list_1.getSelectedIndex());
					numerimobili.remove(x);
				}
			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.RED);
		
		JButton btnNewButton_3 = new JButton("Aggiungi");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryAggiungiNumeroTelefono(coin, "F");
			}
		});
		
		JButton btnNewButton_4 = new JButton("Aggiungi");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryAggiungiNumeroTelefono(coin, "M");
			}
		});
		
		JButton btnNewButton_5 = new JButton("Modifica");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumeroTelefonoFisso n = numerifissi.get(list.getSelectedIndex());
				c.tryModificaNumeroFisso(n, coin);
			}
		});
		
		JButton btnNewButton_6 = new JButton("Elimina");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nfModel.size() <= 1)
				{
					JOptionPane.showMessageDialog(null, "Deve esistere almeno un numero, impossibile cancellare");
				}
				else
				{
					int x;
					nfModel.remove(x = list.getSelectedIndex());
					numerifissi.remove(x);
				}
			}
		});
		btnNewButton_6.setBackground(Color.RED);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(47)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addGap(227))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(510))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(502))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
					.addGap(321))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(list_1, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(268))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addGap(16)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_6))
					.addGap(20)
					.addComponent(list)
					.addGap(62)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list_1)
					.addContainerGap(136, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

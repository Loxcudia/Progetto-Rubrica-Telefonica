package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Contatto;
import Classi.NumeroTelefonoFisso;
import Classi.NumeroTelefonoMobile;
import Controller.Controller;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizzaContattoNumeri extends JFrame {

	private JPanel contentPane;
	Controller con;
	GestioneVisibilitaGUI c;
	DefaultListModel<NumeroTelefonoFisso> nfModel = new DefaultListModel<>();
	DefaultListModel<NumeroTelefonoMobile> nmModel = new DefaultListModel<>();
	ArrayList<NumeroTelefonoFisso> numerifissi= new ArrayList<>();
	ArrayList<NumeroTelefonoMobile> numerimobili= new ArrayList<>();
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
					.addGap(47)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(list_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addGap(16)
					.addComponent(lblNewLabel_1)
					.addGap(49)
					.addComponent(list)
					.addGap(62)
					.addComponent(lblNewLabel_2)
					.addGap(27)
					.addComponent(list_1)
					.addContainerGap(153, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

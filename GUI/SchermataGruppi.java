package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Contatto;
import Model.Gruppo;

import javax.swing.JMenuBar;
public class SchermataGruppi extends JFrame {
	private JPanel contentPane;
	private GestioneVisibilitaGUI c;
	private Controller con;
	private String nomeGruppo = "";
	private DefaultListModel<Gruppo> gruppoModel = new DefaultListModel<>();
	private ArrayList<Gruppo> gruppo = new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public SchermataGruppi(GestioneVisibilitaGUI in, Controller cin, boolean isCresc) {
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
				c.tryCreaGruppo();
				gruppoModel.clear();
				gruppoModel.addAll(gruppo);
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);		
		JList<Gruppo> list = new JList<>();
		if(isCresc == true)
		{
			Collections.sort(gruppo, new Comparator<Gruppo>() {
				   @Override
				   public int compare(Gruppo o1, Gruppo o2) {
				      return o1.getNome().compareTo(o2.getNome());
				   }
				});
		}
		else
		{
			Collections.sort(gruppo, new Comparator<Gruppo>() {
				   @Override
				   public int compare(Gruppo o1, Gruppo o2) {
				      return o2.getNome().compareTo(o1.getNome());
				   }
				});
		}
		gruppo = con.getRubricaGruppi();
		gruppoModel.addAll(gruppo);
		list.setModel(gruppoModel);
		contentPane.add(list, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Visualizza");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gruppo gr= gruppo.get(list.getSelectedIndex());
				c.tryVisualizzaContattiGruppo(gr);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Rimuovi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				gruppoModel.remove(x = list.getSelectedIndex());
				gruppo.remove(x);
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Ecco i tuoi gruppi!");
		JButton btnNewButton_4 = new JButton("Indietro");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroSchermataGruppi();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addGap(187)
							.addComponent(lblNewLabel)
							.addGap(258))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
							.addGap(296)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addGap(17)
							.addComponent(btnNewButton_2)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
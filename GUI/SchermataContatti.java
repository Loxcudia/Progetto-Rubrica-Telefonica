package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import Model.Contatto;
import Model.Rubrica;

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
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SchermataContatti extends JFrame {

	private JPanel contentPane;
	private GestioneVisibilitaGUI c;
	private Controller con;
	private String nomeContatto = "";
	private DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
	private ArrayList<Contatto> contatti = new ArrayList<>();
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public SchermataContatti(GestioneVisibilitaGUI in, Controller cin, boolean isCresc) {
		c = in;
		con = cin;
		contatti = con.getRubricaContatti();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 660);
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
		

		
		if(isCresc == true)
		{
			Collections.sort(contatti, new Comparator<Contatto>() {
				   @Override
				   public int compare(Contatto o1, Contatto o2) {
				      return o1.getNome().compareTo(o2.getNome());
				   }
				});
		}
		else
		{
			Collections.sort(contatti, new Comparator<Contatto>() {
				   @Override
				   public int compare(Contatto o1, Contatto o2) {
				      return o2.getNome().compareTo(o1.getNome());
				   }
				});
		}
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
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contatto co = contatti.get(list.getSelectedIndex());
				c.tryVisualizzaContattoAccountMessaggistica(co);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Indietro");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.tryIndietroSchermataContatti();
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Per:");
		String[] x = {"Nome", "Email", "Account di messaggistica", "Numero di telefono"};
		JComboBox comboBox = new JComboBox(x);
		
		JButton btnNewButton_7 = new JButton("Cerca");
		
			
			btnNewButton_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField.getText().isEmpty() == false)
					{
						ArrayList<Contatto> ricerca = new ArrayList<Contatto>();
						if(comboBox.getSelectedItem().equals("Nome"))
						{
							ricerca = con.ricercaPer("Nome", contatti, textField.getText());
							contattiModel.clear();
							contattiModel.addAll(ricerca);
						}
						if(comboBox.getSelectedItem().equals("Email"))
						{
							ricerca = con.ricercaPer("Email", contatti, textField.getText());
							contattiModel.clear();
							contattiModel.addAll(ricerca);
						}
						if(comboBox.getSelectedItem().equals("Account di messaggistica"))
						{
							ricerca = con.ricercaPer("Account di messaggistica", contatti, textField.getText());
							contattiModel.clear();
							contattiModel.addAll(ricerca);
						}
						if(comboBox.getSelectedItem().equals("Numero di telefono"))
						{
							ricerca = con.ricercaPer("Numero di telefono", contatti, textField.getText());
							contattiModel.clear();
							contattiModel.addAll(ricerca);
						}
					}
					
				}});
	
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_6, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
					.addGap(40))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
							.addGap(187)
							.addComponent(lblNewLabel)
							.addGap(317))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_7, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(247)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
					.addGap(528))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton_4))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_7)
								.addComponent(lblNewLabel_2)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(list)))
					.addGap(480)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_6)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}

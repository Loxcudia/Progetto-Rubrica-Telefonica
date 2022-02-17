package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Contatto;
import Model.Gruppo;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.awt.event.ActionEvent;

public class VisualizzaContattiGruppo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	GestioneVisibilitaGUI c;
	Controller con;
	private DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
	private ArrayList<Contatto> contattigruppo = new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public VisualizzaContattiGruppo(GestioneVisibilitaGUI in, Controller cin, Gruppo gin) {
		c = in;
		con = cin;
		contattigruppo = gin.getContatti();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Contatti presenti nel gruppo:");
		
		JList list = new JList();
		LinkedHashSet<Contatto> hashSet = new LinkedHashSet<>(contattigruppo);
		ArrayList<Contatto> contattigruppo = new ArrayList<>(hashSet);
		contattiModel.addAll(contattigruppo);
		list.setModel(contattiModel);
		contentPane.add(list, BorderLayout.NORTH);
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gin.getContatti().addAll(contattigruppo);
				c.tryAggiungiContattoGruppo(gin);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Rimuovi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				contattiModel.remove(x = list.getSelectedIndex());
				gin.getContatti().remove(x);
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		
		JButton btnNewButton_2 = new JButton("Indietro");
		
		textField = new JTextField(gin.getNome());
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("OK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isBlank() == false)
				{
					gin.setNome(textField.getText());
					c.tryOKVisualizzaContattiGruppo();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Inserisci un nome");
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(list, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
					.addGap(87)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(153)
					.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(178))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 348, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addComponent(btnNewButton_3)
					.addGap(31))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

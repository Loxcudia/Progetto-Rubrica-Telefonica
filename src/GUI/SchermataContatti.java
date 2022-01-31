package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Rubrica;
import Classi.Contatto;
import Controller.Controller;
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

public class SchermataContatti extends JFrame {

	private JPanel contentPane;
	Controller c;
	private String nomeContatto = "";
	DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
	ArrayList<Contatto> contatti = new ArrayList<>();
	/**
	 * Create the frame.
	 */
	public SchermataContatti(Controller in) {
		c = in;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 598);
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
		

		c.riempiArrayList(contatti);
		contattiModel.addAll(contatti);
		list.setModel(contattiModel);
		contentPane.add(list, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Visualizza");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contatto co= contatti.get(list.getSelectedIndex());
				JOptionPane.showMessageDialog(null, co.getInfo());
			}
		});
		
		JButton btnNewButton_2 = new JButton("Rimuovi");
		
		JLabel lblNewLabel = new JLabel("Ecco i tuoi contatti!");
		
		JButton btnNewButton_3 = new JButton("Modifica");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contatto co = contatti.get(list.getSelectedIndex());
				c.tryModificaContatto(co);
			}
		});
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(146)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
					.addComponent(btnNewButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(88))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel))
					.addGap(64)
					.addComponent(list)
					.addPreferredGap(ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}

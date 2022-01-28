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
		setBounds(100, 100, 336, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("CREA");
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
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(251, Short.MAX_VALUE)
					.addComponent(btnNewButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
					.addGap(18))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addGap(67)
					.addComponent(list)
					.addContainerGap(455, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

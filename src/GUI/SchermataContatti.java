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
	private JTable table;
	private String nomeContatto = "";
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
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int riga= table.getSelectedRow();
				nomeContatto = new String(table.getModel().getValueAt(riga, 0).toString());
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"Contatto"
				}
		));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		 ArrayList tabellaContatti = new ArrayList();
		 c.riempiArrayList(tabellaContatti);
		 if(tabellaContatti != null)
		 {
			 for(int i = 0; i < tabellaContatti.size(); i++)
			 {
				 model.addRow(new Object[] {tabellaContatti.get(i)});
			 }
			 contentPane.add(table);
			 
		 }
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(251, Short.MAX_VALUE)
					.addComponent(btnNewButton))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(273, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addGap(58)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(463, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

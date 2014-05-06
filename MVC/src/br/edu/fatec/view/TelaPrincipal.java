package br.edu.fatec.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.dao.ClienteDAO;
import br.edu.fatec.util.ConnectionFactory;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(24, 54, 167, 15);
		contentPane.add(lblNomeDoCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(164, 52, 227, 19);
		contentPane.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection conn = ConnectionFactory.getConnection();
					JOptionPane.showMessageDialog(null, "Consegui conectar ao Banco");
					
					Cliente cliente = new Cliente();
					cliente.setNomeCliente(txtNomeCliente.getText());
					
					ClienteDAO dao = new ClienteDAO();
					
					dao.salvar(cliente);
					JOptionPane.showMessageDialog(null, "Gravado com sucesso");
				}catch (Exception e){
					JOptionPane.showMessageDialog(null, "xiii deu pau");
					
				}
				
				
				
				
				
				
				
			}
		});
		btnSalvar.setBounds(49, 223, 117, 25);
		contentPane.add(btnSalvar);
	}
}

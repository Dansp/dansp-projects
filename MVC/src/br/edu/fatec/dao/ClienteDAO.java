package br.edu.fatec.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.fatec.bean.Cliente;
import br.edu.fatec.util.ConnectionFactory;
public class ClienteDAO {
	private Connection conn;
	
	public ClienteDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try{
			conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
		   throw new Exception ( "erro: \n" + e.getMessage());
		}
   }
	// método de salvar / gravar / incluir

	public void salvar(Cliente cliente)  throws Exception{
	        PreparedStatement ps = null;
	        Connection conn = null;
	        if (cliente == null)
	            throw new
	                    Exception("O valor passado nao pode ser nulo");
	         try {
	               String SQL = "INSERT INTO cliente (nome) values (?)";
	            	conn = this.conn;
	            	ps = conn.prepareStatement(SQL);
	            	ps.setString(1, cliente.getNomeCliente());      
	            	ps.executeUpdate( );
	          } catch (SQLException sqle) {
	                    throw new Exception("Erro ao inserir dados "+ sqle);
	          } finally {
	                 //ConnectionFactory.closeConnection(conn, ps);
	          }
	    }
}

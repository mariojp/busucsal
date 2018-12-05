package br.ucsal.busucsal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	
	private static ConnectionFactory connectionFactory = null;
	
	private static Connection connection  = null;


	private String conStr = "jdbc:hsqldb:hsql://localhost/busucsal";
	private String usuario = "sa";
	private String senha = "";
	
	private ConnectionFactory() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			

			connection =  DriverManager.getConnection(conStr, usuario, senha);

			connection.createStatement().execute("CREATE TABLE IF NOT EXISTS ROTEIROS ("
					+ "ID BIGINT IDENTITY PRIMARY KEY, "
					+"TITULO VARCHAR(255), DESCRICAO VARCHAR(255) );");
			
			connection.createStatement().execute("CREATE TABLE IF NOT EXISTS HORARIOS  ( " + 
					"  ID BIGINT IDENTITY PRIMARY KEY," + 
					"  HORA_INICIO VARCHAR(255), DIA_DA_SEMANA VARCHAR(255), ROTEIRO_ID BIGINT, "
				  + "  FOREIGN KEY(ROTEIRO_ID) REFERENCES ROTEIROS(ID) "
					+ ");");

			
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public static Connection getConnection() {
		if(connectionFactory == null ) {
			connectionFactory = new ConnectionFactory();
		}
		return connection;
	}
	
	
	
	

}

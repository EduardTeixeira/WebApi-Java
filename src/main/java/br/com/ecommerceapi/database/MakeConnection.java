package br.com.ecommerceapi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class MakeConnection {

	public MakeConnection() {
	}

	public static Connection con;

	public static void Conectar() {
		//System.out.println("Conectando ao banco...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basetest", "root", "eduardteixeira");
			//System.out.println("Conectado.");
		} catch (ClassNotFoundException ex) {
			System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
			Logger.getLogger(MakeConnection.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}

}
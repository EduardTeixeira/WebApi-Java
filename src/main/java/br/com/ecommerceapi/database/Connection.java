package br.com.ecommerceapi.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	public static String status = "Not connect data base...";

	public Connection() {

	}

	public static java.sql.Connection getConnectionMySql() {

		Connection connection = null;

		try {

			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			String serverName = "localhost";

			String mydatabase = "ecommerce";

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = "root";

			String password = "eduardteixeira";

			connection = (Connection) DriverManager.getConnection(url, username, password);

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}

			return (java.sql.Connection) connection;

		} catch (ClassNotFoundException e) {

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

		} catch (SQLException e) {

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}

	}

}

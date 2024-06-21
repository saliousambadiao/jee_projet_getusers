package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {
	public static String DB_URL = "jdbc:mysql://localhost:3306/jee_users";
	static String DB_USER = "root";
	static String DB_PASSWORD = "p@sser1234";

	public static Connection getInstance() {
		Connection connexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("Connected successfully!");
		} catch (ClassNotFoundException e) {
			System.out.println("Error while connecting !" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Connexion error : " + e.getMessage());
		}
		return connexion;
	}

	public static void main(String[] args) {
		Connection connexion = getInstance();
		System.out.println(connexion);
		System.out.println("Connexion succed");
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

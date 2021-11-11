package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {
	
	public static void main(String[] args) {
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/escola_banco";
			String user = "root";
			String psw = "130278";
			
			Connection conexao = DriverManager.getConnection( url , user, psw);
			
			System.out.println("Ola mundo");
			JOptionPane.showMessageDialog(null, "Ola mundo");
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Problema na conexão" + e.toString());
			
		}
		
	}
	
}

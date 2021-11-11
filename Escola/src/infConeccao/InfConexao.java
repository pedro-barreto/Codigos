package infConeccao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class InfConexao {

	public Connection getConnection() {
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/escola_banco";
			String user = "root";
			String psw = "130278";
			
			return DriverManager.getConnection(url,user,psw);
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Erro na conexão" + e.toString());
			
		}
		
		return null;
		
	}
	
}

package implemento;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import botoes.Operar;
import contas.Aluno;
import infConeccao.InfConexao;

public class Implementacao implements Operar{
	
	
	public Connection connection;
	
	public Implementacao() {
		
		connection = new InfConexao().getConnection();
		
	}

	@Override
	public void cadastrar(Aluno aluno) {
		
		String sql = "insert into alunos (nome, nascimento, sexo, endereco, n, email, telefone, cpf) values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getNascimento());
			stmt.setString(3, aluno.getSexo());
			stmt.setString(4, aluno.getEndereco());
			stmt.setInt(5, aluno.getN());
			stmt.setString(6, aluno.getEmail());
			stmt.setString(7, aluno.getTelefone());
			stmt.setString(8, aluno.getCpf());
			
			stmt.execute();
			stmt.close();
			
		}catch(Exception e) {
			
			JOptionPane.showInternalMessageDialog(null, "Erro ao cadastrar!" + e.toString());
			
		}
		
	}

	@Override
	public List<Aluno> getLista() {

		try {
			
			List<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM alunos;");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setNascimento(rs.getNString("nascimento"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setEndereco(rs.getString("endereco"));
				aluno.setN(rs.getInt("n"));
				aluno.setEmail(rs.getString("email"));
				aluno.setTelefone(rs.getString("telefone"));
				aluno.setCpf(rs.getString("cpf"));
				
				alunos.add(aluno);
				
			}
			
			stmt.close();
			rs.close();
			
			return alunos;
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao exbir a lista!" + e.toString());
			
		}

		return null;
		
	}

	@Override
	public void alterar(Aluno aluno) {
		
		String sql = "update alunos set nome=?, nascimento=?, sexo=?, endereco=?, n=?, email=?, telefone=?, cpf=? where id=" + aluno.getId();
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getNascimento());
			stmt.setString(3, aluno.getSexo());
			stmt.setString(4, aluno.getEndereco());
			stmt.setInt(5, aluno.getN());
			stmt.setString(6, aluno.getEmail());
			stmt.setString(7, aluno.getTelefone());
			stmt.setString(8, aluno.getCpf());
			
			stmt.execute();
			stmt.close();
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null,"Erro ao editar" + e.toString());
			
		}
		
	}

	@Override
	public void remover(Long id) {
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement("delete from alunos where id=" + id);
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null,"Erro ao remover" + e.toString());
			
		}
		
	}

}

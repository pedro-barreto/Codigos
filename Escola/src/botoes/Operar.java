package botoes;

import java.util.List;
import contas.Aluno;

public interface Operar {
	
	public void cadastrar(Aluno aluno);
	public List<Aluno> getLista();
	public void alterar(Aluno aluno);
	public void remover(Long id);

}

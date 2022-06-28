#include <stdio.h>

//Sudoku do trabalho
//0 = vazio
int sudoku[9][9] = {	(5), (3), (0)  ,  (0), (7), (0)  ,  (0), (0), (0),
					  	(6), (0), (0)  ,  (1), (9), (5)  ,  (0), (0), (0),
					  	(0), (9), (8)  ,  (0), (0), (0)  ,  (0), (6), (0),
					  	
					  	(8), (0), (0)  ,  (0), (6), (0)  ,  (0), (0), (3),
					  	(4), (0), (0)  ,  (8), (0), (3)  ,  (0), (0), (1),
					  	(7), (0), (0)  ,  (0), (2), (0)  ,  (0), (0), (6), 
						   	
					  	(0), (6), (0)  ,  (0), (0), (0)  ,  (2), (8), (0),
					  	(0), (0), (0)  ,  (4), (1), (9)  ,  (0), (0), (5),
					  	(0), (0), (0)  ,  (0), (8), (0)  ,  (0), (7), (9)};

//Sudoku aleatorio pra teste					  	
/*int sudoku[9][9] = {	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0),
					  	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0),
					  	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0),
					  	
					  	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0),
					  	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0),
					  	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0), 
						   	
					  	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0),
					  	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0),
					  	(0), (0), (0)  ,  (0), (0), (0)  ,  (0), (0), (0)};*/

//parte visual, para ver como esta a tabela
void tabela(){
	
	int i, j;
	
	printf("-------------------------------------\n");
	
	for(i = 0 ; i <= 8 ; i++){
		
		printf("|");//linha vertical
		
		for(j = 0 ; j <= 8 ; j++){
			
			if(sudoku[i][j] == 0){//verifica se o espaço esta vazio(0), para deixar em branco
				
				printf("   |");
				
			}else{//caso não esteha vazio, imprimirá o número
				
				printf(" %d |", sudoku[i][j]);	
				
			}
			

		}
		
		printf("\n-------------------------------------\n");//linha horizontal
	
	}
	
}

int checarLinha(int numero, int linha){

	int i, verifica = 0;
	
	for(i = 0 ; i <= 8 ; i++){//percorre toda a linha escolhida
		
		if(sudoku[linha][i] == numero){//se a posição verificada for igual o número que eu quero colocar, vai incrementado o "verifica"
			
			verifica++;
			
		}
		
	}
		
	if(verifica > 0){//caso o "verifica" seja diferente de 0, o numero escolhido não pode ser colocado

		return 0;
		//numero escolhido já tem na linha
		
	}else{

		return 1;
		//numero escolhido pode ser colocado na linha
	}
		
}

int checarColuna(int numero, int coluna){//mesma coisa da linha, só que verifico a coluna

	int i, verifica = 0;
	
	for(i = 0 ; i <= 8 ; i++){
		
		if(sudoku[i][coluna] == numero){
			
			verifica++;
			
		}
		
	}
		
	if(verifica > 0){

		return 0;
		//numero escolhido já tem na coluna
		
	}else{

		return 1;
		//numero escolhido pode ser colocado na coluna
		
	}
		
}

int checarQuadrante(int numero, int linha, int coluna){
	
	int i, j, verifica = 0;

	if(linha >= 0 && linha <= 2){

		if(coluna >= 0 && coluna <= 2){//vejo em qual linha e coluna estou, para saber qual quadrante estou
			
			//Quadrante 1
			for(i = 0 ; i <= 2 ; i++){
				
				for(j = 0 ; j <= 2 ; j++){
					
					if(sudoku[i][j] == numero){//após isso verifico se no quadrante tem um numero que eu quero colocar
						
						verifica++;//caso exista, vai ser incrementado o "verifica"
						
					}
					
				}
				
			}
		
		}else if(coluna >= 3 && coluna <= 5){//faço o mesmo que o anterior, checo o quadrante e vejo se tem o número
			
			//Quadrante 2
			for(i = 0 ; i <= 2 ; i++){
				
				for(j = 3 ; j <= 5 ; j++){
					
					if(sudoku[i][j] == numero){
						
						verifica++;	
						
					}
					
				}
				
			}	
			
		}else if(coluna >= 6 && coluna <= 8){//faço o mesmo que o anterior, checo o quadrante e vejo se tem o número
			
			//Quadrante 3
			for(i = 0 ; i <= 2 ; i++){
				
				for(j = 6 ; j <= 8 ; j++){
					
					if(sudoku[i][j] == numero){
						
						verifica++;	
						
					}
					
				}
				
			}
				
		}
		
	}else if(linha >= 3 && linha <= 5){//faço o mesmo que o anterior, checo o quadrante e vejo se tem o número
		
		if(coluna >= 0 && coluna <= 2){

			//Quadrante 4
			for(i = 3 ; i <= 5 ; i++){
				
				for(j = 0 ; j <= 2 ; j++){
					
					if(sudoku[i][j] == numero){
						
						verifica++;	
						
					}
					
				}
				
			}
		
		}else if(coluna >= 3 && coluna <= 5){//faço o mesmo que o anterior, checo o quadrante e vejo se tem o número
			
			//Quadrante 5
			for(i = 3 ; i <= 5 ; i++){
				
				for(j = 3 ; j <= 5 ; j++){
					
					if(sudoku[i][j] == numero){
						
						verifica++;	
						
					}
					
				}
				
			}
			
		}else if(coluna >= 6 && coluna <= 8){//faço o mesmo que o anterior, checo o quadrante e vejo se tem o número
			
			//Quadrante 6
			for(i = 3 ; i <= 5 ; i++){
				
				for(j = 6 ; j <= 8 ; j++){
					
					if(sudoku[i][j] == numero){
						
						verifica++;	
						
					}
					
				}
				
			}
						
		}	
		
	}else if(linha >= 6 && linha <= 8){//faço o mesmo que o anterior, checo o quadrante e vejo se tem o número
		
		if(coluna >= 0 && coluna <= 2){

			//Quadrante 7
			for(i = 6 ; i <= 8 ; i++){
				
				for(j = 0 ; j <= 2 ; j++){
					
					if(sudoku[i][j] == numero){
						
						verifica++;	
						
					}
					
				}
				
			}
			
		
		}else if(coluna >= 3 && coluna <= 5){//faço o mesmo que o anterior, checo o quadrante e vejo se tem o número
			
			//Quadrante 8
			for(i = 6 ; i <= 8 ; i++){
				
				for(j = 3 ; j <= 5 ; j++){
					
					if(sudoku[i][j] == numero){
						
						verifica++;	
						
					}
					
				}
				
			}
			
		}else if(coluna >= 6 && coluna <= 8){//faço o mesmo que o anterior, checo o quadrante e vejo se tem o número
			
			//Quadrante 9
			for(i = 6 ; i <= 8 ; i++){
				
				for(j = 6 ; j <= 8 ; j++){
					
					if(sudoku[i][j] == numero){
						
						verifica++;	
						
					}
					
				}
				
			}
				
		}
		
	}
	
	if(verifica > 0){//caso o "verifica" seja diferente de 0, o numero escolhido não pode ser colocado
		
		//numero escolhido já tem no quadrante
		return 0;
		
	}else{
		
		//numero escolhido pode ser colocado no quadrante
		return 1;
			
	}
	
}

int checarTudo(int numero, int linha, int coluna){//se todas as funções retornarem verdadeira(1), o número pode ser colocado
	
	if(checarLinha(numero,linha) == 1 && checarColuna(numero,coluna) == 1 && checarQuadrante(numero,linha,coluna) == 1){
		
		return 1;//O numero pode ser colocado
		
	}else{
		
		return 0;//O numero não pode ser colocado
		
	}
	
}

int sudokuInicial[9][9];//sudoko inicial, onde vou receber os valores do sudoku, antes de alterar ele

void salvaTabela(){//salvando os valores do sudoku, antes de alterar
	
	int i, j;
	
	for(i = 0 ; i <= 8 ; i++){
		
		for(j = 0 ; j <= 8 ; j++){
			
			sudokuInicial[i][j] = sudoku[i][j];
			
		}
	
	}
	
}

void resetarTabela(){//voltando os valores do sudoku, antes de alterar
	
	int i, j;
	
	for(i = 0 ; i <= 8 ; i++){
		
		for(j = 0 ; j <= 8 ; j++){
			
			sudoku[i][j] = sudokuInicial[i][j];
			
		}
	
	}
	
}

int verificarSudoku(){//verifica se o sudoku esta seguindo as normas do jogo
	
	int i, j, verifica = 0;
	
	for(i = 0 ; i <= 8 ; i++){
		
		for(j = 0 ; j <= 8 ; j++){
		
			if(sudoku[i][j] != 0){//verifica somente os numeros colocados
				
				int numeroInicial = sudoku[i][j];
				sudoku[i][j] = 0;//salvando o numero e apagando ele temporariamente, pra ele não atrapalhar na verificação
				
				if(checarTudo(numeroInicial,i,j) == 0){//verificando se não segue as normas do jogo
					
					verifica++;
					
				}
				
				sudoku[i][j] = numeroInicial;//colocando o numero de volta
				
			}
		
		}
		
	}
	
	if(verifica > 0){
		
		return 0;//caso não tenha seguido as nosrmas do jogo, o "verifica" será incrementado e retornará falso
		
	}else{
		
		return 1;//caso siga as normas, será possivel resolver o sudoku
			
	}
	
}

void preencherTabela(){//preencher a tabela, onde passo por toda linha e coluna
	
	srand(time(NULL));//função para deixar os numeros de fato aletório a cada execução do programa
	
	int i, j, numero, repeticoes = 50;
	double tentativas = 0;
	
	if(verificarSudoku() == 1){
		
		salvaTabela();//salvar a tabela, antes de mexer nela
		
		for(i = 0 ; i <= 8 ; i++){
		
			for(j = 0 ; j <= 8 ; j++){
				
				if(sudoku[i][j] == 0){//verifico se a posição está vazia, para poder preencher
	
					int verifica = 0;
					
					while(verifica < repeticoes){//verifica quantos numeros eu tentei colocar, no caso 49x vou tentar
						
						numero = rand() % 9 + 1;//gerando um numero aleatorio de 0 a 8, e somando 1
						
						if(checarTudo(numero,i,j) == 1){//verifico se o numero aleatorio pode ser colocado
							
							sudoku[i][j] = numero;//coloco o numero na posição
							verifica = repeticoes;//já posso parar a repetição, sair do while e ir pra proxima
							
						}else{//caso o numero não possa ser colocado, vou tentar colocar outro
							
							verifica++;
							
							if(verifica == repeticoes){//se das 49 tentativas não der certo, eu reseto a tabela e tento outra combinação
								
								resetarTabela();
								tentativas++;//salvando as tentativas de vezes que tentei resolver a tabela
								
								i = 0;// valor 0 pois a primeira linha sempre será resolvida
								j = -1;//valor -1 pois quando sair daaqui será incrementado +1 e ficará com o valor 0
								
							}
							
						}
							
					}
					
				}
				
			}
			
		}
		
		printf("\n\n//////////////////////////////////////////\n\n");
		printf("\nTentativas: %.f\n",tentativas);//quantas vezes ele resetou a tabela e tentou de novo
		
		tabela();//tabela resolvida
		
	}else{
		
		printf("\nNao e possivel resolver esse sudoku\n");
		
	}

}

int main(int argc, char *argv[]) {
	
	tabela();//tabela inicial
	preencherTabela();//funcao para resolver a tabela
	
}

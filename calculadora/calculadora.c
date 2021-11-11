#include <stdio.h>
#include <locale.h>

float raiz(float num){
    int n;
    float r = num;
   
    for (n = 0; n < 10; ++n)
          r = r/2 + num/(2*r);
           
    return(r);    
}

int main(int argc, char *argv[]) {
	
	int sair=0,i,esc,esc2;
	
	setlocale(LC_ALL, "Portuguese");
	
	while(sair==0){
		
	//TABELA
	printf("\n\n\n------------------------------------FUNÇÕES-------------------------------------\n\n");
	
	printf("1 - Calculadora Basica          6 - volume de um cubo ou paralelepípedo\n\n");
	printf("2 - Bhaskara                    7 - volume de uma piramide\n\n");
	printf("3 - Cateto e Hipotenusa         8 - volumede de um triangulo prisma\n\n");
	printf("4 - Media                       9 - volume de um cone\n\n");
	printf("5 - Potência                   10 - volume de um cilindro\n\n");
	printf("\n0 - Sair\n");
	
	printf("\n--------------------------------------------------------------------------------");
		
	printf("\n\nDigite a função que você deseja realizar : ");
	scanf("%d",&esc);
	
		while(esc!=0 && esc!=1 && esc!=2 && esc!=3 && esc!=4 && esc!=5 && esc!=6 && esc!=7 && esc!=8 && esc!=9 && esc!=10){
		//SISTEMA DE REPETIÇÃO ENQUANTO O USUARIO NAO DIGITA UM NUMERO CORRESPONDENTE A TABELA		
			printf("\n\n\nNUMERO INVALIDO TENTE NOVAMENTE...\n\n");
			printf("\n------------------------------------FUNÇÕES-------------------------------------\n\n");
				
			printf("1 - Calculadora Basica          6 - volume de um cubo ou paralelepípedo\n\n");
			printf("2 - Bhaskara                    7 - volume de uma piramide\n\n");
			printf("3 - Cateto e Hipotenusa         8 - volumede de um triangulo prisma\n\n");
			printf("4 - Media                       9 - volume de um cone\n\n");
			printf("5 - Potência                   10 - volume de um cilindro\n\n");
			printf("\n0 - Sair\n");
				
			printf("\n--------------------------------------------------------------------------------");
							
			printf("\n\nDigite a função que você deseja realizar : ");
			scanf("%d",&esc);
			
			
		}
			
	if(esc==1){
		
	// CALULADORA BASICA E LER EXPRESSÃO NUMERICA
	printf("\n\nAinda nao esta concluido...\n\n\n");
	system("PAUSE");	
		
	}else if(esc==2){
	//INICIO DE BHASKARA	
		float a,b,c,delta,x,x1,x2;
		
		printf("\n\n\n\n------------------------------------BHASKARA------------------------------------\n\n\n");
			
		printf("\nDigite o valor de A : ");
		scanf("%f",&a);
		printf("\nDigite o valor de B : ");
		scanf("%f",&b);
		printf("\nDigite o valor de C : ");
		scanf("%f",&c);
			
			delta=(b*b)-(4*a*c);
			x1=(-b+raiz(delta))/(2*a);
			x2=(-b-raiz(delta))/(2*a);
				
			x=(-b)/(2*a);
			
				if(delta>0){
				
					printf("\nDelta = %g\n\nX1 = %g\n\nx2 = %g\n\n",delta,x1,x2);
				
				}else if(delta==0){	
					
					printf("\nDelta = 0\n\nX1 e X2 = %g\n\n",x);
									
				}else{
					
					printf("\nNão a raiz real\n\n");
					
				}
				system("PAUSE");
	
	// FIM DA FUNÇÃO BHASKARA
	
	}else if(esc==3){
	//INICIO DO CATETO E DA HIPOTENUSA	
		float cat1,cat2,hip;
		
		printf("\n\n\n------------------------------Cateto e Hipotenusa-------------------------------\n\n\n");
		printf("OBS: somente para ângulo reto(90° graus)");
		printf("\n\n\nVoce precisa do cateto ou da hipotenusa?");
		printf("\n\n 1 - Cateto       2 - Hipotenusa\n\n");
		scanf("%d",&esc2);
		
			if(esc2==1){
				
				printf("\nDigite o valor da Hipotenusa : ");
				scanf("%f",&cat1);
				printf("\nDigite o valor do cateto : ");
				scanf("%f",&hip);
									
					//ORGANIZANDO A SUBTRAÇÃO
					if(cat1>hip){ 
						cat2=(cat1*cat1)-(hip*hip); 
					}else{
						cat2=(hip*hip)-(cat1*cat1);
					}
								
				cat2=raiz(cat2);
				
				printf("\nO valo do cateto é : %g\n\n",cat2);
				
			}else if(esc2==2){
				
				printf("\nDigite o valor do cateto : ");
				scanf("%f",&cat1);
				printf("\nDigite o valor do outro cateto : ");
				scanf("%f",&cat2);
				
				hip=(cat1*cat1)+(cat2*cat2);
				hip=raiz(hip);
				
				printf("\nA Hipotenusa é : %g\n\n",hip);
				
			}else{	
				printf("Numero Invalido\n\n");				
			}
			
			system("PAUSE");
		
	//FIM DA FUNÇÃO CATETO E HIPTENUSA
		
	}else if(esc==4){
	//INICIO DA MEDIA	
		int m;
		float media,s=0;
		
		printf("\n\n\n-------------------------------------MEDIA--------------------------------------\n\n");
		
		printf("\nDigite quantos numeros você precisa pra media : ");
		scanf("%d",&m);
		
		for(i=1;i<=m;i++){
			printf("\nDigite o %d numero : ",i);
			scanf("%f",&media);	
			s+=media;
				
		}
		
		media=s/m;
		printf("\nA media é : %g\n\n",media);
		system("PAUSE");
		
	//FIM DA MEDIA
		
	}else if(esc==5){
	//INICIO DA POTENCIA
	//NAO FUNCIONA AINDA COM NUMERO NEGATIVO	
		int base,exp,pot=1;
		
		printf("\n\n\n-----------------------------------POTÊNCIA-------------------------------------\n");
		printf("\nDigite a base : ");
		scanf("%d",&base);
		printf("\nDigite o expoente : ");
		scanf("%d",&exp);
			
			for(i=1; i<=exp; i++){
				
				pot*=base;
			}  
			
		printf("\nA potência é : %d\n\n" ,pot);	
		
		system("PAUSE");
			
	//FIM DA POTENCIA
	
	}else if(esc==6){
	//INICIO DOS CUBOU OU...	
		float l,w,h,vol;
		printf("\n\n\n----------------------VOLUME DE UM CUBO OU PARALELEPÍPEDO-----------------------\n");
		printf("OBS: lembre-se de colocar todos valores na mesma unidade de comprimento.\n\n");
		
		/*DESENHO DO CUBO*/	printf("            _________\n            |\\	     \\ \n            | \\	      \\ \n          H |  \\_______\\ \n            |  |       |\n            |  |       |\n             \\ |       |\n             W\\|_______|                        \n                   L\n\n\n");
		
		printf("Digite valor de L : ");
		scanf("%f",&l);
		printf("Digite valor de W : ");
		scanf("%f",&w);
		printf("Digite valor de H : ");
		scanf("%f",&h);
		
			if(l>0 && w>0 && h>0){
				
				vol=l*w*h;
				printf("\nO Volume é : %g\n\n",vol);
				
			}else{
				
				printf("\nNão é posivel um dos valores ser 0 ou negativo\n\n");
				
			}
		
			system("PAUSE");
	//FIM DO CUBO	
	}else if(esc==7){
	//INICIO DAS PIRAMIDES
		float lp,wp,hp,volp;
		
		printf("\n\n\n-------------------------------VOLUME DA PIRAMIDE-------------------------------\n");
		printf("OBS: lembre-se de colocar todos valores na mesma unidade de comprimento.\n\n");

		/*DESENHO DA PIRAMIDE OU ALGO PARECIDO*/printf("              ---\n     /\\\\       |\n    /  \\ \\     |\n   /    \\  \\   |H\n  /      \\  /  |\n /________\\/ W |\n      L       ---\n\n");
		
		printf("Digite o valor de L : ");
		scanf("%f",&lp);
		printf("Digite o valor de W : ");
		scanf("%f",&wp);
		printf("Digite o valor de H (Altura) : ");
		scanf("%f",&hp); 
		
		if(lp>0 && wp>0 && hp>0){
			
			volp=(lp*wp*hp)/3;
			printf("\nO volume da piramide é : %g\n\n",volp);
			
		}else{
			
			printf("\nNão é posivel um dos valores ser 0 ou negativo\n\n");
			
		}
		
		system("PAUSE");
		                   
	//FIM DAS PIRAMIDES
						     	    	
	}else if(esc==8){
	//INICIO DO TRIANGULO PRISMA
		float bt,lt,ht,volt;

		printf("\n\n\n-----------------------VOLUME DE UM TRIANGULO PRISMA----------------------------\n\n");
		printf("OBS: lembre-se de colocar todos valores na mesma unidade de comprimento.\n\n");
		
	/*DESENHO DO TRIANGULO PRISMA OU ALGO PARECIDO*/printf("         /\\ \n        /  \\ \n       /     \\ \n     /\\       \\ \n    /| \\      / \n   / |  \\    /L \n  /  |H  \\  / \n /___|____\\/ \n     B \n")  ;
	
		printf("\nDigite o valor de B : ");
		scanf("%f",&bt);
		printf("\nDigite o valor de L : ");
		scanf("%f",&lt);
		printf("\nDigite o valor de H (Altura) : ");
		scanf("%f",&ht); 
		
			if(bt>0 && lt>0 && ht>0){
				volt=(bt*lt*ht)/3;
				printf("\n\nO volume do triangulo prisma é : %g\n\n",volt);
			}else{
			
				printf("\nNão é posivel um dos valores ser 0 ou negativo\n\n");
			}
				         			   
		    system("PAUSE");              	
	//FIM DO TRIANGULO PRISMA
	}else if(esc==9){
		
		float rc,hc,volc;
		
		printf("\n\n\n-----------------------------VOLUME DE UM CONE----------------------------------\n\n");
		printf("OBS: lembre-se de colocar todos valores na mesma unidade de comprimento.\n\n");
		
		printf("\nDigite o raio do cone : ");
		scanf("%f",&rc);
		printf("\nDigite a altura do cone : ");
		scanf("%f",&hc);
		
		if(rc>0 && hc>0){
			
			volc=((rc*rc)*hc)/3;

			printf("\n\nResultado : %gpi\n\n",volc);
			
		}else{
			
			printf("\nNão é posivel um dos valores ser 0 ou negativo\n\n");
			
		}
		
		system("PAUSE");
	//FIM DOS CONES
	
	}else if(esc==10){
	//INICIO DOS CILINDROS
		
		float rci,hci,volci1,volci2,volci3;
		
		printf("\n\n\n--------------------------VOLUME DE UM CILINDRO---------------------------------\n\n");
		printf("OBS: lembre-se de colocar todos valores na mesma unidade de comprimento.\n\n");
		
		printf("\nDigite o valor do raio : ");
		scanf("%f",&rci);
		printf("\nDigite o valor da altura : ");
		scanf("%f",&hci);
		
			if(rci>0 && hci>0){
				
				volci1=((rci*rci)*hci)*3;
				volci2=((rci*rci)*hci)*3.14;
				volci3=(rci*rci)*hci;
				
				printf("\n\nRESULTADO\n");
				printf("\nPI = 3 resultado é : %g\n",volci1);
				printf("\nPI = 3,14 resultado é : %g\n",volci2);
				printf("\nPode ser represemtado como : %gpi\n\n",volci3);
				
			}else{
				
				printf("\nNão é posivel um dos valores ser 0 ou negativo\n\n");
				
			}
			
			system("PAUSE");
			
	//FIM DOS CILINDROS	
		
	}else if(esc==0){
		sair=1;
			
	}else{
		
		printf("ERRO");
			
	}
}
}

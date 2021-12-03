package conteudo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Bola {

	Configuracoes config = new Configuracoes();
	Jogador jogador = new Jogador();

	private Image imagem;

	private int x, y;

	private int dx = config.getEscolhaVelocidade();
	private int dy = config.getEscolhaVelocidade();

	private int dxAnterior;
	private int dyAnterior;

	private int Largura = 50;
	private int Altura = 50;

	private boolean verificacao = true;

	private int limiteX = new Random().nextInt(config.getLARGURA() - jogador.getLargura() - config.getParedeX() * 2)
			+ config.getParedeX();

	private int limiteY = new Random().nextInt(config.getALTURA() - jogador.getAltura() - config.getParedeY() * 2)
			+ config.getParedeY();

	public Bola(int x, int y) {

		ImageIcon referencia = new ImageIcon("img\\Bola.png");
		imagem = referencia.getImage();

		while (verificacao) {

			if (limiteX > config.getLARGURA() / 2 - 175 && limiteX < config.getLARGURA() / 2 + 125
					&& limiteY > config.getALTURA() / 2 - 175 && limiteY < config.getALTURA() / 2 + 125) {

				limiteX = new Random().nextInt(config.getLARGURA() - jogador.getLargura() - config.getParedeX() * 2)
						+ config.getParedeX();
				limiteY = new Random().nextInt(config.getALTURA() - jogador.getAltura() - config.getParedeY() * 2)
						+ config.getParedeY();

			} else {

				verificacao = false;

			}

		}

		this.x = limiteX;
		this.y = limiteY;

	}

	public void update() {

		this.x += dx;
		this.y += dy;

	}

	public Rectangle getBound() {

		return new Rectangle(x + jogador.getLargura() / 2, y + jogador.getAltura() / 2, Largura, Altura);

	}

	public int getX() {

		return x;

	}

	public void setX(int x) {

		this.x = x;

	}

	public int getY() {

		return y;

	}

	public void setY(int y) {

		this.y = y;

	}

	public Image getImagem() {

		return imagem;

	}

	public int getLargura() {

		return Largura;

	}

	public int getAltura() {

		return Altura;

	}

	public int getDx() {

		return dx;

	}

	public int getDy() {

		return dy;

	}

	public void setDx(int dx) {

		this.dx = dx;

	}

	public void setDy(int dy) {

		this.dy = dy;

	}

	public int getDxAnterior() {

		return dxAnterior;

	}

	public void setDxAnterior(int dxAnterior) {

		this.dxAnterior = dxAnterior;

	}

	public int getDyAnterior() {

		return dyAnterior;

	}

	public void setDyAnterior(int dyAnterior) {

		this.dyAnterior = dyAnterior;

	}

}
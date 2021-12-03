package conteudo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Jogador {

	private Image cursor;
	private int x, y;

	private int Largura = 50;
	private int Altura = 50;

	public void upload() {

		ImageIcon referencia = new ImageIcon("img\\Jogador.png");
		cursor = referencia.getImage();

	}

	public Rectangle getBound() {

		return new Rectangle(x, y, Largura, Altura);

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

	public int getLargura() {

		return Largura;

	}

	public int getAltura() {

		return Altura;

	}

	public Image getCursor() {

		return cursor;

	}

}

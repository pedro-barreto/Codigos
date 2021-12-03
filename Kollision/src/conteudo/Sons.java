package conteudo;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sons {

	public void tocarColisaoBolaNaParede() {

		try {

			AudioInputStream SomColisao = AudioSystem.getAudioInputStream(new File("som\\ColisaoBola.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(SomColisao);
			clip.start();

		} catch (Exception ex) {

			// erro

		}

	}
	
	public void tocarCliqueBotao() {

		try {

			AudioInputStream SomColisao = AudioSystem.getAudioInputStream(new File("som\\Clique.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(SomColisao);
			clip.start();

		} catch (Exception ex) {

			// erro

		}

	}

}

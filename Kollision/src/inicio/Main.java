package inicio;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import conteudo.Bola;
import conteudo.Configuracoes;
import conteudo.Jogador;
import conteudo.Sons;

public class Main extends Canvas implements Runnable {

	Jogador jogador = new Jogador();
	Configuracoes config = new Configuracoes();
	Sons som = new Sons();

	private List<Bola> bolas;

	private int minutos, segundos, pontos;
	private int safeMin, safeSec, safePon;

	private boolean emInicio = true;
	private boolean emJogo = false;
	private boolean emDerrota = false;
	private boolean emConfig = false;
	private boolean emPause = false;

	private boolean emVelocidade = false;
	private boolean emQuantidade = false;
	private boolean emMapa = false;

	private boolean verificacao = true;
	private int verificarVoltar = 0;

	private int limiteX = new Random().nextInt(config.getLARGURA() - jogador.getLargura() - config.getParedeX() * 2)
			+ config.getParedeX();

	private int limiteY = new Random().nextInt(config.getALTURA() - jogador.getAltura() - config.getParedeY() * 2)
			+ config.getParedeY();

	public Main() {

		this.setPreferredSize(new Dimension(config.getLARGURA(), config.getALTURA()));

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {

				jogador.setX(e.getX());
				jogador.setY(e.getY());

				if (emInicio) {

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 - 40 && e.getY() <= config.getALTURA() / 2 + 40) {

						config.setBtnPlay(config.getVerde());

					} else {

						config.setBtnPlay(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 60 && e.getY() <= config.getALTURA() / 2 + 140) {

						config.setBtnSettingInicio(config.getVerde());

					} else {

						config.setBtnSettingInicio(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 160 && e.getY() <= config.getALTURA() / 2 + 240) {

						config.setBtnExitInicio(config.getVermelho());

					} else {

						config.setBtnExitInicio(config.getBranco());

					}

				}

				if (emConfig) {

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 - 140 && e.getY() <= config.getALTURA() / 2 - 60) {

						config.setBtnVelocidade(config.getVerde());

					} else {

						config.setBtnVelocidade(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 - 40 && e.getY() <= config.getALTURA() / 2 + 40) {

						config.setBtnQuantidade(config.getVerde());

					} else {

						config.setBtnQuantidade(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 60 && e.getY() <= config.getALTURA() / 2 + 140) {

						config.setBtnMapa(config.getVerde());

					} else {

						config.setBtnMapa(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 160 && e.getY() <= config.getALTURA() / 2 + 240) {

						config.setBtnVoltar(config.getVermelho());

					} else {

						config.setBtnVoltar(config.getBranco());

					}

				}

				if (emDerrota) {

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 - 40 && e.getY() <= config.getALTURA() / 2 + 40) {

						config.setBtnRetry(config.getVermelho());

					} else {

						config.setBtnRetry(config.getPreto());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 60 && e.getY() <= config.getALTURA() / 2 + 140) {

						config.setBtnSettingDerrota(config.getVermelho());

					} else {

						config.setBtnSettingDerrota(config.getPreto());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 160 && e.getY() <= config.getALTURA() / 2 + 240) {

						config.setBtnExitDerrota(config.getVerde());

					} else {

						config.setBtnExitDerrota(config.getPreto());

					}

				}

				if (emVelocidade) {

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 120 && e.getY() <= 170) {

						config.setBtnVID(config.getCiano());

					} else {

						config.setBtnVID(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 120 && e.getY() <= 170) {

						config.setBtnVIA(config.getCiano());

					} else {

						config.setBtnVIA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 220 && e.getY() <= 270) {

						config.setBtnLMD(config.getCiano());

					} else {

						config.setBtnLMD(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 220 && e.getY() <= 270) {

						config.setBtnLMA(config.getCiano());

					} else {

						config.setBtnLMA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 320 && e.getY() <= 370) {

						config.setBtnTAVD(config.getCiano());

					} else {

						config.setBtnTAVD(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 320 && e.getY() <= 370) {

						config.setBtnTAVA(config.getCiano());

					} else {

						config.setBtnTAVA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 420 && e.getY() <= 470) {

						config.setBtnAVD(config.getCiano());

					} else {

						config.setBtnAVD(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 420 && e.getY() <= 470) {

						config.setBtnAVA(config.getCiano());

					} else {

						config.setBtnAVA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() - 100 && e.getY() <= config.getALTURA() - 20) {

						config.setBtnExitVelocidade(config.getVermelho());

					} else {

						config.setBtnExitVelocidade(config.getBranco());

					}

				}

				if (emQuantidade) {

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 120 && e.getY() <= 170) {

						config.setBtnQID(config.getCiano());

					} else {

						config.setBtnQID(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 120 && e.getY() <= 170) {

						config.setBtnQIA(config.getCiano());

					} else {

						config.setBtnQIA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 220 && e.getY() <= 270) {

						config.setBtnLBD(config.getCiano());

					} else {

						config.setBtnLBD(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 220 && e.getY() <= 270) {

						config.setBtnLBA(config.getCiano());

					} else {

						config.setBtnLBA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 320 && e.getY() <= 370) {

						config.setBtnTAQD(config.getCiano());

					} else {

						config.setBtnTAQD(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 320 && e.getY() <= 370) {

						config.setBtnTAQA(config.getCiano());

					} else {

						config.setBtnTAQA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() - 100 && e.getY() <= config.getALTURA() - 20) {

						config.setBtnExitQuantidade(config.getVermelho());

					} else {

						config.setBtnExitQuantidade(config.getBranco());

					}

				}

				if (emMapa) {

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 120 && e.getY() <= 170) {

						config.setBtnLD(config.getCiano());

					} else {

						config.setBtnLD(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 120 && e.getY() <= 170) {

						config.setBtnLA(config.getCiano());

					} else {

						config.setBtnLA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 220 && e.getY() <= 270) {

						config.setBtnAD(config.getCiano());

					} else {

						config.setBtnAD(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 220 && e.getY() <= 270) {

						config.setBtnAA(config.getCiano());

					} else {

						config.setBtnAA(config.getBranco());

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() - 100 && e.getY() <= config.getALTURA() - 20) {

						config.setBtnExitMapa(config.getVermelho());

					} else {

						config.setBtnExitMapa(config.getBranco());

					}

				}

			}

			@Override
			public void mouseDragged(MouseEvent e) {

			}
		});

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

				if (emInicio) {

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 - 40 && e.getY() <= config.getALTURA() / 2 + 40) {

						som.tocarCliqueBotao();

						tempo();

						inicializarBolas();

						emInicio = false;
						emJogo = true;

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 60 && e.getY() <= config.getALTURA() / 2 + 140) {

						som.tocarCliqueBotao();

						emInicio = false;
						emConfig = true;

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 160 && e.getY() <= config.getALTURA() / 2 + 240) {

						som.tocarCliqueBotao();
						System.exit(0);

					}

				} else if (emConfig) {

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 - 140 && e.getY() <= config.getALTURA() / 2 - 60) {

						som.tocarCliqueBotao();

						emConfig = false;
						emVelocidade = true;

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 - 40 && e.getY() <= config.getALTURA() / 2 + 40) {

						som.tocarCliqueBotao();

						emConfig = false;
						emQuantidade = true;

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 60 && e.getY() <= config.getALTURA() / 2 + 140) {

						som.tocarCliqueBotao();

						emConfig = false;
						emMapa = true;

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 160 && e.getY() <= config.getALTURA() / 2 + 240) {

						som.tocarCliqueBotao();
						salvarInformacao();
						
						if (verificarVoltar == 0) {
							
							emConfig = false;
							emInicio = true;
							
						}else {
							
							emConfig = false;
							emDerrota = true;
							
						}
						

					}

				} else if (emVelocidade) {

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 120 && e.getY() <= 170) {

						if (config.getVelocidade() > 1) {
							
							som.tocarCliqueBotao();

							config.setVelocidade(config.getVelocidade() - 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 120 && e.getY() <= 170) {

						if (config.getVelocidade() < 35) {
							
							som.tocarCliqueBotao();

							config.setVelocidade(config.getVelocidade() + 1);

							if (config.getVelocidade() > config.getLimitadorDeVelocidade()) {

								config.setLimitadorDeVelocidade(config.getLimitadorDeVelocidade() + 1);

							}

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 220 && e.getY() <= 270) {

						if (config.getLimitadorDeVelocidade() > 1) {
							
							som.tocarCliqueBotao();

							config.setLimitadorDeVelocidade(config.getLimitadorDeVelocidade() - 1);

							if (config.getLimitadorDeVelocidade() < config.getVelocidade()) {

								config.setVelocidade(config.getVelocidade() - 1);

							}

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 220 && e.getY() <= 270) {

						if (config.getLimitadorDeVelocidade() < 35) {
							
							som.tocarCliqueBotao();

							config.setLimitadorDeVelocidade(config.getLimitadorDeVelocidade() + 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 320 && e.getY() <= 370) {

						if (config.getTempoAumentoVelocidade() > 1) {
							
							som.tocarCliqueBotao();

							config.setTempoAumentoVelocidade(config.getTempoAumentoVelocidade() - 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 320 && e.getY() <= 370) {

						if (config.getTempoAumentoVelocidade() < 60) {
							
							som.tocarCliqueBotao();

							config.setTempoAumentoVelocidade(config.getTempoAumentoVelocidade() + 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 420 && e.getY() <= 470) {

						if (config.getAumentoDaVelocidade() > 1) {

							som.tocarCliqueBotao();
							
							config.setAumentoDaVelocidade(config.getAumentoDaVelocidade() - 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 420 && e.getY() <= 470) {

						if (config.getAumentoDaVelocidade() < 5) {
							
							som.tocarCliqueBotao();

							config.setAumentoDaVelocidade(config.getAumentoDaVelocidade() + 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() - 100 && e.getY() <= config.getALTURA() - 20) {
						
						som.tocarCliqueBotao();

						emVelocidade = false;
						emConfig = true;

					}

				} else if (emQuantidade) {

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 120 && e.getY() <= 170) {

						if (config.getQuantidadeInicial() > 1) {
							
							som.tocarCliqueBotao();

							config.setQuantidadeInicial(config.getQuantidadeInicial() - 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 120 && e.getY() <= 170) {

						if (config.getQuantidadeInicial() < 10) {
							
							som.tocarCliqueBotao();

							config.setQuantidadeInicial(config.getQuantidadeInicial() + 1);

							if (config.getQuantidadeInicial() > config.getLimitadorDeBolas()) {

								config.setLimitadorDeBolas(config.getLimitadorDeBolas() + 1);

							}

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 220 && e.getY() <= 270) {

						if (config.getLimitadorDeBolas() > 1) {
							
							som.tocarCliqueBotao();

							config.setLimitadorDeBolas(config.getLimitadorDeBolas() - 1);

							if (config.getLimitadorDeBolas() < config.getQuantidadeInicial()) {

								config.setQuantidadeInicial(config.getQuantidadeInicial() - 1);

							}

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 220 && e.getY() <= 270) {

						if (config.getLimitadorDeBolas() < 10) {
							
							som.tocarCliqueBotao();

							config.setLimitadorDeBolas(config.getLimitadorDeBolas() + 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 320 && e.getY() <= 370) {

						if (config.getTempoDeSpawnerDeBolas() > 1) {
							
							som.tocarCliqueBotao();

							config.setTempoDeSpawnerDeBolas(config.getTempoDeSpawnerDeBolas() - 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 320 && e.getY() <= 370) {

						if (config.getTempoDeSpawnerDeBolas() < 60) {
							
							som.tocarCliqueBotao();

							config.setTempoDeSpawnerDeBolas(config.getTempoDeSpawnerDeBolas() + 1);

						}

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() - 100 && e.getY() <= config.getALTURA() - 20) {
						
						som.tocarCliqueBotao();

						emQuantidade = false;
						emConfig = true;

					}

				} else if (emMapa) {

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 120 && e.getY() <= 170) {
						
						som.tocarCliqueBotao();

						System.out.println("Menos largura");

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 120 && e.getY() <= 170) {
						
						som.tocarCliqueBotao();

						System.out.println("Mais largura");

					}

					if (e.getX() >= config.getLARGURA() / 2 - 160 && e.getX() <= config.getLARGURA() / 2 - 100
							&& e.getY() >= 220 && e.getY() <= 270) {
						
						som.tocarCliqueBotao();

						System.out.println("Menos altura");

					}

					if (e.getX() >= config.getLARGURA() / 2 + 100 && e.getX() <= config.getLARGURA() / 2 + 160
							&& e.getY() >= 220 && e.getY() <= 270) {
						
						som.tocarCliqueBotao();

						System.out.println("Mais altura");

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() - 100 && e.getY() <= config.getALTURA() - 20) {
						
						som.tocarCliqueBotao();

						emMapa = false;
						emConfig = true;

					}

				} else if (emDerrota) {

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 - 40 && e.getY() <= config.getALTURA() / 2 + 40) {

						som.tocarCliqueBotao();
						inicializarBolas();

						emDerrota = false;
						emJogo = true;

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 60 && e.getY() <= config.getALTURA() / 2 + 140) {

						som.tocarCliqueBotao();

						emDerrota = false;
						emConfig = true;

					}

					if (e.getX() >= config.getLARGURA() / 2 - 120 && e.getX() <= config.getLARGURA() / 2 + 130
							&& e.getY() >= config.getALTURA() / 2 + 160 && e.getY() <= config.getALTURA() / 2 + 240) {

						som.tocarCliqueBotao();
						System.exit(0);

					}

				}

			}

			@Override
			public void mouseExited(MouseEvent e) {

				if (emJogo) {

					for (int i = 0; i < bolas.size(); i++) {

						Bola bola = bolas.get(i);

						bola.setDxAnterior(bola.getDx());
						bola.setDyAnterior(bola.getDy());

						bola.setDx(0);
						bola.setDy(0);

					}

					emPause = true;

				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				if (emJogo) {

					for (int i = 0; i < bolas.size(); i++) {

						Bola bola = bolas.get(i);

						bola.setDx(bola.getDxAnterior());
						bola.setDy(bola.getDyAnterior());

					}

					emPause = false;

				}

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});

	}

	public static void main(String[] args) {

		Main main = new Main();
		JFrame frame = new JFrame("Kollision");

		frame.add(main);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		new Thread(main).start();

	}

	public void trick() {

		if (emJogo) {

			colisaoJogador();
			colisaoBola();

			jogador.upload();

			for (int i = 0; i < bolas.size(); i++) {

				Bola bola = bolas.get(i);

				bola.update();

			}
			
			if (config.getVelocidade() > config.getLimitadorDeVelocidade()) {
				
				config.setVelocidade(config.getVelocidade()-1);
				
			}

		}

	}

	public void render() {

		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {

			this.createBufferStrategy(3);
			return;

		}

		Graphics g = bs.getDrawGraphics();

		if (emInicio) {

			// TELA INICIO

			g.setColor(Color.white);
			g.fillRect(0, 0, config.getLARGURA(), config.getALTURA());

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("KOLLISION", config.getLARGURA() / 2 - 130, 100);

			// BOTOES INICIO

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 - 40, 250, 80);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 + 60, 250, 80);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 + 160, 250, 80);

			// STRINGS DOS BOTOES

			g.setColor(config.getBtnPlay());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Play", config.getLARGURA() / 2 - 40, config.getALTURA() / 2 + 15);

			g.setColor(config.getBtnSettingInicio());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Settings", config.getLARGURA() / 2 - 70, config.getALTURA() / 2 + 115);

			g.setColor(config.getBtnExitInicio());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Exit", config.getLARGURA() / 2 - 35, config.getALTURA() / 2 + 215);

		} else if (emJogo) {

			Image cursorImage = Toolkit.getDefaultToolkit().getImage("");
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0, 0), "");
			setCursor(blankCursor);

			// INFORMAÇÕES

			g.setColor(Color.white);
			g.fillRect(0, 0, config.getLARGURA(), config.getALTURA());

			g.setColor(Color.green);
			g.drawRect(config.getLARGURA() / 2 - 125, config.getALTURA() / 2 - 125, 250, 250);

			g.setColor(Color.orange);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Área Segura", config.getLARGURA() / 2 - 115, config.getALTURA() / 2 + 20);

			g.setColor(Color.blue);
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.drawString("Dentro do quadrado verde não nasce bolas", config.getLARGURA() / 2 - 150,
					config.getALTURA() / 2 + 150);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Tempo - " + minutos + ":" + segundos, config.getParedeX() + 5,
					config.getYCX() + config.getParedeY() + 20);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Pontos : " + pontos, config.getLARGURA() - config.getParedeX() - 150,
					config.getYCX() + config.getParedeY() + 20);

			g.setColor(Color.darkGray);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Velocidade : " + config.getVelocidade(), config.getXEX() + config.getParedeX() + 5,
					config.getALTURA() - (config.getYCX() + config.getParedeY() + 5));

			g.setColor(Color.darkGray);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Bolas : " + config.getQuantidadeAtual(), config.getXEX() + config.getParedeX() + 5,
					config.getALTURA() - (config.getYCX() + config.getParedeY() + 30));

			// PAREDES

			g.setColor(Color.black);
			g.fillRect(config.getXEX(), config.getXEY(), config.getXELargura(), config.getXEAltura());

			g.setColor(Color.black);
			g.fillRect(config.getXDX(), config.getXDY(), config.getXDLargura(), config.getXDAltura());

			g.setColor(Color.black);
			g.fillRect(config.getYCX(), config.getYCY(), config.getYCLargura(), config.getYCAltura());

			g.setColor(Color.black);
			g.fillRect(config.getYBX(), config.getYBY(), config.getYBLargura(), config.getYBAltura());

			g.drawImage(jogador.getCursor(), jogador.getX() - jogador.getLargura() / 2,
					jogador.getY() - jogador.getAltura() / 2, this);

			for (int i = 0; i < bolas.size(); i++) {

				Bola bola = bolas.get(i);
				g.drawImage(bola.getImagem(), bola.getX(), bola.getY(), this);

			}

			if (emPause) {

				g.setColor(Color.black);
				g.fillRect(0, 0, config.getLARGURA(), config.getALTURA());

				g.setColor(Color.white);
				g.setFont(new Font("Arial", Font.BOLD, 100));
				g.drawString("Pause", config.getLARGURA() / 2 - 150, 100);

				g.setColor(Color.red);
				g.setFont(new Font("Arial", Font.BOLD, 20));
				g.drawString("Coloque o mouse na tela para dar PLAY!", config.getLARGURA() / 2 - 190,
						config.getALTURA() / 2 + 50);

			}

		} else if (emDerrota) {

			setCursor(null);

			g.setColor(Color.black);
			g.fillRect(0, 0, config.getLARGURA(), config.getALTURA());

			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("GAME OVER", config.getLARGURA() / 2 - 150, 60);

			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Tempo - " + safeMin + ":" + safeSec, config.getLARGURA() / 2 - 130, 150);

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Pontos : " + safePon, config.getLARGURA() / 2 - 130, 200);

			// BOTÕES

			g.setColor(Color.white);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 - 40, 250, 80);

			g.setColor(Color.white);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 + 60, 250, 80);

			g.setColor(Color.white);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 + 160, 250, 80);

			// STRINGS DOS BOTOES

			g.setColor(config.getBtnRetry());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Try Again", config.getLARGURA() / 2 - 85, config.getALTURA() / 2 + 15);

			g.setColor(config.getBtnSettingDerrota());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Settings", config.getLARGURA() / 2 - 70, config.getALTURA() / 2 + 115);

			g.setColor(config.getBtnExitDerrota());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Exit", config.getLARGURA() / 2 - 35, config.getALTURA() / 2 + 215);

		} else if (emConfig) {

			setCursor(null);

			g.setColor(Color.white);
			g.fillRect(0, 0, config.getLARGURA(), config.getALTURA());

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("CONFIGURAÇÕES", config.getLARGURA() / 2 - 175, 50);

			// BOTÕES

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 - 140, 250, 80);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 - 40, 250, 80);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 + 60, 250, 80);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() / 2 + 160, 250, 80);

			// STRING DOS BOTÕES

			g.setColor(config.getBtnVelocidade());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Velocidade", config.getLARGURA() / 2 - 100, config.getALTURA() / 2 - 85);

			g.setColor(config.getBtnQuantidade());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Quantidade", config.getLARGURA() / 2 - 100, config.getALTURA() / 2 + 15);

			g.setColor(config.getBtnMapa());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Mapa", config.getLARGURA() / 2 - 45, config.getALTURA() / 2 + 115);

			g.setColor(config.getBtnVoltar());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Voltar", config.getLARGURA() / 2 - 50, config.getALTURA() / 2 + 215);

		} else if (emVelocidade) {

			setCursor(null);

			g.setColor(Color.white);
			g.fillRect(0, 0, config.getLARGURA(), config.getALTURA());

			g.setColor(Color.black);
			g.fillRect(0, 50, config.getLARGURA(), 5);

			// BOTÕES

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 120, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 220, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 320, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 420, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() - 100, 250, 80);

			// STRING DOS BOTÕES

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Velocidade das Bolas", config.getLARGURA() / 2 - 145, 35);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Velocidade Inicial", config.getLARGURA() / 2 - 80, 110);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Limite de Velocidade", config.getLARGURA() / 2 - 100, 210);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Tempo para Aumentar a Velocidade", config.getLARGURA() / 2 - 167, 310);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Aumento de Velocidade", config.getLARGURA() / 2 - 110, 410);

			g.setColor(config.getBtnExitVelocidade());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Voltar", config.getLARGURA() / 2 - 55, config.getALTURA() - 45);

			// INFORMAÇÕES DO BOTÃO

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("" + config.getVelocidade(), config.getLARGURA() / 2 - 5, 153);

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("" + config.getLimitadorDeVelocidade(), config.getLARGURA() / 2 - 5, 253);

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("" + config.getTempoAumentoVelocidade() + "s", config.getLARGURA() / 2 - 10, 353);

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("" + config.getAumentoDaVelocidade() + " a cada " + config.getTempoAumentoVelocidade() + "s",
					config.getLARGURA() / 2 - 55, 453);

			// BOTOES AUMENTAR E DIMINUIR

			if (config.getVelocidade() > 1) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 - 160, 120, 60, 50);

				g.setColor(config.getBtnVID());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("<", config.getLARGURA() / 2 - 145, 167);

			}

			if (config.getVelocidade() < 35) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 + 100, 120, 60, 50);

				g.setColor(config.getBtnVIA());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString(">", config.getLARGURA() / 2 + 115, 167);

			}

			if (config.getLimitadorDeVelocidade() > 1) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 - 160, 220, 60, 50);

				g.setColor(config.getBtnLMD());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("<", config.getLARGURA() / 2 - 145, 267);

			}

			if (config.getLimitadorDeVelocidade() < 35) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 + 100, 220, 60, 50);

				g.setColor(config.getBtnLMA());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString(">", config.getLARGURA() / 2 + 115, 267);

			}

			if (config.getTempoAumentoVelocidade() > 1) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 - 160, 320, 60, 50);

				g.setColor(config.getBtnTAVD());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("<", config.getLARGURA() / 2 - 145, 367);

			}

			if (config.getTempoAumentoVelocidade() < 60) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 + 100, 320, 60, 50);

				g.setColor(config.getBtnTAVA());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString(">", config.getLARGURA() / 2 + 115, 367);

			}

			if (config.getAumentoDaVelocidade() > 1) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 - 160, 420, 60, 50);

				g.setColor(config.getBtnAVD());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("<", config.getLARGURA() / 2 - 145, 467);

			}
			if (config.getAumentoDaVelocidade() < 5) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 + 100, 420, 60, 50);

				g.setColor(config.getBtnAVA());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString(">", config.getLARGURA() / 2 + 115, 467);

			}

		} else if (emQuantidade) {

			setCursor(null);

			g.setColor(Color.white);
			g.fillRect(0, 0, config.getLARGURA(), config.getALTURA());

			g.setColor(Color.black);
			g.fillRect(0, 50, config.getLARGURA(), 5);

			// VALORES

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 120, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 220, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 320, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() - 100, 250, 80);

			// STRING DOS VALORES

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Quantidade de Bolas", config.getLARGURA() / 2 - 145, 35);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Quantidade Inicial", config.getLARGURA() / 2 - 85, 110);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Limite de Bolas", config.getLARGURA() / 2 - 70, 210);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Tempo para Aumentar a Quantidade", config.getLARGURA() / 2 - 167, 310);

			g.setColor(config.getBtnExitQuantidade());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Voltar", config.getLARGURA() / 2 - 55, config.getALTURA() - 45);

			// INFORMAÇÕES DOS VALORES

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("" + config.getQuantidadeInicial(), config.getLARGURA() / 2 - 10, 153);

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("" + config.getLimitadorDeBolas(), config.getLARGURA() / 2 - 5, 253);

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString(config.getTempoDeSpawnerDeBolas() + "s", config.getLARGURA() / 2 - 10, 353);

			// BOTOES AUMENTAR E DIMINUIR

			if (config.getQuantidadeInicial() > 1) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 - 160, 120, 60, 50);

				g.setColor(config.getBtnQID());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("<", config.getLARGURA() / 2 - 145, 167);

			}

			if (config.getQuantidadeInicial() < 10) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 + 100, 120, 60, 50);

				g.setColor(config.getBtnQIA());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString(">", config.getLARGURA() / 2 + 115, 167);

			}

			if (config.getLimitadorDeBolas() > 1) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 - 160, 220, 60, 50);

				g.setColor(config.getBtnLBD());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("<", config.getLARGURA() / 2 - 145, 267);

			}

			if (config.getLimitadorDeBolas() < 10) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 + 100, 220, 60, 50);

				g.setColor(config.getBtnLBA());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString(">", config.getLARGURA() / 2 + 115, 267);

			}

			if (config.getTempoDeSpawnerDeBolas() > 1) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 - 160, 320, 60, 50);

				g.setColor(config.getBtnTAQD());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("<", config.getLARGURA() / 2 - 145, 367);

			}

			if (config.getTempoDeSpawnerDeBolas() < 60) {

				g.setColor(Color.black);
				g.fillRect(config.getLARGURA() / 2 + 100, 320, 60, 50);

				g.setColor(config.getBtnTAQA());
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString(">", config.getLARGURA() / 2 + 115, 367);

			}

		} else if (emMapa) {

			setCursor(null);

			g.setColor(Color.white);
			g.fillRect(0, 0, config.getLARGURA(), config.getALTURA());

			g.setColor(Color.black);
			g.fillRect(0, 50, config.getLARGURA(), 5);

			// VALORES

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 120, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 75, 220, 150, 50);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 120, config.getALTURA() - 100, 250, 80);

			// STRINGS

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("MAPA", config.getLARGURA() / 2 - 50, 35);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Largura do Mapa", config.getLARGURA() / 2 - 80, 110);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("Altura do Mapa", config.getLARGURA() / 2 - 70, 210);

			g.setColor(config.getBtnExitMapa());
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Voltar", config.getLARGURA() / 2 - 55, config.getALTURA() - 45);

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("" + config.getLARGURA(), config.getLARGURA() / 2 - 18, 153);

			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("" + config.getALTURA(), config.getLARGURA() / 2 - 15, 253);

			// BOTOES AUMENTAR E DIMINUIR

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 160, 120, 60, 50);

			g.setColor(config.getBtnLD());
			g.setFont(new Font("Arial", Font.BOLD, 60));
			g.drawString("<", config.getLARGURA() / 2 - 145, 167);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 + 100, 120, 60, 50);

			g.setColor(config.getBtnLA());
			g.setFont(new Font("Arial", Font.BOLD, 60));
			g.drawString(">", config.getLARGURA() / 2 + 115, 167);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 - 160, 220, 60, 50);

			g.setColor(config.getBtnAD());
			g.setFont(new Font("Arial", Font.BOLD, 60));
			g.drawString("<", config.getLARGURA() / 2 - 145, 267);

			g.setColor(Color.black);
			g.fillRect(config.getLARGURA() / 2 + 100, 220, 60, 50);

			g.setColor(config.getBtnAA());
			g.setFont(new Font("Arial", Font.BOLD, 60));
			g.drawString(">", config.getLARGURA() / 2 + 115, 267);

		}

		g.dispose();
		bs.show();

	}

	@Override
	public void run() {

		while (true) {

			trick();
			render();

			try {

				Thread.sleep(1000 / 60);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

	public void colisaoJogador() {

		if (jogador.getBound().intersects(new Rectangle(config.getXEX() + jogador.getLargura() / 2, config.getXEY(),
				config.getXELargura(), config.getXEAltura()))) {

			jogador.setX(config.getParedeX() + jogador.getLargura() / 2);

		}

		if (jogador.getBound().intersects(new Rectangle(config.getXDX() + jogador.getLargura() / 2, config.getXDY(),
				config.getXDLargura(), config.getXDAltura()))) {

			jogador.setX(config.getLARGURA() - jogador.getLargura() / 2 - config.getParedeX());

		}

		if (jogador.getBound().intersects(new Rectangle(config.getYCX(), config.getYCY() + jogador.getAltura() / 2,
				config.getYCLargura(), config.getYCAltura()))) {

			jogador.setY(config.getParedeX() + jogador.getAltura() / 2);

		}

		if (jogador.getBound().intersects(new Rectangle(config.getYBX(), config.getYBY() + jogador.getAltura() / 2,
				config.getYBLargura(), config.getYBAltura()))) {

			jogador.setY(config.getALTURA() - jogador.getAltura() / 2 - config.getParedeX());

		}

	}

	double CatXjogador, CatYjogador, CatXbola, CatYbola, hipotenusa;

	public void colisaoBola() {

		for (int a = 0; a < bolas.size(); a++) {

			Bola bola = bolas.get(a);

			CatXjogador = jogador.getX() - jogador.getLargura() / 2;
			CatYjogador = jogador.getY() - jogador.getAltura() / 2;
			CatXbola = bola.getX();
			CatYbola = bola.getY();

			hipotenusa = Math.sqrt(Math.pow(CatXjogador - CatXbola, 2) + Math.pow(CatYjogador - CatYbola, 2));

			if (jogador.getBound().intersects(bola.getBound()) && hipotenusa <= 50) {

				verificarVoltar++;
				
				limparCenario();
				resetar();

				emJogo = false;
				emDerrota = true;

			}

			if (bola.getBound().intersects(new Rectangle(config.getXEX() + jogador.getLargura() / 2, config.getXEY(),
					config.getXELargura(), config.getXEAltura()))) {

				som.tocarColisaoBolaNaParede();

				bola.setDx(config.getVelocidade());

			}

			if (bola.getBound().intersects(new Rectangle(config.getXDX() + jogador.getLargura() / 2, config.getXDY(),
					config.getXDLargura(), config.getXDAltura()))) {

				som.tocarColisaoBolaNaParede();

				bola.setDx(-config.getVelocidade());

			}

			if (bola.getBound().intersects(new Rectangle(config.getYCX(), config.getYCY() + jogador.getAltura() / 2,
					config.getYCLargura(), config.getYCAltura()))) {

				som.tocarColisaoBolaNaParede();

				bola.setDy(config.getVelocidade());

			}

			if (bola.getBound().intersects(new Rectangle(config.getYBX(), config.getYBY() + jogador.getAltura() / 2,
					config.getYBLargura(), config.getYBAltura()))) {

				som.tocarColisaoBolaNaParede();

				bola.setDy(-config.getVelocidade());

			}

			for (int b = 0; b < bolas.size(); b++) {

				Bola bolaB = bolas.get(b);

				if (bola.getBound().intersects(bolaB.getBound()) && bola.getX() > bolaB.getX()
						&& bola.getY() > bolaB.getY()) {

					som.tocarColisaoBolaNaParede();

					bola.setDx(config.getVelocidade());
					bola.setDy(config.getVelocidade());

					bolaB.setDx(-config.getVelocidade());
					bolaB.setDy(-config.getVelocidade());

				}

				if (bola.getBound().intersects(bolaB.getBound()) && bola.getX() < bolaB.getX()
						&& bola.getY() < bolaB.getY()) {

					som.tocarColisaoBolaNaParede();

					bola.setDx(-config.getVelocidade());
					bola.setDy(-config.getVelocidade());

					bolaB.setDx(config.getVelocidade());
					bolaB.setDy(config.getVelocidade());

				}

				if (bola.getBound().intersects(bolaB.getBound()) && bola.getX() > bolaB.getX()
						&& bola.getY() < bolaB.getY()) {

					som.tocarColisaoBolaNaParede();

					bola.setDx(config.getVelocidade());
					bola.setDy(-config.getVelocidade());

					bolaB.setDx(-config.getVelocidade());
					bolaB.setDy(config.getVelocidade());

				}

				if (bola.getBound().intersects(bolaB.getBound()) && bola.getX() < bolaB.getX()
						&& bola.getY() > bolaB.getY()) {

					som.tocarColisaoBolaNaParede();

					bola.setDx(-config.getVelocidade());
					bola.setDy(config.getVelocidade());

					bolaB.setDx(config.getVelocidade());
					bolaB.setDy(-config.getVelocidade());

				}

			}

		}

	}

	public void inicializarBolas() {

		bolas = new ArrayList<Bola>();

		int cordernadas[] = new int[config.getQuantidadeInicial()];

		for (int i = 0; i < cordernadas.length; i++) {

			verificacao = true;

			while (verificacao) {

				if (limiteX > config.getLARGURA() / 2 - 175 && limiteX < config.getLARGURA() / 2 + 125
						&& limiteY > config.getALTURA() / 2 - 175 && limiteY < config.getALTURA() / 2 + 125) {

					limiteX = new Random().nextInt(config.getLARGURA() - jogador.getLargura() - config.getParedeX() * 2)
							+ config.getParedeX();
					limiteY = new Random().nextInt(config.getALTURA() - jogador.getAltura() - config.getParedeY() * 2)
							+ config.getParedeY();

				} else {

					bolas.add(new Bola(limiteX, limiteY));
					verificacao = false;

				}

			}

		}

	}

	public void salvarInformacao() {

		config.setEscolhaVelocidade(config.getVelocidade());
		config.setEscolhaLimitadorDeVelocidade(config.getLimitadorDeVelocidade());
		config.setEscolhaTempoAumentoVelocidade(config.getTempoAumentoVelocidade());
		config.setEscolhaAumentoDaVelocidade(config.getAumentoDaVelocidade());

		config.setEscolhaQuantidadeInicial(config.getQuantidadeInicial());
		config.setEscolhaLimitadorDeBolas(config.getLimitadorDeBolas());
		config.setEscolhaTempoDeSpawnerDeBolas(config.getTempoDeSpawnerDeBolas());

	}

	public void resetar() {

		safePon = pontos;
		safeMin = minutos;
		safeSec = segundos;

		pontos = 0;
		minutos = 0;
		segundos = 0;

		config.setVelocidade(config.getEscolhaVelocidade());
		config.setLimitadorDeVelocidade(config.getEscolhaLimitadorDeVelocidade());
		config.setTempoAumentoVelocidade(config.getEscolhaTempoAumentoVelocidade());
		config.setAumentoDaVelocidade(config.getEscolhaAumentoDaVelocidade());

		config.setQuantidadeInicial(config.getEscolhaQuantidadeInicial());
		config.setLimitadorDeBolas(config.getEscolhaLimitadorDeBolas());
		config.setTempoDeSpawnerDeBolas(config.getEscolhaTempoDeSpawnerDeBolas());
		config.setQuantidadeAtual(config.getEscolhaQuantidadeInicial());

	}

	public void limparCenario() {

		for (int a = 0; a < bolas.size(); a++) {

			for (int b = 0; b < bolas.size(); b++) {

				for (int c = 0; c < bolas.size(); c++) {

					bolas.remove(c);

				}

			}

		}

		if (config.getQuantidadeInicial() > 1) {

			bolas.remove(0);

		}

	}

	public void tempo() {

		Timer time = new Timer();

		TimerTask cronometro = new TimerTask() {

			@Override
			public void run() {

				if (emJogo) {

					pontos += config.getVelocidade() + config.getQuantidadeAtual();

					if (emPause == false) {

						segundos++;

					}

					if (segundos % config.getTempoDeSpawnerDeBolas() == 0
							&& config.getLimitadorDeBolas() > config.getQuantidadeInicial()) {

						config.setQuantidadeAtual(config.getQuantidadeAtual() + 1);
						config.setLimitadorDeBolas(config.getLimitadorDeBolas() - 1);

						int x = new Random().nextInt(350);
						int y = new Random().nextInt(550);

						bolas.add(new Bola(x, y));

					}

					if (segundos % config.getTempoAumentoVelocidade() == 0
							&& config.getVelocidade() < config.getLimitadorDeVelocidade()) {

						config.setVelocidade(config.getVelocidade() + config.getAumentoDaVelocidade());

					}

					if (segundos % 60 == 0) {

						segundos = 0;
						minutos++;

					}

				}

			}
		};

		time.scheduleAtFixedRate(cronometro, 1000, 1000);

	}

}

//DIREÇÕES INICIAL DAS BOLAS SER ALEATORIO
//COLISAO JOGADOR NA PAREDE MELHORAR ELA E COLISAO DA BOLAS
//AUMENTAR A PAREDE DURANTE O JOGO
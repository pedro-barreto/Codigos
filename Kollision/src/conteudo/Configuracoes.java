package conteudo;

import java.awt.Color;

public class Configuracoes {

	private int LARGURA = 1000;
	private int ALTURA = 800;

	private int quantidadeInicial = 1;
	private int limitadorDeBolas = 3;
	private int tempoDeSpawnerDeBolas = 10;
	private int quantidadeAtual = getQuantidadeInicial();

	private int velocidade = 5;
	private int limitadorDeVelocidade = 25;
	private int tempoAumentoVelocidade = 10;
	private int aumentoDaVelocidade = 5;

	private int paredeX = 5;
	private int paredeY = 5;

	// ---------------------------------------------------------------------------------------------------

	private int escolhaQuantidadeInicial = getQuantidadeInicial();
	private int escolhaLimitadorDeBolas = getLimitadorDeBolas();
	private int escolhaTempoDeSpawnerDeBolas = getTempoDeSpawnerDeBolas();
	private int escolhaQuantidadeAtual = getQuantidadeAtual();

	private int escolhaVelocidade = velocidade;
	private int escolhaLimitadorDeVelocidade = getLimitadorDeVelocidade();
	private int escolhaTempoAumentoVelocidade = getTempoAumentoVelocidade();
	private int escolhaAumentoDaVelocidade = getAumentoDaVelocidade();
	

	private int XEX = 0, XEY = 0, XELargura = paredeX, XEAltura = ALTURA;
	private int YCX = 0, YCY = 0, YCAltura = paredeY, YCLargura = LARGURA;

	private int XDX = LARGURA - paredeX, XDY = 0, XDLargura = paredeX, XDAltura = ALTURA;
	private int YBY = ALTURA - paredeY, YBX = 0, YBAltura = paredeY, YBLargura = LARGURA;

	// ---------------------------------------------------------------------------------------------------
	
	private boolean emInicio = true;
	private boolean emJogo = false;
	private boolean emDerrota = false;
	private boolean emConfig = false;
	private boolean emPause = false;

	private boolean emVelocidade = false;
	private boolean emQuantidade = false;
	private boolean emMapa = false;
	
	//----------------------------------------------------------

	private Color btnPlay = Color.white;
	private Color btnSettingInicio = Color.white;
	private Color btnExitInicio = Color.white;

	// ----------------------------------------------------------

	private Color btnVelocidade = Color.white;
	private Color btnQuantidade = Color.white;
	private Color btnMapa = Color.white;
	private Color btnVoltar = Color.white;

	// ----------------------------------------------------------

	private Color btnRetry = Color.black;
	private Color btnSettingDerrota = Color.black;
	private Color btnExitDerrota = Color.black;

	// ------------------------------------------------------------

	private Color btnVID = Color.white;
	private Color btnVIA = Color.white;
	private Color btnLMD = Color.white;
	private Color btnLMA = Color.white;
	private Color btnTAVD = Color.white;
	private Color btnTAVA = Color.white;
	private Color btnAVD = Color.white;
	private Color btnAVA = Color.white;
	private Color btnExitVelocidade = Color.white;

	// -------------------------------------------------------------

	private Color btnQID = Color.white;
	private Color btnQIA = Color.white;
	private Color btnLBD = Color.white;
	private Color btnLBA = Color.white;
	private Color btnTAQD = Color.white;
	private Color btnTAQA = Color.white;
	private Color btnExitQuantidade = Color.white;

	// ------------------------------------------------------------
	
	private Color btnLD = Color.white;
	private Color btnLA = Color.white;
	private Color btnAD = Color.white;
	private Color btnAA = Color.white;
	private Color btnExitMapa = Color.white;
	
	//-------------------------------------------------------------

	private Color branco = Color.white;
	private Color verde = Color.green;
	private Color vermelho = Color.red;
	private Color preto = Color.black;
	private Color ciano = Color.yellow;

	// -------------------------------------------------------------

	public int getParedeX() {

		return paredeX;

	}

	public void setParedeX(int paredeX) {

		this.paredeX = paredeX;

	}

	public int getParedeY() {

		return paredeY;

	}

	public void setParedeY(int paredeY) {

		this.paredeY = paredeY;

	}

	public int getXEX() {

		return XEX;

	}

	public void setXEX(int xEX) {

		XEX = xEX;

	}

	public int getXEY() {

		return XEY;

	}

	public void setXEY(int xEY) {

		XEY = xEY;

	}

	public int getXELargura() {

		return XELargura;

	}

	public void setXELargura(int xELargura) {

		XELargura = xELargura;

	}

	public int getXEAltura() {

		return XEAltura;

	}

	public void setXEAltura(int xEAltura) {

		XEAltura = xEAltura;

	}

	public int getYCX() {

		return YCX;

	}

	public void setYCX(int yCX) {

		YCX = yCX;

	}

	public int getYCY() {

		return YCY;

	}

	public void setYCY(int yCY) {

		YCY = yCY;

	}

	public int getYCAltura() {

		return YCAltura;

	}

	public void setYCAltura(int yCAltura) {

		YCAltura = yCAltura;

	}

	public int getYCLargura() {

		return YCLargura;

	}

	public void setYCLargura(int yCLargura) {

		YCLargura = yCLargura;

	}

	public int getXDX() {

		return XDX;

	}

	public void setXDX(int xDX) {

		XDX = xDX;
	}

	public int getXDY() {

		return XDY;

	}

	public void setXDY(int xDY) {

		XDY = xDY;

	}

	public int getXDLargura() {

		return XDLargura;

	}

	public void setXDLargura(int xDLargura) {

		XDLargura = xDLargura;

	}

	public int getXDAltura() {

		return XDAltura;

	}

	public void setXDAltura(int xDAltura) {

		XDAltura = xDAltura;

	}

	public int getYBY() {

		return YBY;

	}

	public void setYBY(int yBY) {

		YBY = yBY;

	}

	public int getYBX() {

		return YBX;

	}

	public void setYBX(int yBX) {

		YBX = yBX;

	}

	public int getYBAltura() {

		return YBAltura;

	}

	public void setYBAltura(int yBAltura) {

		YBAltura = yBAltura;

	}

	public int getYBLargura() {

		return YBLargura;

	}

	public void setYBLargura(int yBLargura) {

		YBLargura = yBLargura;

	}

	public int getLARGURA() {

		return LARGURA;

	}

	public void setLARGURA(int lARGURA) {

		LARGURA = lARGURA;

	}

	public int getALTURA() {

		return ALTURA;

	}

	public void setALTURA(int aLTURA) {

		ALTURA = aLTURA;

	}

	public int getQuantidadeInicial() {

		return quantidadeInicial;

	}

	public void setQuantidadeInicial(int quantidadeInicial) {

		this.quantidadeInicial = quantidadeInicial;

	}

	public int getLimitadorDeBolas() {

		return limitadorDeBolas;

	}

	public void setLimitadorDeBolas(int limitadorDeBolas) {

		this.limitadorDeBolas = limitadorDeBolas;

	}

	public int getTempoDeSpawnerDeBolas() {

		return tempoDeSpawnerDeBolas;

	}

	public void setTempoDeSpawnerDeBolas(int tempoDeSpawnerDeBolas) {

		this.tempoDeSpawnerDeBolas = tempoDeSpawnerDeBolas;

	}

	public int getQuantidadeAtual() {

		return quantidadeAtual;

	}

	public void setQuantidadeAtual(int quantidadeAtual) {

		this.quantidadeAtual = quantidadeAtual;

	}

	public int getTempoAumentoVelocidade() {

		return tempoAumentoVelocidade;

	}

	public void setTempoAumentoVelocidade(int tempoAumentoVelocidade) {

		this.tempoAumentoVelocidade = tempoAumentoVelocidade;

	}

	public int getAumentoDaVelocidade() {

		return aumentoDaVelocidade;

	}

	public void setAumentoDaVelocidade(int aumentoDaVelocidade) {

		this.aumentoDaVelocidade = aumentoDaVelocidade;

	}

	public int getLimitadorDeVelocidade() {

		return limitadorDeVelocidade;

	}

	public void setLimitadorDeVelocidade(int limitadorDeVelocidade) {

		this.limitadorDeVelocidade = limitadorDeVelocidade;

	}

	public int getVelocidade() {

		return velocidade;

	}

	public void setVelocidade(int velocidade) {

		this.velocidade = velocidade;

	}

	public int getEscolhaQuantidadeInicial() {

		return escolhaQuantidadeInicial;

	}

	public int getEscolhaLimitadorDeBolas() {

		return escolhaLimitadorDeBolas;

	}

	public int getEscolhaTempoDeSpawnerDeBolas() {

		return escolhaTempoDeSpawnerDeBolas;

	}

	public int getEscolhaVelocidade() {

		return escolhaVelocidade;

	}

	public int getEscolhaTempoAumentoVelocidade() {

		return escolhaTempoAumentoVelocidade;

	}

	public int getEscolhaAumentoDaVelocidade() {

		return escolhaAumentoDaVelocidade;

	}

	public int getEscolhaLimitadorDeVelocidade() {

		return escolhaLimitadorDeVelocidade;

	}

	public Color getBtnPlay() {

		return btnPlay;

	}

	public void setBtnPlay(Color btnPlay) {

		this.btnPlay = btnPlay;

	}

	public Color getBtnSettingInicio() {

		return btnSettingInicio;

	}

	public void setBtnSettingInicio(Color btnSettingInicio) {

		this.btnSettingInicio = btnSettingInicio;

	}

	public Color getBtnExitInicio() {

		return btnExitInicio;

	}

	public void setBtnExitInicio(Color btnExitInicio) {

		this.btnExitInicio = btnExitInicio;

	}

	public Color getBtnVelocidade() {

		return btnVelocidade;

	}

	public void setBtnVelocidade(Color btnVelocidade) {

		this.btnVelocidade = btnVelocidade;

	}

	public Color getBtnQuantidade() {

		return btnQuantidade;
	}

	public void setBtnQuantidade(Color btnQuantidade) {

		this.btnQuantidade = btnQuantidade;

	}

	public Color getBtnMapa() {

		return btnMapa;

	}

	public void setBtnMapa(Color btnMapa) {

		this.btnMapa = btnMapa;

	}

	public Color getBtnVoltar() {

		return btnVoltar;

	}

	public void setBtnVoltar(Color btnVoltar) {

		this.btnVoltar = btnVoltar;

	}

	public Color getBtnRetry() {

		return btnRetry;

	}

	public void setBtnRetry(Color btnRetry) {

		this.btnRetry = btnRetry;

	}

	public Color getBtnSettingDerrota() {

		return btnSettingDerrota;

	}

	public void setBtnSettingDerrota(Color btnSettingDerrota) {

		this.btnSettingDerrota = btnSettingDerrota;

	}

	public Color getBtnExitDerrota() {

		return btnExitDerrota;

	}

	public void setBtnExitDerrota(Color btnExitDerrota) {

		this.btnExitDerrota = btnExitDerrota;

	}

	public Color getVerde() {

		return verde;

	}

	public Color getBranco() {

		return branco;

	}

	public Color getVermelho() {

		return vermelho;

	}

	public Color getPreto() {

		return preto;

	}

	public Color getCiano() {

		return ciano;

	}

	public Color getBtnVID() {

		return btnVID;

	}

	public void setBtnVID(Color btnVID) {

		this.btnVID = btnVID;

	}

	public Color getBtnVIA() {

		return btnVIA;

	}

	public void setBtnVIA(Color btnVIA) {

		this.btnVIA = btnVIA;

	}

	public Color getBtnLMD() {

		return btnLMD;

	}

	public void setBtnLMD(Color btnLMD) {

		this.btnLMD = btnLMD;

	}

	public Color getBtnLMA() {

		return btnLMA;

	}

	public void setBtnLMA(Color btnLMA) {

		this.btnLMA = btnLMA;

	}

	public Color getBtnTAVD() {

		return btnTAVD;

	}

	public void setBtnTAVD(Color btnTAVD) {

		this.btnTAVD = btnTAVD;

	}

	public Color getBtnTAVA() {

		return btnTAVA;

	}

	public void setBtnTAVA(Color btnTAVA) {

		this.btnTAVA = btnTAVA;

	}

	public Color getBtnAVD() {

		return btnAVD;

	}

	public void setBtnAVD(Color btnAVD) {

		this.btnAVD = btnAVD;

	}

	public Color getBtnAVA() {

		return btnAVA;

	}

	public void setBtnAVA(Color btnAVA) {

		this.btnAVA = btnAVA;

	}

	public Color getBtnExitVelocidade() {

		return btnExitVelocidade;

	}

	public void setBtnExitVelocidade(Color btnExitVelocidade) {

		this.btnExitVelocidade = btnExitVelocidade;

	}

	public Color getBtnQID() {
		
		return btnQID;
		
	}

	public void setBtnQID(Color btnQID) {
		
		this.btnQID = btnQID;
		
	}

	public Color getBtnQIA() {
		
		return btnQIA;
		
	}

	public void setBtnQIA(Color btnQIA) {
		
		this.btnQIA = btnQIA;
		
	}

	public Color getBtnLBD() {
		
		return btnLBD;
		
	}

	public void setBtnLBD(Color btnLBD) {
		
		this.btnLBD = btnLBD;
		
	}

	public Color getBtnLBA() {
		
		return btnLBA;
		
	}

	public void setBtnLBA(Color btnLBA) {
		
		this.btnLBA = btnLBA;
		
	}

	public Color getBtnTAQD() {
		
		return btnTAQD;
		
	}

	public void setBtnTAQD(Color btnTAQD) {
		
		this.btnTAQD = btnTAQD;
		
	}

	public Color getBtnTAQA() {
		
		return btnTAQA;
		
	}

	public void setBtnTAQA(Color btnTAQA) {
		
		this.btnTAQA = btnTAQA;
		
	}

	public Color getBtnExitQuantidade() {

		return btnExitQuantidade;

	}

	public Color getBtnLD() {
		
		return btnLD;
		
	}

	public void setBtnLD(Color btnLD) {
		
		this.btnLD = btnLD;
		
	}

	public Color getBtnLA() {
		
		return btnLA;
		
	}

	public void setBtnLA(Color btnLA) {
		
		this.btnLA = btnLA;
		
	}

	public Color getBtnAD() {
		
		return btnAD;
		
	}

	public void setBtnAD(Color btnAD) {
		
		this.btnAD = btnAD;
		
	}

	public Color getBtnAA() {
		
		return btnAA;
		
	}

	public void setBtnAA(Color btnAA) {
		
		this.btnAA = btnAA;
		
	}

	public Color getBtnExitMapa() {
		
		return btnExitMapa;
		
	}

	public void setBtnExitMapa(Color btnExitMapa) {
		
		this.btnExitMapa = btnExitMapa;
		
	}

	public void setBtnExitQuantidade(Color btnExitQuantidade) {

		this.btnExitQuantidade = btnExitQuantidade;

	}

	public void setEscolhaQuantidadeInicial(int escolhaQuantidadeInicial) {
		
		this.escolhaQuantidadeInicial = escolhaQuantidadeInicial;
		
	}

	public void setEscolhaLimitadorDeBolas(int escolhaLimitadorDeBolas) {
		
		this.escolhaLimitadorDeBolas = escolhaLimitadorDeBolas;
		
	}

	public void setEscolhaTempoDeSpawnerDeBolas(int escolhaTempoDeSpawnerDeBolas) {
		
		this.escolhaTempoDeSpawnerDeBolas = escolhaTempoDeSpawnerDeBolas;
		
	}

	public void setEscolhaVelocidade(int escolhaVelocidade) {
		
		this.escolhaVelocidade = escolhaVelocidade;
		
	}

	public void setEscolhaLimitadorDeVelocidade(int escolhaLimitadorDeVelocidade) {
		
		this.escolhaLimitadorDeVelocidade = escolhaLimitadorDeVelocidade;
		
	}

	public void setEscolhaTempoAumentoVelocidade(int escolhaTempoAumentoVelocidade) {
		
		this.escolhaTempoAumentoVelocidade = escolhaTempoAumentoVelocidade;
		
	}

	public void setEscolhaAumentoDaVelocidade(int escolhaAumentoDaVelocidade) {
		
		this.escolhaAumentoDaVelocidade = escolhaAumentoDaVelocidade;
		
	}

	public int getEscolhaQuantidadeAtual() {
		
		return escolhaQuantidadeAtual;
		
	}

	public void setEscolhaQuantidadeAtual(int escolhaQuantidadeAtual) {
		
		this.escolhaQuantidadeAtual = escolhaQuantidadeAtual;
		
	}

	public boolean isEmInicio() {
		
		return emInicio;
		
	}

	public void setEmInicio(boolean emInicio) {
		
		this.emInicio = emInicio;
		
	}

	public boolean isEmJogo() {
		
		return emJogo;
		
	}

	public void setEmJogo(boolean emJogo) {
		
		this.emJogo = emJogo;
		
	}

	public boolean isEmDerrota() {
		
		return emDerrota;
		
	}

	public void setEmDerrota(boolean emDerrota) {
		
		this.emDerrota = emDerrota;
		
	}

	public boolean isEmConfig() {
		
		return emConfig;
		
	}

	public void setEmConfig(boolean emConfig) {
		
		this.emConfig = emConfig;
		
	}

	public boolean isEmPause() {
		
		return emPause;
		
	}

	public void setEmPause(boolean emPause) {
		
		this.emPause = emPause;
		
	}

	public boolean isEmVelocidade() {
		
		return emVelocidade;
		
	}

	public void setEmVelocidade(boolean emVelocidade) {
		
		this.emVelocidade = emVelocidade;
		
	}

	public boolean isEmQuantidade() {
		
		return emQuantidade;
		
	}

	public void setEmQuantidade(boolean emQuantidade) {
		
		this.emQuantidade = emQuantidade;
		
	}

	public boolean isEmMapa() {
		
		return emMapa;
		
	}

	public void setEmMapa(boolean emMapa) {
		
		this.emMapa = emMapa;
		
	}

}

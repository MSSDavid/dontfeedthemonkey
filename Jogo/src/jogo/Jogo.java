package jogo;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Anderson
 * Universidade Federal de Goiás
 * Versão:2.0
 * 
 * Jogo de ir do ponto A ao ponto B, desviando de obstaculos
 */
public class Jogo extends JFrame {

    Personagem pers = new Personagem();
    Jogador player = new Jogador();
    Inimigo inimigo1 = new Inimigo();
    Inimigo2 inimigo2 = new Inimigo2();
    
    //Pega as imagens para os objetos
    ImageIcon iconSaida = new ImageIcon(getClass().getResource("saida.png"));
    ImageIcon iconFundo1 = new ImageIcon(getClass().getResource("fundo1.png"));
    ImageIcon iconFundo2 = new ImageIcon(getClass().getResource("fundo2.png"));
    ImageIcon iconFundo3 = new ImageIcon(getClass().getResource("fundo1.png"));
    
    //Set como JLabel para manipular no programa
    JLabel lSaida = new JLabel (iconSaida);
    JLabel lFundo1 = new JLabel(iconFundo1);

    /**
     *Set os tamanhos dos objetos no tela em pixels
     */
    public void editarComponetes(){
        player.label.setBounds(player.x, player.y, 60, 125);
        lSaida.setBounds(0, 0, 148, 125);
        lFundo1.setBounds(0, 0, 800, 700);
        //inimigo1.label.setBounds(inimigo1.x, inimigo1.y, 30, 35);
        //inimigo2.label.setBounds(inimigo2.x, inimigo2.y, 35, 37);
    }    
    
    /**
     *Define o Tamanho da Janela e coloca os objetos nela
     */
    public void editarJanela(){
        /*setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        add(player.label);
        add(lSaida);
        add(inimigo1.label);
        add(inimigo2.label);
        add(lFundo1);*/
    }

    //realiza o movimento do objeto Personagem, com as teclas do teclado
    public void movimento(int i){
        addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent ke) {
                
            }

            public void keyPressed(KeyEvent ke) {
                //Identifica a tecla que foi pressionada e altera a variavel que define a pocisão do personagem
                if(ke.getKeyCode() == 38){
                    player.label.setIcon(player.iconCimaMexendo);
                    //player.flag_down = true;
                    player.y -= 5;
                     //Faz uma contagem de passos paraa pontuação
                     player.pont ++;
                }
                if(ke.getKeyCode() == 40) {
                    player.label.setIcon(player.iconBaixoMexendo);
                    //player.flag_up = true;
                    player.y += 5;
                //Faz uma contagem de passos paraa pontuação
                player.pont ++;
                }
                if(ke.getKeyCode() == 37) {
                    player.label.setIcon(player.iconEsqMexendo);
                   // player.flag_left = true;
                    player.x -= 5;
                //Faz uma contagem de passos paraa pontuação
                player.pont ++;
                }
                if(ke.getKeyCode() == 39) {
                    player.label.setIcon(player.iconDirMexendo);
                    //player.flag_right = true;
                    player.x += 5;
                //Faz uma contagem de passos paraa pontuação
                player.pont ++;
                }
                player.label.setBounds(player.x, player.y, 60, 125);
                
                //Colisão com o objeto saida
                if(bateu(player.label, lSaida)){
                    if(i == 3){
                        TelaFinal tela = new TelaFinal(player.pont);
                        tela.setVisible(true);
                    }
                    else{
                        new Jogo(i+1);
                    }
                    dispose();
                }
                if(bateu(player.label, inimigo1.label0)){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo1.label1)){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo1.label2)){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo1.label3)){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo2.label0)){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo2.label1)){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo2.label2)){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo2.label3)){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
                //Colisão com os Inimigos
                /*if(((player.playerY >= 500) && (player.playerX <= 148)) || ((player.playerY >= 100) && (player.playerX <= 297))){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }*/
            }

            public void keyReleased(KeyEvent ke) {
                //Identifica a tecla que foi pressionada e altera a variavel que define a pocisão do personagem
                if(ke.getKeyCode() == 38){
                    player.label.setIcon(player.iconCimaP);
                    //player.flag_down = false;
                    player.y -= 10;
                }
                if(ke.getKeyCode() == 40) {
                    player.label.setIcon(player.iconBaixoP);
                    //player.flag_up = false;
                    player.y +=10;
                }
                if(ke.getKeyCode() == 37) {
                    player.label.setIcon(player.iconEsqP);
                    //player.flag_left = false;
                    player.x -=10;
                }
                if(ke.getKeyCode() == 39) {
                    player.label.setIcon(player.iconDirP);
                    //player.flag_right = false;
                    player.x +=10;
                }
                //Movimenta o Personagem
                player.label.setBounds(player.x, player.y, 60, 125);
            }
            
        });    
    }
    
    public boolean bateu(Component a, Component b) {
		int aX = a.getX();
		int aY = a.getY();
		int ladoDireitoA = aX+a.getWidth();
		int ladoEsquerdoA= aX;
		int ladoBaixoA= aY+a.getHeight();
		int ladoCimaA= aY;
		
		int bX = b.getX();
		int bY = b.getY();
		int ladoDireitoB = bX+b.getWidth();
		int ladoEsquerdoB= bX;
		int ladoBaixoB= bY+b.getHeight();
		int ladoCimaB= bY;
		
		boolean bateu = false;
		
		boolean cDireita=false;
		boolean cCima=false;
		boolean cBaixo=false;
		boolean cEsquerda=false;
		
		if(ladoDireitoA>=ladoEsquerdoB) {
			cDireita=true;
		}
		if(ladoCimaA<=ladoBaixoB) {
			cCima=true;
		}
		if(ladoBaixoA>=ladoCimaB) {
			cBaixo=true;
		}
		if(ladoEsquerdoA<=ladoDireitoB) {
			cEsquerda=true;
		}
		
		if(cDireita && cEsquerda && cBaixo && cCima) {
			bateu = true;
		}
			
		return bateu;
	}
   
    public void Fase(int i){
        
        add(lSaida);
        switch(i){
            case 1:
                add(inimigo1.label0);
                add(inimigo2.label0);
                add(lFundo1);
                lSaida.setBounds(0, 0, 148, 125);
                inimigo1.label0.setBounds(inimigo1.x, inimigo1.y, 30, 35);
                inimigo2.label0.setBounds(inimigo2.x, inimigo2.y, 35, 37);
                break;
            case 2:
                add(inimigo1.label0);
                add(inimigo1.label1);
                add(inimigo2.label0);
                lFundo1.setIcon(iconFundo2);
                add(lFundo1);
                lSaida.setBounds(600, 500, 148, 125);
                inimigo1.label0.setBounds(inimigo1.x, inimigo1.y, 30, 35);
                inimigo1.label1.setBounds(100, 400, 30, 35);
                inimigo2.label0.setBounds(inimigo2.x, inimigo2.y, 35, 37);
                break;
            case 3:
                add(inimigo1.label0);
                add(inimigo1.label1);
                add(inimigo2.label0);
                add(inimigo2.label1);
                add(inimigo2.label2);
                lFundo1.setIcon(iconFundo2);
                add(lFundo1);
                lSaida.setBounds(600, 500, 148, 125);
                inimigo1.label0.setBounds(inimigo1.x, inimigo1.y, 30, 35);
                inimigo1.label1.setBounds(100, 400, 30, 35);
                inimigo2.label0.setBounds(250, 100, 35, 37);
                inimigo2.label1.setBounds(150, 350, 35, 37);
                inimigo2.label2.setBounds(550, 370, 35, 37);
                break;
        }
        
        lFundo1.setBounds(0, 0, 800, 700);
    }
    
    public Jogo(int i){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        add(player.label);
        player.label.setBounds(player.x, player.y, 60, 125);
        Fase(i);
        movimento(i);
    }
    
    public static void main(String[] args) {

        TelaInicial telaI = new TelaInicial();
        telaI.setVisible(true);
    }
    
}
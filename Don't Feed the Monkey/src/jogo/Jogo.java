package jogo;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *
 * @author Anderson Luiz
 * @author José Carlos
 * Universidade Federal de Goiás
 * @version 4.0
 * 
 * Jogo de ir do ponto A ao ponto B, desviando de obstaculos
 * 
 */
public class Jogo extends JFrame {

    Personagem pers = new Personagem();
    Jogador player = new Jogador();
    Inimigo inimigo1 = new Inimigo();
    Inimigo2 inimigo2 = new Inimigo2();
    
    /**
     * Pega as imagens para os objetos
     * 
     * fundo 1 - made by Chagial - https://www.deviantart.com/chagial/art/Running-of-the-Leaves-bg-vector-280690098
     * fundo 2 - made by Roger-kun from Jump Ultimate Stars - http://spritedatabase.net/file/12861/School
     * fundo 3 - made by jebo14 - https://www.deviantart.com/jebo14/art/Background-Building-4-School-454303688
     * fundo 4 - made by keenjikun and Toby Fox - https://www.spriters-resource.com/pc_computer/undertale/sheet/77634/
    */
    ImageIcon iconSaida = new ImageIcon(getClass().getResource("saida.png"));
    ImageIcon iconFundo1 = new ImageIcon(getClass().getResource("fundo1.png"));
    ImageIcon iconFundo2 = new ImageIcon(getClass().getResource("fundo2.png"));
    ImageIcon iconFundo3 = new ImageIcon(getClass().getResource("fundo3.png"));
    ImageIcon iconFundo4 = new ImageIcon(getClass().getResource("fundo4.png"));
    
    //Set como JLabel para manipular no programa
    JLabel lSaida = new JLabel (iconSaida);
    JLabel lFundo1 = new JLabel(iconFundo1);

    /**
    *realiza o movimento do objeto Personagem, com as teclas do teclado
    * @param i int - identificador da fase
    *
    */
    public void movimento(int i){
        addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent ke) {
                
            }

            public void keyPressed(KeyEvent ke) {
                //Identifica a tecla que foi pressionada e altera a variavel que define a pocisão do personagem
                if(ke.getKeyCode() == 38){
                    player.label.setIcon(player.iconCimaMexendo);
                    //player.flag_down = true;
                    player.y -= 7;
                     //Faz uma contagem de passos paraa pontuação
                     player.pont ++;
                }
                if(ke.getKeyCode() == 40) {
                    player.label.setIcon(player.iconBaixoMexendo);
                    //player.flag_up = true;
                    player.y += 7;
                //Faz uma contagem de passos paraa pontuação
                player.pont ++;
                }
                if(ke.getKeyCode() == 37) {
                    player.label.setIcon(player.iconEsqMexendo);
                   // player.flag_left = true;
                    player.x -= 7;
                //Faz uma contagem de passos paraa pontuação
                player.pont ++;
                }
                if(ke.getKeyCode() == 39) {
                    player.label.setIcon(player.iconDirMexendo);
                    //player.flag_right = true;
                    player.x += 7;
                //Faz uma contagem de passos paraa pontuação
                player.pont ++;
                }
                if(ke.getKeyCode() == 40 && ke.getKeyCode() == 39) {
                    player.label.setIcon(player.iconBaixoMexendo);
                    //player.flag_up = true;
                    player.y += 7;
                    player.x += 7;
                //Faz uma contagem de passos paraa pontuação
                player.pont = player.pont + 2;
                }
                if(ke.getKeyCode() == 40 && ke.getKeyCode() == 37) {
                    player.label.setIcon(player.iconBaixoMexendo);
                    //player.flag_up = true;
                    player.y += 7;
                    player.x -= 7;
                //Faz uma contagem de passos paraa pontuação
                player.pont = player.pont + 2;
                }
                if(ke.getKeyCode() == 38 && ke.getKeyCode() == 39) {
                    player.label.setIcon(player.iconBaixoMexendo);
                    //player.flag_up = true;
                    player.y -= 7;
                    player.x += 7;
                //Faz uma contagem de passos paraa pontuação
                player.pont = player.pont + 2;
                }
                if(ke.getKeyCode() == 38 && ke.getKeyCode() == 37) {
                    player.label.setIcon(player.iconBaixoMexendo);
                    //player.flag_up = true;
                    player.y -= 7;
                    player.x -= 7;
                //Faz uma contagem de passos paraa pontuação
                player.pont = player.pont + 2;
                }
                player.label.setBounds(player.x, player.y, 80, 125);
                
                //Colisão com o objeto saida
                if(bateu(player.label, lSaida)){
                    if(i == 4){
                        TelaFinal tela = new TelaFinal(player.pont);
                        tela.setVisible(true);
                    }
                    else{
                        new Jogo(i+1);
                    }
                    dispose();
                }
                if(bateu(player.label, inimigo1.label0)){
                    TelaFinal tela = new TelaFinal();
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo1.label1)){
                    TelaFinal tela = new TelaFinal();
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo1.label2)){
                    TelaFinal tela = new TelaFinal();
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo1.label3)){
                    TelaFinal tela = new TelaFinal();
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo2.label0)){
                    TelaFinal tela = new TelaFinal();
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo2.label1)){
                    TelaFinal tela = new TelaFinal();
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo2.label2)){
                    TelaFinal tela = new TelaFinal();
                    tela.setVisible(true);
                    dispose();
                }
                if(bateu(player.label, inimigo2.label3)){
                    TelaFinal tela = new TelaFinal();
                    tela.setVisible(true);
                    dispose();
                }
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
                player.label.setBounds(player.x, player.y, 80, 125);
            }
            
        });    
    }
    
    /**
    *Realiza testes para saber se as Labels chocaram
    * @param a Component - Componente que recebe o JLabel do personagem
    * @param b Component - Componente que recebe o JLabel do inimigo o porta
    *
    * @return boolean - Booleano se as Labels se chocaram ou não
    */
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
   
    /**
    *Realiza a movimentação dos Inimigos
    */
    public class movInimigo extends Thread{
        /**
         * Metodo que movimenta os inimigos
         */
        public void run(){
            
            int teste1 = 0;
            int teste2 = 0;
            int teste3 = 0;
            int teste4 = 0;
            int teste5 = 0;
            int teste6 = 0;
            int teste7 = 0;
            int teste8 = 0;
            
            while(true){
                try{sleep(20);}catch(Exception erro){}
                    if(inimigo1.label0.getX() == 700){
                        teste1 = 1;
                    }
                    if(inimigo1.label0.getX() == 100){
                        teste1 = 0;
                    }
                    if(teste1 == 0){
                        inimigo1.label0.setBounds(inimigo1.label0.getX()+5, inimigo1.label0.getY(), 30, 35);
                    }
                    if(teste1 == 1){
                        inimigo1.label0.setBounds(inimigo1.label0.getX()-5, inimigo1.label0.getY(), 30, 35);
                    }
                    if(inimigo1.label1.getX() == 700){
                        teste2 = 1;
                    }
                    if(inimigo1.label1.getX() == 100){
                        teste2 = 0;
                    }
                    if(teste2 == 0){
                        inimigo1.label1.setBounds(inimigo1.label1.getX()+5, inimigo1.label1.getY(), 30, 35);
                    }
                    if(teste2 == 1){
                        inimigo1.label1.setBounds(inimigo1.label1.getX()-5, inimigo1.label1.getY(), 30, 35);
                    }
                    if(inimigo1.label2.getX() == 700){
                        teste3 = 1;
                    }
                    if(inimigo1.label2.getX() == 100){
                        teste3 = 0;
                    }
                    if(teste3 == 0){
                        inimigo1.label2.setBounds(inimigo1.label2.getX()+5, inimigo1.label2.getY(), 30, 35);
                    }
                    if(teste3 == 1){
                        inimigo1.label2.setBounds(inimigo1.label2.getX()-5, inimigo1.label2.getY(), 30, 35);
                    }
                    if(inimigo1.label3.getX() == 700){
                        teste4 = 1;
                    }
                    if(inimigo1.label3.getX() == 100){
                        teste4 = 0;
                    }
                    if(teste4 == 0){
                        inimigo1.label3.setBounds(inimigo1.label3.getX()+5, inimigo1.label3.getY(), 30, 35);
                    }
                    if(teste4 == 1){
                        inimigo1.label3.setBounds(inimigo1.label3.getX()-5, inimigo1.label3.getY(), 30, 35);
                    }
                    if(inimigo2.label0.getY() == 550){
                        teste5 = 1;
                    }
                    if(inimigo2.label0.getY() == 100){
                        teste5 = 0;
                    }
                    if(teste5 == 0){
                        inimigo2.label0.setBounds(inimigo2.label0.getX(), inimigo2.label0.getY()+5, 35, 37);
                    }
                    if(teste5 == 1){
                        inimigo2.label0.setBounds(inimigo2.label0.getX(), inimigo2.label0.getY()-5, 35, 37);
                    }
                    if(inimigo2.label1.getY() == 550){
                        teste6 = 1;
                    }
                    if(inimigo2.label1.getY() == 100){
                        teste6 = 0;
                    }
                    if(teste6 == 0){
                        inimigo2.label1.setBounds(inimigo2.label1.getX(), inimigo2.label1.getY()+5, 35, 37);
                    }
                    if(teste6 == 1){
                        inimigo2.label1.setBounds(inimigo2.label1.getX(), inimigo2.label1.getY()-5, 35, 37);
                    }
                    if(inimigo2.label2.getX() == 550){
                        teste7 = 1;
                    }
                    if(inimigo2.label2.getX() == 50){
                        teste7 = 0;
                    }
                    if(teste7 == 0){
                        inimigo2.label2.setBounds(inimigo2.label2.getX()+5, inimigo2.label2.getY(), 35, 37);
                    }
                    if(teste7 == 1){
                        inimigo2.label2.setBounds(inimigo2.label2.getX()-5, inimigo2.label2.getY(), 35, 37);
                    }
                    if(inimigo2.label3.getY() == 550){
                        teste8 = 1;
                    }
                    if(inimigo2.label3.getY() == 100){
                        teste8 = 0;
                    }
                    if(teste8 == 0){
                        inimigo2.label3.setBounds(inimigo2.label3.getX(), inimigo2.label3.getY()+5, 35, 37);
                    }
                    if(teste8 == 1){
                        inimigo2.label3.setBounds(inimigo2.label3.getX(), inimigo2.label3.getY()-5, 35, 37);
                    }
            }
        }
}
    
    /**
    *Identifica e adiciona os elementos de cada fase
    * @param i int - identificador da fase
    */
    public void Fase(int i){
        
        add(lSaida);
        switch(i){
            case 1:
                add(inimigo1.label0);
                add(inimigo2.label0);
                add(inimigo1.label1);
                add(inimigo2.label1);
                add(lFundo1);
                player.label.setBounds(player.x, player.y, 80, 125);
                lSaida.setBounds(0, 0, 148, 125);
                inimigo1.label0.setBounds(inimigo1.x, inimigo1.y, 30, 35);
                inimigo2.label0.setBounds(inimigo2.x, inimigo2.y, 35, 37);
                inimigo1.label1.setBounds(255, 157, 30, 35);
                inimigo2.label1.setBounds(380, 450, 35, 37);
                break;
            case 2:
                add(inimigo1.label0);
                add(inimigo1.label1);
                add(inimigo2.label0);
                add(inimigo1.label2);
                add(inimigo2.label1);
                player.x = 700;
                player.y = 550;
                player.label.setBounds(700, 550, 80, 125);
                lFundo1.setIcon(iconFundo2);
                add(lFundo1);
                lSaida.setBounds(250, 0, 148, 125);
                inimigo1.label0.setBounds(inimigo1.x, inimigo1.y, 30, 35);
                inimigo1.label1.setBounds(100, 400, 30, 35);
                inimigo2.label0.setBounds(inimigo2.x, inimigo2.y, 35, 37);
                inimigo1.label2.setBounds(450, 500, 30, 35);
                inimigo2.label1.setBounds(580, 400, 35, 37);
                new movInimigo().start();
                break;
            case 3:
                add(inimigo1.label0);
                add(inimigo1.label1);
                add(inimigo1.label2);
                add(inimigo2.label0);
                add(inimigo2.label1);
                add(inimigo2.label2);
                player.x = 125;
                player.y = 600;
                player.label.setBounds(125, 600, 80, 125);
                lFundo1.setIcon(iconFundo3);
                add(lFundo1);
                lSaida.setBounds(500, 50, 148, 125);
                inimigo1.label0.setBounds(inimigo1.x, inimigo1.y, 30, 35);
                inimigo1.label1.setBounds(100, 400, 30, 35);
                inimigo1.label2.setBounds(500, 400, 30, 35);
                inimigo2.label0.setBounds(250, 200, 35, 37);
                inimigo2.label1.setBounds(150, 350, 35, 37);
                inimigo2.label2.setBounds(550, 370, 35, 37);
                new movInimigo().start();
                break;
            case 4:
                add(inimigo1.label0);
                add(inimigo1.label1);
                add(inimigo1.label2);
                add(inimigo1.label3);
                add(inimigo2.label0);
                add(inimigo2.label1);
                add(inimigo2.label2);
                add(inimigo2.label3);
                player.x = 700;
                player.y = 0;
                player.label.setBounds(700, 0, 80, 125);
                lFundo1.setIcon(iconFundo4);
                add(lFundo1);
                lSaida.setBounds(350, 550, 148, 125);
                inimigo1.label0.setBounds(inimigo1.x, inimigo1.y, 30, 35);
                inimigo1.label1.setBounds(100, 400, 30, 35);
                inimigo1.label2.setBounds(500, 375, 30, 35);
                inimigo1.label3.setBounds(650, 600, 30, 35);
                inimigo2.label0.setBounds(250, 200, 35, 37);
                inimigo2.label1.setBounds(150, 350, 35, 37);
                inimigo2.label2.setBounds(550, 370, 35, 37);
                inimigo2.label3.setBounds(50, 670, 35, 37);
                new movInimigo().start();
                break;
                
        }
        
        lFundo1.setBounds(0, 0, 800, 700);
    }
    
    /**
    *Classe principal que executa o Jogo
    * @param i int - identificador da fase
    */
    public Jogo(int i){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        add(player.label);
        Fase(i);
        movimento(i);
    }
    
    /**
     * Classe main chama a tela inicial
     * @param args 
     */
    public static void main(String[] args) {

        TelaInicial telaI = new TelaInicial();
        telaI.setVisible(true);
    }
    
}
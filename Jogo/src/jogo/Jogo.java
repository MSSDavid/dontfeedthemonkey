
package jogo;

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

    //Pega as imagens para os objetos
    ImageIcon iconPlayer = new ImageIcon(getClass().getResource("player.png"));
    ImageIcon iconSaida = new ImageIcon(getClass().getResource("saida.png"));
    ImageIcon iconFundo1 = new ImageIcon(getClass().getResource("fundo1.png"));
    ImageIcon iconInimigo1 = new ImageIcon(getClass().getResource("inimigo1.png"));
    ImageIcon iconInimigo2 = new ImageIcon(getClass().getResource("inimigo2.png"));
    
    //Set como JLabel para manipular no programa
    JLabel lPlayer = new JLabel(iconPlayer);
    JLabel lSaida = new JLabel (iconSaida);
    JLabel lFundo1 = new JLabel(iconFundo1);
    JLabel lIni1 = new JLabel(iconInimigo1);
    JLabel lIni2 = new JLabel(iconInimigo2);
    
    //Valores para a posição do objeto personagem
    int playerX = 300;
    int playerY = 300;
    int pont = 0;

    /**
     *Set os tamanhos dos objetos no tela em pixels
     */
    public void editarComponetes(){
        lPlayer.setBounds(playerX, playerY, 90, 125);
        lSaida.setBounds(0, 0, 148, 125);
        lFundo1.setBounds(0, 0, 800, 700);
        lIni1.setBounds(500, 100, 50, 48);
        lIni2.setBounds(100, 250, 60, 47);
    }    
    
    /**
     *Define o Tamanho da Janela e coloca os objetos nela
     */
    public void editarJanela(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        add(lPlayer);
        add(lSaida);
        add(lIni1);
        add(lIni2);
        add(lFundo1);
    }

    //realiza o movimento do objeto Personagem, com as teclas do teclado
    public void movimento(){
        addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent ke) {
                
            }

            public void keyPressed(KeyEvent ke) {
                //Colisão com o objeto saida
                if((playerY <= 50) && (playerX <= 80)){
                    TelaFinal tela = new TelaFinal(pont);
                    tela.setVisible(true);
                    dispose();
                }
                //Colisão com os Inimigos
                if(((playerY >= 500) && (playerX <= 148)) || ((playerY >= 100) && (playerX <= 297))){
                    TelaFinal tela = new TelaFinal(1017);
                    tela.setVisible(true);
                    dispose();
                }
            }

            public void keyReleased(KeyEvent ke) {
                //Identifica a tecla que foi pressionada e altera a variavel que define a pocisão do personagem
                if(ke.getKeyCode() == 38){
                    playerY -=30;
                }
                if(ke.getKeyCode() == 40) {
                    playerY +=30;
                }
                if(ke.getKeyCode() == 37) {
                    playerX -=30;
                }
                if(ke.getKeyCode() == 39) {
                    playerX +=30;
                }
                //Faz uma contagem de passos paraa pontuação
                pont ++;
                //Movimenta o Personagem
                lPlayer.setBounds(playerX, playerY, 90, 125);
            }
            
        });
    }   
    
    public Jogo(){
        editarJanela();
        editarComponetes();
        movimento();
    }
    
    public static void main(String[] args) {

        TelaInicial telaI = new TelaInicial();
        telaI.setVisible(true);
    }
    
}

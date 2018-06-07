
package jogo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Jogo extends JFrame {

    ImageIcon iconPlayer = new ImageIcon(getClass().getResource("player.png"));
    ImageIcon iconSaida = new ImageIcon(getClass().getResource("saida.png"));
    
    JLabel lPlayer = new JLabel(iconPlayer);
    JLabel lSaida = new JLabel (iconSaida);
    
    int playerX = 300;
    int playerY = 300;
    int pont = 0;

    
    
    public void editarComponetes(){
        lPlayer.setBounds(playerX, playerY, 90, 125);
        lSaida.setBounds(0, 0, 148, 125);
    }    
    
    public void editarJanela(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        add(lPlayer);
        add(lSaida);
    }

    
    public void movimento(){
        addKeyListener(new KeyListener(){
            
            public void keyTyped(KeyEvent ke) {
                
            }

            public void keyPressed(KeyEvent ke) {
                if((playerY <= 50) && (playerX <= 80)){
                    TelaFinal tela = new TelaFinal(pont);
                    tela.setVisible(true);
                    dispose();
                }
            }

            public void keyReleased(KeyEvent ke) {
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
                pont ++;
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
        
        //int quantJogo;
        //int record;
        
        //quantJogo = 
    
        //if( quantJogo > 0 ){
            TelaInicial telaI = new TelaInicial();
            telaI.setVisible(true);
        
        /*} else {
        TelaInicial telaI = new TelaInicial(quantJogo, record);
        telaI.setVisible(true);
        }*/
        
    }
    
}

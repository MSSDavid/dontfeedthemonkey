/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Anderson
 */
public class Jogador extends Personagem{
        
    ImageIcon iconCimaP = new ImageIcon(getClass().getResource("player_cima.png"));    
    ImageIcon iconBaixoP = new ImageIcon(getClass().getResource("player_baixo.png"));    
    ImageIcon iconDirP = new ImageIcon(getClass().getResource("player_dir.png"));    
    ImageIcon iconEsqP = new ImageIcon(getClass().getResource("player_esq.png"));
    ImageIcon iconCimaMexendo = new ImageIcon(getClass().getResource("player_cima.gif"));
    ImageIcon iconBaixoMexendo = new ImageIcon(getClass().getResource("player_baixo.gif"));
    ImageIcon iconDirMexendo = new ImageIcon(getClass().getResource("player_dir.gif"));
    ImageIcon iconEsqMexendo = new ImageIcon(getClass().getResource("player_esq.gif"));
    
    JLabel label = new JLabel(iconBaixoP);
    
    int x = 300;
    int y = 300;
    
    int pont = 0;
}

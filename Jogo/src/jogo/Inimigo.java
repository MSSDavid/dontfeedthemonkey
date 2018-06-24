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
public class Inimigo extends Personagem {
    
    ImageIcon icon = new ImageIcon(getClass().getResource("inimigo1.png"));
    
    JLabel label = new JLabel(icon);
    
    int x = 500;
    int y = 100;
}

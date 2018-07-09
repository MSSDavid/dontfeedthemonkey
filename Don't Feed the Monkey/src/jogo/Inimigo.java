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
 * @author Anderson Luiz
 * Classe do Inimigo 1
 */
public class Inimigo extends Personagem {
    
    ImageIcon icon = new ImageIcon(getClass().getResource("inimigo1.png"));
    
    JLabel label0 = new JLabel(icon);
    JLabel label1 = new JLabel(icon);
    JLabel label2 = new JLabel(icon);
    JLabel label3 = new JLabel(icon);
    
    int x = 500;
    int y = 100;
}

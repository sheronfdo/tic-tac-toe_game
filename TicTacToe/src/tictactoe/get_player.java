/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jamit
 */
public class get_player extends JFrame implements ActionListener{
    
    public get_player(){
        gui();
    }
    
    JLabel leftlabel = new JLabel();
    JLabel rightlabel = new JLabel(); 
    JTextField leftplayer = new JTextField();
    JTextField rightplayer = new JTextField();
    
    
    public void gui(){
        leftlabel.setBounds(10, 100, 150, 40);
        leftlabel.setText("Left Player Name");
        leftlabel.setBackground(Color.white);
        leftlabel.setOpaque(true);
        
        rightlabel.setBounds(10, 150, 150, 40);
        rightlabel.setText("Right Player Name");
        rightlabel.setBackground(Color.white);
        rightlabel.setOpaque(true);
        
        this.add(leftlabel);
        this.add(rightlabel);
        this.add(leftplayer);
        this.add(rightplayer);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(1500, 0, 301, 439);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
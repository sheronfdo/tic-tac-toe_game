/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jamit
 */
public class get_player extends JFrame implements ActionListener{
    
    public get_player(){
        gui();
    }
    JButton button = new JButton("Start the GAME");
    JLabel leftlabel = new JLabel();
    JLabel rightlabel = new JLabel(); 
    JTextField leftplayer = new JTextField();
    JTextField rightplayer = new JTextField();
    Font font = new Font("Calibri", Font.BOLD, 15);
    
    public void gui(){
        leftlabel.setBounds(10, 100, 110, 40);
        leftlabel.setText("Left Player Name");
        leftlabel.setFont(font);
        leftlabel.setBackground(Color.white);
        leftlabel.setOpaque(true);
        
        rightlabel.setBounds(10, 150, 110, 40);
        rightlabel.setText("Right Player Name");
        rightlabel.setFont(font);
        rightlabel.setBackground(Color.white);
        rightlabel.setOpaque(true);
        
        leftplayer.setBounds(130, 100, 150, 40);
        leftplayer.setFont(font);
        
        rightplayer.setBounds(130, 150, 150, 40);
        rightplayer.setFont(font);
        
        button.setBounds(10, 200, 265, 40);
        button.addActionListener(this);
        
        this.add(button);
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
        if(e.getSource() == button){
            if((leftplayer.getText() == "") || (rightplayer.getText() == "")){
                if(leftplayer.getText() == ""){
                    JOptionPane.showConfirmDialog(this, "Please give us a name for first player", "Name doesn't insert", WIDTH);
                }
                if(rightplayer.getText() == ""){
                    JOptionPane.showConfirmDialog(this, "Please give us a name for second player", "Name doesn't insert", WIDTH);
                }
            } else {
                this.setVisible(false);
                new GUinterface(leftplayer.getText(),rightplayer.getText());
            }
        }
    }
    
}

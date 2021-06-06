/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamit
 */
public class GUinterface extends JFrame implements ActionListener {

    boolean singleplayer;

    public GUinterface(String leftname, String rightname, boolean singleplay) {
        gui(leftname, rightname);
        singleplayer = singleplay;

    }

    JLabel headlabel = new JLabel();
    JLabel body = new JLabel();
    JLabel leftgamer = new JLabel();
    JLabel rightgamer = new JLabel();
    String cplayer = "left";
    ImageIcon righticon = new ImageIcon("image/cross.png");
    ImageIcon lefticon = new ImageIcon("image/check.png");
    ImageIcon cpicon;
    Border border = BorderFactory.createLineBorder(Color.black, 2);
    Border pborder = BorderFactory.createTitledBorder(border, "player");

    String[][] result = new String[3][3];

    JButton but1 = new JButton();
    JButton but2 = new JButton();
    JButton but3 = new JButton();
    JButton but4 = new JButton();
    JButton but5 = new JButton();
    JButton but6 = new JButton();
    JButton but7 = new JButton();
    JButton but8 = new JButton();
    JButton but9 = new JButton();

    public void gui(String leftname, String rightname) {

        but1.setBounds(0, 0, 95, 100);
        but1.addActionListener(this);
        but1.setBackground(Color.white);
        but1.setBorder(border);

        but2.setBounds(95, 0, 95, 100);
        but2.addActionListener(this);
        but2.setBackground(Color.white);
        but2.setBorder(border);

        but3.setBounds(190, 0, 95, 100);
        but3.addActionListener(this);
        but3.setBackground(Color.white);
        but3.setBorder(border);

        but4.setBounds(0, 100, 95, 100);
        but4.addActionListener(this);
        but4.setBackground(Color.white);
        but4.setBorder(border);

        but5.setBounds(95, 100, 95, 100);
        but5.addActionListener(this);
        but5.setBackground(Color.white);
        but5.setBorder(border);

        but6.setBounds(190, 100, 95, 100);
        but6.addActionListener(this);
        but6.setBackground(Color.white);
        but6.setBorder(border);

        but7.setBounds(0, 200, 95, 100);
        but7.addActionListener(this);
        but7.setBackground(Color.white);
        but7.setBorder(border);

        but8.setBounds(95, 200, 95, 100);
        but8.addActionListener(this);
        but8.setBackground(Color.white);
        but8.setBorder(border);

        but9.setBounds(190, 200, 95, 100);
        but9.addActionListener(this);
        but9.setBackground(Color.white);
        but9.setBorder(border);

        rightgamer.setBounds(145, 10, 140, 90);
        rightgamer.setText(rightname);
        rightgamer.setFont(new Font("calibri", Font.BOLD, 15));
        rightgamer.setIcon(righticon);
        rightgamer.setIconTextGap(15);
        rightgamer.setBackground(Color.LIGHT_GRAY);
        rightgamer.setForeground(Color.blue);
        rightgamer.setOpaque(true);
        rightgamer.setBorder(border);

        leftgamer.setBounds(0, 10, 140, 90);
        leftgamer.setText(leftname);
        leftgamer.setFont(new Font("calibri", Font.BOLD, 15));
        leftgamer.setIcon(lefticon);
        leftgamer.setIconTextGap(15);
        leftgamer.setBackground(Color.LIGHT_GRAY);
        leftgamer.setForeground(Color.blue);
        leftgamer.setOpaque(true);
        leftgamer.setBorder(border);

        headlabel.add(leftgamer);
        headlabel.add(rightgamer);
        headlabel.setBounds(0, 0, 300, 100);
        headlabel.setBackground(Color.DARK_GRAY);
        headlabel.setOpaque(true);

        body.add(but9);
        body.add(but8);
        body.add(but7);
        body.add(but6);
        body.add(but5);
        body.add(but4);
        body.add(but3);
        body.add(but2);
        body.add(but1);
        body.setBounds(0, 100, 500, 500);
        body.setBackground(Color.GRAY);
        body.setOpaque(true);

        this.add(headlabel);
        this.add(body);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(1500, 0, 301, 439);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void player() {
        System.out.println("player running");
        if (cplayer == "left") {
            cpicon = lefticon;
        }
        if (cplayer == "right") {
            cpicon = righticon;
        }
    }

    public void next_player() {
        System.out.println("next_player running");
        if (cplayer == "left") {
            cplayer = "right";
            leftgamer.setBorder(border);
            rightgamer.setBorder(pborder);
        } else if (cplayer == "right") {
            cplayer = "left";
            rightgamer.setBorder(border);
            leftgamer.setBorder(pborder);
        }
    }

    public void butdisable(String winner) {
        System.out.println("but_disable running");
        but1.setEnabled(false);
        but2.setEnabled(false);
        but3.setEnabled(false);
        but4.setEnabled(false);
        but5.setEnabled(false);
        but6.setEnabled(false);
        but7.setEnabled(false);
        but8.setEnabled(false);
        but9.setEnabled(false);

        if (winner == "left") {
            JOptionPane.showMessageDialog(null, "winner is " + leftgamer.getText(), "Winner", JOptionPane.PLAIN_MESSAGE);
        }
        if (winner == "right") {
            JOptionPane.showMessageDialog(null, "winner is " + rightgamer.getText(), "Winner", JOptionPane.PLAIN_MESSAGE);
        }
        won = true;
    }
    boolean won = false;

    public void check_win() {
        System.out.println("check_win running");
        if ((result[0][0] == result[1][0]) && (result[2][0] == result[1][0]) && (result[0][0] != null)) {
            but1.setBackground(Color.BLUE);
            but4.setBackground(Color.BLUE);
            but7.setBackground(Color.BLUE);
            butdisable(result[0][0]);
        } else if ((result[0][1] == result[1][1]) && (result[2][1] == result[1][1]) && (result[0][1] != null)) {
            but2.setBackground(Color.BLUE);
            but5.setBackground(Color.BLUE);
            but8.setBackground(Color.BLUE);
            butdisable(result[0][1]);
        } else if ((result[0][2] == result[1][2]) && (result[2][2] == result[1][2]) && (result[0][2] != null)) {
            but3.setBackground(Color.BLUE);
            but6.setBackground(Color.BLUE);
            but9.setBackground(Color.BLUE);
            butdisable(result[0][2]);
        } else if ((result[0][0] == result[0][1]) && (result[0][2] == result[0][1]) && (result[0][0] != null)) {
            but1.setBackground(Color.BLUE);
            but2.setBackground(Color.BLUE);
            but3.setBackground(Color.BLUE);
            butdisable(result[0][0]);
        } else if ((result[1][0] == result[1][1]) && (result[1][2] == result[1][1]) && (result[1][0] != null)) {
            but4.setBackground(Color.BLUE);
            but5.setBackground(Color.BLUE);
            but6.setBackground(Color.BLUE);
            butdisable(result[1][0]);
        } else if ((result[2][0] == result[2][1]) && (result[2][2] == result[2][1]) && (result[2][0] != null)) {
            but7.setBackground(Color.BLUE);
            but8.setBackground(Color.BLUE);
            but9.setBackground(Color.BLUE);
            butdisable(result[2][0]);
        } else if ((result[0][0] == result[1][1]) && (result[2][2] == result[1][1]) && (result[2][2] != null)) {
            but1.setBackground(Color.BLUE);
            but5.setBackground(Color.BLUE);
            but9.setBackground(Color.BLUE);
            butdisable(result[2][2]);
        } else if ((result[0][2] == result[1][1]) && (result[2][0] == result[1][1]) && (result[1][1] != null)) {
            but3.setBackground(Color.BLUE);
            but5.setBackground(Color.BLUE);
            but7.setBackground(Color.BLUE);
            butdisable(result[1][1]);
        }
    }

    //winning patterns
    boolean pat1;
    boolean pat2;
    boolean pat3;
    boolean pat4;
    boolean pat5;
    boolean pat6;
    boolean pat7;
    boolean pat8;

    public void check_win_chance() {

        JButton button = new JButton();
        pat1 = (result[0][0] == "right" || result[1][0] == "right" || result[2][0] == "right") && (result[0][0] != "left" && result[1][0] != "left" && result[2][0] != "left");
        pat2 = (result[0][1] == "right" || result[1][1] == "right" || result[2][1] == "right") && (result[0][1] != "left" && result[1][1] != "left" && result[2][1] != "left");
        pat3 = (result[0][2] == "right" || result[1][2] == "right" || result[2][2] == "right") && (result[0][2] != "left" && result[1][2] != "left" && result[2][2] != "left");
        pat4 = (result[0][0] == "right" || result[0][1] == "right" || result[0][2] == "right") && (result[0][0] != "left" && result[0][1] != "left" && result[0][2] != "left");
        pat5 = (result[1][0] == "right" || result[1][1] == "right" || result[1][2] == "right") && (result[1][0] != "left" && result[1][1] != "left" && result[1][2] != "left");
        pat6 = (result[2][0] == "right" || result[2][1] == "right" || result[2][2] == "right") && (result[2][0] != "left" && result[2][1] != "left" && result[2][2] != "left");
        pat7 = (result[0][0] == "right" || result[1][1] == "right" || result[2][2] == "right") && (result[0][0] != "left" && result[1][1] != "left" && result[2][2] != "left");
        pat8 = (result[0][2] == "right" || result[1][1] == "right" || result[2][0] == "right") && (result[0][2] != "left" && result[1][1] != "left" && result[2][0] != "left");

        if (!won && singleplayer) {
            System.out.println("check_win_chance running");
            if (pat1) {
                int i = 0;
                if (result[0][0] == "right") {
                    i = i + 1;
                }
                if (result[1][0] == "right") {
                    i = i + 1;
                }
                if (result[2][0] == "right") {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][0] != "right") {
                        button = but1;
                        result[0][0] = "right";
                    }
                    if (result[1][0] != "right") {
                        button = but4;
                        result[1][0] = "right";
                    }
                    if (result[2][0] != "right") {
                        button = but7;
                        result[2][0] = "right";
                    }
                }
            } else if (pat2) {
                int i = 0;
                if (result[0][1] == "right") {
                    i = i + 1;
                }
                if (result[1][1] == "right") {
                    i = i + 1;
                }
                if (result[2][1] == "right") {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][1] != "right") {
                        button = but2;
                        result[0][1] = "right";
                    }
                    if (result[1][1] != "right") {
                        button = but5;
                        result[1][1] = "right";
                    }
                    if (result[2][1] != "right") {
                        button = but8;
                        result[2][1] = "right";
                    }
                }
            } else if (pat3) {
                int i = 0;
                if (result[0][2] == "right") {
                    i = i + 1;
                }
                if (result[1][2] == "right") {
                    i = i + 1;
                }
                if (result[2][2] == "right") {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][2] != "right") {
                        button = but3;
                        result[0][2] = "right";
                    }
                    if (result[1][2] != "right") {
                        button = but6;
                        result[1][2] = "right";
                    }
                    if (result[2][2] != "right") {
                        button = but9;
                        result[2][2] = "right";
                    }
                }
            } else if (pat4) {
                int i = 0;
                if (result[0][0] == "right") {
                    i = i + 1;
                }
                if (result[0][1] == "right") {
                    i = i + 1;
                }
                if (result[0][2] == "right") {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][0] != "right") {
                        result[0][0] = "right";
                        button = but1;
                    }
                    if (result[0][1] != "right") {
                        result[0][1] = "right";
                        button = but2;
                    }
                    if (result[0][2] != "right") {
                        result[0][2] = "right";
                        button = but3;
                    }
                }
            } else if (pat5) {
                int i = 0;
                if (result[1][0] == "right") {
                    i = i + 1;
                }
                if (result[1][1] == "right") {
                    i = i + 1;
                }
                if (result[1][2] == "right") {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[1][0] != "right") {
                        button = but4;
                        result[1][0] = "right";
                    }
                    if (result[1][1] != "right") {
                        button = but5;
                        result[1][1] = "right";
                    }
                    if (result[1][2] != "right") {
                        button = but6;
                        result[1][2] = "right";
                    }
                }
            } else if (pat6) {
                int i = 0;
                if (result[2][0] == "right") {
                    i = i + 1;
                }
                if (result[2][1] == "right") {
                    i = i + 1;
                }
                if (result[2][2] == "right") {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[2][0] != "right") {
                        result[2][0] = "right";
                        button = but7;
                    }
                    if (result[2][1] != "right") {
                        result[2][1] = "right";
                        button = but8;
                    }
                    if (result[2][2] != "right") {
                        result[2][2] = "right";
                        button = but9;
                    }
                }
            } else if (pat7) {
                int i = 0;
                if (result[0][0] == "right") {
                    i = i + 1;
                }
                if (result[1][1] == "right") {
                    i = i + 1;
                }
                if (result[2][2] == "right") {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][0] != "right") {
                        result[0][0] = "right";
                        button = but1;
                    }
                    if (result[1][1] != "right") {
                        result[1][1] = "right";
                        button = but5;
                    }
                    if (result[2][2] != "right") {
                        result[2][2] = "right";
                        button = but9;
                    }
                }
            } else if (pat8) {
                int i = 0;
                if (result[0][2] == "right") {
                    i = i + 1;
                }
                if (result[1][1] == "right") {
                    i = i + 1;
                }
                if (result[2][0] == "right") {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][2] != "right") {
                        result[0][2] = "right";
                        button = but3;
                    }
                    if (result[1][1] != "right") {
                        result[1][1] = "right";
                        button = but5;
                    }
                    if (result[2][0] != "right") {
                        result[2][0] = "right";
                        button = but7;
                    }
                }
            }
            button.setIcon(cpicon);
            button.setEnabled(false);
            check_win();
        }
    }

    //boolean[] risky_patterns_def = {false,false,false,false,false,false,false,false};
    public void check_risk() {

        player();
        check_win_chance();
        ArrayList<JButton> com_buttons = new ArrayList<JButton>();
        ArrayList<JButton> most_com_buttons = new ArrayList<JButton>();

        System.out.println("");
        pat1 = (result[0][0] == "left" || result[1][0] == "left" || result[2][0] == "left") && (result[0][0] != "right" && result[1][0] != "right" && result[2][0] != "right");
        pat2 = (result[0][1] == "left" || result[1][1] == "left" || result[2][1] == "left") && (result[0][1] != "right" && result[1][1] != "right" && result[2][1] != "right");
        pat3 = (result[0][2] == "left" || result[1][2] == "left" || result[2][2] == "left") && (result[0][2] != "right" && result[1][2] != "right" && result[2][2] != "right");
        pat4 = (result[0][0] == "left" || result[0][1] == "left" || result[0][2] == "left") && (result[0][0] != "right" && result[0][1] != "right" && result[0][2] != "right");
        pat5 = (result[1][0] == "left" || result[1][1] == "left" || result[1][2] == "left") && (result[1][0] != "right" && result[1][1] != "right" && result[1][2] != "right");
        pat6 = (result[2][0] == "left" || result[2][1] == "left" || result[2][2] == "left") && (result[2][0] != "right" && result[2][1] != "right" && result[2][2] != "right");
        pat7 = (result[0][0] == "left" || result[1][1] == "left" || result[2][2] == "left") && (result[0][0] != "right" && result[1][1] != "right" && result[2][2] != "right");
        pat8 = (result[0][2] == "left" || result[1][1] == "left" || result[2][0] == "left") && (result[0][2] != "right" && result[1][1] != "right" && result[2][0] != "right");

        if (!won && singleplayer) {
            System.out.println("check_risk running");
            if (pat1) {
                int i = 0;
                if (result[0][0] != "left") {
                    com_buttons.add(but1);
                } else {
                    i = i + 1;
                }
                if (result[1][0] != "left") {
                    com_buttons.add(but4);
                } else {
                    i = i + 1;
                }
                if (result[2][0] != "left") {
                    com_buttons.add(but7);
                } else {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][0] != "left") {
                        most_com_buttons.add(but1);
                    }
                    if (result[1][0] != "left") {
                        most_com_buttons.add(but4);
                    }
                    if (result[2][0] != "left") {
                        most_com_buttons.add(but7);
                    }
                }
            }
            if (pat2) {
                int i = 0;
                if (result[0][1] != "left") {
                    com_buttons.add(but2);
                } else {
                    i = i + 1;
                }
                if (result[1][1] != "left") {
                    com_buttons.add(but5);
                } else {
                    i = i + 1;
                }
                if (result[2][1] != "left") {
                    com_buttons.add(but8);
                } else {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][1] != "left") {
                        most_com_buttons.add(but2);
                    }
                    if (result[1][1] != "left") {
                        most_com_buttons.add(but5);
                    }
                    if (result[2][1] != "left") {
                        most_com_buttons.add(but8);
                    }
                }
            }
            if (pat3) {
                int i = 0;
                if (result[0][2] != "left") {
                    com_buttons.add(but3);
                } else {
                    i = i + 1;
                }
                if (result[1][2] != "left") {
                    com_buttons.add(but6);
                } else {
                    i = i + 1;
                }
                if (result[2][2] != "left") {
                    com_buttons.add(but9);
                } else {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][2] != "left") {
                        most_com_buttons.add(but3);
                    }
                    if (result[1][2] != "left") {
                        most_com_buttons.add(but6);
                    }
                    if (result[2][2] != "left") {
                        most_com_buttons.add(but9);
                    }
                }
            }
            if (pat4) {
                int i = 0;
                if (result[0][0] != "left") {
                    com_buttons.add(but1);
                } else {
                    i = i + 1;
                }
                if (result[0][1] != "left") {
                    com_buttons.add(but2);
                } else {
                    i = i + 1;
                }
                if (result[0][2] != "left") {
                    com_buttons.add(but3);
                } else {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][0] != "left") {
                        most_com_buttons.add(but1);
                    }
                    if (result[0][1] != "left") {
                        most_com_buttons.add(but2);
                    }
                    if (result[0][2] != "left") {
                        most_com_buttons.add(but3);
                    }
                }
            }
            if (pat5) {
                int i = 0;
                if (result[1][0] != "left") {
                    com_buttons.add(but4);
                } else {
                    i = i + 1;
                }
                if (result[1][1] != "left") {
                    com_buttons.add(but5);
                } else {
                    i = i + 1;
                }
                if (result[1][2] != "left") {
                    com_buttons.add(but6);
                } else {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[1][0] != "left") {
                        most_com_buttons.add(but4);
                    }
                    if (result[1][1] != "left") {
                        most_com_buttons.add(but5);
                    }
                    if (result[1][2] != "left") {
                        most_com_buttons.add(but6);
                    }
                }
            }
            if (pat6) {
                int i = 0;
                if (result[2][0] != "left") {
                    com_buttons.add(but7);
                } else {
                    i = i + 1;
                }
                if (result[2][1] != "left") {
                    com_buttons.add(but8);
                } else {
                    i = i + 1;
                }
                if (result[2][2] != "left") {
                    com_buttons.add(but9);
                } else {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[2][0] != "left") {
                        most_com_buttons.add(but7);
                    }
                    if (result[2][1] != "left") {
                        most_com_buttons.add(but8);
                    }
                    if (result[2][2] != "left") {
                        most_com_buttons.add(but9);
                    }
                }
            }
            if (pat7) {
                int i = 0;
                if (result[0][0] != "left") {
                    com_buttons.add(but1);
                } else {
                    i = i + 1;
                }
                if (result[1][1] != "left") {
                    com_buttons.add(but5);
                } else {
                    i = i + 1;
                }
                if (result[2][2] != "left") {
                    com_buttons.add(but9);
                } else {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][0] != "left") {
                        most_com_buttons.add(but1);
                    }
                    if (result[1][1] != "left") {
                        most_com_buttons.add(but5);
                    }
                    if (result[2][2] != "left") {
                        most_com_buttons.add(but9);
                    }
                }
            }
            if (pat8) {
                int i = 0;
                if (result[0][2] != "left") {
                    com_buttons.add(but3);
                } else {
                    i = i + 1;
                }
                if (result[1][1] != "left") {
                    com_buttons.add(but5);
                } else {
                    i = i + 1;
                }
                if (result[2][0] != "left") {
                    com_buttons.add(but7);
                } else {
                    i = i + 1;
                }
                if (i > 1) {
                    if (result[0][2] != "left") {
                        most_com_buttons.add(but3);
                    }
                    if (result[1][1] != "left") {
                        most_com_buttons.add(but5);
                    }
                    if (result[2][0] != "left") {
                        most_com_buttons.add(but7);
                    }
                }
            }

            if (most_com_buttons.size() > 0) {
                get_suit_button(most_com_buttons);
            } else {
                get_suit_button(com_buttons);
            }
        }
    }

    public void get_suit_button(ArrayList<JButton> buttons) {
        System.out.println("get_sui_button running");
        ArrayList<JButton> mc_buttons = buttons;
        JButton button = null;
        ArrayList<JButton> sui_buttons = new ArrayList<JButton>();
        HashMap<JButton, Integer> prob = new HashMap<JButton, Integer>();
        for (int i = 0; i < mc_buttons.size(); i++) {
            int count = 0;
            JButton but = mc_buttons.get(i);
            for (int j = 0; j < mc_buttons.size(); j++) {
                if (but == mc_buttons.get(j)) {
                    count += 1;
                }
            }
            prob.put(but, count);
        }
        Set set = prob.entrySet();
        Iterator i = set.iterator();
        int max = 0;
        while (i.hasNext()) {
            Map.Entry val = (Map.Entry) i.next();
            if ((int) val.getValue() > max) {
                max = (int) val.getValue();
            }
        }
        System.out.println(max);
        Iterator p = set.iterator();
        while (p.hasNext()) {
            Map.Entry val = (Map.Entry) p.next();
            if ((int) val.getValue() == max) {
                sui_buttons.add((JButton) val.getKey());
            }
        }

        System.out.println(sui_buttons.size() + "\n");
        Random random = new Random();
        int but = 0;
        try {
            but = random.nextInt(sui_buttons.size());
        } catch (IllegalArgumentException e) {
        }
        System.out.println(but);
        try {
            button = sui_buttons.get(but);
        } catch (IndexOutOfBoundsException e) {
        }
        try {
            button.setIcon(cpicon);
            button.setEnabled(false);

            if (button == but1) {
                result[0][0] = cplayer;
                System.out.println("but1");
            } else if (button == but2) {
                result[0][1] = cplayer;
                System.out.println("but2");
            } else if (button == but3) {
                result[0][2] = cplayer;
                System.out.println("but3");
            } else if (button == but4) {
                result[1][0] = cplayer;
                System.out.println("but4");
            } else if (button == but5) {
                result[1][1] = cplayer;
                System.out.println("but5");
            } else if (button == but6) {
                result[1][2] = cplayer;
                System.out.println("but6");
            } else if (button == but7) {
                result[2][0] = cplayer;
                System.out.println("but7");
            } else if (button == but8) {
                result[2][1] = cplayer;
                System.out.println("but8");
            } else if (button == but9) {
                result[2][2] = cplayer;
                System.out.println("but9");
            }
        } catch (NullPointerException e) {
        }
        check_win();
        next_player();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player();

        if (e.getSource() == but1) {
            but1.setIcon(cpicon);
            but1.setEnabled(false);
            result[0][0] = cplayer;
        }
        if (e.getSource() == but2) {
            but2.setIcon(cpicon);
            but2.setEnabled(false);
            result[0][1] = cplayer;
        }
        if (e.getSource() == but3) {
            but3.setIcon(cpicon);
            but3.setEnabled(false);
            result[0][2] = cplayer;
        }
        if (e.getSource() == but4) {
            but4.setIcon(cpicon);
            but4.setEnabled(false);
            result[1][0] = cplayer;
        }
        if (e.getSource() == but5) {
            but5.setIcon(cpicon);
            but5.setEnabled(false);
            result[1][1] = cplayer;
        }
        if (e.getSource() == but6) {
            but6.setIcon(cpicon);
            but6.setEnabled(false);
            result[1][2] = cplayer;
        }
        if (e.getSource() == but7) {
            but7.setIcon(cpicon);
            but7.setEnabled(false);
            result[2][0] = cplayer;
        }
        if (e.getSource() == but8) {
            but8.setIcon(cpicon);
            but8.setEnabled(false);
            result[2][1] = cplayer;
        }
        if (e.getSource() == but9) {
            but9.setIcon(cpicon);
            but9.setEnabled(false);
            result[2][2] = cplayer;
        }
        next_player();
        check_win();
        if (cplayer == "right") {
            check_risk();
        }
    }
}

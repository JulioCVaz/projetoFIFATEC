package Fifatec;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class HomeUI extends JFrame {
    
    JLabel lblTitulo1        = new JLabel ("FIFA"),
           lblTitulo2        = new JLabel ("tec"),
           lblNomes         = new JLabel ("Desenvolvido por: Bruno Vagliengo, Carlos Henrique, Gabriel do Nascimento, Ítalo Sales e Júlio Vaz - ETEC ZL - PC II 3ºA");
    JButton btnDALE         = new JButton("DALE"),
            btnDELE         = new JButton("DELE"),
            btnDILE         = new JButton("DILE");



    public HomeUI(){
        
        super("HOME FIFAtec");
        Container Tela = getContentPane();
        setLayout(null);
        
        lblTitulo1.setFont(new Font("EA Font v1.5 by Ghettoshark", Font.BOLD, 120));
        lblTitulo2.setFont(new Font("EA Font v1.5 by Ghettoshark", Font.ITALIC, 100));
        lblTitulo1.setForeground(Color.white);
        lblTitulo2.setForeground(Color.white);
        lblNomes.setForeground(Color.white);
        lblTitulo1.setBounds(280,20,350,200);
        lblTitulo2.setBounds(540,23,350,200);
        lblNomes.setBounds(300,700,700,20);
        
          
        
        btnDALE.setBounds(100,280,200,200);
        btnDELE.setBounds(412,280,200,200);
        btnDILE.setBounds(724,280,200,200);
        
        btnDALE.setBorder(null);
        btnDELE.setBorder(null);
        btnDILE.setBorder(null);
        
        btnDALE.setBackground(Color.GRAY);
        btnDELE.setBackground(Color.GRAY);
        btnDILE.setBackground(Color.GRAY);
        
        Tela.add(lblTitulo1);
        Tela.add(lblTitulo2);
        Tela.add(lblNomes);
        Tela.add(btnDALE);
        Tela.add(btnDELE);
        Tela.add(btnDILE);
        
        JDesktopPane desk = new JDesktopPane(){
          Image im = (new ImageIcon("fundo.jpg")).getImage(); 
          public void paintComponent(Graphics g){        
           g.drawImage(im,0,0,this);            }
                                      };
        Tela.add(desk);
        JLabel status = new JLabel();
            status.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            status.setBounds(1, 1, 1024,768);
            status.setIcon(new ImageIcon("fundo.jpg"));
            Tela.add(status);
        
        setVisible(true);
        setSize(1024,768);
        setLocationRelativeTo(null);
    }
    
    
    public static void main(String[] args) {
        HomeUI app = new HomeUI();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

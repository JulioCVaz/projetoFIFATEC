package fifatec;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrameHome extends JFrame {
    
    JLabel lblTitulo1        = new JLabel ("FIFA"),
           lblTitulo2        = new JLabel ("tec"),
           lblNomes          = new JLabel ("Desenvolvido por: Bruno Vagliengo, Carlos Henrique, Gabriel do Nascimento, Ítalo Sales e Júlio Vaz - ETEC ZL - PC II 3ºA");
    
    JButton btnInicio,
            btnCriaTime,
            btnRanking;
    
    ImageIcon iconInicio,
              iconTime,
              iconRanking;


    public FrameHome() throws Exception{
        
        super("HOME FIFAtec");
        Container Tela = getContentPane();
        
        Font fonteFIFA = Font.createFont(Font.TRUETYPE_FONT,new File("EASPORTS15.ttf")).deriveFont(Font.PLAIN, 28);
        
        Tela.setFont(fonteFIFA);
        lblTitulo1  .setFont(new Font("Agency FB", Font.BOLD, 120));
        lblTitulo2  .setFont(new Font("Agency FB", Font.ITALIC, 85));
        lblTitulo1  .setForeground(Color.white);
        lblTitulo2  .setForeground(Color.white);
        lblNomes    .setForeground(Color.white);
       
        
        //Icones botões
        iconInicio  =new ImageIcon("iconeInicio.png");
        btnInicio   =new JButton (iconInicio);
        iconTime    =new ImageIcon("iconeTime.png");
        btnCriaTime =new JButton (iconTime);
        iconRanking =new ImageIcon("iconeRanking.png");
        btnRanking  =new JButton (iconRanking);
        
        lblTitulo1  .setBounds(50,20,350,200);
        lblTitulo2  .setBounds(220,33,350,200);
        lblNomes    .setBounds(300,700,700,20);
        btnInicio   .setBounds(100,280,210,130);
        btnCriaTime .setBounds(412,462,210,130);
        btnRanking  .setBounds(724,280,210,130);
        
        btnInicio   .setBorder(null);
        btnCriaTime .setBorder(null);
        btnRanking  .setBorder(null);
        
        btnInicio   .setBackground(Color.WHITE);
        btnCriaTime .setBackground(Color.WHITE);
        btnRanking  .setBackground(Color.WHITE);
        
        btnInicio   .setOpaque(true);
        btnCriaTime .setOpaque(true);
        btnRanking  .setOpaque(true);
        
        Tela        .add(lblTitulo1);
        Tela        .add(lblTitulo2);
        Tela        .add(lblNomes);
        Tela        .add(btnInicio);
        Tela        .add(btnCriaTime);
        Tela        .add(btnRanking);
        
        JDesktopPane desk = new JDesktopPane(){
        Image im = (new ImageIcon("bg.gif")).getImage(); 
        @Override
        public void paintComponent(Graphics g){        
        g.drawImage(im,0,0,this);            }
                                      };
        
        
        btnRanking.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
            TelaRanking app = new TelaRanking();
            app.setVisible(true);
            app.show();
        }});
        
        btnInicio.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
             FrameJogo game;
            try {
                game = new FrameJogo();
                game.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(FrameHome.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             
        }});
        
        Tela.add(desk);
        JLabel status = new JLabel();
        status.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        status.setBounds(1, 1, 1024,768);
        status.setIcon(new ImageIcon("bg.gif"));
        Tela.add(status);
        
        setVisible(true);
        setSize(1024,768);
        setLocationRelativeTo(null);    
    }
    
    
    public static void main(String[] args) throws Exception {
        FrameJogo app = new FrameJogo();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

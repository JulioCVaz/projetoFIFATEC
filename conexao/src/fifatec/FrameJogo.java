package fifatec;

import conexao.Conexao;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.management.Query.times;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class FrameJogo extends JFrame implements ActionListener {
    
    int localChute=0;
    
    JLabel lblTitulo1        = new JLabel ("FIFA"),
           lblTitulo2        = new JLabel ("tec"),
           lblNomes          = new JLabel ("Desenvolvido por: Bruno Vagliengo, Carlos Henrique, Gabriel do Nascimento, Ítalo Sales e Júlio Vaz - ETEC ZL - PC II 3ºA"),
           lblResult         = new JLabel ("");
    
    JButton btnChute1,
            btnChute2,
            btnChute3,
            btnChute4,
            btnChute5;
    
    ImageIcon iconAlvo1,
              iconAlvo2,
              iconAlvo3,
              iconAlvo4,
              iconAlvo5;
    
    private boolean chute;
    
    ArrayList<Integer> defesas = new ArrayList<>();
    ArrayList<Integer> gols = new ArrayList<>();
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnChute1)
            {
                localChute=1;
            }
        }
    
    
    public String compara(){
        if(defesas.size() > 2 || gols.size() > 2){
            if(defesas.size() > gols.size()){
                return "Goleiro venceu";
            }else{
                return "Batedor Venceu";
            }
        }
        return "Jogando";
    }
    
    public void GoleiroVenceu(){
       JOptionPane.showMessageDialog(null, "Goleiro venceu");
        
       System.exit(1);
    }
    
    public void BatedorVenceu(){
        JOptionPane.showMessageDialog(null, "Batedor venceu");
        
        System.exit(1);
    } 
    
    public void defendeu(int num){
        switch(compara()){
            case "Jogando" : System.out.println("estao jogando");
            break;
            case "Goleiro venceu" : GoleiroVenceu();
            break;
            case "Batedor Venceu" : BatedorVenceu();
            default:
                System.out.println("");
        }
        defesas.add(num);
        

        
    }
    
    public void gol(int num){
        switch(compara()){
            case "Jogando" : System.out.println("estao jogando");
            break;
            case "Goleiro venceu" : GoleiroVenceu();
            break;
            case "Batedor Venceu" : BatedorVenceu();
            default:
                System.out.println("");
        }
        gols.add(num);
        
    }
    /**
     *
     */
   public String contarResultado(ArrayList<Integer> chutes){      
       String result = "Vez do goleiro";
       int num = 1;
       if(chutes.size() > 1){
           if(chutes.get(0) == chutes.get(1)){
               defendeu(num);
               return "Defendeu";
           }else{
               gol(num);
               return "Gol";
           }
       }
       return result;
   }

    public FrameJogo() throws Exception{
        // super classe
        super("HOME FIFAtec");
        
        ArrayList<String> chutesA = new ArrayList<>(); // array time A
        ArrayList<String> chutesB = new ArrayList<>(); // array time B
        ArrayList<Integer> chutes = new ArrayList<>();
        // conexao com o db
        Conexao conn = new Conexao();
        Connection conexao = conn.connect();
        String query = "SELECT nome_time, torcedorID FROM time LIMIT 2";
        
        try(Statement st = conexao.createStatement()){
               ResultSet result = st.executeQuery(query);
               ArrayList<String> times = new ArrayList<>();
               ArrayList<Integer> torcedores = new ArrayList<>();
               while(result.next()){
                  String santos = result.getString("nome_time");
                  times.add(santos);
                  int torc = result.getInt("torcedorID");
                  torcedores.add(torc);
               }
               JOptionPane.showMessageDialog(null, "Jogo iniciado " + times.get(0) + " x " + times.get(1));
        }catch(Exception e){
            System.out.println("erro: " + e);
        }
        // telas
        Container Tela = getContentPane();       
        Font fonteFIFA = Font.createFont(Font.TRUETYPE_FONT,new File("EASPORTS15.ttf")).deriveFont(Font.PLAIN, 23);
        
        Tela.setFont(fonteFIFA);
        lblTitulo1  .setFont(new Font("Agency FB", Font.BOLD, 100));
        lblTitulo2  .setFont(new Font("Agency FB", Font.ITALIC, 65));
        lblTitulo1  .setForeground(Color.BLACK);
        lblTitulo2  .setForeground(Color.BLACK);
        lblNomes    .setForeground(Color.BLACK);
       
        
        //Icones botões
        iconAlvo1    =new ImageIcon("iconeAlvo1.png");
        iconAlvo2    =new ImageIcon("iconeAlvo2.png");
        iconAlvo3    =new ImageIcon("iconeAlvo3.png");
        iconAlvo4    =new ImageIcon("iconeAlvo4.png");
        iconAlvo5    =new ImageIcon("iconeAlvo5.png");
        btnChute1    =new JButton (iconAlvo1);
        btnChute2    =new JButton (iconAlvo2);
        btnChute3    =new JButton (iconAlvo3);
        btnChute4    =new JButton (iconAlvo4);
        btnChute5    =new JButton (iconAlvo5);
        
        lblTitulo1  .setBounds(50,0,170,200);
        lblTitulo2  .setBounds(190,13,80,200);
        lblNomes    .setBounds(100,530,700,20);
        btnChute1   .setBounds(55,170,96,96);
        btnChute2   .setBounds(55,400,96,96);
        btnChute3   .setBounds(650,170,96,96);
        btnChute4   .setBounds(650,400,96,96);
        btnChute5   .setBounds(345,270,96,96);
        
        btnChute1   .setBorderPainted(false);
        btnChute1   .setContentAreaFilled(false);
        btnChute1   .setFocusPainted(false);
        btnChute2   .setBorderPainted(false);
        btnChute2   .setContentAreaFilled(false);
        btnChute2   .setFocusPainted(false);
        btnChute3   .setBorderPainted(false);
        btnChute3   .setContentAreaFilled(false);
        btnChute3   .setFocusPainted(false);
        btnChute4   .setBorderPainted(false);
        btnChute4   .setContentAreaFilled(false);
        btnChute4   .setFocusPainted(false);
        btnChute5   .setBorderPainted(false);
        btnChute5   .setContentAreaFilled(false);
        btnChute5   .setFocusPainted(false);

        btnChute1.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
           int escolha;
            Object[] botoes={"Sim","Não"};
            escolha=JOptionPane.showOptionDialog
                    (null,"Confirmar Seleção ?",
                    "Confirmar",JOptionPane.
                    YES_NO_OPTION,JOptionPane.
                    QUESTION_MESSAGE,null,botoes,botoes[0]);
            if(escolha==JOptionPane.YES_OPTION){
                if(chutes.size() > 1){
                    chutes.clear();
                    chutes.add(1);
                }else{
                    chutes.add(1);
                }
            }else{
                //
            }
            JOptionPane.showMessageDialog(null,contarResultado(chutes));
        }});

        btnChute2.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int escolha;
            Object[] botoes={"Sim","Não"};
            escolha=JOptionPane.showOptionDialog
                    (null,"Confirmar Seleção ?",
                    "Confirmar",JOptionPane.
                    YES_NO_OPTION,JOptionPane.
                    QUESTION_MESSAGE,null,botoes,botoes[0]);
            if(escolha==JOptionPane.YES_OPTION){
                if(chutes.size() > 1){
                    chutes.clear();
                    chutes.add(2);
                }else{
                    chutes.add(2);
                }
            }else{
                //
            }
            JOptionPane.showMessageDialog(null,contarResultado(chutes));
        }});
        btnChute3.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int escolha;
            Object[] botoes={"Sim","Não"};
            escolha=JOptionPane.showOptionDialog
                    (null,"Confirmar Seleção ?",
                    "Confirmar",JOptionPane.
                    YES_NO_OPTION,JOptionPane.
                    QUESTION_MESSAGE,null,botoes,botoes[0]);
            if(escolha==JOptionPane.YES_OPTION){
                if(chutes.size() > 1){
                    chutes.clear();
                    chutes.add(3);
                }else{
                    chutes.add(3);
                }
            }else{
                //
            }
            JOptionPane.showMessageDialog(null,contarResultado(chutes));
        }});
        btnChute4.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int escolha;
            Object[] botoes={"Sim","Não"};
            escolha=JOptionPane.showOptionDialog
                    (null,"Confirmar Seleção ?",
                    "Confirmar",JOptionPane.
                    YES_NO_OPTION,JOptionPane.
                    QUESTION_MESSAGE,null,botoes,botoes[0]);
            if(escolha==JOptionPane.YES_OPTION){
                if(chutes.size() > 1){
                    chutes.clear();
                    chutes.add(4);
                }else{
                    chutes.add(4);
                }
            }else{
                //
            }
            JOptionPane.showMessageDialog(null,contarResultado(chutes));
        }});
        btnChute5.addActionListener(
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int escolha;
            Object[] botoes={"Sim","Não"};
            escolha=JOptionPane.showOptionDialog
                    (null,"Confirmar Seleção ?",
                    "Confirmar",JOptionPane.
                    YES_NO_OPTION,JOptionPane.
                    QUESTION_MESSAGE,null,botoes,botoes[0]);
            if(escolha==JOptionPane.YES_OPTION){
                if(chutes.size() > 1){
                    chutes.clear();
                    chutes.add(5);
                }else{
                    chutes.add(5);
                }
            }else{
                //
            }
            JOptionPane.showMessageDialog(null,contarResultado(chutes));
        }});
                
        Tela        .add(lblTitulo1);
        Tela        .add(lblTitulo2);
        Tela        .add(lblNomes);
        Tela        .add(btnChute1);
        Tela        .add(btnChute2);
        Tela        .add(btnChute3);
        Tela        .add(btnChute4);
        Tela        .add(btnChute5);
        
        JDesktopPane desk = new JDesktopPane(){
        Image im = (new ImageIcon("goleiro.gif")).getImage(); 
        @Override
        public void paintComponent(Graphics g){        
        g.drawImage(im,0,0,this);            }
                                      };
        Tela.add(desk);
        JLabel status = new JLabel();
        status.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        status.setBounds(1, 1, 1024,768);
        status.setIcon(new ImageIcon("goleiro.gif"));
        Tela.add(status);
        
        setVisible(true);
        setSize(800,600);
        setLocationRelativeTo(null);    
        
        
        
    }
    
    
    public static void main(String[] args) throws Exception {
        FrameHome app = new FrameHome();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

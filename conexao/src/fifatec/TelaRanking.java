package fifatec;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaRanking extends JFrame {
    
    JLabel lblTitulo1        = new JLabel ("Ranking:");
    JTextField txbPesquisar     = new JTextField(50);
    JButton btnPesquisar         = new JButton("Pesquisar"),
            btnFechar  = new JButton("Fechar");
    JPanel Painel1,
            Painel2;
    
//_________Instanciando tabela__________________________________________________________________________________________________________
    JTable TabelaRanking;
    String[] coluna = {"Posição","Time","Pontos"};
    String[][] data = new String[][]{
    {"1º","Santos","43"}

};
 
   


    public TelaRanking(){
 
        super("HOME FIFAtec");
        Container Tela = getContentPane();
        setLayout(null);
        //Tela.setBackground(Color.LIGHT_GRAY);     
        
//CONFIGURANDO TITULO E CAIXA DE TEXTO___________________________________________________________________
        lblTitulo1.setFont(new Font("EA Font v1.5 by Ghettoshark", Font.BOLD, 60));
        lblTitulo1.setForeground(Color.white);
        lblTitulo1.setBounds(0,07,300,70);
        txbPesquisar.setBounds(20,450,400,30);
        
      
//CONFIGURANDO O PAINEL1_________________________________________________________________________________
        Painel1 = new JPanel ();
        Painel1.setBackground(new Color(0,0,0,150));
        Painel1.setOpaque(true);
        Painel1.setBounds(0,0,550,550);

        Painel1.add(btnFechar);
        Painel1.add(btnPesquisar);
       
//_________________________________________________________________________________________________________    
//CONFIGURANDO PAINEL 2____________________________________________________________________________________
        Painel2 = new JPanel ();//    azul,Verde,Vermelho
        Painel2.setBackground(new Color(0,   0,     0,180));
        Painel2.setOpaque(true);
        Painel2.setBounds(0,0,850,100);
//_________________________________________________________________________________________________________
//INSTANCIANDO A TABELA____________________________________________________________________________________

        TabelaRanking = new JTable(data,coluna);
        JScrollPane jps = new JScrollPane(TabelaRanking);
        TabelaRanking.setForeground(Color.white);
        TabelaRanking.setBackground(Color.darkGray);
        jps.setBounds(20,150, 500, 250);
        Tela.add(jps);
//_________________________________________________________________________________________________________
//*/ //BOTÃO FECHAR____________________________________________________________________________________________
        btnFechar.setBounds(440,20,80,25);
        btnFechar.setBorder(null); 
        btnFechar.setBackground(Color.red);
        btnFechar.setForeground(Color.white);
        btnFechar.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int escolha;
                Object[] botoes={"sim","não"};
                escolha=JOptionPane.showOptionDialog
                        (null,"Deseja fechar este aplicativo?",
                        "Fechar o aplicativo",JOptionPane.
                        YES_NO_OPTION,JOptionPane.
                        QUESTION_MESSAGE,null,botoes,botoes[0]);
                if(escolha==JOptionPane.YES_OPTION)
                dispose();
        }});                           
//_____________________________________________________________________________________________________________
//BOTÃO PESQUISAR______________________________________________________________________________________________
        btnPesquisar.setBounds(430,450,100,30);
        btnPesquisar.setBorder(null); 
        btnPesquisar.setBackground(Color.DARK_GRAY);
        btnPesquisar.setForeground(Color.white);
//_____________________________________________________________________________________________________________
        
        Tela.add(lblTitulo1);
        Tela.add(btnFechar);
        Tela.add(Painel1);
        Tela.add(txbPesquisar);
        Tela.add(btnPesquisar);
        Tela.add(Painel2);


        
        setUndecorated(true);
     setBackground(new Color(0f, 0f, 0f, 0f));
    setSize(550,550);
    setVisible(true);
    setLocationRelativeTo(null);
    }
    

    
}
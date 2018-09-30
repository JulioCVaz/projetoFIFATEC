/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fifatecdb {
    
    // RETORNAR O TIME 
    
    /*
    SELECT p.nome_pessoa, c.num_camiseta, ti.nome_time, func.descricao 
    FROM Pessoa
    INNER JOIN 
    entidadejogo ON p.id_pessoa = en.pessoaID
    INNER JOIN
    camiseta ON en.camisetaID = c.id_camiseta
    INNER JOIN
    time ON en.timeID = ti.id_time
    INNER JOIN
    funcoes ON en.funcaoID = func.idfuncao;
    
    */
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        try{
        String myDriver = "org.gjt.mm.mysql.Driver";
        String myUrl = "jdbc:mysql://localhost/fifatec";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
        
        String query = "SELECT * FROM time LIMIT 1";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        
        while (rs.next())
        {

            String id = rs.getString("id_time");
            String time = rs.getString("nome_time");
            int torcedor = rs.getInt("torcedorID");

            System.out.format("%s, %s, %s, %s, %s, %s\n", id, time, torcedor);

        }
        
         st.close();
          
        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
             
}

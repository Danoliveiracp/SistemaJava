/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author DannieL
 */
public class conectabanco {

    public Statement stm;
    public ResultSet rs;
    private String caminho = "jdbc:mysql://localhost:3306/sistemavendas";
    private String driver = "com.mysql.jdbc.Driver";
    private String usuario = "root";
    private String senha = "123";
    public Connection conn;

    public void conexao() {

        System.setProperty("jdbc:Drivers", driver);
        try {
            conn = DriverManager.getConnection(caminho, usuario, senha);

            //JOptionPane.showMessageDialog(null,"Conectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão! \n" + ex.getMessage());
        }

    }

    public void executasql(String sql) {

        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           /// JOptionPane.showMessageDialog(null,"Erro no ExecutaSql! \n" + ex.getMessage());

        }

    }

    public void desconecta() {
        try {
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar! \n" + e.getMessage());
        }

    }
}

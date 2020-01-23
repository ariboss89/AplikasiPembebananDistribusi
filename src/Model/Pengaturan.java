package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Controller.Koneksi;

/**
 *
 * @author User
 */
public class Pengaturan {

    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    
    public void Update(String password, String konfirmasi, String username) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update admin set password='" + password + "', konfirmasi='" + konfirmasi + "' where username = '" + username + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Update");
        } catch (SQLException e) {

        }
    }
    
    public void CekPassw(String username, String password) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from admin where username = '" + username + "' AND password = '" + password + "'");
            if (res.next()) {
            }
            else{
                JOptionPane.showMessageDialog(null, "Password Salah !!!");
            }
        } catch (SQLException e) {
            
        }
    }
}

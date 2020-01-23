/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Login {
    private static String username;
    private static String level;
    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Login.username = username;
    }

    public static String getLevel() {
        return level;
    }

    public static void setLevel(String level) {
        Login.level = level;
    }
    
    public void Login(String username, String password, String level) {
        con = new Koneksi();
        con.connect();
        try {
            //FormLogin login = new FormLogin();
            st = con.connect().createStatement();
            res = st.executeQuery("select *from admin where username ='" + username + "' And password = '" + password + "' And level = '"+ level+"'");
            if (res.next()) {
                setLevel(res.getString("level"));
                JOptionPane.showMessageDialog(null, "Hai " + username);                
                new View.ViewUtama().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Failed to Login");
            }
        } catch (SQLException e) {
            
        }
    }
    
    public void SuperLogin(String username, String password) {
        con = new Koneksi();
        con.connect();
        try {
            //FormLogin login = new FormLogin();
            st = con.connect().createStatement();
            res = st.executeQuery("select *from admin where username = '"+"superadmin"+"' And password = '" + password + "'");
            if (res.next()) {
                setLevel("superadmin");
                JOptionPane.showMessageDialog(null, "Hai " + getLevel());                
                new View.ViewUtama().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Failed to Login");
            }
        } catch (SQLException e) {
            
        }
    }
}

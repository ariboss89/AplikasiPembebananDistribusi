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
public class Registrasi {

    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    
    public void Save(String username, String nama, String level, String password, String konfirmasi) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into admin(username, nama, level, password, konfirmasi)values('" + username + "','" + nama + "','" + level + "','" + password + "','" + konfirmasi +"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Tambahkan");
            //new FormLogin().show();
        } catch (SQLException e) {
        }
    }
    
    public void CekUsername(String username){
        con = new Koneksi();
        con.connect();        
        try{
            Statement st = con.conn.createStatement();
            res = st.executeQuery("select *from admin where username = '"+username+"' "); 
            while(res.next()){
                JOptionPane.showMessageDialog(null, "Username Already Exist !!");
            }
            
        }catch(SQLException ex){
            
        }
    }
    
    public void AddJurusan(String nama) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into jurusan(nama)values('" + nama + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Tambahkan");
            //new FormLogin().show();
        } catch (SQLException e) {
        }
    }
    
    public void AddUnit(String nama) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into unit(nama)values('" + nama + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Tambahkan");
            //new FormLogin().show();
        } catch (SQLException e) {
        }
    }

}

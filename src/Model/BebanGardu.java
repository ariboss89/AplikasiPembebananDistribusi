/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.Koneksi;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BebanGardu {
    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    private String namarute;
    private static String Id;

    public static String getId() {
        return Id;
    }

    public static void setId(String Id) {
        BebanGardu.Id = Id;
    }

    public String getNamarute() {
        return namarute;
    }

    public void setNamarute(String namarute) {
        this.namarute = namarute;
    }
    
    public void Delete(String nomorgardu) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from bebangardu where nomorgardu = '" + nomorgardu + "'";
            //st.executeQuery("insert into penjualan(nama,kategori)values('"+nama+"','"+kategori+"')");
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowData(String unit) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM bebangardu";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from bebangardu where unit = '"+unit+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][22];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nogardu");
                data[r][2] = res.getString("rute");
                data[r][3] = res.getString("tanggal");
                data[r][4] = res.getString("jam");
                data[r][5] = res.getString("menit");
                data[r][6] = res.getString("r");
                data[r][7] = res.getString("s");
                data[r][8] = res.getString("t");
                data[r][9] = res.getString("ratarata");
                data[r][10] = res.getString("n");
                data[r][11] = res.getString("bebankva");
                data[r][12] = res.getString("bebanpersen");
                data[r][13] = res.getString("rs");
                data[r][14] = res.getString("rt");
                data[r][15] = res.getString("st");
                data[r][16] = res.getString("rn");
                data[r][17] = res.getString("sn");
                data[r][18] = res.getString("tn");
                data[r][19] = res.getString("unbalance");
                data[r][20] = res.getString("ket");
                data[r][21] = res.getString("unit");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][22];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 22; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }

    public String[][] SearchData(String nomorgardu) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM bebangardu;";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from bebangardu where nomorgardu like '%"+ nomorgardu +"%' ";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][18];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("nomorgardu");
                data[r][1] = res.getString("daya");
                data[r][2] = res.getString("inomseca");
                data[r][3] = res.getString("tanggal");
                data[r][4] = res.getString("jam");
                data[r][5] = res.getString("menit");
                data[r][6] = res.getString("r");
                data[r][7] = res.getString("s");
                data[r][8] = res.getString("t");
                data[r][9] = res.getString("ratarata");
                data[r][10] = res.getString("n");
                data[r][11] = res.getString("bebankva");
                data[r][12] = res.getString("bebanpersen");
                data[r][13] = res.getString("phasa");
                data[r][14] = res.getString("phasanetral");
                data[r][15] = res.getString("phsn");
                data[r][16] = res.getString("unbalance");
                data[r][17] = res.getString("ket");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][18];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 18; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}

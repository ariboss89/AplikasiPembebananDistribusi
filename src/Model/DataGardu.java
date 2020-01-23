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
public class DataGardu {
    
    private Koneksi con;
    private Statement st;
    private String query;
    private ResultSet res;
    private Double Inomseca;

    public Double getInomseca() {
        return Inomseca;
    }

    public void setInomseca(Double Inomseca) {
        this.Inomseca = Inomseca;
    }

    public void Save(String namaunit, String nomorgardu, String merk, String nomorseri, Double daya, Double inomseca, int primer, int sekunder, int jumlahrute, Date tanggal, String alamat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into datagardu(namaunit, nomorgardu, merk, nomorseri, daya, inomseca, primer, sekunder, jumlahrute, tanggal, alamat)values"
                    + "('" + namaunit + "','" + nomorgardu + "','" + merk + "','" + nomorseri + "','" + daya + "','" + inomseca + "','" + primer + "','" + sekunder + "'"
                    + ",'" + jumlahrute + "','" + tanggal + "','" + alamat + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Simpan");
        } catch (SQLException e) {
        }
    }

    public void Update(String namaunit, String nomorgardu, String merk, String nomorseri, Double daya, Double inomseca, int primer, int sekunder, int jumlahrute, Date tanggal, String alamat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update datagardu set namaunit='" + namaunit + "', merk='" + merk + "', nomorseri='" + nomorseri + "', daya='" + daya + "', inomseca='" + inomseca + "', primer='" + primer + "',"
                    + "sekunder='" + sekunder + "' , jumlahrute='" + jumlahrute + "', tanggal='" + tanggal + "', alamat='" + alamat + "' where nomorgardu = '" + nomorgardu + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Update");
        } catch (SQLException e) {

        }
    }

    public void Delete(String nomorgardu) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from datagardu where nomorgardu = '" + nomorgardu + "'";
            //st.executeQuery("insert into penjualan(nama,kategori)values('"+nama+"','"+kategori+"')");
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowData() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM datagardu;";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from datagardu order by Id asc";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][10];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("namaunit");
                data[r][1] = res.getString("nomorgardu");
                data[r][2] = res.getString("merk");
                data[r][3] = res.getString("nomorseri");
                data[r][4] = res.getString("daya");
                data[r][5] = res.getString("primer");
                data[r][6] = res.getString("sekunder");
                data[r][7] = res.getString("jumlahrute");
                data[r][8] = res.getString("tanggal");
                data[r][9] = res.getString("alamat");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][10];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 10; c++) {
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
            query = "SELECT COUNT(Id) AS Jumlah FROM datagardu;";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from datagardu where nomorgardu like '%"+nomorgardu+"%'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][10];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("namaunit");
                data[r][1] = res.getString("nomorgardu");
                data[r][2] = res.getString("merk");
                data[r][3] = res.getString("nomorseri");
                data[r][4] = res.getString("daya");
                data[r][5] = res.getString("primer");
                data[r][6] = res.getString("sekunder");
                data[r][7] = res.getString("jumlahrute");
                data[r][8] = res.getString("tanggal");
                data[r][9] = res.getString("alamat");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][10];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 10; c++) {
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

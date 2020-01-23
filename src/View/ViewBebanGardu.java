/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Koneksi;
import Model.BebanGardu;
import Model.Login;
import Model.PerhitunganBebanGardu;
import Model.Table;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ViewBebanGardu extends javax.swing.JFrame {

    /**
     * Creates new form ViewBebanGardu
     */
    BebanGardu bg = new BebanGardu();
    private int jumlahrute;
    private Double rute;
    PerhitunganBebanGardu htg = new PerhitunganBebanGardu();
    Table tbl = new Table();
    private String [][] rss;

    private String nogardu;
    private String namarute;
    private Date tanggal;
    private int jam;
    private int menit;
    private int r;
    private int s;
    private int t;
    private Double ratarata;
    private int n;
    private Double bebankva;
    private Double bebanpersen;
    private Double rs;
    private Double rt;
    private Double st;
    private Double rn;
    private Double sn;
    private Double tn;
    private Double unbalance;
    private String ket;
    
//    String[] namaKolom = {"No Gardu","Rute", "Tanggal", "Jam", "Menit", "R", "S", "T", "Rata-Rata", "N", "Beban KVA", "Beban Persen" , "R-S", "R-T", "S-T", "R-N", "S-N", "T-N", "Unbalance", "Ket", "Unit"};
//    int jmlKolom = namaKolom.length;
//    int[] lebar = {400,400, 400, 200, 200, 200, 200, 200, 300, 200, 400, 400, 300, 300, 300, 300, 300, 300, 400, 400, 800};
    
    String[] namaKolom = {"ID", "No Gardu","Rute", "Tanggal", "Jam", "Menit", "R" , "S", "T"};
    int jmlKolom = namaKolom.length;
    int[] lebar = {300,400, 400, 200, 200, 200, 200, 200, 300};

    public ViewBebanGardu() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
        ShowNoGardu();
        Disabled();
        Refresh();
    }

    private void Disabled() {
        txtAR.setEnabled(false);
        txtAS.setEnabled(false);
        txtAT.setEnabled(false);
        txtAN.setEnabled(false);
        txtBR.setEnabled(false);
        txtBS.setEnabled(false);
        txtBT.setEnabled(false);
        txtBN.setEnabled(false);
        txtCR.setEnabled(false);
        txtCS.setEnabled(false);
        txtCT.setEnabled(false);
        txtCN.setEnabled(false);
        txtDR.setEnabled(false);
        txtDS.setEnabled(false);
        txtDT.setEnabled(false);
        txtDN.setEnabled(false);
        txtIndukR.setEnabled(false);
        txtIndukS.setEnabled(false);
        txtIndukT.setEnabled(false);
        txtIndukN.setEnabled(false);
    }

    private void Refresh(){
        String unit = "a";
        rss = bg.ShowData(unit);
        tbl.SetTabel(jTable1, rss, namaKolom, jmlKolom, lebar);
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        
        cbNomorGardu.setSelectedIndex(0);
        txtRute.setText("");
        jDateChooser1.setDate(null);
        txtJam.setText("JAM");
        txtMenit.setText("MENIT");
        txtTegangan.setText("");
        
        txtAR.setText("");txtAS.setText("");txtAT.setText("");txtAN.setText("");
        txtBR.setText("");txtBS.setText("");txtBT.setText("");txtBN.setText("");
        txtCR.setText("");txtCS.setText("");txtCT.setText("");txtCN.setText("");
        txtDR.setText("");txtDS.setText("");txtDT.setText("");txtDN.setText("");
        txtIndukR.setText("");txtIndukS.setText("");txtIndukT.setText("");txtIndukN.setText("");
        Disabled();
        
        txtPhasaRS.setText("R-S");txtPhasaRT.setText("R-T");txtPhasaST.setText("S-T");
        txtPhasaNetralRN.setText("R-N");txtPhasaNetralSN.setText("S-N");txtPhasaNetralTN.setText("T-N");
   }
    
    private void ShowNoGardu() {
        java.sql.Connection conn = new Koneksi().connect();
        try {
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet res = st.executeQuery("select *from datagardu");
            while (res.next()) {
                cbNomorGardu.addItem(res.getString("nomorgardu"));
            }

        } catch (SQLException ex) {

        }
    }

    private void AuthJurusan() {
        jumlahrute = Integer.parseInt(txtRute.getText());
        if (jumlahrute == 1) {
            txtAR.setEnabled(true);
            txtAS.setEnabled(true);
            txtAT.setEnabled(true);
            txtAN.setEnabled(true);
            txtBR.setEnabled(false);
            txtBS.setEnabled(false);
            txtBT.setEnabled(false);
            txtBN.setEnabled(false);
            txtCR.setEnabled(false);
            txtCS.setEnabled(false);
            txtCT.setEnabled(false);
            txtCN.setEnabled(false);
            txtDR.setEnabled(false);
            txtDS.setEnabled(false);
            txtDT.setEnabled(false);
            txtDN.setEnabled(false);
            txtIndukR.setEnabled(false);
            txtIndukS.setEnabled(false);
            txtIndukT.setEnabled(false);
            txtIndukN.setEnabled(false);

        } else if (jumlahrute == 2) {
            txtAR.setEnabled(true);
            txtAS.setEnabled(true);
            txtAT.setEnabled(true);
            txtAN.setEnabled(true);
            txtBR.setEnabled(true);
            txtBS.setEnabled(true);
            txtBT.setEnabled(true);
            txtBN.setEnabled(true);
            txtCR.setEnabled(false);
            txtCS.setEnabled(false);
            txtCT.setEnabled(false);
            txtCN.setEnabled(false);
            txtDR.setEnabled(false);
            txtDS.setEnabled(false);
            txtDT.setEnabled(false);
            txtDN.setEnabled(false);
            txtIndukR.setEnabled(false);
            txtIndukS.setEnabled(false);
            txtIndukT.setEnabled(false);
            txtIndukN.setEnabled(false);

        } else if (jumlahrute == 3) {
            txtAR.setEnabled(true);
            txtAS.setEnabled(true);
            txtAT.setEnabled(true);
            txtAN.setEnabled(true);
            txtBR.setEnabled(true);
            txtBS.setEnabled(true);
            txtBT.setEnabled(true);
            txtBN.setEnabled(true);
            txtCR.setEnabled(true);
            txtCS.setEnabled(true);
            txtCT.setEnabled(true);
            txtCN.setEnabled(true);
            txtDR.setEnabled(false);
            txtDS.setEnabled(false);
            txtDT.setEnabled(false);
            txtDN.setEnabled(false);
            txtIndukR.setEnabled(false);
            txtIndukS.setEnabled(false);
            txtIndukT.setEnabled(false);
            txtIndukN.setEnabled(false);

        } else if (jumlahrute == 4) {
            txtAR.setEnabled(true);
            txtAS.setEnabled(true);
            txtAT.setEnabled(true);
            txtAN.setEnabled(true);
            txtBR.setEnabled(true);
            txtBS.setEnabled(true);
            txtBT.setEnabled(true);
            txtBN.setEnabled(true);
            txtCR.setEnabled(true);
            txtCS.setEnabled(true);
            txtCT.setEnabled(true);
            txtCN.setEnabled(true);
            txtDR.setEnabled(true);
            txtDS.setEnabled(true);
            txtDT.setEnabled(true);
            txtDN.setEnabled(true);
            txtIndukR.setEnabled(false);
            txtIndukS.setEnabled(false);
            txtIndukT.setEnabled(false);
            txtIndukN.setEnabled(false);

        } else if (jumlahrute == 2) {
            txtAR.setEnabled(true);
            txtAS.setEnabled(true);
            txtAT.setEnabled(true);
            txtAN.setEnabled(true);
            txtBR.setEnabled(true);
            txtBS.setEnabled(true);
            txtBT.setEnabled(true);
            txtBN.setEnabled(true);
            txtCR.setEnabled(true);
            txtCS.setEnabled(true);
            txtCT.setEnabled(true);
            txtCN.setEnabled(true);
            txtDR.setEnabled(true);
            txtDS.setEnabled(true);
            txtDT.setEnabled(true);
            txtDN.setEnabled(true);
            txtIndukR.setEnabled(true);
            txtIndukS.setEnabled(true);
            txtIndukT.setEnabled(true);
            txtIndukN.setEnabled(true);

        }

    }

    private void RataRata1() {
        Double ar = Double.parseDouble(txtAR.getText());
        Double as = Double.parseDouble(txtAS.getText());
        Double at = Double.parseDouble(txtAT.getText());
        Double an = Double.parseDouble(txtAN.getText());
        Double total = ar + as + at;
        htg.setTotal1(total);
        Double ratarata = ((ar + as + at) / 3);
        htg.setRatarata1(ratarata);
    }

    private void RataRata2() {
        Double br = Double.parseDouble(txtBR.getText());
        Double bs = Double.parseDouble(txtBS.getText());
        Double bt = Double.parseDouble(txtBT.getText());
        Double bn = Double.parseDouble(txtBN.getText());
        Double total = br + bs + bt;
        htg.setTotal2(total);
        Double ratarata = ((br + bs + bt) / 3);
        htg.setRatarata2(ratarata);
    }

    private void RataRata3() {
        Double cr = Double.parseDouble(txtCR.getText());
        Double cs = Double.parseDouble(txtCS.getText());
        Double ct = Double.parseDouble(txtCT.getText());
        Double cn = Double.parseDouble(txtCN.getText());
        Double total = cr + cs + ct;
        htg.setTotal3(total);
        Double ratarata = ((cr + cs + ct) / 3);
        htg.setRatarata3(ratarata);
    }

    private void RataRata4() {
        Double dr = Double.parseDouble(txtDR.getText());
        Double ds = Double.parseDouble(txtDS.getText());
        Double dt = Double.parseDouble(txtDT.getText());
        Double dn = Double.parseDouble(txtDN.getText());
        Double total = dr + ds + dt;
        htg.setTotal4(total);
        Double ratarata = ((dr + ds + dt) / 3);
        htg.setRatarata4(ratarata);
    }

    private void RataRata5() {
        Double indukr = Double.parseDouble(txtIndukR.getText());
        Double induks = Double.parseDouble(txtIndukS.getText());
        Double indukt = Double.parseDouble(txtIndukT.getText());
        Double indukn = Double.parseDouble(txtIndukN.getText());
        Double total = indukr + induks + indukt;
        htg.setTotal5(total);
        Double ratarata = ((indukr + induks + indukt) / 3);
        htg.setRatarata5(ratarata);
    }

    private void MinMax1() {
        Double r = Double.parseDouble(txtAR.getText());
        Double s = Double.parseDouble(txtAS.getText());
        Double t = Double.parseDouble(txtAT.getText());

        if (r <= s && r <= t) {
            htg.setMin1(r);
        }
        if (s <= r && s <= t) {
            htg.setMin1(s);
        }
        if (t <= r && t <= s) {
            htg.setMin1(t);
        }
        if (r >= s && r >= t) {
            htg.setMax1(r);
        }
        if (s >= r && s >= t) {
            htg.setMax1(s);
        }
        if (t >= r && t >= s) {
            htg.setMax1(t);
        }
    }

    private void MinMax2() {
        Double r = Double.parseDouble(txtBR.getText());
        Double s = Double.parseDouble(txtBS.getText());
        Double t = Double.parseDouble(txtBT.getText());

        if (r < s && r < t) {
            htg.setMin2(r);
        }
        if (s < r && s < t) {
            htg.setMin2(s);
        }
        if (t < r && t < s) {
            htg.setMin2(t);
        }
        if (r > s && r > t) {
            htg.setMax2(r);
        }
        if (s > r && s > t) {
            htg.setMax2(s);
        }
        if (t > r && t > s) {
            htg.setMax2(t);
        }
    }

    private void MinMax3() {
        Double r = Double.parseDouble(txtCR.getText());
        Double s = Double.parseDouble(txtCS.getText());
        Double t = Double.parseDouble(txtCT.getText());

        if (r < s && r < t) {
            htg.setMin3(r);
        }
        if (s < r && s < t) {
            htg.setMin3(s);
        }
        if (t < r && t < s) {
            htg.setMin3(t);
        }
        if (r > s && r > t) {
            htg.setMax3(r);
        }
        if (s > r && s > t) {
            htg.setMax3(s);
        }
        if (t > r && t > s) {
            htg.setMax3(t);
        }
    }

    private void MinMax4() {
        Double r = Double.parseDouble(txtDR.getText());
        Double s = Double.parseDouble(txtDS.getText());
        Double t = Double.parseDouble(txtDT.getText());

        if (r < s && r < t) {
            htg.setMin4(r);
        }
        if (s < r && s < t) {
            htg.setMin4(s);
        }
        if (t < r && t < s) {
            htg.setMin4(t);
        }
        if (r > s && r > t) {
            htg.setMax4(r);
        }
        if (s > r && s > t) {
            htg.setMax4(s);
        }
        if (t > r && t > s) {
            htg.setMax4(t);
        }
    }

    private void MinMax5() {
        Double r = Double.parseDouble(txtIndukR.getText());
        Double s = Double.parseDouble(txtIndukS.getText());
        Double t = Double.parseDouble(txtIndukT.getText());

        if (r < s && r < t) {
            htg.setMin5(r);
        }
        if (s < r && s < t) {
            htg.setMin5(s);
        }
        if (t < r && t < s) {
            htg.setMin5(t);
        }
        if (r > s && r > t) {
            htg.setMax5(r);
        }
        if (s > r && s > t) {
            htg.setMax5(s);
        }
        if (t > r && t > s) {
            htg.setMax5(t);
        }
    }

    private void MinMaxPhasa() {
        Double r = Double.parseDouble(txtPhasaRS.getText());
        Double s = Double.parseDouble(txtPhasaRT.getText());
        Double t = Double.parseDouble(txtPhasaST.getText());

        if (r <= s && r <= t) {
            htg.setMinPhasa(r);
        }
        if (s <= r && s <= t) {
            htg.setMinPhasa(s);
        }
        if (t <= r && t <= s) {
            htg.setMinPhasa(t);
        }
        if (r >= s && r >= t) {
            htg.setMaxPhasa(r);
        }
        if (s >= r && s >= t) {
            htg.setMaxPhasa(s);
        }
        if (t >= r && t >= s) {
            htg.setMaxPhasa(t);
        }
    }

    private void BebanKva1() {
        MinMaxPhasa();
        Double a = htg.getMaxPhasa() / 1000;
        Double b = 1.73 * a;
        Double bebankva = b * htg.getRatarata1();
        String convertBeban = String.format("%.2f", bebankva);
        htg.setBebanKVA1(Double.valueOf(convertBeban));

        //bebanpersen
        Double bebanPersen = ((htg.getBebanKVA1() / htg.getDaya()) * 100);
        String convertPersen = String.format("%.2f", bebanPersen);
        htg.setBebanPersen1(Double.valueOf(convertPersen));
    }

    private void BebanKva2() {
        MinMaxPhasa();
        Double a = htg.getMaxPhasa() / 1000;
        Double b = 1.73 * a;
        Double bebankva = b * htg.getRatarata2();
        String convertBeban = String.format("%.2f", bebankva);
        htg.setBebanKVA2(Double.valueOf(convertBeban));

        //bebanpersen
        Double bebanPersen = ((htg.getBebanKVA2() / htg.getDaya()) * 100);
        String convertPersen = String.format("%.2f", bebanPersen);
        htg.setBebanPersen2(Double.valueOf(convertPersen));
    }

    private void BebanKva3() {
        MinMaxPhasa();
        Double a = htg.getMaxPhasa() / 1000;
        Double b = 1.73 * a;
        Double bebankva = b * htg.getRatarata3();
        String convertBeban = String.format("%.2f", bebankva);
        htg.setBebanKVA3(Double.valueOf(convertBeban));

        //bebanpersen
        Double bebanPersen = ((htg.getBebanKVA3() / htg.getDaya()) * 100);
        String convertPersen = String.format("%.2f", bebanPersen);
        htg.setBebanPersen3(Double.valueOf(convertPersen));
    }

    private void BebanKva4() {
        MinMaxPhasa();
        Double a = htg.getMaxPhasa() / 1000;
        Double b = 1.73 * a;
        Double bebankva = b * htg.getRatarata4();
        String convertBeban = String.format("%.2f", bebankva);
        htg.setBebanKVA4(Double.valueOf(convertBeban));

        //bebanpersen
        Double bebanPersen = ((htg.getBebanKVA4() / htg.getDaya()) * 100);
        String convertPersen = String.format("%.2f", bebanPersen);
        htg.setBebanPersen4(Double.valueOf(convertPersen));
    }

    private void BebanKva5() {
        MinMaxPhasa();
        Double a = htg.getMaxPhasa() / 1000;
        Double b = 1.73 * a;
        Double bebankva = b * htg.getRatarata5();
        String convertBeban = String.format("%.2f", bebankva);
        htg.setBebanKVA5(Double.valueOf(convertBeban));

        //bebanpersen
        Double bebanPersen = ((htg.getBebanKVA5() / htg.getDaya()) * 100);
        String convertPersen = String.format("%.2f", bebanPersen);
        htg.setBebanPersen5(Double.valueOf(convertPersen));
    }

    private void Unbalance1() {
        MinMax1();
        Double unbalance = (((htg.getMax1() - htg.getMin1()) / htg.getMax1()) * 100);
        String convertBalance = String.format("%.2f", unbalance);
        htg.setUnbalance1(Double.valueOf(convertBalance));

        if (htg.getUnbalance1() >= 20) {
            htg.setKet("Perlu Penyeimbangan");
            txtKet.setText(htg.getKet());
        } else {
            htg.setKet("Ok");
            txtKet.setText(htg.getKet());
        }
    }

    private void Unbalance2() {
        MinMax2();
        Double unbalance = (((htg.getMax2() - htg.getMin2()) / htg.getMax2()) * 100);
        String convertBalance = String.format("%.2f", unbalance);
        htg.setUnbalance2(Double.valueOf(convertBalance));

        if (htg.getUnbalance2() >= 20) {
            htg.setKet("Perlu Penyeimbangan");
            txtKet.setText(htg.getKet());
        } else {
            htg.setKet("Ok");
            txtKet.setText(htg.getKet());
        }
    }

    private void Unbalance3() {
        MinMax3();
        Double unbalance = (((htg.getMax3() - htg.getMin3()) / htg.getMax3()) * 100);
        String convertBalance = String.format("%.2f", unbalance);
        htg.setUnbalance3(Double.valueOf(convertBalance));

        if (htg.getUnbalance3() >= 20) {
            htg.setKet("Perlu Penyeimbangan");
            txtKet.setText(htg.getKet());
        } else {
            htg.setKet("Ok");
            txtKet.setText(htg.getKet());
        }
    }

    private void Unbalance4() {
        MinMax4();
        Double unbalance = (((htg.getMax4() - htg.getMin4()) / htg.getMax4()) * 100);
        String convertBalance = String.format("%.2f", unbalance);
        htg.setUnbalance4(Double.valueOf(convertBalance));

        if (htg.getUnbalance4() >= 20) {
            htg.setKet("Perlu Penyeimbangan");
            txtKet.setText(htg.getKet());
        } else {
            htg.setKet("Ok");
            txtKet.setText(htg.getKet());
        }
    }

    private void Unbalance5() {
        MinMax5();
        Double unbalance = (((htg.getMax5() - htg.getMin5()) / htg.getMax5()) * 100);
        String convertBalance = String.format("%.2f", unbalance);
        htg.setUnbalance5(Double.valueOf(convertBalance));

        if (htg.getUnbalance5() >= 20) {
            htg.setKet("Perlu Penyeimbangan");
            txtKet.setText(htg.getKet());
        } else {
            htg.setKet("Ok");
            txtKet.setText(htg.getKet());
        }
    }

    private void Save1() {
        nogardu = cbNomorGardu.getSelectedItem().toString();
        namarute = "A";
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = Date.valueOf(spf.format(jDateChooser1.getDate()));
        jam = Integer.parseInt(txtJam.getText().trim());
        menit = Integer.parseInt(txtMenit.getText().trim());
        r = Integer.parseInt(txtAR.getText());
        s = Integer.parseInt(txtAS.getText());
        t = Integer.parseInt(txtAT.getText());
        n = Integer.parseInt(txtAN.getText());
        RataRata1();
        ratarata = htg.getRatarata1();

        rs = Double.parseDouble(txtPhasaRS.getText());
        rt = Double.parseDouble(txtPhasaRT.getText());
        st = Double.parseDouble(txtPhasaST.getText());
        BebanKva1();
        bebankva = htg.getBebanKVA1();
        bebanpersen = htg.getBebanPersen1();

        rn = Double.parseDouble(txtPhasaNetralRN.getText());
        sn = Double.parseDouble(txtPhasaNetralSN.getText());
        tn = Double.parseDouble(txtPhasaNetralTN.getText());

        Unbalance1();
        unbalance = htg.getUnbalance1();
        ket = htg.getKet();
        
        java.sql.Connection conn= new Koneksi().connect();
            try{
                java.sql.PreparedStatement stmt=conn.prepareStatement("insert into bebangardu (nogardu, rute, tanggal, jam, menit, r, s, t, ratarata, n, bebankva, bebanpersen, rs, rt, st, rn, sn, tn, unbalance, ket, unit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                try{
                    stmt.setString(1,nogardu);
                    stmt.setString(2,namarute);
                    stmt.setDate(3,tanggal);
                    stmt.setInt(4,jam);
                    stmt.setInt(5,menit);
                    stmt.setInt(6,r);
                    stmt.setInt(7,s);
                    stmt.setInt(8,t);
                    stmt.setDouble(9,ratarata);
                    stmt.setInt(10,n);
                    stmt.setDouble(11,bebankva);
                    stmt.setDouble(12,bebanpersen);
                    stmt.setDouble(13,rs);
                    stmt.setDouble(14,rt);
                    stmt.setDouble(15,st);
                    stmt.setDouble(16,rn);
                    stmt.setDouble(17,sn);
                    stmt.setDouble(18,tn);
                    stmt.setDouble(19,unbalance);
                    stmt.setString(20,ket);
                    stmt.setString(21,Login.getLevel());
                    stmt.executeUpdate();
                    
                } catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Data Gagal Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){

            }
    }
    
    private void Save2() {
        nogardu = cbNomorGardu.getSelectedItem().toString();
        namarute = "B";
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = Date.valueOf(spf.format(jDateChooser1.getDate()));
        jam = Integer.parseInt(txtJam.getText().trim());
        menit = Integer.parseInt(txtMenit.getText().trim());
        r = Integer.parseInt(txtBR.getText());
        s = Integer.parseInt(txtBS.getText());
        t = Integer.parseInt(txtBT.getText());
        n = Integer.parseInt(txtBN.getText());
        RataRata2();
        ratarata = htg.getRatarata2();

        rs = Double.parseDouble(txtPhasaRS.getText());
        rt = Double.parseDouble(txtPhasaRT.getText());
        st = Double.parseDouble(txtPhasaST.getText());
        BebanKva2();
        bebankva = htg.getBebanKVA2();
        bebanpersen = htg.getBebanPersen2();

        rn = Double.parseDouble(txtPhasaNetralRN.getText());
        sn = Double.parseDouble(txtPhasaNetralSN.getText());
        tn = Double.parseDouble(txtPhasaNetralTN.getText());

        Unbalance2();
        unbalance = htg.getUnbalance2();
        ket = htg.getKet();
        
        java.sql.Connection conn= new Koneksi().connect();
            try{
                java.sql.PreparedStatement stmt=conn.prepareStatement("insert into bebangardu (nogardu, rute, tanggal, jam, menit, r, s, t, ratarata, n, bebankva, bebanpersen, rs, rt, st, rn, sn, tn, unbalance, ket, unit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                try{
                    stmt.setString(1,nogardu);
                    stmt.setString(2,namarute);
                    stmt.setDate(3,tanggal);
                    stmt.setInt(4,jam);
                    stmt.setInt(5,menit);
                    stmt.setInt(6,r);
                    stmt.setInt(7,s);
                    stmt.setInt(8,t);
                    stmt.setDouble(9,ratarata);
                    stmt.setInt(10,n);
                    stmt.setDouble(11,bebankva);
                    stmt.setDouble(12,bebanpersen);
                    stmt.setDouble(13,rs);
                    stmt.setDouble(14,rt);
                    stmt.setDouble(15,st);
                    stmt.setDouble(16,rn);
                    stmt.setDouble(17,sn);
                    stmt.setDouble(18,tn);
                    stmt.setDouble(19,unbalance);
                    stmt.setString(20,ket);
                    stmt.setString(21,Login.getLevel());
                    stmt.executeUpdate();
                    
                } catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Data Gagal Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){

            }
    }
    
    private void Save3() {
        nogardu = cbNomorGardu.getSelectedItem().toString();
        namarute = "C";
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = Date.valueOf(spf.format(jDateChooser1.getDate()));
        jam = Integer.parseInt(txtJam.getText().trim());
        menit = Integer.parseInt(txtMenit.getText().trim());
        r = Integer.parseInt(txtCR.getText());
        s = Integer.parseInt(txtCS.getText());
        t = Integer.parseInt(txtCT.getText());
        n = Integer.parseInt(txtCN.getText());
        RataRata3();
        ratarata = htg.getRatarata3();

        rs = Double.parseDouble(txtPhasaRS.getText());
        rt = Double.parseDouble(txtPhasaRT.getText());
        st = Double.parseDouble(txtPhasaST.getText());
        BebanKva3();
        bebankva = htg.getBebanKVA3();
        bebanpersen = htg.getBebanPersen3();

        rn = Double.parseDouble(txtPhasaNetralRN.getText());
        sn = Double.parseDouble(txtPhasaNetralSN.getText());
        tn = Double.parseDouble(txtPhasaNetralTN.getText());

        Unbalance3();
        unbalance = htg.getUnbalance3();
        ket = htg.getKet();
        
        java.sql.Connection conn= new Koneksi().connect();
            try{
                java.sql.PreparedStatement stmt=conn.prepareStatement("insert into bebangardu (nogardu, rute, tanggal, jam, menit, r, s, t, ratarata, n, bebankva, bebanpersen, rs, rt, st, rn, sn, tn, unbalance, ket, unit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                try{
                    stmt.setString(1,nogardu);
                    stmt.setString(2,namarute);
                    stmt.setDate(3,tanggal);
                    stmt.setInt(4,jam);
                    stmt.setInt(5,menit);
                    stmt.setInt(6,r);
                    stmt.setInt(7,s);
                    stmt.setInt(8,t);
                    stmt.setDouble(9,ratarata);
                    stmt.setInt(10,n);
                    stmt.setDouble(11,bebankva);
                    stmt.setDouble(12,bebanpersen);
                    stmt.setDouble(13,rs);
                    stmt.setDouble(14,rt);
                    stmt.setDouble(15,st);
                    stmt.setDouble(16,rn);
                    stmt.setDouble(17,sn);
                    stmt.setDouble(18,tn);
                    stmt.setDouble(19,unbalance);
                    stmt.setString(20,ket);
                    stmt.setString(21,Login.getLevel());
                    stmt.executeUpdate();
                  
                } catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Data Gagal Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){

            }
    }
    
    private void Save4() {
        nogardu = cbNomorGardu.getSelectedItem().toString();
        namarute = "D";
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = Date.valueOf(spf.format(jDateChooser1.getDate()));
        jam = Integer.parseInt(txtJam.getText().trim());
        menit = Integer.parseInt(txtMenit.getText().trim());
        r = Integer.parseInt(txtAR.getText());
        s = Integer.parseInt(txtAS.getText());
        t = Integer.parseInt(txtAT.getText());
        n = Integer.parseInt(txtAN.getText());
        RataRata4();
        ratarata = htg.getRatarata4();

        rs = Double.parseDouble(txtPhasaRS.getText());
        rt = Double.parseDouble(txtPhasaRT.getText());
        st = Double.parseDouble(txtPhasaST.getText());
        BebanKva4();
        bebankva = htg.getBebanKVA4();
        bebanpersen = htg.getBebanPersen4();

        rn = Double.parseDouble(txtPhasaNetralRN.getText());
        sn = Double.parseDouble(txtPhasaNetralSN.getText());
        tn = Double.parseDouble(txtPhasaNetralTN.getText());

        Unbalance4();
        unbalance = htg.getUnbalance4();
        ket = htg.getKet();
        
        java.sql.Connection conn= new Koneksi().connect();
            try{
                java.sql.PreparedStatement stmt=conn.prepareStatement("insert into bebangardu (nogardu, rute, tanggal, jam, menit, r, s, t, ratarata, n, bebankva, bebanpersen, rs, rt, st, rn, sn, tn, unbalance, ket, unit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                try{
                    stmt.setString(1,nogardu);
                    stmt.setString(2,namarute);
                    stmt.setDate(3,tanggal);
                    stmt.setInt(4,jam);
                    stmt.setInt(5,menit);
                    stmt.setInt(6,r);
                    stmt.setInt(7,s);
                    stmt.setInt(8,t);
                    stmt.setDouble(9,ratarata);
                    stmt.setInt(10,n);
                    stmt.setDouble(11,bebankva);
                    stmt.setDouble(12,bebanpersen);
                    stmt.setDouble(13,rs);
                    stmt.setDouble(14,rt);
                    stmt.setDouble(15,st);
                    stmt.setDouble(16,rn);
                    stmt.setDouble(17,sn);
                    stmt.setDouble(18,tn);
                    stmt.setDouble(19,unbalance);
                    stmt.setString(20,ket);
                    stmt.setString(21,Login.getLevel());
                    stmt.executeUpdate();
                   
                } catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Data Gagal Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){

            }
    }
    
    private void Save5() {
        nogardu = cbNomorGardu.getSelectedItem().toString();
        namarute = "Induk";
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = Date.valueOf(spf.format(jDateChooser1.getDate()));
        jam = Integer.parseInt(txtJam.getText().trim());
        menit = Integer.parseInt(txtMenit.getText().trim());
        r = Integer.parseInt(txtIndukR.getText());
        s = Integer.parseInt(txtIndukS.getText());
        t = Integer.parseInt(txtIndukT.getText());
        n = Integer.parseInt(txtIndukN.getText());
        RataRata5();
        ratarata = htg.getRatarata5();

        rs = Double.parseDouble(txtPhasaRS.getText());
        rt = Double.parseDouble(txtPhasaRT.getText());
        st = Double.parseDouble(txtPhasaST.getText());
        BebanKva5();
        bebankva = htg.getBebanKVA5();
        bebanpersen = htg.getBebanPersen5();

        rn = Double.parseDouble(txtPhasaNetralRN.getText());
        sn = Double.parseDouble(txtPhasaNetralSN.getText());
        tn = Double.parseDouble(txtPhasaNetralTN.getText());

        Unbalance5();
        unbalance = htg.getUnbalance5();
        ket = htg.getKet();
        
        java.sql.Connection conn= new Koneksi().connect();
            try{
                java.sql.PreparedStatement stmt=conn.prepareStatement("insert into bebangardu (nogardu, rute, tanggal, jam, menit, r, s, t, ratarata, n, bebankva, bebanpersen, rs, rt, st, rn, sn, tn, unbalance, ket, unit) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                try{
                    stmt.setString(1,nogardu);
                    stmt.setString(2,namarute);
                    stmt.setDate(3,tanggal);
                    stmt.setInt(4,jam);
                    stmt.setInt(5,menit);
                    stmt.setInt(6,r);
                    stmt.setInt(7,s);
                    stmt.setInt(8,t);
                    stmt.setDouble(9,ratarata);
                    stmt.setInt(10,n);
                    stmt.setDouble(11,bebankva);
                    stmt.setDouble(12,bebanpersen);
                    stmt.setDouble(13,rs);
                    stmt.setDouble(14,rt);
                    stmt.setDouble(15,st);
                    stmt.setDouble(16,rn);
                    stmt.setDouble(17,sn);
                    stmt.setDouble(18,tn);
                    stmt.setDouble(19,unbalance);
                    stmt.setString(20,ket);
                    stmt.setString(21,Login.getLevel());
                    stmt.executeUpdate();
                  
                } catch(SQLException ex){
                    JOptionPane.showMessageDialog(null,"Data Gagal Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(Exception e){

            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbNomorGardu = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtRute = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtJam = new javax.swing.JTextField();
        txtMenit = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTegangan = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAR = new javax.swing.JTextField();
        txtAS = new javax.swing.JTextField();
        txtAT = new javax.swing.JTextField();
        txtAN = new javax.swing.JTextField();
        txtBR = new javax.swing.JTextField();
        txtBS = new javax.swing.JTextField();
        txtBT = new javax.swing.JTextField();
        txtBN = new javax.swing.JTextField();
        txtCR = new javax.swing.JTextField();
        txtCS = new javax.swing.JTextField();
        txtCT = new javax.swing.JTextField();
        txtCN = new javax.swing.JTextField();
        txtDR = new javax.swing.JTextField();
        txtDS = new javax.swing.JTextField();
        txtDT = new javax.swing.JTextField();
        txtDN = new javax.swing.JTextField();
        txtIndukR = new javax.swing.JTextField();
        txtIndukS = new javax.swing.JTextField();
        txtIndukT = new javax.swing.JTextField();
        txtIndukN = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKet = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtPhasaRS = new javax.swing.JTextField();
        txtPhasaRT = new javax.swing.JTextField();
        txtPhasaST = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtPhasaNetralRN = new javax.swing.JTextField();
        txtPhasaNetralSN = new javax.swing.JTextField();
        txtPhasaNetralTN = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel2.setText("HALAMAN PENGINPUTAN DATA BEBAN GARDU");

        jLabel21.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel21.setText("X ");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel21))
        );

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOMOR GARDU");

        cbNomorGardu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbNomorGardu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));
        cbNomorGardu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNomorGarduItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RUTE");

        txtRute.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TANGGAL");

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("WAKTU");

        txtJam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJam.setText("JAM");
        txtJam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtJamMouseClicked(evt);
            }
        });
        txtJam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJamKeyTyped(evt);
            }
        });

        txtMenit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtMenit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMenit.setText("MENIT");
        txtMenit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMenitMouseClicked(evt);
            }
        });
        txtMenit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMenitKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("DAYA");

        txtTegangan.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRute)
                            .addComponent(cbNomorGardu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMenit, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTegangan))))
                .addGap(6, 6, 6))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbNomorGardu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(txtMenit)
                    .addComponent(txtJam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtTegangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RUTE");

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("A");

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("B");

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("C");

        jLabel10.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("D");

        jLabel11.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("INDUK");

        txtAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtARKeyTyped(evt);
            }
        });

        txtAS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtASKeyTyped(evt);
            }
        });

        txtAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtATKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtATKeyTyped(evt);
            }
        });

        txtAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtANKeyTyped(evt);
            }
        });

        txtBR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBRKeyTyped(evt);
            }
        });

        txtBS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBSKeyTyped(evt);
            }
        });

        txtBT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBTKeyTyped(evt);
            }
        });

        txtBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBNKeyTyped(evt);
            }
        });

        txtCR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCRKeyTyped(evt);
            }
        });

        txtCS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCSKeyTyped(evt);
            }
        });

        txtCT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCTKeyTyped(evt);
            }
        });

        txtCN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCNKeyTyped(evt);
            }
        });

        txtDR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDRKeyTyped(evt);
            }
        });

        txtDS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDSKeyTyped(evt);
            }
        });

        txtDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDTKeyTyped(evt);
            }
        });

        txtDN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNKeyTyped(evt);
            }
        });

        txtIndukR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndukRKeyTyped(evt);
            }
        });

        txtIndukS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndukSKeyTyped(evt);
            }
        });

        txtIndukT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIndukTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndukTKeyTyped(evt);
            }
        });

        txtIndukN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIndukNKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("R");

        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("S");

        jLabel14.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("T");

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("N");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDS, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDN, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIndukR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIndukS, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIndukT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIndukN, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCS, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCN, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtAR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAS, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtBR)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtBS, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtBT, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(txtAT))
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBN)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(txtAN))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIndukR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIndukS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIndukT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIndukN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("KETERANGAN");

        txtKet.setEditable(false);
        txtKet.setColumns(20);
        txtKet.setRows(5);
        jScrollPane1.setViewportView(txtKet);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("PHASA-PHASA");

        txtPhasaRS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPhasaRS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhasaRS.setText("R-S");
        txtPhasaRS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhasaRSMouseClicked(evt);
            }
        });
        txtPhasaRS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhasaRSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhasaRSKeyTyped(evt);
            }
        });

        txtPhasaRT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPhasaRT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhasaRT.setText("R-T");
        txtPhasaRT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhasaRTMouseClicked(evt);
            }
        });
        txtPhasaRT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhasaRTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhasaRTKeyTyped(evt);
            }
        });

        txtPhasaST.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPhasaST.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhasaST.setText("S-T");
        txtPhasaST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhasaSTMouseClicked(evt);
            }
        });
        txtPhasaST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhasaSTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhasaSTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhasaSTKeyTyped(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setActionCommand("btnSave");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ACTION");

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setActionCommand("btnSave");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.setActionCommand("btnSave");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtPhasaNetralRN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPhasaNetralRN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhasaNetralRN.setText("R-N");
        txtPhasaNetralRN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhasaNetralRNMouseClicked(evt);
            }
        });
        txtPhasaNetralRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhasaNetralRNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhasaNetralRNKeyTyped(evt);
            }
        });

        txtPhasaNetralSN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPhasaNetralSN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhasaNetralSN.setText("S-N");
        txtPhasaNetralSN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhasaNetralSNMouseClicked(evt);
            }
        });
        txtPhasaNetralSN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhasaNetralSNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhasaNetralSNKeyTyped(evt);
            }
        });

        txtPhasaNetralTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPhasaNetralTN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhasaNetralTN.setText("T-N");
        txtPhasaNetralTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhasaNetralTNMouseClicked(evt);
            }
        });
        txtPhasaNetralTN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhasaNetralTNKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("PHASA NETRAL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtPhasaRS, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhasaNetralRN, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPhasaRT)
                            .addComponent(txtPhasaST))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhasaNetralSN)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel18))
                            .addComponent(txtPhasaNetralTN))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPhasaRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPhasaNetralRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPhasaRT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhasaNetralSN)
                        .addComponent(btnUpdate)))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhasaST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhasaNetralTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbNomorGarduItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNomorGarduItemStateChanged
        // TODO add your handling code here:

        java.sql.Connection conn = new Koneksi().connect();
        try {
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet res = st.executeQuery("select *from datagardu where nomorgardu = '" + cbNomorGardu.getSelectedItem() + "'");
            while (res.next()) {
                txtRute.setText(res.getString("jumlahrute"));
                htg.setInomseca(res.getDouble("inomseca"));
                htg.setDaya(res.getDouble("daya"));
                txtTegangan.setText(String.valueOf(htg.getDaya()));
                AuthJurusan();
                txtAR.requestFocus();
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_cbNomorGarduItemStateChanged

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int row = Integer.parseInt(txtRute.getText());
        if(row == 1){
            Save1();
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);                  

        }
        else if(row == 2){
            Save1();
            Save2();
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);                  

        }
        else if(row == 3){
            Save1();
            Save2();
            Save3();
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);                  

        }
        else if(row == 4){
            Save1();
            Save2();
            Save3();
            Save4();
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);                  

        }
        else if(row == 5){
            Save1();
            Save2();
            Save3();
            Save4();
            Save5();
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Simpan","Pesan",JOptionPane.INFORMATION_MESSAGE);                  

        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtATKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtATKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtATKeyReleased

    private void txtBTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBTKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBTKeyReleased

    private void txtCTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCTKeyReleased

    private void txtDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDTKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDTKeyReleased

    private void txtIndukTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndukTKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtIndukTKeyReleased

    private void txtPhasaSTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaSTKeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_txtPhasaSTKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        BebanGardu.setId(jTable1.getValueAt(row, 0).toString());
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        new ViewUpdateBebanGardu().show();
        dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtJamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJamKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtJam.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if(txtJam.getText().length()>=2){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtJamKeyTyped

    private void txtMenitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMenitKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtMenit.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if(txtJam.getText().length()>=2){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMenitKeyTyped

    private void txtJamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJamMouseClicked
        // TODO add your handling code here:
        txtJam.setText("");
        txtJam.requestFocus();
    }//GEN-LAST:event_txtJamMouseClicked

    private void txtMenitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMenitMouseClicked
        // TODO add your handling code here:
        txtMenit.setText("");
        txtMenit.requestFocus();
    }//GEN-LAST:event_txtMenitMouseClicked

    private void txtARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtARKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtAR.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtARKeyTyped

    private void txtASKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtASKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtAS.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtASKeyTyped

    private void txtATKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtATKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtAT.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtATKeyTyped

    private void txtANKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtANKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtAN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtANKeyTyped

    private void txtBRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBRKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtBR.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtBRKeyTyped

    private void txtBSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtBS.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtBSKeyTyped

    private void txtBTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtBT.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtBTKeyTyped

    private void txtBNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtBN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtBNKeyTyped

    private void txtCRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCRKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtCR.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtCRKeyTyped

    private void txtCSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtCS.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtCSKeyTyped

    private void txtCTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtCT.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtCTKeyTyped

    private void txtCNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtCN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtCNKeyTyped

    private void txtDRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDRKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtDR.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtDRKeyTyped

    private void txtDSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtDS.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtDSKeyTyped

    private void txtDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtDT.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtDTKeyTyped

    private void txtDNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtDN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtDNKeyTyped

    private void txtIndukRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndukRKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtIndukR.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtIndukRKeyTyped

    private void txtIndukSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndukSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtIndukS.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtIndukSKeyTyped

    private void txtIndukTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndukTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtIndukT.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtIndukTKeyTyped

    private void txtIndukNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIndukNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtIndukN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtIndukNKeyTyped

    private void txtPhasaRSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaRSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtPhasaRS.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtPhasaRSKeyTyped

    private void txtPhasaRTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaRTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtPhasaRT.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtPhasaRTKeyTyped

    private void txtPhasaSTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaSTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtPhasaST.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtPhasaSTKeyTyped

    private void txtPhasaNetralRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaNetralRNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtPhasaNetralRN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtPhasaNetralRNKeyTyped

    private void txtPhasaNetralSNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaNetralSNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtPhasaNetralSN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtPhasaNetralSNKeyTyped

    private void txtPhasaNetralTNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaNetralTNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtPhasaNetralTN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtPhasaNetralTNKeyTyped

    private void txtPhasaRSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhasaRSMouseClicked
        // TODO add your handling code here:
        txtPhasaRS.setText("");
        txtPhasaRS.requestFocus();
    }//GEN-LAST:event_txtPhasaRSMouseClicked

    private void txtPhasaRTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhasaRTMouseClicked
        // TODO add your handling code here:
        txtPhasaRT.setText("");
        txtPhasaRT.requestFocus();
    }//GEN-LAST:event_txtPhasaRTMouseClicked

    private void txtPhasaSTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhasaSTMouseClicked
        // TODO add your handling code here:
        txtPhasaST.setText("");
        txtPhasaST.requestFocus();
    }//GEN-LAST:event_txtPhasaSTMouseClicked

    private void txtPhasaNetralRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhasaNetralRNMouseClicked
        // TODO add your handling code here:
        txtPhasaNetralRN.setText("");
        txtPhasaNetralRN.requestFocus();
    }//GEN-LAST:event_txtPhasaNetralRNMouseClicked

    private void txtPhasaNetralSNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhasaNetralSNMouseClicked
        // TODO add your handling code here:
        txtPhasaNetralSN.setText("");
        txtPhasaNetralSN.requestFocus();
    }//GEN-LAST:event_txtPhasaNetralSNMouseClicked

    private void txtPhasaNetralTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhasaNetralTNMouseClicked
        // TODO add your handling code here:
        txtPhasaNetralTN.setText("");
        txtPhasaNetralTN.requestFocus();
    }//GEN-LAST:event_txtPhasaNetralTNMouseClicked

    private void txtPhasaRSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaRSKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtPhasaRT.requestFocus();
            txtPhasaRT.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhasaRSKeyPressed

    private void txtPhasaRTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaRTKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtPhasaST.requestFocus();
            txtPhasaST.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhasaRTKeyPressed

    private void txtPhasaSTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaSTKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtPhasaNetralRN.requestFocus();
            txtPhasaNetralRN.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhasaSTKeyPressed

    private void txtPhasaNetralRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaNetralRNKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtPhasaNetralSN.requestFocus();
            txtPhasaNetralSN.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhasaNetralRNKeyPressed

    private void txtPhasaNetralSNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhasaNetralSNKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtPhasaNetralTN.requestFocus();
            txtPhasaNetralTN.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPhasaNetralSNKeyPressed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBebanGardu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBebanGardu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBebanGardu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBebanGardu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBebanGardu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbNomorGardu;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAN;
    private javax.swing.JTextField txtAR;
    private javax.swing.JTextField txtAS;
    private javax.swing.JTextField txtAT;
    private javax.swing.JTextField txtBN;
    private javax.swing.JTextField txtBR;
    private javax.swing.JTextField txtBS;
    private javax.swing.JTextField txtBT;
    private javax.swing.JTextField txtCN;
    private javax.swing.JTextField txtCR;
    private javax.swing.JTextField txtCS;
    private javax.swing.JTextField txtCT;
    private javax.swing.JTextField txtDN;
    private javax.swing.JTextField txtDR;
    private javax.swing.JTextField txtDS;
    private javax.swing.JTextField txtDT;
    private javax.swing.JTextField txtIndukN;
    private javax.swing.JTextField txtIndukR;
    private javax.swing.JTextField txtIndukS;
    private javax.swing.JTextField txtIndukT;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextArea txtKet;
    private javax.swing.JTextField txtMenit;
    private javax.swing.JTextField txtPhasaNetralRN;
    private javax.swing.JTextField txtPhasaNetralSN;
    private javax.swing.JTextField txtPhasaNetralTN;
    private javax.swing.JTextField txtPhasaRS;
    private javax.swing.JTextField txtPhasaRT;
    private javax.swing.JTextField txtPhasaST;
    private javax.swing.JTextField txtRute;
    private javax.swing.JTextField txtTegangan;
    // End of variables declaration//GEN-END:variables
}

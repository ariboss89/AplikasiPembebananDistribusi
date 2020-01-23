/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Controller.Koneksi;
import Model.DataGardu;
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
public class ViewDataGardu extends javax.swing.JFrame {

    /**
     * Creates new form ViewDataGardu
     */
    DataGardu dg = new DataGardu();
    private String namaunit;
    private String nomor;
    private String merk;
    private String nomorSeri;
    private Double daya;
    private int primer;
    private int sekunder;
    private Double inomseca;
    private int jumlahrute;
    private Date tanggal;
    private String alamat;
    Table tbl = new Table();
    private String[][] rs;

    String[] namaKolom = {"Nama Unit","Nomor", "Merk", "Nomor Seri", "Daya (KVA)", "Tegangan Primer", "Tegangan Sekunder", "Jumlah Rute", "Tanggal", "Alamat"};
    int jmlKolom = namaKolom.length;
    int[] lebar = {800,800, 800, 800, 800, 800, 800, 800, 800, 800};
    
    public ViewDataGardu() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
        ShowUnit();
        Refresh();
    }
    
    private void Refresh() {
        rs = dg.ShowData();
        tbl.SetTabel(jTable1, rs, namaKolom, jmlKolom, lebar);
        cbNamaUnit.setSelectedIndex(0);
        txtNomorGardu.requestFocus();
        txtNomorGardu.setText("");
        txtMerk.setText("");
        txtNomorSeri.setText("");
        txtDaya.setText("");
        txtTeganganPrimer.setText("");
        txtTeganganSekunder.setText("");
        txtJumlahRute.setText("");
        jDateChooser1.setDate(null);
        txtAlamat.setText("");
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnCancel.setEnabled(true);
    }
    
    private void ShowUnit() {
        java.sql.Connection conn = new Koneksi().connect();
        try {
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet res = st.executeQuery("select *from unit");
            while (res.next()) {
                cbNamaUnit.addItem(res.getString("nama"));
            }

        } catch (SQLException ex) {

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
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDaya = new javax.swing.JTextField();
        txtNomorGardu = new javax.swing.JTextField();
        txtMerk = new javax.swing.JTextField();
        txtNomorSeri = new javax.swing.JTextField();
        txtTeganganPrimer = new javax.swing.JTextField();
        txtTeganganSekunder = new javax.swing.JTextField();
        cbNamaUnit = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtJumlahRute = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel12.setText("HALAMAN PENGINPUTAN DATA GARDU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(1026, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NAMA UNIT");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMOR GARDU");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MERK");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMOR SERI");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DAYA (KVA)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TEGANGAN PRIMER");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TEGANGAN SEKUNDER");

        txtDaya.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDayaKeyTyped(evt);
            }
        });

        txtTeganganPrimer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTeganganPrimerKeyTyped(evt);
            }
        });

        txtTeganganSekunder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTeganganSekunderKeyTyped(evt);
            }
        });

        cbNamaUnit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbNamaUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("JUMLAH RUTE + INDUK");

        txtJumlahRute.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahRuteKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TANGGAL");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ALAMAT");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane1.setViewportView(txtAlamat);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("SEARCH");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel))
                    .addComponent(cbNamaUnit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomorGardu)
                    .addComponent(txtMerk)
                    .addComponent(txtNomorSeri)
                    .addComponent(txtDaya)
                    .addComponent(txtTeganganPrimer)
                    .addComponent(txtTeganganSekunder)
                    .addComponent(txtJumlahRute)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbNamaUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNomorGardu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNomorSeri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTeganganPrimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTeganganSekunder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtJumlahRute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnUpdate)
                            .addComponent(btnCancel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        namaunit = cbNamaUnit.getSelectedItem().toString().trim();
        nomor = txtNomorGardu.getText().trim();
        merk = txtMerk.getText().trim();
        nomorSeri = txtNomorSeri.getText().trim();
        daya = Double.parseDouble(txtDaya.getText());
        inomseca = daya*0.692;
        dg.setInomseca(inomseca);
        primer = Integer.parseInt(txtTeganganPrimer.getText().trim());
        sekunder = Integer.parseInt(txtTeganganSekunder.getText().trim());
        jumlahrute = Integer.parseInt(txtJumlahRute.getText().trim());
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = Date.valueOf(spf.format(jDateChooser1.getDate()));
        alamat = txtAlamat.getText().trim();

        if (namaunit.equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Nama Unit !!!");
            cbNamaUnit.requestFocus();
        }
        else if (nomor.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtNomorGardu.requestFocus();
        } else if (merk.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtMerk.requestFocus();
        } else if (jumlahrute == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Jumlah Rute !!!");
            txtJumlahRute.requestFocus();
        } else if (tanggal.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            jDateChooser1.requestFocus();
        } else if (primer==0) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            jPanel1.requestFocus();
        } else if (sekunder==0) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtTeganganSekunder.requestFocus();
        } else if (daya==0) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtDaya.requestFocus();
        } else if (nomorSeri.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtNomorSeri.requestFocus();
        } else if (alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtAlamat.requestFocus();
        } else if(jumlahrute >= 5){
            JOptionPane.showMessageDialog(null, "Batas Input Rute Hanya Sampai 5 !!!");
            txtJumlahRute.setText("");
            txtJumlahRute.requestFocus();
        } else {
            dg.Save(namaunit, nomor, merk, nomorSeri, daya, inomseca, primer, sekunder, jumlahrute, tanggal, alamat);
            Refresh();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        namaunit = cbNamaUnit.getSelectedItem().toString().trim();
        nomor = txtNomorGardu.getText().trim();
        merk = txtMerk.getText().trim();
        nomorSeri = txtNomorSeri.getText().trim();
        daya = Double.parseDouble(txtDaya.getText());
        inomseca = daya*0.692;
        dg.setInomseca(inomseca);
        primer = Integer.parseInt(txtTeganganPrimer.getText().trim());
        sekunder = Integer.parseInt(txtTeganganSekunder.getText().trim());
        jumlahrute = Integer.parseInt(txtJumlahRute.getText().trim());
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = Date.valueOf(spf.format(jDateChooser1.getDate()));
        alamat = txtAlamat.getText().trim();

        if (namaunit.equals("PILIH")) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Nama Unit !!!");
            cbNamaUnit.requestFocus();
        }
        else if (nomor.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtNomorGardu.requestFocus();
        } else if (merk.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtMerk.requestFocus();
        } else if (jumlahrute == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Jumlah Rute !!!");
            txtJumlahRute.requestFocus();
        } else if (tanggal.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            jDateChooser1.requestFocus();
        } else if (primer==0) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            jPanel1.requestFocus();
        } else if (sekunder==0) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtTeganganSekunder.requestFocus();
        } else if (daya==0) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtDaya.requestFocus();
        } else if (nomorSeri.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtNomorSeri.requestFocus();
        } else if (alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "Field Kosong !!!");
            txtAlamat.requestFocus();
        } else {
            dg.Update(namaunit, nomor, merk, nomorSeri, daya, inomseca, primer, sekunder, jumlahrute, tanggal, alamat);
            Refresh();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        cbNamaUnit.setSelectedItem(jTable1.getValueAt(row, 0).toString());
        txtNomorGardu.setText(jTable1.getValueAt(row, 1).toString());
        txtMerk.setText(jTable1.getValueAt(row, 2).toString());
        txtNomorSeri.setText(jTable1.getValueAt(row, 3).toString());
        txtDaya.setText(jTable1.getValueAt(row, 4).toString());
        txtTeganganPrimer.setText(jTable1.getValueAt(row, 5).toString());
        txtTeganganSekunder.setText(jTable1.getValueAt(row, 6).toString());
        txtJumlahRute.setText(jTable1.getValueAt(row, 7).toString());
        txtAlamat.setText(jTable1.getValueAt(row, 9).toString());
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtJumlahRuteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahRuteKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtJumlahRute.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if(txtJumlahRute.getText().length()==1){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtJumlahRuteKeyTyped

    private void txtTeganganSekunderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeganganSekunderKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtTeganganSekunder.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTeganganSekunderKeyTyped

    private void txtTeganganPrimerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTeganganPrimerKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtTeganganPrimer.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTeganganPrimerKeyTyped

    private void txtDayaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDayaKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();       
        if (txtDaya.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDayaKeyTyped

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        nomor = txtSearch.getText();
        dg.SearchData(nomor);
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(ViewDataGardu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDataGardu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDataGardu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDataGardu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDataGardu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbNamaUnit;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtDaya;
    private javax.swing.JTextField txtJumlahRute;
    private javax.swing.JTextField txtMerk;
    private javax.swing.JTextField txtNomorGardu;
    private javax.swing.JTextField txtNomorSeri;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTeganganPrimer;
    private javax.swing.JTextField txtTeganganSekunder;
    // End of variables declaration//GEN-END:variables
}

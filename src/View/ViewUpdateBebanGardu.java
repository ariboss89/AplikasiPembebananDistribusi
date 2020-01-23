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
public class ViewUpdateBebanGardu extends javax.swing.JFrame {

    BebanGardu bg = new BebanGardu();
    PerhitunganBebanGardu htg = new PerhitunganBebanGardu();

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

    public ViewUpdateBebanGardu() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
        ShowData();
        ShowDataGardu();
    }

    private void ShowData() {
        java.sql.Connection conn = new Koneksi().connect();
        try {
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet res = stmt.executeQuery("select *from bebangardu where id = '" + BebanGardu.getId() + "'");
            if (res.next()) {
                txtNoGardu.setText(res.getString("nogardu"));
                txtRute.setText(res.getString("rute"));
            }
        } catch (SQLException ex) {

        }
    }

    private void ShowDataGardu() {
        java.sql.Connection conn = new Koneksi().connect();
        try {
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet res = stmt.executeQuery("select *from datagardu where nomorgardu = '" + txtNoGardu.getText() + "'");
            if (res.next()) {
                htg.setDaya(res.getDouble("daya"));
            }
        } catch (SQLException ex) {

        }
    }

    private void RataRata() {
        Double ar = Double.parseDouble(txtR.getText());
        Double as = Double.parseDouble(txtS.getText());
        Double at = Double.parseDouble(txtT.getText());
        Double an = Double.parseDouble(txtN.getText());
        Double total = ar + as + at;
        htg.setTotal1(total);
        Double ratarata = ((ar + as + at) / 3);
        htg.setRatarata1(ratarata);
    }

    private void MinMax() {
        Double r = Double.parseDouble(txtR.getText());
        Double s = Double.parseDouble(txtS.getText());
        Double t = Double.parseDouble(txtT.getText());

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

    private void MinMaxPhasa() {
        Double r = Double.parseDouble(txtRS.getText());
        Double s = Double.parseDouble(txtRT.getText());
        Double t = Double.parseDouble(txtST.getText());

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

    private void BebanKva() {
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

    private void Unbalance() {
        MinMax();
        Double unbalance = (((htg.getMax1() - htg.getMin1()) / htg.getMax1()) * 100);
        String convertBalance = String.format("%.2f", unbalance);
        htg.setUnbalance1(Double.valueOf(convertBalance));

        if (htg.getUnbalance1() >= 20) {
            htg.setKet("Perlu Penyeimbangan");
        } else {
            htg.setKet("Ok");
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
        txtNoGardu = new javax.swing.JTextField();
        txtRute = new javax.swing.JTextField();
        txtJam = new javax.swing.JTextField();
        txtR = new javax.swing.JTextField();
        txtRS = new javax.swing.JTextField();
        txtRN = new javax.swing.JTextField();
        txtS = new javax.swing.JTextField();
        txtT = new javax.swing.JTextField();
        txtSN = new javax.swing.JTextField();
        txtTN = new javax.swing.JTextField();
        txtRT = new javax.swing.JTextField();
        txtST = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        txtN = new javax.swing.JTextField();
        txtMenit = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Halaman Update");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel12.setText("HALAMAN PENGUPDATEAN DATA GARDU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NO GARDU");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RUTE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TANGGAL");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("WAKTU");

        txtNoGardu.setEditable(false);

        txtRute.setEditable(false);

        txtJam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtJam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJam.setText("JAM");
        txtJam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtJamMouseClicked(evt);
            }
        });
        txtJam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJamActionPerformed(evt);
            }
        });
        txtJam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJamKeyTyped(evt);
            }
        });

        txtR.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtR.setText("R");
        txtR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRMouseClicked(evt);
            }
        });
        txtR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRKeyTyped(evt);
            }
        });

        txtRS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRS.setText("R-S");
        txtRS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRSMouseClicked(evt);
            }
        });
        txtRS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRSKeyTyped(evt);
            }
        });

        txtRN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRN.setText("R-N");
        txtRN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRNMouseClicked(evt);
            }
        });
        txtRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRNKeyTyped(evt);
            }
        });

        txtS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtS.setText("S");
        txtS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSMouseClicked(evt);
            }
        });
        txtS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSKeyTyped(evt);
            }
        });

        txtT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtT.setText("T");
        txtT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTMouseClicked(evt);
            }
        });
        txtT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTKeyTyped(evt);
            }
        });

        txtSN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSN.setText("S-N");
        txtSN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSNMouseClicked(evt);
            }
        });
        txtSN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSNKeyTyped(evt);
            }
        });

        txtTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTN.setText("T-N");
        txtTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTNMouseClicked(evt);
            }
        });
        txtTN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTNKeyTyped(evt);
            }
        });

        txtRT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRT.setText("R-T");
        txtRT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRTMouseClicked(evt);
            }
        });
        txtRT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRTKeyTyped(evt);
            }
        });

        txtST.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtST.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtST.setText("S-T");
        txtST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSTMouseClicked(evt);
            }
        });
        txtST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSTKeyTyped(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtN.setText("N");
        txtN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNMouseClicked(evt);
            }
        });
        txtN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNKeyTyped(evt);
            }
        });

        txtMenit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(114, 114, 114)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtS, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtRute)
                    .addComponent(txtNoGardu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtST, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRS, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRN, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoGardu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMenit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJamActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (txtJam.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtJam.requestFocus();
        } else if (txtMenit.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtMenit.requestFocus();
        } else if (txtR.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtR.requestFocus();
        } else if (txtS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtR.requestFocus();
        } else if (txtT.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtR.requestFocus();
        } else if (txtN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtR.requestFocus();
        } else if (txtRS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtRS.requestFocus();
        } else if (txtRT.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtRT.requestFocus();
        } else if (txtST.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtST.requestFocus();
        } else if (txtRN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtRN.requestFocus();
        } else if (txtSN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtSN.requestFocus();
        } else if (txtTN.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIELD TIDAK BOLEH KOSONG");
            txtTN.requestFocus();
        } else {
            nogardu = txtNoGardu.getText();
            namarute = txtRute.getText();
            SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
            tanggal = Date.valueOf(spf.format(jDateChooser1.getDate()));
            jam = Integer.parseInt(txtJam.getText().trim());
            menit = Integer.parseInt(txtMenit.getText().trim());
            r = Integer.parseInt(txtR.getText());
            s = Integer.parseInt(txtS.getText());
            t = Integer.parseInt(txtT.getText());
            n = Integer.parseInt(txtN.getText());
            RataRata();
            ratarata = htg.getRatarata1();

            rs = Double.parseDouble(txtRS.getText());
            rt = Double.parseDouble(txtRT.getText());
            st = Double.parseDouble(txtST.getText());
            BebanKva();
            bebankva = htg.getBebanKVA1();
            bebanpersen = htg.getBebanPersen1();

            rn = Double.parseDouble(txtRN.getText());
            sn = Double.parseDouble(txtSN.getText());
            tn = Double.parseDouble(txtTN.getText());

            Unbalance();
            unbalance = htg.getUnbalance1();
            ket = htg.getKet();

            java.sql.Connection conn = new Koneksi().connect();
            try {
                java.sql.PreparedStatement stmt = conn.prepareStatement("update bebangardu set nogardu=?, rute=?, tanggal=?, jam=?, menit =?, r =?, s =?, t =?, ratarata =?, n =?, bebankva =?, bebanpersen =?, rs =?, rt =?, st =?, rn =?, sn =?, tn =?, unbalance =?, ket =?, unit =? where Id =? ");
                try {
                    stmt.setString(1, nogardu);
                    stmt.setString(2, namarute);
                    stmt.setDate(3, tanggal);
                    stmt.setInt(4, jam);
                    stmt.setInt(5, menit);
                    stmt.setInt(6, r);
                    stmt.setInt(7, s);
                    stmt.setInt(8, t);
                    stmt.setDouble(9, ratarata);
                    stmt.setInt(10, n);
                    stmt.setDouble(11, bebankva);
                    stmt.setDouble(12, bebanpersen);
                    stmt.setDouble(13, rs);
                    stmt.setDouble(14, rt);
                    stmt.setDouble(15, st);
                    stmt.setDouble(16, rn);
                    stmt.setDouble(17, sn);
                    stmt.setDouble(18, tn);
                    stmt.setDouble(19, unbalance);
                    stmt.setString(20, ket);
                    stmt.setString(21, Login.getLevel());
                    stmt.setString(22, BebanGardu.getId());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update Berhasil", "Pesan", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Di Update", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtJamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJamKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtJam.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if (txtJam.getText().length() >= 2) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtJamKeyTyped

    private void txtMenitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMenitKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtMenit.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
        if (txtMenit.getText().length() >= 2) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMenitKeyTyped

    private void txtRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtR.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtRKeyTyped

    private void txtSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtS.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtSKeyTyped

    private void txtTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtT.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtTKeyTyped

    private void txtNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtNKeyTyped

    private void txtRSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtRS.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtRSKeyTyped

    private void txtRTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtRT.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtRTKeyTyped

    private void txtSTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSTKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtST.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtSTKeyTyped

    private void txtRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtRN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtRNKeyTyped

    private void txtSNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtSN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtSNKeyTyped

    private void txtTNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTNKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((karakter >= 'a') && (karakter <= 'z') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE) || (karakter == KeyEvent.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
        if (txtTN.getText().length() == 0 && karakter == KeyEvent.VK_SPACE) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_txtTNKeyTyped

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

    private void txtRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRMouseClicked
        // TODO add your handling code here:
        txtR.setText("");
        txtR.requestFocus();
    }//GEN-LAST:event_txtRMouseClicked

    private void txtSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSMouseClicked
        // TODO add your handling code here:
        txtS.setText("");
        txtS.requestFocus();
    }//GEN-LAST:event_txtSMouseClicked

    private void txtTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTMouseClicked
        // TODO add your handling code here:
        txtT.setText("");
        txtT.requestFocus();
    }//GEN-LAST:event_txtTMouseClicked

    private void txtNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNMouseClicked
        // TODO add your handling code here:
        txtN.setText("");
        txtN.requestFocus();
    }//GEN-LAST:event_txtNMouseClicked

    private void txtRSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRSMouseClicked
        // TODO add your handling code here:
        txtRS.setText("");
        txtRS.requestFocus();
    }//GEN-LAST:event_txtRSMouseClicked

    private void txtRTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRTMouseClicked
        // TODO add your handling code here:
        txtRT.setText("");
        txtRT.requestFocus();
    }//GEN-LAST:event_txtRTMouseClicked

    private void txtSTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSTMouseClicked
        // TODO add your handling code here:
        txtST.setText("");
        txtST.requestFocus();
    }//GEN-LAST:event_txtSTMouseClicked

    private void txtRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRNMouseClicked
        // TODO add your handling code here:
        txtRN.setText("");
        txtRN.requestFocus();
    }//GEN-LAST:event_txtRNMouseClicked

    private void txtSNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSNMouseClicked
        // TODO add your handling code here:
        txtSN.setText("");
        txtSN.requestFocus();
    }//GEN-LAST:event_txtSNMouseClicked

    private void txtTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTNMouseClicked
        // TODO add your handling code here:
        txtTN.setText("");
        txtTN.requestFocus();
    }//GEN-LAST:event_txtTNMouseClicked

    private void txtRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtS.requestFocus();
            txtS.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtRKeyPressed

    private void txtSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtT.requestFocus();
            txtT.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSKeyPressed

    private void txtTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtN.requestFocus();
            txtN.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTKeyPressed

    private void txtNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRS.requestFocus();
            txtRS.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNKeyPressed

    private void txtRSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRT.requestFocus();
            txtRT.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtRSKeyPressed

    private void txtRTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRTKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtST.requestFocus();
            txtST.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtRTKeyPressed

    private void txtSTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSTKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRN.requestFocus();
            txtRN.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSTKeyPressed

    private void txtRNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRNKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSN.requestFocus();
            txtSN.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtRNKeyPressed

    private void txtSNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTN.requestFocus();
            txtTN.setText("");
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSNKeyPressed

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
            java.util.logging.Logger.getLogger(ViewUpdateBebanGardu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUpdateBebanGardu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUpdateBebanGardu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUpdateBebanGardu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUpdateBebanGardu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtMenit;
    private javax.swing.JTextField txtN;
    private javax.swing.JTextField txtNoGardu;
    private javax.swing.JTextField txtR;
    private javax.swing.JTextField txtRN;
    private javax.swing.JTextField txtRS;
    private javax.swing.JTextField txtRT;
    private javax.swing.JTextField txtRute;
    private javax.swing.JTextField txtS;
    private javax.swing.JTextField txtSN;
    private javax.swing.JTextField txtST;
    private javax.swing.JTextField txtT;
    private javax.swing.JTextField txtTN;
    // End of variables declaration//GEN-END:variables
}

package hemsire;

import database.DBConnection;
import java.awt.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HastaKarti extends javax.swing.JFrame {

    DBConnection d;

    public HastaKarti() {

    }
    int id;

    HastaKarti(int hastaId) {

        initComponents();
        id = hastaId;
        d = new DBConnection();
        this.getContentPane().setBackground(Color.WHITE);
     

        String sql = "SELECT * FROM a.HASTA where HASTAID=" + id;
        Statement s;

        try {

            s = d.connect().createStatement();

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                txtTc.setText(rs.getInt("HASTAID") + "");
                txtAd.setText(rs.getString("HASTAADI"));
                txtSoyad.setText(rs.getString("HASTASOYADI"));
                txtAnneAd.setText(rs.getString("ANNEADI"));
                txtBabaAd.setText(rs.getString("BABAADI"));
                txtDogumYeri.setText(rs.getString("DOGUMYERI"));
                dateDogumTarihi.setDate((java.util.Date) rs.getDate("DOGUMTARIHI"));
                cmbCinsiyet.setSelectedItem(rs.getString("CINSIYET"));
                cmbKanGrubu.setSelectedItem(rs.getString("KANGRUBU"));
                cmbSosyalGüvenlik.setSelectedItem(rs.getString("SOSYALGUVENLIK"));
                cmbDiyabet.setSelectedItem(rs.getString("DIYABET"));
                cmbHepatit.setSelectedItem(rs.getString("HEPATIT"));
                cmbHiv.setSelectedItem(rs.getString("HIV"));
                txtMail.setText(rs.getString("EMAIL"));
                txtTelefon.setText(rs.getString("TELEFON"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbHepatit = new javax.swing.JComboBox();
        cmbDiyabet = new javax.swing.JComboBox();
        cmbHiv = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        txtSoyad = new javax.swing.JTextField();
        txtTc = new javax.swing.JTextField();
        txtBabaAd = new javax.swing.JTextField();
        txtAnneAd = new javax.swing.JTextField();
        dateDogumTarihi = new com.toedter.calendar.JDateChooser();
        txtDogumYeri = new javax.swing.JTextField();
        cmbCinsiyet = new javax.swing.JComboBox();
        cmbKanGrubu = new javax.swing.JComboBox();
        cmbSosyalGüvenlik = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnIptal = new javax.swing.JButton();
        btnKaydet = new javax.swing.JButton();
        txtMail = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Diyabet");
        jLabel12.setMaximumSize(new java.awt.Dimension(15, 5));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 70, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Hepatit");
        jLabel13.setMaximumSize(new java.awt.Dimension(15, 5));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 70, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("E-mail");
        jLabel17.setMaximumSize(new java.awt.Dimension(15, 5));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 70, 20));

        cmbHepatit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbHepatit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hepatit Negatif", "HCV (+)", "HbsAg (+)", "HCV (+) ve HbsAg (+)" }));
        getContentPane().add(cmbHepatit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 140, -1));

        cmbDiyabet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbDiyabet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Diyabet Yok", "Diyabet Tip 1", "Diyabet Tip 2" }));
        getContentPane().add(cmbDiyabet, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 140, -1));

        cmbHiv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbHiv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HIV Negatif", "HIV Pozitif" }));
        getContentPane().add(cmbHiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 140, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hasta Bilgileri", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Adı Soyadı");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tc Kimlik No");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Baba Adı");
        jLabel5.setMinimumSize(new java.awt.Dimension(50, 15));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 60, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Anne Adı");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Doğum Tarihi");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Doğum Yeri");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Cinsiyeti");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 60, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Kan Grubu");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 70, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Sosyal Güvenlik");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, -1));

        txtAd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdActionPerformed(evt);
            }
        });
        jPanel1.add(txtAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 60, 30));

        txtSoyad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtSoyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 60, 30));

        txtTc.setEditable(false);
        txtTc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTcActionPerformed(evt);
            }
        });
        jPanel1.add(txtTc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 130, 20));

        txtBabaAd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtBabaAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 130, -1));

        txtAnneAd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtAnneAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 130, -1));
        jPanel1.add(dateDogumTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 150, -1));

        txtDogumYeri.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtDogumYeri, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, -1));

        cmbCinsiyet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbCinsiyet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ERKEK", "KADIN" }));
        cmbCinsiyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCinsiyetActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCinsiyet, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 130, -1));

        cmbKanGrubu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbKanGrubu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A RH +", "A RH -", "B RH +", "B RH -", "AB RH +", "AB RH -", "0 RH +", "0 RH -" }));
        cmbKanGrubu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKanGrubuActionPerformed(evt);
            }
        });
        jPanel1.add(cmbKanGrubu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 130, -1));

        cmbSosyalGüvenlik.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbSosyalGüvenlik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SGK", "Emekli Sandığı", "Bağkur", "18 Yaş Altı Sosyal Güvence" }));
        jPanel1.add(cmbSosyalGüvenlik, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 130, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("HIV");
        jLabel16.setMaximumSize(new java.awt.Dimension(15, 5));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 60, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Telefon");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 60, 20));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 140, 20));

        btnIptal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIptal.setText("İptal");
        btnIptal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIptalActionPerformed(evt);
            }
        });
        jPanel1.add(btnIptal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 170, -1));

        btnKaydet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKaydet.setText("Değişiklikleri Kaydet");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });
        jPanel1.add(btnKaydet, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 170, -1));

        txtMail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(txtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 140, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 540, 350));
        getContentPane().add(txtTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 136, -1));

        setSize(new java.awt.Dimension(581, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed

     
        try {

            String sql = "UPDATE a.HASTA SET HASTAADI=?,HASTASOYADI=?,DOGUMTARIHI=?,DOGUMYERI=?,KANGRUBU=?,ANNEADI=?,BABAADI=?,CINSIYET=?,SOSYALGUVENLIK=?,DIYABET=?,HEPATIT=?,HIV=?,EMAIL=?,TELEFON=?  WHERE HASTAID=" + id;

            PreparedStatement ps = d.connect().prepareStatement(sql);

            ps.setString(1, txtAd.getText());
            ps.setString(2, txtSoyad.getText());
            java.sql.Date sqlDate = new java.sql.Date(dateDogumTarihi.getDate().getTime());
            ps.setDate(3, sqlDate);

            ps.setString(4, txtDogumYeri.getText());
            ps.setString(5, cmbKanGrubu.getSelectedItem().toString());
            ps.setString(6, txtAnneAd.getText());
            ps.setString(7, txtBabaAd.getText());

            ps.setString(8, cmbCinsiyet.getSelectedItem().toString());

            ps.setString(9, cmbSosyalGüvenlik.getSelectedItem().toString());
            ps.setString(10, cmbDiyabet.getSelectedItem().toString());
            ps.setString(11, cmbHepatit.getSelectedItem().toString());
            ps.setString(12, cmbHiv.getSelectedItem().toString());
            ps.setString(13, txtMail.getText());
            ps.setString(14, txtTelefon.getText());
            ps.executeUpdate();

            this.setVisible(false);
            this.dispose();

        } catch (SQLException ex) {
            Logger.getLogger(HastaKarti.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnKaydetActionPerformed

    private void btnIptalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIptalActionPerformed
        this.setVisible(false);
        this.dispose();

    }//GEN-LAST:event_btnIptalActionPerformed

    private void txtTcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTcActionPerformed

    private void cmbKanGrubuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKanGrubuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKanGrubuActionPerformed

    private void cmbCinsiyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCinsiyetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCinsiyetActionPerformed

    private void txtAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HastaKarti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HastaKarti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HastaKarti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HastaKarti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HastaKarti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIptal;
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox cmbCinsiyet;
    private javax.swing.JComboBox cmbDiyabet;
    private javax.swing.JComboBox cmbHepatit;
    private javax.swing.JComboBox cmbHiv;
    private javax.swing.JComboBox cmbKanGrubu;
    private javax.swing.JComboBox cmbSosyalGüvenlik;
    private com.toedter.calendar.JDateChooser dateDogumTarihi;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtAnneAd;
    private javax.swing.JTextField txtBabaAd;
    private javax.swing.JTextField txtDogumYeri;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtSoyad;
    private javax.swing.JTextField txtTc;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}

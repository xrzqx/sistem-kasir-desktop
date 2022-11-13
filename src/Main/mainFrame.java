package Main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JOptionPane;

import myPanel.panel1;
import myPanel.panel2;
import myPanel.panel3;
import myPanel.panel4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class mainFrame extends javax.swing.JFrame {

//    GridBagLayout layout = new GridBagLayout();
    BorderLayout layout2 = new BorderLayout();
//    panel1 p1;
    panel2 p2;
    panel3 p3;
    panel4 p4;
    GridBagConstraints c = new GridBagConstraints();

    /**
     * Creates new form mFrame
     */
    public mainFrame() {
        initComponents();
        if (pinDataset.isPegawai) {
            jButton6.setVisible(false);
            
        }
        jButton2.setBackground(new java.awt.Color(255, 120, 0));
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Tutup Aplikasi ?",
                "Judul", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                e.getWindow().dispose();
                System.out.println("JFrame Closed!");
            }
        });
//        p1 = new panel1();
        p2 = new panel2();
//        p3 = new panel3();
//        p4 = new panel4();
//        dynamicPanel.setLayout(layout2);
        
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 8;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(0, 30, 0, 0);
//        jPanel1.add(p1, c);
        jPanel1.add(p2, c);
//        jPanel1.add(p3, c);
//        jPanel1.add(p4, c);
//        dynamicPanel.add(p2);
//        dynamicPanel.add(p1);
        //c.anchor = GridBagConstraints.LINE_START;
        //dynamicPanel.add(p1,c);
        //dynamicPanel.add(p2,c);
//        p1.setVisible(true);
        p2.setVisible(true);
//        p3.setVisible(false);
//        p4.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\JavaApplication2\\icons8-question-mark-96.png")); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(1113, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Data Barang");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 5, 0);
        jPanel1.add(jButton2, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(255, 153, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Transaksi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 5, 0);
        jPanel1.add(jButton3, gridBagConstraints);

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Nota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 5, 0);
        jPanel1.add(jButton4, gridBagConstraints);

        jButton5.setBackground(new java.awt.Color(255, 153, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Surat Jalan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 5, 0);
        jPanel1.add(jButton5, gridBagConstraints);

        jButton6.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Rekap Penjualan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 5, 0);
        jPanel1.add(jButton6, gridBagConstraints);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 175;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 317, 0);
        jPanel1.add(jPanel3, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1298, 1007));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setBackground(new java.awt.Color(255, 120, 0));
        jButton3.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setBackground(new java.awt.Color(255, 153, 0));
        if (p2 != null) {
            jPanel1.remove(p2);
            jPanel1.add(p2, c);
        }
        else{
            p2 = new panel2();
            jPanel1.add(p2, c);
        }
        if (p3 != null) {
            p3.setVisible(false);
            jPanel1.remove(p3);
            p3 = null;
        }
        if (p4 != null) {
            p4.setVisible(false);
            jPanel1.remove(p4);
            p4 = null;
        }
//        p1.setVisible(false);
        p2.setVisible(true);
//        p3.setVisible(false);
//        p4.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton3.setBackground(new java.awt.Color(255, 120, 0));
        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setBackground(new java.awt.Color(255, 153, 0));
        
        if (p2 != null) {
            p2.setVisible(false);
            jPanel1.remove(p2);
            p2 = null;
        }
        if (p4 != null) {
            p4.setVisible(false);
            jPanel1.remove(p4);
            p4 = null;
        }
        if (p3 != null) {
            jPanel1.remove(p3);
            jPanel1.add(p3, c);
        }
        else{
            p3 = new panel3();
            jPanel1.add(p3, c);
        }
        
//        jPanel1.add(p3, c);
//        p1.setVisible(false);
//        p2.setVisible(false);
        p3.setVisible(true);
//        p4.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton3.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setBackground(new java.awt.Color(255, 120, 0));
        if (p2 != null) {
            p2.setVisible(false);
            jPanel1.remove(p2);
            p2 = null;
        }
        if (p3 != null) {
            p3.setVisible(false);
            jPanel1.remove(p3);
            p3 = null;
        }
        
        if (p4 != null) {
            jPanel1.remove(p4);
            jPanel1.add(p4, c);
        }
        else{
            p4 = new panel4();
            jPanel1.add(p4, c);
        }
//        jPanel1.add(p3, c);
//        p1.setVisible(false);
//        p2.setVisible(false);
//        p3.setVisible(false);
        p4.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}

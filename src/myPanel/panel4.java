/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPanel;

import Main.Config;

import java.awt.Font;
import java.awt.GridBagConstraints;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


//import java.beans.PropertyChangeListener;


/**
 *
 * @author hp
 */
public class panel4 extends javax.swing.JPanel {

    GridBagConstraints c = new GridBagConstraints();
    Font font = new Font("Tahoma", Font.PLAIN, 20);
    JFormattedTextField textfild = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
//    CalendarWindow calendarWindow = new CalendarWindow();

    private void load_table() {
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(jDateChooser1.getDate());
//        model.setRowCount(0);

        model.addColumn("pKey");
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Terjual");
        model.addColumn("Total Untung");
        model.addColumn("Tgl");

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
            String sql = "select idpembelian,namaBarang,jumlahBarang,hargajualBarang,hargabeliBarang,tglpemesanan "
                    + "from barang,pembelian "
                    + "where barang_idbarang = idbarang;";

            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {

                model.addRow(new Object[]{res.getInt(1), no++, res.getString(2), res.getInt(3), (res.getInt(4)*res.getInt(3)) - (res.getInt(5)*res.getInt(3)), res.getDate(6)});
                
            }
            jTable1.setModel(model);
//            jTable1.removeColumn(jTable1.getColumnModel().getColumn(7));
//            jTable1.removeColumn(jTable1.getColumnModel().getColumn(6));
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));

//            Font font = new Font("Tahoma", Font.PLAIN, 20);
            JTableHeader header = jTable1.getTableHeader();
            header.setReorderingAllowed(false);
            header.setFont(font);

            jTable1.getTableHeader().setResizingAllowed(false);
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);

            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTable1.setSelectionBackground(new java.awt.Color(255, 120, 0));
            jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
//            model.fireTableDataChanged();

        } catch (Exception e) {
//            Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void load_table(String tgl) {
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(jDateChooser1.getDate());
//        model.setRowCount(0);

        model.addColumn("pKey");
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Terjual");
        model.addColumn("Total Untung");
        model.addColumn("Tgl");

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
            String sql = "select idpembelian,namaBarang,jumlahBarang,hargajualBarang,hargabeliBarang,tglpemesanan "
                    + "from barang,pembelian "
                    + "where barang_idbarang = idbarang and tglpemesanan like '" + tgl+"'   ;";

            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {

                model.addRow(new Object[]{res.getInt(1), no++, res.getString(2), res.getInt(3), (res.getInt(4)*res.getInt(3)) - (res.getInt(5)*res.getInt(3)), res.getDate(6)});
                
            }
            jTable1.setModel(model);
//            jTable1.removeColumn(jTable1.getColumnModel().getColumn(7));
//            jTable1.removeColumn(jTable1.getColumnModel().getColumn(6));
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));

//            Font font = new Font("Tahoma", Font.PLAIN, 20);
            JTableHeader header = jTable1.getTableHeader();
            header.setReorderingAllowed(false);
            header.setFont(font);

            jTable1.getTableHeader().setResizingAllowed(false);
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);

            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTable1.setSelectionBackground(new java.awt.Color(255, 120, 0));
            jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
//            model.fireTableDataChanged();

        } catch (Exception e) {
//            Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void find_load_table(String find) {
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(jDateChooser1.getDate());
//        model.setRowCount(0);

        model.addColumn("pKey");
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Terjual");
        model.addColumn("Total Untung");
        model.addColumn("Tgl");

        //menampilkan data database kedalam tabel
        try {
            int no = 1;
            String sql = "select idpembelian,namaBarang,jumlahBarang,hargajualBarang,hargabeliBarang,tglpemesanan "
                    + "from barang,pembelian "
                    + "where barang_idbarang = idbarang and namaBarang like '%" + find+"%'   ;";

            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {

                model.addRow(new Object[]{res.getInt(1), no++, res.getString(2), res.getInt(3), (res.getInt(4)*res.getInt(3)) - (res.getInt(5)*res.getInt(3)), res.getDate(6)});
                
            }
            jTable1.setModel(model);
//            jTable1.removeColumn(jTable1.getColumnModel().getColumn(7));
//            jTable1.removeColumn(jTable1.getColumnModel().getColumn(6));
            jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));

//            Font font = new Font("Tahoma", Font.PLAIN, 20);
            JTableHeader header = jTable1.getTableHeader();
            header.setReorderingAllowed(false);
            header.setFont(font);

            jTable1.getTableHeader().setResizingAllowed(false);
            jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);

            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTable1.setSelectionBackground(new java.awt.Color(255, 120, 0));
            jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
//            model.fireTableDataChanged();

        } catch (Exception e) {
//            Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    

    /**
     * Creates new form panel4
     */
    public panel4() {
        initComponents();
        load_table();
        
        
        
        
        
        
        
//        calendarWindow.setUndecorated(true);
//        calendarWindow.addPropertyChangeListener(this);
//        textfild.setValue(new Date());
//        textfild.setPreferredSize(new Dimension(130, 30));
//        textfild.setFont(font);
//        c.gridx = 0;
//        c.gridy = 2;
//        c.gridwidth = 1;
//        c.gridheight = 1;
//        c.insets = new Insets(10, 150, 0, 0);
//        c.anchor = GridBagConstraints.NORTHWEST;
//        this.add(textfild, c);
//        load_table();

//        jButton1.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                calendarWindow.setLocation(textfild.getLocationOnScreen().x,
//                        (textfild.getLocationOnScreen().y + textfild.HEIGHT) );
//                
//                Date selectedDate = (Date) textfild.getValue();
//                calendarWindow.resetSelection(selectedDate);
//                
//                calendarWindow.setVisible(true);
//            }
//        });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new java.awt.GridBagLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
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
        jTable1.setGridColor(new java.awt.Color(255, 255, 51));
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(255, 97, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 450;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(jScrollPane1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Find");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(20, 30, 0, 0);
        add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tanggal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 30, 0, 0);
        add(jLabel3, gridBagConstraints);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 200;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 150, 0, 0);
        add(jTextField2, gridBagConstraints);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 320, 0, 0);
        add(jButton1, gridBagConstraints);

        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 390, 0, 0);
        add(jButton2, gridBagConstraints);

        jDateChooser1.setBackground(new java.awt.Color(0, 153, 153));
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 150, 0, 0);
        add(jDateChooser1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (jDateChooser1.getDate() == null) {
            load_table();
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(jDateChooser1.getDate());
            load_table(date);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (jTextField2.getText() == null || "".equals(jTextField2.getText()) || " ".equals(jTextField2.getText()) ) {
            load_table();
        }
        else{
            find_load_table(jTextField2.getText());
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        if (evt.getPropertyName().equals("selectedDate")) {
//            java.util.Calendar cal = (java.util.Calendar) evt.getNewValue();
//            Date selDate = cal.getTime();
//            textfild.setValue(selDate);
//        }
//    }
}

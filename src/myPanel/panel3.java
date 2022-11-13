/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPanel;

import Main.pinDataset;
import Main.CheckoutFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
//import static com.mindfusion.scheduling.CalendarElement.Cell;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.AbstractCellEditor;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hp
 */
public class panel3 extends javax.swing.JPanel {

    private static final Font font = new Font("Tahoma", Font.PLAIN, 20);
    public static int total = 0;

    private void load_pintable() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 4) {
//                    int jumlah = (int) getValueAt(row, column);
                    setValueAt(getValueAt(row, column), row, column);

                    return true;
                }
                return false;
            }
        };
        model.addColumn("pKey");
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("Katgegori");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        int no = 1;
        for (int i = 0; i < pinDataset.getSize(); i++) {
            Object[] temp = pinDataset.getRowValue(i);
            model.addRow(
                    new Object[]{
                        temp[0],
                        no++,
                        temp[1],
                        temp[2],
                        temp[3],
                        temp[4]});
        }

        jTable2.setModel(model);
        jTable2.revalidate();
        jTable2.removeColumn(jTable2.getColumnModel().getColumn(0));

//        Font font = new Font("Tahoma", Font.PLAIN, 20);
        JTableHeader header = jTable2.getTableHeader();
        header.setReorderingAllowed(false);
        header.setFont(font);

        jTable2.getColumnModel().getColumn(3).setCellEditor(new MyCellEditor());

//        JTextField textField = new JTextField();
//        textField.setFont(font);
//        textField.setBorder(new LineBorder(Color.BLACK));
//        DefaultCellEditor dce = new DefaultCellEditor( textField );
//        
//        jTable2.getColumnModel().getColumn(3).setCellEditor(dce);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(1);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(90);

        jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        jTable2.setRowSelectionAllowed(true);
        jTable2.setSelectionBackground(new java.awt.Color(255, 120, 0));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));

//        TableColumnModel colModel = jTable2.getColumnModel();
//        colModel.getColumn(3).setCellEditor(new MyCellEditor());
//        colModel.getColumn(3).setCellRenderer(new MyCellEditor());
    }

    private void autoSizeColumns(Workbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet.getPhysicalNumberOfRows() > 0) {
                Row row = sheet.getRow(sheet.getFirstRowNum());
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    sheet.autoSizeColumn(columnIndex);
                }
            }
        }
    }

    private class MyCellEditor extends AbstractCellEditor implements TableCellEditor {

        private static final long serialVersionUID = 1L;
//        private JFormattedTextField renderer;
        private JFormattedTextField editor;
        private NumberFormat format = NumberFormat.getIntegerInstance();

        public MyCellEditor() {
            format.setGroupingUsed(false);
//            renderer = new JFormattedTextField(format);
//            renderer.setBorder(null);
            editor = new JFormattedTextField(format);
            editor.setFont(font);
            editor.setBorder(new LineBorder(Color.BLACK));
        }

//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            renderer.setValue(value);
//            return renderer;
//        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//            int temp = String.valueOf(value).length();
            editor.setValue(value);
            return editor;
        }

        @Override
        public boolean stopCellEditing() {
            try {
                int selectedrow = jTable2.getSelectedRow();
                editor.commitEdit();
                Object[] temp = pinDataset.getRowValue(selectedrow);
                temp[3] = editor.getValue();
                pinDataset.setRowValueAt(selectedrow, temp);
                int jml = Math.toIntExact((long) temp[3]);

                int total2 = total;
                total = total - total2 + ((int) temp[4] * jml);
                if (pinDataset.hargalist.isEmpty()) {
                    pinDataset.hargalist.put((int) temp[0], total);
                    pinDataset.hargatotal = pinDataset.hargatotal + pinDataset.hargalist.get(temp[0]);
                    totaltxtField.setText(String.format("%,d", pinDataset.hargatotal));
                } else {
                    if (pinDataset.hargalist.containsKey((int) temp[0])) {
                        pinDataset.hargatotal = pinDataset.hargatotal - pinDataset.hargalist.get(temp[0]);
                        pinDataset.hargalist.replace((int) temp[0], total);
                        pinDataset.hargatotal = pinDataset.hargatotal + pinDataset.hargalist.get(temp[0]);
                        totaltxtField.setText(String.format("%,d", pinDataset.hargatotal));
                    } else {

                        pinDataset.hargalist.put((int) temp[0], total);
                        pinDataset.hargatotal = pinDataset.hargatotal + pinDataset.hargalist.get(temp[0]);
                        totaltxtField.setText(String.format("%,d", pinDataset.hargatotal));
                    }
                }

            } catch (ParseException e) {
                return false;
            }
            return super.stopCellEditing();
        }

        @Override
        public Object getCellEditorValue() {
            return editor.getValue();
        }
    }

    /**
     * Creates new form panel3
     */
    public panel3() {
        initComponents();
        totaltxtField.setText(String.format("%,d", pinDataset.hargatotal));
        load_pintable();

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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        checkoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        totaltxtField = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        notaButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new java.awt.GridBagLayout());

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setRowHeight(50);
        jTable2.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 450;
        gridBagConstraints.ipady = 25;
        add(jScrollPane2, gridBagConstraints);

        checkoutButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\JavaApplication2\\icons8-question-mark-32.png")); // NOI18N
        checkoutButton.setText("Check Out");
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        add(checkoutButton, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 40, 5, 0);
        add(jLabel1, gridBagConstraints);

        totaltxtField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totaltxtField.setForeground(new java.awt.Color(255, 255, 255));
        totaltxtField.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 120, 5, 0);
        add(totaltxtField, gridBagConstraints);

        deleteButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\JavaApplication2\\icons8-question-mark-32.png")); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 145);
        add(deleteButton, gridBagConstraints);

        notaButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\UD.BAROKAHJAYA\\src\\icons8-question-mark-32.png")); // NOI18N
        notaButton.setText("Export Nota");
        notaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 270);
        add(notaButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
        boolean status = false;
        for (int i = 0; i < pinDataset.getSize(); i++) {
            Object[] temp = pinDataset.getRowValue(i);

            if (temp[3] instanceof Integer) {
                if ((int) temp[3] <= 0) {
                    status = true;
                }
            }
            if (temp[3] instanceof Long) {
                if ((long) temp[3] <= 0) {
                    status = true;
                }
            }

        }
        if (pinDataset.getSize() <= 0) {
            JOptionPane.showMessageDialog(null, "Kosong");
        } else if (status) {
            JOptionPane.showMessageDialog(null, "Jumlah barang harus lebih besar dari 0");
        } else {
            Frame fm = new CheckoutFrame();
            fm.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    load_pintable();
                    totaltxtField.setText(String.format("%,d", pinDataset.hargatotal));
                }
            });
            fm.show();
        }

    }//GEN-LAST:event_checkoutButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedrow = jTable2.getSelectedRow();
        pinDataset.deleteRowValueAt(selectedrow);
        load_pintable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void notaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaButtonActionPerformed
        FileOutputStream outputStream = null;
        BufferedOutputStream excelBou = null;
        XSSFWorkbook workbook = null;
        JFileChooser excelFileChooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChoser = excelFileChooser.showSaveDialog(null);

        if (excelChoser == JFileChooser.APPROVE_OPTION) {

            try {
                workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Data Sheet");
                org.apache.poi.ss.usermodel.Font font = workbook.createFont();
                font.setFontHeightInPoints((short)12);
                org.apache.poi.ss.usermodel.Font hfont = workbook.createFont();
                hfont.setFontHeightInPoints((short)10);
                CellStyle style = workbook.createCellStyle();
                CellStyle style2 = workbook.createCellStyle();
                style2.setFont((org.apache.poi.ss.usermodel.Font) font);
                style2.setBorderBottom(BorderStyle.MEDIUM);  
                style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                style2.setBorderTop(BorderStyle.MEDIUM);
                style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
                style2.setBorderLeft(BorderStyle.MEDIUM);  
                style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                style2.setBorderRight(BorderStyle.MEDIUM);  
                style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
                CellStyle style3 = workbook.createCellStyle();
                style3.setAlignment(HorizontalAlignment.RIGHT);
                CellStyle style4 = workbook.createCellStyle();
                style4.setBorderLeft(BorderStyle.MEDIUM);  
                style4.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                style4.setBorderRight(BorderStyle.MEDIUM);  
                style4.setRightBorderColor(IndexedColors.BLACK.getIndex());
                CellStyle style5 = workbook.createCellStyle();
                style5.setBorderLeft(BorderStyle.MEDIUM);  
                style5.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                style5.setBorderRight(BorderStyle.MEDIUM);  
                style5.setRightBorderColor(IndexedColors.BLACK.getIndex());
                style5.setBorderBottom(BorderStyle.MEDIUM);  
                style5.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                CellStyle style6 = workbook.createCellStyle();
                style6.setFont((org.apache.poi.ss.usermodel.Font) hfont);
                
                
                Row head = sheet.createRow(0);
                Cell chead = head.createCell(1);
                chead.setCellValue("No. Nota");
                chead.setCellStyle(style6);
                chead = head.createCell(4);
                chead.setCellValue("Tanggal");
                chead.setCellStyle(style6);
                
                Row hMargin = sheet.createRow(1);
                hMargin.setHeight((short) 400);
                SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
                Date date = new Date(System.currentTimeMillis());
                Cell cMargin = hMargin.createCell(4);
                cMargin.setCellValue(formatter.format(date));
                
                Row row = sheet.createRow(2);
                Cell cell = row.createCell(1);
                cell.setCellValue("Daftar Barang");
                cell.setCellStyle(style2);
                cell = row.createCell(2);
                cell.setCellValue("Harga");
                cell.setCellStyle(style2);
                cell = row.createCell(3);
                cell.setCellValue("Qty");
                cell.setCellStyle(style2);
                cell = row.createCell(4);
                cell.setCellValue("Jumlah Harga");
                cell.setCellStyle(style2);
                
                int rowidx = 3;
                int celidx = 1;
                int size = pinDataset.getSize();
                 
                
                for (int i = 0; i < size; i++) {
                    Object [] temp = pinDataset.getRowValue(i);
                    Object [] data = {
                        temp[1],temp[3],temp[4],(long)temp[3]*(int)temp[4]
                    };
                    Row rowtmp = sheet.createRow(rowidx);
                    CellStyle cstyle;
                    for (int j = 0; j < data.length; j++) {
                        if (i != size-1) {
                            cstyle = style4;
                        }
                        else{
                            cstyle = style5;
                        }
                        Cell celltmp = rowtmp.createCell(celidx);
                        celltmp.setCellValue(data[j].toString());
                        celltmp.setCellStyle(cstyle);
                        celidx++;
//                        System.out.println("cell "+celidx);
//                        System.out.println(data[i][j]);
                    }
                    rowidx++;
                    if (i != size-1) {
                        celidx = 1;
//                        System.out.println(celidx);
//                        System.out.println("ii = " + i);
//                        System.out.println("data leght " + data.length);
                    }else{
//                        System.out.println(celidx);
                        celidx = celidx - 3;
                        sheet.addMergedRegion(new CellRangeAddress(rowidx,rowidx,celidx,celidx+2));
                        Row rowtmp2 = sheet.createRow(rowidx);
                        Cell celltmp = rowtmp2.createCell(celidx);
                        celltmp.setCellValue("Total Belanja : ");
                        celltmp.setCellStyle(style3);
                        
                        sheet.addMergedRegion(new CellRangeAddress(rowidx+1,rowidx+1,celidx,celidx+2));
                        Row rowtmp3 = sheet.createRow(rowidx+1);
                        Cell celltmp2 = rowtmp3.createCell(celidx);
                        celltmp2.setCellValue("Uang Bayar : ");
                        celltmp2.setCellStyle(style3);
                        
                        sheet.addMergedRegion(new CellRangeAddress(rowidx+2,rowidx+2,celidx,celidx+2));
                        Row rowtmp4 = sheet.createRow(rowidx+2);
                        Cell celltmp3 = rowtmp4.createCell(celidx);
                        celltmp3.setCellValue("Total Kembali : ");
                        celltmp3.setCellStyle(style3);
                        
                    }
                    
                }
                
                autoSizeColumns(workbook);
                String fullpth = FilenameUtils.getFullPath(excelFileChooser.getSelectedFile().getAbsolutePath());
                String spth = excelFileChooser.getSelectedFile().getName();
                if ("xlsx".equals(FilenameUtils.getExtension(spth))) {
                    spth = FilenameUtils.removeExtension(spth);
                }
                outputStream = new FileOutputStream(fullpth + spth + ".xlsx");
                excelBou = new BufferedOutputStream(outputStream);
                workbook.write(excelBou);
            } catch (FileNotFoundException ex) {
//                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } catch (IOException ex) {
//                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBou != null) {
                        excelBou.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (workbook != null) {
                        workbook.close();
                    }
                } catch (IOException ex) {
//                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }//GEN-LAST:event_notaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkoutButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton notaButton;
    private javax.swing.JLabel totaltxtField;
    // End of variables declaration//GEN-END:variables
}

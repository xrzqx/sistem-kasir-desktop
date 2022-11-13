/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPanel;

import java.awt.Component;
import java.awt.Font;
import java.lang.ref.Reference;
import javax.swing.AbstractCellEditor;
import javax.swing.CellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author hp
 */
public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {
    CellEditor currentEditor;

    public MyTableCellEditor() {
    }

    JComponent component = new JTextField();
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
//        currentEditor.set
        ((JTextField)component).setText(String.valueOf(value));
        ((JTextField)component).setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
        currentEditor = (CellEditor) component;
        return (Component) currentEditor;
    }

    @Override
    public Object getCellEditorValue() {
        return currentEditor.getCellEditorValue();
    }

    

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hp
 */
public class pinDataset {

        private static ArrayList<Object[]> pinList = new ArrayList<Object[]>();
        private static Object[] editData ;
        public static HashMap<Integer, Integer> hargalist = new HashMap<Integer, Integer>();
        public static long hargatotal = 0;
        public static boolean isPegawai = false;
        
        private static boolean ctrltable = false;
        public pinDataset(ArrayList<Object[]> list) {
            this.pinList = list;
        }
        public static Object getValueAt(int row, int col){
            Object[] temp = pinList.get(row);
            return temp[col];
        }
        public static Object[] getRowValue(int row){
            return pinList.get(row);
        }
        
        public static void setData(Object []datarow){
            Object[] temp = datarow;
            pinList.add(temp);
        }
        
        public static void setRowValueAt(int row, Object []datarow){
            pinList.remove(row);
            pinList.add(row, datarow);
        }
        
        public static void deleteRowValueAt(int row){
            pinList.remove(row);
        }
        
        public static void clear(){
//            pinList.removeAll(pinList);
            pinList.clear();
            hargatotal = 0;
        }
        public static int getSize(){
            return pinList.size();
        }
        // untuk arraay editdata
        public static void setEditData(Object [] data){
            editData = data;
        }
        public static Object[] getEditData(){
            return editData;
        }
        public static Object getColEditData(int col){
            return editData[col];
        }
        public static void setCtrlTable(boolean status){
            ctrltable = status;
        }
        public static boolean cekStatus(){
            return ctrltable;
        }
}

package com.ibik.pbo.teori.jdbc;

import javax.swing.JOptionPane;

public class MainApps{

    public static void main(String[] args) {
    	ConnectionDB conn = new ConnectionDB();
    	try {
			conn.connect();
			new Login().setVisible(true);//
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
        
    }
}

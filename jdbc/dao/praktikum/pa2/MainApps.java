package com.ibik.pbo.teori.jdbc.dao.praktikum.pa2;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MainApps {
	
	MainApps(){
		ConnectionDB conn = new ConnectionDB ();
		try {
			conn.connect();
			new FormRegister().setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Gagal");
		}
		
	}
	
	public static void main(String[] args) {
		new MainApps();
		
	}
}

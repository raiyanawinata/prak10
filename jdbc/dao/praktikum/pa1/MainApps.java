package com.ibik.pbo.teori.jdbc.dao.praktikum.pa1;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.ibik.pbo.teori.FormBio;

public class MainApps {
	
	MainApps(){
	ConnectDb coon = new ConnectDb();
	FormBio form = new FormBio();
	try {
		coon.connect();
		form.setVisible(true);
		JOptionPane.showMessageDialog(null,"Koneksi Berhasil");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"Koneksi Gagal");
	}
}

	public static void main(String[] args) {
		new MainApps();
	}

}

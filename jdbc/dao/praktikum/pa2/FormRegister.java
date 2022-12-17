package com.ibik.pbo.teori.jdbc.dao.praktikum.pa2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormRegister extends JFrame {

	private JPanel contentPane;
	private JTextField text_npm;
	private JTextField text_email;
	private JTextField text_password;
	private JTextField text_repassword;
	private JTextField text_firstname;
	private JTextField text_middlename;
	private JTextField text_lastname;
	private JTextField text_birthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRegister frame = new FormRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 254, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NPM");
		lblNewLabel.setBounds(10, 54, 46, 14);
		contentPane.add(lblNewLabel);
		
		text_npm = new JTextField();
		text_npm.setBounds(123, 51, 86, 20);
		contentPane.add(text_npm);
		text_npm.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(10, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 104, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Re-password");
		lblNewLabel_3.setBounds(10, 129, 79, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("FirstName");
		lblNewLabel_4.setBounds(10, 154, 79, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MiddleName");
		lblNewLabel_5.setBounds(10, 179, 79, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("LastName");
		lblNewLabel_6.setBounds(10, 204, 68, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Birthday");
		lblNewLabel_7.setBounds(10, 229, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		text_email = new JTextField();
		text_email.setBounds(123, 76, 86, 20);
		contentPane.add(text_email);
		text_email.setColumns(10);
		
		text_password = new JTextField();
		text_password.setBounds(123, 101, 86, 20);
		contentPane.add(text_password);
		text_password.setColumns(10);
		
		text_repassword = new JTextField();
		text_repassword.setBounds(123, 126, 86, 20);
		contentPane.add(text_repassword);
		text_repassword.setColumns(10);
		
		text_firstname = new JTextField();
		text_firstname.setBounds(123, 151, 86, 20);
		contentPane.add(text_firstname);
		text_firstname.setColumns(10);
		
		text_middlename = new JTextField();
		text_middlename.setBounds(123, 176, 86, 20);
		contentPane.add(text_middlename);
		text_middlename.setColumns(10);
		
		text_lastname = new JTextField();
		text_lastname.setBounds(123, 201, 86, 20);
		contentPane.add(text_lastname);
		text_lastname.setColumns(10);
		
		text_birthday = new JTextField();
		text_birthday.setBounds(123, 226, 86, 20);
		contentPane.add(text_birthday);
		text_birthday.setColumns(10);
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setBounds(21, 284, 89, 23);
		contentPane.add(btn_cancel);
		
		JButton btn_register = new JButton("Register");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserttodb();
			}
		});
		btn_register.setBounds(120, 284, 89, 23);
		contentPane.add(btn_register);
		
	}

	protected void inserttodb() {
		// TODO Auto-generated method stub
		String output = "";
		output += "NPM :"+ text_npm.getText()+"\n"+
		"email :"+ text_email.getText()+"\n"+
		"first name :"+ text_firstname.getText()+"\n"+
		"middle name :"+ text_middlename.getText()+"\n"+
		"last name :"+ text_lastname.getText()+"\n"+
		"Birthday :"+ text_birthday.getText()+"\n";
		
		Students std = new Students();
		StudentsDAO stddao = new StudentsDAO();
		
		std.setNpm(Integer.parseInt(text_npm.getText()));
		std.setEmail(text_email.getText());
		std.setFirstname(text_firstname.getText());
		std.setMiddlename(text_middlename.getText());
		std.setLastname(text_lastname.getText());
		std.setBirthday(text_birthday.getText());
		
		try {
			stddao.saved(std);
			JOptionPane.showMessageDialog(null,"Berhasil disimpan");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"gagal disimpan");
		}
		
	}
}

package com.ibik.pbo.teori.jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Login extends JFrame{
    private JTextField textUsername;
    private JPasswordField textPassword;
    private String data[] = {"asdos.pbo@ibik.ac.id","123456","Asisten Dosen PBO"};
    
    Login(){
        setVisible(true);
        pack();
        setTitle("Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(350, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        initialize(this);
    }

    public static void main(String[] args) {
        new Login();
    }

    private void initialize(Login frame) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		frame.setContentPane(mainPanel);

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		mainPanel.add(panel1,BorderLayout.NORTH);

		JLabel lblUsername = new JLabel("Email สวัสดี");
		lblUsername.setBounds(22, 23, 80, 16);
		panel1.add(lblUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(105, 18, 169, 30);
		textUsername.setText(data[0]);
		panel1.add(textUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 69, 61, 16);
		panel1.add(lblPassword);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(105, 64, 169, 30);
		textPassword.setText(data[1]);
		panel1.add(textPassword);

		JCheckBox chkRemember = new JCheckBox("Remember password ?");
		chkRemember.setBounds(105, 90, 173, 40);
		panel1.add(chkRemember);

		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new GridLayout());
		pnlButton.setBounds(105, 140, 169, 40);
		
		JButton btnRegis = new JButton("Register");
		btnRegis.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Register().setVisible(true);
                dispose();
            }
        });
		pnlButton.add(btnRegis);
		JButton btnSubmit = new JButton("Login");
		btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPostData(e);
            }
        });
        pnlButton.add(btnSubmit);
        panel1.add(pnlButton);

		JLabel lblCopyright = new JLabel("copyright IBIK @ 2022",SwingConstants.CENTER);
		lblCopyright.setBackground(Color.BLUE);
		lblCopyright.setSize(300, 50);
		mainPanel.add(lblCopyright,BorderLayout.SOUTH);

		frame.add(panel1);
	}

    protected void checkPostData(ActionEvent e) {
        String message = "";
        System.out.println(textPassword.getPassword());
        if(!textUsername.getText().isEmpty() && !textPassword.getText().isEmpty()){
            if(textUsername.getText().equals(data[0]) && textPassword.getText().equals(data[1])){
                message = "Selamat datang "+data[2];
                Object[] options = {"OK"};
                int result = JOptionPane.showConfirmDialog(null, message, "Data ditemukan", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
                if(result == JOptionPane.OK_OPTION) {
                	new ScoreApps().setVisible(true);
                    dispose();
                }
            }else{
                message = "Data tidak ditemukan";
                JOptionPane.showMessageDialog(null, message);
            }
        }else{
            message = "Silakan mengisi data dengan benar";
            JOptionPane.showMessageDialog(null, message);
        }
        
    }
}

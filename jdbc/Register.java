package com.ibik.pbo.teori.jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Register extends JFrame {
    private JTextField textFullname,textEmail,textPhone;
    private JRadioButton radioGender1,radioGender2;
    private JComboBox selectCitizen;
    private ButtonGroup bg;

    Register(){
        setVisible(true);
        pack();
        setTitle("Register");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 350);
        setLocationRelativeTo(null);
        initialize(this);
        
    }

    public static void main(String[] args) {
        new Register();
    }

    private void initialize(Register frame) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		frame.setContentPane(mainPanel);

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		mainPanel.add(panel1,BorderLayout.NORTH);

		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setBounds(22, 23, 80, 16);
		panel1.add(lblFullname);
		
		textFullname = new JTextField();
		textFullname.setBounds(105, 18, 169, 30);
		//textFullname.setText("Febry D F");
		panel1.add(textFullname);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 69, 61, 16);
		panel1.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(105, 64, 169, 30);
		panel1.add(textEmail);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(22, 109, 61, 16);
		panel1.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setBounds(105, 104, 169, 30);
		panel1.add(textPhone);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(22, 150, 61, 16);
		panel1.add(lblGender);

		radioGender1 = new JRadioButton("Female");
		radioGender1.setBounds(105, 145, 100, 30);
        radioGender1.setActionCommand(radioGender1.getText());
		panel1.add(radioGender1);
		radioGender2 = new JRadioButton("Male");
		radioGender2.setBounds(200, 145, 100, 30);
		panel1.add(radioGender2);

		bg=new ButtonGroup();
		bg.add(radioGender1);bg.add(radioGender2);

		JLabel lblCityzen= new JLabel("Citizenship");
		lblCityzen.setBounds(22, 185, 100, 16);
		panel1.add(lblCityzen);

		String country[]={"Indonesia","India","Aus","U.S.A","England","Newzealand"}; 
		selectCitizen = new JComboBox(country);
		selectCitizen.setBounds(105, 180, 169, 30);
		panel1.add(selectCitizen);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(105, 220, 169, 40);
        btnSubmit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                checkPostData(e);
            }

        });
		panel1.add(btnSubmit);

		JLabel lblCopyright = new JLabel("copyright IBIK @ 2022",SwingConstants.CENTER);
		lblCopyright.setBackground(Color.BLUE);
		lblCopyright.setSize(300, 50);
		//lblCopyright.setPreferredSize(panel1.getPreferredSize());
		mainPanel.add(lblCopyright,BorderLayout.SOUTH);

		frame.add(panel1);
	}

    protected void checkPostData(ActionEvent e) {
        String message = "";
        String gender = "";
        if(radioGender1.isSelected()){
            gender = radioGender1.getText();
        }else if(radioGender2.isSelected()){
            gender = radioGender2.getText();
        }else{
            gender = "";
        }
        if((!textFullname.getText().isEmpty()) && (!textEmail.getText().isEmpty()) && (!textPhone.getText().isEmpty()) && (!gender.equals("")) && (!selectCitizen.getSelectedItem().equals("")) ){
            message += "Data anda adalah:\n";
            message += "Fullname: "+textFullname.getText()+"\n";
            message += "Email: "+textEmail.getText()+"\n";
            message += "Phone: "+textPhone.getText()+"\n";
            message += "Gender: "+gender+"\n";
            message += "Citizenship: "+selectCitizen.getSelectedItem().toString();
            
            int result = JOptionPane.showConfirmDialog(null, message, "Berhasil ditambahkan", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
            if(result == JOptionPane.OK_OPTION) {
            	new Login().setVisible(true);
                dispose();
            }
        }else{
            message = "Silakan mengisi data dengan benar";
            JOptionPane.showMessageDialog(null, message, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }        
    }
}

























package onlinereservationsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class signup extends javax.swing.JFrame{
    JFrame signupFrame;
    JLabel titlelabel, usernametext, passwordtext, signuptext;
    JTextField usernameinput;
    JPasswordField passwordinput;
    JButton backbutton, registerbutton;
    
    Connection conn;
    String DB_URL = "jdbc:mysql://localhost:3306/onlinereservationsystem";
    String user = "root";
    String password = "";
    
    public signup() throws ClassNotFoundException, SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, user, password);
            //Statement stmt =conn.createStatement();
            /*String sql1 = "if not exists (select * from sys.databases where name = 'onlinereservationsystem')"
                    + "BEGIN create database onlinereservationsystem";
            stmt.executeUpdate(sql1);*/
            /*String sql2= "use onlinereservationsystem"
                    + "CREATE TABLE 'onlinereservationsystem'.'users' ('username' VARCHAR(100) NOT NULL , 'password' VARCHAR(100) NOT NULL ) ENGINE = InnoDB";
            stmt.executeUpdate(sql2);*/
            
        }catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Something went wrong");
        }
        signupFrame = new JFrame("Online reservation - Create Account by Maanvith");
        signupFrame.setSize(4000,4000);
        signupFrame.setLayout(null);
        
        titlelabel = new JLabel("Online Reservation System ");
        titlelabel.setBounds(500,5,500,200);
        titlelabel.setForeground(Color.BLACK);
        Font font1 = new Font("Serif", Font.BOLD, 40);
        titlelabel.setFont(font1);
        signupFrame.add(titlelabel);
        
        signuptext = new JLabel("SIGNUP");
        signuptext.setBounds(680,100,400,200);
        signuptext.setForeground(Color.BLACK);
        Font font2 = new Font("Serif", Font.BOLD,20);
        signuptext.setFont(font2);
        signupFrame.add(signuptext);
        
       
        passwordtext = new JLabel("password");
        passwordtext.setBounds(400,400,100,40);
        passwordtext.setForeground(Color.BLACK);
        Font font3 = new Font("Serif", Font.BOLD,20);
        passwordtext.setFont(font3);
        signupFrame.add(passwordtext);
        
        usernametext = new JLabel("Username");
        usernametext.setBounds(400,300,100,40);
        usernametext.setForeground(Color.BLACK);
        Font font6 = new Font("Serif", Font.PLAIN,20);
        usernametext.setFont(font3);
        signupFrame.add(usernametext);
        
        usernameinput = new JTextField();
        usernameinput.setBounds(550,300,300,40);
        usernameinput.requestFocus();
        usernameinput.setFont(font6);
        signupFrame.add(usernameinput);
        
        passwordinput = new JPasswordField();
        passwordinput.setBounds(550,400,300,40);
        passwordinput.setFont(font6);
        signupFrame.add(passwordinput);
        
        registerbutton = new JButton("Register");
        registerbutton.setBounds(550,500,140,40);
        signupFrame.add(registerbutton);
        
        registerbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e ){
                try {
                    insertintodatabase();
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        backbutton = new JButton("Back to Login");
        backbutton.setBounds(700,500,150,40);
        signupFrame.add(backbutton);
        
        backbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                back();
            }
        });
        signupFrame.setVisible(true);
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void insertintodatabase() throws IllegalArgumentException, SQLException{
        try{
            String q1, q2;
            String usern;
            usern = usernameinput.getText();
            String pwd;
            pwd = passwordinput.getText();
            
            if(usern.isEmpty() || pwd.isEmpty()){
                throw new IllegalArgumentException();
            }
            
            //q1 = "create table if not exixts users (username varchar(100) unique not null, password int not null";
            //q1 = "if not exixts(select * from sys.objects where object_id = OBJECT_ID(n'[dbo].[users]') and type in(N'U'))"
                    //+ "create table[dbo].[users](username varchar(100) unique not null, password varchar(30) not null)";
            //PreparedStatement pstl = conn.prepareStatement(q1);
            //pstl.execute();
            
            q2 = "insert into users(username,password) values(?,?)";
            PreparedStatement pst2 =conn.prepareStatement(q2);
            pst2.setString(1, usern);
            pst2.setString(2, pwd);
            try{
                pst2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Account Created");
                passwordinput.setText("");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Username must be unique");
            }
            usernameinput.setText("");
            usernameinput.requestFocus();
            
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null,"Username and Password must not be blank");
            System.out.println(e);
        }
    }
    public void back(){
        signupFrame.dispose();
    }
 
}
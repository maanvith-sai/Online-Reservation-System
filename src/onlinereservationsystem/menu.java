package onlinereservationsystem;
import java.util.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class menu extends javax.swing.JFrame{
    JFrame menuFrame;
    JLabel titleLabel, menuLabel;
    JButton bookButton, exitButton,cancelButton, showButton;
    
    Connection conn;
    String DB_URL = "jdbc:mysql://localhost:3306";
    String user = "root";
    String password = "";
    
    public menu(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(DB_URL,user,password);
            Statement stmt = conn.createStatement();
            /*String sql = "create database if not exists onlinereservationsystem";
            stmt.executeUpdate(sql);
            sql = "use onlinereservationsystem";
            stmt.executeUpdate(sql);
            sql= "create table if not exists ticketinfo (pnr int unique not null, firstname varchar(100) not null, lastname varchar(100), emailid varchar(100),"
                    + "fromcity varchar(100), tocity varchar(100), datecal varchar(100), time varchar(100)";
            stmt.executeUpdate(sql); */   
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error in Connection menu");
        }
        menuFrame = new JFrame("Online Reservarion System by Maanvith");
        menuFrame.setSize(4000,4000);
        menuFrame.setLayout(null);
        
        titleLabel = new JLabel("Online Reservation System");
        titleLabel.setBounds(500, 5, 500, 200); 
        titleLabel.setForeground (Color.BLACK);
        Font font1 = new Font("Serif", Font. BOLD, 35);
        titleLabel.setFont(font1);
        menuFrame.add(titleLabel);

        menuLabel = new JLabel("MENU");
        menuLabel.setBounds (650, 150, 400, 200);
        menuLabel.setForeground (Color.BLACK);
        Font font2 = new Font("Serif", Font.BOLD, 32);
        menuLabel.setFont(font2); 
        menuFrame.add(menuLabel);
        
        bookButton = new JButton("Book A Ticket");
        bookButton.setBounds(550, 300, 300, 80);
        Font font3 = new Font("Serif", Font. BOLD, 20);
        bookButton.setFont(font3);
        bookButton.setForeground (Color.BLACK);
        menuFrame.add(bookButton);
        
        showButton = new JButton("Show A Ticket");
        showButton.setBounds (550, 400, 300, 80); 
        Font font4 = new Font("Serif", Font. BOLD, 20);
        showButton.setFont(font4);
        showButton.setForeground (Color.BLACK);
        menuFrame.add(showButton);

        cancelButton = new JButton("Cancel A Ticket");
        cancelButton.setBounds(550, 500, 300, 80);
        Font font5 = new Font("Serif", Font.BOLD, 20);
        cancelButton.setFont(font5);
        cancelButton.setForeground (Color.BLACK); 
        menuFrame.add(cancelButton);
        
        exitButton = new JButton("Exit");
        exitButton.setBounds (550, 600, 300, 80); 
        Font font6 = new Font("Serif", Font.BOLD, 20);
        exitButton.setFont(font6);
        exitButton.setForeground(Color.BLACK);
        menuFrame.add(exitButton);
        
        bookButton.addActionListener(new ActionListener() { 
            public void actionPerformed (ActionEvent e) {
                book boo = new book();
            }

        });
        
        showButton.addActionListener(new ActionListener() { 
            public void actionPerformed (ActionEvent e) {
                showticket boo = new showticket ();
            }

        });
        
        cancelButton.addActionListener(new ActionListener() { 
            public void actionPerformed (ActionEvent e) {
                cancel foo = new cancel();
            }

        });
        
        exitButton.addActionListener(new ActionListener() { 
            public void actionPerformed (ActionEvent e) {
                menuFrame.dispose();
            }

        });
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    }
    
}

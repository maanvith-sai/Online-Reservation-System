package onlinereservationsystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
public class showticket extends javax.swing.JFrame{
    JFrame bookFrame;
    JLabel titleLabel, enterPnrText, bookingFormText, emailLabel, fromLabel, toLabel, dateLabel, timeLabel;
    JLabel pnr, name, email, locationinfo, datentime,trainName, trainNumber;
    JTextField firstNameInput, lastNameInput, emailInput, pnrInput, timeInput; JComboBox fromlistCities, tolistCities;
    JButton submitButton, backButton;
    Connection conn;
    String DB_URL = "jdbc:mysql://localhost:3306/onlinereservationsystem";
    String user = "root";
    String password = "";

    public showticket() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection (DB_URL, user, password);
            Statement stmt = conn.createStatement();
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        bookFrame = new JFrame("Online Reservation System - Display Ticket Details by Maanvith"); 
        bookFrame.setSize(4000, 4000);
        bookFrame.setLayout(null);

        titleLabel = new JLabel("Online Reservation System"); 
        titleLabel.setBounds (500, 5, 500, 200); 
        Font font1 = new Font("Serif", Font.BOLD, 35);
        titleLabel.setForeground (Color.BLACK);
        titleLabel.setFont(font1);
        bookFrame.add(titleLabel);
        
        bookingFormText = new JLabel("VIEW TICKET"); 
        bookingFormText.setBounds(580, 60, 400, 200); 
        bookingFormText.setForeground (Color.BLACK); 
        Font font2 = new Font("Serif", Font. BOLD, 30); 
        bookingFormText.setFont(font2);
        bookFrame.add(bookingFormText);
        
        
        enterPnrText = new JLabel("Enter PNR");
        enterPnrText.setBounds(400,300,100,40);
        enterPnrText.setForeground(Color.BLACK);
        Font font3 = new Font("Sierf", Font.BOLD,25);
        titleLabel.setFont(font3);
        bookFrame.add(enterPnrText);
        
        pnrInput = new JTextField();
        pnrInput.setBounds(550,300,300,40);
        pnrInput.setFont(font3);
        pnrInput.requestFocus();
        bookFrame.add(pnrInput);
        
        pnr = new JLabel("PNR : ");
        pnr.setBounds(550,400,300,30);
        pnr.setForeground(Color.BLACK);
        Font font4 = new Font("Serif", Font.BOLD, 20);
        pnr.setFont(font4);
        bookFrame.add(pnr);
        
        
        name = new JLabel("Name : ");
        name.setBounds(550,440,300,30);
        name.setForeground(Color.BLACK);
        name.setFont(font4);
        bookFrame.add(name);
        
        
        email = new JLabel("E-Mail ID : ");
        email.setBounds(550,480,500,30);
        email.setForeground(Color.BLACK);
        email.setFont(font4);
        bookFrame.add(email);
        
        
        locationinfo = new JLabel("From : ");
        locationinfo.setBounds(550,520,300,30);
        locationinfo.setForeground(Color.BLACK);
        locationinfo.setFont(font4);
        bookFrame.add(locationinfo);
        
        
        datentime = new JLabel("Date : ");
        datentime.setBounds(550,560,300,30);
        datentime.setForeground(Color.BLACK);
        datentime.setFont(font4);
        bookFrame.add(datentime);
        
        trainNumber = new JLabel("Train Number : ");
        trainNumber.setBounds(550,600,300,30);
        trainNumber.setForeground(Color.BLACK);
        trainNumber.setFont(font4);
        bookFrame.add(trainNumber);
        
        trainName = new JLabel("Train Name : ");
        trainName.setBounds(550,640,700,30);
        trainName.setForeground(Color.BLACK);
        trainName.setFont(font4);
        bookFrame.add(trainName);
        

        submitButton = new JButton("Submit"); 
        submitButton.setBounds (520, 700, 140, 40); 
        bookFrame.add(submitButton);

        backButton = new JButton("Back"); 
        backButton.setBounds (700, 700, 140, 40); 
        bookFrame.add(backButton);
        
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    String pnrNumber = pnrInput.getText().toString();
                    String q = "Select * from ticketinfo where pnr = ?";
                    
                    PreparedStatement pst1 = conn.prepareStatement(q);
                    
                    pst1.setString(1,pnrNumber);
                   
                    ResultSet rSet = pst1.executeQuery();
                    if(rSet.next()){
                        pnr.setText("PNR : " +rSet.getString(1));
                        name.setText("Name : "+rSet.getString(2)+" "+rSet.getString(3));
                        email.setText("E-Mail ID : "+ rSet.getString(4));
                        locationinfo.setText("From: "+rSet.getString(5)+ " "+ "To : "+rSet.getString(6));
                        datentime.setText("Date: "+rSet.getString(7)+" "+"Time : "+rSet.getString(8));
                        trainNumber.setText("Train Number : "+rSet.getString(9));
                        trainName.setText("Train Name : "+rSet.getString(10));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "PNR Doesnot exits");
                        pnrInput.setText("");
                        pnrInput.requestFocus();
                        //firstNameInput.requestFocus();
                    }
                }catch (Exception e2){
                        System.out.println(e2);
                        JOptionPane.showMessageDialog(null, "Assignment Failed");
                    }
                }
            
        });
        
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bookFrame.dispose();
            }
        });
        
        bookFrame.setVisible(true);
        bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
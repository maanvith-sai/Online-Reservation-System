package onlinereservationsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class book extends javax.swing.JFrame {

    JFrame bookFrame;
    JLabel titleLabel, bookingFormText, firstNameLabel, emailLabel, fromLabel, toLabel, dateLabel, timeLabel, trainLabel, trainNameLabel,lastNameLabel;
    JTextField firstNameInput, lastNameInput, emailInput, dateInput, timeInput, trainNumberInput, trainNameInput;
    JComboBox fromlistCities, tolistCities;
    JButton submitButton, backButton, getButton;
    String cities[] = {"Banglore", "Chennai", "Chittor", "Delhi", "Kolkata", "Mumbai", "Nellore", "Pune", "Tirupati"};
    Connection conn;
    String DB_URL = "jdbc:mysql://localhost:3306/onlinereservationsystem";
    String user = "root";
    String password = "";

    public book() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, user, password);
            /*Statement stmt = conn.createStatement();
            String sql = "use onlinereservationsystem";
            stmt.executeUpdate(sql);
            sql = "create table if not exists ticketinfo (pnr int unique not null, firstname varchar(100) not null, lastname varchar(100), emailid varchar(100),"
                    + "fromcity varchar(100), tocity varchar(100), datecal varchar(100), time varchar(100)";
            stmt.executeUpdate(sql);*/
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        Font font4 = new Font("Serif", Font.BOLD, 20);
        bookFrame = new JFrame("Online Reservation System - Ticket Booking by Maanvith");
        bookFrame.setSize(4000, 4000);
        bookFrame.setLayout(null);

        titleLabel = new JLabel("Online Reservation System");
        titleLabel.setBounds(500, 2, 500, 200);
        Font font1 = new Font("Serif", Font.BOLD, 35);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(font1);
        bookFrame.add(titleLabel);
        
        bookingFormText = new JLabel("BOOKING FORM");
        bookingFormText.setBounds(580, 60, 400, 200);
        bookingFormText.setForeground(Color.BLACK);
        Font font2 = new Font("Serif", Font.BOLD, 30);
        bookingFormText.setFont(font2);
        bookFrame.add(bookingFormText);

        firstNameInput = new JTextField();
        firstNameInput.setBounds(360, 210, 150, 40);
        firstNameInput.setFont(font4);
        bookFrame.add(firstNameInput);
        firstNameInput.requestFocus();

        lastNameInput = new JTextField();
        lastNameInput.setBounds(750, 210, 150, 40);
        lastNameInput.setFont(font4);
        bookFrame.add(lastNameInput);

        emailInput = new JTextField();
        emailInput.setBounds(360, 280, 640, 40);
        emailInput.setFont(font4);
        bookFrame.add(emailInput);

        firstNameLabel = new JLabel("First Name :");
        firstNameLabel.setBounds(150, 210, 200, 40);
        firstNameLabel.setForeground(Color.BLACK);
        Font font3 = new Font("Serif", Font.BOLD, 20);
        firstNameLabel.setFont(font3);
        bookFrame.add(firstNameLabel);
        
        lastNameLabel = new JLabel("Last Name :");
        lastNameLabel.setBounds(630, 210, 200, 40);
        lastNameLabel.setForeground(Color.BLACK);
        lastNameLabel.setFont(font3);
        bookFrame.add(lastNameLabel);

        emailLabel = new JLabel("Email Id :");
        emailLabel.setBounds(150, 280, 200, 40);
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(font4);
        bookFrame.add(emailLabel);

        trainLabel = new JLabel("Train Number :");
        trainLabel.setBounds(150, 560, 150, 40);
        trainLabel.setForeground(Color.BLACK);
        trainLabel.setFont(font3);
        bookFrame.add(trainLabel);

        trainNameInput = new JTextField();
        trainNameInput.setBounds(800, 560, 150, 40);
        trainNameInput.setFont(font4);
        bookFrame.add(trainNameInput);
        trainNameInput.requestFocus();

        trainNameLabel = new JLabel("Train Name :");
        trainNameLabel.setBounds (680, 560, 150, 40); 
        trainNameLabel.setForeground (Color.BLACK);
        trainNameLabel.setFont(font4);
        bookFrame.add(trainNameLabel);
        
        
        trainNumberInput = new JTextField();
        trainNumberInput.setBounds(360, 560, 150, 40);
        trainNumberInput.setFont(font4);
        bookFrame.add(trainNumberInput);
        trainNumberInput.requestFocus();

        
        fromLabel = new JLabel("From : ");
        fromLabel.setBounds(150, 360, 200, 40);
        fromLabel.setForeground(Color.BLACK);
        Font fonts = new Font("Serif", Font.BOLD, 20);
        fromLabel.setFont(fonts);
        bookFrame.add(fromLabel);
        
        
        toLabel = new JLabel("TO : ");
        toLabel.setBounds(650, 360, 200, 40);
        toLabel.setForeground(Color.BLACK);
        toLabel.setFont(fonts);
        bookFrame.add(toLabel);
        
        fromlistCities = new JComboBox<String>(cities);
        fromlistCities.setBounds(360, 360, 150, 40);
        bookFrame.add(fromlistCities);
        fromlistCities.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == fromlistCities) {
                    fromlistCities.getSelectedItem();
                }
            }
        });

        tolistCities = new JComboBox<String>(cities);
        tolistCities.setBounds(700, 360, 150, 40);
        bookFrame.add(tolistCities);
        tolistCities.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tolistCities) {
                    tolistCities.getSelectedItem();
                }
            }
        });

        dateLabel = new JLabel("Date (yyyy-mm-dd):");
        dateLabel.setBounds(150, 440, 200, 40);
        dateLabel.setForeground(Color.BLACK);
        Font font6 = new Font("Serif", Font.BOLD, 20);
        dateLabel.setFont(font6);
        bookFrame.add(dateLabel);

        dateInput = new JTextField();
        dateInput.setBounds(360, 440, 100, 40);
        dateInput.setFont(font4);
        bookFrame.add(dateInput);

        timeLabel = new JLabel("Time (HH:MM) 24HRS :");
        timeLabel.setBounds(570, 440, 250, 40);
        timeLabel.setForeground(Color.BLACK);
        Font font7 = new Font("Serif", Font.BOLD, 18);
        timeLabel.setFont(font7);
        bookFrame.add(timeLabel);

        timeInput = new JTextField();
        timeInput.setBounds(780, 440, 100, 40);
        timeInput.setFont(font4);
        bookFrame.add(timeInput);

        submitButton = new JButton("Submit");
        submitButton.setBounds(700, 700, 140, 40);
        bookFrame.add(submitButton);
        
        getButton = new JButton("Get");
        getButton.setBounds(550, 560, 100, 40);
        bookFrame.add(getButton);
        

        backButton = new JButton("Back");
        backButton.setBounds(520, 700, 140, 40);
        bookFrame.add(backButton);

        /*submitButton.addActionListener(new ActionListener(){
            public void actionPerfomed(ActionEvent e) {
                try{
                    String q1, q2;
                    Random randomNumber = new Random();
                    int pnr = randomNumber.nextInt(2000);
                    String firstname = firstNameInput.getText();
                    String lastname = lastNameInput.getText();
                    String email = emailInput.getText(); 
                    String fromcity = fromlistCities.getSelectedItem().toString();
                    String tocity = tolistCities.getSelectedItem().toString();
                    String datee = dateInput.getText().toString();
                    String timee = timeInput.getText().toString();
                    
                    q2 = "insert into ticketinfo(pnr, firstname, lastname, emailid, fromcity, tocity, datecal, time) values (?,?,?,?,?,?,?,?)";
                    PreparedStatement pst2 = conn.prepareStatement(q2);
                    pst2.setInt(1, pnr);
                    pst2.setString(2, firstname);
                    pst2.setString(3, lastname);
                    pst2.setString(4, email);
                    pst2.setString(5, fromcity);
                    pst2.setString(6, tocity);
                    pst2.setString(7, datee);
                    pst2.setString(8, timee);
                    try{
                        pst2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Ticket Generated Successfully in Remember PNR is: " + pnr);
                        firstNameInput.setText("");
                        lastNameInput.setText("");
                        emailInput.setText("");
                        dateInput.setText("");
                        timeInput.setText("");
                    }catch (Exception e1){
                        System.out.println(e1);
                        JOptionPane.showMessageDialog(null,"Somethng went wrong");
                    }
                    firstNameInput.requestFocus();
                }catch (Exception e2){
                    System.out.println(e2);
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }
            }

        });*/
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String q1, q2;
                    Random randomNumber = new Random();
                    int pnr = randomNumber.nextInt(2000);
                    String firstname = firstNameInput.getText();
                    String lastname = lastNameInput.getText();
                    String email = emailInput.getText();
                    String fromcity = fromlistCities.getSelectedItem().toString();
                    String tocity = tolistCities.getSelectedItem().toString();
                    String datee = dateInput.getText().toString();
                    String timee = timeInput.getText();
                    String tnumber = trainNumberInput.getText();
                    String tname = trainNameInput.getText();

                    q2 = "insert into ticketinfo(pnr, firstname, lastname, emailid, fromcity, tocity, datecal, time,trainnumber,trainname) values (?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst2 = conn.prepareStatement(q2);
                    pst2.setInt(1, pnr);
                    pst2.setString(2, firstname);
                    pst2.setString(3, lastname);
                    pst2.setString(4, email);
                    pst2.setString(5, fromcity);
                    pst2.setString(6, tocity);
                    pst2.setString(7, datee);
                    pst2.setString(8, timee);
                    pst2.setString(9, tnumber);
                    pst2.setString(10, tname);

                    try {
                        pst2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Ticket Generated Successfully in Remember PNR is: " + pnr);
                        firstNameInput.setText("");
                        lastNameInput.setText("");
                        emailInput.setText("");
                        dateInput.setText("");
                        timeInput.setText("");
                        firstNameInput.requestFocus();
                    } catch (Exception e1) {
                        System.out.println(e1);
                    }

                } catch (Exception e2) {
                    System.out.println(e2);
                    JOptionPane.showMessageDialog(null, "Submit Button Error");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookFrame.dispose();
            }
        });
        
        getButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    String t;
                    String trainnumber = trainNumberInput.getText();
                    t = "select trainname from trains where trainnumber = ?";
                    PreparedStatement pst3 = conn.prepareStatement(t);
                    pst3.setString(1,trainnumber);
                    try{
                        ResultSet rSet = pst3.executeQuery();
                        if(rSet.next()){
                            trainNameInput.setText(rSet.getString(1));
                        }
                    }catch(Exception e5){
                        JOptionPane.showMessageDialog(null,"Rset error");
                    }
                }catch(Exception e4){
                    System.out.println(e4);
                    JOptionPane.showMessageDialog(null,"Fetching train Details Error");
                }
            }
        });

        bookFrame.setVisible(true);
        bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

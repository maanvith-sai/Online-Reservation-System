package onlinereservationsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class cancel extends javax.swing.JFrame {
    JFrame cancelFrame;
    JLabel titleLabel, showLabel, enterPnrText;
    JTextField pnrInput;
    JButton submitButton, backButton;
    
    Connection conn;
    String DB_URL = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    
    public cancel(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection (DB_URL, user, password);
            Statement stmt = conn.createStatement();
            String sql = "use onlinereservationsystem";
            stmt.executeUpdate(sql);
        }catch (Exception e){
            System.out.println(e);
        }
        
        cancelFrame = new JFrame("Online Reservation System - Cancel Ticket by Maanvith");
        cancelFrame.setSize(4000,4000);
        cancelFrame.setLayout(null);
        
        titleLabel = new JLabel("Online Reservation System"); 
        titleLabel.setBounds(500, 5, 500, 200);
        titleLabel.setForeground (Color.BLACK);
        Font font1 = new Font("Serif", Font. BOLD, 35);
        titleLabel.setFont(font1);
        cancelFrame.add(titleLabel);

        showLabel = new JLabel("CANCEL A TICKET");
        showLabel.setBounds (560, 150, 400, 200);
        showLabel.setForeground (Color.BLACK);
        Font font2 = new Font("Serif", Font. BOLD, 30);
        showLabel.setFont(font2);
        cancelFrame.add(showLabel);

        enterPnrText = new JLabel("Enter PNR");
        enterPnrText.setBounds (400, 300, 100, 40);
        enterPnrText.setForeground (Color.BLACK);
        Font font3 = new Font("Serif", Font. BOLD, 20);
        enterPnrText.setFont(font3);
        cancelFrame.add(enterPnrText);
        
        pnrInput = new JTextField(); 
        pnrInput.setBounds(550, 300, 300, 40); 
        pnrInput.requestFocus(); 
        cancelFrame.add(pnrInput);
        
        submitButton = new JButton("Submit"); 
        submitButton.setBounds(550, 400, 140, 40); 
        cancelFrame.add(submitButton);

        backButton = new JButton("Back"); 
        backButton.setBounds (700, 400, 150, 40); 
        cancelFrame.add(backButton);

        submitButton.addActionListener(new ActionListener(){ 
            public void actionPerformed (ActionEvent e) {
                deletedata();
            }
        });

        backButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed (ActionEvent e) { 
                cancelFrame.dispose();
            }
         });
        
        cancelFrame.setVisible(true); 
        cancelFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }
    public void deletedata (){
        try{
            int pnrNumber = Integer.parseInt(pnrInput.getText());
            String q = "select * from ticketinfo where pnr = ?";
            PreparedStatement pst1 = conn.prepareStatement(q);
            pst1.setInt(1,pnrNumber); 
            ResultSet rSet = pst1.executeQuery();
            if(rSet.next()){ 
                try{
                    int response = JOptionPane.showConfirmDialog(cancelFrame,"Do you want to cancel the ticket for sure?", "confirm",JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(response == JOptionPane.YES_NO_OPTION){
                        q = "delete from ticketinfo where pnr = ?";
                        pst1 = conn.prepareStatement(q);
                        pst1.setInt(1,pnrNumber);
                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Ticket Cancelled Succesfully");
                    }
                }catch (Exception e1){
                    System.out.println(e1);
                    JOptionPane.showMessageDialog(null, "something went wrong");
                }
            }else{
                JOptionPane.showMessageDialog(null, "PNR number doesnot exist");
            }
            pnrInput.setText("");
            pnrInput.requestFocus();
        } catch(Exception e2){
            System.out.println(e2);
            JOptionPane.showMessageDialog(null, "SOmething went wrong");
        }
    }
}

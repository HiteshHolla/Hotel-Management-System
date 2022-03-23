package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
        setBounds(275,100,1000,600); //Sets Frame size and position of window
//        setSize(500,400);
//        setLocation(500,200);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/one.jpg")); //Fetches BG image
        JLabel l1=new JLabel(i1); //Create label to add image object
        l1.setBounds(0,0,1000,600);
        add(l1);

        JLabel l2=new JLabel("<html><div style='text-align:center;'>Hotel<br>Management<br>System</div></html>");
        l2.setBounds(750,-50,500,300);
        l2.setForeground(Color.black);
        l2.setFont(new Font("serif",Font.BOLD,36));
        l1.add(l2);

        JButton b1=new JButton("Next");
        b1.setFocusPainted(false);
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(820,500,90,35);
        b1.setFont(new Font("serif",Font.BOLD,25));
        b1.setBorder(BorderFactory.createLineBorder(Color.black));
        b1.addActionListener(this);
        l1.add(b1);

        setLayout(null);
        setVisible(true);

        while(true) {
            l2.setVisible(false);
            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }

            l2.setVisible(true);
            try {
                Thread.sleep(300);
            } catch (Exception e) {
            }
        }
    }

    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args){
        new HotelManagementSystem();
    }
}

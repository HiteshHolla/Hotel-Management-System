package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {

    Choice c1;
    JTextField t1,t2;
    JButton b1,b2,b3;

    CheckOut(){

        JLabel l1=new JLabel("Check Out");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Helvetica", Font.PLAIN,20));
        l1.setBounds(120,20,100,30);
        add(l1);

        JLabel l2=new JLabel("Customer ID");
        l2.setBounds(30,80,100,30);
        add(l2);

        c1=new Choice();
        try{
            Conn c=new Conn();
            String str="select * from customer";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        c1.setBounds(150,80,185,30);
        add(c1);

        JLabel l3=new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);

        t1=new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);

        b1=new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(30,180,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(170,180,120,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        i1=new ImageIcon(i2);
        b3=new JButton(i1);
        b3.setBounds(310,80,20,20);
        b3.addActionListener(this);
        add(b3);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(500,200,380,270);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == b1) {
            String id=c1.getSelectedItem();
            String room=t1.getText();
            String str1="delete from customer where number='"+id+"'";
            String str2="update room set available='Available' where room_number='"+room+"'";
            Conn c=new Conn();
            try{
                c.s.executeUpdate(str1);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "Checkout Completed");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == b2) {
            new Reception().setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == b3) {
            String s1 = c1.getSelectedItem();
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from customer where number='" + s1 + "'");
                while (rs.next()) {
                    t1.setText(rs.getString("room"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static  void main(String[] args){
        new CheckOut().setVisible(true);
    }
}

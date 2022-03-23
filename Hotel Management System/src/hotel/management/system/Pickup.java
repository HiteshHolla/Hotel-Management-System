package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pickup extends JFrame implements ActionListener {

    Choice c1;
    JButton b1,b2;
    JTable t1;

    Pickup(){

        JLabel l1=new JLabel("Pickup Service");
        l1.setFont(new Font("Helvetica",Font.PLAIN,20));
        l1.setBounds(400,30,200,30);
        add(l1);

        JLabel l2=new JLabel("Type of Car");
        l2.setBounds(50,100,100,20);
        add(l2);

        c1=new Choice();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("model"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        c1.setBounds(150,100,150,25);
        add(c1);

        t1=new JTable();
        t1.setBounds(0,200,1000,300);
        add(t1);

        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(300,520,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(500,520,120,30);
        b2.addActionListener(this);
        add(b2);

        JLabel l11=new JLabel("Name");
        l11.setBounds(30,160,100,20);
        add(l11);

        JLabel l12=new JLabel("Age");
        l12.setBounds(200,160,100,20);
        add(l12);

        JLabel l13=new JLabel("Gender");
        l13.setBounds(330,160,100,20);
        add(l13);

        JLabel l14=new JLabel("Company");
        l14.setBounds(460,160,100,20);
        add(l14);

        JLabel l15=new JLabel("Model");
        l15.setBounds(630,160,100,20);
        add(l15);

        JLabel l16=new JLabel("Availability");
        l16.setBounds(740,160,100,20);
        add(l16);

        JLabel l17=new JLabel("Location");
        l17.setBounds(890,160,100,20);
        add(l17);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(380,100,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try {
                String str1 = "select * from driver where model='" + c1.getSelectedItem() + "'";
                String str2 = "select * from room where bed_type='" + c1.getSelectedItem() + "' and available='Available'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(str1);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new Pickup().setVisible(true);
    }
}

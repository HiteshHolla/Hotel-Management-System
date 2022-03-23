package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {

    Choice c1;
    JButton b1,b2;
    JTable t1;

    Department(){

        JLabel l1=new JLabel("Department Info");
        l1.setFont(new Font("Helvetica",Font.BOLD,22));
        l1.setBounds(170,30,200,30);
        add(l1);

        JLabel l2=new JLabel("Department");
        l2.setBounds(50,100,100,20);
        add(l2);

        c1=new Choice();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            while(rs.next()){
                c1.add(rs.getString("job"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        c1.setBounds(150,100,150,25);
        add(c1);

        t1=new JTable();
        t1.setBounds(0,200,500,300);
        add(t1);

        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(100,520,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(250,520,120,30);
        b2.addActionListener(this);
        add(b2);

        JLabel l11=new JLabel("Name");
        l11.setBounds(50,160,100,20);
        add(l11);

        JLabel l12=new JLabel("Department");
        l12.setBounds(150,160,100,20);
        add(l12);

        JLabel l13=new JLabel("Phone No");
        l13.setBounds(270,160,100,20);
        add(l13);

        JLabel l14=new JLabel("Email ID");
        l14.setBounds(390,160,100,20);
        add(l14);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(450,100,500,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try {
                String str1 = "select name,job,phone,email from employee where job='" + c1.getSelectedItem() + "'";
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
        new Department().setVisible(true);
    }
}

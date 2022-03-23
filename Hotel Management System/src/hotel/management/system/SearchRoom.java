package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JComboBox c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;

    SearchRoom(){

        JLabel l1=new JLabel("Search For Room");
        l1.setFont(new Font("Helvetica",Font.PLAIN,20));
        l1.setBounds(400,30,200,30);
        add(l1);

        JLabel l2=new JLabel("Room Bed Type");
        l2.setBounds(50,100,100,20);
        add(l2);

        c1=new JComboBox(new String[]{"Single Bed","Double Bed"});
        c1.setBounds(150,100,150,25);
        c1.setBackground(Color.white);
        add(c1);

        c2=new JCheckBox("Display Available");
        c2.setBackground(Color.white);
        c2.setBounds(650,100,150,25);
        add(c2);

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

        JLabel l11=new JLabel("Room Number");
        l11.setBounds(50,160,100,20);
        add(l11);

        JLabel l12=new JLabel("Availability");
        l12.setBounds(270,160,80,20);
        add(l12);

        JLabel l13=new JLabel("Status");
        l13.setBounds(450,160,80,20);
        add(l13);

        JLabel l14=new JLabel("Price");
        l14.setBounds(670,160,60,20);
        add(l14);

        JLabel l15=new JLabel("Bed Type");
        l15.setBounds(870,160,100,20);
        add(l15);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(380,100,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String str1="select * from room where bed_type='"+c1.getSelectedItem()+"'";
                String str2="select * from room where bed_type='"+c1.getSelectedItem()+"' and available='Available'";
                Conn c=new Conn();

                if(c2.isSelected()){
                    ResultSet rs2=c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                }else{
                    ResultSet rs=c.s.executeQuery(str1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new SearchRoom().setVisible(true);
    }
}

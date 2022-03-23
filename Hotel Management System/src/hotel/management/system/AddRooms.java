package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {

    JTextField t1,t2,t3;
    JComboBox c1,c2,c3;
    JButton b1,b2;

    AddRooms(){

        JLabel l1=new JLabel("Add Rooms");
        l1.setFont(new Font("Helvetica",Font.BOLD,20));
        l1.setBounds(150,20,200,20);
        add(l1);

        JLabel room=new JLabel("Room Number");
        room.setFont(new Font("Helvetica",Font.BOLD,16));
        room.setBounds(60,80,120,30);
        add(room);

        t1=new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);

        JLabel available=new JLabel("Available");
        available.setFont(new Font("Helvetica",Font.BOLD,16));
        available.setBounds(60,130,120,30);
        add(available);

        c1=new JComboBox(new String[] {"Available","Occupied"});
        c1.setBackground(Color.white);
        c1.setBounds(200,130,120,30);
        add(c1);

        JLabel status=new JLabel("Cleaning Status");
        status.setFont(new Font("Helvetica",Font.BOLD,16));
        status.setBounds(60,180,120,30);
        add(status);

        c2=new JComboBox(new String[] {"Clean","Unclean"});
        c2.setBackground(Color.white);
        c2.setBounds(200,180,120,30);
        add(c2);

        JLabel price=new JLabel("Price");
        price.setFont(new Font("Helvetica",Font.BOLD,16));
        price.setBounds(60,230,120,30);
        add(price);

        t2=new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);

        JLabel type=new JLabel("Bed Type");
        type.setFont(new Font("Helvetica",Font.BOLD,16));
        type.setBounds(60,280,120,30);
        add(type);

        c3=new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBackground(Color.white);
        c3.setBounds(200,280,120,30);
        add(c3);

        b1=new JButton("Add Room");
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,350,130,30);
        add(b1);

        b2=new JButton("Cancel");
        b2.addActionListener(this);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,350,130,30);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/four.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        i1=new ImageIcon(i2);
        JLabel l2=new JLabel(i1);
        l2.setBounds(400,70,250,250);
        add(l2);

        getContentPane().setBackground(Color.white);

        setBounds(450,200,700,500);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String room=t1.getText();
            String available=(String)c1.getSelectedItem();
            String status=(String)c2.getSelectedItem();
            String price=t2.getText();
            String type=(String)c3.getSelectedItem();

            Conn c=new Conn();

            String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";

            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddRooms().setVisible(true);
    }
}

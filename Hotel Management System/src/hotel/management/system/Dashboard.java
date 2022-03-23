package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;

    Dashboard(){
        mb=new JMenuBar();
        add(mb);

        ImageIcon bg=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/two.jpg"));
        Image bg2=bg.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT);
        ImageIcon bg3=new ImageIcon(bg2);
        JLabel l1=new JLabel(bg3);
        l1.setBounds(0,0,1920,1080);
        add(l1);

        JLabel l2=new JLabel("XXX Group of Hotels Welcomes You");
        l2.setBounds(400,70,1000,100);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Helvetica",Font.ITALIC,50));
        l1.add(l2);

        m1=new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.red);
        mb.add(m1);

        m2=new JMenu("ADMIN");
        m2.setForeground(Color.blue);
        mb.add(m2);

        i1=new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);

        i2=new JMenuItem("Add Employee");
        i2.addActionListener(this);
        m2.add(i2);

        i3=new JMenuItem("Add Rooms");
        i3.addActionListener(this);
        m2.add(i3);

        i4=new JMenuItem("Add Drivers");
        i4.addActionListener(this);
        m2.add(i4);

        mb.setBounds(0,0,1920,40);

        setLayout(null);
        setBounds(0,0,1920,1080);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Reception")){
            new Reception().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Employee")){
            new AddEmployee().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms().setVisible(true);
        }else if(ae.getActionCommand().equals("Add Drivers")){
            new AddDrivers().setVisible(true);
        }
    }

    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
}

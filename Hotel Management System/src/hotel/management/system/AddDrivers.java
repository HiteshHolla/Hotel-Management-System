package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;

    AddDrivers(){

        JLabel title=new JLabel("Add Drivers");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("Helvetica", Font.BOLD,18));
        add(title);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Helvetica", Font.PLAIN,14));
        name.setBounds(60,70,100,30);
        add(name);

        t1=new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);

        JLabel age=new JLabel("Age");
        age.setFont(new Font("Helvetica", Font.PLAIN,14));
        age.setBounds(60,110,100,30);
        add(age);

        t2=new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Helvetica", Font.PLAIN,14));
        gender.setBounds(60,150,100,30);
        add(gender);

        c1=new JComboBox(new String[] {"Male","Female"});
        c1.setBackground(Color.white);
        c1.setBounds(200,150,150,30);
        add(c1);

        JLabel car=new JLabel("Car Company");
        car.setFont(new Font("Helvetica", Font.PLAIN,14));
        car.setBounds(60,190,100,30);
        add(car);

        t3=new JTextField();
        t3.setBounds(200,190,150,30);
        add(t3);

        JLabel model=new JLabel("Car Model");
        model.setFont(new Font("Helvetica", Font.PLAIN,14));
        model.setBounds(60,230,100,30);
        add(model);

        t4=new JTextField();
        t4.setBounds(200,230,150,30);
        add(t4);

        JLabel available=new JLabel("Available");
        available.setFont(new Font("Helvetica", Font.PLAIN,14));
        available.setBounds(60,270,100,30);
        add(available);

        c2=new JComboBox(new String[] {"Available","Busy"});
        c2.setBackground(Color.white);
        c2.setBounds(200,270,150,30);
        add(c2);

        JLabel location=new JLabel("Location");
        location.setFont(new Font("Helvetica", Font.PLAIN,14));
        location.setBounds(60,310,100,30);
        add(location);

        t5=new JTextField();
        t5.setBounds(200,310,150,30);
        add(t5);

        b1=new JButton("Add Driver");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,370,130,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(220,370,130,30);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/five.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT);
        i1=new ImageIcon(i2);
        JLabel l2=new JLabel(i1);
        l2.setBounds(400,70,350,300);
        add(l2);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(400,200,800,470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String name=t1.getText();
            String age=t2.getText();
            String gender=(String)c1.getSelectedItem();
            String company=t3.getText();
            String model=t4.getText();
            String available=(String)c2.getSelectedItem();
            String location=t5.getText();

            Conn c=new Conn();

            String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Driver Added");
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddDrivers().setVisible(true);
    }
}

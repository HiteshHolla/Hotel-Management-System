package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    //Variable Declarations global to use in all methods
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){ //Create Constructor

        l1=new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);

        l2=new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);

        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);

        b1=new JButton("Login");
        b1.setFocusPainted(false);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(40,120,120,30);
        b1.setFont(new Font("serif",Font.BOLD,20));
        b1.setBorder(BorderFactory.createLineBorder(Color.black));
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setFocusPainted(false);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(180,120,120,30);
        b2.setFont(new Font("serif",Font.BOLD,20));
        b2.setBorder(BorderFactory.createLineBorder(Color.black));
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/empIcon.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(350,-10,200,200);
        add(l3);

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(500,300,600,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String username=t1.getText();
            String password=t2.getText();
            Conn c=new Conn();

            String str="select * from login where username='"+username+"' and password='"+password+"'";
            try{
                ResultSet rs = c.s.executeQuery(str);

                if(rs.next()){
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }catch(Exception e){

            }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener{

    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;

    AddEmployee(){
        JLabel name=new JLabel("Name");
        name.setBounds(60,30,120,30);
        name.setForeground(Color.black);
        name.setFont(new Font("Helvetica",Font.PLAIN,17));
        add(name);

        t1=new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);

        JLabel age=new JLabel("Age");
        age.setFont(new Font("Helvetica",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);

        t2=new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Helvetica",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        add(gender);

        r1=new JRadioButton("Male");
        r1.setBackground(Color.white);
        r1.setFont(new Font("Helvetica",Font.PLAIN,12));
        r1.setBounds(200,130,70,30);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setFont(new Font("Helvetica",Font.PLAIN,12));
        r2.setBounds(270,130,70,30);
        add(r2);

        JLabel job=new JLabel("Job");
        job.setFont(new Font("Helvetica",Font.PLAIN,17));
        job.setBounds(60,180,120,30);
        add(job);

        String str[]={"Front Dest Clerk","Manager","Room Service","Porter","Waiter","Accountant","HouseKeeping","Kitchen Staff"};
        c1=new JComboBox(str);
        c1.setBackground(Color.white);
        c1.setBounds(200,180,150,30);
        add(c1);

        JLabel salary=new JLabel("Salary");
        salary.setFont(new Font("Helvetica",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        add(salary);

        t3=new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);

        JLabel phone=new JLabel("Phone No");
        phone.setFont(new Font("Helvetica",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        add(phone);

        t4=new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);

        JLabel aadhaar=new JLabel("Aadhaar No");
        aadhaar.setFont(new Font("Helvetica",Font.PLAIN,17));
        aadhaar.setBounds(60,330,120,30);
        add(aadhaar);

        t5=new JTextField();
        t5.setBounds(200,330,150,30);
        add(t5);

        JLabel email=new JLabel("Email ID");
        email.setFont(new Font("Helvetica",Font.PLAIN,17));
        email.setBounds(60,380,120,30);
        add(email);

        t6=new JTextField();
        t6.setBounds(200,380,150,30);
        add(t6);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/Images/three.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        i1=new ImageIcon(i2);
        JLabel l1=new JLabel(i1);
        l1.setBounds(400,80,300,300);
        add(l1);

        JLabel l2=new JLabel("Add Employee Details");
        l2.setForeground(Color.blue);
        l2.setBounds(420,30,400,30);
        l2.setFont(new Font("Helvetica",Font.PLAIN,28));
        add(l2);

        b1=new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(200,430,150,30);
        b1.addActionListener(this);
        add(b1);

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(400,150,750,550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String aadhaar=t5.getText();
        String email=t6.getText();
        String gender=null;

        if(r1.isSelected()){
            gender="Male";
        }
        else if(r2.isSelected()){
            gender="Female";
        }

        String job=(String)c1.getSelectedItem();

        Conn c=new Conn();

        String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhaar+"','"+email+"')";
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new AddEmployee().setVisible(true);
    }
}

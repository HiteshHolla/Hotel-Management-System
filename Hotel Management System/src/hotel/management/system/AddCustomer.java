package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JRadioButton r1,r2;
    JComboBox c1;
    Choice c2;

    AddCustomer(){
        JLabel l1=new JLabel("NEW CUSTOMER FORM");
        l1.setBounds(100,20,300,30);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Helvetica",Font.PLAIN,20));
        add(l1);

        JLabel id=new JLabel("ID");
        id.setBounds(35,80,100,20);
        add(id);

        c1=new JComboBox(new String[] {"Passport","Driving License","Aadhaar"});
        c1.setBackground(Color.white);
        c1.setBounds(200,80,150,25);
        add(c1);

        JLabel number=new JLabel("Number");
        number.setBounds(35,120,100,20);
        add(number);

        t1=new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);

        JLabel name=new JLabel("Name");
        name.setBounds(35,160,100,20);
        add(name);

        t2=new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(35,200,100,20);
        add(gender);

        r1=new JRadioButton("Male");
        r1.setBackground(Color.white);
        r1.setBounds(200,200,60,25);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setBounds(270,200,80,25);
        add(r2);

        JLabel country=new JLabel("Country");
        country.setBounds(35,240,100,20);
        add(country);

        t3=new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);

        JLabel room=new JLabel("Allocated Room No");
        room.setBounds(35,280,120,20);
        add(room);

        c2=new Choice();
        try{
            Conn c=new Conn();
            String str="select * from room where available='Available'";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room_number"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        c2.setBounds(200,280,150,25);
        add(c2);

        JLabel checkin=new JLabel("Checked In");
        checkin.setBounds(35,320,120,20);
        add(checkin);

        t4=new JTextField();
        t4.setBounds(200,320,150,25);
        add(t4);

        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(35,360,120,20);
        add(deposit);

        t5=new JTextField();
        t5.setBounds(200,360,150,25);
        add(t5);

        b1=new JButton("Add Customer");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(35,410,120,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(200,410,120,30);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(Color.white);


        setLayout(null);
        setBounds(500,200,440,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String id=(String)c1.getSelectedItem();
            String number=t1.getText();
            String name=t2.getText();
            String gender=null;

            if(r1.isSelected()) {
                gender = "Male";
            }else if(r2.isSelected()){
                gender="Female";
            }

            String country=t3.getText();
            String room=c2.getSelectedItem();
            String status=t4.getText();
            String deposit=t5.getText();

            String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
            String str2="update room set available='Occupied' where room_number='"+room+"'";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"New Customer Added");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new AddCustomer().setVisible(true);
    }
}

package Passport.src.UserDetails;

import Passport.src.UserDetails.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import javax.lang.model.element.Name;
import javax.swing.*;

public class Passport extends User_Array {

  class Create_user implements ActionListener {

    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
    Choice c1, c2, c3, c4, c5, c6, c7;
    JLabel Name, Apl, Emailid, Address, Age, Gender, DateofBirth, Marital_Status, AadhaarNo, PhoneNo, Username, Password, rePassword, renewal;
    JFrame f;
    JButton b1, b2;
    JCheckBox r1;

    Create_user() {
      f = new JFrame("GUI");

      Name = new JLabel("Name : ");
      Apl = new JLabel("Application ID : ");
      Emailid = new JLabel("Email ID : ");
      Address = new JLabel("Address : ");
      Age = new JLabel("Age : ");
      Gender = new JLabel("Gender : ");
      DateofBirth = new JLabel("Date Of Birth : ");
      Marital_Status = new JLabel("Marital Status : ");
      AadhaarNo = new JLabel("Aadhaar Number : ");
      PhoneNo = new JLabel("Phone Number : ");
      Username = new JLabel("Username : ");
      Password = new JLabel("Password : ");
      renewal = new JLabel("Renewal : ");
      rePassword = new JLabel("RePassword : ");
      r1 = new JCheckBox();

      t1 = new JTextField(18);
      t2 = new JTextField(5);
      t9 = new JTextField(10);
      t3 = new JTextField(25);
      t4 = new JTextField(10);
      t5 = new JTextField(30);
      t6 = new JTextField(10);
      t7 = new JTextField(10);
      t8 = new JTextField(10);
      b1 = new JButton("Upload");
      b2 = new JButton("Exit");
      c1 = new Choice();
      c2 = new Choice();
      c3 = new Choice();
      c4 = new Choice();
      c5 = new Choice();
      c6 = new Choice();
      c1.addItem("Select Age");
      for (int i = 1; i <= 90; i++) {
        c1.addItem(Integer.toString(i));
      }

      c2.addItem("Male");
      c2.addItem("Female");
      c3.addItem("Day");
      for (int i = 1; i <= 31; i++) {
        c3.addItem(Integer.toString(i));
      }
      c5.addItem("Year");
      for (int i = 1880; i <= 2021; i++) {
        c5.addItem(Integer.toString(i));
      }
      c4.addItem("Month");
      c4.addItem("January");
      c4.addItem("February");
      c4.addItem("March");
      c4.addItem("April");
      c4.addItem("May");
      c4.addItem("June");
      c4.addItem("July");
      c4.addItem("August");
      c4.addItem("September");
      c4.addItem("October");
      c4.addItem("November");
      c4.addItem("December");

      c6.addItem("Marital Status");
      c6.addItem("Single");
      c6.addItem("Married");

      b1.addActionListener(this);

      b2.addActionListener(this);

      f.add(Name);
      f.add(t1);
      f.add(Apl);
      f.add(t9);
      f.add(Age);
      f.add(c1);
      f.add(DateofBirth);
      f.add(c3);
      f.add(c4);
      f.add(c5);
      f.add(Gender);
      f.add(c2);
      f.add(Marital_Status);
      f.add(c6);
      f.add(AadhaarNo);
      f.add(t2);
      f.add(Emailid);
      f.add(t3);
      f.add(PhoneNo);
      f.add(t4);
      f.add(Address);
      f.add(t5);
      f.add(Username);
      f.add(t6);
      f.add(Password);
      f.add(t7);
      f.add(rePassword);
      f.add(t8);
      f.add(renewal);
      f.add(r1);
      f.add(b1);
      f.add(b2);

      f.setLayout(new FlowLayout());
      f.setSize(500, 500);
      f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
      //boolean Procced = false;
      if (e.getSource() == b1) {
        if (t1.getText().isEmpty()) JOptionPane.showMessageDialog(
          null,
          "Name is not Filled"
        );
        if (c1.getSelectedItem() == "Select Age") JOptionPane.showMessageDialog(
          null,
          "Age is not Filled"
        );
        if (
          c3.getSelectedItem() == "Date" &&
          c4.getSelectedItem().equals("Month") &&
          c5.getSelectedItem().equals("Year")
        ) JOptionPane.showMessageDialog(null, "Date of Birth is not Filled");
        if (c2.getSelectedItem() == "Gender") JOptionPane.showMessageDialog(
          null,
          "Gender is Not Filled"
        );
        if (
          c6.getSelectedItem() == "Marital Status"
        ) JOptionPane.showMessageDialog(null, "Marital Status Not Filled");
        if (t2.getText().isEmpty()) JOptionPane.showMessageDialog(
          null,
          "Aadhaar Number is Empty"
        );
        if (t3.getText().isEmpty()) JOptionPane.showMessageDialog(
          null,
          "Phone Number is Empty"
        );
        if (t4.getText().isEmpty()) JOptionPane.showMessageDialog(
          null,
          "Address is Empty"
        );
        if (t5.getText().isEmpty()) JOptionPane.showMessageDialog(
          null,
          "Username is Empty"
        );
        if (t6.getText().isEmpty()) JOptionPane.showMessageDialog(
          null,
          "Password is Empty"
        );
        if (t6.getText() == t7.getText()) {
          JOptionPane.showMessageDialog(null, "Password Not Matching Retry");
        }
      }

      try {
        Integer.parseInt(t2.getText());
        try {
          Integer.parseInt(t4.getText());
          Existing_User();
          User u = new User(
            t1.getText(),
            Integer.parseInt(t9.getText()),
            Integer.parseInt(c1.getSelectedItem()),
            Integer.parseInt(c3.getSelectedItem()),
            c4.getSelectedItem(),
            Integer.parseInt(c5.getSelectedItem()),
            c2.getSelectedItem(),
            c6.getSelectedItem(),
            Integer.parseInt(t2.getText()),
            t3.getText(),
            Integer.parseInt(t4.getText()),
            t5.getText(),
            t6.getText(),
            t7.getText()
          );
          User_Array.user.add(u);
          un.add(t6.getText());
          Au.put(t6.getText(), u);
          up.put(t6.getText(), t7.getText());
          if (r1.isSelected()) {
            ren.add(r1.isSelected());
          } else {
            ren.add(false);
          }
          JOptionPane.showMessageDialog(null, "Successfully Created");
        } catch (NumberFormatException a) {
          System.out.println("Phone Number can only be Number ");
        }
      } catch (NumberFormatException a) {
        System.out.println("Aadhaar Number Can Only be Numbers");
      }
      f.dispose();
      new Login();
      // new show_Created_user();

      if (e.getSource() == b2) {
        f.dispose();
      }
    }
  }

  class AcceptReject extends Passport implements ActionListener {

    JFrame f;
    JButton update, Logout;
    JLabel u1, u2, u3, u4, head;
    JRadioButton a1, a2, a3, a4, r1, r2, r3, r4;

    AcceptReject() {
      f = new JFrame();
      head = new JLabel("APPLICATION FORM");

      a1 = new JRadioButton("Accept");
      a2 = new JRadioButton("Accept");
      a3 = new JRadioButton("Accept");
      a4 = new JRadioButton("Accept");
      r1 = new JRadioButton("Reject");
      r2 = new JRadioButton("Reject");
      r3 = new JRadioButton("Reject");
      r4 = new JRadioButton("Reject");

      u1 =
        new JLabel(
          User_Array.user.get(0).ApplicationStatus + User_Array.user.get(0).Name
        );
      u2 =
        new JLabel(
          User_Array.user.get(1).ApplicationStatus + User_Array.user.get(1).Name
        );
      u3 =
        new JLabel(
          User_Array.user.get(2).ApplicationStatus + User_Array.user.get(2).Name
        );
      u4 =
        new JLabel(
          User_Array.user.get(3).ApplicationStatus + User_Array.user.get(3).Name
        );

      update = new JButton("Update");
      Logout = new JButton("Logout");
      update.addActionListener(this);
      Logout.addActionListener(this);

      f.add(head);
      f.add(u1);
      f.add(a1);
      f.add(r1);
      f.add(u2);
      f.add(a2);
      f.add(r2);
      f.add(u3);
      f.add(a3);
      f.add(r3);
      f.add(u4);
      f.add(a4);
      f.add(r4);
      f.add(update);
      f.add(Logout);

      f.setSize(1000, 600);
      f.setVisible(true);
      f.setLayout(new FlowLayout());
    }

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == update) {
        //f.dispose();
        JOptionPane.showMessageDialog(f, "Successfully Updated");
        //new Login();
      }
      if (e.getSource() == Logout) {
        f.dispose();
        JFrame fi = new JFrame();
        int a = JOptionPane.showConfirmDialog(fi, "Are you Sure ?");
        if (a == JOptionPane.NO_OPTION) {
          fi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          new Login();
        }
      }
    }
  }

  public static void Existing_User() {
    User poi = new User(
      "Thanuj",
      1,
      18,
      22,
      "April",
      2003,
      "Male",
      "Single",
      123,
      "Raghavgmail.com",
      9874135,
      "fghjlkd",
      "123",
      "123"
    );
    ren.add(true);
    User_Array.user.add(poi);
    un.add("123");
    Au.put("123", poi);
    up.put("123", "123");
    User p0 = new User(
      "Yara",
      25,
      19,
      32,
      "June",
      1984,
      "Male",
      "Married",
      123,
      "Gonmand@gmail.com",
      314784561,
      "John Road, Fifth street , LA 02",
      "321",
      "321"
    );
    un.add("321");
    User_Array.user.add(p0);
    Au.put("321", p0);
    ren.add(true);
    up.put("321", "321");
    User p1 = new User(
      "Ramar",
      2,
      19,
      32,
      "June",
      1984,
      "Male",
      "Married",
      123,
      "Gonmand@gmail.com",
      314784561,
      "John Road, Fifth street , LA 02",
      "321abc",
      "321abc"
    );
    un.add("321abc");
    User_Array.user.add(p1);
    Au.put("321abc", p1);
    up.put("321abc", "321abc");
    ren.add(false);
    User p2 = new User(
      "Pranav",
      3,
      19,
      32,
      "June",
      1984,
      "Male",
      "Married",
      123,
      "Gonmand@gmail.com",
      314784561,
      "John Road, Fifth street , LA 02",
      "abc",
      "abc"
    );
    un.add("abc");
    User_Array.user.add(p2);
    Au.put("abc", p2);
    up.put("abc", "abc");
    ren.add(true);
  }

  public static class Login extends Passport implements ActionListener {

    JFrame f;
    JLabel l1;
    JButton b1, b2, b3, b4;

    Login() {
      f = new JFrame();
      l1 = new JLabel("Login");
      b1 = new JButton("Admin");
      b2 = new JButton("User");
      b3 = new JButton("Create User");
      b4 = new JButton("Exit");
      f.add(l1);
      f.add(b1);
      f.add(b2);
      f.add(b3);
      f.add(b4);
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      b4.addActionListener(this);
      f.setSize(1000, 600);
      f.setLayout(new FlowLayout());
      f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == b1) {
        f.dispose();
        new AdminLogin();
      }
      if (e.getSource() == b2) {
        f.dispose();
        new UserLogin();
      }
      if (e.getSource() == b3) {
        new Passport.Create_user();
        f.dispose();
      }
      if (e.getSource() == b4) {
        f.dispose();
      }
    }
  }

  class AdminLogin extends Passport implements ActionListener {

    JFrame f;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4;
    JTextField t1, t3;
    JPasswordField t2;
    JPanel contentPane;
    JLabel lblAdminLoginForm 

    AdminLogin() {
      f = new JFrame();
      l1 = new JLabel("USERNAME ");
      t1 = new JTextField(5);
      l2 = new JLabel("PASSWORD ");
      t2 = new JPasswordField(3);
      b1 = new JButton("Login");
      b2 = new JButton("Exit");
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      f.setContentPane(contentPane);
      lblAdminLoginForm = new JLabel("Admin Login Form");
      lblAdminLoginForm.setForeground(Color.GRAY);
      lblAdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));

      b1.addActionListener(this);
      b2.addActionListener(this);

      f.add(l1);
      f.add(t1);
      f.add(l2);
      f.add(t2);
      f.add(b1);
      f.add(b2);
      f.setSize(1000, 600);
      f.setVisible(true);
      f.setLayout(new FlowLayout());
    }

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == b1) {
        String password = new String(t2.getPassword());
        if ((t1.getText()).equals("admin") & password.equals("123")) {
          f.dispose();
          new Passport.AcceptReject();
        }
      }
      if (e.getSource() == b2) {
        f.dispose();
        new Login();
      }
    }
  }

  class UserLogin implements ActionListener {

    JFrame f;
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4;
    JTextField t1, t3;
    JPasswordField t2;
    int Index;

    UserLogin() {
      f = new JFrame();
      l1 = new JLabel("USERNAME ");
      t1 = new JTextField(5);
      l2 = new JLabel("PASSWORD ");
      l3 = new JLabel(User_Array.user.get(1).username);
      t2 = new JPasswordField(3);
      b1 = new JButton("Login");
      b2 = new JButton("Exit");

      b1.addActionListener(this);
      b2.addActionListener(this);

      f.add(l1);
      f.add(t1);
      f.add(l2);
      f.add(t2);
      f.add(b1);
      f.add(l3);
      f.add(b2);
      f.setSize(1000, 600);
      f.setVisible(true);
      f.setLayout(new FlowLayout());
    }

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == b1) {
        String password = new String(t2.getPassword());
        String un = new String(t1.getText());

        if (
          User_Array.Au.containsKey(un) &&
          User_Array.up.containsKey(un) &&
          User_Array.up.containsValue(password)
        ) {
          int index = User_Array.un.indexOf(un);
          index = Index;
          System.out.println(
            "lOGEDIN sUCCESSFULL " +
            User_Array.un.indexOf(un) +
            "  " +
            User_Array.user.get(index) +
            " " +
            User_Array.user.get(index).Name
          );

          new Renewal();
        }
      }

      if (e.getSource() == b2) {
        f.dispose();
        new Login();
      }
    }

    class Renewal implements ActionListener {

      JFrame f;
      JLabel l1, l2, l3, l4, l5, l6, name;
      JCheckBox c1, c2, c3, c4, c5;
      JButton b1, b2, b3, b4, b5;

      JComboBox reasons, chandet;

      Renewal() {
        f = new JFrame();
        name = new JLabel(User_Array.user.get(Index).Name + " Logged In");
        b1 = new JButton("Update");
        b2 = new JButton("Back");
        l1 = new JLabel("Applying for : ");
        l2 = new JLabel("if Re-issue, Specify reasons : ");
        l3 =
          new JLabel(
            "If change in existing Personal Particulars, specify reason(s)"
          );
        c1 = new JCheckBox("Fresh Passport");
        c2 = new JCheckBox("Re-issue of Passport");

        String[] r = {
          "Choose",
          "Validity Expired within 3 years/Due to Expire",
          "Validity Expired more than 3 years ago",
          "Change in Existing Personal Particulars",
          "Exhaustion of Pages",
          "Lost Passport",
          "Damaged Passport",
        };
        reasons = new JComboBox<>(r);
        String[] p = {
          "None",
          "Appearance",
          "Signature",
          "Name",
          "Surname",
          "Date of Birth",
          "Address",
          "None",
        };
        chandet = new JComboBox<>(p);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.add(name);
        f.add(l1);
        f.add(c1);
        f.add(c2);
        f.add(l2);
        f.add(reasons);
        f.add(l3);
        f.add(chandet);
        f.add(b1);
        f.add(b2);
        f.setSize(1000, 600);
        f.setVisible(true);
        f.setLayout(new FlowLayout());
      }

      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
          if (c2.isSelected()) {
            String successfull =
              "\n Successfully Updated . We will contact you later. Thankyou";
            if (chandet.getSelectedItem() != "None") {
              String changed =
                "Changes will be applied to Your new Passport.\n";
              JOptionPane.showMessageDialog(null, changed + successfull);
            }
          }
        }
        if (e.getSource() == b2) {
          f.dispose();
          new Login();
        }
      }
    }
  }

  public static void main(String[] args) {
    Existing_User();
    new Login();
  }
}

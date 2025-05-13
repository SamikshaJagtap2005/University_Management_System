/*package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {
    
    String rollno;
    JButton cancel;
    
    Marks(String rollno) {
        this.rollno = rollno;
        
        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Delhi Technical Univeristy");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);
        
        JLabel lblrollno = new JLabel("Roll Number  -   " + rollno);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);
        
        try {
            Conn c = new Conn();
            
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while(rs1.next()) {
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while(rs2.next()) {
                sub1.setText(sub1.getText() + "     ------------    " + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "   ------------   " + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "   ------------   " + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "   ------------   " + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "    ------------   " + rs2.getString("marks5"));
                lblsemester.setText("Semester   -   " + rs2.getString("semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new Marks("");
    }
}*/
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {

    String rollno;
    JButton cancel;
    JTable table;

    Marks(String rollno) {
        this.rollno = rollno;

        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Delhi Technical University");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number  -   " + rollno);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60, 130, 500, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsemester);

        // Table column headers
        String[] columns = {"Subject", "Marks"};
        // Data array for subjects and marks (6 rows: 1 header + 5 data rows)
        String[][] data = new String[6][2];

        // Set the header row
        data[0][0] = "Subject";
        data[0][1] = "Marks";

        try {
            Conn c = new Conn();

            // Fetch subjects for the student
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '" + rollno + "'");
            if (rs1.next()) {
                data[1][0] = rs1.getString("subject1");
                data[2][0] = rs1.getString("subject2");
                data[3][0] = rs1.getString("subject3");
                data[4][0] = rs1.getString("subject4");
                data[5][0] = rs1.getString("subject5");
            }

            // Fetch marks for the student
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '" + rollno + "'");
            if (rs2.next()) {
                data[1][1] = rs2.getString("marks1");
                data[2][1] = rs2.getString("marks2");
                data[3][1] = rs2.getString("marks3");
                data[4][1] = rs2.getString("marks4");
                data[5][1] = rs2.getString("marks5");
                lblsemester.setText("Semester   -   " + rs2.getString("semester"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the table with subject and marks data
        table = new JTable(data, columns);
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.setRowHeight(30); // Set the row height
        table.setEnabled(false); // Disable editing

        // Set table bounds to fit 6 rows directly without scroll
        table.setBounds(50, 180, 400, 200); // Adjusted for 6 rows (1 header + 5 data)
        add(table);

        // Back button to go back to the previous window
        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false); // Close the current window
    }

    public static void main(String[] args) {
        new Marks("");
    }
}

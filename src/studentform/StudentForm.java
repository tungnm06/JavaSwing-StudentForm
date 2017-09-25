/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentform;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Administrator
 */
public class StudentForm extends JFrame {

    private JLabel lblIdstudent;
    private JLabel lblName;
    private JLabel lblPhone;
    private JLabel lblBirthday;
    private JLabel lblEmail;
    private JLabel lblClassname;
    private JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtBirthday;
    private JTextField txtIdstudent;
    private JTextField txtEmail;
    private JTextField txtClassname;
    private JButton btnSubmit;
    private JPanel panel;
    private JFormattedTextField phoneField;
    private JFormattedTextField birthdayField;
    private ActionListener ActionListener;

    public StudentForm() throws ParseException {
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);

        this.lblIdstudent = new JLabel("Id Student ");
        this.lblName = new JLabel("Name ");
        this.lblClassname = new JLabel("Class Name ");
        this.lblPhone = new JLabel("Phone ");
        this.lblBirthday = new JLabel("Birthday ");
        this.lblEmail = new JLabel("Email ");
        this.txtIdstudent = new JTextField();
        this.txtEmail = new JTextField();
        this.txtName = new JTextField();
        this.txtClassname = new JTextField();
        this.txtPhone = new JTextField();
        this.txtBirthday = new JTextField();
        this.btnSubmit = new JButton("Submit");
        this.panel = new JPanel();
        this.panel.setBounds(100, 30, 600, 300);
        this.panel.setVisible(true);
        this.panel.setLayout(null);
        this.panel.setBackground(Color.lightGray);

        this.lblIdstudent.setBounds(50, 10, 150, 40);
        this.lblName.setBounds(50, 50, 150, 40);
        this.lblClassname.setBounds(50, 90, 150, 40);
        this.lblPhone.setBounds(50, 130, 150, 40);
        this.lblBirthday.setBounds(50, 170, 150, 40);
        this.lblEmail.setBounds(50, 210, 150, 40);

        this.txtIdstudent.setBounds(200, 20, 200, 20);
        this.txtName.setBounds(200, 60, 200, 20);
        this.txtClassname.setBounds(200, 100, 200, 20);
//        this.txtPhone.setBounds(200, 140, 200, 20);
//        this.txtBirthday.setBounds(200, 180, 200, 20);
        this.txtEmail.setBounds(200, 220, 200, 20);

        this.btnSubmit.setBounds(250, 255, 100, 30);
        this.btnSubmit.addActionListener(new btnSubmitHandle());
        this.phoneField = new JFormattedTextField(new MaskFormatter("+84##########"));
        this.phoneField.setBounds(200, 140, 200, 20);
        panel.add(phoneField);

        this.birthdayField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        this.birthdayField.setBounds(200, 180, 200, 20);

        panel.add(birthdayField);

        panel.add(lblIdstudent);
        panel.add(lblName);
        panel.add(lblBirthday);
        panel.add(lblPhone);
        panel.add(lblEmail);
        panel.add(lblClassname);
        panel.add(txtIdstudent);
        panel.add(txtName);
        panel.add(txtEmail);
        panel.add(txtBirthday);
        panel.add(txtPhone);
        panel.add(txtClassname);
        panel.add(btnSubmit);
        this.add(panel);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class btnSubmitHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            int i = StudentForm.showConfirmDialog(this,"Do you want to insert this record into database?","Comfirm Dialog Demo",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
//			if (i==0)  // neu nguoi dung chon "Yes"
            int i;
            i = JOptionPane.showConfirmDialog(null, "Sub thành công tài khoản :" + txtName.getText() + "Id :" + txtIdstudent.getText() + "Phone :" + phoneField.getText() + "Birthday :" + birthdayField.getText(), "Comfirm Dialog Demo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (i == 0) // neu nguoi dung chon "Yes"
            {

                JOptionPane.showMessageDialog(null, "Thành Công", "Message Dialog Demo", JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }

    public static void main(String[] args) throws ParseException {
        StudentForm studentForm = new StudentForm();
        studentForm.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                studentForm.setTitle("                                                                                                                                                                 "
                        + "Thời gian : " + dateFormat.format(date));
            }
        });
        timer.start();
    }

}

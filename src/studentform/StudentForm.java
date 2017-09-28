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
import java.util.HashMap;
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
    private JLabel lblTotalMesseage;
    private JLabel lblIdMesseage;
    private JLabel lblMailMesseage;
    private JLabel lblNameMesseage;
    private JLabel lblPhonetMesseage;
    private JLabel lblClassnameMesseage;
    private JLabel lblBirthdayMesseage;

    public StudentForm() throws ParseException {
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);

        this.lblIdstudent = new JLabel("Id Student ");
        this.lblName = new JLabel("Name ");
        this.lblClassname = new JLabel("Class Name ");
        this.lblPhone = new JLabel("Phone ");
        this.lblBirthday = new JLabel("Birthday ");
        this.lblEmail = new JLabel("Email ");

        this.lblTotalMesseage = new JLabel();
        this.lblIdMesseage = new JLabel();
        this.lblMailMesseage = new JLabel();
        this.lblNameMesseage = new JLabel();
        this.lblPhonetMesseage = new JLabel();
        this.lblClassnameMesseage = new JLabel();
        this.lblBirthdayMesseage = new JLabel();

        this.txtIdstudent = new JTextField();
        this.txtEmail = new JTextField();
        this.txtName = new JTextField();
        this.txtClassname = new JTextField();
        this.txtPhone = new JTextField();
        this.txtBirthday = new JTextField();
        this.btnSubmit = new JButton("Submit");
        this.panel = new JPanel();
        this.panel.setBounds(100, 30, 800, 400);
        this.panel.setVisible(true);
        this.panel.setLayout(null);
        this.panel.setBackground(Color.lightGray);

        this.lblTotalMesseage.setBounds(50, 290, 300, 40);
        this.lblIdMesseage.setBounds(360, 10, 300, 40);
        this.lblMailMesseage.setBounds(360, 210, 300, 40);
        this.lblNameMesseage.setBounds(360, 50, 300, 40);
        this.lblPhonetMesseage.setBounds(360, 130, 300, 40);
        this.lblClassnameMesseage.setBounds(360, 90, 300, 40);
        this.lblBirthdayMesseage.setBounds(360, 170, 300, 40);

        this.lblIdstudent.setBounds(50, 10, 100, 40);
        this.lblName.setBounds(50, 50, 100, 40);
        this.lblClassname.setBounds(50, 90, 100, 40);
        this.lblPhone.setBounds(50, 130, 100, 40);
        this.lblBirthday.setBounds(50, 170, 100, 40);
        this.lblEmail.setBounds(50, 210, 100, 40);

        this.txtIdstudent.setBounds(150, 20, 200, 20);
        this.txtName.setBounds(150, 60, 200, 20);
        this.txtClassname.setBounds(150, 100, 200, 20);
//        this.txtPhone.setBounds(200, 140, 200, 20);
//        this.txtBirthday.setBounds(200, 180, 200, 20);
        this.txtEmail.setBounds(150, 220, 200, 20);

        this.btnSubmit.setBounds(250, 255, 100, 30);
        this.btnSubmit.addActionListener(new btnSubmitHandle());
        this.phoneField = new JFormattedTextField(new MaskFormatter("+84##########"));
        this.phoneField.setBounds(150, 140, 200, 20);
        panel.add(phoneField);

        this.birthdayField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        this.birthdayField.setBounds(150, 180, 200, 20);

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

        panel.add(lblBirthdayMesseage);
        panel.add(lblTotalMesseage);
        panel.add(lblClassnameMesseage);
        panel.add(lblIdMesseage);
        panel.add(lblPhonetMesseage);
        panel.add(lblMailMesseage);
        panel.add(lblNameMesseage);
        this.add(panel);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class btnSubmitHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = txtName.getText();
            String phone = phoneField.getText();
            String mail = txtEmail.getText();
            String id = txtIdstudent.getText();
            String classname = txtClassname.getText();
            String birthday = birthdayField.getText();
            HashMap<String, String> erros = new StudentHandle().validateLogin(name, phone, mail, id, classname, birthday);
            if (erros.size() == 0) {

                resetMessage();

                
            } else {
                showError(erros);
            }
//            int i;
//            i = JOptionPane.showConfirmDialog(null, "Sub thành công tài khoản :" + txtName.getText() + "Id :" + txtIdstudent.getText() + "Phone :" + phoneField.getText() + "Birthday :" + birthdayField.getText(), "Comfirm Dialog Demo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//            if (i == 0) // neu nguoi dung chon "Yes"
//            {
//
//                JOptionPane.showMessageDialog(null, "Thành Công", "Message Dialog Demo", JOptionPane.INFORMATION_MESSAGE);
//            }
        }

    }
//

    public void resetMessage() {
        lblTotalMesseage.setText("");
        lblBirthdayMesseage.setText("");
        lblPhonetMesseage.setText("");
        lblClassnameMesseage.setText("");
        lblIdMesseage.setText("");
        lblMailMesseage.setText("");
        lblNameMesseage.setText("");
    }

    public void showError(HashMap<String, String> erros) {
        lblTotalMesseage.setForeground(Color.red);
        lblTotalMesseage.setText("Vui long sua thong tin");
        if (erros.containsKey("txtId")) {

            lblIdMesseage.setForeground(Color.red);
            lblIdMesseage.setText(erros.get("txtId"));

        } else {
            lblIdMesseage.setForeground(Color.green);
            lblIdMesseage.setText("hop le");
        }
        if (erros.containsKey("txtName")) {

            lblNameMesseage.setForeground(Color.red);
            lblNameMesseage.setText(erros.get("txtName"));

        } else {
            lblNameMesseage.setForeground(Color.green);
            lblNameMesseage.setText("hop le");
        }
        if (erros.containsKey("txtMail")) {

            lblMailMesseage.setForeground(Color.red);
            lblMailMesseage.setText(erros.get("txtMail"));

        } else {
            lblMailMesseage.setForeground(Color.green);
            lblMailMesseage.setText("hop le");
        }

        if (erros.containsKey("txtPhone")) {

            lblPhonetMesseage.setForeground(Color.red);
            lblPhonetMesseage.setText(erros.get("txtPhone"));

        } else {
            lblPhonetMesseage.setForeground(Color.green);
            lblPhonetMesseage.setText("Mời bạn kiểm tra lại SDT");
        }
        if (erros.containsKey("txtClassname")) {

            lblClassnameMesseage.setForeground(Color.red);
            lblClassnameMesseage.setText(erros.get("txtClassname"));

        } else {
            lblClassnameMesseage.setForeground(Color.green);
            lblClassnameMesseage.setText("hop le");
        }
          if (erros.containsKey("txtBirthday")) {

            lblBirthdayMesseage.setForeground(Color.red);
            lblBirthdayMesseage.setText(erros.get("txtBirthday"));

        } else {
            lblBirthdayMesseage.setForeground(Color.green);
            lblBirthdayMesseage.setText("hop le");
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

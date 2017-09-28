/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentform;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class StudentHandle {

    public HashMap<String, String> validateLogin(String name, String phone, String mail, String id, String classname, String birthday) {

        HashMap<String, String> erros = new HashMap<>();

        if (id.isEmpty()) {
            erros.put("txtId", "Id không được để trống");
        }
        if (name.length() < 6) {
            erros.put("txtName", "* Tên phải đủ 6 kí tự.");
        }
        if (phone.isEmpty()) {
            erros.put("txtPhone", "Vui lòng nhập lại SDT đúng định dạng");
        }
        if (birthday.isEmpty()) {
            erros.put("txtBirthday", "Vui lòng nhập lại birthday đúng định dạng");
        }
        if (mail.isEmpty()) {
            erros.put("txtMail", "Email không được để trống");

        }
        if (classname.isEmpty()) {
            erros.put("txtClassname", "Classname không được để trống");
        }

        return erros;

    }
}

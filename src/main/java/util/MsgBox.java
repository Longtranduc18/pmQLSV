/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MsgBox {

    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "IOCare thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
public static void alertcd(Component parent, String message) {
    JOptionPane.showOptionDialog(
        parent,
        message,
        "IOCare thông báo",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        new Object[]{"Đóng"},
        "Đóng");
}

    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, "IOCare thông báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message, "IOCare thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
}

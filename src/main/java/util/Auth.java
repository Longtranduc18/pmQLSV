/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.NhanSu;

/**
 *
 * @author Admin
 */
public class Auth {
     public static NhanSu user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }
    
     /**
     * Kiểm tra xem có phải là trưởng phòng hay không
     */
//    public static boolean isManager() {
//        return Auth.isLogin() && user.getVaiTro();
//    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class ChamSocTamThoi {

    private String loaiChienDich;
    private String DienGiaiCT;
    private String lyDoGhiNhan;
    private String doiTuong;
    private String phanLoaiNguyCo;
    private String nuyenVongSvPh;
    private boolean checkLuu;
    private boolean check;

    public ChamSocTamThoi() {
        this.check = false;
        this.checkLuu =true;
    }

    public ChamSocTamThoi(boolean checkLuu, boolean check) {
        this.checkLuu = checkLuu;
        this.check = check;
    }
    

    public ChamSocTamThoi(String loaiChienDich, String DienGiaiCT, String lyDoGhiNhan, String doiTuong, String phanLoaiNguyCo, String nuyenVongSvPh, boolean check) {
        this.loaiChienDich = loaiChienDich;
        this.DienGiaiCT = DienGiaiCT;
        this.lyDoGhiNhan = lyDoGhiNhan;
        this.doiTuong = doiTuong;
        this.phanLoaiNguyCo = phanLoaiNguyCo;
        this.nuyenVongSvPh = nuyenVongSvPh;
        this.check = check;
    }

    public String getLoaiChienDich() {
        return loaiChienDich;
    }

    public void setLoaiChienDich(String loaiChienDich) {
        this.loaiChienDich = loaiChienDich;
    }

    public String getDienGiaiCT() {
        return DienGiaiCT;
    }

    public void setDienGiaiCT(String DienGiaiCT) {
        this.DienGiaiCT = DienGiaiCT;
    }

    public String getLyDoGhiNhan() {
        return lyDoGhiNhan;
    }

    public void setLyDoGhiNhan(String lyDoGhiNhan) {
        this.lyDoGhiNhan = lyDoGhiNhan;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public String getPhanLoaiNguyCo() {
        return phanLoaiNguyCo;
    }

    public void setPhanLoaiNguyCo(String phanLoaiNguyCo) {
        this.phanLoaiNguyCo = phanLoaiNguyCo;
    }

    public String getNuyenVongSvPh() {
        return nuyenVongSvPh;
    }

    public void setNuyenVongSvPh(String nuyenVongSvPh) {
        this.nuyenVongSvPh = nuyenVongSvPh;
    }

    public boolean isCheckLuu() {
        return checkLuu;
    }

    public void setCheckLuu(boolean checkLuu) {
        this.checkLuu = checkLuu;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

}

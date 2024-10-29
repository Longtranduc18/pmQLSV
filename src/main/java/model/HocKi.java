package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HocKi")
public class HocKi {

    @Id
    @Column(name = "maHocKi")
    private String maHocKi;

    @Column(name = "tenHocKi")
    private String tenHocKi;

    @Column(name = "thoiGianBatDau")
    private Date thoiGianBatDau;

    @Column(name = "thoiGianKetThuc")
    private Date thoiGianKetThuc;
 @Column(name = "STT")
 @GeneratedValue
    private int STT;
    // constructors, getters, setters

    public HocKi() {
    }

    public HocKi(String maHocKi) {
        this.maHocKi = maHocKi;
    }

    public String getMaHocKi() {
        return maHocKi;
    }

    public void setMaHocKi(String maHocKi) {
        this.maHocKi = maHocKi;
    }

    public String getTenHocKi() {
        return tenHocKi;
    }

    public void setTenHocKi(String tenHocKi) {
        this.tenHocKi = tenHocKi;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    
}

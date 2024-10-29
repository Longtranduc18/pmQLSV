package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DanhGiaHP")
public class DanhGiaHP implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maChienDichChuDong")
    private ChienDichCD chienDichCD;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mssv")
    private SinhVien sinhVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mans")
    private NhanSu nhanSu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maHocKi")
    private HocKi hocKi;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maChienDich")
    private ChienDich chienDich;

    @Column(name = "trangThai")
    private boolean trangThai;

    @Column(name = "trangThaiHP")
    private boolean trangThaiHP;

    @Column(name = "trangThaiBL")
    private boolean trangThaiBL;
    @Column(name = "hocPhi")
    private int hocPhi;
    @Column(name = "macn")
    private String macn;

    public DanhGiaHP() {

    }

    public DanhGiaHP(ChienDichCD chienDichCD, SinhVien sinhVien, NhanSu nhanSu, HocKi hocKi, ChienDich chienDich,
            boolean trangThai, boolean trangThaiHP, boolean trangThaiBL) {
        this.chienDichCD = chienDichCD;
        this.sinhVien = sinhVien;
        this.nhanSu = nhanSu;
        this.hocKi = hocKi;
        this.chienDich = chienDich;
        this.trangThai = trangThai;
        this.trangThaiHP = trangThaiHP;
        this.trangThaiBL = trangThaiBL;
    }

    public ChienDichCD getChienDichCD() {
        return chienDichCD;
    }

    public void setChienDichCD(ChienDichCD chienDichCD) {
        this.chienDichCD = chienDichCD;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public NhanSu getNhanSu() {
        return nhanSu;
    }

    public void setNhanSu(NhanSu nhanSu) {
        this.nhanSu = nhanSu;
    }

    public HocKi getHocKi() {
        return hocKi;
    }

    public void setHocKi(HocKi hocKi) {
        this.hocKi = hocKi;
    }

    public ChienDich getChienDich() {
        return chienDich;
    }

    public void setChienDich(ChienDich chienDich) {
        this.chienDich = chienDich;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isTrangThaiHP() {
        return trangThaiHP;
    }

    public void setTrangThaiHP(boolean trangThaiHP) {
        this.trangThaiHP = trangThaiHP;
    }

    public boolean isTrangThaiBL() {
        return trangThaiBL;
    }

    public void setTrangThaiBL(boolean trangThaiBL) {
        this.trangThaiBL = trangThaiBL;
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public String getMacn() {
        return macn;
    }

    public void setMacn(String macn) {
        this.macn = macn;
    }

}

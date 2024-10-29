package model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "DanhGiaEN")
public class DanhGiaEN implements Serializable {

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

    @Column(name = "maMon")
    private String maMon;
    @Column(name = "macn")
    private String macn;

    public DanhGiaEN() {

    }

    public DanhGiaEN(ChienDichCD chienDichCD, SinhVien sinhVien, NhanSu nhanSu, HocKi hocKi, ChienDich chienDich,
            String maMon) {
        this.chienDichCD = chienDichCD;
        this.sinhVien = sinhVien;
        this.nhanSu = nhanSu;
        this.hocKi = hocKi;
        this.chienDich = chienDich;
        this.maMon = maMon;
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

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getMacn() {
        return macn;
    }

    public void setMacn(String macn) {
        this.macn = macn;
    }

}

package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DanhGia1D3")
public class DanhGia1D3 implements Serializable {

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

    @Column(name = "nganh")
    private String nganh;

    @Column(name = "maMon")
    private String maMon;

    @Column(name = "tenMonHoc")
    private String tenMonHoc;

    @Column(name = "lop")
    private String lop;

    @Column(name = "block")
    private String block;

    @Column(name = "NgayBatDauLop")
    private Date ngayBatDauLop;

    @Column(name = "ngayKetThucLop")
    private Date ngayKetThucLop;

    @Column(name = "tenGV")
    private String tenGV;

    @Column(name = "tieuChi")
    private String tieuChi;

    @Column(name = "nhanXet")
    private String nhanXet;

    @Column(name = "thoiGian")
    private Date thoiGian;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "nhanXetChung", columnDefinition = "TEXT")
    private String nhanXetChung;
    @Column(name = "macn")
    private String macn;
    // constructors, getters and setters

    public DanhGia1D3() {

    }

    public DanhGia1D3(ChienDichCD chienDichCD, SinhVien sinhVien, NhanSu nhanSu, HocKi hocKi, ChienDich chienDich,
            String nganh, String maMon, String tenMonHoc, String lop, String block, Date ngayBatDauLop, Date ngayKetThucLop,
            String tenGV, String tieuChi, String nhanXet, Date thoiGian, String ghiChu, String nhanXetChung) {
        this.chienDichCD = chienDichCD;
        this.sinhVien = sinhVien;
        this.nhanSu = nhanSu;
        this.hocKi = hocKi;
        this.chienDich = chienDich;
        this.nganh = nganh;
        this.maMon = maMon;
        this.tenMonHoc = tenMonHoc;
        this.lop = lop;
        this.block = block;
        this.ngayBatDauLop = ngayBatDauLop;
        this.ngayKetThucLop = ngayKetThucLop;
        this.tenGV = tenGV;
        this.tieuChi = tieuChi;
        this.nhanXet = nhanXet;
        this.thoiGian = thoiGian;
        this.ghiChu = ghiChu;
        this.nhanXetChung = nhanXetChung;
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

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Date getNgayBatDauLop() {
        return ngayBatDauLop;
    }

    public void setNgayBatDauLop(Date ngayBatDauLop) {
        this.ngayBatDauLop = ngayBatDauLop;
    }

    public Date getNgayKetThucLop() {
        return ngayKetThucLop;
    }

    public void setNgayKetThucLop(Date ngayKetThucLop) {
        this.ngayKetThucLop = ngayKetThucLop;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getTieuChi() {
        return tieuChi;
    }

    public void setTieuChi(String tieuChi) {
        this.tieuChi = tieuChi;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNhanXetChung() {
        return nhanXetChung;
    }

    public void setNhanXetChung(String nhanXetChung) {
        this.nhanXetChung = nhanXetChung;
    }

    public String getMacn() {
        return macn;
    }

    public void setMacn(String macn) {
        this.macn = macn;
    }

}

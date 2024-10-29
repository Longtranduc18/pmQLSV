package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LichSuChamSoc1D3")
public class LichSuChamSoc1D3 implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maChienDichChuDong")
    private ChienDichCD chienDichCD;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maHocKi")
    private HocKi hocKi;

     @ManyToOne
    @JoinColumn(name = "maChienDich")
    private ChienDich chienDich;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mans")
    private NhanSu nhanSu;
    @Id
    @Column(name = "MSSV")
    private String MSSV;

    @Column(name = "nganh")
    private String nganh;

    @Column(name = "chuyenNganh")
    private String chuyenNganh;

    @Column(name = "maMon")
    private String maMon;

    @Column(name = "tenMonHoc")
    private String tenMonHoc;

    @Column(name = "lop")
    private String lop;

    @Column(name = "ngayBatDauLop")
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

    @Column(name = "nhanXetChung")
    private String nhanXetChung;

    @Column(name = "thoiGianCS")
    private Timestamp thoiGianCS;

    @Column(name = "lyDoGhiNhan")
    private String lyDoGhiNhan;

    @Column(name = "NguyenVongSvPh")
    private String NguyenVongSvPh;

    @Column(name = "doiTuong")
    private String doiTuong;

    @Column(name = "phanLoaiNguyCo")
    private String phanLoaiNguyCo;

    @Column(name = "DienGiaiCT")
    private String DienGiaiCT;

    @Column(name = "block")
    private String block;
    
//constructor, getters and setters
    public LichSuChamSoc1D3() {
    }

    public LichSuChamSoc1D3(ChienDich chienDich, NhanSu mans, java.util.Date thoiGianCS, String lyDoGhiNhan, String phanLoaiNguyCo, String DienGiaiCT) {
        this.chienDich = chienDich;
       this.nhanSu = mans;
        this.thoiGianCS = (Timestamp) thoiGianCS;
        this.lyDoGhiNhan = lyDoGhiNhan;
        this.phanLoaiNguyCo = phanLoaiNguyCo;
        this.DienGiaiCT = DienGiaiCT;
    }

    public LichSuChamSoc1D3(ChienDichCD chienDichCD, HocKi hocKi, ChienDich chienDich, NhanSu nhanSu, String MSSV, String nganh, String chuyenNganh, String maMon, String tenMonHoc, String lop, Date ngayBatDauLop, Date ngayKetThucLop, String tenGV, String tieuChi, String nhanXet, Date thoiGian, String ghiChu, String nhanXetChung, Timestamp thoiGianCS, String lyDoGhiNhan, String NguyenVongSvPh, String doiTuong, String phanLoaiNguyCo, String DienGiaiCT, String block) {
        this.chienDichCD = chienDichCD;
        this.hocKi = hocKi;
        this.chienDich = chienDich;
        this.nhanSu = nhanSu;
        this.MSSV = MSSV;
        this.nganh = nganh;
        this.chuyenNganh = chuyenNganh;
        this.maMon = maMon;
        this.tenMonHoc = tenMonHoc;
        this.lop = lop;
        this.ngayBatDauLop = ngayBatDauLop;
        this.ngayKetThucLop = ngayKetThucLop;
        this.tenGV = tenGV;
        this.tieuChi = tieuChi;
        this.nhanXet = nhanXet;
        this.thoiGian = thoiGian;
        this.ghiChu = ghiChu;
        this.nhanXetChung = nhanXetChung;
        this.thoiGianCS = thoiGianCS;
        this.lyDoGhiNhan = lyDoGhiNhan;
        this.NguyenVongSvPh = NguyenVongSvPh;
        this.doiTuong = doiTuong;
        this.phanLoaiNguyCo = phanLoaiNguyCo;
        this.DienGiaiCT = DienGiaiCT;
        this.block = block;
    }
    

    
    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

  
    

    public ChienDichCD getChienDichCD() {
        return chienDichCD;
    }

    public void setChienDichCD(ChienDichCD chienDichCD) {
        this.chienDichCD = chienDichCD;
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

    public NhanSu getNhanSu() {
        return nhanSu;
    }

    public void setNhanSu(NhanSu nhanSu) {
        this.nhanSu = nhanSu;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String mSSV) {
        MSSV = mSSV;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
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

    public Timestamp getThoiGianCS() {
        return thoiGianCS;
    }

    public void setThoiGianCS(Timestamp thoiGianCS) {
        this.thoiGianCS = thoiGianCS;
    }

    public String getLyDoGhiNhan() {
        return lyDoGhiNhan;
    }

    public void setLyDoGhiNhan(String lyDoGhiNhan) {
        this.lyDoGhiNhan = lyDoGhiNhan;
    }

    public String getNguyenVongSvPh() {
        return NguyenVongSvPh;
    }

    public void setNguyenVongSvPh(String nguyenVongSvPh) {
        NguyenVongSvPh = nguyenVongSvPh;
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

    public String getDienGiaiCT() {
        return DienGiaiCT;
    }

    public void setDienGiaiCT(String dienGiaiCT) {
        DienGiaiCT = dienGiaiCT;
    }
}

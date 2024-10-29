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
@Table(name = "LichSuChamSocHP")
public class LichSuChamSocHP implements Serializable {
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
	private String mssv;
	@Column(name = "chuyenNganh")
	private String chuyenNganh;

	@Column(name = "kyHoc")
	private int kyHoc;

	@Column(name = "trangThaiHP")
	private boolean trangThaiHP;

	@Column(name = "trangThaiBL")
	private boolean trangThaiBL;

	@Column(name = "trangThaiCS")
	private boolean trangThaiCS;

	@Column(name = "thoiGianCS")
	private Timestamp thoiGianCS;

	@Column(name = "lyDoGhiNhan")
	private String lyDoGhiNhan;

	@Column(name = "NguyenVongSvPh")
	private String nguyenVongSvPh;

	@Column(name = "doiTuong")
	private String doiTuong;

	@Column(name = "phanLoaiNguyCo")
	private String phanLoaiNguyCo;

	@Column(name = "DienGiaiCT")
	private String dienGiaiCT;

	public LichSuChamSocHP() {

	}

    public LichSuChamSocHP(ChienDichCD chienDichCD, HocKi hocKi, ChienDich chienDich, NhanSu nhanSu, String mssv, String chuyenNganh, int kyHoc, boolean trangThaiHP, boolean trangThaiBL, boolean trangThaiCS, Timestamp thoiGianCS, String lyDoGhiNhan, String nguyenVongSvPh, String doiTuong, String phanLoaiNguyCo, String dienGiaiCT) {
        this.chienDichCD = chienDichCD;
        this.hocKi = hocKi;
        this.chienDich = chienDich;
        this.nhanSu = nhanSu;
        this.mssv = mssv;
        this.chuyenNganh = chuyenNganh;
        this.kyHoc = kyHoc;
        this.trangThaiHP = trangThaiHP;
        this.trangThaiBL = trangThaiBL;
        this.trangThaiCS = trangThaiCS;
        this.thoiGianCS = thoiGianCS;
        this.lyDoGhiNhan = lyDoGhiNhan;
        this.nguyenVongSvPh = nguyenVongSvPh;
        this.doiTuong = doiTuong;
        this.phanLoaiNguyCo = phanLoaiNguyCo;
        this.dienGiaiCT = dienGiaiCT;
    }

    public LichSuChamSocHP(ChienDich chienDich, NhanSu nhanSu, java.util.Date thoiGianCS, String lyDoGhiNhan, String phanLoaiNguyCo, String dienGiaiCT) {
        this.chienDich = chienDich;
        this.nhanSu = nhanSu;
      this.thoiGianCS = (Timestamp) thoiGianCS;
        this.lyDoGhiNhan = lyDoGhiNhan;
        this.phanLoaiNguyCo = phanLoaiNguyCo;
        this.dienGiaiCT = dienGiaiCT;
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

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getKyHoc() {
		return kyHoc;
	}

	public void setKyHoc(int kyHoc) {
		this.kyHoc = kyHoc;
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

	public boolean isTrangThaiCS() {
		return trangThaiCS;
	}

	public void setTrangThaiCS(boolean trangThaiCS) {
		this.trangThaiCS = trangThaiCS;
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
		return nguyenVongSvPh;
	}

	public void setNguyenVongSvPh(String nguyenVongSvPh) {
		this.nguyenVongSvPh = nguyenVongSvPh;
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
		return dienGiaiCT;
	}

	public void setDienGiaiCT(String dienGiaiCT) {
		this.dienGiaiCT = dienGiaiCT;
	}

}
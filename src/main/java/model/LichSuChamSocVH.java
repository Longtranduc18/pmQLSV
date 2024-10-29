package model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "LichSuChamSocVH")
public class LichSuChamSocVH implements Serializable {
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

	@Column(name = "maMon")
	private String maMon;

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

	// constructors, getters, setters
	public LichSuChamSocVH() {

	}

	public LichSuChamSocVH(ChienDichCD chienDichCD, HocKi hocKi, ChienDich chienDich, NhanSu nhanSu, String mssv,
			String chuyenNganh, int kyHoc, String maMon, Timestamp thoiGianCS, String lyDoGhiNhan, String nguyenVongSvPh,
			String doiTuong, String phanLoaiNguyCo, String dienGiaiCT) {
		this.chienDichCD = chienDichCD;
		this.hocKi = hocKi;
		this.chienDich = chienDich;
		this.nhanSu = nhanSu;
		this.mssv = mssv;
		this.chuyenNganh = chuyenNganh;
		this.kyHoc = kyHoc;
		this.maMon = maMon;
		this.thoiGianCS = thoiGianCS;
		this.lyDoGhiNhan = lyDoGhiNhan;
		NguyenVongSvPh = nguyenVongSvPh;
		this.doiTuong = doiTuong;
		this.phanLoaiNguyCo = phanLoaiNguyCo;
		DienGiaiCT = dienGiaiCT;
	}

    public LichSuChamSocVH(ChienDich chienDich, NhanSu nhanSu, java.util.Date thoiGianCS, String lyDoGhiNhan, String phanLoaiNguyCo, String DienGiaiCT) {
        this.chienDich = chienDich;
        this.nhanSu = nhanSu;
        this.thoiGianCS = (Timestamp) thoiGianCS;
        this.lyDoGhiNhan = lyDoGhiNhan;
        this.phanLoaiNguyCo = phanLoaiNguyCo;
        this.DienGiaiCT = DienGiaiCT;
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

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
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

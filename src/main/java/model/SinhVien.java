package model;

import javax.persistence.*;

@Entity
@Table(name = "SinhVien")
public class SinhVien {

    @Id
    @Column(name = "mssv")
    private String mssv;
    @Column(name = "hoVaTen")
    private String hoVaTen;

    @Column(name = "khoi_Truong")
    private String khoiTruong;

    @Column(name = "KNHNN")
    private Double KNHNN;

    @Column(name = "KNHBD")
    private Double KNHBD;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "kiHocHT")
    private int kiHocHT;

    @Column(name = "nganhHoc")
    private String nganhHoc;

    @Column(name = "chuyenNganh")
    private String chuyenNganh;

    public SinhVien() {
    }

    public SinhVien(String mssv, String hoVaTen, String khoiTruong, Double KNHNN, Double KNHBD,
            String trangThai, int kiHocHT, String nganhHoc, String chuyenNganh) {
        this.mssv = mssv;
        this.hoVaTen = hoVaTen;
        this.khoiTruong = khoiTruong;
        this.KNHNN = KNHNN;
        this.KNHBD = KNHBD;
        this.trangThai = trangThai;
        this.kiHocHT = kiHocHT;
        this.nganhHoc = nganhHoc;
        this.chuyenNganh = chuyenNganh;
    }

    public SinhVien(String mssv, String chuyenNganh) {
		this.mssv = mssv;
		this.chuyenNganh = chuyenNganh;
	}

	// Getters and setters
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getKhoiTruong() {
        return khoiTruong;
    }

    public void setKhoiTruong(String khoiTruong) {
        this.khoiTruong = khoiTruong;
    }

    public Double getKNHNN() {
        return KNHNN;
    }

    public void setKNHNN(Double kNHNN) {
        KNHNN = kNHNN;
    }

    public Double getKNHBD() {
        return KNHBD;
    }

    public void setKNHBD(Double kNHBD) {
        KNHBD = kNHBD;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getKiHocHT() {
        return kiHocHT;
    }

    public void setKiHocHT(int kiHocHT) {
        this.kiHocHT = kiHocHT;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

}

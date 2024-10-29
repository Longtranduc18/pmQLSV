package model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ChienDichCD")
public class ChienDichCD {

    @Id
    @Column(name = "maChienDichChuDong")
    private String maChienDichChuDong;

    @Column(name = "tenChienDichCD")
    private String tenChienDichCD;

    @Column(name = "thoiGianTao")
    private Timestamp thoiGianTao;
    @Column(name = "trangThai")
    private boolean trangThai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mans")
    private NhanSu nhanSu;
    // constructor, getter, setter
   

   

    public ChienDichCD(String maChienDichChuDong) {
        this.maChienDichChuDong = maChienDichChuDong;
    }

    public ChienDichCD(String maChienDichChuDong, String tenChienDichCD, Timestamp thoiGianTao, boolean trangThai,
			NhanSu nhanSu) {
		
		this.maChienDichChuDong = maChienDichChuDong;
		this.tenChienDichCD = tenChienDichCD;
		this.thoiGianTao = thoiGianTao;
		this.trangThai = trangThai;
		this.nhanSu = nhanSu;
	}

	public ChienDichCD() {

    }

    public String getMaChienDichChuDong() {
        return maChienDichChuDong;
    }

    public void setMaChienDichChuDong(String maChienDichChuDong) {
        this.maChienDichChuDong = maChienDichChuDong;
    }

    public String getTenChienDichCD() {
        return tenChienDichCD;
    }

    public void setTenChienDichCD(String tenChienDichCD) {
        this.tenChienDichCD = tenChienDichCD;
    }

    public Timestamp getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Timestamp thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhanSu getNhanSu() {
		return nhanSu;
	}



	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}



	@Override
    public String toString() {
        return tenChienDichCD;
    }

}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NhanSu")
public class NhanSu {

    @Id
    @Column(name = "mans")
    private String mans;

    @Column(name = "hoVaten")
    private String hoVaten;

    @Column(name = "gioiTinh")
    private Boolean gioiTinh;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "email")
    private String email;

    @Column(name = "trangThai")
    private Boolean trangThai;
    @Column(name = "vaiTro")
    private int vaiTro;

    // constructors, getters, setters
    public NhanSu(String mans, String hoVaten, Boolean gioiTinh, String matKhau, String email, Boolean trangThai) {
        this.mans = mans;
        this.hoVaten = hoVaten;
        this.gioiTinh = gioiTinh;
        this.matKhau = matKhau;
        this.email = email;
        this.trangThai = trangThai;
    }

    public NhanSu(String mans) {
		
		this.mans = mans;
	}

	public NhanSu() {

    }

    public String getMans() {
        return mans;
    }

    public void setMans(String mans) {
        this.mans = mans;
    }

    public String getHoVaten() {
        return hoVaten;
    }

    public void setHoVaten(String hoVaten) {
        this.hoVaten = hoVaten;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }

}

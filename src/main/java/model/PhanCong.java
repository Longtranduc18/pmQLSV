package model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PhanCong")
public class PhanCong implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "mans", insertable = false, updatable = false)
	private NhanSu nhanSu;
	@Id
	@ManyToOne
	@JoinColumn(name = "maChienDich", insertable = false, updatable = false)
	private ChienDich chienDich;
	@Id
	@ManyToOne
	@JoinColumn(name = "maChuyenNganh", insertable = false, updatable = false)
	private ChuyenNganh chuyenNganh;

	// constructors, getters and setters
	public PhanCong() {

	}

    public PhanCong(NhanSu nhanSu, ChienDich chienDich, ChuyenNganh chuyenNganh) {
        this.nhanSu = nhanSu;
        this.chienDich = chienDich;
        this.chuyenNganh = chuyenNganh;
    }
        

	public PhanCong(NhanSu nhanSu, ChuyenNganh chuyenNganh) {
		this.nhanSu = nhanSu;
		this.chuyenNganh = chuyenNganh;
	}

	public NhanSu getNhanSu() {
		return nhanSu;
	}

	public void setNhanSu(NhanSu nhanSu) {
		this.nhanSu = nhanSu;
	}

	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public ChienDich getChienDich() {
		return chienDich;
	}

	public void setChienDich(ChienDich chienDich) {
		this.chienDich = chienDich;
	}

}

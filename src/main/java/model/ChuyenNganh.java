package model;
import javax.persistence.*;

@Entity
@Table(name = "ChuyenNganh")
public class ChuyenNganh {
    
    @Id
    @Column(name = "maChuyenNganh")
    private String maChuyenNganh;
    
    @Column(name = "tenChuyenNganh")
    private String tenChuyenNganh;
    // constructors, getters and setters
	public ChuyenNganh() {
		
	}
	public ChuyenNganh(String maChuyenNganh, String tenChuyenNganh) {
		this.maChuyenNganh = maChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
	}
	public String getMaChuyenNganh() {
		return maChuyenNganh;
	}
	public void setMaChuyenNganh(String maChuyenNganh) {
		this.maChuyenNganh = maChuyenNganh;
	}
	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}
	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}
	@Override
	public String toString() {
		return maChuyenNganh + " - " + tenChuyenNganh;
	}
	
	
}

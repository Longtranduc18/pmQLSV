package model;
import javax.persistence.*;

@Entity
@Table(name = "MonHoc")
public class MonHoc {
    
    @Id
    @Column(name = "maMonHoc")
    private String maMonHoc;
    
    @Column(name = "tenMonHoc")
    private String tenMonHoc;
    // constructors, getters and setters
	public MonHoc() {
		
	}
	public MonHoc(String maMonHoc, String tenMonHoc) {
		this.maMonHoc = maMonHoc;
		this.tenMonHoc = tenMonHoc;
	}
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	
	
    
  
    
}

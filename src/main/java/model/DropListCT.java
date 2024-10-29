package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DropListCT")
public class DropListCT implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "maLoaiDl")
	private DropList dropList;
	@Id
	@ManyToOne
	@JoinColumn(name = "maChienDich")
	private ChienDich chienDich;

	@Column(name = "xephang")
	private Integer xephang;
	@Id
	@Column(name = "NoiDung")
	private String noiDung;

	public DropListCT() {

	}

	public DropListCT(DropList dropList, ChienDich chienDich, int xephang, String noiDung) {

		this.dropList = dropList;
		this.chienDich = chienDich;
		this.xephang = xephang;
		this.noiDung = noiDung;
	}

    public DropListCT(DropList dropList, ChienDich chienDich, String noiDung) {
        this.dropList = dropList;
        this.chienDich = chienDich;
        this.noiDung = noiDung;
    }

	public DropList getDropList() {
		return dropList;
	}

	public void setDropList(DropList dropList) {
		this.dropList = dropList;
	}

	public ChienDich getChienDich() {
		return chienDich;
	}

	public void setChienDich(ChienDich chienDich) {
		this.chienDich = chienDich;
	}

	public Integer getXephang() {
		return xephang;
	}

	public void setXephang(Integer xephang) {
		this.xephang = xephang;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	// constructors, getters, setters
}
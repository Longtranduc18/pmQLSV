package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DropList")
public class DropList {

    @Id
    @Column(name = "maLoaiDl")
    private String maLoaiDl;

    @Column(name = "tenLoaiDl")
    private String tenLoaiDl;

    public DropList(String maLoaiDl, String tenLoaiDl) {

        this.maLoaiDl = maLoaiDl;
        this.tenLoaiDl = tenLoaiDl;
    }

    public DropList(String maLoaiDl) {
        this.maLoaiDl = maLoaiDl;
    }

    public DropList() {

    }

    public String getMaLoaiDl() {
        return maLoaiDl;
    }

    public void setMaLoaiDl(String maLoaiDl) {
        this.maLoaiDl = maLoaiDl;
    }

    public String getTenLoaiDl() {
        return tenLoaiDl;
    }

    public void setTenLoaiDl(String tenLoaiDl) {
        this.tenLoaiDl = tenLoaiDl;
    }

    // constructors, getters, setters
}

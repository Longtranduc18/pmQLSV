package model;

import javax.persistence.*;

@Entity
@Table(name = "ChienDich")
public class ChienDich {

    @Id
    @Column(name = "maChienDich")
    private String maChienDich;

    @Column(name = "tenChienDich")
    private String tenChienDich;

    // constructors, getters and setters
    public ChienDich() {

    }

    public ChienDich(String maChienDich) {
        this.maChienDich = maChienDich;
    }

    public ChienDich(String maChienDich, String tenChienDich) {
        this.maChienDich = maChienDich;
        this.tenChienDich = tenChienDich;
    }

    public String getMaChienDich() {
        return maChienDich;
    }

    public void setMaChienDich(String maChienDich) {
        this.maChienDich = maChienDich;
    }

    public String getTenChienDich() {
        return tenChienDich;
    }

    public void setTenChienDich(String tenChienDich) {
        this.tenChienDich = tenChienDich;
    }

}

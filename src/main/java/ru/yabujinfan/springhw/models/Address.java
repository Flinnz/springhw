package ru.yabujinfan.springhw.models;

import javax.persistence.*;

@Table(name="address")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Address(District district, String address) {
        this.district = district;
        this.address = address;
    }

    public Address() {
    }

    @Column(unique=true, name="address")
    private String address;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


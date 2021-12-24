package com.ivandelic.micro.csas;

import javax.persistence.*;

@Entity
public class Branch {
    @Id
    private Integer id;
    private String name;
    private String city;
    private String address;
    private String description;

    public Branch() {}

    public Branch(Integer id, String name, String city, String address, String description) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

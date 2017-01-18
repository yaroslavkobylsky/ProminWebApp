package com.promin_ism.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_Material_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "material_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "gost")
    private String gost;

    @Column(name = "sort")
    private String sort;

    @Column(name = "lastDate")
    private Date lastDate;

    @ManyToOne
    private MaterialType materilalType;

    @ManyToOne
    private User user;

    private String fullName;

    private String generateFullName(){
        this.fullName = name + " " + dimensions + " " + gost + "/" +  sort;
        return fullName;
    }

    public Material(String name, String dimensions, String gost, String sort) {
        this.name = name;
        this.dimensions = dimensions;
        this.gost = gost;
        this.sort = sort;
    }

    public Material() {
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.dimensions, this.sort, this.gost);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        else {
            if (obj instanceof Material){
                Material material = (Material)obj;
                return Objects.equal(this.name, material.name)
                && Objects.equal(this.dimensions, material.dimensions)
                && Objects.equal(this.sort, material.sort)
                && Objects.equal(this.gost, material.gost);
            }
            else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("dimensions", dimensions)
                .add("gost", gost)
                .add("sort", sort)
                .add("date", lastDate)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getGost() {
        return gost;
    }

    public void setGost(String gost) {
        this.gost = gost;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Date getDate() {
        return lastDate;
    }

    public void setDate(Date date) {
        this.lastDate = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MaterialType getMaterilalType() {
        return materilalType;
    }

    public void setMaterilalType(MaterialType materilalType) {
        this.materilalType = materilalType;
    }

    public String getFullName() {
        return generateFullName();
    }

}
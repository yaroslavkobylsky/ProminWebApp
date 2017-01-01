package com.promin_ism.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_Material_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
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
        int hashCode = 1;

        if(name != null){
            hashCode = hashCode*name.hashCode() + name.hashCode();
        }
        else {
            hashCode+=1;
        }

        if(dimensions != null){
            hashCode = hashCode*dimensions.hashCode() + dimensions.hashCode();
        }
        else {
            hashCode+= 2;
        }

        if(gost != null){
            hashCode = hashCode*gost.hashCode() + gost.hashCode();
        }
        else {
            hashCode+= 4;
        }

        if(sort != null){
            hashCode = hashCode*sort.hashCode() + sort.hashCode();
        }
        else {
            hashCode+= 8;
        }

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        else {
            if (obj instanceof Material){
                Material material = (Material)obj;
                if(name.equals(material.getName()) && dimensions.equals(material.getDimensions())
                        && gost.equals(material.getGost()) && sort.equals(material.getSort())){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        return "[Material: id=" + id + ", name=" + name + ", dimensions=" + dimensions + ", gost=" + gost + ", sort=" +
                sort + ", lastDate=" + lastDate.toLocaleString() + " ]";
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
package com.promin_ism.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Material")
public class Material {
    /*public static Long TYPE_ROUND_PIPE = new Long(1);
    public static Long TYPE_RECTANGULAR_PIPE = new Long(2);
    public static Long TYPE_CORNER = new Long(3);
    public static Long TYPE_SHEET = new Long(4);*/

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

    @Column(name = "type")
    private Long type;

    @Column(name = "lastDate")
    private Date date;

    @ManyToOne
    private MaterilalType materilalType;

    @ManyToOne
    private User user;

    private String fullName;

    private void generateFullName(){
        this.fullName = name + " " + dimensions + " " + gost + "/" +  sort;
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
                sort + ", lastDate=" + date.toLocaleString() + " ]";
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
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
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MaterilalType getMaterilalType() {
        return materilalType;
    }

    public void setMaterilalType(MaterilalType materilalType) {
        this.materilalType = materilalType;
    }
}
package com.promin_ism.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Part")
public class Part {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_Part_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descName")
    private String descName;

    @ManyToOne
    private Material material;

    @Column(name = "materialNormWeight")
    private BigDecimal materialNormWeight;

    @Column(name = "isPurchased")
    private Boolean isPurchased;

    @Column(name = "lastDate")
    private Date lastDate;

    @ManyToMany
    private List<ProductionMethod> productionMethods;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "[Part: id=" + id + " name=" + name + " norm=" + materialNormWeight + "]";
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        if (name != null){
            hashCode = hashCode*name.hashCode() + name.hashCode();
        }
        else{
            hashCode++;
        }

        if (descName != null){
            hashCode = hashCode*descName.hashCode() + descName.hashCode();
        }
        else{
            hashCode+=2;
        }

        if(material!=null){
            hashCode = hashCode*material.hashCode() + material.hashCode();
        }
        else {
            hashCode+=4;
        }

        if(materialNormWeight!=null){
            hashCode = hashCode*materialNormWeight.intValue() + materialNormWeight.hashCode();
        }
        else {
            hashCode+= 8;
        }

        if(isPurchased.booleanValue()){
            if(isPurchased.booleanValue()){
                hashCode++;
            }
        }
        else {
            hashCode+= 16;
        }

        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else {
            if(obj instanceof Part){
                Part part = (Part)obj;
                if(name.equals(part.getName()) && descName.equals(part.getDescName())){
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

    public Part() {
        this.lastDate = new Date();
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigDecimal getMaterialNormWeight() {
        return materialNormWeight;
    }

    public void setMaterialNormWeight(BigDecimal materialNormWeight) {
        this.materialNormWeight = materialNormWeight;
    }

    public Boolean getIsPurchased() {
        return isPurchased;
    }

    public void setIsPurchased(Boolean isPurchased) {
        this.isPurchased = isPurchased;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescName() {
        return descName;
    }

    public void setDescName(String descName) {
        this.descName = descName;
    }

    public Boolean getPurchased() {
        return isPurchased;
    }

    public void setPurchased(Boolean purchased) {
        isPurchased = purchased;
    }

    public List<ProductionMethod> getProductionMethod() {
        return productionMethods;
    }

    public void setProductionMethod(List<ProductionMethod> productionMethods) {
        this.productionMethods = productionMethods;
    }
}

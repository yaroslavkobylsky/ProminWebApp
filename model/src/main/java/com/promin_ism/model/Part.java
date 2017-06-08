package com.promin_ism.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

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
    @Column(name = "part_id")
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

    @ManyToMany(fetch = FetchType.EAGER)
    private List<ProductionMethod> productionMethods;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Drawing> drawings;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("desc name", descName)
                .add("norm weight", materialNormWeight)
                .add("is purchased", isPurchased)
                .add("date", lastDate)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.descName, this.isPurchased, this.materialNormWeight);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else {
            if(obj instanceof Part){
                Part part = (Part)obj;
                return Objects.equal(this.name, part.name)
                        && Objects.equal(this.descName, part.descName)
                        && Objects.equal(this.isPurchased, part.isPurchased)
                        && Objects.equal(this.materialNormWeight, part.materialNormWeight);
            }
            else {
                return false;
            }
        }
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

    public String getDescName() {
        return descName;
    }

    public void setDescName(String descName) {
        this.descName = descName;
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

    public void setIsPurchased(Boolean purchased) {
        isPurchased = purchased;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public List<ProductionMethod> getProductionMethods() {
        return productionMethods;
    }

    public void setProductionMethods(List<ProductionMethod> productionMethods) {
        this.productionMethods = productionMethods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

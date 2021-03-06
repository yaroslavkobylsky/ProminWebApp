package com.promin_ism.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "StandardPart")
public class StandardPart {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_StandardPart_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "standard_part_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gost")
    private String gost;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "additionalInfo")
    private String additionalInfo;

    @Column(name = "lastDate")
    private Date lastDate;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("gost", gost)
                .add("weight", weight)
                .add("info", additionalInfo)
                .add("date", lastDate)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.gost);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj instanceof StandardPart){
            StandardPart standardPart = (StandardPart)obj;
            return Objects.equal(this.name, standardPart.getName())
             && Objects.equal(this.gost, standardPart.gost);
        }
        else {
            return false;
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

    public String getGost() {
        return gost;
    }

    public void setGost(String gost) {
        this.gost = gost;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
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
}

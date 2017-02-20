package com.promin_ism.model.AssemblyUtility;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;

public class CadSpecificationEntry {
    private String format;
    private String zone;
    private Long position;
    private String name;
    private String descName;
    private BigDecimal numberOf;
    private String additional;

    public CadSpecificationEntry() {
    }

    public CadSpecificationEntry(String format, String zone, Long position, String name, String descName, BigDecimal numberOf, String additional) {
        this.format = format;
        this.zone = zone;
        this.position = position;
        this.name = name;
        this.descName = descName;
        this.numberOf = numberOf;
        this.additional = additional;
    }

    public CadSpecificationEntry(String name, String descName) {
        this.name = name;
        this.descName = descName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("format", format)
                .add("zone", zone)
                .add("position", position)
                .add("name", name)
                .add("descName", descName)
                .add("numberOf", numberOf)
                .add("additional", additional)
                .toString();
    }

    public CadSpecificationEntry(String descName) {
        this.descName = descName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
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

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public BigDecimal getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(BigDecimal numberOf) {
        this.numberOf = numberOf;
    }
}

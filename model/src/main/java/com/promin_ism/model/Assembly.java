package com.promin_ism.model;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "assembly")
public class Assembly {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_Assembly_ID", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "assembly_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descName")
    private String descName;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "assembly_assembly",
            joinColumns = @JoinColumn(name = "assembly_id"))
    @MapKeyJoinColumn(name = "assembly_embedded_id")
    @Column(name = "quantity", nullable = false)
    private Map<Assembly, Long> assemblies;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "assembly_part",
            joinColumns = @JoinColumn(name = "assembly_id"))
    @MapKeyJoinColumn(name = "part_id")
    @Column(name = "quantity", nullable = false)
    private Map<Part, Long> parts;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "assembly_standart_part",
            joinColumns = @JoinColumn(name = "assembly_id"))
    @MapKeyJoinColumn(name = "standard_part_id")
    @Column(name = "quantity", nullable = false)
    private Map<StandardPart, Long> standartParts;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "assembly_material",
            joinColumns = @JoinColumn(name = "assembly_id"))
    @MapKeyJoinColumn(name = "material_id")
    @Column(name = "quantity", nullable = false)
    private Map<Material, BigDecimal> materials;

    @Column(name = "additionalInfo")
    private String additionalInfo;

    @Column(name = "lastDate")
    private Date lastDate;

    @ManyToOne
    private User user;

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.descName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        else{
            if (obj instanceof Assembly){
                Assembly assembly = (Assembly)obj;
                if(this.name.equals(assembly.getName()) && this.descName.equals(assembly.getDescName())){
                    return true;
                }
                else{
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }

    public boolean deleteAssembly(Assembly assembly){
        if(assembly == null){
            return false;
        }
        if(assemblies.containsKey(assembly)){
            assemblies.remove(assembly);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deletePart(Part part){
        if(part == null){
            return false;
        }
        if(parts.containsKey(part)){
            parts.remove(part);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteStandartPart(StandardPart standardPart){
        if(standardPart == null){
            return false;
        }
        if(standartParts.containsKey(standardPart)){
            standartParts.remove(standardPart);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteMaterial(Material material){
        if(material == null){
            return false;
        }
        if(materials.containsKey(material)){
            materials.remove(material);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addAssembly(Assembly assembly, Long quantity){
        if(this.assemblies==null){
            assemblies = new HashMap<Assembly, Long>();
        }
        if(this.id.equals(assembly.getId())){
            return false;
        }
        if (assemblies.containsKey(assembly)){
            return false;
        }
        if(quantity == null || quantity.longValue() <= 0 ){
            return false;
        }
        else{
            assemblies.put(assembly, quantity);
            return true;
        }
    }

    public boolean addPart(Part part, Long quantity){
        if(this.parts==null){
            parts = new HashMap();
        }
        if (parts.containsKey(part)){
            return false;
        }
        if(quantity == null || quantity.longValue() <= 0 ){
            return false;
        }
        else{
            parts.put(part, quantity);
            return true;
        }
    }

    public boolean addStandartPart(StandardPart standardPart, Long quantity){
        if(this.standartParts==null){
            standartParts = new HashMap();
        }
        if (standartParts.containsKey(standardPart)){
            return false;
        }
        if(quantity == null || quantity.longValue() <= 0 ){
            return false;
        }
        else{
            standartParts.put(standardPart, quantity);
            return true;
        }
    }

    public boolean addMaterials(Material material, BigDecimal quantity){
        if(this.materials==null){
            materials = new HashMap();
        }
        if (materials.containsKey(material)){
            return false;
        }
        if(quantity == null || quantity.longValue() <= 0 ){
            return false;
        }
        else{
            materials.put(material, quantity);
            return true;
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

    public Map<Assembly, Long> getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(Map<Assembly, Long> assemblies) {
        this.assemblies = assemblies;
    }

    public Map<Part, Long> getParts() {
        return parts;
    }

    public void setParts(Map<Part, Long> parts) {
        this.parts = parts;
    }

    public Map<StandardPart, Long> getStandartParts() {
        return standartParts;
    }

    public void setStandartParts(Map<StandardPart, Long> standartParts) {
        this.standartParts = standartParts;
    }

    public Map<Material, BigDecimal> getMaterials() {
        return materials;
    }

    public void setMaterials(Map<Material, BigDecimal> materials) {
        this.materials = materials;
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

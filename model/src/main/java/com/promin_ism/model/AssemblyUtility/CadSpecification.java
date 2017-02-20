package com.promin_ism.model.AssemblyUtility;

import com.promin_ism.model.Assembly;

import java.util.List;

public class CadSpecification {
    private Assembly assembly;
    private List<CadSpecificationEntry> cadSpecificationEntries;

    public CadSpecification(Assembly assembly, List<CadSpecificationEntry> cadSpecificationEntries) {
        this.assembly = assembly;
        this.cadSpecificationEntries = cadSpecificationEntries;
    }

    public CadSpecification() {
    }

    public Assembly getAssembly() {
        return assembly;
    }

    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }

    public List<CadSpecificationEntry> getCadSpecificationEntries() {
        return cadSpecificationEntries;
    }

    public void setCadSpecificationEntries(List<CadSpecificationEntry> cadSpecificationEntries) {
        this.cadSpecificationEntries = cadSpecificationEntries;
    }
}

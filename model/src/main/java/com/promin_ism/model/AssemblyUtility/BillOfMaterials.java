package com.promin_ism.model.AssemblyUtility;

import com.promin_ism.model.Assembly;
import com.promin_ism.model.Material;

import java.math.BigDecimal;
import java.util.Map;

public class BillOfMaterials {
    private Assembly assembly;
    private Map<Material, BigDecimal> bill;


    public Assembly getAssembly() {
        return assembly;
    }

    public void setAssembly(Assembly assembly) {
        this.assembly = assembly;
    }

    public Map<Material, BigDecimal> getBill() {
        return bill;
    }

    public void setBill(Map<Material, BigDecimal> bill) {
        this.bill = bill;
    }
}

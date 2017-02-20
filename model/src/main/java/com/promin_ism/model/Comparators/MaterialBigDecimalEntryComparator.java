package com.promin_ism.model.Comparators;

import com.promin_ism.model.Material;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;

public class MaterialBigDecimalEntryComparator implements Comparator<Map.Entry<Material, BigDecimal>> {
    @Override
    public int compare(Map.Entry<Material, BigDecimal> o1, Map.Entry<Material, BigDecimal> o2) {
        int result = o1.getKey().getName().compareTo(o2.getKey().getName());
        if(result == 0){
            result = o1.getKey().getDimensions().compareTo(o2.getKey().getDimensions());
            if(result == 0){
                result = o1.getKey().getGost().compareTo(o2.getKey().getGost());
                if(result == 0){
                    return o1.getKey().getSort().compareTo(o2.getKey().getSort());
                }
                else {
                    return result;
                }
            }
            else {
                return result;
            }
        }
        else{
            return result;
        }
    }
}

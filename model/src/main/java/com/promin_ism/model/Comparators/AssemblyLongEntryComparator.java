package com.promin_ism.model.Comparators;

import com.promin_ism.model.Assembly;

import java.util.Comparator;
import java.util.Map;

public class AssemblyLongEntryComparator implements Comparator<Map.Entry<Assembly, Long>> {
    @Override
    public int compare(Map.Entry<Assembly, Long> o1, Map.Entry<Assembly, Long> o2) {
        int result = o1.getKey().getName().compareTo(o2.getKey().getName());
        if (result == 0) {
            return o1.getKey().getDescName().compareTo(o2.getKey().getDescName());
        }
        else {
            return result;
        }
    }
}

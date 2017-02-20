package com.promin_ism.model.Comparators;

import com.promin_ism.model.StandardPart;

import java.util.Comparator;
import java.util.Map;

public class StandardPartLongEntryComparator implements Comparator <Map.Entry<StandardPart, Long>> {
    @Override
    public int compare(Map.Entry<StandardPart, Long> o1, Map.Entry<StandardPart, Long> o2) {
        int result = o1.getKey().getName().compareTo(o2.getKey().getName());
        if(result == 0){
            return  o1.getKey().getGost().compareTo(o2.getKey().getGost());
        }
        else{
            return result;
        }
    }
}

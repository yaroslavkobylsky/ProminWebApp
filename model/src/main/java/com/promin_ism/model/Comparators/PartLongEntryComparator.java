package com.promin_ism.model.Comparators;

import com.promin_ism.model.Part;

import java.util.Comparator;
import java.util.Map;

public class PartLongEntryComparator implements Comparator<Map.Entry<Part, Long>> {
        @Override
        public int compare(Map.Entry<Part, Long> o1, Map.Entry<Part, Long> o2) {
            return o1.getKey().getName().compareTo(o2.getKey().getName());
        }
}

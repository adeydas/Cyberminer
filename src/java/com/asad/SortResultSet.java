/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asad;

import java.sql.ResultSet;
import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author Sudharsan
 */
public class SortResultSet implements Comparator<String>{

    Map<String, String> base;
    /**
     *
     * @param base
     */
    public SortResultSet(Map<String, String> base) {
        this.base = base;
    }
    
    @Override
    public int compare(String o1, String o2) {             
             return base.get(o1).compareTo(base.get(o2));         
    }

    
}

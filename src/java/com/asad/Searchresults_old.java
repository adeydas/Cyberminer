package com.asad;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;
/**
 * Author: Abhishek Dey Das
 * Website: http://abhis.ws
 * Date: Apr 18, 2013
 */
public class Searchresults_old {
    
    //Method to search for multiple keywords. The search is run for each keyword.
    //Input: keywords in the format keyword1 keyword2 keyword3 keyword4.
    //Output: List<String> containing Url at position 0 and description at position 1.
    public TreeMap<String, String> getResults(String keywords) {
        
        System.out.println(keywords);
        Mysql obj = new Mysql();
        String arr[] = keywords.split(" ");
        //String a = "";
        ArrayList ids = new ArrayList();
        
        for (String a:arr) {
            String query = "SELECT id FROM search WHERE firstword LIKE '"+a+"'";
            ResultSet rs = obj.runQuery(query);
            
            if(rs!=null) {
                try {
                    while(rs.next()) {
                        ids.add(rs.getInt("id"));
                        
                    }
                    obj.closeCon();
                } catch (SQLException ex) {
                    Logger.getLogger(Searchresults.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        //got all the matching id's for all keywords
        HashSet h = new HashSet(ids);
        ids.clear();
        ids.addAll(h);
        //all id's are in place without duplicates
        ArrayList ret = new ArrayList();
        HashMap<String,String> map = new HashMap<String,String>();
        SortResultSet srs =  new SortResultSet(map);
        TreeMap<String,String> sorted_map = new TreeMap<String,String>(srs);
        for(int k=0; k<ids.size(); k++) {
            String q = "SELECT url, description FROM urlInfo WHERE id='"+ids.get(k)+"' ORDER BY description DESC";
            ResultSet rs = obj.runQuery(q);
            if(rs!=null){
                try {
                    int i = 0;
                    while(rs.next()) {
                        //List<String> list = new ArrayList();
                        //list.add(rs.getString("url"));                        
                        //list.add(rs.getString("description"));
                        map.put(rs.getString("url"), rs.getString("description"));
                        //System.out.println(rs.getString("description"));                        
                    }
                    obj.closeCon();
                } catch (SQLException ex) {
                    Logger.getLogger(Searchresults.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //return
        sorted_map.putAll(map);
        return sorted_map;
    }
    
    //Method to search for single keyword.
    //Input: keywords in the format keyword1.
    //Output: String containing a matching keyword or null.
    public String autoFill(String keyword) {
        String query = "SELECT firstword FROM search WHERE firstword LIKE '%"+keyword+"%' LIMIT 1";
        String ret = null;        
        Mysql obj = new Mysql();
        ResultSet rs = obj.runQuery(query);
        try {
            while(rs.next()) {
                ret = rs.getString("firstword");
                //System.out.println(ret);
            }
            obj.closeCon();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Searchresults.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Autofill keywords :"+ret);
       return ret;
    }
    //Test code. Uncomment this code to test the class.
  /*public static void main(String args[]) {
        Searchresults s = new Searchresults();
        System.out.println("Searching for results....");
        TreeMap<String,String> treeMap = s.getResults("white pages");
        Print first 10. Others pages can be printed starting from that particular index                        
        for(Map.Entry<String,String> entry : treeMap.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        System.out.println(key + " => " + value);
      }
        
        //Autofill test
        System.out.println("Searching for autofill value....");
        String sf = s.autoFill("ce");
        System.out.println(sf);
    }  */
    
}




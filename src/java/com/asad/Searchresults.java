package com.asad;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;
/**
 * Author: Abhishek Dey Das
 * Website: http://abhis.ws
 * Date: Apr 18, 2013
 */
public class Searchresults {
    
    //Method to search for multiple keywords. The search is run for each keyword.
    //Input: keywords in the format keyword1 keyword2 keyword3 keyword4.
    //Output: List<String> containing Url at position 0 and description at position 1.
    public ArrayList<Result> getResults(String keywords) {
        
        System.out.println(keywords);
        Mysql obj = new Mysql();
        String arr[] = keywords.split(" ");
        
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT u.url, u.description FROM urlInfo u");
        sql.append(" JOIN search s ON u.id = s.id");
        sql.append(" WHERE s.firstword IN (");
        
        //String a = "";
        //ArrayList ids = new ArrayList();
        long time = System.nanoTime();
        for (int i=0; i<arr.length; i++) {
            sql.append("?,");
        }
        sql.delete(sql.length()-1, sql.length());
        sql.append(")");
        sql.append("ORDER BY u.description ASC");
        System.out.println(TimeUnit.MILLISECONDS.convert((System.nanoTime()-time), TimeUnit.NANOSECONDS));
        //got all the matching id's for all keywords
                
        System.out.println(sql);
        ResultSet rs = obj.runQuery(sql.toString(), arr);
        ArrayList<Result> sortedRes = new ArrayList<Result>();
        
        if(rs!=null){
            try {
                int i = 0;
                while(rs.next()) {
                	//sortedResultMap.put(rs.getString("url"), rs.getString("description"));  
                    if(!rs.getString("description").startsWith(" ")){
                        sortedRes.add(new Result(rs.getString("url"), rs.getString("description")));
                    }
                }
                obj.closeCon();
            } catch (SQLException ex) {
                Logger.getLogger(Searchresults.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }    
        if(sortedRes.size() != 0){
            return sortedRes;
        }
        System.out.println("REsult set is null !!!!");
        return null;
                //sortedResultMap;
        
        /*for(int k=0; k<ids.size(); k++) {
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
        return sorted_map;*/
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
  public static void main(String args[]) {
        Searchresults s = new Searchresults();
        System.out.println("Searching for results....");
        ArrayList<Result> rs = s.getResults("msn mit");
        //Print first 10. Others pages can be printed starting from that particular index                        
        /*for(Map.Entry<String,String> entry : rs.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        System.out.println(key + " => " + value);
      }*/
        Iterator<Result> iter = rs.iterator();
        while(iter.hasNext()){
            Result rs1 = iter.next();
            System.out.println(rs1.getDesc());
        }
        
        //Autofill test
        System.out.println("Searching for autofill value....");
        String sf = s.autoFill("ce");
        System.out.println(sf);
    }  
    
}




package com.asad;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.io.*;
import java.sql.*;
import javax.sql.*;



/**
 * Author: Abhishek Dey Das
 * Website: http://abhis.ws
 * Date: Apr 18, 2013
 */
public class Mysql {
    
    Connection con;
	Scanner in;
    
    private void openCon()
    {
    	try
		{
			String server = "ec2-54-242-49-43.compute-1.amazonaws.com";
			String port = "3306";
			String url = "jdbc:mysql://"+server+":"+port+"/url";
			Class.forName("com.mysql.jdbc.Driver");
			String userid = "sad";
			String password = "sad";
			con = DriverManager.getConnection(url, userid, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    
    public void closeCon()
    {
    	try
    	{
    		con.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public ResultSet runQuery(String query, String ... parameters) {
        try {
            this.openCon();
            PreparedStatement statement = this.con.prepareStatement(query);
            for(int i=0; i<parameters.length; i++)
                statement.setString(i+1, parameters[i]);
            ResultSet rs = statement.executeQuery();
            //this.closeCon();
            return rs;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

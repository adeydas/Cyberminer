/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asad;

/**
 *
 * @author Ashwin
 */
public class Result {
    private String url;
    private String desc;

    public String getUrl() {
        return url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Result(String url, String desc) {
        this.url = url;
        this.desc = desc;
    }
    
    
            
            
}

package com.tutr.libtutr.Model;

/**
 * Created by jhallard on 1/12/15.
 */
public class LoginConfirmer {
    
    private int retcode;
    
    public LoginConfirmer() {retcode = -1;}
    public LoginConfirmer(int code) {if(code >= 0 && code <= 3) {retcode = code;}}
    
    public int getCode() {return retcode;}
    public void setCode(int code) {if(code >= 0 && code <= 3) {retcode = code;}}
}

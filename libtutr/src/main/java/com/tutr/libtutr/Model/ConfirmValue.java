package com.tutr.libtutr.Model;

/**
 * Created by jhallard on 1/12/15.
 */
public class ConfirmValue {
    private boolean data;
    
    public ConfirmValue() {data = true;}
    public ConfirmValue(boolean dat) {data = dat;}
    
    public boolean getData() {return data;}
    public void setData(boolean dat)  {data = dat;}
}

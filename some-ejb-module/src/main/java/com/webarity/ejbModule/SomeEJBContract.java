package com.webarity.ejbModule;

import javax.ejb.Local;

@Local
public interface SomeEJBContract {
    
    public byte[] pong(String s);
}
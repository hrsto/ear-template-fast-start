package com.webarity.ejbModule;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.webarity.library.Example;

@Stateless
@Local(SomeEJBContract.class)
public class SomeEJBImpl implements SomeEJBContract {

    @Override
    public byte[] pong(String s) {
        Example ex = new Example();
        return String.format("pong: %s %s\n", s, ex.getHellow()).getBytes();
    }
}
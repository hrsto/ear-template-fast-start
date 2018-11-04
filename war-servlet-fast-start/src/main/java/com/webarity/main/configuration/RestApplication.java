package com.webarity.main.configuration;

import java.util.HashSet;
import java.util.Set;

import com.webarity.main.RestEndpoint;

public class RestApplication extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(RestEndpoint.class);
        return classes;
    }
}
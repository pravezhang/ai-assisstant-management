package com.lowrisk.aiassistant.management.controller;

public abstract class BaseController {

    public boolean checkNull(Object... objects){
        for (Object o : objects)
            if(o == null)
                return true;
        return false;
    }

    public boolean checkBadInteger(Object... objects){
        for (Object o : objects){
            try {
                Integer.parseInt((String) o);
            }catch (Exception e){
                return true;
            }
        }
        return true;
    }
}

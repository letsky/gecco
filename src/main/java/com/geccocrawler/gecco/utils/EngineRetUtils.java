package com.geccocrawler.gecco.utils;

import com.geccocrawler.gecco.spider.SpiderThreadLocal;

public class EngineRetUtils {

    public static Object getRet(){
        return SpiderThreadLocal.get().getEngine().getRet();
    }

    public static void setRet(Object o){
        SpiderThreadLocal.get().getEngine().setRet(o);
    }

}

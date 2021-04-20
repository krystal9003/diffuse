package com.han.demo.edition.three.handler;

import com.han.demo.edition.three.BizHandler;
import com.han.demo.edition.three.DiffuseRequest;


public class OneBizHandler implements BizHandler {


    @Override
    public DiffuseRequest invoke(DiffuseRequest diffuseRequest) {
        System.out.println("oneBizHandler invoke method param={}" + diffuseRequest);
        return new DiffuseRequest();
    }


}

package com.lyh.dubbo.demo.impl;
import com.lyh.dubbo.demo.IDemoService;

import java.util.ArrayList;
import java.util.List;

public class demoService implements IDemoService {

    @Override
    public List getPermissions(Long id) {
        List<String> list=new ArrayList<String>();
        list.add(String.format("Permisstion_%d",id-1));
        list.add(String.format("Permisstion_%d",id));
        list.add(String.format("Permisstion_%d",id+1));
        return list;
    }
}

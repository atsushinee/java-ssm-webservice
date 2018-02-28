package org.ihsusta.server.service.impl;

import org.ihsusta.server.service.IndexService;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {

    public void hello(String name) {
        System.out.println("I am IndexService, hello " + name + " !");
    }
}

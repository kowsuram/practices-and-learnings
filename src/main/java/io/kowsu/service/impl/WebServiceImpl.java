package io.kowsu.service.impl;

import io.kowsu.service.IWebService;
import org.springframework.stereotype.Service;

@Service
public class WebServiceImpl implements IWebService {

    @Override
    public float stockPrice(String stockCode) {
        return stockCode.length();
    }

}

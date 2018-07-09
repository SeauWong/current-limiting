package com.wongcu.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author WongCU
 * @date 2018/7/9
 */
@RestController
@RequestMapping("/current_limiting")
public class CurrentLimitingController {

    private static AtomicInteger count = new AtomicInteger(0);

    private RateLimiter rateLimiter = RateLimiter.create(2);

    @GetMapping
    public Double currentLimiting(){
        double acquire = rateLimiter.acquire();
        System.out.println(new Date());
        return acquire;
    }
}

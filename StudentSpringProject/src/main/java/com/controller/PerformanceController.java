package com.controller;

import com.model.Performance;
import com.services.PerformanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/performance")
public class PerformanceController {

    @Autowired
    PerformanceService performanceService;
    public static final Logger logger = LoggerFactory.getLogger(PerformanceController.class);
    @GetMapping
    public List<Performance> getPerformance(){
        logger.info("Student Performance");
        return performanceService.getPerformance();
    }
    @PostMapping
    public Performance createPerformance(@RequestBody Performance performance){
        logger.info("createPerformance is invoked {}",performance);
        return performanceService.create(performance);
    }
    @GetMapping("/{id}")
    public Performance getperformanceById(@PathVariable ("id") int id) {
        logger.info("getperformanceById is invoked with Performance Id {}", id);
        return performanceService.getPerformanceById(id);
    }

    @PutMapping("/update")
    public Performance updatePerformance(@RequestBody Performance performance){
        return performanceService.updatePerformance(performance);
    }

    @DeleteMapping("/{id}")
    public Performance deletePerformanceById(@PathVariable ("id") int id) {
        return performanceService.deletePerformanceById(id);
    }
}

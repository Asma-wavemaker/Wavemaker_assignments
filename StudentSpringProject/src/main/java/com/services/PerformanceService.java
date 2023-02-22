package com.services;

import com.model.Performance;
import com.model.Student;

import java.util.List;

public interface PerformanceService {
    List<Performance> getPerformance() ;
    Performance create(Performance performance);
    Performance getPerformanceById(int id);
    Performance updatePerformance(Performance performance);
    Performance deletePerformanceById(int id);
}

package com.samsolutions.service;

import com.samsolutions.entity.User;
import com.samsolutions.entity.Visit;
import org.springframework.stereotype.Service;

@Service
public interface VisitService {
    Visit findById(Long id);
}

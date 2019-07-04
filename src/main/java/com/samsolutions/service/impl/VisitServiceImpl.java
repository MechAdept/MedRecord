package com.samsolutions.service.impl;

import com.samsolutions.entity.Visit;
import com.samsolutions.repository.VisitRepository;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("VisitService")
public class VisitServiceImpl implements VisitService {
    @Autowired
    @Qualifier(value = "visitRepository")
    private VisitRepository visitRepository;

    @Override
    public Visit findById(Long id) {
        return null;
    }
}

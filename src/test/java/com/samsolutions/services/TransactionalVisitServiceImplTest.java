package com.samsolutions.services;

import com.samsolutions.converter.VisitConverter;
import com.samsolutions.repository.HealthRepository;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.repository.VisitRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:application-context-test.xml")
@TestPropertySource("classpath:properties/application.test.properties")
@Transactional
@Sql(value = {"/sql/script-before-test.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class TransactionalUserServiceImplTest extends Assert {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private HealthRepository healthRepository;

    @Autowired
    private VisitConverter visitConverter;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    public void t1() {
        visitRepository.deleteById(1L);
    }

    @Test
    public void t2() {
        visitRepository.deleteById(1L);
    }

}

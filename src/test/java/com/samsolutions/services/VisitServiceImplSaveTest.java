package com.samsolutions.services;

import com.samsolutions.dto.form.VisitFormDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import com.samsolutions.entity.Visit;
import com.samsolutions.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-data-test.xml", "classpath:properties/application.test.properties", "classpath:application-context-test.xml"})
@Transactional
public class VisitServiceImplSaveTest {

    @Autowired
    UserRepository userRepository;

    @Before
    public void beforeTest() {
        User patient = new User();
        User doctor = new User();
        Ticket ticket = new Ticket();
        Visit visit = new Visit();
        //patient set Start

        patient.setUsername("patient");
        patient.setPassword("12345678");
        patient.setName("patientName");
        patient.setSurname("patientSurname");
        patient.setBirth(LocalDate.parse("22.11.1998", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        patient.setSex(true);
        userRepository.save(patient);
        //patient End
        //doctor set Start
        doctor.setUsername("doctor");
        doctor.setPassword("12345678");
        doctor.setName("doctorName");
        doctor.setSurname("doctorSurname");
        doctor.setBirth(LocalDate.parse("22.11.2008", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        doctor.setSex(true);
        userRepository.save(doctor);
        //
        ticket.setPatient(patient);
        ticket.setDoctor(doctor);
        ticket.setDatetime(LocalDateTime.parse("21.11.2019 18:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        ticket.setAttendance(null);
    }

    @Test
    public void Test() {

    }


    @After
    public void afterTest() {

    }
}

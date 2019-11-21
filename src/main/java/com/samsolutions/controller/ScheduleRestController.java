package com.samsolutions.controller;

import com.samsolutions.dto.data.ScheduleDataDTO;
import com.samsolutions.service.ScheduleService;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleRestController {

    @Autowired
    private ScheduleService scheduleService;

    @Secured("IS_AUTHENTICATED_FULLY")
    @GetMapping(value = "/schedule/{id}/{date}")
    @ResponseBody
    public List<ScheduleDataDTO> getSchedule(@PathVariable("id") Long id, @PathVariable("date") String date) {
        return scheduleService.getDayByDateAndId(date, id);
    }

    @Secured({"ROLE_PATIENT", "ROLE_ADMIN"})
    @GetMapping(value = "/schedule/booking/{patientId}/{scheduleId}")
    @ResponseBody
    public ResponseEntity<Object> bookTime(@PathVariable("patientId") Long patientId, @PathVariable("scheduleId") Long scheduleId) {
        if (scheduleService.booking(patientId, scheduleId)) {
            return new ResponseEntity<>(scheduleService.getDayBySchedule(scheduleId), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("mega message");
        }
    }

    @Secured({"ROLE_RECEPTIONIST", "ROLE_ADMIN"})
    @GetMapping(value = "/aschedule/booking/{patientId}/{scheduleId}/dereserve")
    @ResponseBody
    public ResponseEntity<Object> deReserveTime(@PathVariable("patientId") Long patientId, @PathVariable("scheduleId") Long scheduleId) {
        if (scheduleService.booking(patientId, scheduleId)) {
            return new ResponseEntity<>(scheduleService.getDayBySchedule(scheduleId), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @Secured({"ROLE_RECEPTIONIST", "ROLE_ADMIN"})
    @GetMapping(value = "/schedule/edit/{scheduleId}")
    @ResponseBody
    public ResponseEntity<Object> changeAvailable(@PathVariable("scheduleId") Long scheduleId) {
        scheduleService.changeAvailableById(scheduleId);
        return new ResponseEntity<>(scheduleService.getDayBySchedule(scheduleId), HttpStatus.OK);
    }
}

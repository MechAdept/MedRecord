package com.samsolutions.controller.patientPanel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Secured("ROLE_PATIENT")
public class BookingRestController {
}

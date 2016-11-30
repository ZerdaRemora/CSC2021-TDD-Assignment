package com.example.tddCoursework.testing;

import com.example.tddCoursework.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * JUnit Test Class for testing the functionality added by Feature 8 in Task 3 of the coursework.
 * Test Driven Development has been used in this class.
 *
 * NOTE: I already tested and solved the issue of preventing null Appointment values in task 2 when
 * testing Appointment's constructor, so 'preventNullAppointmentBeingAdded' passed immediately, skipping
 * the RED phase.
 */
public class Task3Feature8Test extends AbstractLoggingJUnitTest
{
    private AppointmentManager am;
    private Patient p;

    @Before
    public void initialise()
    {
        am = new AppointmentManager();
        Calendar dob = Calendar.getInstance();
        dob.set(1990, 6, 12);
        p = new Patient("John Smith", "123 Imaginary Street", "01546875421", dob.getTime());
        am.addPatient(p);
    }

    @Test
    public void canAddNewAppointmentWithAppointmentManager()
    {
        Calendar appDate = Calendar.getInstance();
        appDate.set(2016, 10, 14);
        am.addAppointment(p.getId(), appDate.getTime(), "Patient's First Appointment");

        assertNotNull("Appointment not added correctly by AppointmentManager", p.getAppointments().get(0));
    }

    @Test
    public void canAddMultipleNewAppointmentsWithAppointmentManager()
    {
        // Create a new Patient...
        Calendar dob2 = Calendar.getInstance();
        dob2.set(1975, 0, 19);
        Patient patient1 = new Patient("Bob Smith", "55 Road Street", "+447854932567", dob2.getTime());
        am.addPatient(patient1);

        // ... and register two Appointments with the Patient.
        Calendar appDate1 = Calendar.getInstance();
        appDate1.set(2016, 6, 8);
        am.addAppointment(patient1.getId(), appDate1.getTime(), "Patient 1's First Appointment");

        Calendar appDate2 = Calendar.getInstance();
        appDate2.set(2016, 7, 8);
        am.addAppointment(patient1.getId(), appDate2.getTime(), "Patient 1's Second Appointment");

        // Create a third Patient...
        Calendar dob3 = Calendar.getInstance();
        dob3.set(1988, 1, 28);
        Patient patient2 = new Patient("Jane Doe", "321 Real Road", "01234567890", dob3.getTime());
        am.addPatient(patient2);

        // ... and register a single Appointment with that Patient.
        Calendar appDate3 = Calendar.getInstance();
        appDate3.set(2016, 8, 22);
        am.addAppointment(patient2.getId(), appDate3.getTime(), "Patient 2's First Appointment");

        // Patient 1 should have 2 Appointments and Patient 2 should have 1.
        assertEquals("Appointments not added via AppointmentManager to Patient 1", 2, patient1.getAppointments().size());
        assertEquals("Appointment not added via AppointmentManager to Patient 2", 1, patient2.getAppointments().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventNullAppointmentBeingAdded()
    {
        am.addAppointment(p.getId(), null, "Testing Null Appointment Date");
    }
}

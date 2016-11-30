package com.example.tddCoursework.testing;

import com.example.tddCoursework.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

/**
 * JUnit Test Class for testing the functionality added by Feature 7 in Task 3 of the coursework.
 * Test Driven Development has been used in this class.
 *
 * NOTE: I already tested the ability to change a Patient's name and address through the Patient class
 * in task 2 while testing getter/setter methods. This tests whether the AppointmentManager class can change these
 * values too.
 */
public class Task3Feature7Test extends AbstractLoggingJUnitTest
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
    public void canChangePatientNameWithAppointmentManager()
    {
        am.changePatientName(p.getId(), "Jonathan Smith");
        assertEquals("AppointmentManager did not change Patient name correctly", "Jonathan Smith", p.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventIncorrectPatientIdWhenChangingName()
    {
        am.changePatientName(967, "Bob Smith");
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventNullValueWhenChangingPatientName()
    {
        am.changePatientName(p.getId(), null);
    }

    @Test
    public void canChangePatientAddressWithAppointmentManager()
    {
        am.changePatientAddress(p.getId(), "321 Real Road");
        assertEquals("AppointmentManager did not change Patient address correctly", "321 Real Road", p.getAddress());
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventIncorrectPatientIdWhenChangingAddress()
    {
        am.changePatientAddress(-9, "77 Incorrect Drive");
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventNullValueWhenChangingPatientAddress()
    {
        am.changePatientAddress(p.getId(), null);
    }
}

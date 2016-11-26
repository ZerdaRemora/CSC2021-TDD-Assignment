package com.example.tddCoursework.testing;

import com.example.tddCoursework.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JUnit Test Class for testing the functionality added in Task 2 of the coursework.
 * Test Driven Development has not been used in this class.
 */
public class Task2Test extends AbstractLoggingJUnitTest
{
    private AppointmentManager am;
    private Patient p;

    @Before
    public void initialise()
    {
        am = new AppointmentManager();

        Calendar dob = Calendar.getInstance();
        dob.set(1977, 7, 7);
        p = new Patient("Test Test", "1 Test Lane", dob.getTime());
    }

    @Test
    public void canCreateAppointmentManager()
    {
        assertTrue("AppointmentManager not created correctly", am instanceof AppointmentManager);
    }

    @Test
    public void canCreateMultipleAppointmentManagers()
    {
        AppointmentManager am2 = new AppointmentManager();

        assertTrue("First AppointmentManager not created correctly", am instanceof AppointmentManager);
        assertTrue("Second AppointmentManager  not created correctly", am2 instanceof AppointmentManager);
        assertNotEquals("AppointmentManager objects not unique", am, am2);
    }

    @Test
    public void canGetPatientList()
    {
        assertNotNull("AppointmentManager Patient List not initialised", am.getPatients());
    }

    @Test
    public void canCreatePatient()
    {
        assertEquals("Patient object not created correctly", "Test Test", p.getName());
        assertEquals("Patient object not created correctly", "1 Test Lane", p.getAddress());

        Calendar dob = Calendar.getInstance();
        dob.set(1977, 7, 7);
        Calendar c = Calendar.getInstance();
        c.setTime(p.getDateOfBirth());
        assertEquals("Patient object not created correctly", dob.DAY_OF_MONTH, c.DAY_OF_MONTH);
    }

    @Test
    public void patientHasUniqueId()
    {
        Calendar dob2 = Calendar.getInstance();
        dob2.set(1984, 11, 25);
        Patient p2 = new Patient("Check Test", "2 Test Street", dob2.getTime());

        assertNotEquals(p.getId(), p2.getId());
    }

    @Test
    public void canAddPatient()
    {
        Calendar dob = Calendar.getInstance();
        dob.set(1990, 6, 12);
        am.addPatient("John Smith", "123 Imaginary Street", dob.getTime());

        assertEquals("Patient not added to AppointmentManager correctly", "John Smith", am.getPatients().get(0).getName());
    }

    @Test
    public void canChangePatient()
    {
        p.setName("John");
        assertEquals("John", p.getName());

        p.setAddress("123 Test Road");
        assertEquals("123 Test Road", p.getAddress());
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventNullPatientValues()
    {
        Patient p2 = new Patient("Test", "Test Street", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventFutureDateOfBirth()
    {
        Calendar dob = Calendar.getInstance();
        dob.set(2020, 10, 1);
        Patient p2 = new Patient("Test", "Test Street", dob.getTime());
    }

    @Test
    public void canCreateAppointment()
    {
        Calendar appointmentDate = Calendar.getInstance();
        appointmentDate.set(2016, 10, 1);
        Appointment a = new Appointment(appointmentDate.getTime(), "Appointment Description");

        assertEquals("Appointment not created correctly", appointmentDate.getTime(), a.getDate());
        assertEquals("Appointment not created correctly", "Appointment Description", a.getDescription());
    }

    @Test
    public void canAddAppointment()
    {
        Calendar dob = Calendar.getInstance();
        dob.set(1977, 7, 7);
        Patient p = new Patient("Test Test", "1 Test Lane", dob.getTime());

        Calendar appointmentDate = Calendar.getInstance();
        appointmentDate.set(2016, 10, 1);
        p.addAppointment(appointmentDate.getTime(), "N/A");

        assertNotNull("Appointment not added to Patient correctly", p.getAppointments().get(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventNullAppointmentValues()
    {
        Appointment a = new Appointment(null, null);
    }
}

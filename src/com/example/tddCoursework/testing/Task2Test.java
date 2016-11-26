package com.example.tddCoursework.testing;

import com.example.tddCoursework.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task2Test extends AbstractLoggingJUnitTest
{
    private AppointmentManager am;

    @Before
    public void initialise()
    {
        am = new AppointmentManager();
    }

    @Test
    public void canCreateAppointmentManager()
    {
        assertTrue("AppointmentManager not created", am instanceof AppointmentManager);
    }

    @Test
    public void canCreateMultipleAppointmentManagers()
    {
        AppointmentManager am2 = new AppointmentManager();

        assertTrue("First AppointmentManager not created", am instanceof AppointmentManager);
        assertTrue("Second AppointmentManager  not created", am2 instanceof AppointmentManager);
        assertNotEquals("AppointmentManager objects not unique", am, am2);
    }

    @Test
    public void canGetPatientList()
    {
        assertNotNull("AppointmentManager Patient List not initialised", am.getPatients());
    }
}

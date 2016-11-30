package com.example.tddCoursework.testing;

import com.example.tddCoursework.*;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Calendar;

/**
 * JUnit Test Class for testing the functionality added by Feature 6 in Task 3 of the coursework.
 * Test Driven Development has been used in this class.
 */
public class Task3Feature6Test extends AbstractLoggingJUnitTest
{
    @Test
    public void canFindPatientWithName()
    {
        /*
        Most of this could go in a initialisation method labelled with '@Before' however
        one cannot guarantee the order that JUnit tests are ran in. To guarantee that
        'canFindMultiplePatientsWithSameName' will have exactly 2 Patients in the AppointmentManager,
        I have opted to create separate AppointmentManagers and Patients for each method.
        */
        AppointmentManager am = new AppointmentManager();
        Calendar dob = Calendar.getInstance();
        dob.set(1990, 6, 12);
        Patient p = new Patient("John Smith", "123 Imaginary Street", "01546875421", dob.getTime());
        am.addPatient(p);

        assertEquals("Patient Name not found in AppointmentManager", p, am.findPatient("John Smith").get(0));
    }

    @Test
    public void canFindMultiplePatientsWithSameName()
    {
        AppointmentManager am = new AppointmentManager();
        Calendar dob = Calendar.getInstance();
        dob.set(1990, 6, 12);
        Patient p = new Patient("John Smith", "123 Imaginary Street", "01546875421", dob.getTime());
        Calendar dob2 = Calendar.getInstance();
        dob2.set(1977, 7, 7);
        Patient p2 = new Patient("John Smith", "1 Test Lane", "+4401234567890", dob2.getTime());
        Calendar dob3 = Calendar.getInstance();
        dob3.set(1977, 7, 7);
        Patient p3 = new Patient("Jane Doe", "12 Test Road", "01264988780", dob3.getTime());
        am.addPatient(p);
        am.addPatient(p2);
        am.addPatient(p3); // 3rd Patient with different name to make sure that isn't returned too.

        int count = 0;
        // Not sure if asserts in for loop is best practice, but it seemed like the most ideal way to run this test.
        for (Patient pi : am.findPatient("John Smith"))
        {
            assertEquals("Multiple of same Patient Name not found in Appointment Manager", "John Smith", pi.getName());
            count++;
        }

        assertEquals("Multiple of same Patient Name not found in Appointment Manager", 2, count);
    }


    @Test
    public void canReturnNoPatientsWithMatchingNames()
    {
        AppointmentManager am = new AppointmentManager();

        // Originally checked for a null value being returned here, but I believe it would be better practice to just return an
        // empty ArrayList instead.
        assertEquals("Patient List not empty if no matches", 0, am.findPatient("John Smith").size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void preventNullNameValue()
    {
        AppointmentManager am = new AppointmentManager();
        am.findPatient(null);
    }
}

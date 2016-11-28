package com.example.tddCoursework.testing;

import com.example.tddCoursework.*;

import java.util.Calendar;
import java.util.List;

/**
 * Driver class for testing the functionality added in Task 2 of the coursework.
 * Test Driven Development has not been used in this class.
 */
public class Task2Driver
{
    public static void main(String[] args)
    {
        // Create multiple AppointmentManagers.
        AppointmentManager am1 = new AppointmentManager();
        AppointmentManager am2 = new AppointmentManager();

        // Create patient with required information.
        Calendar dob1 = Calendar.getInstance();
        dob1.set(1977, 7, 7);
        Patient p1 = new Patient("John Smith", "123 Test Street", "01234567890", dob1.getTime());
        Calendar dob2 = Calendar.getInstance();
        dob2.set(1977, 7, 7);
        Calendar dob3 = Calendar.getInstance();
        dob3.set(1977, 7, 7);
        Patient p3 = new Patient("Jane Doe", "11 Twelve Street", "+4401254869743", dob3.getTime());

        // Add patients to AppointmentManagers.
        am1.addPatient(p1);
        am1.addPatient("Bob Smith", "321 Test Lane", "09876543210", dob2.getTime());
        am2.addPatient(p3);

        // Add appointments to the Patients.
        Calendar appDate1 = Calendar.getInstance();
        appDate1.set(2016, 11, 2);
        Appointment app1 = new Appointment(appDate1.getTime(), "Patient 1's First Appointment");
        Calendar appDate2 = Calendar.getInstance();
        appDate2.set(2016, 11, 16);
        Appointment app2 = new Appointment(appDate2.getTime(), "Patient 1's Second Appointment");
        Calendar appDate3 = Calendar.getInstance();
        appDate3.set(2016, 10, 30);

        p1.addAppointment(app1);
        p1.addAppointment(app2);
        // Patient 3 will have id 1 as she was created second (IDs start counting from 0).
        am2.getPatientById(1).addAppointment(appDate3.getTime(), "Patient 3's First Appointment");



        System.out.println("AppointmentManager 1:\n");
        List<Patient> am1Patients = am1.getPatients();
        for (Patient p : am1Patients)
        {
            System.out.println(p);  // Print details for each patient in the first AppointmentManager.
        }

        System.out.println("---------------------\nAppointmentManager 2:\n");
        List<Patient> am2Patients = am2.getPatients();
        for (Patient p : am2Patients)
        {
            System.out.println(p);  // Print details for each patient in the first AppointmentManager.
        }
    }
}

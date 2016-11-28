package com.example.tddCoursework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents the Appointment Manager system for a doctor's surgery.
 */
public class AppointmentManager
{
    private List<Patient> patients;

    /**
     * Creates an AppointmentManager with no patients.
     */
    public AppointmentManager()
    {
        this.patients = new ArrayList<Patient>();
    }

    /**
     * Returns a list of Patients.
     * @return List of Patients registered on the AppointmentManager.
     */
    public List<Patient> getPatients()
    {
        return this.patients;
    }

    public void addPatient(Patient patient)
    {
        if (patient == null)
            throw new IllegalArgumentException("Appointment must not be null.");

        this.patients.add(patient);
    }

    public void addPatient(String name, String addr, String phoneNumber, Date dob)
    {
        this.patients.add(new Patient(name, addr, phoneNumber, dob));    // Error checking is present in Patient constructor.
    }

    /**
     * Helper function to find a Patient object given a Patient's ID.
     * @param patientId The ID of the patient we are looking for.
     * @return The Patient object with the given ID, or null if no Patient with
     * the provided ID was found.
     */
    public Patient getPatientById(int patientId)
    {
        for (Patient p : patients)
        {
            if (p.getId() == patientId)
            {
                return p;
            }
        }
        return null;
    }

    /* Should be implemented later.
    public List<Patient> findPatient(String name)
    {
        return null;
    }

    public void changePatientName(int patientId, String name)
    {
        Patient p = getPatientById(patientId);
        p.setName(name);
    }

    public void changePatientAddress(int patientId, String address)
    {
        Patient p = getPatientById(patientId);
        p.setAddress(address);
    }

    public void addAppointment(int patientId, Date date, String desc)
    {
        Patient p = getPatientById(patientId);
        p.addAppointment(date,  desc);
    }
    */

}

package com.example.tddCoursework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents the Appointment Manager system for a doctor's surgery.
 *
 * This class differs slightly from the design produced in Task 1. Firstly, I have added a
 * method for adding an already made Patient object rather than constructing one in AppointmentManager
 * (this.addPatient(Patient patient)).
 * I have also added a 'getPatientById' helper method which is used by the AppointmentManager class when
 * changing a Patient's name, address or adding an appointment. I added this as it will cut down on duplicated
 * code in these 3 methods.
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

    /**
     * Register a Patient with the AppointmentManager.
     * @param patient The Patient object to register.
     */
    public void addPatient(Patient patient)
    {
        if (patient == null)
            throw new IllegalArgumentException("Patient must not be null.");

        this.patients.add(patient);
    }

    /**
     * Register a Patient with the AppointmentManager.
     * @param name Name of the Patient
     * @param addr Address of the Patient
     * @param phoneNumber Phone Number of the Patient
     * @param dob Date of Birth of the Patient
     */
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

    /**
     * Given a name, this method finds all Patients registered in the AppointmentManager with
     * a name that matches exactly that of the one provided.
     * @param name The name of the patient(s) to search for.
     * @return A List of Patients with the name provided.
     */
    public List<Patient> findPatient(String name)
    {
        if (name == null)
            throw new IllegalArgumentException("Name must not be null.");

        List<Patient> matchingPatients = new ArrayList<Patient>();

        for (Patient p : patients)
        {
            if (p.getName().equals(name))
            {
                matchingPatients.add(p);
            }
        }

        return matchingPatients;
    }

    /**
     * Change the Patient with the corresponding ID's name.
     * @param patientId The ID of the Patient to change
     * @param name The Patient's new name
     */
    public void changePatientName(int patientId, String name)
    {
        Patient p = getPatientById(patientId);
        if (p == null)
            throw new IllegalArgumentException("No Patient exists with that ID.");
        p.setName(name);
    }

    /**
     * Change the Patient with the corresponding ID's address.
     * @param patientId The ID of the Patient to change
     * @param address The Patient's new address
     */
    public void changePatientAddress(int patientId, String address)
    {
        Patient p = getPatientById(patientId);
        if (p == null)
            throw new IllegalArgumentException("No Patient exists with that ID.");
        p.setAddress(address);
    }

    /**
     * Add an appointment related to the Patient with the provided ID.
     * @param patientId The ID of the Patient to which the Appointment belongs.
     * @param date The date of the Appointment
     * @param desc Any notes regarding the Appointment
     */
    public void addAppointment(int patientId, Date date, String desc)
    {
        Patient p = getPatientById(patientId);
        p.addAppointment(date,  desc);
    }


}

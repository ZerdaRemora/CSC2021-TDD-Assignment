package com.example.tddCoursework;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentManager
{
    private List<Patient> patients;

    public AppointmentManager()
    {
        this.patients = new ArrayList<Patient>();
    }

    public List<Patient> getPatients()
    {
        return patients;
    }

    // TODO: Implement this.
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

    /**
     * Private helper function to find a Patient object given a Patient's ID.
     * @param patientId The ID of the patient we are looking for.
     * @return The Patient object with the given ID, or null if no Patient with
     * the provided ID was found.
     */
    private Patient getPatientById(int patientId)
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
}

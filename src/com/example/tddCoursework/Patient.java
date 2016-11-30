package com.example.tddCoursework;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Represents a Patient at a doctor's surgery. Each patient has an ID which is unique across all
 * AppointmentManager systems in case of a patient changing doctor's surgery or if required as part
 * of a larger system.
 *
 * This class differs slightly from the design produced in Task 1. Firstly, a 'getID' method has been added
 * to help distinguish between similar Patients.
 * I have also added a 'addAppointment(Appointment app)' method for adding an Appointment to a patient if it has
 * already been created.
 * Finally, I have overridden 'toString' to neatly display the details of a Patient.
 */
public class Patient
{
    private final int ID;
    private static int nextId = 0;
    private String name;
    private String address;
    private String phoneNumber;
    private Date dateOfBirth;
    private List<Appointment> appointments;

    /**
     * Creates a Patient with the specified parameters.
     * @param name Full name of the patient
     * @param phoneNumber Phone Number of the Patient
     * @param addr Address of the patient
     * @param dob Date of Birth of the patient
     */
    public Patient(String name, String addr, String phoneNumber, Date dob)
    {
        // Regex pattern for testing that a phoneNumber only contains numbers, or a '+' with country code.
        Pattern phoneNoPattern = Pattern.compile("(\\+[0-9]{1,3})?[0-9]*");

        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name must not be null or empty.");
        if (addr == null || addr.isEmpty())
            throw new IllegalArgumentException("Address must not be null or empty.");
        if (phoneNumber == null || phoneNumber.isEmpty())
            throw new IllegalArgumentException("Phone Number must not be null or empty.");
        if (!phoneNoPattern.matcher(phoneNumber).matches())
            throw new IllegalArgumentException("Phone Number is malformed.");
        if (dob == null)
            throw new IllegalArgumentException("Date of birth must not be null.");
        if (dob.after(Calendar.getInstance().getTime()))
            throw new IllegalArgumentException("Date of birth must be in the past.");

        // Uses a static int to ensure a unique ID.
        this.ID = nextId;
        nextId++;

        this.name = name;
        this.address = addr;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dob;

        appointments = new ArrayList<Appointment>();
    }

    public int getId()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name must not be null or empty.");
        this.name = name;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        if (address == null || address.isEmpty())
            throw new IllegalArgumentException("Address must not be null or empty.");
        this.address = address;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public Date getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    /**
     * Register an Appointment with the Patient.
     * @param appointment An Appointment object representing the Patient's appointment
     */
    public void addAppointment(Appointment appointment)
    {
        if (appointment == null)
            throw new IllegalArgumentException("Appointment must not be null.");
        appointments.add(appointment);
    }

    /**
     * Register an Appointment with the Patient.
     * @param date The date of the Appointment
     * @param desc Any notes regarding the Appointment
     */
    public void addAppointment(Date date, String desc)
    {
        Appointment a = new Appointment(date, desc);    // Error checking is in Appointment constructor.
        appointments.add(a);
    }

    public List<Appointment> getAppointments()
    {
        return this.appointments;
    }

    @Override
    public String toString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ID: %s\nName: %s\nAddress: %s\nPhone Number: %s\nDate of Birth: %s\n",
                ID, name, address, phoneNumber, dateFormat.format(dateOfBirth)));

        for (Appointment a : appointments)
        {
            sb.append("\t" + a);
        }
        return sb.toString();
    }
}

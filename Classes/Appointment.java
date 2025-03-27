package Classes;

/**
 * Represents an appointment in the hospital management system.
 * This class manages scheduling between patients and doctors,
 * storing appointment details and facilitating the booking process.
 */
public class Appointment {
    /** Unique identifier for the appointment */
    private String appID;
    /** Name of the patient who booked the appointment */
    private String patientName;
    /** Brief description of the medical condition or reason for visit */
    private String diagnosis;
    /** Name of the doctor conducting the appointment */
    private String doctorName;
    /** Scheduled date of the appointment */
    private String appDate;
    /** Scheduled time of the appointment */
    private String appTime;

    /**
     * Constructor to initialize an Appointment with all required details.
     * @param appID Unique appointment identifier
     * @param patientName Name of the patient
     * @param diagnosis Medical condition or reason for visit
     * @param doctorName Name of the assigned doctor
     * @param appDate Date of the appointment
     * @param appTime Time slot for the appointment
     */
    public Appointment(String appID, String patientName, String diagnosis, String doctorName, String appDate, String appTime) {
        this.appID = appID;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.doctorName = doctorName;
        this.appDate = appDate;
        this.appTime = appTime;
    }

    /**
     * Gets the unique identifier of the appointment.
     * @return The appointment ID
     */
    public String getAppId() {
        return appID;
    }

    /**
     * Gets the name of the patient who booked the appointment.
     * @return The patient's name
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Gets the medical condition or reason for the appointment.
     * @return The diagnosis or reason for visit
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Gets the name of the doctor conducting the appointment.
     * @return The doctor's name
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * Gets the scheduled date of the appointment.
     * @return The appointment date
     */
    public String getAppDate() {
        return appDate;
    }

    /**
     * Gets the scheduled time slot for the appointment.
     * @return The appointment time
     */
    public String getAppTime() {
        return appTime;
    }
}
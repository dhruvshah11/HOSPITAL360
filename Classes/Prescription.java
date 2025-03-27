package Classes;

/**
 * Represents a medical prescription in the hospital management system.
 * This class stores all relevant information about a prescription including
 * patient details, diagnosis, prescribed medication, and usage instructions.
 * It serves as a data structure for managing patient medications and treatment plans.
 */
public class Prescription {
    /** Unique identifier of the patient receiving the prescription */
    private String patientId;
    /** Name of the patient */
    private String patientName;
    /** Medical diagnosis or condition being treated */
    private String diagnosis;
    /** Name of the prescribing doctor */
    private String doctorName;
    /** Name of the prescribed medication */
    private String medicineName;
    /** Prescribed dosage of the medication */
    private String dosage;
    /** Detailed instructions for taking the medication */
    private String usageInstructions;

    /**
     * Constructor to create a new prescription with all required details.
     * @param patientId Unique identifier of the patient
     * @param patientName Full name of the patient
     * @param diagnosis Medical condition being treated
     * @param doctorName Name of the prescribing doctor
     * @param medicineName Name of the prescribed medication
     * @param dosage Prescribed dosage of the medication
     * @param usageInstructions Instructions for taking the medication
     */
    public Prescription(String patientId, String patientName, String diagnosis, String doctorName, String medicineName, String dosage, String usageInstructions) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.doctorName = doctorName;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.usageInstructions = usageInstructions;
    }

    /**
     * Retrieves the patient's unique identifier.
     * @return The patient's ID
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * Gets the patient's full name.
     * @return The patient's name
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Retrieves the medical diagnosis.
     * @return The diagnosis or medical condition
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Gets the name of the prescribing doctor.
     * @return The doctor's name
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * Retrieves the name of the prescribed medication.
     * @return The medicine name
     */
    public String getMedicineName() {
        return medicineName;
    }

    /**
     * Gets the prescribed dosage information.
     * @return The medication dosage
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * Retrieves the detailed instructions for taking the medication.
     * @return The usage instructions
     */
    public String getUsageInstructions() {
        return usageInstructions;
    }
}
package Classes;

/**
 * Represents a patient in the hospital management system.
 * This class extends the Person class and adds patient-specific attributes
 * such as medical history, room assignment, and billing information.
 * It manages all aspects of a patient's hospital stay and treatment.
 */
public class Patient extends Person {
    /** Age of the patient */
    private String age;
    /** Residential address of the patient */
    private String address;
    /** ID or name of the doctor assigned to this patient */
    private String appointedDoctor;
    /** Room number assigned to the patient */
    private String room;
    /** Current medical diagnosis or condition */
    private String diagnosis;
    /** Amount deposited for medical services */
    private String deposit;

    
    /**
     * Constructor to initialize a Patient object with all required information.
     * @param id Unique patient identifier (PID format)
     * @param name Patient's full name
     * @param mobileNo Contact number
     * @param gender Patient's gender
     * @param age Patient's age
     * @param address Residential address
     * @param appointedDoctor Assigned doctor's ID/name
     * @param room Assigned room number
     * @param diagnosis Medical condition or diagnosis
     * @param deposit Initial payment deposit
     */
    public Patient(String id, String name, String mobileNo, String gender, String age, String address, String appointedDoctor, String room, String diagnosis, String deposit) {
        super(id, name, mobileNo, gender);
        this.age = age;
        this.address = address;
        this.appointedDoctor = appointedDoctor;
        this.room = room;
        this.diagnosis = diagnosis;
        this.deposit = deposit;
    }

  
    /**
     * Retrieves the patient's age.
     * @return The age of the patient
     */
    public String getAge() {
        return age;
    }

    /**
     * Updates the patient's age.
     * @param age New age to set
     */
    public void setAge(String age) {
        this.age = age;
    }
	
	
    /**
     * Gets the patient's residential address.
     * @return The address of the patient
     */
    public String getAddress() {
        return address;
    }

    /**
     * Updates the patient's residential address.
     * @param address New address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
	
	
    /**
     * Gets the ID/name of the doctor assigned to this patient.
     * @return The appointed doctor's identifier
     */
    public String getAppointedDoctor() {
        return appointedDoctor;
    }

    /**
     * Updates the assigned doctor for this patient.
     * @param appointedDoctor New doctor's ID/name
     */
    public void setAppointedDoctor(String appointedDoctor) {
        this.appointedDoctor = appointedDoctor;
    }

    /**
     * Gets the patient's assigned room number.
     * @return The room number
     */
    public String getRoom() {
        return room;
    }

    /**
     * Updates the patient's room assignment.
     * @param room New room number
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * Gets the patient's current medical diagnosis.
     * @return The medical diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Updates the patient's medical diagnosis.
     * @param diagnosis New medical diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
	
    /**
     * Gets the amount deposited by the patient.
     * @return The deposit amount
     */
    public String getDeposit() {
        return deposit;
    }

    /**
     * Updates the patient's deposit amount.
     * @param deposit New deposit amount
     */
    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }
	
	
	
	
}
 
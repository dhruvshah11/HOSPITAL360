package Classes;

/**
 * Represents a doctor in the hospital management system.
 * This class extends the Person class and adds doctor-specific attributes
 * such as department, joining date, and medical registration number.
 * It manages doctor authentication and professional information.
 */
public class Doctor extends Person {
    /** Medical department or specialization of the doctor */
    private String department;
    /** Date when the doctor joined the hospital */
    private String joiningDate;
    /** Medical registration number (BMDC registration) */
    private String bmdcReg;
    /** Password for doctor's authentication in the system */
    private String password;
	
    /**
     * Constructor to initialize a Doctor object with all required information.
     * @param id Unique doctor identifier (DID format)
     * @param name Doctor's full name
     * @param gender Doctor's gender
     * @param mobileNo Contact number
     * @param department Medical specialization/department
     * @param joiningDate Date of joining the hospital
     * @param bmdcReg Medical registration number
     * @param password Authentication password
     */
    public Doctor(String id, String name, String gender, String mobileNo, String department, String joiningDate, String bmdcReg, String password) {
        super(id, name, gender, mobileNo);
        this.department = department;
        this.joiningDate = joiningDate;
        this.bmdcReg = bmdcReg;
        this.password = password;
    }

    /**
     * Retrieves the doctor's medical department/specialization.
     * @return The department name
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Updates the doctor's department assignment.
     * @param department New department name
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the date when the doctor joined the hospital.
     * @return The joining date
     */
    public String getJoiningDate() {
        return joiningDate;
    }

    /**
     * Updates the doctor's joining date.
     * @param joiningDate New joining date
     */
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * Retrieves the doctor's authentication password.
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Updates the doctor's authentication password.
     * @param password New password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
	
    /**
     * Gets the doctor's medical registration number.
     * @return The BMDC registration number
     */
    public String getBmdcReg() {
        return bmdcReg;
    }

    /**
     * Updates the doctor's medical registration number.
     * @param bmdcReg New BMDC registration number
     */
    public void setBmdcReg(String bmdcReg) {
        this.bmdcReg = bmdcReg;
    }
}

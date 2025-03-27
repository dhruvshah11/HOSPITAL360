package Classes;

/**
 * Abstract base class representing a person in the hospital management system.
 * This class serves as the parent class for both Patient and Doctor classes,
 * providing common attributes and methods for personal information management.
 */
public abstract class Person {
    /** Unique identifier for the person (used differently in Patient and Doctor subclasses) */
    public String id;
    /** Full name of the person */
    private String name;
    /** Gender of the person */
    private String gender;
    /** Contact number for the person */
    private String mobileNo;
    /** Residential address of the person */
    private String address;

    /**
     * Constructor to initialize a Person object with basic information.
     * @param id Unique identifier for the person
     * @param name Full name of the person
     * @param mobileNo Contact number
     * @param gender Gender of the person
     */
    public Person(String id, String name, String mobileNo, String gender) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.gender = gender;
    }

    /**
     * Retrieves the person's unique identifier.
     * @return The ID of the person
     */
    public String getId() {
        return id;
    }

    /**
     * Updates the person's unique identifier.
     * @param id New ID to be set
     */
    public void setId(String id) {
        this.id = id;
    }

	
    /**
     * Retrieves the person's full name.
     * @return The name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the person's name.
     * @param name New name to be set
     */
    public void setName(String name) {
        this.name = name;
    }
	
    /**
     * Retrieves the person's contact number.
     * @return The mobile number of the person
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Updates the person's contact number.
     * @param mobileNo New mobile number to be set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    } 

  
    /**
     * Retrieves the person's gender.
     * @return The gender of the person
     */
    public String getGender() {
        return gender;
    }

    /**
     * Updates the person's gender.
     * @param gender New gender to be set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    
}

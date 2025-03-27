package Classes;

import java.io.*;
import java.util.Scanner;

/**
 * Manages the storage and retrieval of medical prescriptions in the hospital system.
 * This class handles the persistence of prescription data to/from a text file,
 * provides search functionality, and maintains an in-memory list of prescriptions.
 * It implements thread-safe operations for concurrent access.
 */
public class PrescriptionList {
    /** File path for storing prescription records */
    private static final String PRESCRIPTION_FILE = "Files/prescriptions.txt";
    /** Array to store prescription objects in memory */
    private Prescription[] prescriptionList;
    /** Current number of prescriptions in the list */
    private static int pCount;
    /** Maximum number of prescriptions that can be stored */
    private static final int MAX_PRESCRIPTIONS = 1000;

    /**
     * Constructor initializes the prescription list and loads existing prescriptions from file.
     * Creates a new prescription file if it doesn't exist.
     */
    public PrescriptionList() {
        prescriptionList = new Prescription[MAX_PRESCRIPTIONS];
        pCount = 0;
        loadPrescriptions();
    }

    /**
     * Loads prescriptions from the file into memory.
     * Creates a new file if it doesn't exist and handles file reading errors.
     * Parses each prescription record and creates Prescription objects.
     */
    private void loadPrescriptions() {
        File file = new File(PRESCRIPTION_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Could not create prescriptions file: " + e.getMessage());
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                
                try {
                    String patientId = line.split(": ")[1];
                    String patientName = reader.readLine().split(": ")[1];
                    String diagnosis = reader.readLine().split(": ")[1];
                    String doctorName = reader.readLine().split(": ")[1];
                    String medicineName = reader.readLine().split(": ")[1];
                    String dosage = reader.readLine().split(": ")[1];
                    String usageInstructions = reader.readLine().split(": ")[1];
                    
                    // Skip the empty line between prescriptions
                    reader.readLine();

                    Prescription p = new Prescription(patientId, patientName, diagnosis,
                            doctorName, medicineName, dosage, usageInstructions);
                    prescriptionList[pCount++] = p;
                } catch (Exception e) {
                    System.err.println("Error parsing prescription: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading prescriptions: " + e.getMessage());
        }
    }

    /**
     * Adds a new prescription to both memory and file storage.
     * This method is synchronized to ensure thread safety when multiple threads attempt to add prescriptions.
     * @param p The prescription to add
     * @throws IOException If there's an error writing to the file
     * @throws IllegalArgumentException If the prescription is null
     * @throws IllegalStateException If the prescription list is full
     */
    public synchronized void addPrescription(Prescription p) throws IOException {
        if (p == null) {
            throw new IllegalArgumentException("Prescription cannot be null");
        }
        if (pCount >= MAX_PRESCRIPTIONS) {
            throw new IllegalStateException("Prescription list is full");
        }

        // Add to memory
        prescriptionList[pCount] = p;
        pCount++;

        // Format prescription details
        String prescriptionDetails = String.format(
            "Patient ID: %s\n" +
            "Patient Name: %s\n" +
            "Diagnosis: %s\n" +
            "Doctor's Name: %s\n" +
            "Medicine Name: %s\n" +
            "Dosage: %s\n" +
            "Usage Instructions: %s\n\n",
            p.getPatientId(), p.getPatientName(), p.getDiagnosis(),
            p.getDoctorName(), p.getMedicineName(), p.getDosage(),
            p.getUsageInstructions());

        // Write to file with proper resource management
        try (FileWriter fw = new FileWriter(PRESCRIPTION_FILE, true)) {
            fw.write(prescriptionDetails);
            fw.flush();
        } catch (IOException e) {
            // Revert memory state if file write fails
            prescriptionList[--pCount] = null;
            throw new IOException("Failed to save prescription: " + e.getMessage(), e);
        }
    }

    /**
     * Searches for a prescription by patient ID.
     * @param patientId The ID of the patient to search for
     * @return The index of the prescription in the array, or -1 if not found
     */
    public int searchPrescription(String patientId) {
        int index = -1;
        for (int i = 0; i < pCount; i++) {
            if (prescriptionList[i] != null && prescriptionList[i].getPatientId().equalsIgnoreCase(patientId)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Retrieves a prescription by its index in the array.
     * @param index The index of the prescription to retrieve
     * @return The Prescription object at the specified index
     */
    public Prescription getPrescription(int index) {
        return prescriptionList[index];
    }
}
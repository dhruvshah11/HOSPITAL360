# Hospital Management System Documentation

## Core Classes

### Person Class
Base class that provides common attributes for both patients and doctors:
- Stores basic personal information (name, gender, contact)
- Serves as a parent class for Patient and Doctor classes

### Patient Class (extends Person)
Manages patient-specific information:
- Patient ID (PID format)
- Medical history and current diagnosis
- Room assignment and billing information
- Assigned doctor information

### Doctor Class (extends Person)
Handles doctor-specific attributes:
- Doctor ID (DID format)
- Specialization/Department
- Schedule management
- Patient list management

### Appointment Class
Manages patient appointments:
- Stores appointment details (date, time, doctor)
- Links patients with doctors
- Handles scheduling logic

## Data Management Classes

### PList Class
Patient list management:
- Maintains the master list of all patients
- Handles patient registration and updates
- Provides search functionality

### RegDoctorList Class
Doctor registration and management:
- Maintains the list of registered doctors
- Handles doctor authentication
- Manages doctor schedules

### PrescriptionList Class
Manages medical prescriptions:
- Stores prescription details
- Links prescriptions to patients and doctors
- Handles prescription history

## User Interface Frames

### Login Frame
Authentication interface:
- Handles admin and doctor login
- Validates credentials
- Directs users to appropriate dashboards

### Menu Frame
Main navigation interface:
- Provides access to all system functions
- Different menus for admin and doctors

### DrDashboard Frame
Doctor's main interface:
- Shows assigned patients
- Manages appointments
- Access to prescription writing

### AddPatient Frame
Patient registration interface:
- Collects patient information
- Assigns room and doctor
- Generates patient ID

### AddDoctor Frame
Doctor registration interface:
- Collects doctor information
- Assigns department
- Generates doctor ID

### PrescriptionView Frame
Prescription management:
- Shows prescription history
- Allows writing new prescriptions
- Prints prescription documents

### Update Frame
Information update interface:
- Modifies patient/doctor information
- Updates medical records
- Changes room assignments

### Discharge Frame
Patient discharge processing:
- Handles billing
- Updates room availability
- Maintains discharge records

## File Management

### PatientList.txt
Stores patient records:
- Patient IDs and personal information
- Medical details and room assignments
- Billing information

### DoctorList.txt
Maintains doctor information:
- Doctor IDs and credentials
- Specializations and schedules
- Contact information

### prescriptions.txt
Stores prescription records:
- Links patients with medications
- Includes dosage and instructions
- Maintains prescription history

## System Features

### Admin Capabilities
- Complete system control
- Patient and doctor management
- Room assignment
- Billing management

### Doctor Features
- Patient list view
- Prescription management
- Appointment scheduling
- Medical record access

### Security
- Password protection
- Role-based access control
- Secure data storage

### Data Management
- File-based storage system
- Automatic ID generation
- Data validation and verification
# HOSPITAL360
Hospital Management System

1. Introduction
1.1 Purpose
This document provides a detailed description of the requirements for the Hospital Management System. It outlines the functional and non-functional requirements, system architecture, and technical specifications necessary for system implementation.


1.2 Scope
The Hospital Management System is designed to streamline hospital operations by managing patient records, doctor schedules, appointments, prescriptions, and billing information. The system serves hospital administrators, doctors, and support staff.


1.3 Definitions and Acronyms
HMS: Hospital Management System
PID: Patient Identification Number
DID: Doctor Identification Number

2. System Overview

   
2.1 System Architecture
The system follows an object-oriented architecture with the following key components:
Core Classes (Person, Patient, Doctor)
Data Management Classes (PList, RegDoctorList, PrescriptionList)
User Interface Components (Frames)
File-based Data Storage

2.2 System Interfaces
User Interfaces: Java Swing-based GUI components
File System Interface: Text-based data storage
Authentication System: Role-based access control


3. Functional Requirements

   
3.1 User Management

3.1.1 Authentication
System shall provide secure login for administrators and doctors
System shall maintain separate access levels for different user roles
System shall enforce password protection


3.1.2 User Roles
Administrator: Full system access and control
Doctor: Limited access to patient records and prescriptions

3.2 Patient Management

3.2.1 Patient Registration
System shall generate unique Patient IDs
System shall store patient personal information
System shall maintain medical history
System shall track room assignments
System shall manage billing information

3.2.2 Patient Records
System shall allow updating patient information
System shall maintain prescription history
System shall track appointment schedules
System shall process discharge procedures

3.3 Doctor Management
3.3.1 Doctor Registration
System shall generate unique Doctor IDs
System shall store doctor specializations
System shall maintain doctor schedules

3.3.2 Doctor Functions
System shall allow viewing assigned patients
System shall enable prescription writing
System shall manage appointment schedules

3.4 Appointment System
System shall schedule new appointments
System shall manage appointment conflicts
System shall track appointment history
System shall send appointment notifications

3.5 Prescription Management
System shall allow creating new prescriptions
System shall maintain prescription history
System shall link prescriptions to patients
System shall enable prescription printing

3.6 Billing System
System shall calculate patient bills
System shall track payment status
System shall generate billing reports
System shall process discharge billing


4. Non-Functional Requirements
4.1 Performance
System shall handle multiple concurrent users
System shall respond to queries within 2 seconds
System shall support multiple simultaneous appointments


4.2 Security
System shall encrypt sensitive data
System shall maintain access logs
System shall enforce password policies
System shall protect against unauthorized access


4.3 Reliability
System shall maintain data integrity
System shall provide data backup functionality
System shall handle errors gracefully


4.4 Usability
System shall provide intuitive user interface
System shall display clear error messages
System shall offer help documentation


5. Data Management
5.1 Data Storage
   
5.1.1 File Structure
PatientList.txt: Patient records
DoctorList.txt: Doctor information
prescriptions.txt: Prescription records
AppointmentList.txt: Appointment data


5.1.2 Data Backup
System shall maintain regular backups
System shall provide data recovery options


5.2 Data Validation
System shall validate input data
System shall prevent duplicate entries
System shall maintain data consistency


7. User Interface
6.1 Main Interfaces
6.1.1 Login Frame
Login form for authentication
Role selection options
Password recovery function


6.1.2 Menu Frame
Navigation menu for system functions
Role-based menu options
Quick access shortcuts


6.1.3 Dashboard
Overview of current status
Quick access to common functions
Notification area

6.2 Patient Management Interfaces
6.2.1 Add Patient Frame
Patient registration form
Room assignment interface
Doctor assignment options

6.2.2 Update Frame
Patient information update
Medical record modification
Room reassignment

6.3 Doctor Management Interfaces
6.3.1 Add Doctor Frame
Doctor registration form
Specialization selection
Schedule management

6.3.2 Doctor Dashboard
Patient list view
Appointment schedule
Prescription management


9. System Constraints
7.1 Technical Constraints
Java-based implementation
File-based storage system
Swing GUI framework


7.2 Hardware Constraints
Minimum RAM requirements
Storage space for data files
Network connectivity for multi-user access

11. Future Enhancements

    
8.1 Potential Improvements

Database integration
Mobile application interface
Online appointment booking
Electronic health records integration
Automated billing system
Pharmacy management integration


13. Appendix

    
9.1 Use Case Diagrams


9.1.1 Patient Management
+------------------+
|     Patient      |
+------------------+
        |
    +---+---+
    |       |
+-------+ +--------+
|Register| |Schedule|
|Patient | |Appoint.|
+-------+ +--------+
    |           |
+-------+ +---------+
|Update | |View Med.|
|Info   | |History  |
+-------+ +---------+
9.1.2 Doctor Management
+------------------+
|     Doctor       |
+------------------+
        |
    +---+---+
    |       |
+-------+ +--------+
|View    | |Write   |
|Patients| |Presc.  |
+-------+ +--------+
    |           |
+-------+ +---------+
|Manage | |View     |
|Appts. | |Schedule |
+-------+ +---------


9.2 Sequence Diagrams


9.2.1 Patient Registration
User        GUI         PList       Patient
 |           |            |            |
 |--AddPatient----------->|            |
 |           |            |            |
 |           |--create----|----------->|
 |           |            |            |
 |           |<-return----|------------|
 |           |            |            |
 |           |--save----->|            |
 |           |            |            |
 |<-success--|            |            |

 
9.2.2 Appointment Scheduling
Doctor      GUI      AppointmentList  Patient
 |           |            |            |
 |--Schedule------------>|            |
 |           |            |            |
 |           |--validate->|            |
 |           |            |            |
 |           |<-available-|            |
 |           |            |            |
 |           |--create----|----------->|
 |           |            |            |
 |<-confirm--|            |            |

 
9.2.3 Prescription Management
Doctor      GUI      PrescriptionList Patient
 |           |            |            |
 |--WritePres---------->|            |
 |           |            |            |
 |           |--create--->|            |
 |           |            |            |
 |           |<-save------|            |
 |           |            |            |
 |<-success--|            |            |

 
|-- View Prescriptions |-- Process Discharge

[Doctor] | |-- View Patient List |-- Write Prescription |-- Manage Appointments |-- Update Patient Records

[Administrator] | |-- Manage Patient Records |-- Manage Doctor Records |-- Room Assignment |-- Billing Management |-- System Configuration


### 9.2 Data Flow Diagrams

#### 9.2.1 Patient Registration Flow
[Patient Info] --> [Registration Form] | v [Validation] --> [Generate PID] | v [Store in PatientList.txt] | v [Assign Doctor/Room]


#### 9.2.2 Prescription Flow
[Doctor] --> [Write Prescription] | v [Prescription Details] --> [Validation] | v [Store in prescriptions.txt] | v [Link to Patient Record]


### 9.3 Class Diagrams

#### 9.3.1 Core Classes
+------------------+ +------------------+ | Person | | Appointment | +------------------+ +------------------+ | - name: String | | - id: String | | - gender: String | | - date: String | | - contact: String| | - time: String | +------------------+ | - status: String | ^ | +--------+--------+ +------------------+ | Patient |<>--------| - patient: Patient| +------------------+ | - doctor: Doctor | | - pid: String | +------------------+ | - diagnosis: String
| - room: String | +------------------+ | - doctor: Doctor | | Prescription | +------------------+ +------------------+ ^ | - id: String | | | - date: String | +------------------+ | - medicine: String| | Doctor |<>--------| - doctor: Doctor | +------------------+ | - patient: Patient| | - did: String | +------------------+ | - specialization | | - schedule: List | +------------------+


#### 9.3.2 Management Classes
+------------------+ +------------------+ | PList | | PrescriptionList | +------------------+ +------------------+ | - patients: List | | - prescriptions | +------------------+ +------------------+ | + addPatient() | | + addPrescription| | + updatePatient()| | + getPrescHistory| | + searchPatient()| | + searchByPatient| | + removePatient()| | + searchByDoctor | +------------------+ +------------------+

+------------------+ +------------------+ | RegDoctorList | | AppointmentList | +------------------+ +------------------+ | - doctors: List | | - appointments | +------------------+ +------------------+ | + addDoctor() | | + scheduleAppt() | | + validateLogin()| | + cancelAppt() | | + getDoctorById()| | + updateStatus() | | + updateDoctor() | | + getByDoctor() | +------------------+ +------------------+


#### 9.3.3 UI Classes
+------------------+ +------------------+ | Login | | Menu | +------------------+ +------------------+ | + validateUser() | | + showOptions() | | + showError() | | + handleChoice() | +------------------+ +------------------+ ^ | +------------------+ +------------------+ | DrLogin | | DrDashboard | +------------------+ +------------------+ | + checkDoctor() | | + viewPatients() | | + accessLevel() | | + writePresc() | +------------------+ +------------------+


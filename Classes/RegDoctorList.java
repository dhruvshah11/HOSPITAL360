package Classes;

import java.io.*;
import java.util.Scanner;

public class RegDoctorList{
	public Doctor doctorList[] = new Doctor[100];
	public static int doctorCount = 0;
	
	public RegDoctorList() {
        try {
            File file = new File("Files/DoctorList.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                try {
                    String id = sc.nextLine().trim();
                    String name = sc.nextLine().trim();
                    // Remove 'Dr.' prefix if present
                    if (name.startsWith("Dr. ")) {
                        name = name.substring(4);
                    }
                    String gender = sc.nextLine().trim();
                    String mobile = sc.nextLine().trim();
                    String department = sc.nextLine().trim();
                    String joiningDate = sc.nextLine().trim();
                    String bmdc = sc.nextLine().trim();
                    String password = sc.nextLine().trim();

                    if (sc.hasNext()) {
                        sc.nextLine(); // Skip extra newline if present
                    }

                    // Enhanced validation
                    if (id.isEmpty() || !id.startsWith("DID") || name.isEmpty() || 
                        !gender.matches("(?i)(Male|Female)") || mobile.isEmpty() || 
                        department.isEmpty() || joiningDate.isEmpty() || 
                        bmdc.isEmpty() || password.isEmpty()) {
                        System.out.println("Warning: Skipping invalid doctor record - ID: " + id);
                        continue;
                    }

                    if (doctorCount < doctorList.length) {
                        Doctor d = new Doctor(id, name, gender, mobile, department, joiningDate, bmdc, password);
                        doctorList[doctorCount] = d;
                        doctorCount++;
                    } else {
                        System.out.println("Warning: Doctor list is full. Cannot add more doctors.");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error reading doctor record: " + e.getMessage());
                    // Skip to next record
                    while (sc.hasNext() && sc.nextLine().trim().isEmpty());
                }
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println("Error accessing doctor database: " + ex.getMessage());
        }
		
	}
	
	public void addDoctor(Doctor d){
		doctorList[doctorCount] = d;
		doctorCount++;
	
	
	// Format doctor details with proper validation
		String DrDetails = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n\n",
			d.getId(),
			d.getName(),
			d.getGender(),
			d.getMobileNo(),
			d.getDepartment(),
			d.getJoiningDate(),
			d.getBmdcReg(),
			d.getPassword());
		try{
			FileWriter fw = new FileWriter("Files/DoctorList.txt",true);
			fw.write(DrDetails);
			fw.close();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public int doctorExists(String name){
		int index = -1;
		for(int i = 0; i<doctorCount; i++){
			if(doctorList[i]!=null && doctorList[i].getName().equals(name)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	public Doctor checkPassword(int index, String pass){
		Doctor d = null;
		if(doctorList[index].getPassword().equals(pass)){
			d = doctorList[index];
		}
		return d;
	}
	
	public Doctor getDoctor(int index){
		return doctorList[index];
	}
	
	public String[] getDoctorNames() {
    String doctorNames [] = new String[doctorCount];
    for (int i = 0; i < doctorCount; i++) {
		if (doctorNames!= null && doctorList[i]!= null){
        doctorNames[i] = "Dr. "+doctorList[i].getName();
    }}
    return doctorNames;
	
}

	
	/*public void deleteDoctor(Doctor d){
		for(int i = 0; i<doctorCount; i++){
			if(doctorList[i] == d){
				for(int j = i; j<doctorCount-1; j++){
					doctorList[j] = doctorList[j+1];
				}
				doctorCount--;
				doctorList[doctorCount]=null;
				break;
			}
		}
	}*/
	
	
}
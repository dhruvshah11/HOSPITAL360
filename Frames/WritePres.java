package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Classes.*;

public class WritePres extends JFrame implements ActionListener {

    JLabel nameLabel, ddLabel, srchLabel, ptNameLabel, diagLabel, drNameLabel, medNameLabel, doseLabel, usageLabel;
    JTextField srchTF, ptNameTF, diagTF, drNameTF, medNameTF, doseTF, usageTF;
    JButton searchBtn, saveBtn, backBtn;
    Font font1, font2, font3, font4, font5;
    Color color1, color2, color3;
    ImageIcon img, icon;
    JPanel panel;

    public WritePres() {
        super("Hospital-360 - Doctor Dashboard");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        icon = new ImageIcon("images/emp-info.png");
        this.setIconImage(icon.getImage());

        font1 = new Font("Ubuntu", Font.BOLD, 30);
        font2 = new Font("Ubuntu", Font.BOLD, 18);
        font3 = new Font("Ubuntu", Font.BOLD, 14);
        font4 = new Font("Ubuntu", Font.BOLD, 15);
        font5 = new Font("Ubuntu", Font.ITALIC, 16);

        color1 = new Color(70, 150, 180); // Calming blue
        color2 = new Color(100, 180, 140); // Soft healing green
        color3 = new Color(245, 250, 255); // Clean medical white

        panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Hospital-360");
        nameLabel.setBounds(350, 30, 250, 40);
        nameLabel.setFont(font1);
        panel.add(nameLabel);

        ddLabel = new JLabel("Patient Prescription");
        ddLabel.setBounds(186, 100, 200, 30);
        ddLabel.setFont(font2);
        panel.add(ddLabel);

        srchLabel = new JLabel("Search by PID: ");
        srchLabel.setBounds(100, 140, 170, 20);
        srchLabel.setFont(font4);
        panel.add(srchLabel);

        srchTF = new JTextField();
        srchTF.setBounds(230, 142, 75, 20);
        panel.add(srchTF);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(325, 140, 80, 20);
        searchBtn.setFont(font5);
        searchBtn.setBorder(null);
        searchBtn.setBackground(color1);
        searchBtn.setForeground(Color.RED);
        searchBtn.addActionListener(this);
        panel.add(searchBtn);

        ptNameLabel = new JLabel("Patient Name: ");
        ptNameLabel.setBounds(100, 180, 150, 20);
        ptNameLabel.setFont(font3);
        panel.add(ptNameLabel);

        ptNameTF = new JTextField();
        ptNameTF.setBounds(225, 180, 150, 20);
        panel.add(ptNameTF);

        diagLabel = new JLabel("Diagnosis: ");
        diagLabel.setBounds(100, 220, 150, 20);
        diagLabel.setFont(font3);
        panel.add(diagLabel);

        diagTF = new JTextField();
        diagTF.setBounds(225, 220, 150, 20);
        panel.add(diagTF);

        drNameLabel = new JLabel("Doctor's Name: ");
        drNameLabel.setBounds(100, 260, 150, 20);
        drNameLabel.setFont(font3);
        panel.add(drNameLabel);

        drNameTF = new JTextField();
        drNameTF.setBounds(225, 260, 150, 20);
        panel.add(drNameTF);

        medNameLabel = new JLabel("Medicine Name: ");
        medNameLabel.setBounds(100, 300, 150, 20);
        medNameLabel.setFont(font3);
        panel.add(medNameLabel);

        medNameTF = new JTextField();
        medNameTF.setBounds(225, 300, 150, 20);
        panel.add(medNameTF);

        doseLabel = new JLabel("Dosage: ");
        doseLabel.setBounds(100, 340, 150, 20);
        doseLabel.setFont(font3);
        panel.add(doseLabel);

        doseTF = new JTextField();
        doseTF.setBounds(225, 340, 150, 20);
        panel.add(doseTF);

        usageLabel = new JLabel("Usage Instruc.: ");
        usageLabel.setBounds(100, 380, 150, 20);
        usageLabel.setFont(font3);
        panel.add(usageLabel);

        usageTF = new JTextField();
        usageTF.setBounds(225, 380, 150, 20);
        panel.add(usageTF);

        saveBtn = new JButton("Save");
        saveBtn.setBounds(140, 430, 100, 30);
        saveBtn.setBackground(Color.BLACK);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.addActionListener(this);
        panel.add(saveBtn);

        backBtn = new JButton("Exit");
        backBtn.setBounds(260, 430, 100, 30);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        img = new ImageIcon("images/dis.png");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(450, 75, 400, 400);
        panel.add(imgLabel);

        panel.setBackground(color1);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals("Search")) {
            searchPatient();
        } else if (command.equals("Save")) {
            savePrescription();
        } else if (command.equals("Exit")) {
            goBack();
        }
    }

    private void searchPatient() {
        String id = srchTF.getText();
        PList pl = new PList();
        if (!id.isEmpty()) {
            int index = pl.searchPatient(id);
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Patient does not exist!");
            } else {
                Patient p = pl.getPatient(index);
                ptNameTF.setText(p.getName());
                diagTF.setText(p.getDiagnosis());
                drNameTF.setText(p.getAppointedDoctor());
            }
        }
    }

    private void savePrescription() {
        String patientID = srchTF.getText().trim();
        String patientName = ptNameTF.getText().trim();
        String diagnosis = diagTF.getText().trim();
        String doctorName = drNameTF.getText().trim();
        String medicineName = medNameTF.getText().trim();
        String dosage = doseTF.getText().trim();
        String usageInstructions = usageTF.getText().trim();

        if (patientID.isEmpty() || patientName.isEmpty() || diagnosis.isEmpty() || 
            doctorName.isEmpty() || medicineName.isEmpty() || dosage.isEmpty() || 
            usageInstructions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!patientID.matches("PID\\d+")) {
            JOptionPane.showMessageDialog(this, "Invalid Patient ID format. Must start with 'PID' followed by numbers.",
                                        "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String prescription = String.format("%s,%s,%s,%s,%s,%s,%s\n",
                patientID, patientName, diagnosis, doctorName, medicineName, dosage, usageInstructions);
            
            FileWriter fw = new FileWriter("Files/prescriptions.txt", true);
            fw.write(prescription);
            fw.close();

            JOptionPane.showMessageDialog(this, "Prescription saved successfully!");
            clearFields();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving prescription: " + e.getMessage(),
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        srchTF.setText("");
        ptNameTF.setText("");
        diagTF.setText("");
        drNameTF.setText("");
        medNameTF.setText("");
        doseTF.setText("");
        usageTF.setText("");
    }

    private void goBack() {
        Menu menu = new Menu();
        menu.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        WritePres frame = new WritePres();
        frame.setVisible(true);
    }
}
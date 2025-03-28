package Frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;

public class AppointmentFrame extends JFrame implements MouseListener, ActionListener {
    private Color color3;

    JLabel appIdLabel, appIdTF, patientNameLabel, diagnosisLabel, doctorNameLabel, appDateLabel, appTimeLabel;
    JTextField patientNameTF, diagnosisTF, appDateTF, appTimeTF;
    JButton add, backBtn;
    Color color1, color2;
    Font font1, font2;
    JComboBox<String> doctorNameCB;
    JPanel panel;
    ImageIcon img, icon;
    AppointmentList al;

    public AppointmentFrame(AppointmentList al) {
        super("Hospital-360 - Book Appointment");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        icon = new ImageIcon("images/icon.png");
        this.setIconImage(icon.getImage());

        this.al = al;

        color1 = new Color(70, 150, 180); // Calming blue
        color2 = new Color(100, 180, 140); // Soft healing green
        color3 = new Color(245, 250, 255); // Clean medical white

        font1 = new Font("Ubuntu", Font.BOLD, 30);
        font2 = new Font("Ubuntu", Font.PLAIN, 20);

        panel = new JPanel();
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Hospital-360");
        titleLabel.setBounds(300, 10, 400, 100);
        titleLabel.setFont(font1);
        panel.add(titleLabel);

        JLabel formLabel = new JLabel("Appointment Form");
        formLabel.setBounds(180, 90, 450, 30);
        formLabel.setFont(font2);
        panel.add(formLabel);

        appIdLabel = new JLabel("Appointment ID: ");
        appIdLabel.setBounds(75, 140, 150, 30);
        panel.add(appIdLabel);

        appIdTF = new JLabel("A-" + (5000 + al.appCount));
        appIdTF.setBounds(230, 140, 200, 30);
        //appIdTF.setEditable(false);
        panel.add(appIdTF);

        patientNameLabel = new JLabel("Patient Name: ");
        patientNameLabel.setBounds(75, 180, 150, 30);
        panel.add(patientNameLabel);

        patientNameTF = new JTextField();
        patientNameTF.setBounds(230, 180, 200, 30);
        panel.add(patientNameTF);

        diagnosisLabel = new JLabel("Diagnosis: ");
        diagnosisLabel.setBounds(75, 220, 150, 30);
        panel.add(diagnosisLabel);

        diagnosisTF = new JTextField();
        diagnosisTF.setBounds(230, 220, 200, 30);
        panel.add(diagnosisTF);

        doctorNameLabel = new JLabel("Doctor Name: ");
        doctorNameLabel.setBounds(75, 260, 150, 30);
        panel.add(doctorNameLabel);

        RegDoctorList rdl = new RegDoctorList();
        String[] DrL = rdl.getDoctorNames();
        doctorNameCB = new JComboBox<>(DrL);
        doctorNameCB.setBounds(230, 260, 200, 30);
        panel.add(doctorNameCB);

        appDateLabel = new JLabel("Appointment Date: ");
        appDateLabel.setBounds(75, 300, 150, 30);
        panel.add(appDateLabel);

        appDateTF = new JTextField();
        appDateTF.setBounds(230, 300, 200, 30);
        panel.add(appDateTF);

        appTimeLabel = new JLabel("Appointment Time: ");
        appTimeLabel.setBounds(75, 340, 150, 30);
        panel.add(appTimeLabel);

        appTimeTF = new JTextField();
        appTimeTF.setBounds(230, 340, 200, 30);
        panel.add(appTimeTF);

        add = new JButton("Book Appointment");
        add.setBounds(500, 420, 150, 40);
        add.setBackground(color2);
        add.setForeground(Color.WHITE);
        add.setOpaque(true);
        add.addMouseListener(this);
        add.addActionListener(this);
        panel.add(add);

        backBtn = new JButton("BACK");
        backBtn.setBounds(670, 420, 100, 40);
        backBtn.setBackground(Color.RED);
        backBtn.setForeground(Color.WHITE);
        backBtn.setOpaque(true);
        backBtn.addMouseListener(this);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        img = new ImageIcon("images/dis.png");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(450, 60, 400, 400);
        panel.add(imgLabel);

        panel.setBackground(color1);
        this.add(panel);
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == add) {
            add.setBackground(color2);
            add.setForeground(Color.WHITE);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(Color.RED);
            backBtn.setForeground(Color.BLACK);
        }
    }
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == add) {
            add.setBackground(color2);
            add.setForeground(Color.BLACK);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(Color.RED);
            backBtn.setForeground(Color.WHITE);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backBtn) {
            Menu me = new Menu();
            me.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == add) {
            try {
                String appId = appIdTF.getText();
                String patientName = patientNameTF.getText().trim();
                String diagnosis = diagnosisTF.getText().trim();
                String doctorName = (String) doctorNameCB.getSelectedItem();
                String appDate = appDateTF.getText().trim();
                String appTime = appTimeTF.getText().trim();

                // Validate empty fields
                if (patientName.isEmpty() || diagnosis.isEmpty() || doctorName.isEmpty() || appDate.isEmpty() || appTime.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all fields!");
                    return;
                }

                // Validate date format (DD/MM/YYYY)
                if (!appDate.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                    JOptionPane.showMessageDialog(this, "Please enter date in DD/MM/YYYY format!");
                    return;
                }

                // Validate time format (HH:MM)
                if (!appTime.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$")) {
                    JOptionPane.showMessageDialog(this, "Please enter time in HH:MM format (24-hour)!");
                    return;
                }

                // Create and save appointment
                Appointment appointment = new Appointment(appId, patientName, diagnosis, doctorName, appDate, appTime);
                al.addAppointment(appointment);

                JOptionPane.showMessageDialog(this, "Appointment booked successfully!");
                Menu menu = new Menu();
                menu.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error booking appointment: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        AppointmentList al = new AppointmentList();
        AppointmentFrame frame = new AppointmentFrame(al);
        frame.setVisible(true);
    }
}
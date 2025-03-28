
// A DYMRA TECH PRODUCTION
package Frames;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import Classes.*;

public class DoctorList extends JFrame implements ActionListener {

    JLabel userLabel, passLabel, imgLabel;
    JButton back;
    Color color1, color2, color3;
    Font font1, font4;
    ImageIcon img;
    JPanel panel;
    JTable table;
    DefaultTableModel model;

    public DoctorList() {
        super("Doctor List");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        color1 = new Color(70, 150, 180); // Calming blue
        color2 = new Color(100, 180, 140); // Soft healing green
        color3 = new Color(245, 250, 255); // Clean medical white

        font1 = new Font("Ubuntu", Font.BOLD, 30);
        font4 = new Font("Ubuntu", Font.BOLD, 18);

        panel = new JPanel();
        panel.setLayout(null);

        userLabel = new JLabel("Hospital-360 ");
        userLabel.setBounds(350, 10, 400, 100);
        userLabel.setFont(font1);
        panel.add(userLabel);

        userLabel = new JLabel("Doctor List ");
        userLabel.setBounds(377, 70, 400, 50);
        userLabel.setFont(font4);
        panel.add(userLabel);

		model = new DefaultTableModel();
        table = new JTable(model);
		table.setBackground(color2);
		//table.setSelectionBackground(new Color(255, 153, 255));
		table.setFont(new Font("Ubuntu", Font.BOLD, 16));
		//table.setBackground(new Color(182, 224, 232));
		
       
		model.addColumn("Doctor ID");
        model.addColumn("Name");
        model.addColumn("Department");
        model.addColumn("Gender");
        model.addColumn("Mobile");
        model.addColumn("Joining Date");

        RegDoctorList regDoctorList = new RegDoctorList();
		//String title = new String ("Dr. ");
		String title = "Dr. ";
        for(int i = 0; i < regDoctorList.doctorList.length; i++) {
            Doctor doctor = regDoctorList.doctorList[i];
            if (doctor != null) {
                if (doctor.getId() != null && doctor.getName() != null && doctor.getDepartment() != null) {
                    model.addRow(new Object[]{
                        doctor.getId(),
                        title + doctor.getName(),
                        doctor.getDepartment(),
                        doctor.getGender(),
                        doctor.getMobileNo(),
                        doctor.getJoiningDate()
                    });
                }
            }
        }
        }

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 150, 850, 270);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getTableHeader().setFont(new Font("Ubuntu", Font.BOLD, 14));
        table.setRowHeight(25);
        panel.add(scrollPane);

        back = new JButton("BACK");
        back.setBounds(620, 470, 100, 40);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.addActionListener(this);
        panel.add(back);

        panel.setBackground(color1);
        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            Menu me = new Menu();
            me.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        DoctorList doctorList = new DoctorList();
        doctorList.setVisible(true);
    }
}
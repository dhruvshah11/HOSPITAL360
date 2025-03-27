package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Classes.*;

public class DrLogin extends JFrame implements MouseListener, ActionListener{
	
	JLabel nameLabel,lgnLabel,userLabel,passLabel,imgLabel;
	JTextField userTF;
	JPasswordField passTF;
	JButton lgnBtn, exitBtn;
	JPanel panel;
	Font font1,font2,font3;
	Color color1, color2, color3;
	ImageIcon img, icon;
	RegDoctorList rdl;
	
	
	public DrLogin(RegDoctorList rdl){
		super("Hospital 360 - Doctor Login");
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		icon = new ImageIcon("emp-info.png");
		this.setIconImage(icon.getImage());
		this.rdl = rdl;
		
		font1 = new Font("Ubuntu",Font.BOLD, 23);
		font2 = new Font("Ubuntu",Font.BOLD, 20);
		font3 = new Font("Ubuntu",Font.PLAIN, 14);
		
		color1 = new Color(0, 230, 230); // Electric cyan
		color2 = new Color(81, 0, 230); // Deep electric purple
		color3 = new Color(230, 230, 255); // Soft neon white
		
		panel = new JPanel();
		panel.setLayout(null);
		
		nameLabel = new JLabel("Hospital 360");
		nameLabel.setBounds(388,180,250,40);
		nameLabel.setFont(font1);
		panel.add(nameLabel);
		
		lgnLabel = new JLabel("Doctor Login");
		lgnLabel.setBounds(388,255,160,30);
		lgnLabel.setFont(font2);
		panel.add(lgnLabel);
		
		
		userLabel = new JLabel("Username: ");
		userLabel.setBounds(312,325,90,20);
		userLabel.setFont(font3);
		panel.add(userLabel);
		
		
		passLabel = new JLabel("Password: ");
		passLabel.setBounds(312,360,90,20);
		passLabel.setFont(font3);
		panel.add(passLabel);
		
		
		userTF = new JTextField();
		userTF.setBounds(388,326,150,20);
		
		panel.add(userTF);
		
		
		passTF = new JPasswordField();
		passTF.setBounds(388,360,150,20);
		
		panel.add(passTF);
		
		
		lgnBtn = new JButton("Login");
		lgnBtn.setBounds(343,415,70,30);
		lgnBtn.setBackground(color2);
		lgnBtn.setForeground(color3);
		lgnBtn.addMouseListener(this);
		lgnBtn.addActionListener(this);
		panel.add(lgnBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(448,415,70,30);
		exitBtn.setBackground(color2);
		exitBtn.setForeground(color3);
		exitBtn.addMouseListener(this);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		img = new ImageIcon("images/x.jpg");
		
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0,0,900,600);
		//imgLabel.setBounds(500,150,256,256);
		panel.add(imgLabel);
		
		
		
		panel.setBackground(color1);
		this.add(panel);
		
		
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){
		if(me.getSource () == lgnBtn){
			lgnBtn.setBackground(color1);
			lgnBtn.setForeground(color3);
		}
		else if(me.getSource () == exitBtn){
			exitBtn.setBackground(color1);
			exitBtn.setForeground(color3);
		}
	    
	 
		if(me.getSource () == lgnBtn){
			lgnBtn.setBackground(color2);
			lgnBtn.setForeground(Color.BLACK);
		}
		else if(me.getSource () == exitBtn){
			exitBtn.setBackground(Color.RED);
			exitBtn.setForeground(Color.BLACK);
		}
		 
	}
	 
	public void mouseExited(MouseEvent me){
		if(me.getSource () == lgnBtn){
			lgnBtn.setBackground(color1);
			lgnBtn.setForeground(color3);
		}
		else if(me.getSource () == exitBtn){
			exitBtn.setBackground(color1);
			exitBtn.setForeground(color3);
		}
	    
	 
		if(me.getSource () == lgnBtn){
			lgnBtn.setBackground(color2);
			lgnBtn.setForeground(color3);
		}
		else if(me.getSource () == exitBtn){
			exitBtn.setBackground(color2);
			exitBtn.setForeground(color3);
		}
		
		
	}
		
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
			
			if(ae.getSource() == exitBtn){
			System.exit(0);
			}
			else if(lgnBtn.getText().equals(command));{
			String name = userTF.getText();
			String pass = passTF.getText();
			
			if(!name.isEmpty() && !pass.isEmpty()){
				
				int index = rdl.doctorExists(name);
				if(index == -1){
					JOptionPane.showMessageDialog(this, "There is no doctor in this name!");
				}else{
					Doctor d = rdl.checkPassword(index, pass);
					if( d == null){
						JOptionPane.showMessageDialog(this, "The password is not correct!");
					}else{
						DrDashboard me = new DrDashboard(d, rdl);
						me.setVisible(true);
						this.setVisible(false);
					}
				}
				
			} else{
				JOptionPane.showMessageDialog(this, "You can not leave username/password field empty!");
			}
			
		}	
		
		
	}
	
}
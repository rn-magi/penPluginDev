import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.*;

public class ArduinoSimulaterFrame extends JFrame implements ActionListener {
	private ArduinoSimulaterEnviroment ase;
	private ArduinoSimulaterInternal asi;
	
	private JButton st_button1;
	private JButton st_button2;
	private JButton st_button3;
	private JButton st_button4;
	private JButton st_button5;
	private JButton st_button6;
	
	private int st_bu1 = 1;
	private int st_bu2 = 1;
	private int st_bu3 = 1;
	private int st_bu4 = 0;
	private int st_bu5 = 0;
	
	/*static JLabel L1 = new JLabel();
	static JLabel L2 = new JLabel();
	static JLabel L3 = new JLabel();*/
	
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();
	private ImageIcon icon = new ImageIcon("./plugin/CLCD-BOOSTER/screen.png");
	private ImageIcon icon1 = new ImageIcon("./plugin/CLCD-BOOSTER//button2.png");
	private ImageIcon icon2 = new ImageIcon("./plugin/CLCD-BOOSTER/button1.png");
	private ImageIcon icon3 = new ImageIcon("./plugin/CLCD-BOOSTER/icon3.png");
	private ImageIcon icon4 = new ImageIcon("./plugin/CLCD-BOOSTER/icon4.png");
	private ImageIcon icon5 = new ImageIcon("./plugin/CLCD-BOOSTER/icon5.png");
	
	public ArduinoSimulaterFrame(ArduinoSimulaterEnviroment ase,
									ArduinoSimulaterInternal asi) {
		this.ase = ase;
		this.asi = asi;
		
		this.setBounds(750, 200, 260, 250);
		
		//フレームの表示
		this.setVisible(true);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.lightGray);
		
		setLayout(new FlowLayout());
		JLabel label = new JLabel();
		label.setIcon(icon);
		p1.setPreferredSize(new Dimension(290, 100));
		p1.add(label);

		JLabel L1 = new JLabel("		 SW1	");
		JLabel L2 = new JLabel("		SW2			 ");
		JLabel L3 = new JLabel("		SW3");
		//L1.setVerticalAlignment(JLabel.BOTTOM);
		//L2.setVerticalAlignment(JLabel.BOTTOM);
		//L3.setVerticalAlignment(JLabel.BOTTOM);
		p2.add(L1);
		p2.add(L2);
		p2.add(L3);
		
		st_button1 = new JButton(icon1);// button を　作る
		st_button2 = new JButton(icon1);
		st_button3 = new JButton(icon1);
		st_button4 = new JButton(icon3);
		st_button5 = new JButton(icon3);
		st_button6 = new JButton("Internal");
		
		p2.setLayout(new GridLayout(1, 3));
		p3.setLayout(new GridLayout(1, 3));
		p4.setLayout(new GridLayout(1, 3));
		p5.setLayout(new GridLayout(1, 1));
		
		st_button1.addActionListener(this);
		st_button2.addActionListener(this);
		st_button3.addActionListener(this);
		st_button4.addActionListener(this);
		st_button5.addActionListener(this);
		st_button6.addActionListener(this);
		
		p3.add(st_button1);
		p3.add(st_button2);
		p3.add(st_button3);
		p4.add(st_button4);
		p4.add(st_button5);
		p5.add(st_button6);
		
		Container contentPane = getContentPane();
		contentPane.add(p1, BorderLayout.NORTH);
		contentPane.add(p2, BorderLayout.CENTER);
		contentPane.add(p3, BorderLayout.CENTER);
		contentPane.add(p4, BorderLayout.SOUTH);
		contentPane.add(p5, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == st_button1) {
			if(st_bu1 == 0) {
				st_button1.setIcon(icon1);
				st_bu1 = 1;
			} else {
				st_button1.setIcon(icon2);
				st_bu1 = 0;
			}
		} else if(e.getSource() == st_button2) {
			if(st_bu2 == 0) {
				st_button2.setIcon(icon1);
				st_bu2 = 1;
			} else {
				st_button2.setIcon(icon2);
				st_bu2 = 0;
			}
		} else if(e.getSource() == st_button3) {
			if(st_bu3 == 0) {
				st_button3.setIcon(icon1);
				st_bu3 = 1;
			} else {
				st_button3.setIcon(icon2);
				st_bu3 = 0;
			}
		} else if(e.getSource() == st_button4) {
			if(st_bu4 == 0) {
				st_button4.setIcon(icon3);
				st_bu4 = 1;
			} else {
				st_button4.setIcon(icon4);
				st_bu4 = 0;
			}
		} else if(e.getSource() == st_button5) {
			if(st_bu5 == 0) {
				st_button5.setIcon(icon3);
				st_bu5 = 1;
			} else {
				st_button5.setIcon(icon5);
				st_bu5 = 0;
			}
		} else if(e.getSource() == st_button6){
			asi.setVisible(true);
		}
	}
	
	public void setLEDon(int i){
		if(i == 13){
			st_button4.setIcon(icon4);
		} else if(i == 10){
			st_button5.setIcon(icon5);
		}
	}
	
	public void setLEDoff(int i){
		 if(i == 13){
			 st_button4.setIcon(icon3);
		 } else if(i == 10){
			 st_button5.setIcon(icon3);;
		 }
	}
	
	public void INPUT(){
	}
	
	public void OUTPUT(){ 
	}
	
	public void pinMode(int pin, int mode){
	}
	
	public int digitalRead(int pin){
		asi.setCurrentCommandTest("digitalRead(" + pin + ")");
		
		if(pin == 6){
			return st_bu1;
		} else if(pin == 7){
			return st_bu2;
		} else if(pin == 8){
			return st_bu3;
		} else {
			return 0;
		}
	}
	
	public void digitalWrite(int pin, int value){
		asi.setCurrentCommandTest("digitalWrite(" + pin + "," + value + ")");
		
		if(value == 0){
			setLEDoff(pin);
		} else if(value == 1){
			setLEDon(pin);
		}
	}
	
	public int analogRead(int pin){
		asi.setCurrentCommandTest("analogRead(" + pin + ")");
		
		if(pin == 4){
			return ase.getPhotoSensorValue();
		} else if(pin == 5){
			return ase.getTempSensorValue();
		} else {
			return 0;
		}
	}
	
	public void analogWrite(int pin, int value){
		asi.setCurrentCommandTest("analogWrite(" + pin + "," + value + ")");
	}
}
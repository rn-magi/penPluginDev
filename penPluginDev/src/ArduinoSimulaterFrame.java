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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;

public class ArduinoSimulaterFrame extends JFrame implements ActionListener {
	private ArduinoSimulaterEnviroment ase;
	private ArduinoSimulaterInternal asi;
	
	private JLabel lcdLabel = new JLabel();
	private JLabel switchLabel1 = new JLabel("SW1");
	private JLabel switchLabel2 = new JLabel("SW2");
	private JLabel switchLabel3 = new JLabel("SW3");
	
	private JButton switchButton1;
	private JButton switchButton2;
	private JButton switchButton3;
	private JButton ledGreenButton;
	private JButton ledRedButton;
	private JButton internalButton;
	
	private int switchButton1Flag = 1;
	private int switchButton2Flag = 1;
	private int switchButton3Flag = 1;
	private int ledGreenButtonFlag	= 0;
	private int ledRedButtonFlag	= 0;
	
	private JPanel switchPanel	= new JPanel();
	private JPanel ledPanel		= new JPanel();
	
	public static final ImageIcon lcdIcon		= new ImageIcon("./plugin/CLCD-BOOSTER/LCD.png");
	public static final ImageIcon buttonOFFicon	= new ImageIcon("./plugin/CLCD-BOOSTER/button_OFF.png");
	public static final ImageIcon buttonONicon	= new ImageIcon("./plugin/CLCD-BOOSTER/button_ON.png");
	public static final ImageIcon ledOFFicon	= new ImageIcon("./plugin/CLCD-BOOSTER/LED_OFF.png");
	public static final ImageIcon ledGreenIcon	= new ImageIcon("./plugin/CLCD-BOOSTER/LED_Green.png");
	public static final ImageIcon ledRedIcon	= new ImageIcon("./plugin/CLCD-BOOSTER/LED_Red.png");
	
	public ArduinoSimulaterFrame(ArduinoSimulaterEnviroment ase,
									ArduinoSimulaterInternal asi) {
		this.ase = ase;
		this.asi = asi;
		
		this.setTitle("CLCD-BOOSTER Simulater");
		this.setSize(300,250);
		this.setLocation(750,150);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.lightGray);
		
		this.setLayout(new FlowLayout());
		
		lcdLabel.setIcon(lcdIcon);
		
		switchButton1 = new JButton(buttonOFFicon);
		switchButton1.addActionListener(this);
		
		switchButton2 = new JButton(buttonOFFicon);
		switchButton2.addActionListener(this);
		
		switchButton3 = new JButton(buttonOFFicon);
		switchButton3.addActionListener(this);
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		switchPanel.setLayout(gbl);
		
		gbc.gridx = 0; gbc.gridy = 0;
		gbl.setConstraints(switchLabel1, gbc);
		gbc.gridx = 1; gbc.gridy = 0;
		gbl.setConstraints(switchLabel2, gbc);
		gbc.gridx = 2; gbc.gridy = 0;
		gbl.setConstraints(switchLabel3, gbc);

		gbc.gridx = 0; gbc.gridy = 1;
		gbl.setConstraints(switchButton1, gbc);
		gbc.gridx = 1; gbc.gridy = 1;
		gbl.setConstraints(switchButton2, gbc);
		gbc.gridx = 2; gbc.gridy = 1;
		gbl.setConstraints(switchButton3, gbc);
		
		switchPanel.add(switchLabel1);
		switchPanel.add(switchLabel2);
		switchPanel.add(switchLabel3);
		switchPanel.add(switchButton1);
		switchPanel.add(switchButton2);
		switchPanel.add(switchButton3);
		
		ledGreenButton = new JButton(ledOFFicon);
		ledGreenButton.addActionListener(this);
		ledRedButton = new JButton(ledOFFicon);
		ledRedButton.addActionListener(this);
		ledPanel.setLayout(new GridLayout(1, 3));
		ledPanel.add(ledGreenButton);
		ledPanel.add(ledRedButton);

		internalButton = new JButton("Internal");
		internalButton.addActionListener(this);
		
		this.getContentPane().add(lcdLabel, BorderLayout.NORTH);
		this.getContentPane().add(switchPanel, BorderLayout.CENTER);
		this.getContentPane().add(ledPanel, BorderLayout.SOUTH);
		this.getContentPane().add(internalButton, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == switchButton1) {
			if(switchButton1Flag == 0) {
				switchButton1.setIcon(buttonOFFicon);
				switchButton1Flag = 1;
			} else {
				switchButton1.setIcon(buttonONicon);
				switchButton1Flag = 0;
			}
		} else if(e.getSource() == switchButton2) {
			if(switchButton2Flag == 0) {
				switchButton2.setIcon(buttonOFFicon);
				switchButton2Flag = 1;
			} else {
				switchButton2.setIcon(buttonONicon);
				switchButton2Flag = 0;
			}
		} else if(e.getSource() == switchButton3) {
			if(switchButton3Flag == 0) {
				switchButton3.setIcon(buttonOFFicon);
				switchButton3Flag = 1;
			} else {
				switchButton3.setIcon(buttonONicon);
				switchButton3Flag = 0;
			}
		} else if(e.getSource() == ledGreenButton) {
			if(ledGreenButtonFlag == 0) {
				ledGreenButton.setIcon(ledGreenIcon);
				ledGreenButtonFlag = 1;
			} else {
				ledGreenButton.setIcon(ledOFFicon);
				ledGreenButtonFlag = 0;
			}
		} else if(e.getSource() == ledRedButton) {
			if(ledRedButtonFlag == 0) {
				ledRedButton.setIcon(ledRedIcon);
				ledRedButtonFlag = 1;
			} else {
				ledRedButton.setIcon(ledOFFicon);
				ledRedButtonFlag = 0;
			}
		} else if(e.getSource() == internalButton){
			asi.setVisible(true);
		}
	}
	
	public void setLEDon(int pin){
		if(pin == 13){
			ledGreenButton.setIcon(ledGreenIcon);
		} else if(pin == 10){
			ledRedButton.setIcon(ledRedIcon);
		}
	}
	
	public void setLEDoff(int pin){
		 if(pin == 13){
			 ledGreenButton.setIcon(ledOFFicon);
		 } else if(pin == 10){
			 ledRedButton.setIcon(ledOFFicon);;
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
			return switchButton1Flag;
		} else if(pin == 7){
			return switchButton2Flag;
		} else if(pin == 8){
			return switchButton3Flag;
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
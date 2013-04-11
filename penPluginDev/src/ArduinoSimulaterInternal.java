import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridLayout;

public class ArduinoSimulaterInternal extends JFrame {
	private JLabel label = new JLabel("Current command");
	private JLabel tempLabel	= new JLabel();
	private JLabel photoLabel	= new JLabel();

	public ArduinoSimulaterInternal(){
		this.setTitle("画面変数表示");
		this.setBounds(100, 100, 500, 150);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.lightGray);
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		
		getContentPane().setLayout(null);
		getContentPane().add(p);
		getContentPane().add(p1);
	 
		p.setLayout(new GridLayout(1,1));
		p1.setLayout(new GridLayout(2,1));
		
		p.setBounds(20, 10, 350, 30);
		p1.setBounds(20, 70, 350, 30);
		p.add(label);
		p1.add(tempLabel);
		p1.add(photoLabel);
	}
	
	public void setTemp(int tempSensorValue, String labelName){
		tempLabel.setText("温度値：" + tempSensorValue);
	}
	
	public void setPhoto(int photoSensorValue, String labelName){
		photoLabel.setText("照度値：" + photoSensorValue);
	}
	
	public void setCurrentCommandTest(String command){
		label.setText("Current command - " + command);
	}
}
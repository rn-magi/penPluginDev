import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.event.*;

public class ArduinoSimulaterEnviroment extends JFrame implements ChangeListener {
	private ArduinoSimulaterInternal asi;
	
	private JSlider tempSensorSlider	= new JSlider(-40,125);
	private JSlider photoSensorSlider	= new JSlider(0,1000);
	private JSlider soundSlider			= new JSlider(0,100);
	
	private JLabel tempLabel	= new JLabel();
	private JLabel photoLabel	= new JLabel();
	private JLabel soundLabel	= new JLabel();
	
	public ArduinoSimulaterEnviroment(ArduinoSimulaterInternal asi) {
		this.asi = asi;

		this.setTitle("SensorValue");
		this.setSize(300,200);
		this.setLocation(750,400);

		tempSensorSlider.addChangeListener(this);
		photoSensorSlider.addChangeListener(this);
		soundSlider.addChangeListener(this);
		
		photoSensorSlider.setLabelTable(photoSensorSlider.createStandardLabels(20));
		
		JPanel p = new JPanel();
		JPanel panelBase = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		int tempSensorValue	= tempSensorSlider.getValue();
		int photoSensorValue = photoSensorSlider.getValue();
		
		String tempSensorString = "温度値：" + tempSensorValue;
		String photoSensorString = "照度値：" + photoSensorValue;
		
		tempLabel.setText(tempSensorString);
		photoLabel.setText(photoSensorString);
		//soundLabel.setText("音声：" + soundSlider.getValue());

		asi.setTemp(tempSensorValue, tempSensorString);
		asi.setPhoto(photoSensorValue, photoSensorString);
		
		getContentPane().setLayout(null);
		getContentPane().add(p);
		tempSensorSlider.addChangeListener(this);
		getContentPane().add(p1);
		photoSensorSlider.addChangeListener(this);
		//getContentPane().add(p2);
		//soundSlider.addChangeListener(this);
		
		p.setLayout(new GridLayout(2,1 ));
		p1.setLayout(new GridLayout(2,1));
		//p2.setLayout(new GridLayout(2, 1));
	
		p.add(tempLabel);
		panelBase.add(photoSensorSlider);
		p.add(tempSensorSlider);
		p1.add(photoLabel);
		p1.add(photoSensorSlider);
		//p2.add(label2);
		//p2.add(soundSlider);
		
		this.setBackground(Color.lightGray);
		p.setBounds(50, 10, 150, 30);
		p1.setBounds(50, 70, 150, 30);
		p2.setBounds(50, 130, 150, 30);
	}
	
	public void stateChanged(ChangeEvent e) {
		int tempSensorValue	= tempSensorSlider.getValue();
		int photoSensorValue = photoSensorSlider.getValue();
		
		String tempSensorString = "温度値：" + tempSensorValue;
		String photoSensorString = "照度値：" + photoSensorValue;
		
		tempLabel.setText(tempSensorString);
		photoLabel.setText(photoSensorString);
		//soundLabel.setText("音声：" + soundSlider.getValue());

		asi.setTemp(tempSensorValue, tempSensorString);
		asi.setPhoto(photoSensorValue, photoSensorString);
	}
	
	public int getTempSensorValue(){
		return tempSensorSlider.getValue();
	}
	
	public int getPhotoSensorValue(){
		return photoSensorSlider.getValue();
	}
}
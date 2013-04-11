import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.event.*;

public class ArduinoSimulaterEnviroment extends JFrame implements ChangeListener {
	private ArduinoSimulaterInternal asi;
	
	private JSlider tempSensorSlider	= new JSlider(-40,125);
	private JSlider photoSensorSlider	= new JSlider(0,1000);
	
	private JLabel tempLabel	= new JLabel();
	private JLabel photoLabel	= new JLabel();

	private JPanel sensorPanel = new JPanel();
	
	public ArduinoSimulaterEnviroment(ArduinoSimulaterInternal asi) {
		this.asi = asi;

		this.setTitle("SensorValue");
		this.setSize(300,200);
		this.setLocation(750,400);
		this.setLayout(new FlowLayout());
		this.setBackground(Color.lightGray);

		tempSensorSlider.addChangeListener(this);
		photoSensorSlider.addChangeListener(this);
		
		photoSensorSlider.setLabelTable(photoSensorSlider.createStandardLabels(20));
		
		int tempSensorValue	= tempSensorSlider.getValue();
		int photoSensorValue = photoSensorSlider.getValue();
		
		String tempSensorString = "温度値：" + tempSensorValue;
		String photoSensorString = "照度値：" + photoSensorValue;
		
		tempLabel.setText(tempSensorString);
		photoLabel.setText(photoSensorString);

		asi.setTemp(tempSensorValue, tempSensorString);
		asi.setPhoto(photoSensorValue, photoSensorString);
		
		tempSensorSlider.addChangeListener(this);
		photoSensorSlider.addChangeListener(this);
		
		sensorPanel.setLayout(new GridLayout(4,1));
	
		sensorPanel.add(tempLabel);
		sensorPanel.add(tempSensorSlider);
		sensorPanel.add(photoLabel);
		sensorPanel.add(photoSensorSlider);
		sensorPanel.setPreferredSize(new Dimension(200, 100));
		
		this.getContentPane().add(sensorPanel);
	}
	
	public void stateChanged(ChangeEvent e) {
		int tempSensorValue	= tempSensorSlider.getValue();
		int photoSensorValue = photoSensorSlider.getValue();
		
		String tempSensorString = "温度値：" + tempSensorValue;
		String photoSensorString = "照度値：" + photoSensorValue;
		
		tempLabel.setText(tempSensorString);
		photoLabel.setText(photoSensorString);

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
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.event.*;

public class ArduinoSimulaterEnviroment extends JFrame implements ChangeListener {
	private ArduinoSimulaterFrame asf;
	private ArduinoSimulaterEnviroment ase;
	private ArduinoSimulaterInternal asi;
	
	private JSlider tempSensorSlider	= new JSlider(-50,300,20);
	private JSlider photoSensorSlider	= new JSlider(0,1023,180);
	
	private JLabel tempLabel	= new JLabel();
	private JLabel photoLabel	= new JLabel();
	
	private JPanel sensorPanel	= new JPanel();
	
	private Hashtable photoSensorSliderScale = new Hashtable();

	private boolean sensorFlag = false;
	
	public ArduinoSimulaterEnviroment() {
		this.setTitle("Arduino環境設定");
		this.setSize(300, 230);
		this.setLocation(700, 320);
		this.setLayout(new FlowLayout());
		this.setBackground(Color.lightGray);
		
		tempSensorSlider.setPaintTicks(true);
		tempSensorSlider.setMajorTickSpacing(40);
		tempSensorSlider.setMinorTickSpacing(10);

		photoSensorSliderScale.put(0, new JLabel("真暗"));
		photoSensorSliderScale.put(180, new JLabel("室内"));
		photoSensorSliderScale.put(650, new JLabel("室外曇"));
		photoSensorSliderScale.put(980, new JLabel("室外晴"));

		photoSensorSlider.setPaintTicks(true);
		photoSensorSlider.setMajorTickSpacing(100);
		photoSensorSlider.setMinorTickSpacing(25);
		photoSensorSlider.setPaintLabels(true);
		photoSensorSlider.setLabelTable(photoSensorSliderScale);
		
		tempSensorSlider.addChangeListener(this);
		photoSensorSlider.addChangeListener(this);
		
		sensorPanel.setLayout(new GridLayout(4,1));
		sensorPanel.setPreferredSize(new Dimension(250, 180));
	
		sensorPanel.add(tempLabel);
		sensorPanel.add(tempSensorSlider);
		sensorPanel.add(photoLabel);
		sensorPanel.add(photoSensorSlider);
		
		this.add(sensorPanel);
	}
	
	public void stateChanged(ChangeEvent e) {
		if(sensorFlag){
			sensorFlag = false;
		} else {
			if(e.getSource().equals(tempSensorSlider)){
				changeTempSensorLabel();
			} else if(e.getSource().equals(photoSensorSlider)){
				changePhotoSensorLabel();
			}
		}
	}
	
	public int getTempSensorValue(){
		return tempSensorSlider.getValue();
	}
	
	public void setTempSensorLabel(int tempValue){
		String tempSensorString = "温度：" + tempValue + "℃";
		tempLabel.setText(tempSensorString);
	}
	
	public void changeTempSensorLabel(){
		setTempSensorLabel(getTempSensorValue());
		asi.setTempValue(tempConvert(getTempSensorValue()));
	}
	
	public void changeTempSensorSlider(int tempValue){
		sensorFlag = true;
		tempSensorSlider.setValue(tempValue);
		setTempSensorLabel(tempValue);
	}
	
	public int getPhotoSensorValue(){
		return photoSensorSlider.getValue();
	}
	
	public void setPhotoSensorLabel(int photoValue){
		String photoSensorString = "照度";
		photoLabel.setText(photoSensorString);
	}
	
	public void changePhotoSensorLabel(){
		setPhotoSensorLabel(getPhotoSensorValue());
		asi.setPhotoValue(photoConvert(getPhotoSensorValue()));
	}
	
	public void changePhotoSensorSlider(int photoValue){
		sensorFlag = true;
		photoSensorSlider.setValue(photoValue);
		setPhotoSensorLabel(photoValue);
	}

	public int tempConvert(int tempSensorValue){
		int tempValue = (int) (((tempSensorValue * 0.01953) + 0.4) * 1024 / 5.1);
		
		if(tempValue < 0){
			return 0;
		} else if(tempValue > 1023){
			return 1023;
		} else {
			return tempValue;
		}
	}
	
	public int photoConvert(int photSensorValue){
		int photoValue = photSensorValue;
		return photoValue;
	}
	
	public void setJFrame(ArduinoSimulaterFrame asf,
							ArduinoSimulaterEnviroment ase,
							ArduinoSimulaterInternal asi){
		this.asf = asf;
		this.ase = ase;
		this.asi = asi;
	}
}
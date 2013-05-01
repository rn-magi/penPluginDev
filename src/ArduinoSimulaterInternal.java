import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ArduinoSimulaterInternal extends JFrame implements ChangeListener{
	private ArduinoSimulaterFrame asf;
	private ArduinoSimulaterEnviroment ase;
	private ArduinoSimulaterInternal asi;
	
	private JLabel commandLabel = new JLabel("Current command");
	private JLabel tempLabel	= new JLabel();
	private JLabel photoLabel	= new JLabel();
	
	private SpinnerNumberModel tempValueSNM		= new SpinnerNumberModel(0,0,1023,1);
	private SpinnerNumberModel photoValueSNM	= new SpinnerNumberModel(0,0,1023,1);
	
	private JSpinner tempSpinner	= new JSpinner(tempValueSNM);
	private JSpinner photoSpinner	= new JSpinner(photoValueSNM);
	
	private JPanel internalPanel	= new JPanel();
	private JPanel tempSensorPanel	= new JPanel();
	private JPanel photoSensorPanel	= new JPanel();

	public ArduinoSimulaterInternal(){
		this.setTitle("Arduino内部状態");
		this.setSize(300, 150);
		this.setLocation(700, 550);
		this.setLayout(new FlowLayout());
		this.setBackground(Color.lightGray);
		
		internalPanel.setPreferredSize(new Dimension(250, 100));
		internalPanel.setLayout(new GridLayout(3,1));
		
		tempLabel.setText("温度値：");
		photoLabel.setText("照度値：");
		
		JSpinner.NumberEditor tempSensorEditor = new JSpinner.NumberEditor(tempSpinner, "####");
		tempSpinner.setEditor(tempSensorEditor);
		tempSpinner.setPreferredSize(new Dimension(50,20));
		tempSpinner.addChangeListener(this);
		
		JSpinner.NumberEditor photoSensorEditor = new JSpinner.NumberEditor(photoSpinner, "####");
		photoSpinner.setEditor(photoSensorEditor);
		photoSpinner.setPreferredSize(new Dimension(50,20));
		photoSpinner.addChangeListener(this);
		
		tempSensorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tempSensorPanel.add(tempLabel);
		tempSensorPanel.add(tempSpinner);
		
		photoSensorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		photoSensorPanel.add(photoLabel);
		photoSensorPanel.add(photoSpinner);

		internalPanel.add(commandLabel);
		internalPanel.add(tempSensorPanel);
		internalPanel.add(photoSensorPanel);
		
		this.add(internalPanel);
	}
	
	public int getTempValue(){
		return Integer.valueOf(tempSpinner.getValue().toString());
	}
	
	public void setTempValue(int tempSensorValue){
		tempSpinner.setValue(tempSensorValue);
	}
	
	public int getPhotoValue(){
		return Integer.valueOf(photoSpinner.getValue().toString());
	}
	
	public void setPhotoValue(int photoSensorValue){
		photoSpinner.setValue(photoSensorValue);
	}
	
	public void setCurrentCommand(String command){
		commandLabel.setText("Current command - " + command);
	}
	
	public void setJFrame(ArduinoSimulaterFrame asf,
							ArduinoSimulaterEnviroment ase,
							ArduinoSimulaterInternal asi){
		this.asf = asf;
		this.ase = ase;
		this.asi = asi;
	}

	public void stateChanged(ChangeEvent e) {
		int temp = Integer.valueOf(tempSpinner.getValue().toString());
		int tmepValue = (int) (((5.1 / 1024 * temp) - 0.4) / 0.01953);
		ase.changeTempSensorSlider(tmepValue);
		ase.changePhotoSensorSlider(Integer.valueOf(photoSpinner.getValue().toString()));
	}
}
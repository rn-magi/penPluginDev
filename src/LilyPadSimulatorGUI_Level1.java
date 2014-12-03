import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class LilyPadSimulatorGUI_Level1 extends JFrame implements ChangeListener, penPlugin {
	private JPanel contentPane = new JPanel();
	private JPanel LilyPadPanel = new LilyPadPanel();
	private JPanel LED1 = new JPanel();
	private JPanel LED2 = new JPanel();
	private JPanel LED3 = new JPanel();
	private JPanel LED4 = new JPanel();
	private JPanel LED5 = new JPanel();
	private JPanel FullColorLED = new JPanel();
	private JToggleButton SlideSwitch = new JToggleButton("OFF");
	private JToggleButton ButtonSwitch = new JToggleButton("OFF");
	private JSlider TempSlider = new JSlider();
	private JSlider LightSlider = new JSlider();
	private JPanel SensorPanel = new JPanel();
	private JPanel TempPanel = new JPanel();
	private JPanel LightPanel = new JPanel();
	private JLabel TempLabel = new JLabel("温度センサー");
	private JLabel LightLabel = new JLabel("光センサー");
	private JLabel TempValue = new JLabel("0");
	private JLabel LightValue = new JLabel("0");

	public LilyPadSimulatorGUI_Level1() {
		setTitle("LilyPad Development Board");
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 553, 520);
		setContentPane(contentPane);

		contentPane.setLayout(null);
		
		LilyPadPanel.setBounds(0, 0, 553, 388);
		LilyPadPanel.setLayout(null);
		contentPane.add(LilyPadPanel);
		
		LED1.setBorder(new LineBorder(Color.WHITE, 1));
		LED1.setBackground(Color.BLACK);
		LED1.setBounds(163, 326, 15, 10);
		LilyPadPanel.add(LED1);
		
		LED2.setBorder(new LineBorder(Color.WHITE, 1));
		LED2.setBackground(Color.BLACK);
		LED2.setBounds(215, 326, 15, 10);
		LilyPadPanel.add(LED2);
		
		LED3.setBorder(new LineBorder(Color.WHITE, 1));
		LED3.setBackground(Color.BLACK);
		LED3.setBounds(267, 326, 15, 10);
		LilyPadPanel.add(LED3);
		
		LED4.setBorder(new LineBorder(Color.WHITE, 1));
		LED4.setBackground(Color.BLACK);
		LED4.setBounds(319, 326, 15, 10);
		LilyPadPanel.add(LED4);
		
		LED5.setBorder(new LineBorder(Color.WHITE, 1));
		LED5.setBackground(Color.BLACK);
		LED5.setBounds(371, 326, 15, 10);
		LilyPadPanel.add(LED5);

		FullColorLED.setBorder(new LineBorder(Color.WHITE, 1));
		FullColorLED.setBackground(Color.BLACK);
		FullColorLED.setBounds(65, 186, 15, 15);
		LilyPadPanel.add(FullColorLED);
		
		ButtonSwitch.addChangeListener(this);
		ButtonSwitch.setBounds(56, 276, 33, 18);
		ButtonSwitch.setMargin(new Insets(0,0,0,0));
		LilyPadPanel.add(ButtonSwitch);

		SlideSwitch.addChangeListener(this);
		SlideSwitch.setBounds(56, 328, 33, 18);
		SlideSwitch.setMargin(new Insets(0,0,0,0));
		LilyPadPanel.add(SlideSwitch);
		
		SensorPanel.setBounds(0, 388, 553, 112);
		SensorPanel.setLayout(new BoxLayout(SensorPanel, BoxLayout.Y_AXIS));
		contentPane.add(SensorPanel);
		
		SensorPanel.add(TempPanel);
		SensorPanel.add(LightPanel);
		
		TempPanel.setLayout(new BoxLayout(TempPanel, BoxLayout.X_AXIS));
		TempLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		TempLabel.setPreferredSize(new Dimension(100, 100));
		TempPanel.add(TempLabel);
		
		TempSlider.setPaintTicks(true);
		TempSlider.setMinorTickSpacing(50);
		TempSlider.setMajorTickSpacing(100);
		TempSlider.setValue(100);
		TempSlider.setMaximum(1023);
		TempSlider.addChangeListener(this);
		TempPanel.add(TempSlider);
		
		TempValue.setHorizontalAlignment(SwingConstants.CENTER);
		TempValue.setText(String.valueOf(TempSlider.getValue()));
		TempValue.setPreferredSize(new Dimension(75, 100));
		TempPanel.add(TempValue);
		
		LightPanel.setLayout(new BoxLayout(LightPanel, BoxLayout.X_AXIS));
		LightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		LightLabel.setPreferredSize(new Dimension(100, 100));
		LightPanel.add(LightLabel);

		LightSlider.setPaintTicks(true);
		LightSlider.setMinorTickSpacing(50);
		LightSlider.setMajorTickSpacing(100);
		LightSlider.setValue(100);
		LightSlider.setMaximum(1023);
		LightSlider.addChangeListener(this);
		LightPanel.add(LightSlider);
		
		LightValue.setHorizontalAlignment(SwingConstants.CENTER);
		LightValue.setText(String.valueOf(LightSlider.getValue()));
		LightValue.setPreferredSize(new Dimension(75, 100));
		LightPanel.add(LightValue);
	}

	public void pinMode(int pin, String mode){
		setVisible();
	}

	public int digitalRead(int pin){
		setVisible();
		
		switch( pin ){
			case 2:
				if(SlideSwitch.isSelected()) {
					return 0;
				} else {
					return 1;
				}
			case 19:
				if(ButtonSwitch.isSelected()) {
					return 0;
				} else {
					return 1;
				}
		}
		return 0;
	}
	
	public void digitalWrite(int pin, int value){
		setVisible();
		
		analogWrite(pin, value * 255);
	}
	
	public int analogRead(int pin){
		setVisible();
		
		switch( pin ){
			case 1:
				return TempSlider.getValue();
			case 6:
				return LightSlider.getValue();
		}
		return 0;
	}
	
	public void analogWrite(int pin, int value){
		setVisible();
		
		Color fullColor =  FullColorLED.getBackground();
		int fullColorRed = fullColor.getRed();
		int fullColorGreen = fullColor.getGreen();
		int fullColorBlue = fullColor.getBlue();
		
		switch( pin ){
			case 5:
				LED1.setBackground(new Color(value, value, 0));
				break;
			case 6:
				LED2.setBackground(new Color(value, value, 0));
				break;
			case 16:
				LED3.setBackground(new Color(value, value, 0));
				break;
			case 18:
				LED4.setBackground(new Color(value, value, 0));
				break;
			case 17:
				LED5.setBackground(new Color(value, value, 0));
				break;
			case 9:
				value = 255 - value;
				FullColorLED.setBackground(new Color(value, fullColorGreen, fullColorBlue));
				break;
			case 10:
				value = 255 - value;
				FullColorLED.setBackground(new Color(fullColorRed, fullColorGreen, value));
				break;
			case 11:
				value = 255 - value;
				FullColorLED.setBackground(new Color(fullColorRed, value, fullColorBlue));
				break;
		}
	}
	
	public void stateChanged(ChangeEvent evt) {
		if(evt.getSource().equals(SlideSwitch)) {
			if(SlideSwitch.isSelected()) {
				SlideSwitch.setText("ON");
			} else {
				SlideSwitch.setText("OFF");
			}
		} else if(evt.getSource().equals(ButtonSwitch)) {
			if(ButtonSwitch.isSelected()) {
				ButtonSwitch.setText("ON");
			} else {
				ButtonSwitch.setText("OFF");
			}
		} else if(evt.getSource().equals(TempSlider)) {
			TempValue.setText(String.valueOf(TempSlider.getValue()));
		} else if(evt.getSource().equals(LightSlider)) {
			LightValue.setText(String.valueOf(LightSlider.getValue()));
		}
	}
	
	public void setVisible(){
		if(!this.isShowing()) {
			setVisible(true);
		}
	}
	
	public void init(){
		LED1.setBackground(Color.BLACK);
		LED2.setBackground(Color.BLACK);
		LED3.setBackground(Color.BLACK);
		LED4.setBackground(Color.BLACK);
		LED5.setBackground(Color.BLACK);
		FullColorLED.setBackground(Color.BLACK);
	}

	public void destruction() {
	}
}

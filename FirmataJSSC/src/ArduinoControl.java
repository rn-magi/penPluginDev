import org.firmata.*;

public class ArduinoControl implements penPlugin {
	private Arduino arduino = null;
	
	public ArduinoControl() {
		
	}
	
	public void openPort(String port) {
		if(arduino == null) {
				arduino = new Arduino(port);
		}
	}
	
	public void closePort() {
		if(arduino != null) {
			arduino.dispose();
		}
		arduino = null;
	}
	
	public String portList(int i) {
		return Arduino.list()[i];
	}
	
	public int portListLength() {
		return Arduino.list().length;
	}
	
	public void pinMode(int pin, String mode) {
		mode.toUpperCase();
		if(arduino != null) {
			if(mode.equals("INPUT")) {
				arduino.pinMode(pin, Arduino.INPUT);
			} else if(mode.equals("OUTPUT")) {
				arduino.pinMode(pin, Arduino.OUTPUT);
			} else if(mode.equals("INPUT_PULLUP")) {
				arduino.pinMode(pin, Arduino.INPUT);
				arduino.digitalWrite(pin, Arduino.HIGH);
			}
		}
	}
	
	public int digitalRead(int pin) {
		if(arduino != null) {
			return arduino.digitalRead(pin);
		}
		return 0;
	}
	
	public void digitalWrite(int pin, int value) {
		if(arduino != null) {
			arduino.digitalWrite(pin, value);
		}
	}
	
	public int analogRead(int pin) {
		if(arduino != null) {
			return arduino.analogRead(pin);
		}
		return 0;
	}
	
	public void analogWrite(int pin, int value) {
		if(arduino != null) {
			arduino.analogWrite(pin, value);
		}
	}
	
	public void init() {
		
	}
	
	public void destruction() {
		if(arduino != null) {
			closePort();
		}
	}
}
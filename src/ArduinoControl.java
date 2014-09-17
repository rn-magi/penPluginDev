import com.shigeodayo.javarduino.Arduino;

public class ArduinoControl implements penPlugin {
	private Arduino arduino = null;
	private ArduinoSimulaterControl asc = null;
	
	public ArduinoControl(){
		
	}
	
	public void openPort(String port){
		if(asc == null && arduino == null){
			if(port.equals("SIM")){
				asc = new ArduinoSimulaterControl();
			} else {
				arduino = new Arduino(port);
			}
		}
	}
	
	public void closePort(){
		if(asc != null){
			asc.closePort();
		} else if(arduino != null){
			arduino.dispose();
		}
		asc = null;
		arduino = null;
	}
	
	public String portList(int i){
		return Arduino.list()[i];
	}
	
	public int portListLength(){
		return Arduino.list().length;
	}
	
	public void pinMode(int pin, String mode){
		mode.toUpperCase();
		if(asc != null){
			asc.pinMode(pin, mode);
		} else if(mode.equals("INPUT")){
			arduino.pinMode(pin, Arduino.INPUT);
		} else if(mode.equals("OUTPUT")){
			arduino.pinMode(pin, Arduino.OUTPUT);
		}
	}
	
	public int digitalRead(int pin){
		if(asc != null){
			return asc.digitalRead(pin);
		}else{
			return arduino.digitalRead(pin);
		}
	}
	
	public void digitalWrite(int pin, int value){
		if(asc != null){
			asc.digitalWrite(pin, value);
		} else {
			arduino.digitalWrite(pin, value);
		}
	}
	
	public int analogRead(int pin){
		if(asc != null){
			return asc.analogRead(pin);
		} else {
			return arduino.analogRead(pin);
		}
	}
	
	public void analogWrite(int pin, int value){
		if(asc != null){
			asc.analogWrite(pin, value);
		} else {
			arduino.analogWrite(pin, value);
		}
	}
	
	public void destruction() {
		if(asc != null || arduino != null){
			closePort();
		}
	}
}
public class ArduinoControl implements penPlugin {
	private Arduino arduino;
	
	public ArduinoControl(){
		
	}
	
	public void openPort(String port){
		arduino = new Arduino(port);
	}
	
	public void closePort(){
		arduino.dispose();
	}
	
	public String portList(int i){
		return Arduino.list()[i];
	}
	
	public int portListLength(){
		return Arduino.list().length;
	}
	
	public void pinMode(int pin, String mode){
		mode.toUpperCase();
		if(mode.equals("INPUT")){
			arduino.pinMode(pin, Arduino.INPUT);
		} else if(mode.equals("OUTPUT")){
			arduino.pinMode(pin, Arduino.OUTPUT);
		}
	}
	
	public int digitalRead(int pin){
		return arduino.digitalRead(pin);
	}
	
	public void digitalWrite(int pin, int value){
		arduino.digitalWrite(pin, value);
	}
	
	public int analogRead(int pin){
		return arduino.analogRead(pin);
	}
	
	public void analogWrite(int pin, int value){
		arduino.analogWrite(pin, value);
	}

	public void destruction() {
		if(arduino.serial.port != null){
			closePort();
		}
	}
}

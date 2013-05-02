public class ArduinoSimulaterControl{
	private ArduinoSimulaterFrame asf		= new ArduinoSimulaterFrame();
	private ArduinoSimulaterEnviroment ase	= new ArduinoSimulaterEnviroment();
	private ArduinoSimulaterInternal asi	= new ArduinoSimulaterInternal();
	
	public ArduinoSimulaterControl(){
		asf.setJFrame(asf, ase, asi);
		ase.setJFrame(asf, ase, asi);
		asi.setJFrame(asf, ase, asi);
		
		ase.changeTempSensorLabel();
		ase.changePhotoSensorLabel();
		
		asf.setVisible(true);
		asf.initialize();
	}
	
	public void closePort(){
		asf.dispose();
		asi.dispose();
		ase.dispose();
	}

	public void pinMode(int pin, String mode){
		mode.toUpperCase();
		if(mode.equals("INPUT")){
			asf.pinMode(pin, Arduino.INPUT);
		} else if(mode.equals("OUTPUT")){
			asf.pinMode(pin, Arduino.OUTPUT);
		}
	}
	
	public int digitalRead(int pin){
		return asf.digitalRead(pin);
	}
	
	public void digitalWrite(int pin, int value){
		asf.digitalWrite(pin, value);
	}
	
	public int analogRead(int pin){
		return asf.analogRead(pin);
	}
	
	public void analogWrite(int pin, int value){
		asf.analogWrite(pin, value);
	}
}


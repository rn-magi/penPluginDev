public class ArduinoSimulaterControl{
	private ArduinoSimulaterFrame af;
	private ArduinoSimulaterEnviroment ase;
	private ArduinoSimulaterInternal asi;
	
	public ArduinoSimulaterControl(){
		asi = new ArduinoSimulaterInternal();
		ase = new ArduinoSimulaterEnviroment(asi);
		af = new ArduinoSimulaterFrame(ase, asi);
		
		af.setVisible(true);
		ase.setVisible(true);
	}
	
	public void closePort(){
		af.dispose();
		asi.dispose();
		ase.dispose();
	}

	public void pinMode(int pin, String mode){
		mode.toUpperCase();
		if(mode.equals("INPUT")){
			af.pinMode(pin, ArduinoSimulaterFrame.INPUT);
		} else if(mode.equals("OUTPUT")){
			af.pinMode(pin, ArduinoSimulaterFrame.OUTPUT);
		}
	}
	
	public int digitalRead(int pin){
		return af.digitalRead(pin);
	}
	
	public void digitalWrite(int pin, int value){
		af.digitalWrite(pin, value);
	}
	
	public int analogRead(int pin){
		return af.analogRead(pin);
	}
	
	public void analogWrite(int pin, int value){
		af.analogWrite(pin, value);
	}
}



public class Port {

	private final int BYTE = 8;
	private int IN;
	private int OUT;
	private int SEL0;
	private int SEL1;
	private int DIR;
	private int REN;
	private int DS;
	
	private String GPIO = "GPIO";
	private String HW1 = "HW1";
	private String HW2 = "HW2";
	private String HW3 = "HW3";
	private Pin[] pins = new Pin[BYTE];
	
	public Port() {
		IN = 0;
		OUT = 0;
		SEL0 = 0;
		SEL1 = 0;
		DIR = 0;
		REN = 0;
		DS = 0;	
		for (int i = 0; i < BYTE; i++) {
			pins[i] = new Pin();
		}
	}
	
	private void setPinReg(String reg, int value) {
		for (int i = 0; i < BYTE; i++ ) {
			boolean set = (value & 0x1) != 0;
			switch (reg) {
			case "IN" : pins[i].setIn(set); break;
			case "OUT" : pins[i].setOut(set); break;
			case "SEL0" : pins[i].setSel0(set); break;
			case "SEL1" : pins[i].setSel1(set); break;
			case "DIR" : pins[i].setDir(set); break;
			case "REN" : pins[i].setRen(set); break;
			case "DS" : pins[i].setDS(set); break;
			}
			value = value >>1;
		}
	}
	
	public void setIn(int val) {
		IN = val & 0xFF;
		setPinReg("IN",IN);
	}

	public void setOut(int val) {
		OUT = val & 0xFF;
		setPinReg("OUT",OUT);
	}

	public void setSel0(int val) {
		SEL0 = val & 0xFF;
		setPinReg("SEL0",SEL0);
	}

	public void setSel1(int val) {
		SEL1 = val & 0xFF;
		setPinReg("SEL1",SEL1);
	}

	public void setDir(int val) {
		DIR = val & 0xFF;
		setPinReg("DIR",DIR);
	}

	public void setRen(int val) {
		REN = val & 0xFF;
		setPinReg("REN",REN);
	}

	public void setDS(int val) {
		DS = val & 0xFF;
		setPinReg("DS",DS);
	}
	
	private void printConfig() {
		System.out.println("Printing Port Configuration: ");
		for (int i = 0; i < BYTE; i++) {
			System.out.println("   Pin "+i+": "+pins[i].getMode());
		}	
	}	

	public static void main(String[] args) {
		Port port = new Port();
		port.setSel0(0);
		port.setSel1(0);
		port.setDir(0x0F);
		port.setOut(0x53);
		port.setDS(0x0a);
		port.setRen(0xC0);
		port.printConfig();
	}

}

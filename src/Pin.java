
public class Pin {
	
	private boolean IN = false;
	private boolean OUT = false;
	private int SEL0 = 0;
	private int SEL1 = 0;
	private boolean DIR = false;
	private boolean REN = false;
	private boolean DS = false;
	String MODE = "";
	
	public void setIn(boolean setting) {
		IN = setting;
		updateConfig();
	}

	public void setOut(boolean setting) {
		OUT = setting;
		updateConfig();
	}
	public void setSel0(boolean setting) {
		SEL0 = setting ? 1 : 0;
		updateConfig();
	}

	public void setSel1(boolean setting) {
		SEL1 = setting ? 2 : 0;
		updateConfig();
	}

	public void setDir(boolean setting) {
		DIR = setting;		
		updateConfig();
	}

	public void setRen(boolean setting) {
		REN = setting;
		updateConfig();
	}
	
	public void setDS(boolean setting) {
		DS = setting;
		updateConfig();
	}
	
	public String getMode() {
		return MODE;
	}

	private void updateConfig() {
		switch (SEL0+SEL1) {
		case 0 : MODE = "GPIO";break;
		case 1 : MODE = "HW-1";break;
		case 2 : MODE = "HW-2";break;
		case 3 : MODE = "HW-3";break;
		}
		if ("GPIO".equals(MODE)) {
			MODE += (!DIR) ? "_IN" : "_OUT";
			if (!DIR) {
				if (REN) {
					MODE += (OUT) ? "_PULLUP" : "_PULLDOWN";
				} 
			} else {
				MODE += (OUT) ? "_DRIVE-HIGH" : "_DRIVE-LOW";
				MODE += (DS) ? "_HS" : "";
			}
		}
	}
}

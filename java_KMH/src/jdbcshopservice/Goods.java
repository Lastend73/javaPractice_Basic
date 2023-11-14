package jdbcshopservice;

public class Goods {
	private String GCODE;
	private String GNAME;
	private int GPRICE;
	private String GTYPE;
	private int GSTOCK;
	private String GSTATE;
	
	public String getGSTATE() {
		return GSTATE;
	}
	public void setGSTATE(String gSTATE) {
		GSTATE = gSTATE;
	}
	public String getGCODE() {
		return GCODE;
	}
	public void setGCODE(String gCODE) {
		GCODE = gCODE;
	}
	public String getGNAME() {
		return GNAME;
	}
	public void setGNAME(String gNAME) {
		GNAME = gNAME;
	}
	public int getGPRICE() {
		return GPRICE;
	}
	public void setGPRICE(int gPRICE) {
		GPRICE = gPRICE;
	}
	public String getGTYPE() {
		return GTYPE;
	}
	public void setGTYPE(String gTYPE) {
		GTYPE = gTYPE;
	}
	public int getGSTOCK() {
		return GSTOCK;
	}
	public void setGSTOCK(int gSTOCK) {
		GSTOCK = gSTOCK;
	}
	
}

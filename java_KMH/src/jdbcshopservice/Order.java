package jdbcshopservice;

public class Order {
	private String odcode;
	private String odgcode;
	private String odmid;
	private int odqty;
	
	public String getOdcode() {
		return odcode;
	}
	public String getOdmid() {
		return odmid;
	}
	public void setOdmid(String odmid) {
		this.odmid = odmid;
	}
	public void setOdcode(String odcode) {
		this.odcode = odcode;
	}
	public String getOdgcode() {
		return odgcode;
	}
	public void setOdgcode(String odgcode) {
		this.odgcode = odgcode;
	}
	public int getOdqty() {
		return odqty;
	}
	public void setOdqty(int odqty) {
		this.odqty = odqty;
	}
}

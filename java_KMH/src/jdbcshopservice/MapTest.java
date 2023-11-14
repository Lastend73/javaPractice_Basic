package jdbcshopservice;

import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		String sql = "SELECT";
		//key(이름), value(값) 상으로 데이터를 저장
		//HashMap<key타입, value 타입>
		HashMap<String, String> odInfo = new HashMap<>();
		//put(key,value)
		odInfo.put("GNAME", "모니터");
		odInfo.put("ODQTY", "1");
		
		System.out.println("상품이름 : "+ odInfo.get("GNAME") );
		System.out.println("주문수량 : "+ odInfo.get("ODQTY") );
	}

}

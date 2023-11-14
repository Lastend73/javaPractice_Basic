package jdbcshopservice;

import java.util.ArrayList;
import java.util.HashMap;

public class MapTest2 {

	public static void main(String[] args) {
		/*SELECT GNAME, GPRICE ODQTY, (GPRICE * ODQTY),ODDDATE
		 * while (rs.next()){
		 * 
		 * }
		 * */
		//rs.next() >> 레코드가 선택
		// ArrayList<Goods> goodList = new ArrayList<Good>();
		HashMap<String, String> odInfo = new HashMap<>();
		ArrayList<HashMap<String, String>> odlist =  new ArrayList<HashMap<String, String>>();
		
		odInfo.put("GNAME", "사이다");
		odInfo.put("GPRICE", 1500+"");
		odInfo.put("ODQTY", 2+"");
		odlist.add(odInfo);
		
		odInfo = new HashMap<>();
		odInfo.put("GNAME", "라면");
		odInfo.put("GPRICE", 1500+"");
		odInfo.put("ODQTY", 2+"");
		odlist.add(odInfo);

	}

}

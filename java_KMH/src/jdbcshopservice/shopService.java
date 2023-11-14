package jdbcshopservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class shopService {
	shopdao sdao = new shopdao();
	Scanner scan = new Scanner(System.in);
	

	public void order(String Id) {
		System.out.println("[1]전체상품 [2]종류별상품목록 [3]인기상품조회");
		System.out.print("선택하십시오 : ");
		ArrayList<Goods> goodList = new ArrayList<Goods>();
		int selectList = scan.nextInt();
		switch (selectList) {
		case 1:
			System.out.println("[모든 상품 조회]");
			goodList = sdao.SelectList_ALL();
			for (int i = 0; i < goodList.size(); i++) {
				System.out.print("[" + i + "]" + goodList.get(i).getGNAME()+" ");
				if(goodList.get(i).getGSTATE().equals("Y")) {
					System.out.print("[가격]" + goodList.get(i).getGPRICE()+" ");
					System.out.println("[수량]" + goodList.get(i).getGSTOCK()+" ");					
				}else {
					System.out.println("[판매가 중지된 상품입니다.]");
				}
			}
			System.out.println();
			break;
		case 2:
			System.out.println("[상품별 조회]");
			goodList = sdao.SelectList_type();
			if (goodList == null || goodList.size() <= 0) {
				System.out.println("오류");
			} else {
				for (int i = 0; i < goodList.size(); i++) {
					System.out.print("[" + i + "]" + goodList.get(i).getGTYPE() + " ");
				}

				if (goodList != null) {
					System.out.print("\n선택 >> ");
					int selecttype = scan.nextInt();
					String gtype = goodList.get(selecttype).getGTYPE();
					goodList = sdao.selectGoods_type(gtype);

					for (int i = 0; i < goodList.size(); i++) {
						System.out.print("[" + i + "]" + goodList.get(i).getGNAME());
						if(goodList.get(i).getGSTATE().equals("Y")) {
							System.out.print("[가격]" + goodList.get(i).getGPRICE()+" ");
							System.out.println("[수량]" + goodList.get(i).getGSTOCK()+" ");					
						}else {
							System.out.println("[판매가 중지된 상품입니다.]");
						}
					}

				}

			}
			break;
		case 3:
			System.out.println("[인기상품조회]");
			goodList = sdao.selectGoods_Best();
			if (goodList == null || goodList.size() <= 0) {
				System.out.println("문재발셍");
				return;
			}
			for (int i = 0; i < goodList.size(); i++) {
				System.out.print("[" + i + "]" + goodList.get(i).getGNAME() + " ");
				if(goodList.get(i).getGSTATE().equals("Y")) {
					System.out.print("[가격]" + goodList.get(i).getGPRICE()+" ");
					System.out.println("[수량]" + goodList.get(i).getGSTOCK()+" ");					
				}else {
					System.out.println("[판매가 중지된 상품입니다.]");
				}
			}
			break;
		} // switch 끝

		System.out.print("무엇을 구매하시겠습니까 >> ");
		int SelectMenu = scan.nextInt();
		System.out.print("몇개 구매하시겠습니까? >> ");
		int orderAmount = scan.nextInt();

		if (orderAmount < 0) {
			System.out.println("구매수량이 0개 입니다\n 다시 구매해주세요");
			return;
		}
		
		if ( goodList.get(SelectMenu).getGSTOCK() < orderAmount) {
			System.out.println("잔여 물품 갯수보다 더 많이 주문하셧습니다");
			return;
		}
		
		Order or = new Order();
		or.setOdcode(MaxOdcode());
		or.setOdgcode(goodList.get(SelectMenu).getGCODE());
		or.setOdmid(Id);
		or.setOdqty(orderAmount);
		int result = sdao.Insert(or);

		if (result > 0) {
			System.out.println("주문이 완료 되었습니다.");
		} else {
			System.out.println("주문이 완료되지 않았습니다");
		}
	}

	public String MaxOdcode() {

		String odcode = sdao.selectMaxOdcode();

		String str = odcode.substring(0, 1);
		int num = Integer.parseInt(odcode.substring(1)) + 1;
		String code = str + String.format("%04d", num);
		return code;
	}

	public void goodsList_map() {
		System.out.println("상품목록(Map)");
		// 1. 상품목록 Return (dao - SELECT >> service 리턴)
		ArrayList<HashMap<String, String>> goodslist = sdao.selectGoods_Map();
		// 2. 조회된 목록 상품 출력
		if (goodslist.size() < 0 || goodslist == null) {
			System.out.println("주문내역이 없습니다");
		} else {

			for (int i = 0; i < goodslist.size(); i++) {
				System.out.print(goodslist.get(i).get("gcode")  + " ");
				System.out.print(goodslist.get(i).get("gname") + " ");
				System.out.print(goodslist.get(i).get("gprice") + " ");
				System.out.print(goodslist.get(i).get("gtype") + " ");
				System.out.println(goodslist.get(i).get("gstock") + " ");

			}
		}
	}

	public void OrderList(String ID) {
		System.out.println("[주문내역]");
		System.out.println("[1]최근주문순 [2]총액높은순");
		System.out.print("선택 : ");
		int orderByOption = scan.nextInt();
		ArrayList<HashMap<String, String>> orderlist = sdao.OrderList(ID,orderByOption);
		if(orderlist == null) {
			System.out.println("주문 내역을 조회하는대 실패했습니다");
		}
		else if (orderlist.size() <= 0 ) {
			System.out.println("주문내역이 없습니다");
		} else {

			for (int i = 0; i < orderlist.size(); i++) {
				System.out.print("["+i+"][이름]"+orderlist.get(i).get("gname"));
				System.out.print(", [가격]"+orderlist.get(i).get("gprice"));
				System.out.print(", [수량]"+orderlist.get(i).get("odqty"));
				System.out.print(", [총액]"+orderlist.get(i).get("sum") );
				System.out.print(", [주문일]"+orderlist.get(i).get("oddate"));
				System.out.println("");
				
			}
			System.out.println();
		}
	}

	public void deleteOrderList(String loginId) {
		System.out.println("[주문내역]");
		ArrayList<HashMap<String, String>> orderlist = sdao.OrderList(loginId);
		if(orderlist == null) {
			System.out.println("주문 내역을 조회하는대 실패했습니다");
			return;
		}
		else if (orderlist.size() <= 0 ) {
			System.out.println("주문내역이 없습니다");
			return;
		} else {

			for (int i = 0; i < orderlist.size(); i++) {
				System.out.println("["+i+"][이름]"+orderlist.get(i).get("gname"));
				System.out.println("   [가격]"+orderlist.get(i).get("gprice"));
				System.out.println("   [수량]"+orderlist.get(i).get("odqty"));
				System.out.println("   [총액]"+orderlist.get(i).get("sum") );
				System.out.println("   [주문일]"+orderlist.get(i).get("oddate"));
				
			}
			System.out.println("취소할 주문선택 >>");
			int selectOrder = scan.nextInt();
			HashMap<String, String> order = orderlist.get(selectOrder);
			String odcode = order.get("odcode"); //취소할 주문코드
			int gstock = Integer.parseInt(order.get("odqty"));
			String gcode = order.get("gcode");
			System.out.println(odcode +", "+ gstock + ", " +gcode );
			int cancelResult = sdao.cancelOrder(odcode,gcode,gstock);
			if(cancelResult > 0) {
				System.out.println("주문이 취소 되었습니다.");
			}
		}
		
	}
	
	
}

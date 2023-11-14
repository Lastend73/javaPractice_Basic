package jdbcshopservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.zone.ZoneOffsetTransitionRule;
import java.util.ArrayList;
import java.util.HashMap;

import oracle.jdbc.proxy.annotation.Pre;

public class shopdao {
	Connection getConnection() {
		Connection con = null;

		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String userId = "KMH_DBA";
		String userPw = "1111";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, userId, userPw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 예외");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 예외");
		}

		if (con != null) {
			System.out.println("DB 접속");
		} else {
			System.out.println("DB 접속 실패");
		}

		return con;
	}

	public String selectMaxOdcode() {

		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return null;
		}

		String sql = "SELECT NVL (MAX(ODCODE), 'O0000') FROM ORDERS";
		String maxOdcode = null;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				maxOdcode = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxOdcode;
	}

	public int insertOrder(Order od) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return 0;
		}
		String INSERT = "INSERT INTO ORDERS(ODCODE, ODMID,ODGCODE,ODQTY,ODDATE)" + " VALUES ?, ?,? ,? ,SYSDATE";
		int insertresult = 0;
		int updateResult = 0;

		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, od.getOdcode());
			pstmt.setString(2, od.getOdgcode());
			pstmt.setString(3, od.getOdmid());
			pstmt.setInt(4, od.getOdqty());
			insertresult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (insertresult > 0) {
			try {
				PreparedStatement pstmt = con.prepareStatement(INSERT);
				pstmt.setInt(1, od.getOdqty());
				pstmt.setString(2, od.getOdgcode());
				updateResult = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (updateResult > 0) {
					con.commit();
				} else {
					con.rollback();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return insertresult;
	}

	public int update(String odcode) {

		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return 0;
		}
		String SQL = "UPDATE GOODS SET GSTOCK = GSTOCK - ? WHERE GCODE = ?";
		int result = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, odcode);
			pstmt.setString(2, odcode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public Object selectGoods_All() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Goods> SelectList_type() {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return null;
		}
		String sql = "SELECT GTYPE FROM GOODS GROUP BY GTYPE";
		ArrayList<Goods> gtypeList = new ArrayList<Goods>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Goods gb = new Goods();
				gb.setGTYPE(rs.getString(1));
				gtypeList.add(gb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gtypeList;

	}

	public ArrayList<Goods> SelectList_ALL() {

		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
		}
		String sql = "SELECT * FROM GOODS";
		ArrayList<Goods> odList = new ArrayList<Goods>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Goods gd = new Goods();
				gd.setGCODE(rs.getString(1));
				gd.setGNAME(rs.getString(2));
				gd.setGPRICE(rs.getInt(3));
				gd.setGTYPE(rs.getString(4));
				gd.setGSTOCK(rs.getInt(5));
				gd.setGSTATE(rs.getString(6));
				odList.add(gd);
			}
		} catch (SQLException e) {
			System.out.println("오류");
			e.printStackTrace();
		}

		return odList;
	}

	public ArrayList<Goods> selectGoods_type(String gtype) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
		}
		String sql = "SELECT * FROM GOODS WHERE GTYPE = ? AND GSTOCK > 0";
		ArrayList<Goods> gdList = new ArrayList<Goods>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gtype);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Goods gd = new Goods();
				gd.setGCODE(rs.getString(1));
				gd.setGNAME(rs.getString(2));
				gd.setGPRICE(rs.getInt(3));
				gd.setGTYPE(rs.getString(4));
				gd.setGSTOCK(rs.getInt(5));
				gd.setGSTATE(rs.getString(6));
				gdList.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gdList;
	}

	public ArrayList<Goods> selectGoods_Best() {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
		}

		String sql = "SELECT *\r\n" + "FROM GOODS GD INNER JOIN(SELECT ODGCODE, SUM(ODQTY) AS ODQTY " + " From ORDERS"
				+ " GROUP BY ODGCODE) OD" + " ON GD.GCODE = OD.ODGCODE" + " ORDER BY ODQTY DESC";
		ArrayList<Goods> gdList = new ArrayList<Goods>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Goods gd = new Goods();
				gd.setGCODE(rs.getString(1));
				gd.setGNAME(rs.getString(2));
				gd.setGPRICE(rs.getInt(3));
				gd.setGTYPE(rs.getString(4));
				gd.setGSTOCK(rs.getInt(5));
				gd.setGSTATE(rs.getString(6));
				gdList.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gdList;
	}

	public int Insert(Order or) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
		}

		String insertSql = "INSERT INTO ORDERS(ODCODE,ODMID,ODGCODE,ODQTY,ODDATE) VALUES(?, ?, ?, ?, sysdate)";
		int insertResult = 0;

		String upSql = "UPDATE GOODS SET GSTOCK = GSTOCK - ? WHERE GCODE = ?";
		int upResult = 0;
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, or.getOdcode());
			pstmt.setString(2, or.getOdmid());
			pstmt.setString(3, or.getOdgcode());
			pstmt.setInt(4, or.getOdqty());
			insertResult = pstmt.executeUpdate();

			pstmt = con.prepareStatement(upSql);
			pstmt.setInt(1, or.getOdqty());
			pstmt.setString(2, or.getOdgcode());
			upResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = 0;
		try {
			if (insertResult > 0 && upResult > 0)
				con.commit();
				result = 1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public ArrayList<HashMap<String, String>> selectGoods_Map() {
		// 1. DB접속
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
		}
		// 2. 쿼리문 실행 결과값 반환
		String sql = "SELECT * FROM GOODS";
		ArrayList<HashMap<String, String>> goodsList = new ArrayList<HashMap<String, String>>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				HashMap<String, String> goods = new HashMap<String, String>();
				goods.put("gcode", rs.getString("GCODE"));
				goods.put("gname", rs.getString("GNAME"));
				goods.put("gprice", rs.getString("GPRICE"));
				goods.put("gtype", rs.getString("GTYPE"));
				goods.put("gstock", rs.getString("GSTOCK"));
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodsList;
	}

	public ArrayList<HashMap<String, String>> OrderList(String ID, int orderByOption) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return null;
		}
		String sql = "Select OD.ODCODE, GD.GNAME, GD.GPRICE, OD.ODQTY,(GD.GPRICE * OD.ODQTY) as sum, OD.ODDATE FROM ORDERS OD INNER JOIN GOODS GD ON OD.ODGCODE = GD.GCODE WHERE  OD.ODMID = ?";
		if (orderByOption == 1) {
			sql += "ORDER BY OD.ODDATE desc";
		} else if (orderByOption == 2) {
			sql += " ORDER BY sum desc";
		} else {
			System.out.println("잘못 입력하셨습니다");
			return null;
		}
		ArrayList<HashMap<String, String>> OrderList = new ArrayList<HashMap<String, String>>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				HashMap<String, String> order = new HashMap<String, String>();
				order.put("odcode", rs.getString("ODCODE"));
				order.put("gname", rs.getString("GNAME"));
				order.put("gprice", rs.getString("GPRICE"));
				order.put("odqty", rs.getString("ODQTY"));
				order.put("sum", rs.getString("SUM"));
				order.put("oddate", rs.getString("ODDATE"));
				OrderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OrderList;
	}

	public ArrayList<HashMap<String, String>> OrderList(String loginId) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return null;
		}
		String sql = "Select OD.ODCODE, GD.GNAME, GD.GCODE, GD.GPRICE, OD.ODQTY,(GD.GPRICE * OD.ODQTY) as sum, OD.ODDATE FROM ORDERS OD INNER JOIN GOODS GD ON OD.ODGCODE = GD.GCODE WHERE  OD.ODMID = ?";
		ArrayList<HashMap<String, String>> OrderList = new ArrayList<HashMap<String, String>>();

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				HashMap<String, String> order = new HashMap<String, String>();
				order.put("odcode", rs.getString("ODCODE"));
				order.put("gname", rs.getString("GNAME"));
				order.put("gprice", rs.getString("GPRICE"));
				order.put("odqty", rs.getString("ODQTY"));
				order.put("sum", rs.getString("SUM"));
				order.put("oddate", rs.getString("ODDATE"));
				order.put("gcode", rs.getString("GCODE"));
				OrderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return OrderList;
	}

	public int cancelOrder(String odcode, String gcode, int gstock) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결 실패");
			return 0;
		}
		String delsql = "DELETE FROM ORDERS WHERE ODCODE = ?";
		int delResult = 0;

		String upSQL = "UPDATE GOODS SET GSTOCK = GSTOCK + ? WHERE GCODE = ?";
		int upResult = 0;
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(delsql);
			pstmt.setString(1, odcode);
			delResult = pstmt.executeUpdate();

			pstmt = con.prepareStatement(upSQL);
			pstmt.setInt(1, gstock);
			pstmt.setString(2, gcode);
			upResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = 0;
		try {
			if (delResult > 0 && upResult > 0) {
				con.commit();
				result = 1;
			} else {
				con.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}

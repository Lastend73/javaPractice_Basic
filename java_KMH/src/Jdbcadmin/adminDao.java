package Jdbcadmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbcshopservice.Goods;
import oracle.jdbc.proxy.annotation.Pre;

public class adminDao {

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
		
		if(con == null) {
			System.out.println("DB 접속 실패");
		}
		
		return con;	
	}
	
	
	public ArrayList<membersinfo> select() {
		
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결하지 못했습니다");
			return null;
		}
		
		String sql = "SELECT MID,MPW,MNAME,MPHONE,TO_CHAR(MBIRTH,'YYYY-MM-DD'),MSTATE FROM MEMBERS";
		ArrayList<membersinfo> info = new ArrayList<membersinfo>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				membersinfo mem = new membersinfo();
				mem.setmId(rs.getString(1));
				mem.setmPw(rs.getString(2));
				mem.setmName(rs.getString(3));
				mem.setmPhone(rs.getString(4));
				mem.setmBirth(rs.getString(5));
				mem.setmState(rs.getString(6));
				info.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
	}


	public int chageState(String ID) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결하지 못했습니다");
			return 0;
		}
		
		String Statesql = "Select MSTATE FROM MEMBERS WHERE MID = ?"; 
		String State = null;
		
		String upSql = "Update MEMBers Set MSTATE = ?  WHERE MID= ?";
		int upReslut =0;
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(Statesql);
			pstmt.setString(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				State = rs.getString(1);	
			}
			
			pstmt = con.prepareStatement(upSql);
			if(State.equals("Y") ) {
				pstmt.setString(1, "N");
				pstmt.setString(2, ID);
				upReslut =1;
			}else if(State.equals("N")) {
				pstmt.setString(1, "Y");
				pstmt.setString(2, ID);
				upReslut =2;
			}
				
			result = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return upReslut;
	}


	public ArrayList<Goods> goodsSelect() {
		
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결하지 못했습니다");
			return null;
		}
		
		String sql = "Select * From Goods";
		ArrayList<Goods> gd = new ArrayList<Goods>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Goods good = new Goods();
				good.setGCODE(rs.getString(1));
				good.setGNAME(rs.getString(2));
				good.setGPRICE(rs.getInt(3));
				good.setGTYPE(rs.getString(4));
				good.setGSTOCK(rs.getInt(5));
				good.setGSTATE(rs.getString(6));
				
				gd.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gd;
	}


	public int chageGoodsState(String Gcode) {
		Connection con = getConnection();
		if (con == null) {
			System.out.println("DB연결하지 못했습니다");
			return 0;
		}
		String Statesql = "Select MSTATE FROM GOODS WHERE GCode =  ?"; 
		String State = null;
		
		String sql = "UPDATE GOODS SET MSTATE = ? WHERE GCODE= ?";
		int result = 0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(Statesql);
			pstmt.setString(1, Gcode);
			ResultSet rs  = pstmt.executeQuery();
			
			while(rs.next()) {
				State = rs.getString(1);
			}
			pstmt = con.prepareStatement(sql);
			if(State.equals("Y") ) {
				pstmt.setString(1, "N");
				pstmt.setString(2, Gcode);
			}else if(State.equals("N")) {
				pstmt.setString(1, "Y");
				pstmt.setString(2, Gcode);
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}

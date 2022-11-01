package kr.or.team4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.team4.utils.ConnectionHelper;

public class loginDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public boolean loginCheck(String id, String pwd) {
		  conn = ConnectionHelper.getConnection("oracle");
          String sql="select id, pwd from koreamember where id=?";
          try {
			pstmt = conn.prepareStatement(sql);
	          pstmt.setString(1,id);
	          rs = pstmt.executeQuery();
	          
	          //검색결과가 존재하면(즉 해당 아이디가 존재하면)
	            while(rs.next()){
	              //ID 존재
	              if(pwd.equals(rs.getString("pwd"))){
	                //ID 존재 , PWD(0) 
	                //정상회원
	                //Top.jsp 정보 로그인 상태 ...??
	                return true;
	              }else {
	            	  //비밀번호가 틀릴 경우
	            	  return false;
	              }
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
          return false;
	}
	
}

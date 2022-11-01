package kr.or.team4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.team4.dto.MemberDto;
import kr.or.team4.utils.ConnectionHelper;

public class joinDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertMember(MemberDto dto) {
		  conn = ConnectionHelper.getConnection("oracle");
		  String sql="insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
		  int result = 0;
		  try {
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, dto.getId());
			  pstmt.setString(2, dto.getPwd());
			  pstmt.setString(3, dto.getName());
			  pstmt.setInt(4, dto.getAge());
			  pstmt.setString(5, dto.getGender());
			  pstmt.setString(6, dto.getEmail());
			  pstmt.setString(7, dto.getIp());
			  result = pstmt.executeUpdate();
			  
		} catch (SQLException e) {

			e.printStackTrace();
		}
			return result;

	}
}

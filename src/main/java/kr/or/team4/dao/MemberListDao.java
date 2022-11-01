package kr.or.team4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.team4.dto.MemberDto;
import kr.or.team4.utils.ConnectionHelper;

public class MemberListDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<MemberDto> allMemberList() {
		  conn = ConnectionHelper.getConnection("oracle");
          String sql="select * from koreamember";
          
          List<MemberDto> memberlist = new ArrayList<>();
          
          try {
        		pstmt = conn.prepareStatement(sql);
        		rs = pstmt.executeQuery();
        		
        		while(rs.next()) { //쿼리 실행 결과가 있으면
        			//list에 값을 담는다
        			memberlist.add(new MemberDto(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"), rs.getString("email"), rs.getString("ip")));
        			//String id, String pwd, String name, int age, String gender, String email, String ip
        		}
        		
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}
          
          return memberlist;
          
		}
	
	public List<MemberDto> searchMember(String inputvalue){
		List<MemberDto> searchMemberlist = new ArrayList<>();
		conn = ConnectionHelper.getConnection("oracle");
		String sql = "select id, pwd, name, age, gender, email, ip from koreamember where name like ?";
		//System.out.println("inputvalue : " + inputvalue.trim());
		//System.out.println("공백제거 비교 : " + (inputvalue == inputvalue.trim()));
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+inputvalue.trim()+'%');
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //쿼리 실행 결과가 있으면
    			//list에 값을 담는다
				
				MemberDto member = new MemberDto(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"), rs.getString("email"), rs.getString("ip"));
    			searchMemberlist.add(member);
				System.out.println("rs while문 : " + member.getId());
    			//String id, String pwd, String name, int age, String gender, String email, String ip
    		}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return searchMemberlist;
	}
	
	public MemberDto getIdUser(String id) {
		MemberDto member = null;
		conn = ConnectionHelper.getConnection("oracle");
		String sql = "select * from koreamember where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new MemberDto(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getInt("age"), rs.getString("gender"), rs.getString("email"), rs.getString("ip"));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return member;
	}
	
	public int delUser(String id) {
		int result = 0;
		conn = ConnectionHelper.getConnection("oracle");
		String sql = "delete from koreamember where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int memberUpdate(String id, String name, int age, String gender, String email) {
		int result = 0;
		conn = ConnectionHelper.getConnection("oracle");
		String sql = "update koreamember set name = ?, age = ?, gender = ?, email = ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, gender);
			pstmt.setString(4, email);
			pstmt.setString(5, id);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
          
}

package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import common.JDBConnect;

public class MemberDAO extends JDBConnect {
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}

	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "Select * from member where id=? and pass =?";
		Connection con = getConnection();
		if (con == null)
			return null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, uid);
			ps.setString(2, upass);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}

	public ArrayList<MemberDTO> getAllMemberDTO() {
		Connection con = getConnection();
		if (con == null)
			return null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> list = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from member");

			list = new ArrayList<>();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int insertMemberDTO(MemberDTO member) {
		String sql = "insert into member(id,pass,name) value (?,?,?)"; 
		
		Connection con = getConnection();
		if (con == null)
			return 0;
		PreparedStatement ps = null;
		int ret = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPass());
			ps.setString(3, member.getName());
			ret = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}
	public int updateMemberDTO(MemberDTO member) {
		
		String sql = "update member set pass = ?, name = ? where id =?"; 
		Connection con = getConnection();
		if (con == null)
			return 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getPass());
			ps.setString(2, member.getName());
			ps.setString(3, member.getId());
			int ret = ps.executeUpdate();
			
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int deleteMemberDTO(MemberDTO member) {
		String sql = "delete from member where id =?"; 
		Connection con = getConnection();
		if (con == null)
			return 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			int ret = ps.executeUpdate();
			
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public void close(Connection con) {
		try{
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

package fileupload;

import java.util.List;
import java.util.Vector;

import common.JDBConnect;

public class MyfileDAO extends JDBConnect{
	public int insertFile(MyfileDTO dto) {
		int applyResult = 0;
		try {
			String query = "Insert into myfile ("
					+ "name, title, cate, ofile, sfile)"
					+ "Values (?, ?, ?, ?, ?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1,dto.getName());
			psmt.setString(2,dto.getTitle());
			psmt.setString(3,dto.getCate());
			psmt.setString(4,dto.getOfile());
			psmt.setString(5,dto.getSfile());
			
			applyResult = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Insert 중 예외 발생");
			e.printStackTrace();
		}
		return applyResult;
	}
	public List<MyfileDTO> myFileList(){
		List<MyfileDTO> fileList = new Vector<MyfileDTO>();
		
		String query = "Select * from myfile order by idx desc";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MyfileDTO dto = new MyfileDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setPostdate(rs.getString(7));
				
				fileList.add(dto);
			}
		
		}catch(Exception e) {
			System.out.println("select 시 예외 발생");
			e.printStackTrace();
		}
		return fileList;
	}
	public static void main(String[] args) {
		MyfileDAO dao = new MyfileDAO();
		dao.insertFile(new MyfileDTO("a","b","c","d","e"));
//		MyfileDTO dto = new MyfileDTO();
//		dto.setName("name");
//		dto.setTitle("title");
//		dto.setCate("cateBuf");
//		dto.setOfile("filename");
//		dto.setSfile("newFileName");
//		dao.insertFile(dto);
		
	}
}

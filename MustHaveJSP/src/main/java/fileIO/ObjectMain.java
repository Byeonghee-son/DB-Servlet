package fileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import membership.MemberDTO;

public class ObjectMain {

	public void serialize(List<MemberDTO> list, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			for(MemberDTO)
			oos.writeObject(obj);
		}
	}

	public MemberDTO deserialize(String fileName) throws IOException, ClassNotFoundException {
		MemberDTO m = null;
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			m = (MemberDTO)ois.readObject();
		}		
		return m;
	}	
	public List<MemberDTO> deserialize1(String fileName) throws IOException, ClassNotFoundException {
		MemberDTO m = null;
		List<MemberDTO> list = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
//			while((m = ois.readObject()) != null){
//				list.add((MemberDTO)m);
//			}
			for(int i = 0; i <3; i++) {
				m = ois.readObject();
				list.add((MemberDTO)m);
			}
		}		
		return list;
	}	
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain2 om = new ObjectMain2();
		List<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO("100","1234","홍길동","2023-01-01"));
		list.add(new MemberDTO("200","1234","홍이동","2023-01-01"));
		list.add(new MemberDTO("300","1234","홍삼동","2023-01-01"));
		om.serialize(list,"testObject.dat");
		
		list = om.deserialize1("testObject.dat");
		System.out.println(list);
	}
}

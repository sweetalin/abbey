package task1;

import java.util.ArrayList;

public class ConnTest {
	
	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		//int tag=ud.insert();
		
		//System.out.println(tag + "");
		ArrayList<User> list = ud.findAll();
		
		for(int i=0;i<list.size();i++){
		System.out.print(list.get(i).getStu_id() + " ");
		System.out.print(list.get(i).getQq() + " ");
		System.out.print(list.get(i).getName() + " ");
		System.out.print(list.get(i).getType() + " ");
		System.out.print(list.get(i).getSchool_day() + " ");
		System.out.print(list.get(i).getGra_university() + " ");
		System.out.print(list.get(i).getOnline_id() + " ");
		System.out.print(list.get(i).getDay_report() + " ");
		System.out.print(list.get(i).getWish() + " ");
		System.out.print(list.get(i).getRec_senior()+ " ");
		System.out.print(list.get(i).getCheck_senior() + " ");
		System.out.print(list.get(i).getCreate_at() + " ");
		System.out.println(list.get(i).getUpdate_at());
		}
		
	}
}

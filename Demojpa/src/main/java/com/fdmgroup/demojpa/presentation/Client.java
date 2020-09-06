package com.fdmgroup.demojpa.presentation;

import java.util.Collections;
import java.util.List;

import com.fdmgroup.demojpa.data.NbaPlayersJpaDao;
import com.fdmgroup.demojpa.model.NbaPlayer;



public class Client {

	public static void main(String[] args) {
		NbaPlayersJpaDao dao = new NbaPlayersJpaDao();
		
//		NbaPlayer waiyat = new NbaPlayer();
//		waiyat.setFirstName("Waiyat");
//		waiyat.setLastName("Hamdani");
//		waiyat.setCareerPoints(80000);
//		System.out.println("before create...........");
//		System.out.println("waiyat is"+ waiyat);
//		
//		dao.create(waiyat);
//		
//		System.out.println("after adding........");
//		System.out.println("waiyat is"+ waiyat);
//		
//		waiyat.setFirstName("Waiyat");
//		waiyat.setLastName("Hamdani");
//		waiyat.setCareerPoints(90000);
//		
//		System.out.println("waiyat updated ...");
//		System.out.println("waiyat is "+ waiyat);
//		dao.update(waiyat);
//		
//		NbaPlayer retrivedPlayer = dao.read(waiyat.getId());
//		
//		System.out.println("after update and read..." );
//		System.out.println("retrivedPlayer is "+ retrivedPlayer);
//		
//		NbaPlayer wahyu = new NbaPlayer("wahyu", "hamdani",33);
//		dao.create(wahyu);
//		
//		NbaPlayer jimbo = new NbaPlayer("jim","halpert",40);
//		dao.create(jimbo);
		
//		NbaPlayer x=dao.readbyLastname("halpert");
//		System.out.println("person is "+ x);
		List<NbaPlayer> readall = dao.read();
		for (NbaPlayer temp: readall) {
			System.out.println(display(temp));
		}
		
		dao.close();
		
		
		
}
	
	private static String header() {
		
		int lineLength = 45;
		StringBuilder underLine = new StringBuilder();
		for (int i=0; i<lineLength; i++) {
			underLine.append("-");
		}
		
		return String.format("%-8s%-14s%-13s%-10s%n%45s", "ID", "FIRST_NAME", "LAST_NAME", "CAREER_PTS", underLine.toString());
	}
	
	private static String display(NbaPlayer player) {
		
		return String.format("%-8d%-14s%-13s%,10d", player.getId(), player.getFirstName(), player.getLastName(), player.getCareerPoints());
	}
}

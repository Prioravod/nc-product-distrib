package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BL.*;
import model.*;

public class Menu {
	private static int tab = 0;
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.chooseRole();
	}
	private void chooseRole() {
		boolean notExit = true;
		List<Shop> shopList = new ArrayList<>(); //static database with list of all shops
		while(notExit) {
			switch(choose("Buyer","Provider")) {
			case 0:
				selectShop(shopList);
				break;
			case 1:
				checkGoodsAvail();
				break;
			case 2:
				notExit = false;
				break;
			}
		}
	}
	private void checkGoodsAvail() {
		boolean notExit = true;
		while(notExit) {
			switch(choose("Send goods")) {
			case 0:
				sendGoods();
				break;
			case 1:
				notExit = false;
				break;
			}
		}
	}
	private void sendGoods() {}
	private void selectShop(List<Shop> shopList) {
		boolean notExit = true;		
		while(notExit) {
			int shopChoose = choose(shopList.toArray(new String[shopList.size()]));
			selectGoods(shopList.get(shopChoose));
		}
	}
	private void selectGoods(Shop shop) {
		ShopManager sm = new ShopManager(shop);
		List<Product> productList = sm.productList();
		boolean notExit = true;		
		while(notExit) {
			int prodChoose = choose(productList.toArray(new String[productList.size()]));
			printT();
			System.out.println("Enter the number of goods: ");
			//add check for availability goods and cutomer money 
			printT();
			Scanner in = new Scanner(System.in);
			int count = in.nextInt();
			sm.buyItem(productList.get(prodChoose),count);
			//add charge off customer cash/card
			System.out.println("Successfully purchased!");
		}
	}
	
	
	
	public static int choose(String...options) {
		int i = 0;
		int choose = 0;
		boolean input = false;
		printT();
		System.out.println("Choose the answer:");
		for(String op : options) {
			printT();
			System.out.println(i++ + ") " + op + ";");
		}
		printT();
		System.out.println(i++ + ") Back;");
		Scanner in = new Scanner(System.in);
		while(input == false) {
			printT();
			System.out.print("(0-"+i+") : ");
			choose = in.nextInt();
			if (choose > 0 && choose <= i) input = true;
			else {
				printT();
				System.out.println("Enter error!");
			}
		}
		tab++;
		return choose;
	}
	private static void printT() {
		for(int i = 0;i < tab;i++) {
			System.out.print(" ");
		}
	}

}

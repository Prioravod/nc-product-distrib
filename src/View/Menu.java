package view;

import controllers.*;
import dao.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.*;

public class Menu {
	private static int tab = 0;
	Basket basket = new Basket();
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		//Map<Product,Integer> products,Shop shop
		
		Shop pc = new Shop("Pyatorochka-Chemodurova", new Geotag("Chemodurova,14",51.607446d, 45.975488d));
		Shop pt = new Shop("Pyatorochka-Tarhova", new Geotag("Tarhova,14",51.610580d, 45.982037d));
		Company dobrii = new Company("Dobrii");
		Company ya = new Company("Ya");
		Product jda = new Juice(dobrii, "AppleJuice", 60l, 2000);
		Product jyp = new Juice(ya, "PineappleJuice", 100l, 1000);
		Product jdo = new Juice(dobrii, "OrangeJuice", 70l, 2000);
		
		Map<Product,Integer> products1 = new HashMap<>();
		products1.put(jdo, 14);
		products1.put(jyp, 5);
		products1.put(jda, 9);
		
		
		Map<Product,Integer> products2 = new HashMap<>();
		products2.put(jyp, 3);
		products2.put(jda, 1);
		
		Map<Product,Integer> products3 = new HashMap<>();
		products3.put(jdo, 9);
		products3.put(jyp, 2);
		
		
		
		DemandManager dm1 = new DemandManager(products1, pc);
		DemandManager dm2 = new DemandManager(products2, pt);
		DemandManager dm3 = new DemandManager(products3, pc);
		dm1.printCurrCMMap();
		dm2.printCurrCMMap();
		dm3.printCurrCMMap();
		
		
		//menu.enableMenu();
		
	}
	private void enableMenu() {
		chooseRole();
	}
	private void chooseRole() {
		boolean notExit = true;
		List<Shop> shopList = Static.shopBase; //static database with list of all shops
		while(notExit) {
			switch(choiceAnswer("Buyer","Provider","View Basket")) {
			case 0:
				selectShop(shopList);
				break;
			case 1:
				checkGoodsAvail();
				break;
			case 2:
				basket.getAll().stream().forEach(System.out::println);
				break;
			case 3:
				notExit = false;
				break;
			}
		}
	}
	private void checkGoodsAvail() {
		boolean notExit = true;
		while(notExit) {
			switch(choiceAnswer("Send goods")) {
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
			List<String> shopNames = shopList.stream().map(x -> x.getShopName()).collect(Collectors.toList());
			int shopChoose = choiceAnswer(shopNames.toArray(new String[shopNames.size()]));
			if (shopChoose==shopNames.size()) {
				notExit = false;
				tab = 0;
			}
			else selectAndBuyGoods(shopList.get(shopChoose));
		}
	}
	private void selectAndBuyGoods(Shop shop) {
		ShopManager sm = new ShopManager(shop);
		List<String> productNameList = sm.productNameList();
		boolean notExit = true;		
		while(notExit) {
			int prodChoose = choiceAnswer(productNameList.toArray(new String[productNameList.size()]));
			createIndent();
			int availCount = sm.getProductCurrCount(sm.productList().get(prodChoose));
			System.out.println("Enter the number of goods (1 - " + availCount + ") : ");
			//add check for availability goods and cutomer money 
			createIndent();
			Scanner in = new Scanner(System.in);
			int count = in.nextInt();
			basket.addNewProducts(sm.buyItem(sm.productList().get(prodChoose),count));
			//add charge off customer cash/card
			System.out.println("Successfully purchased!");
			notExit = false;
			
		}
	}
	
	public static int choiceAnswer(String...options) {
		int i = 0;
		int choose = 0;
		boolean input = false;
		createIndent();
		System.out.println("Choose the answer:");
		for(String op : options) {
			createIndent();
			System.out.println(i++ + ") " + op + ";");
		}
		createIndent();
		System.out.println(i + ") Back;");
		Scanner in = new Scanner(System.in);
		while(input == false) {
			createIndent();
			System.out.print("(0-"+i+") : ");
			choose = in.nextInt();
			if (choose >= 0 && choose <= i) input = true;
			else {
				createIndent();
				System.out.println("Enter error!");
			}
		}
		tab++;
		return choose;
	}
	private static void createIndent() {
		for(int i = 0;i < tab;i++) {
			System.out.print(" ");
		}
	}

}

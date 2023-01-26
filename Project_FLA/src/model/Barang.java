package model;

import java.util.Random;
import java.util.Scanner;

public class Barang {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	private String id, name;
	private int price, quantity;
	
	
	public Barang(String name, int price, int quantity) {
		this.id = generateID();
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}

  int scanint(){
    	int x = -1;
        try {
            x = scan.nextInt();
        } catch (Exception e){
            scan.nextLine();
        }
        return x;
    }

  public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
  
	public String generateID() {
		String id = "PR";
		for (int i = 0; i < 3; i++) {
			id += rand.nextInt(10);
		}
		return id;
	}
}

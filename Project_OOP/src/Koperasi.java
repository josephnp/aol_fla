import java.util.Scanner;
import java.util.Vector;

public class Koperasi {
	Scanner scan = new Scanner(System.in);
	private Vector<Barang> list_barang = new Vector<>();

	public void CreateBarang() {
		String ipt_name;
		
		do {
			System.out.print("Input Product Name [5 - 20 characters]: ");
			ipt_name= scan.nextLine();
		} while (ipt_name.length() < 5 || ipt_name.length() > 20);
			
		int ipt_price = 0;
		do {
			System.out.print("Input Product Price [1000 - 100000]: ");
			try {
				ipt_price = scan.nextInt();
			} catch (Exception e) {
				ipt_price = -1;
			}
			scan.nextLine();
		} while (ipt_price < 1000 || ipt_price > 100000);
		
		int ipt_qty = 0;
		do {
			System.out.print("Input Product Quantity [1 - 100]: ");
			try {
				ipt_qty = scan.nextInt();
			} catch (Exception e) {
				ipt_qty = -1;
			}
			scan.nextLine();
		} while (ipt_qty < 1 || ipt_qty > 100);
		
		Barang barang = new Barang(ipt_name, ipt_price, ipt_qty);
		list_barang.add(barang);
		
		System.out.println("\nProduct " + barang.getId() + " has been added!");
		System.out.print("Press enter to continue...");
		scan.nextLine();
	}
	
	public void line_view() {
		for (int i = 0; i < 63; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	
	public void ViewBarang(boolean skip) {
		line_view();
		System.out.printf("| %-10s | %-20s | %-10s | %-10s |\n","ID", "Name", "Price", "Quantity");
		line_view();
		if (list_barang.isEmpty()) {
			System.out.printf("| %-59s |\n","There are no product on the list");
		}
		else {
			for (Barang barang : list_barang) {
				System.out.printf("| %-10s | %-20s | %-10d | %-10d |\n",
						barang.getId(), barang.getName(), barang.getPrice(), barang.getQuantity());
			}
		}
		line_view();
		
		if (!skip) {
			System.out.print("Press enter to continue...");
			scan.nextLine();
		}
	}
	
	public void UpdateBarang() {
		String updateid;
		boolean flag = false;
		int idx = 0;
		
		ViewBarang(true);
		if (!list_barang.isEmpty()) {
			do {	
				System.out.print("Input Id: ");
				updateid = scan.nextLine();
				for(int i = 0; i < list_barang.size(); i++) {
					if (list_barang.get(i).getId().equals(updateid)) {
						idx = i;
						flag = true;
					}
				}
			} while (!flag);
			
			int ipt_price = 0;
			do {
				System.out.print("Input Product Price [1000 - 100000]: ");
				try {
					ipt_price = scan.nextInt();
				} catch (Exception e) {
					ipt_price = -1;
				}
				scan.nextLine();
			} while (ipt_price < 1000 || ipt_price > 100000);
			
			int ipt_qty=0;
			do {
				System.out.print("Input Product Quantity [1 - 100]: ");
				try {
					ipt_qty = scan.nextInt();
				} catch (Exception e) {
					ipt_qty = -1;
				}
				scan.nextLine();
			} while (ipt_qty < 1 || ipt_qty > 100);
			
			list_barang.get(idx).setPrice(ipt_price);
			list_barang.get(idx).setQuantity(ipt_qty);
			System.out.println("\nProduct " + updateid + " has been updated!");
			
			System.out.print("Press enter to continue...");
			scan.nextLine();
		}
	}
	
	public void DeleteBarang() {
		String deleteid;
		boolean flag = false;
		int idx = 0;
		
		ViewBarang(true);
		if (!list_barang.isEmpty()) {
			do {	
				System.out.print("Input Id: ");
				deleteid = scan.nextLine();
				
				for(int i = 0; i < list_barang.size(); i++) {
					if(list_barang.get(i).getId().equals(deleteid)) {
						idx = i;
						flag = true;
					}
				}
			} while (!flag);
			
			list_barang.remove(idx);
			System.out.println("\nProduct " + deleteid + " has been removed!");
			
			System.out.print("Press enter to continue...");
			scan.nextLine();
		}
	}
	
	public Barang jajan() {
		String productID;
		boolean flag = false;
		int idx = 0;
		
		do {	
			System.out.print("Input Product ID to buy: ");
			productID = scan.nextLine();
			
			for (int i = 0; i < list_barang.size(); i++) {
				if (list_barang.get(i).getId().equals(productID)) {
					idx = i;
					flag = true;
				}
			}
		} while (!flag);
		
		return list_barang.get(idx);
	}
	
	public int calculateTotalPrice(Barang barang, int quantity) {
		int idx = 0;
		
		for (int i = 0; i < list_barang.size(); i++) {
			if (list_barang.get(i).getId().equals(barang.getId())) {
				idx = i;
			}
		}
		list_barang.get(idx).setQuantity(list_barang.get(idx).getQuantity() - quantity);
		
		return barang.getPrice()*quantity;
	}
	
	public boolean isEmpty() {
		if (list_barang.isEmpty()) return true;
		else return false;
	}
}

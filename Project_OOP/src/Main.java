package main;

//import cable.VGA;
import device.Laptop;
//import device.Monitor;

public class Main {

	public Main() {
//		VGA vga = new VGA();
		Laptop laptop = new Laptop();
//		Monitor monitor = new Monitor();
		
		laptop.setMode("start windows");
	}

	public static void main(String[] args) {
		new Main();
	}

}

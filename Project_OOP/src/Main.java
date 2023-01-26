import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


public class Main{
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    
    Vector<Student> students = new Vector<>();
    Vector<Employee> employees = new Vector<>();
    Koperasi kp = new Koperasi();
    
    boolean flag = false;
    String name, gender, address, phoneNumber = null;
    int age, salary;
    
    private void cls() {
    	for(int i = 0; i< 100; i++) {
    		System.out.println("");
    	}
    }
    
    private int scanint(){
    	int x = -1;
        try {
            x = scan.nextInt();
        } catch (Exception e){
            scan.nextLine();
        }
        return x;
    }
    
    private void insertPerson() {
    	do {
        	System.out.print("Input Name [5 - 20 characters]: ");
        	name = scan.nextLine();
        } while (name.length() < 5 || name.length() > 20);
        
        do {
        	System.out.print("Input Gender [Male | Female] (case sensitive): ");
        	gender = scan.nextLine();
        } while (!gender.equals("Male") && !gender.equals("Female"));
        
        do {
        	System.out.print("Input Address [min. 5 characters]: ");
        	address = scan.nextLine();
        } while (address.length() <5);
        
        do {
        	System.out.print("Input Phone Number [11 - 12 numbers]: ");
        	phoneNumber = scan.nextLine();
        } while (!phoneNumberCheck());
        
        do {
        	System.out.print("Input Age [13 - 50]: ");
        	age = scanint(); 
        } while (age < 13 || age > 50);
    }
    
    private boolean phoneNumberCheck() {
    	if (phoneNumber.length() < 11 || phoneNumber.length() > 12) {
    		return false;
    	}
    	
    	for (int i = 0; i < phoneNumber.length(); i++) {
    		if (phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9') {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    private String generateID(String id, String type) {
        do {
        	for (int i = 0; i < 3; i++) {
        		id += rand.nextInt(10);
        	}
        	
        	if (type.equals("st")) {
	        	for(int i = 0; i > students.size(); i++) {
	        		if(id.equals(students.get(i).getId())) {
	        			flag = true;
	        		}
	        	}
        	} else if (type.equals("tc") || type.equals("sc") || type.equals("cs")) {
        		for(int i = 0; i > employees.size(); i++) {
	        		if(id.equals(employees.get(i).getId())) {
	        			flag = true;
	        		}
	        	}
        	}
        } while (flag);
        
        flag = false;
        return id;
    }
    
    private void insertSalary() {
    	do {
        	System.out.print("Input salary [min. 5000000]: ");
        	salary = scanint();
        } while (salary < 5000000);
    	scan.nextLine();
    }

    // =============== Admin Menu ===============
    private void AdminMenu() {
    	int menuChoice;
    	do {
    			cls();
	            System.out.println("Hello, Admin!");
	            System.out.println("---------");
	            System.out.println("1. Manage student data");
	            System.out.println("2. Manage employee data");
	            System.out.println("3. Manage product data");
	            System.out.println("4. Exit");
	            
	            do {
		            System.out.print(">> ");
		            menuChoice = scanint();
	            } while (menuChoice < 1 || menuChoice > 4);
	            scan.nextLine();
	            
	            switch (menuChoice) {
				case 1:
					AdminStudentMenu();
					break;
				case 2:
					AdminEmployeeMenu();
					break;
				case 3:
					AdminProductMenu();
					break;
				}
            } while (menuChoice != 4);
    }
    
    private void AdminStudentMenu() {
    	int studentChoice = 0;
    	
		do {
			cls();
			System.out.println("1. Add new student");
			System.out.println("2. View students data");
			System.out.println("3. Update student data");
			System.out.println("4. DO Student");
			System.out.println("5. Back");
			
			do {
				System.out.print(">> ");
	            studentChoice = scanint();
			} while (studentChoice < 1 || studentChoice > 5);
			scan.nextLine();

			cls();
            switch (studentChoice) {
				case 1:
					addStudent();
					break;
				case 2:
					viewStudent();
					break;
				case 3:
					updateStudent();
					break;
				case 4:
					DOStudent();
					break;
			}
		} while (studentChoice != 5);
    }
    
    private void AdminEmployeeMenu() {
    	int employeeChoice;
    	
		do {
			cls();
	    	System.out.println("1. Hire new employee");
			System.out.println("2. View employees data");
			System.out.println("3. Update employee's salary");
			System.out.println("4. Fire employee");
			System.out.println("5. Exit");
			
			do {
				System.out.print(">> ");
				employeeChoice = scanint(); 
			} while (employeeChoice < 1 || employeeChoice > 5);
			scan.nextLine();

			cls();
            switch (employeeChoice) {
				case 1:
					addEmployee();
					break;
				case 2:
					viewEmployee();	
					break;
				case 3:
					updateEmployee();
					break;
				case 4:
					fireEmployee();
					break;
			}
		} while (employeeChoice != 5);
    }
    
    private void AdminProductMenu() {
    	int productChoice;
    	
		do {
			cls();
	    	System.out.println("1. Add Product");
			System.out.println("2. View Product");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Exit");
			
			do {
				System.out.print(">> ");
				productChoice = scanint();
			} while (productChoice < 1 || productChoice > 5);
			scan.nextLine();

			cls();
            switch (productChoice) {
			case 1:
				kp.CreateBarang();
				break;
			case 2:
				kp.ViewBarang(false);	
				break;
			case 3:
				kp.UpdateBarang();
				break;
			case 4:
				kp.DeleteBarang();
				break;
			}
		} while (productChoice != 5);
    }
    
    // ========== Student ==========
    private void addStudent(){
    	int kelas, score;
    	
        insertPerson();
        String id = generateID("ST", "st");
        
        do {
        	System.out.print("Input Kelas [10/11/12]: ");
        	kelas = scan.nextInt();
        } while (kelas < 10 || kelas > 12);
        
        do {
            System.out.print("Input Nilai [0 - 100]: ");
            score = scan.nextInt();	
        } while (score < 0 || score > 100);
        scan.nextLine();
        
        System.out.println("\nA new student with ID " + id + " has been added!");
        students.add(new Student(id, name, gender, address, phoneNumber, age, kelas, score));
        System.out.print("Press enter to continue...");
        scan.nextLine();
    }

    private void viewStudent(){
    	if (students.isEmpty()) {
    		System.out.println("There is no student!");
    	} else {
    		viewStudentTable();        
    	}
    	
    	System.out.print("Press enter to continue...");
    	scan.nextLine();
    }
    
    private void viewStudentTable() {
    	System.out.println("===================================================================================================================================================");
    	System.out.printf("| %-7s | %-30s | %-5s | %-10s | %-30s | %-15s | %-15s | %-10s |\n","ID","Name","Age","Gender","Address","Phone Number","Class","Score");
    	System.out.println("===================================================================================================================================================");
    	for(int i =0;i<students.size();i++) {
    		System.out.printf("| %-7s | %-30s | %-5d | %-10s | %-30s | %-15s | %-15d | %-10d |\n",
    				students.get(i).getId(),students.get(i).getName(), students.get(i).getAge(),
    				students.get(i).getGender(), students.get(i).getAddress(), students.get(i).getPhoneNumber(),
    				students.get(i).getKelas(),students.get(i).getScore());
    	}
    	System.out.println("===================================================================================================================================================");
    }
    
    private void updateStudent() {
		if (students.isEmpty()) {
			System.out.println("There is No Student!");
		} else {
			String id;
			int idx = -1;
			viewStudentTable();
			
			do {
				System.out.print("Choose student ID to update [input 0 to go back]: ");
				id = scan.nextLine();
				
				if (id.equals("0")) return;
				else idx = searchStudent(id);
			} while (idx == -1);

			int scoreUpdate = 0;
			do {
				System.out.print("Update student's score [0 - 100]: ");
				scoreUpdate = scanint();
			} while (scoreUpdate < 0 || scoreUpdate > 100);
			scan.nextLine();

			students.get(idx).setScore(scoreUpdate);
			System.out.println("\n" + id + "'s score has been updated!");
		}
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
    
    private int searchStudent(String id) {
		for(int i = 0; i < students.size();i++) {
			if(id.equals(students.get(i).getId())) {
				return i;
			}
		}
		return -1;
	}
    
	private void DOStudent() {
		if (students.isEmpty()) {
    		System.out.println("There is no student!");
    	} else {
    		String id;
			int idx = -1;
			viewStudentTable();
			
    		do {
				System.out.print("Choose student ID to drop out [input 0 to go back]: ");
				id = scan.nextLine();
				
				if (id.equals("0")) return;
				else idx = searchStudent(id);
			} while (idx == -1);
        		
    		students.remove(idx);
    		System.out.println("\n" + id + " has been dropped out!");
    	}
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
    
    // ============ Employee ============
    private void addEmployee(){
    	insertPerson();
    	insertSalary();
    	
    	String department = null;
    	do {
    		System.out.print("Choose employee department [Teacher | Security | Cleaning Service] (case sensitive): ");
    		department = scan.nextLine();
    	} while (!department.equals("Teacher") && !department.equals("Security") && !department.equals("Cleaning Service"));
    	
    	String id = null;
    	
    	if (department.equals("Teacher")) {
	    	id = generateID("TC", "tc");
	    	employees.add(new Teacher(id, name, gender, address, phoneNumber, age, salary));
    	} else if (department.equals("Security")) {
	    	id = generateID("SC", "sc");
	    	employees.add(new Security(id, name, gender, address, phoneNumber, age, salary));
    	} else if (department.equals("Cleaning Service")) {
	    	id = generateID("CS", "cs");
	    	employees.add(new CleaningService(id, name, gender, address, phoneNumber, age, salary));
    	}
        
        System.out.println("\nA new employee with ID " + id + " has been hired!");
        System.out.print("Press enter to continue...");
        scan.nextLine();
    }

    private void viewEmployee(){
    	if (employees.isEmpty()) {
			System.out.println("There is no employee!");
		} else {
			viewEmployeeTable();
		}
    	
    	System.out.print("Press enter to continue...");
    	scan.nextLine();
    }
    
    private void viewEmployeeTable() {
    	System.out.println("=========================================================================================================================================================");
		System.out.printf("| %-7s | %-16s | %-30s | %-5s | %-10s | %-30s | %-15s | %-15s |\n", "ID", "Department", "Name", "Age", "Gender", "Address", "Phone Number","Salary");
    	System.out.println("=========================================================================================================================================================");

		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i) instanceof Teacher) {
				System.out.printf("| %-7s | %-16s | %-30s | %-5d | %-10s | %-30s | %-15s | Rp. %-11d |\n",
						employees.get(i).getId(), "Teacher", employees.get(i).getName(),
						employees.get(i).getAge(), employees.get(i).getGender(), employees.get(i).getAddress(),
						employees.get(i).getPhoneNumber(), employees.get(i).getSalary());
			} else if (employees.get(i) instanceof Security) {
				System.out.printf("| %-7s | %-16s | %-30s | %-5d | %-10s | %-30s | %-15s | Rp. %-11d |\n",
						employees.get(i).getId(), "Security", employees.get(i).getName(),
						employees.get(i).getAge(), employees.get(i).getGender(), employees.get(i).getAddress(),
						employees.get(i).getPhoneNumber(), employees.get(i).getSalary());
			} else if (employees.get(i) instanceof CleaningService) {
				System.out.printf("| %-7s | %-16s | %-30s | %-5d | %-10s | %-30s | %-15s | Rp. %-11d |\n",
						employees.get(i).getId(), "Cleaning Service", employees.get(i).getName(),
						employees.get(i).getAge(), employees.get(i).getGender(), employees.get(i).getAddress(),
						employees.get(i).getPhoneNumber(),employees.get(i).getSalary());
			}
		}
    	System.out.println("=========================================================================================================================================================");
    }
    
    private void updateEmployee(){
		if (employees.isEmpty()) {
			System.out.println("There is no employee!");
		} else {
			String id;
			int idx = -1;
			viewEmployeeTable();
			
			do {
				System.out.print("Choose employee ID to update [input 0 to go back]: ");
				id = scan.nextLine();
				
				if (id.equals("0")) return;
				else idx = searchEmployee(id);
			} while (idx == -1);

			int salaryUpdate = 0;
			do {
				System.out.print("Update employee's salary [min. 5000000]: ");
				salaryUpdate = scanint();
			} while (salaryUpdate < 5000000);
			scan.nextLine();

			employees.get(idx).setSalary(salaryUpdate);
			System.out.println("\n" + id + "'s salary has been updated!");
		}
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
    }
    
    private int searchEmployee(String id){
    	for(int i = 0; i < employees.size();i++) {
			if(id.equals(employees.get(i).getId())) {
				return i;
			}
		}
		return -1;
    }

	private void fireEmployee() {
		if (employees.isEmpty()) {
    		System.out.println("There is no employee!");
    	} else {
    		String id;
			int idx = -1;
			viewEmployeeTable();
			
    		do {
				System.out.print("Choose employee ID to fire [input 0 to go back]: ");
				id = scan.nextLine();
				
				if (id.equals("0")) return;
				else idx = searchEmployee(id);
			} while (idx == -1);
        		
    		employees.remove(idx);
    		System.out.println("\n" + id + " has been fired!");
    	}
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	// ================== Student Menu ==================
	private void StudentMenu() {
		if (students.isEmpty()) {
			System.out.println("There are no students yet!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		} else {
			int studentIdx;
			String studentId;
			
			do {
				System.out.print("Input your ID [input 0 to go back]: ");
				studentId = scan.nextLine();
				if (studentId.equals("0")) return;
				else studentIdx = searchStudent(studentId); 
			} while (studentIdx == -1);
			
			Student student = students.get(studentIdx);
			int menuChoice;
	    	do {
	    			cls();
		            System.out.println("Hello, " + student.getName() + "!");
		            System.out.println("---------");
		            System.out.println("1. Jajan");
		            System.out.println("2. Belajar");
		            System.out.println("3. Exit");
		            
		            do {
			            System.out.print(">> ");
			            menuChoice = scanint();
		            } while (menuChoice < 1 || menuChoice > 3);
		            scan.nextLine();
		            
		            cls();
		            switch (menuChoice) {
					case 1:
						jajan(student);
						break;
					case 2:
						belajar(student);
						break;
					}
	            } while (menuChoice != 3);
		}
	}
	
	private void jajan(Student student) {
		int quantity = 0;
		
		kp.ViewBarang(true);
		if (!kp.isEmpty()) {
			Barang boughtProduct = kp.jajan();
			
			do {
				System.out.print("Input quantity [1 - " + boughtProduct.getQuantity() + "]: ");
				quantity = scanint();
			} while (quantity < 1 || quantity > boughtProduct.getQuantity());
			scan.nextLine();
			
			if (randomEquation()) {
				int totalPrice = kp.calculateTotalPrice(boughtProduct, quantity);
				System.out.println("\n" + student.getId() + " has bought " + boughtProduct.getId() + " for Rp. " + totalPrice + "!");
			} else {
				System.out.println("\nYou failed the equation!");
			}
		}

		System.out.print("Press enter to continue...");
		scan.nextLine();
	}
	
	private boolean randomEquation() {
		int ans = 0, ansInput = -1;
		int num1 = rand.nextInt(20)+1;
		int num2 = rand.nextInt(20)+1;
		int op = rand.nextInt(3);
		
		System.out.print("Enter this equation (");
		if (op == 0) {
			ans = num1+num2;
			System.out.print(num1 + " + " + num2);
		} else if (op == 1) {
			ans = num1-num2;
			System.out.print(num1 + " - " + num2);
		} else {
			ans = num1*num2;
			System.out.print(num1 + " * " + num2);
		}
		System.out.print("): ");
		
		ansInput = scan.nextInt();
		scan.nextLine();
		if (ansInput == ans) {
			return true;
		} else {
			return false;
		}
	}
	
	private void belajar(Student student) {
		int duration = rand.nextInt(10)+1;
		for (int i = duration; i > 0; i--) {
			System.out.println("Learning ended in " + i + " hours...");
			sleepthread(1000);
		}
		System.out.println("Learning has ended...");
		
		int score = rand.nextInt(5)+1;
		score *= duration;
		
		if (score + student.getScore() > 100) {
			score = 100-student.getScore();
		}
		
		System.out.println("\n" + student.getId() + "'s score is increased by " + score + "!");
		student.setScore(score + student.getScore());
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	private void sleepthread(int x) { 
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// ==================== Employee Menu ====================
	private void EmployeeMenu() {
		if (employees.isEmpty()) {
			System.out.println("There are no employees yet!");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
		} else {
			int employeeIdx;
			String employeeId;
			
			do {
				System.out.print("Input your ID [input 0 to go back]: ");
				employeeId = scan.nextLine();
				if (employeeId.equals("0")) return;
				else employeeIdx = searchEmployee(employeeId); 
			} while (employeeIdx == -1);
			
			Employee employee = employees.get(employeeIdx);
			int menuChoice;
	    	do {
	    			cls();
		            System.out.println("Hello, " + employee.getName() + "!");
		            System.out.println("---------");
		            System.out.println("1. Jajan");
		            System.out.println("2. Bekerja");
		            System.out.println("3. Exit");
		            
		            do {
			            System.out.print(">> ");
			            menuChoice = scanint();
		            } while (menuChoice < 1 || menuChoice > 3);
		            scan.nextLine();
		            
		            cls();
		            switch (menuChoice) {
					case 1:
						jajan(employee);
						break;
					case 2:
						bekerja(employee);
						break;
					}
	            } while (menuChoice != 3);
		}
	}
	
	private void jajan(Employee employee) {
		int quantity = 0;
		
		kp.ViewBarang(true);
		if (!kp.isEmpty()) {
			Barang boughtProduct = kp.jajan();
			
			do {
				System.out.print("Input quantity [1 - " + boughtProduct.getQuantity() + "]: ");
				quantity = scanint();
			} while (quantity < 1 || quantity > boughtProduct.getQuantity());
			scan.nextLine();
			
			if (randomEquation()) {
				int totalPrice = kp.calculateTotalPrice(boughtProduct, quantity);
				System.out.println("\n" + employee.getId() + " has bought " + boughtProduct.getId() + " for Rp. " + totalPrice + "!");
			} else {
				System.out.println("\nYou failed the equation!");
			}
		}

		System.out.print("Press enter to continue...");
		scan.nextLine();
	}
	
	private void bekerja(Employee employee) {
		int duration = rand.nextInt(10)+1;
		for (int i = duration; i > 0; i--) {
			System.out.println("Working ended in " + i + " hours...");
			sleepthread(1000);
		}
		System.out.println("Working has ended...");
		
		int salary = rand.nextInt(15)+5;
		salary += duration;
		salary *= 1000000;
		
		System.out.println("\n" + employee.getId() + "'s salary is increased by " + salary + "!");
		employee.setSalary(salary + employee.getSalary());
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
	}
	
    public Main(){
    	int menuChoice;
    	do {
    			cls();
	            System.out.println("Sekolahku");
	            System.out.println("---------");
	            System.out.println("1. Menu Admin");
	            System.out.println("2. Menu Student");
	            System.out.println("3. Menu Employee");
	            System.out.println("4. Exit");
	            
	            do {
		            System.out.print(">> ");
		            menuChoice = scanint();
	            } while (menuChoice < 1 || menuChoice > 4);
	            scan.nextLine();
	            
	            cls();
	            switch (menuChoice) {
				case 1:
					AdminMenu();
					break;
				case 2:
					StudentMenu();
					break;
				case 3:
					EmployeeMenu();
					break;
				}
            } while (menuChoice != 4);      
    }

    public static void main(String args[]){
        new Main();
    }
}
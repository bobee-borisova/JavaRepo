import java.util.Scanner;

public class ElectricityBill {
    int custNo; 
    String custName;
    int prevReading; 
    int currentReading; 
    int connectionType; 
    int units; 
    double bill; 

    //input method
    void input_data(){
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Please enter customer number: ");
            custNo = scan.nextInt();

            System.out.println("Please enter customer name: ");
            custName = scan.next();

            System.out.println("Please enter previous units: ");
            prevReading = scan.nextInt();

            System.out.println("Please enter current units: ");
            currentReading = scan.nextInt();

            System.out.println("Connection type: 1 for domestic or 2 for commercial");
            connectionType = scan.nextInt();
        }
    }

    //bill calculation method
    void calculateBill(){
        units = currentReading - prevReading; 
        System.out.println("\n Number of units: " + units);

        switch(connectionType) {
			case 1: if(units >= 0 && units <= 100) {
				bill = units * 1;
			}else if(units >= 100 && units <= 200) {
				bill = (100 * 1) + ((units - 100) * 2.50);
			}else if(units >= 200 && units <= 500) {
				bill = (100 * 1) + (100 * 2.5) + ((units - 200) * 4);
			}else {
				bill = (100 * 1) + (100 * 2.5) + (300 * 4) + ((units - 500) * 6);
			}
			break;
				
			case 2: if(units >= 0 && units <= 100) {
				bill = units * 2;
			}else if(units >= 100 && units <= 200) {
				bill = (100 * 2) + ((units - 100) * 4.50);
			}else if(units >= 200 && units <= 500) {
				bill = (100 * 2) + (100 * 4.50) + ((units - 200) * 6);
			}else {
				bill = (100 * 2) + (100 * 4.50) + (300 * 6) + ((units - 500) * 7);
			}
			break;
		}
    }

    //show bill
    void display(){
        System.out.println("*******************");
		System.out.println("ELECTRICITY BILL");
		System.out.println("*******************");
		System.out.println("Customer number: " + custNo);
		System.out.println("Customer name: " + custName);
		System.out.println("Previous reading: " + prevReading);
		System.out.println("Current reading: " + currentReading);
		System.out.println("Type of connection: " + connectionType);
		System.out.println("*******************");
		System.out.println("Total bill is: " + bill);
    }

    public static void main(String args[]){
        ElectricityBill eb = new ElectricityBill();
        eb.input_data();
        eb.calculateBill();
        eb.display();
    }
}

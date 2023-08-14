package lld.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ParkingLot p = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to PNR1234 parking lot!!");
		String input = "menu";
		System.out.println("Enter following:\n " + "1. create_parking_lot PR1234 <floors> <slots>\n"
				+ "2. display free_count <vehicleType>\n" + "3. display free_slots <vehicleType>\n"
				+ "4. display occupied_slots <vehicleType>\n" + "5. park_vehicle <vehicletype> <regno> <color>\n"
				+ "6. unpark_vehicle <ticketid>");

		while (!input.equals("exit")) {
			input = sc.next();
			switch (input) {
			case "create_parking_lot":
				p = new ParkingLot(sc.next(), sc.nextInt(), sc.nextInt());
				System.out.println(p);
				break;
			case "display": {
				String subcommand = sc.next();
				if(subcommand.equals("free_count")) {
				String vehicleType = sc.next();
				p.displayFreeCount(Enum.valueOf(VehicleType.class, vehicleType));
				 
				}
				else if (subcommand.equals("free_slots")) {
					String vehicleType = sc.next();
					p.displayFreeSlots(Enum.valueOf(VehicleType.class, vehicleType));
				}
				break;
				 
			}
			 
			case "park_vehicle": {
				String vehicle = sc.next();
				String regNo = sc.next();
				String color = sc.next();

				if (vehicle.equals("CAR")) {
					p.parkVehicle(new Car(VehicleType.CAR, regNo, color));
				} else if (vehicle.equals("BIKE")) {
					p.parkVehicle(new Bike(VehicleType.BIKE, regNo, color));
				} else if (vehicle.equals("TRUCK")) {
					p.parkVehicle(new Truck(VehicleType.TRUCK, regNo, color));
				}
				break;
			}
			case "unpark_vehicle": {
				String ticket = sc.next();
				String[] ticketTokens = ticket.split("_");
				String parkingSlot = ticketTokens[0];
				int floorNum = Integer.valueOf(ticketTokens[1]);
				int slotNum = Integer.valueOf(ticketTokens[2]);

				p.unparkVehicle(new ParkingTicket(parkingSlot, floorNum, slotNum));
				break;
			}

			case "menu":
				System.out.println("Enter following:\n " + "1. create_parking_lot PR1234 <floors> <slots>\n"
						+ "2. display free_count <vehicleType>\n" + "3. display free_slots <vehicleType>\n"
						+ "4. display occupied_slots <vehicleType>\n"
						+ "5. park_vehicle <vehicletype> <regno> <color>\n" + "6. unpark_vehicle <ticketid>");
				break;

			default:
				System.out.println("nothign matched");
			}

		}

	}
}

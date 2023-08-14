package lld.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ParkingLot {

	String id;

	List<Floor> floors;

	int numSlots;

	int numFloors;

	Map<ParkingTicket, Vehicle> parkings = new HashMap<>();

	
	ParkingLot(String id, int numFloors, int numSlots) {
		this.floors = new ArrayList<Floor>();
		this.id = id;
		this.numFloors = numFloors;
		this.numSlots = numSlots;

		for (int i = 0; i < numFloors; i++) {
			Floor f = new Floor(i);
			for (int j = 0; j < numSlots; j++) {
				if (j == 0)
					f.slots.add(new ParkingSlot(j, VehicleType.TRUCK, AVAILABILITY_STATUS.FREE));
				else if (j == 1 || j == 2)
					f.slots.add(new ParkingSlot(j, VehicleType.BIKE, AVAILABILITY_STATUS.FREE));
				else  
					f.slots.add(new ParkingSlot(j, VehicleType.CAR, AVAILABILITY_STATUS.FREE));
				 
			}
			this.floors.add(f);
		}

	}

	 
	
	void displayFreeCount(VehicleType type) {
		for (int i = 0; i < floors.size(); i++) {

			Floor f = floors.get(i);
			System.out.print("Floor# " + i+" \n");
			f.displayCount(type, AVAILABILITY_STATUS.FREE);
			System.out.println();
		}
	}
	
	void displayFreeSlots(VehicleType type) {
		for (int i = 0; i < floors.size(); i++) {

			Floor f = floors.get(i);
			System.out.print("Floor# " + i+" \n");
			f.displaySlotsDetails(type, AVAILABILITY_STATUS.FREE);
			System.out.println();
		}
	}
	
	void displayOccupiedSlots(VehicleType type){
		for (int i = 0; i < floors.size(); i++) {

			Floor f = floors.get(i);
			System.out.print("Floor# " + i+" \n");
			f.displaySlotsDetails(type,AVAILABILITY_STATUS.OCCUPIED);
			System.out.println();
		}
	}
	

	ParkingTicket parkVehicle(Vehicle vehicle) {
		final ParkingTicket p = new ParkingTicket("PR1234", -1	, -1);
		for (int i = 0; i < floors.size(); i++) {
			Floor f = floors.get(i);

			ParkingSlot slot = f.slots.stream()
					.filter(s -> s.vehicleType == vehicle.vehicleType && s.occupied == AVAILABILITY_STATUS.FREE)
					.findFirst().orElse(null);

			if (slot != null) {
				slot.occupied = AVAILABILITY_STATUS.OCCUPIED;
				p.floorNum = i;
				p.slotNum = slot.id;
				parkings.put(p, vehicle) ;
				break;
			}

		}

		if (p.slotNum == -1) {
			System.out.println("Parking Lot Full");
			return null;
		}
		return p;
	}

	void unparkVehicle(ParkingTicket ticket) {
		Floor f = floors.get(ticket.floorNum);
		ParkingSlot s = f.slots.get(ticket.slotNum);

		if (s.occupied == AVAILABILITY_STATUS.FREE) {
			System.out.println("Invalid Ticket");
		} else {
			Vehicle v = parkings.get(ticket);
			System.out.println("unparked vehicle with details "+v.regNo+" "+v.color);
			s.occupied = AVAILABILITY_STATUS.FREE;
			
		}

	}

}

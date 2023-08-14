package lld.parkinglot;

import java.util.*;

public class Floor {
     List<ParkingSlot> slots;
     int id;
     public Floor(int id) {
		slots = new ArrayList<ParkingSlot>();
		this.id = id;
	}

	public void display(VehicleType type, AVAILABILITY_STATUS availability) {
		if(type==null)
		 for(int i=0;i<slots.size();i++) {
			 System.out.println("slot Details:# "+slots.get(i));
		 }
		else {
			slots.stream().filter(s->s.vehicleType==type && s.occupied == availability).forEach(System.out::println);;
		}
		
	}
	
	public void displayCount(VehicleType type, AVAILABILITY_STATUS status) {
		 
			 long count  = slots.stream().filter(s->s.vehicleType==type && s.occupied == status).count();
			 System.out.println("count# "+count);
		 
	}
	
	public void displaySlotsDetails(VehicleType type, AVAILABILITY_STATUS status) {
		 
			slots.stream().filter(s->s.vehicleType==type && s.occupied == status).forEach(s->{
				System.out.println(s);
			});
			  
		 
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Floor# "+id;
	}
    
}

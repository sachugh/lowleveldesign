package lld.parkinglot;

public class ParkingSlot {
	VehicleType vehicleType;
	AVAILABILITY_STATUS occupied;
	int id;

	public ParkingSlot(int id, VehicleType vehicleType, AVAILABILITY_STATUS occupied) {
		super();
		this.vehicleType = vehicleType;
		this.occupied = occupied;
		this.id = id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "slot#"+(id)+" slotType:"+vehicleType+" Availability:"+occupied ;
	}

}

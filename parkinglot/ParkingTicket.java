package lld.parkinglot;

import java.util.Objects;

public class ParkingTicket {
	String parkingLotId;
	int floorNum;
	int slotNum;

	public ParkingTicket(String parkingLotId, int floorNum, int slotNum) {
		super();
		this.parkingLotId = parkingLotId;
		this.floorNum = floorNum;
		this.slotNum = slotNum;
	}

	@Override
	public String toString() {
		return parkingLotId + "_" + floorNum + "_" + slotNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(floorNum, parkingLotId, slotNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingTicket other = (ParkingTicket) obj;
		return floorNum == other.floorNum && Objects.equals(parkingLotId, other.parkingLotId)
				&& slotNum == other.slotNum;
	}

	 
	
	
	
	

}

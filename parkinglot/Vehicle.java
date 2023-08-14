package lld.parkinglot;

public class Vehicle {
   VehicleType vehicleType;
   String regNo;
   String color;
   
   Vehicle(VehicleType type, String regnum, String clr){
	   this.vehicleType = type;
	   this.regNo = regnum;
	   this.color = clr;
   }

@Override
public String toString() {
	return "Vehicle [vehicleType=" + vehicleType + ", regNo=" + regNo + ", color=" + color + "]";
}
   
    
}

package com.yan.util;

import com.yan.entity.Vehicle;
import com.yan.entity.Car;
import com.yan.entity.Truck;
import com.yan.entity.Carriage;

public class VehicleUtil {
	public static Vehicle createVehicle(String color,double Rentprice,String Licenseno,String name,int type,int Limdate,int load,int Loadpe)
	{
		Vehicle vehicle=null;
		switch(type){
		case 1:
			vehicle=new Car(color,Rentprice,Licenseno,name,Limdate);
			break;
		case 2:
			vehicle=new Truck(color,Rentprice,Licenseno,name,Limdate,load);
			break;
		case 3:
			vehicle=new Carriage(color,Rentprice,Licenseno,name,Limdate,Loadpe);
			break;
			
		}
		
		return vehicle;
		
	}

}

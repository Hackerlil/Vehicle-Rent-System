package com.yan.entity;

public class Car extends Vehicle {
	public Car(){
		super();
	}
	/**
	 * @param color
	 * @param Rentprice
	 * @param licenseNO
	 * @param name
	 * @param LimDate
	 * @param rentUser
	 * @param yearsOfService
	 */
	public Car(String color,double Rentprice,String Licenseno,String name,int Limdate)
	{
		super(color,Rentprice,Licenseno,name,Limdate);
		
	}
	@Override
	public double caclprice() {
		// TODO Auto-generated method stub
		if(super.getLimdate()<30)
		{
			return super.getRentprice()*super.getLimdate();
		}
		else{
			double baseprice=super.getRentprice()*30;
			double price=baseprice+(super.getLimdate()-30)*1.1*super.getRentprice();
			return price;
		}
			
		
	}
	}

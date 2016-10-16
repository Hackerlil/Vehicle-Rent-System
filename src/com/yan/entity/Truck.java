package com.yan.entity;

public class Truck extends Vehicle {
	public int load;//增加载重量属性
	public void setload(int load)
	{
		this.load=load;
	}
	public int getload()
	{
		return load;
	}
	public Truck()
	{
		super();
	}
	public Truck(String color,double Rentprice,String Licenseno,String name,int Limdate,int load)
	{
		super(color,Rentprice,Licenseno,name,Limdate);
		this.load=load;
	}

	@Override
	public double caclprice() {
		// TODO Auto-generated method stub
		if(super.getLimdate()<30)
		{
			return super.getRentprice()*super.getLimdate()*this.load;
		}
		else{
			double baseprice=super.getRentprice()*30;
			double price=baseprice+(super.getLimdate()-30)*1.1*super.getRentprice()*this.load;
			return price;
		}
		
	}

}

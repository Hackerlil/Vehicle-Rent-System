package com.yan.entity;

public class Carriage extends Vehicle {
	private int Loadpe;//增加载客量属性
	public void setLoadp(int Loadpe)
	{
		this.Loadpe=Loadpe;
	}
	public int getLoadpe()
	{
		return Loadpe;
	}
	public Carriage(){
		super();
	}
	/*
	 * param@color
	 * 
	 */
	public Carriage(String color,double Rentprice,String Licenseno,String name,int Limdate,int Loadpe)
	{
		super(color,Rentprice,Licenseno,name,Limdate);
		this.Loadpe=Loadpe;
	}

	@Override
	public double caclprice() {
		// TODO Auto-generated method stub
		if(super.getLimdate()<7)
		{
			return super.getRentprice()*super.getLimdate()*this.getLoadpe();
		}
		else
			return super.getRentprice()*super.getLimdate()*this.getLoadpe()*1.1;
		
	}

}

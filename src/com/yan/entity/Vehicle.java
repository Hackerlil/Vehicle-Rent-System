package com.yan.entity;

public abstract class Vehicle {
	private String color;//车的颜色
	private double Rentprice;//日租车价格
	private String user;//租户名字
	private String Licenseno;//车牌号
	private int Limdate;//使用年限
	private String name;//车辆类型名称
	private int days;//租用时间
	public void setcolor(String color){
		this.color=color;
	}
	public String getcolor(){
		return color;
	}
	public void setRentpice(double Rentprice){
		this.Rentprice=Rentprice;
	}
	public double getRentprice(){
		return Rentprice;
	}
	public void setuser(String user)
	{
		this.user=user;
	}
	public String getuser()
	{
		return user;
	}
	public void setLicenseNo(String Licenseno){
		this.Licenseno=Licenseno;
	}
	public String getLincenseno(){
		return Licenseno;
	}
	public void setLimdate(int Limdate){
		this.Limdate=Limdate;
	}
	public int getLimdate(){
		return Limdate;
	}
	public void setname(String name){
		this.name=name;
	}
	public String getname(){
		return name;
	}
	public void setdays(int days){
		this.days=days;
	}
	public int getdays(){
		return days;
	}
	public Vehicle(String color,double Rentprice,String Licenseno,String name,int Limdate)
	{
		super();
		this.Licenseno=Licenseno;
		this.color=color;
		this.Rentprice=Rentprice;
		this.Limdate=Limdate;
		this.name=name;
	}
	/**
	 * 
	 */
	public Vehicle() {
		super();
	}
	public abstract double caclprice();






}

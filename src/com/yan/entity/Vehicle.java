package com.yan.entity;

public abstract class Vehicle {
	private String color;//������ɫ
	private double Rentprice;//���⳵�۸�
	private String user;//�⻧����
	private String Licenseno;//���ƺ�
	private int Limdate;//ʹ������
	private String name;//������������
	private int days;//����ʱ��
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

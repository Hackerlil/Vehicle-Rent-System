package com.yan.biz;

import java.util.Scanner;

import com.yan.entity.Car;
import com.yan.entity.Carriage;
import com.yan.entity.Truck;
import com.yan.entity.Vehicle;

import com.yan.util.VehicleUtil;

public class VehicleBiz {
	//可租车的数组
	Vehicle []vehicles=new Vehicle[100];
	//结算车辆的数组
	Vehicle []rentvehicles=new Vehicle[100];
	public void initial()//初始化录入信息
	{
		//可租车信息
		vehicles[0]=new Car("黑色",320.00,"粤A124k0","奥迪Q7",4);
		vehicles[1]=new Truck("绿色",220.00,"鄂Bk2954","东风",8,100);
		vehicles[2]=new Carriage("白色",400.00,"赣Bk9384","宇通",10,90);
		//待结算的车辆
		rentvehicles[0]=new Truck("白色",340.00,"沪Aj9834","ISUZS",5,120); 
		rentvehicles[1]=new Car("黑色",240.00,"陕Fjf938","宝马x6",7);
		rentvehicles[2]=new Carriage("蓝白色",440.00,"陕Ajf348","斯考特",7,30);
	}
	public void Mainmenu(){
		Scanner scan=new Scanner(System.in);
		do{
			System.out.println("欢迎进入os汽车租赁系统！");
			System.out.println("======================");
			System.out.println("1、租车 2、还车 3、新车入库 4、退出");
			int choice=scan.nextInt();
		switch(choice){
		case 1:
			RentVehicle();
			continue;
		case 2:
			ReturnVehicle();
			continue;
		case 3:
			insertVehicle();
			continue;
		case 4:
			System.out.println("程序退出！谢谢使用");
			break;
		default:
			System.out.println("输入错误！请重新输入");
			continue;
			}
		break;	
		}while(true);
	}
	private void insertVehicle() 
	{
		// TODO Auto-generated method stub
		System.out.println("=====================================");
		Scanner input=new Scanner(System.in);
		System.out.println("请选择入库车型:");
		System.out.println("1、轿车  2、卡车 3、客车");
		System.out.println("======================================");
		int choice=input.nextInt();
		System.out.println("请输入车牌号:");
		String lisenceno=input.next();
		System.out.println("请输入车型:");
		String name=input.next();
		System.out.println("请输入车的颜色:");
		String color=input.next();
		System.out.println("请输入使用年限:");
		int year=input.nextInt();
		System.out.println("请输入日租金:");
		double price=input.nextDouble();
		int load=0,loadpe=0;
		if (choice==2) {
			System.out.println("请输入载重量:");
			 load=input.nextInt();
		}
		if(choice==3){
			System.out.println("请输入载客量：");
			loadpe=input.nextInt();
		}
		Vehicle v=VehicleUtil.createVehicle(color, price, lisenceno, name,choice,year,load,loadpe);
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i]==null) 
			{
				vehicles[i]=v;
				break;
				
			}
		}
		System.out.println("新车入库成功!");
		showInfo(vehicles);
		
	}
	private void ReturnVehicle() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		showInfo(rentvehicles);
		System.out.println("================");
		System.out.println("请输入还车编号：");
		int i=in.nextInt();
		System.out.println("请输入租用天数：");
		int m=in.nextInt();
		System.out.println("共租用"+m+"天，因付租金为："+rentvehicles[i-1].caclprice());
		System.out.println("还车成功！");
		for(int k=0;k<vehicles.length;k++)
		{
			if(vehicles[k]==null)
			{
				vehicles[k]=rentvehicles[i-1];
				break;
			}
		}
		//在结算车中删除 
		for (int l =i-1;l<rentvehicles.length-1;l++) 
		{
		 if (rentvehicles[l]!=null)
			{
			  rentvehicles[l]=rentvehicles[l+1];
			}else{
				break;
				}
		}
		showInfo(rentvehicles);
	}
	public void RentVehicle()
	{
		Scanner input=new Scanner(System.in);
		showInfo(vehicles);//调用显示的方法
		System.out.println("=====================================");
		System.out.println("请输入车辆编号:");
		int no=input.nextInt();
		System.out.println("请输入车辆名称:");
		String name=input.next();
		Vehicle v=vehicles[no-1];
		v.setname(name);//为租用者赋值 
		//放到结算车辆的数组中
		for (int i = 0; i < rentvehicles.length; i++) {
			if(rentvehicles[i]==null){
				rentvehicles[i]=v;
				break;
			}
		}
		//移动位置
		for (int i =no-1;i<vehicles.length-1;i++) {
			if (vehicles[i]!=null) {
				vehicles[i]=vehicles[i+1];
			}else{
				break;
			}
		}
		System.out.println("租车成功!");
		showInfo(vehicles);//调用显示的方法
		
	}
	@SuppressWarnings("unused")
	private void showInfo(Vehicle []veh)
	{
		System.out.println("序号 \t车名\t颜色\t使用时间 \t日租金 \t卡车载重\t载客量 ");
		int i=1;
		for(Vehicle v:veh){
			if (v==null) {
				break;
			}
			if (v instanceof Truck) {
				Truck t=(Truck)v;
				System.out.println(i+"\t"+t.getname()+"\t"+t.getcolor()+"\t"+t.getLimdate()+"\t"+t.getRentprice()+"\t"+t.getload()+"\t无");
			}else if(v instanceof Carriage)
			{
				Carriage ca=(Carriage)v;
				System.out.println(i+"\t"+ca.getname()+"\t"+ca.getcolor()+"\t"+ca.getLimdate()+"\t"+ca.getRentprice()+"\t无"+"\t"+ca.getLoadpe());
			}else
			{
				Car c=(Car)v;
				System.out.println(i+"\t"+c.getname()+"\t"+c.getcolor()+"\t"+c.getLimdate()+"\t"+c.getRentprice()+"\t无"+"\t无");
			}
			i++;
		}
		
	
	}
	

}

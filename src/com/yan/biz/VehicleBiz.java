package com.yan.biz;

import java.util.Scanner;

import com.yan.entity.Car;
import com.yan.entity.Carriage;
import com.yan.entity.Truck;
import com.yan.entity.Vehicle;

import com.yan.util.VehicleUtil;

public class VehicleBiz {
	//���⳵������
	Vehicle []vehicles=new Vehicle[100];
	//���㳵��������
	Vehicle []rentvehicles=new Vehicle[100];
	public void initial()//��ʼ��¼����Ϣ
	{
		//���⳵��Ϣ
		vehicles[0]=new Car("��ɫ",320.00,"��A124k0","�µ�Q7",4);
		vehicles[1]=new Truck("��ɫ",220.00,"��Bk2954","����",8,100);
		vehicles[2]=new Carriage("��ɫ",400.00,"��Bk9384","��ͨ",10,90);
		//������ĳ���
		rentvehicles[0]=new Truck("��ɫ",340.00,"��Aj9834","ISUZS",5,120); 
		rentvehicles[1]=new Car("��ɫ",240.00,"��Fjf938","����x6",7);
		rentvehicles[2]=new Carriage("����ɫ",440.00,"��Ajf348","˹����",7,30);
	}
	public void Mainmenu(){
		Scanner scan=new Scanner(System.in);
		do{
			System.out.println("��ӭ����os��������ϵͳ��");
			System.out.println("======================");
			System.out.println("1���⳵ 2������ 3���³���� 4���˳�");
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
			System.out.println("�����˳���ллʹ��");
			break;
		default:
			System.out.println("�����������������");
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
		System.out.println("��ѡ����⳵��:");
		System.out.println("1���γ�  2������ 3���ͳ�");
		System.out.println("======================================");
		int choice=input.nextInt();
		System.out.println("�����복�ƺ�:");
		String lisenceno=input.next();
		System.out.println("�����복��:");
		String name=input.next();
		System.out.println("�����복����ɫ:");
		String color=input.next();
		System.out.println("������ʹ������:");
		int year=input.nextInt();
		System.out.println("�����������:");
		double price=input.nextDouble();
		int load=0,loadpe=0;
		if (choice==2) {
			System.out.println("������������:");
			 load=input.nextInt();
		}
		if(choice==3){
			System.out.println("�������ؿ�����");
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
		System.out.println("�³����ɹ�!");
		showInfo(vehicles);
		
	}
	private void ReturnVehicle() {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		showInfo(rentvehicles);
		System.out.println("================");
		System.out.println("�����뻹����ţ�");
		int i=in.nextInt();
		System.out.println("����������������");
		int m=in.nextInt();
		System.out.println("������"+m+"�죬�����Ϊ��"+rentvehicles[i-1].caclprice());
		System.out.println("�����ɹ���");
		for(int k=0;k<vehicles.length;k++)
		{
			if(vehicles[k]==null)
			{
				vehicles[k]=rentvehicles[i-1];
				break;
			}
		}
		//�ڽ��㳵��ɾ�� 
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
		showInfo(vehicles);//������ʾ�ķ���
		System.out.println("=====================================");
		System.out.println("�����복�����:");
		int no=input.nextInt();
		System.out.println("�����복������:");
		String name=input.next();
		Vehicle v=vehicles[no-1];
		v.setname(name);//Ϊ�����߸�ֵ 
		//�ŵ����㳵����������
		for (int i = 0; i < rentvehicles.length; i++) {
			if(rentvehicles[i]==null){
				rentvehicles[i]=v;
				break;
			}
		}
		//�ƶ�λ��
		for (int i =no-1;i<vehicles.length-1;i++) {
			if (vehicles[i]!=null) {
				vehicles[i]=vehicles[i+1];
			}else{
				break;
			}
		}
		System.out.println("�⳵�ɹ�!");
		showInfo(vehicles);//������ʾ�ķ���
		
	}
	@SuppressWarnings("unused")
	private void showInfo(Vehicle []veh)
	{
		System.out.println("��� \t����\t��ɫ\tʹ��ʱ�� \t����� \t��������\t�ؿ��� ");
		int i=1;
		for(Vehicle v:veh){
			if (v==null) {
				break;
			}
			if (v instanceof Truck) {
				Truck t=(Truck)v;
				System.out.println(i+"\t"+t.getname()+"\t"+t.getcolor()+"\t"+t.getLimdate()+"\t"+t.getRentprice()+"\t"+t.getload()+"\t��");
			}else if(v instanceof Carriage)
			{
				Carriage ca=(Carriage)v;
				System.out.println(i+"\t"+ca.getname()+"\t"+ca.getcolor()+"\t"+ca.getLimdate()+"\t"+ca.getRentprice()+"\t��"+"\t"+ca.getLoadpe());
			}else
			{
				Car c=(Car)v;
				System.out.println(i+"\t"+c.getname()+"\t"+c.getcolor()+"\t"+c.getLimdate()+"\t"+c.getRentprice()+"\t��"+"\t��");
			}
			i++;
		}
		
	
	}
	

}

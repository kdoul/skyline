

import java.util.Scanner;
public class MySkylineApp {
	
	//public static int size;

	public static void main(String[] args) {
		
		
		SkylineAlg1 Alg1 = new SkylineAlg1();
		SkylineAlg2 Alg2 = new SkylineAlg2();
		int select;
		Scanner input = new Scanner(System.in);
		
		ListDoublePoints List = new ListDoublePoints();
		ListDoublePoints List_2 = new ListDoublePoints();
		
		
		ListIterator itr = new ListIterator(List.header);
		ListIterator itr_2 = new ListIterator(List_2.header);
		
		/*//TEST SKYLINE DUMMY. 
		List.insert(1.0, 9.0, itr);
		List.insert(2.0, 10.0, itr);
		List.insert(4.0, 8.0, itr);
		List.insert(3.0, 2.0, itr);
		List.insert(4.0, 3.0, itr);
		List.insert(5.0, 4.0, itr);
		List.insert(6.0, 2.0, itr);
		List.insert(6.0, 6.0, itr);
		List.insert(8.0, 2.0, itr);
		List.insert(9.0, 1.0, itr);
		
		
		ListDoublePoints.printList(List);*/
		
		/*
		List.delete(2.0, 10.0);
		List.delete(8.0, 2.0);
		ListDoublePoints.printList(List);
		
		//System.out.println(List.findPrevious(2.0, 10.0).retrieve().x + " " + List.findPrevious(2.0, 10.0).retrieve().y);
		//System.out.println(List.findPrevious(8.0, 2.0).retrieve().x + " " + List.findPrevious(8.0, 2.0).retrieve().y);
		*/
		
		
		System.out.println("How many Points do you want to make? ");
		select = input.nextInt();
		input.close();
		
		List.makePoints(List, List_2, select, itr, itr_2);
		
		
		/*System.out.println("Points before skyline 1 ");
		ListDoublePoints.printList(List);
		System.out.println("Points before skyline 2 ");
		ListDoublePoints.printList(List_2);*/
		
		
		
		
		Alg1.Algorithm1(List);
		Alg2.Algorithm2(List_2);
		
		
		System.out.println("Skyline1: ");
		ListDoublePoints.printList(List);
		
		System.out.println(" \n Time elapsed for Algorithm_1 : " +SkylineAlg1.myTime +" miliseconds \n");
		
		System.out.println("Skyline2 : ");
		ListDoublePoints.printList(List_2);
		
		System.out.println(" \n Time elapsed for Algorithm_2 : " +SkylineAlg2.myTime +" miliseconds \n");
		
		
	}

}

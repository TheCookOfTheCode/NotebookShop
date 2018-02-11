package app;

import java.util.Scanner;

import data.DataStore;

public class NotebookShop {

	public static void main(String[] args) {
	Scanner sc1= new Scanner(System.in);
	DataStore datastore = new DataStore();

	int mainNumber=-1;
	
	// G³ówna pêtla - Menu
	while(mainNumber !=DataStore.EXIT) { 
		
		datastore.mainMenu();
		mainNumber=sc1.nextInt();
		sc1.nextLine();
		
		switch(mainNumber) {
		case DataStore.EXIT:{
			System.out.println("Zamykam program");
			break;
		}
		case DataStore.ONE:{
			datastore.add();
			break;
		}
		case DataStore.TWO:{
			datastore.find();
			break;
		}
		}				
	}
	sc1.close();
}
}

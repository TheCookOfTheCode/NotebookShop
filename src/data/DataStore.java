package data;

import logic.Computer;

import java.util.Scanner;

public class DataStore {
	public static final int MAX = 100;
	public static final int EXIT = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public Computer[] computer = new Computer[MAX];
	int numberNotebook = 0;
	Scanner sc = new Scanner(System.in);
	int keyNumber=-1;
	public void miniMenu() {
		System.out.println("Powrót do g³ównego menu, wciœnij - 0");
		System.out.println("Dodanie nootebooka, wciñnij - 1");
		System.out.println("Wyœwietlenie listy wszystkich nootebooków - 2");
	}
	//Pêtla miniMenu - dodanie i wyœwietlenie notebooków
	public void add() {
		miniMenu();
			
		while (keyNumber != EXIT) { 
			
			keyNumber=sc.nextInt();
			
			switch (keyNumber) {
			case EXIT:{
				System.out.println("Powrót do g³ównego menu!");
				break;
			}
			case ONE: {
				if (numberNotebook < MAX) {
					System.out.println("Podaj nazwê producenta:");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.println("Podaj numer modelu:");
					int num=sc.nextInt();
					computer[numberNotebook] = new Computer(name, num);
					numberNotebook++;
					miniMenu();
				} else {
					System.out.println("Magazyn jest pe³ny!");
					miniMenu();
				}
				break;
			}
			case TWO: {
				System.out.println("W Twoim magazynie znajduje siê:");
				for (int i = 0; i < numberNotebook; i++) {
					System.out.println(computer[i]);
				}
				miniMenu();
				break;
			}
			default:{
				System.out.println("Wpisa³eœ niepoprawny numer");
				miniMenu();
			}
		}
		}
	}
    public int checkAvailability(Computer find) {
        if (find == null)
            return 0;
 
        int count = 0;
        for (int i = 0; i < numberNotebook; i++) {
            if (find.equals(computer[i])) {
                count++;
            }
        }
        return count;}
    
    public void find(){
    	System.out.println("Podaj nazwê producenta:");
    	sc.nextLine();
    	String name=sc.nextLine();
    	System.out.println("Podaj model:");
    	int num=sc.nextInt();
        Computer compToFind = new Computer(name, num);
        int computersFound = checkAvailability(compToFind);
        System.out.println("Liczba komputerów " + compToFind + ": " + computersFound+"szt.");
    }
   
	public void mainMenu() {
		System.out.println("Witaj w magazynie!");
		System.out.println("Wyjœcie z programu, wciœnij - 0");
		System.out.println("Dodanie notebooka lub wyœwietlenie listy wszystkich znajduj¹cych siê w magazynie, wciœnij - 1");
		System.out.println("Sprawdzenie stanu magazynowego danego modelu, wciœnij - 2");
	}
}

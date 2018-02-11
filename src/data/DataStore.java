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
		System.out.println("Powr�t do g��wnego menu, wci�nij - 0");
		System.out.println("Dodanie nootebooka, wci�nij - 1");
		System.out.println("Wy�wietlenie listy wszystkich nootebook�w - 2");
	}
	//P�tla miniMenu - dodanie i wy�wietlenie notebook�w
	public void add() {
		miniMenu();
			
		while (keyNumber != EXIT) { 
			
			keyNumber=sc.nextInt();
			
			switch (keyNumber) {
			case EXIT:{
				System.out.println("Powr�t do g��wnego menu!");
				break;
			}
			case ONE: {
				if (numberNotebook < MAX) {
					System.out.println("Podaj nazw� producenta:");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.println("Podaj numer modelu:");
					int num=sc.nextInt();
					computer[numberNotebook] = new Computer(name, num);
					numberNotebook++;
					miniMenu();
				} else {
					System.out.println("Magazyn jest pe�ny!");
					miniMenu();
				}
				break;
			}
			case TWO: {
				System.out.println("W Twoim magazynie znajduje si�:");
				for (int i = 0; i < numberNotebook; i++) {
					System.out.println(computer[i]);
				}
				miniMenu();
				break;
			}
			default:{
				System.out.println("Wpisa�e� niepoprawny numer");
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
    	System.out.println("Podaj nazw� producenta:");
    	sc.nextLine();
    	String name=sc.nextLine();
    	System.out.println("Podaj model:");
    	int num=sc.nextInt();
        Computer compToFind = new Computer(name, num);
        int computersFound = checkAvailability(compToFind);
        System.out.println("Liczba komputer�w " + compToFind + ": " + computersFound+"szt.");
    }
   
	public void mainMenu() {
		System.out.println("Witaj w magazynie!");
		System.out.println("Wyj�cie z programu, wci�nij - 0");
		System.out.println("Dodanie notebooka lub wy�wietlenie listy wszystkich znajduj�cych si� w magazynie, wci�nij - 1");
		System.out.println("Sprawdzenie stanu magazynowego danego modelu, wci�nij - 2");
	}
}

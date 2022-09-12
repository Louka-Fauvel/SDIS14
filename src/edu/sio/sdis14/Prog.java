package edu.sio.sdis14;

import java.util.Scanner;

import edu.sio.sdis14.exceptions.TelNumberException;
import edu.sio.sdis14.models.Pompier;

public class Prog {

	public static void main(String[] args) {
		
		Pompier pompier = new Pompier("Akou Velfau");
		Scanner sc = new Scanner(System.in);
		try {
			
			try {
				
				pompier.setTel(sc.nextLine());
				System.out.println(2 / 0);
				System.out.println(pompier.getTel());
				
			} catch (TelNumberException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (ArithmeticException ae) {
			System.out.println("Division par zéro");
		}
		sc.close();

	}

}

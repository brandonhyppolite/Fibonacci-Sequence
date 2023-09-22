/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

import java.util.*;
/**
 *
 * @author brandonhyppolite
 */
public class Fib {
    // constructor
	public Fib(int f0, int f1) 
	{
            this.f0 = f0;
            this.f1 = f1;
	}


	// computes F(n) using an ***iterative*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
	// use instance variables that store F(0) and F(1).
	// check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
        /**
         * performs iterative algorithm to print the Fibonacci sequence
         * @param n is the number of iterations 
         * @return the Fibonacci sequence for n iterations
         */
	public int f(int n) {
            int prev = f0;
            int current = f1;
            int next = prev + current;
            if (n<0){
                throw new IllegalArgumentException("invalid parameter: negative value");
            }
            else if (n == 0) {
                return f0;
            }
            else if (n == 1 ) {
                return f1;
            }
            else {
              for (int i=2; i<n; i++){
                  prev = current;
                  current = next;
                  next = prev + current;
              }
            }
            return next;
	}


	// computes F(n) using the ***recursive*** algorithm, where F(n) = F(n-1) + F(n-2) is the recursive definition.
	// use instance variables that store F(0) and F(1).
	// check parameter and throw exception if n < 0. Don't worry about arithmetic overflow.
        /**
         * Performs a recursive algorithm to compute the Fibonacci sequence
         * @param n the number of iterations
         * @return the Fibonacci sequence for n iterations
         */
	public int fRec(int n) {
            if (n<0){
                return n;
            }
            else if (n == 0) {
                return f0;
            }
            else if (n == 1 ) {
                return f1;
            }
            else {
                return (fRec(n - 1) + (fRec(n-2)));
            }
	}
        
        /**
         * The main sequence. Asks for the first and second number to be used,
         * the number of iterations to be performed, and prints out 
         * the Fibonacci sequence.
         * @param args 
         */
	public static void main(String[] args) 
	{
		// get numbers F(0) and F(1) from args[0] and args[1].
		// use either the Scanner class or Integer.parseInt(args[...])
		// you must handle possible exceptions !
            Scanner sc = new Scanner(System.in); 
            try {
                System.out.println("Enter first number: ");
		int f0 = sc.nextInt();
                System.out.println("Enter second number: ");
                int f1 = sc.nextInt();

		// get n from args[2]:
		System.out.println("Enter number of iterations: ");
                int n = sc.nextInt();

		// create a Fib object with params F(0) and F(1)
		Fib fib = new Fib(f0, f1);


		// calculate F(0), ..., F(n) and display them with System.out.println(...) using
		// the iterative methode f(i)
                System.out.println("This is the iterative algorithm");
		for (int i=0; i<n; i++){
                    System.out.println("F(" + i + ") = " + fib.f(i));
                }


		// calculate F(0), ..., F(n) and display them with System.out.println(...) using
		// the recursive methode fRec(i)
                System.out.println("This is the recursive algorithm");
		for (int i=0; i<n; i++){
                    System.out.println("F(" + i + ") = " + fib.fRec(i));
                }
                sc.close();
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Usage: java Q1 <f0> <f1> <n>");
            }
	}

	// instance variables store F(0) and F(1):
        public int f0, f1;
};
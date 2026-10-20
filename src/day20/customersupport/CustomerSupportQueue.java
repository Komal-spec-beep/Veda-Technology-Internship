package day20.customersupport;

import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.Queue;
import java .util.Scanner;

public class CustomerSupportQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<String> tickets = new ArrayDeque<>();
		HashMap<String, String> ticketStatus = new HashMap<>();
		
		System.out.println("========= Customer Support Queue ==========");
		System.out.println("Support queue created successfully!");
		System.out.print("How many tickets do you want to add? ");
		int count = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= count; i++) {
		    System.out.print("Enter ticket " + i + ": ");
		    String ticket = sc.nextLine();

		    tickets.offer(ticket);
		    ticketStatus.put(ticket, "Pending");
		}

		System.out.println("All tickets added successfully!");
		System.out.println("Current Queue: " + tickets);
		
		while (!tickets.isEmpty()) {
		    String nextTicket = tickets.poll();

		    System.out.println("Processing Ticket: " + nextTicket);

		    ticketStatus.put(nextTicket, "Completed");
		    System.out.println("Ticket Status: " + ticketStatus.get(nextTicket));
		}

		System.out.println("No tickets left to process.");
		
		System.out.println("Remaining Queue: " + tickets);
		
		sc.close();
	}
}

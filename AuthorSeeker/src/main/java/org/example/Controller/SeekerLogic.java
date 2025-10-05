package org.example.Controller;

import org.example.Services.ApiService;

import java.util.Scanner;

/**
 * Controller for program's workflow
 */

public class SeekerLogic {
    public static void main(String[] args) {

        ApiService client = new ApiService();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter search query: ");
        String queryText = sc.nextLine();

        String rawJson = client.requestApi(queryText);

        if (rawJson != null){
            System.out.println("Data received.");
        } else {
            System.out.println("Failed to receive data from API.");
        }

        sc.close();

    }
}
package org.example.Controller;

import org.example.Model.ApiClient;

import java.util.Scanner;

public class SeekerLogic {
    public static void main(String[] args) {

        ApiClient client = new ApiClient();

        System.out.println("Enter search query: ");

        Scanner sc = new Scanner(System.in);
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
package org.example;

import org.example.Model.ApiClient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApiClient client = new ApiClient();

        System.out.println("Enter search query: ");

        Scanner sc = new Scanner(System.in);
        String userQuery = sc.nextLine();

        client.displayUrl(userQuery);

        sc.close();

    }
}
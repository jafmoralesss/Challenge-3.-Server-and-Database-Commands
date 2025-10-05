package org.example;

import org.example.Controller.SeekerLogic;

public class Main {

    public static void main(String[] args) {
        // 1. Create an instance of the main controller.
        SeekerLogic seeker = new SeekerLogic();

        // 2. Call the run() method to start the application workflow.
        seeker.run();
    }
}


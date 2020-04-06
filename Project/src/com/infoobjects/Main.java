package com.infoobjects;

import com.infoobjects.dto.BaseDto;
import com.infoobjects.dto.HotelDto;
import com.infoobjects.services.HotelService;
import com.infoobjects.services.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Service<Integer, BaseDto> hotelService = new HotelService();
    public static void main(String[] args) {
        System.out.println("Welcome ");
        System.out.println("Starting project ...");
        printActions();
        boolean quit=false;
        while (!quit){
            System.out.println("Enter action(6 to show list of available actions) : ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Closing project ...");
                    quit=true;
                    break;
                case  1:
                    hotelService.create(HotelService.inputId(),HotelService.populateFields());
                    break;
                case 2:
                    hotelService.delete(HotelService.inputId());
                    break;
                case 3:
                    hotelService.update(HotelService.inputId(),HotelService.populateFields());
                    break;
                case 4:
                    System.out.print(hotelService.read(HotelService.inputId()));
                    break;
                case 5:
                    System.out.println(hotelService.readAll());
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Invalid Input");
                    System.out.println("Try again");
                    break;
            }
        }
//        HashMap<Integer, HotelDto> hashMap = new HashMap<>();
//        hashMap.put(1,new HotelDto("1","a","12","12","true"));
//        hashMap.put(2,new HotelDto("2","a","12","12","true"));
//        Set<Map.Entry<Integer,HotelDto>> set = hashMap.entrySet();
//        System.out.println(set);
    }
    private static void printActions(){
        System.out.println("\nAvailable Actions:\n Press");
        System.out.println("0 - to exit\n"+
                "1 - to add hotel\n"+
                "2 - to remove hotel\n"+
                "3 - to update hotel\n"+
                "4 - to query hotel(id basis)\n"+
                "5 - to query all hotels\n"+
                "6 - to print a list of available actions\n"
        );
        System.out.println("Choose your action : ");
    }
}

package com.infoobjects.services;

import com.infoobjects.dao.HotelDao;
import com.infoobjects.dto.BaseDto;
import com.infoobjects.dto.HotelDto;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HotelService implements Service<Integer,BaseDto> {

    private static Scanner scanner = new Scanner(System.in);
    private static HotelDao<Integer,BaseDto> hotelDao = new HotelDao<>();

    @Override
    public BaseDto read(Integer id) {
        return hotelDao.read(id);
    }

    @Override
    public Map<Integer, BaseDto> readAll() {
        return hotelDao.readAll();
    }

    @Override
    public void create(Integer id, BaseDto hotelDTO) {
        hotelDao.create(id,hotelDTO);
    }

    @Override
    public void update(Integer id, BaseDto hotelDTO) {
        hotelDao.update(id, hotelDTO);
    }

    @Override
    public void delete(Integer id) {
        if(hotelDao.delete(id)){
            System.out.println("Hotel associated with id " + id + " is successfully deleted");
        }
    }

    public static HotelDto populateFields() {
        try {
            System.out.println("Enter code : ");
            String code = scanner.nextLine();
            matchPattern("\\d*",code);
            System.out.println("Enter name : ");
            String name = scanner.nextLine();
            matchPattern("\\D*",name);
            System.out.println("Enter staff no. : ");
            String staff = scanner.nextLine();
            matchPattern("\\d*",staff);
            System.out.println("Enter rooms : ");
            String rooms =  scanner.nextLine();
            matchPattern("\\d*",rooms);
            System.out.println("Enter availability status : ");
            String available = scanner.nextLine();
            matchPattern("\\D*",available);
            return new HotelDto(code, name, staff, rooms, available);
        }catch (InputMismatchException i){
            System.out.println("Input doesn't match");
            System.out.println("Please enter again");
            return populateFields();
        }
    }

    public static int inputId(){
        System.out.println("Enter id : ");
        int id;
        while (!scanner.hasNextInt()){
            String input = scanner.next();
            System.out.printf("\"%s\" is not a valid number.\n", input);
        }
        id=scanner.nextInt();
        scanner.nextLine();
        return id;
    }
    public static boolean matchPattern(String exp, String input){
        if (Pattern.matches(exp,input)){
            return true;
        }else {
            throw new InputMismatchException("Input doesn't match");
        }
    }
}

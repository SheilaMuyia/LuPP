package com.example.lupp;

public class Constants {

    public class ServiceType {
        public static final String BASE_URL = "http://192.168.43.247/lupp/";//folder not db table
        public static final String LOGIN = BASE_URL + "simplelogin.php";
        public static final String ADMINLOGIN = BASE_URL + "adminlogin.php";
        public static final String REGISTER =  BASE_URL + "simpleregister.php";


    }
    // webservice key constants
    public class Params {

        public static final String NAME = "name";
        public static final String HOBBY = "hobby";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
    }
}

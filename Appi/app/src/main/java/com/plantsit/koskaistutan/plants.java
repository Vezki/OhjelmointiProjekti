package com.plantsit.koskaistutan;

public class plants {

    private static String kasvi;
    // private final String aikaisintaan;

    public plants(String name) {
        this.kasvi = name;
        // this.aikaisintaan = date;
    }

    public static String getName() {
        return kasvi;
    }

    //public String getDate() {
    //return aikaisintaan;
    //}

}
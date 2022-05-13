package com.plantsit.koskaistutan;

public class plants {

    private static String kasvi;

    public plants(String kasvi) {
    }
    // private final String aikaisintaan;

    public void kasvit(String kasvi) {
        this.kasvi = kasvi;
        // this.aikaisintaan = date;
    }

    public static String getName() {
        return kasvi;
    }

    //public String getDate() {
    //return aikaisintaan;
    //}

}
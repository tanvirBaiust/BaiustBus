package com.example.tanvir.baiustbus;

/**
 * Created by Tanvir on 6/11/2018.
 */

public class DataProvider {
    private String time;
    private String from;
    private String via;
    private String to;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }



    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    public String getVia() {
        return via;
    }

    public void setVia(String via){
        this.via=via;
    }

    public DataProvider(String time, String from , String via,String to){
        this.time=time;
        this.from=from;
        this.via=via;
        this.to=to;


    }
}

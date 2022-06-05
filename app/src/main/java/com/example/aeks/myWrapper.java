package com.example.aeks;

public class myWrapper {
    private String mywordle;

    public myWrapper() {
        this.mywordle ="";
    }

    public void setMywordle(String x){
        this.mywordle = x.substring(2,7).toUpperCase();
    }

    public String getMywordle(){
        return this.mywordle;
    }
}

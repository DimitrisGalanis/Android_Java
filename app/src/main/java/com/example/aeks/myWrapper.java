package com.example.aeks;

public class myWrapper {
    String mywordle;

    public myWrapper() {
        this.mywordle ="KAPPA";
    }

    public void setMywordle(String x){
        this.mywordle = x.substring(2,7).toUpperCase();
    }

    public String getMywordle(){
        return this.mywordle;
    }
}

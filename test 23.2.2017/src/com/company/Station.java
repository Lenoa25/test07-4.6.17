package com.company;

public class Station{

    int charge;
    int distanceToNext;

    public Station(int charge, int distanceToNext) {
        this.charge = charge;
        this.distanceToNext = distanceToNext;
    }

    public static int findStartingStation(Station[] stations){
        boolean validPath;
        for (int i = 0; i < stations.length; i++) {
            int sum = 0;
            int j=i;
            validPath = true;
            do {
                sum += stations[j].charge;
                sum -= stations[j].distanceToNext;
                if(sum<0){
                    validPath = false;
                    break;
                }
                j++;
                if(j==stations.length)
                    j=0;
            }while(j != i);
            if(validPath)
                return i;
        }
        return -1;
    }

    public static int findStartingStation2(Station[] stations) {

        int sum=0,position=0;
        for (int i = 0; i <stations.length ; i++) {
            sum += stations[i].charge;
            sum -= stations[i].distanceToNext;
            if(sum<0){
                position=i+1;
                sum=0;
            }
        }
        return position;
    }
}

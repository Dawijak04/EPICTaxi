package org.example;

public class VehicleChoice {

    public static void displaySelectedType(Type type, LinkedGrid linkedGrid, DataList<Taxi> taxiList){

        linkedGrid.setShowSelectedTypeOnly(true);
        linkedGrid.display();
        DataList<Taxi> selectedTaxis = getTaxisByType(taxiList, type );
        printDriverNames(selectedTaxis);


    }
    private static DataList<Taxi> getTaxisByType(DataList<Taxi> taxilist, Type type){
        DataList<Taxi> availableTaxis = new DataList<>();
        for(int i = 0; i < taxilist.size(); i++){
            Taxi taxi = taxilist.get(i);
            if(taxi.getType() == type){
                availableTaxis.add(taxi);
            }
        }
        return availableTaxis;

    }

    private static void printDriverNames(DataList<Taxi> taxiList){
        System.out.println("Drivers names of available taxis: ");
        for(int i = 0;i < taxiList.size(); i++){
            Taxi taxi = taxiList.get(i);
            System.out.println("Driver Name: " + taxi.getDriverName() );
        }
    }
}
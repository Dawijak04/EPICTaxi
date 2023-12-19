package org.example;

public class NarrowingRange {

    private static DataList<Taxi> visibleTaxis;

    public static DataList<Taxi> getVisibleTaxis() {
        return visibleTaxis;
    }



    public NarrowingRange(){
        visibleTaxis = new DataList<>();
    }

    public static void narrowRange(DataList<Taxi> allTaxis, Person person, int distance){
        visibleTaxis = new DataList<>();
        for(int i = 0; i < allTaxis.size(); i++){
            Taxi taxi = allTaxis.get(i);
            if(InNarrowRange(person, taxi , 5) <= distance){
                visibleTaxis.add(taxi);
            }
        }

    }



    private static double InNarrowRange(Person person, Taxi taxi, int maxDistance){ // this bascially gives us d = sqrt{(x_2 - x_1)^2 + (y_2-y_1)^2}
        int DistanceX = person.getLocX() - taxi.getPointX();
        int DistanceY = person.getLocY() - taxi.getPointY();

        return Math.sqrt(DistanceX * DistanceX + DistanceY * DistanceY); // math.sqrt is a math method that returns a square root.
    }

}
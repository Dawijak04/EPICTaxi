package org.example;

public class NarrowingRange {

    private static DataList<Taxi> visibleTaxis;

    public static DataList<Taxi> getVisibleTaxis() {
        return visibleTaxis;
    }



    public NarrowingRange(){
        visibleTaxis = new DataList<>();
    }

    public static void narrowRange(DataList<Taxi> visibleTaxis, Person person, int distance){
        // Create a new list to store taxis that meet the distance criteria
        DataList<Taxi>narrowedTaxis = new DataList<>();
        for(int i = 0; i < visibleTaxis.size(); i++){ // Create a new list to store taxis that meet the distance criteria
            Taxi taxi = visibleTaxis.get(i);
            if(InNarrowRange(person, taxi , 5) <= distance){
                narrowedTaxis.add(taxi);// Add the taxi to the narrowedTaxis list
            }
        }
        for (int i = 0; i < narrowedTaxis.size(); i++) {
            visibleTaxis.add(narrowedTaxis.get(i));
        }

    }



    public static double InNarrowRange(Person person, Taxi taxi, int maxDistance){ // this bascially gives us d = sqrt{(x_2 - x_1)^2 + (y_2-y_1)^2}
        int DistanceX = person.getLocX() - taxi.getPointX();
        int DistanceY = person.getLocY() - taxi.getPointY();

        return Math.sqrt(DistanceX * DistanceX + DistanceY * DistanceY); // math.sqrt is a math method that returns a square root.
    }

}
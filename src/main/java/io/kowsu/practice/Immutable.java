package io.kowsu.practice;

public class Immutable {
    public static void main(String[] args) {
        final String s = "abc";
        System.out.println(s);

        Weather weather = new Weather("SKP", "32.1C");
        System.out.printf("Weather details:-> place %s, temperature %s \n", weather.place(), weather.temperature());

        weather = new Weather("YTK", "33.1C");
        System.out.printf("Weather details:-> place %s, temperature %s \n", weather.place(), weather.temperature());

        Location location = new Location("111", "HYD");
        System.out.printf("Location details:-> id %s, location %s \n", location.id(), location.place());

    }
}


record Weather(String place, String temperature) {
}

record Location(String id, String place) {
}

record Person(String id, String name, Address address) {
    record Address(String lane1, String lane2, String city, String district) {
    }
}


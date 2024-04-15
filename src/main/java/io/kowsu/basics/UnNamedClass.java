/*
    @created April/15/2024 - 1:46 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

void main() throws Exception {
    System.out.println("Hello world");
//    hello();
    learn();
}

void hello() {
    System.out.println("saying hello.....");

    Optional<Integer> max = Arrays.asList("1", "2", "3").stream().map(Integer::parseInt).max(Comparator.comparingInt(a -> a));
    System.out.println(max.get());
}

void learn() throws Exception {
    List<Trip> tripsList = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
        TripDetails tripDetails = new TripDetails(i, "trip#" + i);
        TripDetails modifiedTripDetails = new TripDetails(i, "trip#" + i);
        TripDetails modifiedTripDetails1 = new TripDetails(i + 1, "trip#" + (i + 1));
        Trip trip = new Trip(List.of(tripDetails), List.of(modifiedTripDetails, modifiedTripDetails1));
        tripsList.add(trip);
    }
    Trips trips = new Trips(tripsList);
    String jsonResponse = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(trips);
    System.out.println(jsonResponse);

    trips.trips().stream().flatMap(t -> t.modified().stream()).collect(Collectors.maxBy(Comparator.comparingInt(a -> a.tripNumber())));

}


record Trips(List<Trip> trips) {
}

record Trip(List<TripDetails> original, List<TripDetails> modified) {
}

record TripDetails(int tripNumber, String tripName) {
}
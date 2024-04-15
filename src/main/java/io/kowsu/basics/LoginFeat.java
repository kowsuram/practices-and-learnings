package io.kowsu.basics;

/*
    @created April/15/2024 - 11:24 AM
    @project spring-boot-web
    @author k.ramanjineyulu
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

//@FunctionalInterface
//public interface ILoginFeat {
//
//    boolean login(String username, char[] password);
//
//    default String gen(String name) {
//        return "";
//    }
//
//}
//

class LoginFeat {

    public boolean login(String username, char[] password) {
        return false;
    }

    public String gen(String name) {
        return "";
    }


    public void some_functions() {
        Consumer<String> c = (val) -> System.out.println("val = " + val);
        Predicate<String> p = (val) -> val.equals("abc");
        Function<String, Boolean> f = (val) -> val.length() > 0;
        BiFunction<String, Integer, Boolean> b = (val1, val2) -> val1.length() == val2;
        Supplier<String> s = () -> "Hello world";
        UnaryOperator<String> u = (val) -> val.toUpperCase();

        Rank r1 = new Rank(3);
        Rank r2 = new Rank(2);
        Rank r3 = new Rank(4);
        List<Rank> ranks = Arrays.asList(r1, r2, r3);
        Optional<Rank> reduce = ranks.stream().reduce(BinaryOperator.maxBy(Comparator.comparingInt(a -> a.id())));
        if (reduce.isPresent())
            System.out.println("reduce = " + reduce.isPresent() + " " + reduce.get());

    }

    public static void main(String[] args) {
        LoginFeat feat = new LoginFeat();
        feat.some_functions();
    }

}


record Rank(int id) {
}
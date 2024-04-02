package io.kowsu.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/*
    @created March/29/2024 - 3:08 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(() -> {
            System.out.println("going for shopping...");
        }).thenAccept(a -> {
            System.out.println("making food " + a);
        });

        System.out.println("Executing all tasks..");
        CompletableFuture<Void> shoppingTask = CompletableFuture
                .supplyAsync(() -> "going for shopping...").thenAccept(System.out::println);

        CompletableFuture<Void> cookingTask = CompletableFuture
                .supplyAsync(() -> "going for cooking...").thenAccept(System.out::println);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(shoppingTask, cookingTask);

        voidCompletableFuture.get();

        System.out.println("Executing any one of the tasks..");
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.anyOf(shoppingTask, cookingTask);
        objectCompletableFuture.get();


        CompletableFuture.supplyAsync(isUserValid)
                .thenApply(r -> r ? isUserHasCreditScore.get() : false)
                .thenApply(r -> r ? isUserHasAnyRemarks.get() : false)
                .exceptionally((ex) -> {
                    System.out.println(ex.getMessage());
                    return false;
                }).get();

        CompletableFuture.supplyAsync(isUserValid)
                .thenApply(r -> r ? isUserHasCreditScore.get() : false)
                .thenApply(r -> r ? isUserHasAnyRemarks.get() : false)
                .handle((r, ex) -> {
                    System.out.println(r + " " + ex.getMessage());
                    return false;
                }).get();
    }


    static Supplier<Boolean> isUserValid = () -> {
        System.out.println("User is valid");
        return true;
    };

    static Supplier<Boolean> isUserHasCreditScore = () -> {
        System.out.println("User is having valid credit score");
        return true;
    };

    static Supplier<Boolean> isUserHasAnyRemarks = () -> {
        throw new RuntimeException("User has illegal money activity...");
    };

}

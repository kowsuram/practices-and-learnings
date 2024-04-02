package io.kowsu.future;

import org.aspectj.weaver.ast.Call;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
    @created March/29/2024 - 2:59 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class FutureExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> shoppingTask = executorService.submit(new ShoppingTask());
        Future<String> cookingTask = executorService.submit(new CookingTask());

        String shopping = shoppingTask.get();
        String s = cookingTask.get() + shopping;
        System.out.println(s);
    }
}


class ShoppingTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        return "Doing shopping..";
    }
}


class CookingTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return "Doing cooking..";
    }
}

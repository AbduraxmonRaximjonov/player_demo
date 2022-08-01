package uz.geeks.player_app.configs;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorConfig {

    private static final ExecutorService executorService =
            Executors.newFixedThreadPool(10);


    public static void run() {
        executorService.submit(() -> System.out.println("::::::::::TREAD POOL STARTED::::::::::"));
//        CompletableFuture.supplyAsync(
//                ()-> {
//
//                }, executorService
//        )
    };

    public static void submit(Runnable runnable) {
        executorService.submit(runnable);
    }

}

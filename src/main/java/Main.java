import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Запускаю потоки");
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(new MyCallable(5000));
        callables.add(new MyCallable(1000));
        callables.add(new MyCallable(2500));
        callables.add(new MyCallable(3000));

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> resultsOfTask = new ArrayList<>();

        try {
            resultsOfTask = threadPool.invokeAll(callables);
            for (int i = 0; i < resultsOfTask.size(); i++) {
                System.out.printf("result task %s: %s\n", i + 1, resultsOfTask.get(i).get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();

        }
    }

}

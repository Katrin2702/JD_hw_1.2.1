import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {

    int time;

    public MyCallable(int time) {
        this.time = time;
    }

    @Override
    public Integer call() {
        Integer count = 0;
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(time);
                System.out.printf("Поток %s: Всем привет!\n", Thread.currentThread().getName());
                count++;
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("Поток %s завершен\n", Thread.currentThread().getName());
            return count;
        }
    }
}

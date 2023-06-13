
class PrintWithThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class LambdaExpressionDemo2 {

    public static void main(String[] args) {
//        PrintWithThread p1 = new PrintWithThread();
//        PrintWithThread p2 = new PrintWithThread();
//        Thread t1 = new Thread(p1);
//        Thread t2 = new Thread(p2);
//        t1.start();
//        t2.start();

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(i);
//                }
//            }
//        });
//        t1.start();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });

        t1.start();
    }
}

public class Main {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Group"); // главная группа потоков

        for(int i = 1; i < 5; i++) {
            new Thread(threadGroup,new MyThread(threadGroup,"Я поток " + i)).start();
        }
        try {
            //усыпляем поток на 15 секунд
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Завершаю все потоки");
        threadGroup.interrupt();//остановка потока
    }
}

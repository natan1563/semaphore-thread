import colors.BaseCollor;
import colors.Green;
import colors.Red;
import colors.Yellow;
import java.util.Scanner;

public class Semaforo extends Thread{
    public static void main(String[] args) throws InterruptedException {
        BaseCollor yellow = new Yellow();
        yellow.setColor("Amarela");

        BaseCollor green = new Green();
        green.setColor("Verde");

        BaseCollor red = new Red();
        red.setColor("Vermelho");

        Runnable runSemaphore = new Runnable() {
            Thread threadOfColors = new Thread(new Semaforo());

            @Override
            public void run() {
                synchronized (threadOfColors) {
                    int finished = 1;
                    do {
                        green.showCollor();
                        try {
                            threadOfColors.wait(12000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        yellow.showCollor();
                        try {
                            threadOfColors.wait(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        red.showCollor();
                        try {
                            threadOfColors.wait(6000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        System.out.println("Se desejar continuar a simulação: 1 - Sim | 2 - Não");
                        Scanner input = new Scanner(System.in);
                        finished = input.nextInt();
                    } while (finished == 1);
                }
            }
        };

        Thread runnableThread = new Thread(runSemaphore);
        runnableThread.start();
    }
}

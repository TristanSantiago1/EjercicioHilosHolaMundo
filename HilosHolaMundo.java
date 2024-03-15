import java.util.Scanner;

public class HilosHolaMundo extends Thread {
    private String mensaje;
    private volatile boolean running = true;

    public HilosHolaMundo(String m) {
        mensaje = m;
    }

    @Override
    public void run() {
        while (running) {
            System.out.print(mensaje + " ");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopRunning() {
        running = false;
    }

    public static void main(String[] args) {
        HilosHolaMundo hiloHola = new HilosHolaMundo("Hola");
        HilosHolaMundo hiloMundo = new HilosHolaMundo("Mundo");

        hiloHola.start();
        hiloMundo.start();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona Enter para detener los hilos.");
        scanner.nextLine();

        hiloHola.stopRunning();
        hiloMundo.stopRunning();
    }
}

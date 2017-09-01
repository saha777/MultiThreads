package thread.phaser;

import java.util.concurrent.Phaser;

public class PhaserRunner {
    //int register(): регистрирует сторону, которая выполняет фазы,
    // и возвращает номер текущей фазы - обычно фаза 0

    //int arrive(): сообщает, что сторона завершила фазу и возвращает номер текущей фазы

    //int arriveAndAwaitAdvance(): аналогичен методу arrive,
    //только при этом заставляет phaser ожидать завершения фазы всеми остальными сторонами

    //int arriveAndDeregister(): сообщает о завершении всех фаз стороной и снимает ее с регистрации.
    //Возвращает номер текущей фазы или отрицательное число, если синхронизатор Phaser завершил свою работу

    //int getPhase(): возвращает номер текущей фазы

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}

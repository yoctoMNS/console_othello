import java.util.Scanner;
import java.awt.Point;


public class GameManager {
    private Stage stage;
    private ConsoleController cc;
    private Scanner sc;
    private int turn;
    private Point cursor;


    public GameManager() {
        init();
    }


    private void init() {
        buildInstance();

        turn = Stage.CELL_BLACK;
    }


    private void buildInstance() {
        stage = new Stage();
        cc = new ConsoleController("/bin/bash", "-c", "clear");
        sc = new Scanner(System.in);
        cursor = new Point();
    }


    private void input() {
        cursor.x = sc.nextInt();
        cursor.y = sc.nextInt();
    }


    private void update() {
        if (stage.canPut(cursor, turn)) {
            stage.setStageCell(cursor.x, cursor.y, turn);
        }
    }


    private void draw() {
        cc.run();

        for (int y=0; y<Stage.STAGE_SIZE; ++y) {
            for (int x=0; x<Stage.STAGE_SIZE; ++x) {
                switch (stage.getStageCell(x, y)) {
                case Stage.CELL_NONE:
                    System.out.print(" + ");
                    break;

                case Stage.CELL_BLACK:
                    System.out.print(" B ");
                    break;

                case Stage.CELL_WHITE:
                    System.out.print(" W ");
                    break;

                default:
                    System.out.print(" E ");
                }
            }
            System.out.println();
        }
    }


    private void loop() {
        while (true) {
            draw();
            input();
            update();
        }
    }


    public void run() {
        loop();
    }
}

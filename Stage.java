import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Stage {
    public static final int STAGE_SIZE  = 8;

    public static final int CELL_NONE   = 0;
    public static final int CELL_BLACK  = 1;
    public static final int CELL_WHITE  = 2;

    private int[][] data;
    private List<Point> enemyPos;
    private List<Point> flipDir;
    private List<Point> flipEndPos;


    public Stage() {
        init();
    }


    private void init() {
        makeData();
        buildInstance();
    }


    private void buildInstance() {
        enemyPos = new ArrayList<>();
        flipEndPos = new ArrayList<>();
        flipDir = new ArrayList<>();
    }


    private void makeData() {
        data = new int[STAGE_SIZE][STAGE_SIZE];
        
        for (int y=0; y<STAGE_SIZE; ++y)
        for (int x=0; x<STAGE_SIZE; ++x) {
            data[y][x] = CELL_NONE;
        }

        data[3][3] = CELL_BLACK;
        data[3][4] = CELL_WHITE;
        data[4][3] = CELL_WHITE;
        data[4][4] = CELL_BLACK;
    }


    public boolean canPut(Point cursor, int turn) {
        if (checkAroundCell(cursor, turn)) {
            return true;
        }

        return false;
    }


    private boolean checkAroundCell(Point cursor, int turn) {
        boolean isEnemy = false;
        enemyPos.clear();

        for (int i=-1; i<=1; ++i)
        for (int j=-1; j<=1; ++j) {
            if (isCellEnemy(cursor.x+j, cursor.y+i, turn)) {
                enemyPos.add(new Point(cursor.x+j, cursor.y+i));
                flipDir.add(new Point(i, j));
                isEnemy = true;
            }
        }

        return isEnemy;
    }

    
    private boolean checkLineCell(int turn) {
        boolean isMy = false;

        int idx = 0;
        for (Point p : enemyPos) {
            int vecX = flipDir.get(idx).x;
            int vecY = flipDir.get(idx).y;

            while (true ) {
            }
        }

        return isMy;
    }


    public boolean isCellNone(int x, int y) {
        return data[y][x] == CELL_NONE;
    }


    public boolean isCellEnemy(int x, int y, int turn) {
        return data[y][x] == (turn==CELL_BLACK ? CELL_WHITE : CELL_BLACK);
    }


    public int getStageCell(int x, int y) {
        return data[y][x];
    }


    public void setStageCell(int x, int y, int v) {
        data[y][x] = v;
    }
}

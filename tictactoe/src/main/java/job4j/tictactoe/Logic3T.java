package job4j.tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerXandO(Predicate<Figure3T> hasMark) {
        return this.fillBy(hasMark, 0, 0, 1, 0) ||
        this.fillBy(hasMark, 0, 0, 0, 1) ||
        this.fillBy(hasMark, 0,0, 1, 1) ||
        this.fillBy(hasMark, this.table.length - 1 , 0, -1, 1);

    }

    public boolean isWinnerX() {
        return isWinnerXandO(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {

        return isWinnerXandO(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(table).flatMap().anyMatch();
    }
}

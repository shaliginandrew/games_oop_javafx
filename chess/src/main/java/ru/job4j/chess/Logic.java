package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }


    boolean isWayFree(Cell[] steps) {
        boolean result = true;
        for (Cell step : steps) {
            for (int j = 0; j < index; j++) {
                if (figures[j] != null && step.equals(figures[j].position())) {
                    result = false;
                    break;
                }
            }
            if (!result) { break; }
        }
        return result;
    }

    public boolean move(Cell source, Cell dest) {
        boolean result = false;
        try {
            int index = this.findBy(source);
            if (index != -1) {
                Cell[] steps = this.figures[index].way(source, dest);
                if (isWayFree(steps) && steps.length > 0) {
                    result = true;
                    this.figures[index] = this.figures[index].copy(dest);
                }
            }
        } catch (IllegalStateException my) {
            }
        return result;
        }

        public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}

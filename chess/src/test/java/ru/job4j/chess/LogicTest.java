package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = logic.move(Cell.C1, Cell.H6);
        assertThat(rsl, is(true));
    }
    @Test
    public void moveThroughPawn() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C8));
        logic.add(new PawnBlack(Cell.B7));
        assertThat(logic.move(Cell.C8, Cell.A6), is(true));
    }
}
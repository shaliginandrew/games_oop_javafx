package ru.job4j.chess.firuges.black;


import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void whenPosition() {
        assertThat( new BishopBlack(Cell.F8).position(), is(Cell.F8));
    }
    @Test
    public void whenCopy() {
        assertThat( new BishopBlack(Cell.F8).copy(Cell.F7).position(), is(Cell.F7));
    }
    public void whenWay() {
        assertThat( new BishopBlack(Cell.C1).way(Cell.C1,Cell.G5), is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }
}

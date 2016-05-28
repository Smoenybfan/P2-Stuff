package sokoban.test.game;

import org.junit.Test;
import sokoban.game.Point;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestPoint {

    @Test
    public void testConstructor() {
        Point p = new Point(1, 2);
        assertEquals(1, p.getX());
        assertEquals(2, p.getY());
    }

    @Test
    public void testEquals() {
        Point p1, p2, p3;
        p1 = new Point(1, 2);
        p2 = new Point(1, 2);
        p3 = new Point(1, 3);

        assertEquals(p1, p2);
        assertEquals(p2, p1);
        assertNotEquals(p1, p3);
        assertNotEquals(p3, p1);

        p3 = new Point(2, 2);
        assertNotEquals(p1, p3);
        assertNotEquals(p3, p1);

        p3 = new Point(2, 3);
        assertNotEquals(p1, p3);
        assertNotEquals(p3, p1);
    }

    @Test
    public void testToString() {
        Point p = new Point(1, 2);
        assertEquals("Point(1, 2)", p.toString());
    }
}

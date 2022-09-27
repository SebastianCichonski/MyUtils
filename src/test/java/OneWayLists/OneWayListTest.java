package OneWayLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

public class OneWayListTest {
    private static OneWayList<Integer> listUnderTest;

    @BeforeEach
    public void init(){
        listUnderTest = new OneWayList<>(0,1,2,3);
    }

    @AfterEach
    void tearDown(){
        listUnderTest.reset();
    }

    @org.junit.jupiter.api.Test
    public void testAddLast(){
        listUnderTest.addLast(11);
        assertEquals(11, listUnderTest.getLast());
    }

    @org.junit.jupiter.api.Test
    public void testAddLast_x3(){
        listUnderTest.addLast(11).addLast(12).addLast(13);
        assertEquals(13, listUnderTest.getLast());
        assertEquals(7,listUnderTest.getLength());
    }

    @ParameterizedTest
    @ValueSource(ints = {10,11,12,13, Integer.MAX_VALUE})
    public void testAddLastParams(int number){
        listUnderTest.addLast(number);
        assertEquals(number,listUnderTest.getLast());
    }


    @org.junit.jupiter.api.Test
    public void testAddLast_Null(){
        assertThrows(IllegalArgumentException.class,() ->{
            listUnderTest.addLast(null);
        });
    }

    @org.junit.jupiter.api.Test
    public void testAddFirst(){
        listUnderTest.addFirst(-1);
        assertEquals(-1, listUnderTest.getFirst());
    }

    @org.junit.jupiter.api.Test
    public void testAddFirst_x3(){
        listUnderTest.addFirst(11).addFirst(12).addFirst(13);
        assertEquals(13, listUnderTest.getFirst());
        assertEquals(7,listUnderTest.getLength());
    }

    @org.junit.jupiter.api.Test
    public void testAddFirst_null(){
        assertThrows(IllegalArgumentException.class, () -> {
            listUnderTest.addFirst(null);
        });
    }

    @org.junit.jupiter.api.Test
    public void testGetLenght(){
        assertEquals(4, listUnderTest.getLength());
    }

    @org.junit.jupiter.api.Test
    public void testIsEmpty(){
        listUnderTest.reset();
        assertTrue(listUnderTest.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testDelFirst(){
        listUnderTest.delFirst();
        assertEquals(1, listUnderTest.getFirst());
    }

    @org.junit.jupiter.api.Test
    public void testDelFirst_Null(){
        listUnderTest.delFirst().delFirst().delFirst().delFirst().delFirst().delFirst();
        assertTrue(listUnderTest.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testDelLast(){
        listUnderTest.delLast();
        assertEquals(2, listUnderTest.getLast());
    }

    @org.junit.jupiter.api.Test
    public void testDelLast_Null(){
        listUnderTest.delLast().delLast().delLast().delLast().delLast().delLast();
        assertTrue(listUnderTest.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testToArray(){
        Object[] actual;
        Object[] expected = {0,1,2,3};
        actual = listUnderTest.toArray();
        assertArrayEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void testFind(int number){
        assertTrue(listUnderTest.find(number));
        assertFalse(listUnderTest.find(6));
    }
    @org.junit.jupiter.api.Test
    public void testFind_Null(){
        assertThrows(IllegalArgumentException.class, () -> {
            listUnderTest.find(null);
        });
    }

}
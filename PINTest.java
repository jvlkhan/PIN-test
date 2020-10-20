import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PINTest {
    PIN p;
    Object o;

    @BeforeEach
    void setUp() throws Exception {
        p = new PIN(000);
    }

    @Test
    void checkTest1() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        /*
         * if (access || (tryCounter > 0 && pin == securePin))
         *
         * access = false
         *
         * securePin = false
         * tryCounter = true
         *
         * result = false
         */
        p.checkPin(001);
        Field[] f = p.getClass().getDeclaredFields();
        for(java.lang.reflect.Field fd : f) {
            fd.setAccessible(true);
            if(fd.getName().equals("access")) {
                o = fd.get(p);
            }
        }

        boolean test1 = (boolean) o;
        assertFalse(test1);
    }

    @Test
    void checkTest2() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        /*
         * if (access || (tryCounter > 0 && pin == securePin))
         *
         * access = false
         *
         * securePin = true
         * tryCounter = false
         *
         * result = false
         */
        p.checkPin(002);
        p.checkPin(003);
        p.checkPin(004);
        p.checkPin(005);
        p.checkPin(006);
        p.checkPin(000);
        Field[] f = p.getClass().getDeclaredFields();
        for(java.lang.reflect.Field fd : f) {
            fd.setAccessible(true);
            if(fd.getName().equals("access")) {
                o = fd.get(p);
            }
        }

        boolean test1 = (boolean) o;
        assertFalse(test1);
    }

    @Test
    void checkTest3() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        /*
         * if (access || (tryCounter > 0 && pin == securePin))
         *
         * access = true
         *
         * securePin = false
         * tryCounter = true
         *
         * result = true
         */
        p.checkPin(000);
        p.checkPin(300);
        Field[] f = p.getClass().getDeclaredFields();
        for(java.lang.reflect.Field fd : f) {
            fd.setAccessible(true);
            if(fd.getName().equals("access")) {
                o = fd.get(p);
            }
        }

        boolean test1 = (boolean) o;
        assertTrue(test1);
    }

    @Test
    void checkTest4() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        /*
         * if (access || (tryCounter > 0 && pin == securePin))
         *
         * access = false
         *
         * securePin = true
         * tryCounter = true
         *
         * result = true
         */
        p.checkPin(000);
        Field[] f = p.getClass().getDeclaredFields();
        for(java.lang.reflect.Field fd : f) {
            fd.setAccessible(true);
            if(fd.getName().equals("access")) {
                o = fd.get(p);
            }
        }

        boolean test1 = (boolean) o;
        assertTrue(test1);
    }
}
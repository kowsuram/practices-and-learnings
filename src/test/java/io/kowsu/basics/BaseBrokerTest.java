package io.kowsu.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBrokerTest {

    @Test
    void constructorTest() {
        BaseBroker baseBroker = new ZerodhaBroker();
        String display = baseBroker.display();
        assertEquals("Broker Name Zerodha, and its margin fee 0.48; finally it's code ZRD \n", display);
    }

    @Test
    void accessingSpecificBehavior() {
        BaseBroker zerodhaBroker = new ZerodhaBroker();
        assertEquals(zerodhaBroker.getMarginFee(), 0.48);
        assertEquals(zerodhaBroker.getName(), "Zerodha");
        assertEquals(zerodhaBroker.getBrokerCode(), "ZRD");
        String zerodhaDisplay = zerodhaBroker.display();
        assertEquals("Broker Name Zerodha, and its margin fee 0.48; finally it's code ZRD \n", zerodhaDisplay);

        BaseBroker growwBroker = new GrowwBroker();
        assertEquals(growwBroker.getMarginFee(), 0.20);
        assertEquals(growwBroker.getName(), "Groww");
        assertEquals(growwBroker.getBrokerCode(), "GRW");
        String growwDisplay = growwBroker.display();
        assertEquals("Broker Name Groww, and its margin fee 0.2; finally it's code GRW \n", growwDisplay);
    }
}

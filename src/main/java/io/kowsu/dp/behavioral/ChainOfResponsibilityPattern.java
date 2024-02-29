package io.kowsu.dp.behavioral;

//TODO: implement in a better way.
public class ChainOfResponsibilityPattern {

    public static void main(String[] args) {

        PlaceOrderChain placeOrderChain = new PlaceOrderChain();
        OrderVerificationChain orderVerificationChain = new OrderVerificationChain();
        InventoryCheckChain inventoryCheckChain = new InventoryCheckChain();
        PaymentProcessingChain paymentProcessingChain = new PaymentProcessingChain();
        ShippingChain shippingChain = new ShippingChain();

        placeOrderChain.next(orderVerificationChain);
        orderVerificationChain.next(inventoryCheckChain);
        inventoryCheckChain.next(paymentProcessingChain);
        paymentProcessingChain.next(shippingChain);

        //calling the first handler/chain process
        placeOrderChain.process();
    }
}

interface OrderChain {
    void next(OrderChain chain);
    void process();
}


/**
 * Chains includes, Place order, Order verification, Inventory check, Payment processing, shipping..
 */

class PlaceOrderChain implements OrderChain {
    private OrderChain chain;

    @Override
    public void next(OrderChain chain) {
        this.chain = chain;
    }

    @Override
    public void process() {
        System.out.println("placing the order");
        chain.process();
    }
}

class OrderVerificationChain implements OrderChain {
    private OrderChain chain;

    @Override
    public void next(OrderChain chain) {
        this.chain = chain;
    }

    @Override
    public void process() {
        System.out.println("processing the order");
        chain.process();
    }
}

class InventoryCheckChain implements OrderChain {
    private OrderChain chain;

    @Override
    public void next(OrderChain chain) {
        this.chain = chain;
    }

    @Override
    public void process() {
        System.out.println("Inventory verified");
        chain.process();
    }
}

class PaymentProcessingChain implements OrderChain {
    private OrderChain chain;
    @Override
    public void next(OrderChain chain) {
        this.chain = chain;
    }

    @Override
    public void process() {
        System.out.println("Payment processed");
        chain.process();
    }
}

class ShippingChain implements OrderChain {
    @Override
    public void next(OrderChain chain) {
        throw new UnsupportedOperationException("this is the terminal chain");
    }

    @Override
    public void process() {
        System.out.println("Shipping is done");
    }
}
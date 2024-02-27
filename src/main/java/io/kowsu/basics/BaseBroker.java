package io.kowsu.basics;

interface IBroker {
    String getName();

    double getMarginFee();
}

public abstract class BaseBroker implements IBroker {
    private String brokerCode;

    public BaseBroker(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    /**
     * Base class wants to make display format standardized; modification not allowed for sub-classes so
     *
     * @return
     */
    final String display() {
        return String.format("Broker Name %s, and its margin fee %s; finally it's code %s \n", getName(), getMarginFee(), brokerCode);
    }

    final String getBrokerCode() {
        return brokerCode;
    }
}

class ZerodhaBroker extends BaseBroker {


    public ZerodhaBroker() {
        super("ZRD");
    }

    @Override
    public String getName() {
        return "Zerodha";
    }

    @Override
    public double getMarginFee() {
        return 0.48d;
    }

}


class GrowwBroker extends BaseBroker {

    public GrowwBroker() {
        super("GRW");
    }

    @Override
    public String getName() {
        return "Groww";
    }

    @Override
    public double getMarginFee() {
        return 0.20d;
    }
}

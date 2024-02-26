package io.kowsu.dp.structural;

/*
    @created February/23/2024 - 4:19 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class MediatorPattern {
    public static void main(String[] args) {
        GrowwService growwService = new GrowwService();
        //client trader knows, he is making use of growservice to place order
        TraderService  traderService = new TraderService(growwService);
        traderService.placeCustomOrder("bse");
    }
}

interface IExchangeService {
    void placeOrder();
}

class BSEExchangeService implements IExchangeService {

    @Override
    public void placeOrder() {
        System.out.println("BSE order placed");
    }
}

class NSEExchangeService implements IExchangeService {
    @Override
    public void placeOrder() {
        System.out.println("BSE order placed");
    }
}

class GrowwService {
    public void placeOrder(String exchange) {
        IExchangeService bse = ExchangeFactory.exchangeService("bse");
        System.out.println("Broker Grow is placing an order with "+ exchange + " on behalf of trader");
        bse.placeOrder();
    }
}

class ExchangeFactory {
    public static IExchangeService exchangeService(String exchange) {
        switch (exchange) {
            case "bse": return  new BSEExchangeService();
            case "nse":  return  new NSEExchangeService();
            default:return null;
        }
    }
}


class TraderService {

    GrowwService growwService;
    public TraderService(GrowwService growwService) {
        this.growwService = growwService;
    }

    public void placeCustomOrder(String exchange) {
        //grow is a mediator in between traders and exchanges (bse and nse)
        System.out.println("Trader is placing an order with " + exchange);
        this.growwService.placeOrder(exchange);
    }

}

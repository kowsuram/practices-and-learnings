package io.kowsu.dp.structural;

/*
    @created February/23/2024 - 2:20 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class FacadePattern {

    public static void main(String[] args) {
        //calling facade client place order
        IOrderFacade orderFacade = new OrderFacadeImpl();
        //client only have to call placeOrder; he need not to worry about internal
        //implementation of calling login, placement, payment
        orderFacade.placeOrder();
    }

}


interface IOrderFacade {
    void placeOrder();
}

class OrderFacadeImpl implements IOrderFacade {
    @Override
    public void placeOrder() {
        LoginService loginService = new LoginService();
        loginService.login();
        PlaceOrderService orderService = new PlaceOrderService();
        orderService.placeOrder();
        PaymentService paymentService = new PaymentService();
        paymentService.payment();
    }
}


class LoginService {
    public void login() {
        System.out.println("login called");
    }
}


class PlaceOrderService {
    public void placeOrder() {
        System.out.println("place order called");
    }
}


class PaymentService {
    public void payment() {
        System.out.println("payment called");
    }
}
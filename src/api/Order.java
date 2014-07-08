package api;

import java.math.BigDecimal;

/**
 * User: masniki Date: 07.07.14 Time: 13:24
 */


public class Order {
    private int participant;
    private int side;
    private BigDecimal price;
    private int qty;
    private int leavesQty;
    private OrderState orderState;
    private int orderID;

    public boolean isPending() {
        return !orderState.equals(OrderState.active);
    }
}

enum OrderState {
    notActive,
    pendingAdd,
    pendingReplace,
    pendingCancel,
    active
}
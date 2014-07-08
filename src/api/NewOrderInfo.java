package api;

import java.math.BigDecimal;

/**
 * User: masniki Date: 07.07.14 Time: 16:10
 */
public class NewOrderInfo {
    private int participant;
    private int side;
    private BigDecimal price;
    private int qty;

    public NewOrderInfo(int participant, int side, BigDecimal price, int qty) {
        this.participant = participant;
        this.side = side;
        this.price = price;
        this.qty = qty;
    }
}

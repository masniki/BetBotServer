package api;

import java.math.BigDecimal;

/**
 * User: masniki Date: 07.07.14 Time: 13:17
 */
public class Level {
    private BigDecimal price;
    private int qty;

    public Level(BigDecimal price, int qty) {
        this.price = price;
        this.qty = qty;
    }
}

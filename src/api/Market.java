package api;

import java.util.List;

/**
 * User: masniki Date: 07.07.14 Time: 13:10
 */
public class Market {

    private MarketInfo marketInfo;
    private List<Level>[][] quotes; // player, side, level number
    private List<Order> orders;
    private Score currentScore;
    private boolean isSubscribed;
    private boolean isUpdatedFlag;

    public Market(MarketInfo marketInfo) {
        this.marketInfo = marketInfo;
    }

    private void onSubscribtionUpdate() {
        //update isSubscribed here
    }

    private void onQuoteUpdate() {
        //update quotes here
        isUpdatedFlag = true;
    }

    private void onScoreUpdate() {
        //update current score here
        isUpdatedFlag = true;
    }

    private void onOrdersUpdate() {
        //update orders here
        isUpdatedFlag = true;
    }

    public boolean getIsUpdatedFlag() {
        boolean ret = isUpdatedFlag;
        isUpdatedFlag = false;
        return ret;
    }

    private boolean isSubscribed() {
        return isSubscribed;
    }

    public List<Order> getOrders() { //add such functions with filters
        return orders;
    }

    public List<Level>[][] getQuotes() { //add such functions with filters
        return quotes;
    }

    public void sendNewOrder(NewOrderInfo newOrderInfo) {
        //send new order
    }

    public void sendChangeOrder(Order order, NewOrderInfo newOrderInfo) {
        //send change order
    }

    public void sendCancelOrder(Order order) {
        //send cancel order
    }

    public boolean cancelAllOrders() {
        boolean done = true;
        for (Order order : orders) {
            done = false;
            if (!order.isPending()) {
                sendCancelOrder(order);
            }
        }
        return done;
    }

    public Score getCurrentScore() {
        return currentScore;
    }
}

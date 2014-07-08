import api.ConnectionDetails;
import api.Market;

/**
 * User: masniki Date: 07.07.14 Time: 13:00
 */
public class BaseFeed {
    private boolean isConnected = false;

    public BaseFeed(ConnectionDetails connectionDetailsExchange) {
    }

    public void connectToExchange() {
        //connect to exchange
    }

    public boolean isConnectedToExchange() {
        return isConnected;
    }

    public void subscribeOnMarket(Market market) {
        //subscribe on market
    }

    public void handleFeedUpdate() {
        //update market
        //handle connection -> isConnected = true
        //handle disconnection -> isConnected = false
        //handle subscribtion report
        //handle data update
    }
}

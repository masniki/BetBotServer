import api.ConnectionDetails;

import static java.lang.Thread.sleep;

/**
 * User: masniki Date: 07.07.14 Time: 18:17
 */
public class StartBot {
    public static void main(String[] args) throws Exception {
        System.out.print("Hello");

        Head head = new Head();
        ConnectionDetails baseFeedToExchange;
        BaseFeed baseFeed = new BaseFeed(baseFeedToExchange);

        while (!baseFeed.isConnectedToExchange()) {
            baseFeed.connectToExchange();
            sleep(1000000);
        }

        //here create infinite loop with sleep(millis) or sleep while have no updates
    }
}

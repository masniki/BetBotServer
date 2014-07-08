import api.Level;
import api.Market;
import api.MarketInfo;
import api.Score;

import java.util.List;

/**
 * User: masniki Date: 07.07.14 Time: 13:00
 */

// Head is main modulus. All other modulus should connect to head.

public class Head {
    private Market market;
    private HeadState state;
    private boolean scoreUpdatedFlag;
    private Score newScore;

    public Head() {
    }

    private void handleUserConnection() {
    }

    public boolean isUserConnected() {
        return false;
    }

    public void handleUserMarketRequest(MarketInfo marketInfo, BaseFeed baseFeed) {
        market = new Market(marketInfo);
        baseFeed.subscribeOnMarket(market);
    }

    public void handleUserScoreUpdate() {
        //Score->newScore;
        scoreUpdatedFlag = true;
    }

    public void handleUserStart() {
        state = HeadState.starting;
        onStart();
    }

    public void handleUserStopsTrading() {
        state = HeadState.stoping;
        onStop();
    }

    private void onStart() {
        //do something
        state = HeadState.on;
    }

    private void onStop() {
        //do something
        state = HeadState.stoping;
        if (market.cancelAllOrders())
            state = HeadState.off;
    }

    public void onUpdate() {
        //handle updates
        if (state == HeadState.stoping) {
            if (market.cancelAllOrders())
                state = HeadState.off;
            return;
        }
        if (market.getIsUpdatedFlag() || scoreUpdatedFlag) {
            manageOrders(scoreUpdatedFlag);
            if (scoreUpdatedFlag)
                scoreUpdatedFlag = false;
        }

    }

    private void manageOrders(boolean scoreUpdated) {
        if (scoreUpdated) {
            double[] newProbabilities = calculateFairPropabilities(market.getCurrentScore(), newScore,
                    market.getQuotes());
            //add opening orders if need

        } else {
            //manage closing orders
        }
    }

    private double[] calculateFairPropabilities(Score currentScore, Score newScore, List<Level>[][] quotes) {
        return new double[]{0.0, 0.0};
    }


}

enum HeadState {
    off,
    starting,
    on,
    stoping
}

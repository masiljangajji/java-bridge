package bridge;


import view.Message;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private String bridgeSize;
    private List<String> userMove = new ArrayList<>();
    private String retry;
    private List<String> bridge = new ArrayList<>();
    private int tryNumber = 1;

    public boolean bridgeSize(String bridgeSize) {
        this.bridgeSize = bridgeSize;
        return checkBridgeSize();
    }

    public void move(String userMove) {
        this.userMove.add(userMove);
    }

    public void retry(String retry) {
        this.retry = retry;
    }

    public void bridge(List<String> bridge) {
        this.bridge = bridge;
    }


    public int getBridgeSize() {
        return Integer.valueOf(bridgeSize);
    }

    public List<String> getMoveList() {
        return userMove;
    }

    public String getRetry() {
        return retry;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void checkTryNumber() {
        tryNumber++;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public boolean checkFail(List<String> bridgeResult) {
        for (int i = 0; i < bridgeResult.size(); i++) {
            if (bridgeResult.get(i).contains("X")) {
                return true;
            }
        }
        return false;
    }

    public int checkSuccess(List<String> bridgeResult) {
        int successCount = 0;
        for (int i = 0; i < bridgeResult.size(); i++) {
            successCount += bridgeResult.get(i).chars()
                    .filter(c -> c == 'O')
                    .count();
        }
        return successCount;
    }

    public void initializeUserMove() {
        userMove.clear();
    }


    public boolean checkBridgeSize() {
        try {
            checkBridgeSizeInput();
            checkBridgeSizeRange();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public void checkBridgeSizeInput() {
        for (int i = 0; i < bridgeSize.length(); i++) {
            if (i == 0 && bridgeSize.charAt(i) == '0') {
                throw new IllegalArgumentException(Message.BRIDGE_SIZE_INPUT_ZERO_ERROR.getMessage());
            }
            if (!(bridgeSize.charAt(i) >= '0' && bridgeSize.charAt(i) <= '9')) {
                throw new IllegalArgumentException(Message.BRIDGE_SIZE_INPUT_ERROR.getMessage());
            }
        }
    }
    public void checkBridgeSizeRange() {
        if (!(getBridgeSize() >= 3 && getBridgeSize() <= 20)) {
            throw new IllegalArgumentException(Message.BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }





}

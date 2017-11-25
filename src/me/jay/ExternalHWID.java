package me.jay;

import me.jay.interfaces.Logger;

/**
 * @Author Jay
 */
public class ExternalHWID {

    private static ExternalHWID instance = new ExternalHWID();

    private Frame frame = new Frame();
    private Logger logger = new LoggerFactory().withName("ExternalHWID").withParenthesis(true).create();

    public void onInit() {
        logger.info("Initializing.");
        frame.onInit();
        logger.info("Initialized.");
    }

    public static ExternalHWID getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        ExternalHWID.getInstance().onInit();
    }
}

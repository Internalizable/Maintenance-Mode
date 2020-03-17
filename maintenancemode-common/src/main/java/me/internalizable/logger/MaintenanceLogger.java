package me.internalizable.logger;

public class MaintenanceLogger {

    private String prefix = "Maintenance Mode";

    public void log(LoggerType type, String logMessage) {
        System.out.print("[" + type.toString() + "] - " + prefix + ": " + logMessage);
    }
}

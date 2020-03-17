package me.internalizable.maintenancemode.storage;

import me.internalizable.config.MaintenanceConfig;
import me.internalizable.config.SQLConfig;
import me.internalizable.maintenancemode.MaintenanceModeSpigot;
import me.internalizable.storage.IStorageLoader;

public class BukkitStorageLoader implements IStorageLoader {

    private MaintenanceModeSpigot instance;
    private MaintenanceConfig maintenanceconfig;
    private SQLConfig sqlConfig;

    public BukkitStorageLoader(MaintenanceModeSpigot instance, MaintenanceConfig maintenanceConfig, SQLConfig sqlConfig) {
        this.instance = instance;
        this.maintenanceconfig = maintenanceconfig;
        this.sqlConfig = sqlConfig;
    }

    public void loadStorage() {

    }

}

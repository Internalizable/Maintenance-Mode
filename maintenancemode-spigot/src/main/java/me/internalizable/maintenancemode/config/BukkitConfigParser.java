package me.internalizable.maintenancemode.config;

import me.internalizable.config.IConfigParser;
import me.internalizable.config.MaintenanceConfig;
import me.internalizable.config.SQLConfig;
import me.internalizable.maintenancemode.MaintenanceModeSpigot;
import me.internalizable.storage.StorageType;

public class BukkitConfigParser implements IConfigParser {

    private MaintenanceModeSpigot instance;
    private MaintenanceConfig config;
    private SQLConfig sqlConfig;

    public BukkitConfigParser(MaintenanceModeSpigot instance, MaintenanceConfig config, SQLConfig sqlConfig) {
        this.instance = instance;
        this.config = config;
        this.sqlConfig = sqlConfig;
    }

    public void parse() {

        if(StorageType.valueOf(config.getStorageType()) == null) {

            instance.getServer().getPluginManager().disablePlugin(instance);
        }

    }

}

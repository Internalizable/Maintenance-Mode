package me.internalizable.config;

import lombok.Getter;
import me.internalizable.api.config.SimpleConfig;
import me.internalizable.api.config.annotation.Comment;

@Getter
public class MaintenanceConfig extends SimpleConfig {

    @Comment("Define the storage type below (either use YAML or SQL). It is set to YAML by default.")
    private String storageType = "YAML";
}

package me.internalizable.config;

import lombok.Getter;
import me.internalizable.api.config.SimpleConfig;
import me.internalizable.api.config.annotation.Comment;

@Getter
public class SQLConfig extends SimpleConfig {
    @Comment("Define the host for the SQL storage type database")
    private String hostname = "localhost";

    @Comment("Define the port number for the SQL storage type")
    private int port = 3306;

    @Comment("Define the database name for the SQL storage type")
    private String database = "maintenance";

    @Comment("Define the SQL server username for the SQL storage type")
    private String username = "root";

    @Comment("Define the SQL server password for the SQL storage type")
    private String password = "19mK1js093";
}

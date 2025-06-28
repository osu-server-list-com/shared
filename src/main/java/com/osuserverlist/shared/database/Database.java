package com.osuserverlist.shared.database;

import javax.sql.DataSource;

import org.jooq.Configuration;
import org.jooq.ExecuteContext;
import org.jooq.ExecuteListener;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.osuserverlist.shared.Globals;
import com.osuserverlist.shared.configuration.ServerConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Database implements ExecuteListener {

    private static HikariConfig hikariConfig;

    private static Logger logger = LoggerFactory.getLogger("OSL-Database");

    public static void connect(ServerConfig config) {
        hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(
                "jdbc:mysql://" + config.mysql.host + ":" + config.mysql.port + "/" + config.mysql.database);
        hikariConfig.setUsername(config.mysql.user);
        hikariConfig.setPassword(config.mysql.password);
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setMaximumPoolSize(config.mysql.poolsize);

        DataSource dataSource = new HikariDataSource(hikariConfig);
        Configuration configuration = new DefaultConfiguration()
                .set(dataSource)
                .set(SQLDialect.MYSQL)
                .set(new Database())
                .set(new Settings().withExecuteLogging(false));

        Globals.dsl = DSL.using(configuration);

        Globals.dsl.fetch("SELECT 1").forEach(record -> {
            logger.debug("Database connection test successful: " + record.get(0));
        });

        logger.info("Connected to MySQL database at " + config.mysql.host + ":" + config.mysql.port + "/"
                + config.mysql.database);
    }

    @Override
    public void executeStart(ExecuteContext ctx) {
        
    }

    @Override
    public void executeEnd(ExecuteContext ctx) {
        if(!Globals.serverConfig.mysql.log) return;

        logger.debug("[SQL] " + ctx.sql());
    }

    @Override
    public void exception(ExecuteContext ctx) {
        logger.error("Execution failed", ctx.sqlException());
    }

}

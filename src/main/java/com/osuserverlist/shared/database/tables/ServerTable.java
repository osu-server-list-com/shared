package com.osuserverlist.shared.database.tables;

import java.time.LocalDateTime;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class ServerTable extends TableImpl<org.jooq.Record> {

    private static final long serialVersionUID = 1L;

    // Singleton instance
    public static final ServerTable SERVER = new ServerTable();

    // Columns (fields)
    public final TableField<org.jooq.Record, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this);
    public final TableField<org.jooq.Record, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(20).nullable(false), this);
    public final TableField<org.jooq.Record, Integer> PLAYERS = createField(DSL.name("players"), SQLDataType.INTEGER.nullable(false).defaultValue(0), this);
    public final TableField<org.jooq.Record, Integer> VOTES = createField(DSL.name("votes"), SQLDataType.INTEGER.nullable(false).defaultValue(0), this);
    public final TableField<org.jooq.Record, Integer> EXPIRED = createField(DSL.name("expired"), SQLDataType.INTEGER.nullable(false).defaultValue(0), this);
    public final TableField<org.jooq.Record, Integer> PING = createField(DSL.name("ping"), SQLDataType.INTEGER.nullable(true), this);
    public final TableField<org.jooq.Record, String> URL = createField(DSL.name("url"), SQLDataType.CLOB.nullable(false), this);
    public final TableField<org.jooq.Record, String> DEVSERVER = createField(DSL.name("devserver"), SQLDataType.VARCHAR(200).nullable(false), this);
    public final TableField<org.jooq.Record, String> LOGO_LOC = createField(DSL.name("logo_loc"), SQLDataType.VARCHAR(300).nullable(false), this);
    public final TableField<org.jooq.Record, Boolean> FEATURED = createField(DSL.name("featured"), SQLDataType.BOOLEAN.nullable(false).defaultValue(false), this);
    public final TableField<org.jooq.Record, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME.nullable(false), this);
    public final TableField<org.jooq.Record, String> APIKEY = createField(DSL.name("apikey"), SQLDataType.VARCHAR(30).nullable(false), this);
    public final TableField<org.jooq.Record, String> OWNER_IDS = createField(DSL.name("owner_ids"), SQLDataType.VARCHAR(20).nullable(false).defaultValue("0"), this);
    public final TableField<org.jooq.Record, Boolean> VISIBLE = createField(DSL.name("visible"), SQLDataType.BOOLEAN.nullable(false).defaultValue(true), this);
    public final TableField<org.jooq.Record, Boolean> LOCKED = createField(DSL.name("locked"), SQLDataType.BOOLEAN.nullable(false).defaultValue(true), this);
    public final TableField<org.jooq.Record, Boolean> ONLINE = createField(DSL.name("online"), SQLDataType.BOOLEAN.nullable(false).defaultValue(true), this);
    public final TableField<org.jooq.Record, String> CATEGORIES = createField(DSL.name("categories"), SQLDataType.CLOB.nullable(false), this);
    public final TableField<org.jooq.Record, String> BANNER_URL = createField(DSL.name("banner_url"), SQLDataType.VARCHAR(150).nullable(true), this);
    public final TableField<org.jooq.Record, String> DISCORD_URL = createField(DSL.name("discord_url"), SQLDataType.VARCHAR(100).nullable(true), this);
    public final TableField<org.jooq.Record, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(1500).nullable(true), this);

    // Private constructor
    private ServerTable() {
        this(DSL.name("un_servers"), null);
    }

    // Constructor with name and schema
    private ServerTable(Name alias, Table<org.jooq.Record> aliased) {
        this(alias, aliased, (Field<?>[]) null);
    }

    // Constructor with name, schema and parameters
    private ServerTable(Name alias, Table<org.jooq.Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Category table"));
    }

    @Override
    public ServerTable as(String alias) {
        return new ServerTable(DSL.name(alias), this);
    }

    @Override
    public ServerTable as(Name alias) {
        return new ServerTable(alias, this);
    }

    @Override
    public Class<org.jooq.Record> getRecordType() {
        return org.jooq.Record.class;
    }
}

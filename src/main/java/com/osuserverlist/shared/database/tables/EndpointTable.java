package com.osuserverlist.shared.database.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class EndpointTable extends TableImpl<org.jooq.Record> {

    private static final long serialVersionUID = 1L;    // Singleton instance
    public static final EndpointTable ENDPOINTS = new EndpointTable();

    // Columns (fields)
    public final TableField<org.jooq.Record, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this);
    public final TableField<org.jooq.Record, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR(20).nullable(false), this);
    public final TableField<org.jooq.Record, String> APITYPE = createField(DSL.name("apitype"), SQLDataType.VARCHAR(20).nullable(false), this);
    public final TableField<org.jooq.Record, String> ENDPOINT = createField(DSL.name("endpoint"), SQLDataType.CLOB.nullable(false), this);
    public final TableField<org.jooq.Record, Byte> DCBOT = createField(DSL.name("dcbot"), SQLDataType.TINYINT.nullable(true).defaultValue((byte)1), this);
    public final TableField<org.jooq.Record, Integer> SRV_ID = createField(DSL.name("srv_id"), SQLDataType.INTEGER.nullable(false), this);

    // Private constructor
    private EndpointTable() {
        this(DSL.name("un_endpoints"), null);
    }

    // Constructor with name and schema
    private EndpointTable(Name alias, Table<org.jooq.Record> aliased) {
        this(alias, aliased, (Field<?>[]) null);
    }

    // Constructor with name, schema and parameters
    private EndpointTable(Name alias, Table<org.jooq.Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Endpoint table"));
    }

    @Override
    public EndpointTable as(String alias) {
        return new EndpointTable(DSL.name(alias), this);
    }

    @Override
    public EndpointTable as(Name alias) {
        return new EndpointTable(alias, this);
    }

    @Override
    public Class<org.jooq.Record> getRecordType() {
        return org.jooq.Record.class;
    }
}

package com.osuserverlist.shared.database.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class CategoryTable extends TableImpl<org.jooq.Record> {

    private static final long serialVersionUID = 1L;

    // Singleton instance
    public static final CategoryTable CATEGORY = new CategoryTable();

    // Columns (fields)
    public final TableField<org.jooq.Record, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this);
    public final TableField<org.jooq.Record, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this);
    public final TableField<org.jooq.Record, String> COLOR = createField(DSL.name("color"), SQLDataType.VARCHAR(7).nullable(false), this);

    // Private constructor
    private CategoryTable() {
        this(DSL.name("un_categories"), null);
    }

    // Constructor with name and schema
    private CategoryTable(Name alias, Table<org.jooq.Record> aliased) {
        this(alias, aliased, (Field<?>[]) null);
    }

    // Constructor with name, schema and parameters
    private CategoryTable(Name alias, Table<org.jooq.Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Category table"));
    }

    @Override
    public CategoryTable as(String alias) {
        return new CategoryTable(DSL.name(alias), this);
    }

    @Override
    public CategoryTable as(Name alias) {
        return new CategoryTable(alias, this);
    }

    @Override
    public Class<org.jooq.Record> getRecordType() {
        return org.jooq.Record.class;
    }
}

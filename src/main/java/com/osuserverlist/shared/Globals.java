package com.osuserverlist.shared;

import org.jooq.DSLContext;

import com.google.gson.Gson;
import com.osuserverlist.shared.configuration.ServerConfig;
import com.osuserverlist.shared.database.tables.CategoryTable;
import com.osuserverlist.shared.database.tables.EndpointTable;
import com.osuserverlist.shared.database.tables.ServerTable;
import com.osuserverlist.shared.utils.RequestInterceptor;

import okhttp3.OkHttpClient;

/**
 * OSL Shared Lib!
 */
public class Globals 
{
    public static final String USER_AGENT = "osu!ListBot/v4.0 (https://osu-server-list.com/docs; +osu)";
    public static final Gson GSON = new Gson();

    public static ServerConfig serverConfig = ServerConfig.load();
    public static DSLContext dsl;

    public static final CategoryTable CATEGORY = CategoryTable.CATEGORY;
    public static final ServerTable SERVER = ServerTable.SERVER;
    public static final EndpointTable ENDPOINT = EndpointTable.ENDPOINTS;

    public static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
        .addInterceptor(new RequestInterceptor())
        .build();

 


    public static void main( String[] args )
    {
        System.out.println( "Shared Library" );
    }
}

package com.osuserverlist.shared.configuration;

import java.io.File;

import com.moandjiezana.toml.Toml;

public class ServerConfig {

    public Api api;
    public MySQL mysql;
    public Crawler crawler;
    public HTTP http;

    public static class Api {
        public int port;
        public String domain;
    }

    public static class Crawler {
        public int workers;
        public int timeout;
        public String webhook;
    }

    public static class MySQL {
        public String host;
        public int port;
        public String database;
        public String user;
        public String password;

        public int poolsize;
        public boolean log;
    }

    public static class HTTP {
        public boolean log;
    }

    public static ServerConfig load() {
        Toml toml = new Toml().read(new File(".config/server.toml"));
        return toml.to(ServerConfig.class);
    }
}

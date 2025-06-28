package com.osuserverlist.shared.models;

import com.osuserverlist.shared.database.records.Server;

import lombok.Data;

@Data
public class Incident {
    private String time;
    private String message;
    private String url;
    private int responseCode;
    private Server server;
}
package com.osuserverlist.shared.database.records;

public record Server(
    int id,
    String name,
    int players,
    int votes,
    int expired,
    int ping,
    String url,
    String devserver,
    String logo_loc,
    boolean featured,
    String created,
    String apikey,
    int owner_ids,
    boolean visible,
    boolean locked,
    boolean online,
    String categories,
    String banner_url,
    String discord_url,
    String description
) {}
package com.osuserverlist.shared.database.records;

public record OLLServer(
    int id,
    String name,
    String safe_name,
    String url,
    String devserver,
    boolean online,
    String image,
    int players,
    int votes,
    String timestamp
) {}
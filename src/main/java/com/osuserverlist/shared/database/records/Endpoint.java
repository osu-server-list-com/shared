package com.osuserverlist.shared.database.records;

import com.osuserverlist.shared.models.CrawlerType;
import com.osuserverlist.shared.models.EndpointType;

public record Endpoint(
    int id,
    CrawlerType type,
    EndpointType apitype,
    String endpoint,
    boolean dcbot,
    int srv_id
) {}
package com.osuserverlist.shared.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.osuserverlist.shared.Globals;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiscordWebhook {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final String webhookUrl;

    private final String content;
    private final List<Embed> embeds;

    private DiscordWebhook(Builder builder) {
        this.webhookUrl = builder.webhookUrl;
        this.content = builder.content;
        this.embeds = builder.embeds;
    }

    public void send() throws IOException {
        JsonObject payload = new JsonObject();

        if (content != null && !content.isEmpty()) {
            payload.addProperty("content", content);
        }

        if (!embeds.isEmpty()) {
            JsonArray embedsArray = new JsonArray();
            for (Embed e : embeds) {
                embedsArray.add(e.toJson());
            }
            payload.add("embeds", embedsArray);
        }

        RequestBody body = RequestBody.create(payload.toString(), JSON);
        Request request = new Request.Builder().url(webhookUrl).post(body).build();

        try (Response response = Globals.HTTP_CLIENT.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Request failed: " + response.code() + " " + response.message());
            }
        }
    }

    public static class Builder {
        private final String webhookUrl;
        private String content;
        private final List<Embed> embeds = new ArrayList<>();

        public Builder(String webhookUrl) {
            this.webhookUrl = webhookUrl;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder addEmbed(Embed embed) {
            this.embeds.add(embed);
            return this;
        }

        public DiscordWebhook build() {
            return new DiscordWebhook(this);
        }
    }

    public static class Embed {
        private String title;
        private String description;
        private Integer color;

        public Embed setTitle(String title) {
            this.title = title;
            return this;
        }

        public Embed setDescription(String description) {
            this.description = description;
            return this;
        }

        public Embed setColor(int color) {
            this.color = color;
            return this;
        }

        private JsonObject toJson() {
            JsonObject json = new JsonObject();
            if (title != null) json.addProperty("title", title);
            if (description != null) json.addProperty("description", description);
            if (color != null) json.addProperty("color", color);
            return json;
        }
    }
}

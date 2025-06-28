package com.osuserverlist.shared.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.osuserverlist.shared.Globals;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger("OSL-HTTP");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request modifiedRequest = originalRequest.newBuilder()
                .header("User-Agent", Globals.USER_AGENT)
                .build();

        if (Globals.serverConfig.http.log) {
            logger.debug("[{}] {}",
                    modifiedRequest.method(), modifiedRequest.url());
        }

        return chain.proceed(modifiedRequest);
    }

}

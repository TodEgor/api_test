package helpers;

import kong.unirest.Unirest;
import kong.unirest.UnirestInstance;

public class HttpClientFactory {

    public static UnirestInstance getHttpClient() {
        UnirestInstance httpClient = Unirest.spawnInstance();
        httpClient.config()
                .verifySsl(false)
                .followRedirects(true)
                .addDefaultHeader("Content-Type", "Application/JSON");

        return httpClient;
    }
}

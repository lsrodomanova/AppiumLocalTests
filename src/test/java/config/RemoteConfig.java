package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:remote.properties"
})

public interface RemoteConfig extends Config {
    String login();
    String key();
    String appURL();
    String baseURL();
    String name();
    String project();
    String build();
    String osVersion();
    String device();
}

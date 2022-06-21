package config;

import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:local.properties"
})

public interface LocalConfig extends Config {
    String deviceName();
    String osLocalVersion();
    String platformName();
    String localURL();
    String appPath();
}

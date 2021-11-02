package cloud.autotests.config.lenta;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/lenta/app.properties"
})
public interface AppConfig extends Config {

    String webUrl();

    String userLogin();

    String userPassword();

}

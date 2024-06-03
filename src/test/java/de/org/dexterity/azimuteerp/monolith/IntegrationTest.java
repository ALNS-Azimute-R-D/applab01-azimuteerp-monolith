package de.org.dexterity.azimuteerp.monolith;

import de.org.dexterity.azimuteerp.monolith.config.AsyncSyncConfiguration;
import de.org.dexterity.azimuteerp.monolith.config.EmbeddedSQL;
import de.org.dexterity.azimuteerp.monolith.config.JacksonConfiguration;
import de.org.dexterity.azimuteerp.monolith.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(
    classes = {
        AzimuteErpSpringAngularMonolith01App.class,
        JacksonConfiguration.class,
        AsyncSyncConfiguration.class,
        TestSecurityConfiguration.class,
    }
)
@EmbeddedSQL
public @interface IntegrationTest {
}

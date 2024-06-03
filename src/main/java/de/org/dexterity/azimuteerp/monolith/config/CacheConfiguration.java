package de.org.dexterity.azimuteerp.monolith.config;

import java.time.Duration;
import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;
import org.hibernate.cache.jcache.ConfigSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.*;
import tech.jhipster.config.JHipsterProperties;
import tech.jhipster.config.cache.PrefixedKeyGenerator;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private GitProperties gitProperties;
    private BuildProperties buildProperties;
    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(
                Object.class,
                Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries())
            )
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build()
        );
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Country.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Country.class.getName() + ".provincesLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Country.class.getName() + ".localitiesLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Province.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Province.class.getName() + ".townCitiesLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.TownCity.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.TownCity.class.getName() + ".districtsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.District.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.District.class.getName() + ".personsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.District.class.getName() + ".customersLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Locality.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Tenant.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Tenant.class.getName() + ".organizationsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.TypeOfOrganization.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.TypeOfOrganization.class.getName() + ".organizationsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Organization.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Organization.class.getName() + ".organizationDomainsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Organization.class.getName() + ".organizationAttributesLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Organization.class.getName() + ".businessUnitsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Organization.class.getName() + ".childrenOrganizationsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Organization.class.getName() + ".organizationRolesLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Organization.class.getName() + ".organizationMembershipsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.BusinessUnit.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.BusinessUnit.class.getName() + ".childrenBusinessUnitsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.OrganizationDomain.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.OrganizationAttribute.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.TypeOfPerson.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.TypeOfPerson.class.getName() + ".personsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Person.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Person.class.getName() + ".managedPersonsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Person.class.getName() + ".organizationMembershipsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.OrganizationRole.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.OrganizationRole.class.getName() + ".organizationMemberRolesLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.OrganizationMembership.class.getName());
            createCache(
                cm,
                de.org.dexterity.azimuteerp.monolith.domain.OrganizationMembership.class.getName() + ".organizationMemberRolesLists"
            );
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.OrganizationMemberRole.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.AssetType.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.AssetType.class.getName() + ".rawAssetsProcsTmps");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.AssetType.class.getName() + ".assets");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmp.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.RawAssetProcTmp.class.getName() + ".assets");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Asset.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.AssetMetadata.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Invoice.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.PaymentMethod.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.PaymentMethod.class.getName() + ".invoicesAsPreferrableLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.PaymentMethod.class.getName() + ".paymentsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Payment.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Warehouse.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Warehouse.class.getName() + ".inventoryTransactionsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Warehouse.class.getName() + ".stockLevelsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Supplier.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Supplier.class.getName() + ".productsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Supplier.class.getName() + ".inventoryTransactionsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Brand.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Brand.class.getName() + ".productsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Product.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Product.class.getName() + ".productsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Product.class.getName() + ".stockLevelsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Product.class.getName() + ".suppliersLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.InventoryTransaction.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.StockLevel.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Customer.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.CustomerType.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.CustomerType.class.getName() + ".customersLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Category.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Category.class.getName() + ".articlesLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Category.class.getName() + ".childrenCategoriesLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Article.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Article.class.getName() + ".ordersItemsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Order.class.getName());
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.Order.class.getName() + ".ordersItemsLists");
            createCache(cm, de.org.dexterity.azimuteerp.monolith.domain.OrderItem.class.getName());
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache != null) {
            cache.clear();
        } else {
            cm.createCache(cacheName, jcacheConfiguration);
        }
    }

    @Autowired(required = false)
    public void setGitProperties(GitProperties gitProperties) {
        this.gitProperties = gitProperties;
    }

    @Autowired(required = false)
    public void setBuildProperties(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new PrefixedKeyGenerator(this.gitProperties, this.buildProperties);
    }
}

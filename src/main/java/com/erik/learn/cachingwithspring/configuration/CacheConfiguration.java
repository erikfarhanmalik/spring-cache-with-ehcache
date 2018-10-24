package com.erik.learn.cachingwithspring.configuration;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class CacheConfiguration implements JCacheManagerCustomizer {

	@Override
	public void customize(CacheManager cacheManager) {

		cacheManager.createCache("rare-book", new MutableConfiguration<>()
				.setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 10)))
				.setStoreByValue(true)
				.setStatisticsEnabled(true)
		);
	}
}

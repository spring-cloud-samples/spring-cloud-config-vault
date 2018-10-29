package org.springframework.cloud.vaultconfigclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaultConfigClientApplication implements CommandLineRunner {
	Logger LOG = LoggerFactory.getLogger(VaultConfigClientApplication.class);

	@Value("${foo}")
	String foo;

	@Value("${baz}")
	String bar;

	public static void main(String[] args) {
		SpringApplication.run(VaultConfigClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Foo: " + foo);
		LOG.info("Bar: " + bar);
	}
}

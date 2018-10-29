package org.springframework.cloud.vaultconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class VaultConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultConfigServerApplication.class, args);
	}
}

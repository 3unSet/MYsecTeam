package org.hnust.MYSec.Configure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "docker.service")
@Data
public class DockerServiceConfig {
	private String mode;
	private String host="http://127.0.0.1:2375";
}



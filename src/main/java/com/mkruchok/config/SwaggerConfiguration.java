package com.mkruchok.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.ArrayList;
import java.util.List;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;


@Configuration
public class SwaggerConfiguration {
  @Bean
  public LinkDiscoverers discoverers() {
    List<LinkDiscoverer> plugins = new ArrayList<>();
    plugins.add(new CollectionJsonLinkDiscoverer());
    return new LinkDiscoverers(SimplePluginRegistry.of(plugins));
  }

  @Bean
  public GroupedOpenApi decksApi() {
    return GroupedOpenApi.builder().group("public").pathsToMatch("/public/**").build();
  }

  @Bean
  public OpenAPI ajaxOpenApi() {
    Server server = new Server();
    server.setUrl("http://localhost:8443");
    return new OpenAPI().info(new Info().title("AJAX SYSTEMS CRUD DEMO")
        .description("Application for ajax security systems")
        .version("v0.0.1")
        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
  }

}
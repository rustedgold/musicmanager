package com.ea.music.rmgr.config;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Music Manager Resources",
                version = "V1.0",
                title = "Music Manager API",
                contact = @Contact(
                   name = "Radha Bh", 
                   email = "rsoujanya.bh@gmail.com", 
                   url = ""
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "API documentation", url = "")
)
public interface ApiDefinitionConfig {

}
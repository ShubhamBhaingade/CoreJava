package com.cg.Garment.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(
				title="Garment Project",
				description = "This app is aimed at Performing CRUD operation and Some Buisness Logic",
				summary = "App Includes Few Modules Like Product,Department,Admin,Garment ",
				contact = @Contact(
						
						name = "Shubham",
						email = "XYZ@gmail.com"
						),
				license = @License(name = "Your Licence Id"),
				version = "V1"
				
				)
		)
public class SwaggerConfig {

}

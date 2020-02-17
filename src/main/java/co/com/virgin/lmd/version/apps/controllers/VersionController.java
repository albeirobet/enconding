package co.com.virgin.lmd.version.apps.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/version")
@Api(value = "versionApi", description = "Operaciones de la logica de negocio para las versiones de las Apps de VMCO.")
public class VersionController {

	@ApiOperation(value = "EndPoint test para comprobar funcionalidad en Lambda", response = ResponseEntity.class)
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
	public String test() {
		System.out.println("Printing special characters á é í ó ú ñ à è ò");
		return "á é í ó ú ñ à è ò";
	}

}

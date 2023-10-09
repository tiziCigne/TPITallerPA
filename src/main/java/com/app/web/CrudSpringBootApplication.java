package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Cliente;
import com.app.web.entidad.Marca;
import com.app.web.entidad.Modelo;
import com.app.web.entidad.Vehiculo;
import com.app.web.entidad.tecnico;
import com.app.web.repository.ClienteRepositorio;
import com.app.web.repository.MarcaRepository;
import com.app.web.repository.ModeloRepositorio;
import com.app.web.repository.VehiculoRepository;
import com.app.web.repository.tecnicoRepositorio;

/**
 * Clase principal de la aplicación Spring Boot.
 * Implementa la interfaz CommandLineRunner para ejecutar tareas al iniciar la aplicación.
 */
@SpringBootApplication
public class CrudSpringBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootApplication.class, args); //Inicia la aplicación Spring Boot.
	}
	
	@Autowired
    private MarcaRepository repositorioMarca;
    
	@Autowired
	private VehiculoRepository repositorio;
	
	@Autowired 
	private tecnicoRepositorio repositorioTecnico;
	
	@Autowired 
	private ClienteRepositorio repositorioCliente;
	
	@Autowired
	private ModeloRepositorio repositorioModelo;
	
	//este método es ejecutado al iniciar la aplicación.
    //carga de datos iniciales.
	@Override
	public void run(String... args) throws Exception {
	
		
		Vehiculo vehiculo1 = new Vehiculo("A03 NFB");
		repositorio.save(vehiculo1);
		
		Vehiculo vehiculo2 = new Vehiculo("A33 FDA");
		repositorio.save(vehiculo2);
		
        Marca marca1 = new Marca("FIAT");
        repositorioMarca.save(marca1);

        Marca marca2 = new Marca("PEUGEOT");
        repositorioMarca.save(marca2);
		
		tecnico tecnico1 = new tecnico("Pineda","Alvaro",3385688 );	
		repositorioTecnico.save(tecnico1);
	
		tecnico tecnico2 = new tecnico("Pepe","Salamaleco",3585688 );	
		repositorioTecnico.save(tecnico2);
		
		Cliente cliente1 = new Cliente("Celia","Carranza","celi@gmail.com",784576698,"Periodistas argentinos 99","patente 455","");
		repositorioCliente.save(cliente1);
		
		Cliente cliente2 = new Cliente("Alvaro","Pineda","alva@gmail.com",1515151777,"Periodistas argentinos 6984","patente 2145","");
		repositorioCliente.save(cliente2);
		
		Cliente cliente3 = new Cliente("Rodrigo","Alves","rorororo@gmail.com",14785239,"Periodistas argentinos 199","patente 55","");
		repositorioCliente.save(cliente3);
		
		Cliente cliente4 = new Cliente("Tiziana","Cignetti","tizi@gmail.com",985235,"Pellegrini 4578","patente 7841","");
		repositorioCliente.save(cliente4);
		
		Modelo modelo1 = new Modelo("Focus", "2001");
		repositorioModelo.save(modelo1);
		
		Modelo modelo2 = new Modelo("K", "2003");
		repositorioModelo.save(modelo2);
		
		Modelo modelo3 = new Modelo("Fiesta", "2009");
		repositorioModelo.save(modelo3);
		
	}
}


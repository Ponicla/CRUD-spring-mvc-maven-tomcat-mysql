package com.embarque.tarjetas.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.embarque.tarjetas.models.Tarjeta;
import com.embarque.tarjetas.models.TarjetaDao;

@Controller
public class HomeController {

	private ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	private TarjetaDao tarjetaDao = (TarjetaDao) context.getBean("TarjetaDAO");

	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Tarjeta> tarjetas = tarjetaDao.getAll();
		//ORDEN BASADO EN ATRIBUTO HORA//
		Collections.sort(tarjetas);
		//ORDEN BASADO EN ATRIBUTO HORA//
		model.addAttribute("tarjetas", tarjetas);
		return "tarjeta_all";
	}
	
	@RequestMapping(value = "/add")
	public String add(Model model) {
		
		return "tarjeta_add";
	}
	
	@RequestMapping(value = "/addTarjeta")
	public String addTarjeta(Model model, Tarjeta tarjeta) {
		String mensaje = tarjetaDao.insert(tarjeta);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("url", "/tarjetas");
		
		return "mensaje";
	}
	
	@RequestMapping(value = "/edit/{tarjetaId}")
	public String editTarjeta(Model model, @PathVariable String tarjetaId) {
		Tarjeta tarjeta = tarjetaDao.getById(tarjetaId);
		model.addAttribute("origen", tarjeta.getOrigen());
		model.addAttribute("destino", tarjeta.getDestino());
		model.addAttribute("transporte", tarjeta.getTransporte());
		model.addAttribute("fecha", tarjeta.getFecha());
		model.addAttribute("hora", tarjeta.getHora());
		model.addAttribute("tarjetaId", tarjeta.getTarjetaId());
		
		return "tarjeta_edit";
	}
	
	
	@RequestMapping(value = "/editTarjeta")
	public String editTarjeta(Model model, Tarjeta tarjeta) {
		String mensaje = tarjetaDao.update(tarjeta);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("url", "/tarjetas");
		
		return "mensaje";
	}
	
	
	@RequestMapping(value = "/deleteTarjeta/{tarjetaId}")
	public String deleteTarjeta(Model model, @PathVariable String tarjetaId) {
		String mensaje = tarjetaDao.delete(tarjetaId);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("url", "/tarjetas");
		
		return "mensaje";
	}
	
	
	
}

/*
 * OBTENER TODAS List<Tarjeta> tarjetas = tarjetaDao.getAll(); for(Tarjeta
 * tarjeta: tarjetas) { System.out.println(tarjeta.toString()); }
 */

/*
 * OBTENER UNA ESPECIFICO Tarjeta tarjeta = tarjetaDao.getById("3");
 * System.out.println(tarjeta.toString());
 */

/*
 * AGREGAR UNA TARJETA Tarjeta tarjeta = new
 * Tarjeta("","rosario","la plata","aereo","03/12/2019","15:40"); String mensaje
 * = tarjetaDao.insert(tarjeta); System.out.println(mensaje);
 */

/*
 * ACTUALIZAR POR CAMPO Tarjeta tarjeta = tarjetaDao.getById("3");
 * System.out.println(tarjeta.toString()); tarjeta.setDestino("santa fe");
 * String mensaje = tarjetaDao.update(tarjeta); System.out.println(mensaje);
 */

/*
 * ELIMINAR POR ID String mensaje = tarjetaDao.delete("3");
 * System.out.println(mensaje);
 */

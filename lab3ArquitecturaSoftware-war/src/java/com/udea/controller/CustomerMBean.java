/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.logica.CustomerManager;
import com.udea.logica.DiscountManager;
import com.udea.logica.MicroMarketManager;
import com.udea.modelo.Customer;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author camilo.posadaa
 */
public class CustomerMBean implements Serializable{
    @EJB
    private MicroMarketManager microMarketManager;
    @EJB
    private DiscountManager discountManager;
    @EJB
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerMBean
     */
    public CustomerMBean() {
    }
    
    
    //propiedades del Modelo
    //para deplegar /actualizar /insertar en el formulario
    private Customer customer;
    //para mostrar en la tabla de datos 
    private List<Customer> customers;
    //Retorna la lista de lientes para mostrar en la Tabla de Datos
    public List<Customer> getCustomers(){
        if ((customers ==null)||(customers.isEmpty())) refresh();
        return customers;
    }
    //Retorna lo s detalles del cliente. Usando para desplegar en el 
    //formulario Customer Details
    public Customer getDetails(){
        return customer;
    }
    
    //Action handler- Llamando cuando se hace click sobre cada ID
    public String showDetails(Customer customer){
        this.customer=customer;
        return "DETAILS"; //Este es el primer caso en la navegación
    }
    
    //Action handler - Atualizo el modelo del Cliente en la BD
    //Llamando cuando se presiona el boton Update en el formulario
    public String update(){
        customer=customerManager.update(customer);
        return "SAVED"; //Este es el segundo caso en la navegación
    }
    
    //Action Handler - Retorna la lista de clientes de la tabla
    public String list(){
        return "LIST"; //Este es el tercer caso en la navegación
    }
    public void refresh(){
        customers=customerManager.getAllCustomers();
    }
    
    
    
    
    
    
    
}

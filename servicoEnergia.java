/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.servico.cee;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author leozin
 */
@WebService(
        name = "CEE",
        serviceName = "CEEServico")
public class CEE {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "calcularEnergia")
    public CalcularEnergia calcularEnergia(
            @WebParam(name = "nomeCliente") String nomeCliente,
            @WebParam(name = "endereco") String endereco,
            @WebParam(name = "leituraA") double leituraA,
            @WebParam(name = "leituraB") double leituraB) {
        
        // Preço fixo por kWh, pode ser parametrizado
        double precoPorKwh = 0.50;  
        
        // Criação de instância da classe CalcularEnergia com os parâmetros fornecidos
        CalcularEnergia calculaEng = new CalcularEnergia(nomeCliente, endereco, leituraA, leituraB, precoPorKwh);
        
        // Calcular o valor total baseado no consumo
        calculaEng.calcularValorTotal();
        
        // Retornar o objeto CalcularEnergia com as informações
        return calculaEng;
    }
}

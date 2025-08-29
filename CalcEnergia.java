package com.calcenergia;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(name="CalcEnergia", serviceName="CalcEnergiaServico")
public class CalcEnergia {

    @WebMethod(operationName = "calculaEnergia")
    public String calculaEnergia(
            @WebParam(name = "nomeC") String nomeC, 
            @WebParam(name = "End") String End,
            @WebParam(name = "leitA") double leitA,
            @WebParam(name = "leitB") double leitB) {

        double precoPorKwh = 0.50;

        // Criando objeto da classe CalculaEnergia
        CalculaEnergia calculaEng = new CalculaEnergia(nomeC, End, leitA, leitB, precoPorKwh);

        // Chamando o método que calcula o total
        calculaEng.calculaValorTotal();

        // Retornando informações
        return "Cliente: " + calculaEng.getNomeC() +
               " | Endereço: " + calculaEng.getEnd() +
               " | Consumo: " + calculaEng.getConsEnerg() + " kWh" +
               " | Valor Total: R$ " + calculaEng.getValorT();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servico.cee;

/**
 *
 * @author leozin
 */
public class CalcularEnergia {
    private String nomeCliente, endereco;
    private double leituraA, leituraB, valorP; // Preço por kWh
    private double valorT; // Valor total da conta
    private double consumoEnergia; // Consumo total de energia em kWh

    // Construtor
    public CalcularEnergia(String nomeCliente, String endereco, double leituraA, double leituraB, double valorP) {
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.leituraA = leituraA;
        this.leituraB = leituraB;
        this.valorP = valorP;
    }

    // Métodos Getters e Setters

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getLeituraA() {
        return leituraA;
    }

    public void setLeituraA(double leituraA) {
        this.leituraA = leituraA;
    }

    public double getLeituraB() {
        return leituraB;
    }

    public void setLeituraB(double leituraB) {
        this.leituraB = leituraB;
    }

    public double getValorP() {
        return valorP;
    }

    public void setValorP(double valorP) {
        this.valorP = valorP;
    }

    public double getValorT() {
        return valorT;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    // Método para calcular o consumo
    public void calcularConsumo() {
        if (leituraB >= leituraA) {
            this.consumoEnergia = leituraB - leituraA; // Consumo em kWh
        } else {
            System.out.println("Leitura final não pode ser menor que a leitura inicial.");
            this.consumoEnergia = 0;
        }
    }

    // Método para calcular o valor total da conta
    public void calcularValorTotal() {
        calcularConsumo();
        if (consumoEnergia > 0) {
            this.valorT = consumoEnergia * valorP; // Valor total = consumo * preço por kWh
        } else {
            this.valorT = 0;
        }
    }

}


package com.calcenergia;

public class CalculaEnergia {
    private String nomeC, End;
    private double leitA, leitB, valorP, valorT, consEnerg;
    
    // Construtor
    public CalculaEnergia(String nomeC, String End, double leitA, double leitB, double valorP) {
        this.nomeC = nomeC;
        this.End = End;
        this.leitA = leitA;
        this.leitB = leitB;
        this.valorP = valorP;
    }
    
    // Métodos Get e Set
    public String getNomeC() {
        return nomeC;
    }
    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }
    public String getEnd() {
        return End;
    }
    public void setEnd(String End) {
        this.End = End;
    }
    public double getLeitA() {
        return leitA;
    }
    public void setLeitA(double leitA) {
        this.leitA = leitA;
    }
    public double getLeitB() {
        return leitB;
    }
    public void setLeitB(double leitB) {
        this.leitB = leitB;
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
    public double getConsEnerg() {
        return consEnerg;
    }
    
    // Método para calcular o consumo
    public void calculaConsumo() {
        if (leitB >= leitA) {
            this.consEnerg = leitB - leitA;
        } else {
            System.out.println("Leitura final não pode ser menor que a leitura inicial.");
            this.consEnerg = 0;
        }
    }
    
    // Método para calcular o valor total da conta
    public void calculaValorTotal() {
        calculaConsumo();
        if (consEnerg > 0) {
            this.valorT = consEnerg * valorP;
        } else {
            this.valorT = 0;
        }
    }
}

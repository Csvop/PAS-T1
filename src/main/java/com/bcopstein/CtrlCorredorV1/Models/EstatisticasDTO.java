package com.bcopstein.CtrlCorredorV1.Models;


public class EstatisticasDTO {
    private int quantidadeDeProvas;
    private double media;
    private double mediana;
    private double desvioPadrao;
    
    
    public EstatisticasDTO(int quantidadeDeProvas, double media, double mediana, double desvioPadrao) {
        this.media = media;
        this.mediana = mediana;
        this.desvioPadrao = desvioPadrao;
        this.quantidadeDeProvas = quantidadeDeProvas;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }

    public int getQuantidadeDeProvas() {
        return quantidadeDeProvas;
    }

    public void setQuantidadeDeProvas(int quantidadeDeProvas) {
        this.quantidadeDeProvas = quantidadeDeProvas;
    }

    @Override
    public String toString() {
        return "EstatisticasDTO [desvioPadrao=" + desvioPadrao + ", media=" + media + ", mediana=" + mediana
                + ", quantidadeDeProvas=" + quantidadeDeProvas + "]";
    }
    
    
}
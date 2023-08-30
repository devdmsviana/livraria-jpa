package br.edu.ifpb.ads.enums;

public enum StatusPedido {

    PENDENTE("Pendente"),
    PAGO("Pago"),
    FINALIZADO("Finalizado");

    private String descricao;
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}

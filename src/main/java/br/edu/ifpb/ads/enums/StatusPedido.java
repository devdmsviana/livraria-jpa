package br.edu.ifpb.ads.enums;

public enum StatusPedido {

    AGUARDANDO_PAGAMENTO("Pendente"),
    FINALIZADO("Finalizado");

    private final String descricao;
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}

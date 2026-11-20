package org.example;

public class EstabelecimentoBuilder {

    private Estabelecimento estabelecimento;

    public EstabelecimentoBuilder() {
        estabelecimento = new Estabelecimento();
    }

    public Estabelecimento build() {
        if (estabelecimento.getCodigo() == 0) {
            throw new IllegalArgumentException("Código inválido");
        }
        if (estabelecimento.getNome().equals("")) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (estabelecimento.getTaxaEntrega() < 0) {
            throw new IllegalArgumentException("Taxa de entrega inválida");
        }
        return estabelecimento;
    }

    public EstabelecimentoBuilder setCodigo(int codigo) {
        estabelecimento.setCodigo(codigo);
        return this;
    }

    public EstabelecimentoBuilder setNome(String nome) {
        estabelecimento.setNome(nome);
        return this;
    }

    public EstabelecimentoBuilder setCnpj(String cnpj) {
        estabelecimento.setCnpj(cnpj);
        return this;
    }

    public EstabelecimentoBuilder setTelefone(String telefone) {
        estabelecimento.setTelefone(telefone);
        return this;
    }

    public EstabelecimentoBuilder setEmail(String email) {
        estabelecimento.setEmail(email);
        return this;
    }

    public EstabelecimentoBuilder setEnderecoLogradouro(String enderecoLogradouro) {
        estabelecimento.setEnderecoLogradouro(enderecoLogradouro);
        return this;
    }

    public EstabelecimentoBuilder setEnderecoNumero(int enderecoNumero) {
        estabelecimento.setEnderecoNumero(enderecoNumero);
        return this;
    }

    public EstabelecimentoBuilder setEnderecoBairro(String enderecoBairro) {
        estabelecimento.setEnderecoBairro(enderecoBairro);
        return this;
    }

    public EstabelecimentoBuilder setEnderecoCidade(String enderecoCidade) {
        estabelecimento.setEnderecoCidade(enderecoCidade);
        return this;
    }

    public EstabelecimentoBuilder setEnderecoUF(String enderecoUF) {
        estabelecimento.setEnderecoUF(enderecoUF);
        return this;
    }

    public EstabelecimentoBuilder setHorarioAbertura(String horarioAbertura) {
        estabelecimento.setHorarioAbertura(horarioAbertura);
        return this;
    }

    public EstabelecimentoBuilder setHorarioFechamento(String horarioFechamento) {
        estabelecimento.setHorarioFechamento(horarioFechamento);
        return this;
    }

    public EstabelecimentoBuilder setAceitaDelivery(boolean aceitaDelivery) {
        estabelecimento.setAceitaDelivery(aceitaDelivery);
        return this;
    }

    public EstabelecimentoBuilder setTaxaEntrega(float taxaEntrega) {
        estabelecimento.setTaxaEntrega(taxaEntrega);
        return this;
    }

}

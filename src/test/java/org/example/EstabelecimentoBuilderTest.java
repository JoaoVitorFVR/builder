package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstabelecimentoBuilderTest {

    @Test
    void deveRetornarExcecaoParaEstabelecimentoSemCodigo() {
        try {
            EstabelecimentoBuilder builder = new EstabelecimentoBuilder();
            Estabelecimento estabelecimento = builder
                    .setNome("Pizzaria Centro")
                    .setEmail("centro@pizzaria.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Código inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaEstabelecimentoSemNome() {
        try {
            EstabelecimentoBuilder builder = new EstabelecimentoBuilder();
            Estabelecimento estabelecimento = builder
                    .setCodigo(1)
                    .setEmail("centro@pizzaria.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaTaxaDeEntregaNegativa() {
        try {
            EstabelecimentoBuilder builder = new EstabelecimentoBuilder();
            Estabelecimento estabelecimento = builder
                    .setCodigo(1)
                    .setNome("Pizzaria Centro")
                    .setAceitaDelivery(true)
                    .setTaxaEntrega(-5.0f)
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Taxa de entrega inválida", e.getMessage());
        }
    }

    @Test
    void deveRetornarEstabelecimentoValido() {
        EstabelecimentoBuilder builder = new EstabelecimentoBuilder();
        Estabelecimento estabelecimento = builder
                .setCodigo(1)
                .setNome("Pizzaria Centro")
                .setEmail("centro@pizzaria.com")
                .build();

        assertNotNull(estabelecimento);
    }

    @Test
    void deveRetornarEstabelecimentoComTodosOsDadosInformados() {
        Estabelecimento estabelecimento = new EstabelecimentoBuilder()
                .setCodigo(10)
                .setNome("Pizzaria Centro")
                .setCnpj("12.345.678/0001-90")
                .setTelefone("(32) 99999-0000")
                .setEmail("centro@pizzaria.com")
                .setEnderecoLogradouro("Av. Rio Branco")
                .setEnderecoNumero(100)
                .setEnderecoBairro("Centro")
                .setEnderecoCidade("Juiz de Fora")
                .setEnderecoUF("MG")
                .setHorarioAbertura("18:00")
                .setHorarioFechamento("23:30")
                .setAceitaDelivery(true)
                .setTaxaEntrega(8.0f)
                .build();

        assertEquals(10, estabelecimento.getCodigo());
        assertEquals("Pizzaria Centro", estabelecimento.getNome());
        assertEquals("12.345.678/0001-90", estabelecimento.getCnpj());
        assertEquals("(32) 99999-0000", estabelecimento.getTelefone());
        assertEquals("centro@pizzaria.com", estabelecimento.getEmail());
        assertEquals("Av. Rio Branco", estabelecimento.getEnderecoLogradouro());
        assertEquals(100, estabelecimento.getEnderecoNumero());
        assertEquals("Centro", estabelecimento.getEnderecoBairro());
        assertEquals("Juiz de Fora", estabelecimento.getEnderecoCidade());
        assertEquals("MG", estabelecimento.getEnderecoUF());
        assertEquals("18:00", estabelecimento.getHorarioAbertura());
        assertEquals("23:30", estabelecimento.getHorarioFechamento());
        assertTrue(estabelecimento.isAceitaDelivery());
        assertEquals(8.0f, estabelecimento.getTaxaEntrega());
    }

    @Test
    void deveManterValoresPadraoParaOsCamposNaoInformados() {
        Estabelecimento estabelecimento = new EstabelecimentoBuilder()
                .setCodigo(1)
                .setNome("Pizzaria Centro")
                .build();

        assertFalse(estabelecimento.isAceitaDelivery());
        assertEquals(0.0f, estabelecimento.getTaxaEntrega());
        assertNull(estabelecimento.getEnderecoCidade());
    }

    @Test
    void deveEncadearChamadasRetornandoOMesmoBuilder() {
        EstabelecimentoBuilder builder = new EstabelecimentoBuilder();

        assertSame(builder, builder.setCodigo(1));
        assertSame(builder, builder.setNome("Pizzaria Centro"));
    }

}

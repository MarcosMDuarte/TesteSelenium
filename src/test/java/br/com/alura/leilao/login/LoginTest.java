package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforEach () {
        this.paginaDeLogin = new LoginPage();
    }


    @AfterEach
    public void afterEach() {
        paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        paginaDeLogin.preencheFormularioDeLogin("fulano","pass");
        paginaDeLogin.efetuaLogin();

        ;
        Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
        Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());

    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos () {

        paginaDeLogin.preencheFormularioDeLogin("invalido","123");
        paginaDeLogin.efetuaLogin();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComErro());
        Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
        //Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));

    }

    // autorizações

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {

        paginaDeLogin.navegaParaPaginaDeLances();

        Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
        Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));


    }
}

package br.com.alura.leilao.ebx;

import org.openqa.selenium.chrome.ChromeDriver;

public class login {

    private static final String URL_LOGIN = "https://mdmcadastro.integrado.teste.bradesco.com.br/ebx-ui/ui/custom/Geral/action/87";
    private final ChromeDriver browser;

    public login() {
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }

}

package br.com.alura.leilao.ebx;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {

    private static final String URL_LOGIN = "https://mdmcadastro.integrado.teste.bradesco.com.br/ebx-ui/ui/custom/Geral/action/87";
    private ChromeDriver browser;

    @Test
    public void abrir () {
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
        browser.findElement(By.name("usuario_email")).sendKeys("curadoria");

    }
}



package br.com.alura.leilao.login;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private WebDriver browser;
    private static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }
    public void fechar() {
        this.browser.quit();
    }
    public void preencheFormularioDeLogin(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);

    }
    public LeiloesPage efetuaLogin() {
        browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(browser);

    }
    public boolean isPaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }
    public boolean isPaginaDeLoginComErro() {
        return browser.getCurrentUrl().equals(URL_LOGIN + "?error");

    }
    public String getNomeUsuarioLogado(){
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }
    public void navegaParaPaginaDeLances() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }


}


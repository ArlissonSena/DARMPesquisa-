package Acesso.formulario;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Teste Web Formulario")

public class TesteCamposObrigatorios {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        //Abrir o Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver 103\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        //Maximizar a Tela
        this.navegador.manage().window().maximize();
        //Definir um tempo de espera padrao de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Navegar para pagina da fakeLunch
        this.navegador.get("https://bit.ly/fake-lunch.");
    }
    @Test
    @DisplayName("Por favor, Marque os campos obrigatórios")
    public void testPreencherOsCamposObrigatorios(){
        //Como não há regra de negocio estabelecida nem criterios para preencher o formulario
        //Optei por preencher os campos obrigatorios com valores maximos e rodar o Teste

        //Preencher o Nome com "UsuarioTeste"
        navegador.findElement(By.cssSelector("input[jsname='YPqjbf']")).sendKeys("UsuarioTeste");
        //Selecionar valor máximo de nota na "experiencia conosco"
        navegador.findElement(By.xpath("(//div[@class='vd3tt'])[6]")).click();
        //Selecionar máximo de nota na recomendação da fakelunch
        navegador.findElement(By.xpath("(//div[@class='vd3tt'])[16]")).click();
        //Clicar para enviar Resposta
        navegador.findElement(By.xpath("(//div[@class='lRwqcd'])")).click();
        //Validar que a resposta foi registrada
        String textElement = navegador.findElement(By.xpath("//div[@class='vHW8K']")).getText();
        Assertions.assertEquals("Sua resposta foi registrada.", textElement);
    }
    @AfterEach
    public void afterEach(){
        //Fechar o navegador
        navegador.quit();
    }

}

package modulos.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Teste web do modulo de produtos")
public class ProdutosTest {
    private WebDriver navegador;
    @BeforeEach
    public void BeforeEach(){
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver103\\chromedriver.exe");
        this.navegador = new ChromeDriver();
        //Maximizar a Tela
        this.navegador.manage().window().maximize();
        // Definir tempo de espera padrao de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Navegar para pagina da lojinha web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2");

    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualaZero(){

        //Fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessaroFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Mackbook Pro")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("preto, branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor acima de 7000.00")
    public void testNaoEPermitidoRegistrarProdutoComValorAcimaDeSeteMil(){

        //Fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessaroFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Iphone")
                .informarValorDoProduto("700001")
                .informarCoresDoProduto("preto, azul")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam na faixa entre 0,01 e 7000.00")
    public void testPossoAdicionarProdutosComValorDeUmCentavoaSeteMil(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessaroFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("30000")
                .informarCoresDoProduto("preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarmensagemApresentada();
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);



    }

    @AfterEach
    public void AfterEach(){
        //Fechar navegador
        //navegador.quit();
    }
}

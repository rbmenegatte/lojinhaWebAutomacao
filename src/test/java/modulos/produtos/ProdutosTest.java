package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        // Vou maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a pagina da Lojinha web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a R$0,00")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {
        // Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicionarNovoProduto()
                .informarNomeDoProduto("Produto09072022")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("preto, branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor maior que 7.000,00")
    public void testNaoEPermitidoRegistrarProdutoComValorSuperiorASeteMil(){

        // Vou fazer o login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicionarNovoProduto()
                .informarNomeDoProduto("Produto08072022")
                .informarValorDoProduto("700002")
                .informarCoresDoProduto("preto,azul")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Adicao de produto com valor na faixa de R$0,01 a R$7.000,00")
    public void testAdicionarProdutosComValorDeUmCentavoASeteMilReais(){
       String mensagemApresentada =  new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicionarNovoProduto()
                .informarNomeDoProduto("SouEuTestandoNoSabado")
                .informarValorDoProduto("0001")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

       Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @Test
    @DisplayName("Adicao de produto com o valor limite de R$7.000,00")
    public void testAdicionarProdutoComValorDeSeteMilReais(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicionarNovoProduto()
                .informarNomeDoProduto("SouEuTestandoNoSabadoDeNovo")
                .informarValorDoProduto("700000")
                .informarCoresDoProduto("preto,amarelo")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }

    @AfterEach
    public void afterEach(){
        // Vou fechar o navegador
        navegador.quit();
    }

}




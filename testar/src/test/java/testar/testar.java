package testar;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testar {

	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {


		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http:/www.automationpractice.com");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		// Selecionando o Produto
		WebElement produto = driver.findElement(By.linkText("Blouse"));
		produto.click();

		// Adicionando o produto ao carrinhp
		WebElement carrinho = driver.findElement(By.name("Submit"));
		carrinho.click();

		// Esperando o elemento ficar visivel
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Proceed to checkout")));

		// Seguindo para o checkou
		WebElement checkout = driver.findElement(By.partialLinkText("Proceed to checkout"));
		checkout.click();

		// Validando o produto adicionado ao carrinho
		WebElement valida = driver.findElement(By.name("quantity_2_7_0_0"));

		assertEquals(1, Double.parseDouble(valida.getAttribute("value")), 0);

		// Seguido
		WebElement prossegue = driver.findElement(By.partialLinkText("Proceed to checkout"));
		prossegue.click();

		// Criando email
		WebElement email = driver.findElement(By.id("email_create"));
		email.sendKeys("teste@SeleniumDB.com.br");

		WebElement cria = driver.findElement(By.id("SubmitCreate"));
		cria.click();

		// Espera

		WebDriverWait espera = new WebDriverWait(driver, 10);
		espera.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));

		// PREENCHENDO CADASTRO

		// Titulo
		WebElement titulo = driver.findElement(By.id("id_gender2"));
		titulo.click();

		// Nome
		WebElement nome = driver.findElement(By.id("customer_firstname"));
		nome.sendKeys("Carolina");

		// Sobrenome
		WebElement sobrenome = driver.findElement(By.id("customer_lastname"));
		sobrenome.sendKeys("Almeida");

		// Senha
		WebElement senha = driver.findElement(By.id("passwd"));
		senha.sendKeys("123456");

		// Dia aniversário
		Select dia = new Select(driver.findElement(By.id("days")));
		dia.selectByVisibleText("23  ");

		// Mes
		Select mes = new Select(driver.findElement(By.id("months")));
		mes.selectByVisibleText("September ");

		// Ano
		Select ano = new Select(driver.findElement(By.id("years")));
		ano.selectByVisibleText("1999  ");

		// Check box
		WebElement seleciona = driver.findElement(By.id("optin"));
		seleciona.click();

		// Empresa
		WebElement empresa = driver.findElement(By.id("company"));
		empresa.sendKeys("Teste");

		// Endereço
		WebElement endereco = driver.findElement(By.id("address1"));
		endereco.sendKeys("Santa Barbara");

		// Validado Endereço

		assertEquals("Santa Barbara", (endereco.getAttribute("value")));

		// Endereço 2
		WebElement endereco2 = driver.findElement(By.id("address2"));
		endereco2.sendKeys("Casa");

		// Cidade
		WebElement cidade = driver.findElement(By.id("city"));
		cidade.sendKeys("Charqueadas");

		// Selciona Estado
		Select select = new Select(driver.findElement(By.id("id_state")));
		select.selectByVisibleText("California");

		// Cep
		WebElement cep = driver.findElement(By.id("postcode"));
		cep.sendKeys("96745");

		// Informações Adicionais
		WebElement informação = driver.findElement(By.id("other"));
		informação.sendKeys("Informações adicionais");

		// Telefone fixo
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("36586809");

		// Telefone movel
		WebElement phone2 = driver.findElement(By.id("phone_mobile"));
		phone2.sendKeys("995100266");

		// Email alternativo
		WebElement email2 = driver.findElement(By.id("alias"));
		email2.sendKeys("teste@email.com");

		// Clica
		WebElement criar = driver.findElement(By.id("submitAccount"));
		criar.click();

		// Clica
		WebElement processar = driver.findElement(By.name("processAddress"));
		processar.click();

		// Clica
		WebElement termos = driver.findElement(By.id("cgv"));
		termos.click();

		// Clica
		WebElement proximo = driver.findElement(By.name("processCarrier"));
		proximo.click();

		// Valida Valor
		WebElement valor = driver.findElement(By.id("total_price_container"));
		assertEquals("$29.00", valor.getText());

		// Seleciona tipo de pagamento
		WebElement pagamento = driver.findElement(By.className("bankwire"));
		pagamento.click();

		// Confirma Compra
		WebElement confirma = driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button"));
		confirma.click();

		// Validar Compra
		WebElement textoElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong"));
		assertEquals("Your order on My Store is complete.", textoElement.getText());

	}

}

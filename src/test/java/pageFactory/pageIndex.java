package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageIndex {

    WebDriver driver;
    WebDriverWait wait;

    public pageIndex(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement textCorreo;

    @FindBy(xpath = "//*[@id=\"pass\"]")
    public WebElement textPass;

    @FindBy(xpath = "//*[@id=\"loginbutton\"]")
    public WebElement btnIngresar;

    @FindBy(xpath = "//*[@id=\"userNavigationLabel\"]")
    public WebElement btnMenuPerfil;

    //@FindBy(xpath = "//*[@id=\"u_7_3\"]")
    //public WebElement btnCerrarSesion;

    @FindBy(xpath = "//*[@id=\"facebook\"]/body")
    public WebElement bodyFacebook;

    @FindBy(xpath = "//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']")
    public WebElement btnCerrarSesion;
}

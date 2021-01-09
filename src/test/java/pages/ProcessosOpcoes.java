package pages;

import org.openqa.selenium.By;
import support.DriverQA;

public class ProcessosOpcoes {
    private DriverQA driver;

    public ProcessosOpcoes(DriverQA driverQA) {
        driver = driverQA;
    }

    public void botaoNovoProcesso() {
        driver.click("btn-novo");
    }
    public void botaoMostrar(String code){
        driver.click("btn-show_"+code);
    }
    public void botaoEditar(String code){
        driver.click("btn-edit_"+code);
    }
    public void botaoDeletar(String code){
        driver.click("btn-delete_"+code);
    }
    public void confirmaDelecao(){
        driver.ChooseOkOnNextConfirmation();
    }
    public boolean existeBotaoApagar(String code){
        boolean respose = true;
        try{
            respose = driver.getDriver().findElement(By.id("btn-delete_"+code)).isDisplayed();

        }catch (Exception e){
            respose = false;
        }

        return respose;
    }

}


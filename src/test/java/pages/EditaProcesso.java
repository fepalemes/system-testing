package pages;
import support.DriverQA;

public class EditaProcesso {
    private DriverQA driver;

    public EditaProcesso(DriverQA driverQA) {
        driver = driverQA;
    }
    public void preencherCampo(String campo, String valor) {
        driver.sendKeys(valor, campo);
    }

    public void clicarSalvar() {
        driver.click("#btn-save" ,"css");
    }

}

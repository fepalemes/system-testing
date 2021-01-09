package pages;
import support.DriverQA;

public class ProcessosMostrar {
    private final DriverQA driver;

    public ProcessosMostrar(DriverQA driverQA) {
        driver = driverQA;
    }

    public String recuperarMensagemDeSucesso() {
        return driver.getText("notice");
    }
    public String recuperaCodigo() {
        return driver.getText("codigo");
    }

    public void clicarVoltar() {
        driver.click(".ls-btn-primary-danger","css");
    }

    public String getField(String field){
        return driver.getText(field);
    }
}

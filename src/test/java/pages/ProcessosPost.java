package pages;

import support.DriverQA;

public class ProcessosPost {
    private DriverQA driver;
    private  String processoCode;

    public ProcessosPost(DriverQA driverQA) {
        driver = driverQA;
    }
    public void preencherCampo(String campo, String valor) {
        driver.sendKeys(valor, campo);
    }

    public void clicarSalvar() {
        driver.click("#btn-save" ,"css");
    }

    public void selecionarUrgencia(String valor) {
        driver.selectByText(valor, "processo_urgente");
    }

    public void clicarArbitramentoSim() {
        driver.click("processo_arbitramento_s");
    }
    public void setCode(String code){
         processoCode = code;
    }
    public String getCode(){
        return processoCode;
    }
}

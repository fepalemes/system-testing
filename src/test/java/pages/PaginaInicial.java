package pages;

import support.DriverQA;

public class PaginaInicial extends BasePage {

    private String url = "http://agapito-server.herokuapp.com/";

    public PaginaInicial(DriverQA stepDriver){
        super (stepDriver);
    }

    public void abrirPagina() {
        driver.openURL(url);
    }
}




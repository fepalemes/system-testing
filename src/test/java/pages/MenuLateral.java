package pages;

import support.DriverQA;

public class MenuLateral {
    private DriverQA driver;

    public MenuLateral(DriverQA stepDriver){
        driver = stepDriver;
    }

    public void clicarMenuLateral(String vMenu) {
        driver.click(vMenu);
    }
}

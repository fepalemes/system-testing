package pages;

import support.DriverQA;

public class MenuLateral extends BasePage{


    public MenuLateral(DriverQA stepDriver){
        super(stepDriver);
    }

    public void clicarMenuLateral(String vMenu) {
        driver.click(vMenu);
    }
}

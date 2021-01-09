package pages;

import support.DriverQA;

public class BasePage {
    final DriverQA driver;

    BasePage(DriverQA stepDriver) {
        this.driver = stepDriver;
    }
}

package global;

import java.util.function.Function;
import org.openqa.selenium.By;

public abstract class EvolveBasePage extends BasePage {

    private By hamburgerButton;
    private Function<String, By> menuItemWithTitle;

    public EvolveBasePage () {
        super();

        if (onAndroid) {
            hamburgerButton = By.id("OK");
            menuItemWithTitle = title -> By.xpath(String.format("//android.widget.CheckedTextView[@text='%s']", title));
        }

        if (oniOS) {
            menuItemWithTitle = title -> By.xpath(String.format("//UIATabBar//UIAButton[@name='%s']", title));
        }
    }

    public void selectMenuItem(String title) {
        if (onAndroid) {
            driver.findElement(hamburgerButton).click();
            label("Menu Opened");
        }

        driver.findElement(menuItemWithTitle.apply(title)).click();
        label(String.format("Tapped menu item with title: %s", title));
    }
}

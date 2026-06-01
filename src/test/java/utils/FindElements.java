package utils;


// class in progress the definition
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements {



    public static WebElement findElementByText(
            List<WebElement> elements,
            By childLocator,
            String expectedText) {

        return elements.stream()
                .filter(element ->
                        element.findElement(childLocator)
                                .getText()
                                .trim()
                                .equals(expectedText))

                .findFirst()
                .orElse(null);

    }


}

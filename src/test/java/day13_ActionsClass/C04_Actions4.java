package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {
     /*
https://jqueryui.com/droppable/ adresine gidin
"Drag me to my target" elementini "Drop here" elementi üzerine dragAndDrop ile bırakınız.
 */
    @Test
    public void test01(){
        driver.get("https://jqueryui.com/droppable/");
        //sayfada iframe olduğu için switch yapmamız gerekiyor.
        driver.switchTo().frame(0);
        //kaynak ve hedef web elementlerini locate ediyoruz
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droppable"));
        //çekme pırakma için Actions clasından obje oluşturup dargAndDrop methodu kullanıyoruz.
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,target);
    }
}

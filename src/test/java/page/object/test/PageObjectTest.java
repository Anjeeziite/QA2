package page.object.test;

import org.junit.jupiter.api.Test;
import page.object.BaseFunc;

public class PageObjectTest {
    @Test
    public void pageObjectTest(){
        BaseFunc bf = new BaseFunc();
        bf.openPage("delfi.lv");
        bf.closeBrowser();
    }
}

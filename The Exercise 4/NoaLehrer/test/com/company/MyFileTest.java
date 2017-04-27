package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by hackeru on 3/14/2017.
 */
class MyFileTest {


    @Test
    void checkMyFile_notPath() {
        FileHandler file = new FileHandler("aa45415a");
        if (file.check())
            Assertions.fail("not path");
    }
    @Test
    void checkMyFile_notFile() {
        FileHandler file = new FileHandler("C:\\Users\\hackeru.HACKERU3\\Downloads\\2017_01_idf-master (1)");
        if (!file.check())
            Assertions.fail("not file");
    }
    @Test
    void checkMyFile_notExist() {
        FileHandler file = new FileHandler("C:\\eclipse\\ddddd");
        if (file.check())
            Assertions.fail("Path doesn't exist ");
    }
    @Test
    void checkMyFile_pathExist() {
        FileHandler file = new FileHandler("C:\\eclipse\\features\\org.eclipse.e4.rcp_1.4.1.v20160212-1350\\feature.xml");
        if (!file.check())
            Assertions.fail("Path exists ");
    }
}
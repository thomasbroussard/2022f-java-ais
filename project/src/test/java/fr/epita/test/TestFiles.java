package fr.epita.test;

import org.junit.jupiter.api.Test;

import java.io.File;

public class TestFiles {

    //sandbox test
    @Test
    public void testTemplate(){
        // 0. technical setup

        // 1. hypothesis - given

        // 2. action - when

        // 3. verification - then

        // 4. clean
    }

    @Test
    public void testFile(){
        File file = new File("test.save");
        if (file.exists()){
            System.out.println("exists");
        } else {
            System.out.println("does not exist");
        }



    }


}

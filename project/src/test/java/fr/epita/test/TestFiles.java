package fr.epita.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

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
    public void testFile() throws IOException {

        //given
        File file = new File("test.save");
        try {
            if (!Files.exists(file.toPath())) {
                Files.createFile(file.toPath());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //then
//        if (file.exists()){
//            System.out.println("exists");
//        } else {
//            System.out.println("does not exist");
//        }

        Assertions.assertTrue(file.exists());

        //clean
        Files.delete(file.toPath());
    }


}

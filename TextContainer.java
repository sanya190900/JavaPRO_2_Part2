package com;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "test.txt")
public class TextContainer {
    private String input;

    public TextContainer(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
    @Saver
    public void save(String path){
        try(FileWriter writer = new FileWriter(path, false)){
            writer.write(input);
            System.out.println("Content \"" + input + "\" is successfully written to \"" + path + "\"");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package hu.ittc.training.dictionary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReader {

    public void readDictionaryFile(String filePath) {
        FileInputStream ownerFile = new FileInputStream(filePath);
        InputStreamReader ir = new InputStreamReader(ownerFile);
        BufferedReader br = new BufferedReader(ir);

    }
}

package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Game {
    static StringBuilder log = new StringBuilder();

    public static void makeNewDir(String pathname) {
        File dir = new File(pathname);
        Date date = new Date();
// пробуем создать каталог
        if (dir.mkdir())
            log.append(date + " каталог " + dir.getName() + " успешно создан в директории " + dir.getParent() + '\n');
        else
            log.append(date + " каталог " + dir.getName() + " НЕ создан в директории " + dir.getParent() + '\n');

    }

    public static void makeNewFile(String pathname) {
        File file = new File(pathname);
        Date date = new Date();

        // создадим новый файл
        try {
            if (file.createNewFile())
                log.append(date + " файл " + file.getName() + " успешно создан в директории " + file.getParent() + '\n');
        } catch (IOException ex) {
            log.append(date + " файл " + file.getName() + " НЕ создан в директории " + file.getParent() + ". " +
                    ex.getMessage() + '\n');
        }


    }

    public static void buildLog(StringBuilder log) {
        try (FileWriter writer = new FileWriter("Games//temp/temp.txt", false)) {
            // запись всей строки
            writer.write(String.valueOf(log));
            // дозаписываем и очищаем буфер
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }


}

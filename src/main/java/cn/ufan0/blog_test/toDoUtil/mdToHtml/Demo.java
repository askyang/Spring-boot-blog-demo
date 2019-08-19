package cn.ufan0.blog_test.toDoUtil.mdToHtml;

import java.io.*;
public class Demo {
    public static void main(String[] args) throws IOException {
        String str = new StringToHtml().stringToHtml("C:\\Users\\Darksails\\Desktop\\Temp Code\\mdtohtml\\src\\main\\resources\\a.md");
        File file = new File("C:\\Users\\Darksails\\Desktop\\Temp Code\\mdtohtml\\src\\main\\resources\\a.html");
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println(str);
    }
}
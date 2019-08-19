package cn.ufan0.blog_test.toDoUtil.mdToHtml;

import java.io.*;
class MdToString {

    StringBuilder mdToString(String filePath) throws IOException {

        /*
        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fin, StandardCharsets.UTF_8);
        BufferedReader buffReader = new BufferedReader(reader);

        String strTmp = "";
        StringBuilder html = new StringBuilder();
        while ((strTmp = buffReader.readLine()) != null) {
            html.append(strTmp).append("\n");
        }
        buffReader.close();
        reader.close();
        fin.close();
        */

        StringBuilder html = new StringBuilder();
        String string = "";

        // 在给定从中读取数据的文件名的情况下创建一个新 FileReader
        FileReader fr = new FileReader(filePath);
        // 创建一个使用默认大小输入缓冲区的缓冲字符输入流
        BufferedReader br = new BufferedReader(fr);
        while (null != (string = br.readLine())) {
            // 按行读取拼接，并加上换行符，否则无法正常解析
            html.append(string).append("\n");
        }
        // 关闭流，节约资源
        br.close();
        fr.close();

        return html;
    }

}

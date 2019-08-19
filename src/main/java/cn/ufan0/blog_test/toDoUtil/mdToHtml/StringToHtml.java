package cn.ufan0.blog_test.toDoUtil.mdToHtml;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.io.IOException;

class StringToHtml {

    String stringToHtml(String str) throws IOException {
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node node = parser.parse(new MdToString().mdToString(str).toString());
        return renderer.render(node);
    }
}

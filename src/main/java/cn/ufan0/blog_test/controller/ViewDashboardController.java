package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewDashboardController {

    @Autowired
    private InformationService informationService;

    @Autowired
    private UserService userService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CauserieService causerieService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    /**
     * 后台首页
     */
    @RequestMapping("/")
    public String index(Model model) {
        // sidebar选中
        model.addAttribute("index_active", "active");
        // 网页标题
        model.addAttribute("headTitle", "仪表盘");
        // 发送用户信息
        model.addAttribute("informationService", informationService);
        // 展示用户信息
        model.addAttribute("user", userService.getUser());
        // 展示站点信息
        model.addAttribute("site", siteService.getSite());
        return "index";
    }

    /**
     * 后台文章页
     */
    @RequestMapping("/article")
    public String article(Model model) {
        model.addAttribute("article_active", "active");
        model.addAttribute("headTitle", "文章");
        // 为了提高速度，返回所有文章是不带有正文的
        model.addAttribute("articles", articleService.getAllArticle());
        // 展示基本信息
        model.addAttribute("informationService", informationService);
         /*
         编辑框，需要显示已经保存的内容，要带上正文，得在html调用getArticle()才能拿到正文，按需调用。
         model.addAttribute("articleService", articleService);
         编辑页面单独设计，此方案作废
         */
        return "article";
    }

    /**
     * 后台编辑文章页
     */
    @RequestMapping("/article/editArticle")
    public String editArticle(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("article_active", "active");
        model.addAttribute("headTitle", "编辑文章");
        model.addAttribute("article", articleService.getArticle(id));
        return "article/editArticle";
    }

    /**
     * 后台增加文章页
     */
    @RequestMapping("/article/addArticle")
    public String addArticle(Model model) {
        model.addAttribute("article_active", "active");
        model.addAttribute("headTitle", "新增文章");
        return "article/addArticle";
    }

    /**
     * 后台文章标签页
     */
    @RequestMapping("/article/tag")
    public String tag(Model model) {
        model.addAttribute("article_active", "active");
        model.addAttribute("headTitle", "文章标签");
        model.addAttribute("tags", tagService.getTag());
        return "article/tag";
    }

    /**
     * 后台文章分类页
     */
    @RequestMapping("/article/category")
    public String category(Model model) {
        model.addAttribute("article_active", "active");
        model.addAttribute("headTitle", "文章分类");
        model.addAttribute("categories", categoryService.getCategory());
        return "article/category";
    }

    /**
     * 后台随笔
     */
    @RequestMapping("/causerie")
    public String causerie(Model model) {
        model.addAttribute("causerie_active", "active");
        model.addAttribute("headTitle", "随笔");
        model.addAttribute("causeries",causerieService.getAllCauserie());
        return "causerie";
    }

    /**
     * 后台用户资料页
     */
    @RequestMapping("/user")
    public String user(Model model) {
        model.addAttribute("user_active", "active");
        model.addAttribute("headTitle", "用户资料");
        model.addAttribute("user", userService.getUser());
        return "user";
    }

    /**
     * 后台站点信息页
     */
    @RequestMapping("/site")
    public String site(Model model) {
        model.addAttribute("site_active", "active");
        model.addAttribute("headTitle", "站点信息");
        model.addAttribute("site", siteService.getSite());
        return "site";
    }

}

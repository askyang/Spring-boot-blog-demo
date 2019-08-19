package cn.ufan0.blog_test.controller;

import cn.ufan0.blog_test.entity.Causerie;
import cn.ufan0.blog_test.service.CauserieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
public class CauserieController {

    @Autowired
    private CauserieService causerieService;

    @GetMapping("/causerie")
    public Object getCauserie(@RequestParam(value = "id", required = false) Integer id) {
        if (id == null) {
            return causerieService.getAllPublicCauserie();
        } else {
            return causerieService.getCauserie(id);
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("/causerie")
    public void addCauserie(Causerie causerie) {
        if (causerie.getContent() != null && !causerie.getContent().equals("")) {
            causerieService.addCauserie(causerie);
        }
    }

    @Secured("ROLE_USER")
    @PutMapping("/causerie")
    public void updateCauserie(Causerie causerie) {
        // 当修改了内容时，才更新最后编辑时间
        if (causerie.getContent() != null && !causerie.getContent().equals("")) {
            causerie.setLast_update_time(new Timestamp(System.currentTimeMillis()));
        }
        causerieService.updateCauserie(causerie);
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/causerie")
    public void deleteCauserie(Integer id) {
        causerieService.deleteCauserie(id);
    }

}

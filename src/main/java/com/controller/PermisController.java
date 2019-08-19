package com.controller;

import com.domain.Permis;
import com.service.PermisService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PermisController {

    @Resource(name = "permisServiceImpl")
    PermisService permisService;

    /**
     * 菜单管理
     *
     * @param request
     * @return
     */
    @RequiresAuthentication
    @RequiresPermissions(value = "permis:menu")
    @ResponseBody
    @RequestMapping("/permismenu")
    public List<Permis> permisMenu(HttpServletRequest request, Permis permis) {
        permis.setParent((permis.getParent()==null)?0:permis.getParent());
        permis.setPermistype(1);//只查询为1的，表示菜单
        List<Permis> permisList = permisService.selectPermisByParent(permis);
        return permisList;
    }

    @RequiresAuthentication
    @RequiresPermissions(value = "permis:add")
    @RequestMapping("/addpermismenu")
    public String addpermisMenu(Permis permis){
        permisService.insertSelective(permis);
        return "redirect:/view/permismenu.jsp";
    }
}

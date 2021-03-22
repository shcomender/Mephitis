package com.jijuwuhua.myblog.web;

import com.jijuwuhua.myblog.pojo.Tag;
import com.jijuwuhua.myblog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author ：chenjiajun
 * @description：标签控制器
 * @date ：2021/3/22 15:40
 */
@Controller
@RequestMapping("/admin")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    /**
    * @Description: 获取全部标签信息，并通过pageble进行分类，传回前端
    * @Param: [pageable, model]
    * @return: java.lang.String
    * @Author: chenjiajun
    * @Date: 2021/3/22
    */
    @GetMapping("/tags")
    public String listTags(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.ASC)
                           Pageable pageable, Model model){
        model.addAttribute("page",tagsService.listPage(pageable));
        return "admin/types";
    }

    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tags",new Tag());
        return "admin/tags-input";
    }

    /**
    * @Description: 插入映射，在已经有了前端校验的基础上，进行valid springboot非空校验
     * bindingresult返回错误结果,和后端查询重复校验
    * @Param: [tag, bindingResult, redirectAttributes]
    * @return: java.lang.String
    * @Author: chenjiajun
    * @Date: 2021/3/22
    */
    @PostMapping("/tags")
    public String post(@Valid Tag tag,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){
        //进行重复校验
        Tag t = tagsService.getTagByName(tag.getName());
        if(t != null){
            bindingResult.rejectValue("name","errorName","标签名称已经存在");
        }

        if (bindingResult.hasErrors()){
            //如果已经出现错误了，将页面跳转回tags-input,从rejectValue里面取错误信息
            return "admin/tags-input";
        }
        //验证没有重复就插入表中
        Tag tag1 = tagsService.save(t);
        if (t == null){
            redirectAttributes.addFlashAttribute("message","插入失败");
        }
        else {
            redirectAttributes.addFlashAttribute("message","插入成功");
        }
        //验证不出错，回到查询全部的页面
        return "redirect:/admin/tags";
    }

    /**
    * @Description: @Description: 按照id更新id,实际操作是共享新建id的页面，但是修改form表单的提交方法
      * 公用一个页面
    * @Param: [id, model]
    * @return: java.lang.String
    * @Author: chenjiajun
    * @Date: 2021/3/22
    */
    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable long id,Model model){
        model.addAttribute("tag",tagsService.getTag(id));
        return "admin/tags-input";
    }

}

package com.jijuwuhua.myblog.web;

import com.jijuwuhua.myblog.pojo.Type;
import com.jijuwuhua.myblog.service.TypeService;
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
 * @description：分类控制器
 * @date ：2021/3/20 23:33
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private  TypeService typeService ;

    //注意pageable的导包
    /**
    * @Description: 分页获取types数据
    * @Param: [pageable, model]
    * @return: java.lang.String
    * @Author: chenjiajun
    * @Date: 2021/3/21
    */
    @GetMapping("/types")
    public String list(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC)
                                   Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }

    /**
    * @Description: 访问添加类型页面，
     * 但是由于需要使用一个标志性的type来标志出现非法的类型名称时进行错误提醒，
     * 所以需要传入一个空的type对象
    * @Param: [model]
    * @return: java.lang.String
    * @Author: chenjiajun
    * @Date: 2021/3/22
    */
    @GetMapping("/types/input")
    public  String iput(Model model){
        //这里传入type是由于在插入类型名字非法的时候会传入页面一个
        //type对象，由th模板获取，为保证访问不报错，这里必须传入一个空对象
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    /**
    * @Description: 插入新的类型,bindingResult一定要跟着type否则无法进行校验
     * 要在需要进行校验的Bean前面加上@Valid注解
     * 每个需要校验的Bean后面紧跟一个BindingResult，SpringMVC框架会将校验结果保存在它里面，
     * 通过hasErrors方法可以判断是否有校验错误；
     * valid对传入的实体类对象进行后端自动验证非空，需要在实体类中加入相关注解和自定义错误
    * @Param: [type]
    * @return: java.lang.String
    * @Author: chenjiajun
    * @Date: 2021/3/21
    */
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes  redirectAttributes){
        //服务端重复校验
        Type type1 = typeService.getTypeByName(type.getName());
        if(type1 != null){
            //rejectValue 参数名称  英文描述  中文描述
            result.rejectValue("name","nameError","该分类不能重复添加");
        }

        //进行输入的后端校验，出现错误就返回到插入页面
        if (result.hasErrors()){
            return "admin/types-input";
        }

        Type t = typeService.saveType(type);
        if(t == null){
            redirectAttributes.addFlashAttribute("message","操作失败");
        }else{
            redirectAttributes.addFlashAttribute("message","操作成功");
        }
        return  "redirect:/admin/types";
    }

    //根据id修改type,共用types-input页面
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }

    /**
    * @Description: 修改类型提交
    * @Param: [type, result, id, attributes]
    * @return: java.lang.String
    * @Author: chenjiajun
    * @Date: 2021/3/22
    */
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes) {
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/types-input";
        }
        Type t = typeService.updateType(id,type);
        if (t == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}

package xyz.ariesfish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.ariesfish.domain.Account;
import xyz.ariesfish.service.IAccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService IAccountService;

    @RequestMapping("findAll")
    public String findAll(Model model) {
        System.out.println("Controller: findAll");
        // 调用service方法，依赖注入
        List<Account> list = IAccountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("saveAccount")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Controller: saveAccount");
        // 调用service方法，依赖注入
        IAccountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }
}

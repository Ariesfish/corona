package xyz.ariesfish.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.ariesfish.domain.Account;
import xyz.ariesfish.service.IAccountService;

public class AccountTest {
    private ApplicationContext context;
    private IAccountService IAccountService;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IAccountService = (IAccountService) context.getBean("accountService");
    }

    @Test
    public void testFinaAll() {
        IAccountService.findAll();
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setUid(10);
        account.setMoney(2500.0f);
        IAccountService.saveAccount(account);
    }
}

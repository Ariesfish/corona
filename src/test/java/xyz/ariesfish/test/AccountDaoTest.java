package xyz.ariesfish.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import xyz.ariesfish.dao.AccountDao;
import xyz.ariesfish.domain.Account;

import java.io.InputStream;
import java.util.List;

public class AccountDaoTest {
    private InputStream in;
    private SqlSession session;
    private AccountDao dao;

    @Before
    public void init() throws Exception {
        // 加载配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        session = factory.openSession();
        // 获取代理对象
        dao = session.getMapper(AccountDao.class);
    }

    @After
    public void release() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void testFindAll() {
        // 查询所有的数据
        List<Account> list =  dao.findAll();
        for (Account account: list) {
            System.out.println(account);
        }
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setId(10);
        account.setMoney(2500.0f);
        dao.saveAccount(account);
    }
}


package xyz.ariesfish.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xyz.ariesfish.domain.Account;

import java.util.List;

@Repository()
public interface AccountDao {

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account (id,uid,money) values (#{id},#{uid},#{money})")
    void saveAccount(Account account);
}

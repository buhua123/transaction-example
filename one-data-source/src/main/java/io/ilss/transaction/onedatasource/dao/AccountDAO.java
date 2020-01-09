package io.ilss.transaction.onedatasource.dao;

import io.ilss.transaction.onedatasource.entities.AccountDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountDAO {
    int deleteByPrimaryKey(Long id);

    int insert(AccountDO record);

    int insertSelective(AccountDO record);

    AccountDO selectByPrimaryKey(Long id);

    List<AccountDO> selectAll();

    int updateByPrimaryKeySelective(AccountDO record);

    int updateByPrimaryKey(AccountDO record);

}
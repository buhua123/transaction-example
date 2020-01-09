package io.ilss.transaction.onedatasource.service;

import io.ilss.transaction.onedatasource.entities.AccountDO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author feng
 */
public interface AccountService {


    String transferAnnotation(Long sourceAccountId, Long targetAccountId, BigDecimal amount);


    String transferCode(Long sourceAccountId, Long targetAccountId, BigDecimal amount);

    List<AccountDO> listAll();

}

package io.ilss.transaction.onedatasource.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * account
 * @author feng
 */
@Data
public class AccountDO implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
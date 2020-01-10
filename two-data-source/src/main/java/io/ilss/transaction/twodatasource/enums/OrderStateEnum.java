package io.ilss.transaction.twodatasource.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author feng
 */
@Getter
@AllArgsConstructor
public enum  OrderStateEnum {
    // 状态0-新订单创建 1-已付款 2-已发货 3-已确认签收付款  -1-订单取消 -2 支付失败 -3 退货  9-订单完成
    RETURNS(-3, "RETURNS"),
    PAY_FAILED(-2, "PAY_FAILED"),
    CANCEL(-1, "CANCEL"),
    NEW(0,"NEW"),
    PAID(1, "PAID"),
    SHIPPED(2, "SHIPPED"),
    RECEIVED(3, "RECEIVED"),


    COMPLETED(9, "COMPLETED"),
    ;

    private Integer state;
    private String desc;

}

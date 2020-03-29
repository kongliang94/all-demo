package cn.itcast.dtx.txmsgdemo.bank2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountChangeEvent implements Serializable {
    /**
     * 转出账号
     */
    private String accountNoOut;
    /**
     * 转入账号
     */
    private String accountNoIn;
    /**
     * 变动金额
     */
    private double amount;
    /**
     * 事务号
     */
    private String txNo;

}

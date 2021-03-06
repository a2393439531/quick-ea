package com.bugjc.ea.qrcode.web.req;

import lombok.Data;

import java.util.Date;

/**
 * 订单
 * @author aoki
 */
@Data
public class OrderRequest {
    /**
     * 主键
     */
    private Long id;

    /**
     * 版本
     */
    private String version;

    /**
     * 签名
     */
    private String signature;

    /**
     * 算法类型
     */
    private String signType;

    /**
     * 证书id
     */
    private String certId;

    /**
     * 交易类型
     */
    private String reqType;

    /**
     * 原交易类型
     */
    private String origReqType;

    /**
     * 交易序列号
     */
    private String txnNo;

    /**
     * C2B码
     */
    private String qrNo;

    /**
     * 交易币种
     */
    private String currencyCode;

    /**
     * 交易金额
     */
    private Double txnAmt;

    /**
     * 原交易应答码
     */
    private String origRespCode;

    /**
     * 原交易应答信息
     */
    private String origRespMsg;

    /**
     * 商户代码
     */
    private String merId;

    /**
     * 商户类别
     */
    private String merCatCode;

    /**
     * 商户名称
     */
    private String merName;

    /**
     * 终端号
     */
    private String termId;

    /**
     * 付款凭证号
     */
    private String voucherNum;

    /**
     * 清算主键
     */
    private String settleKey;

    /**
     * 清算日期
     */
    private String settleData;

    /**
     * 银行对账流水信息
     */
    private String comInfo;

    /**
     * 请求方自定义域
     */
    private String reqReserved;

    /**
     * 优惠信息
     */
    private String couponInfo;

    /**
     * 初始交易金额
     */
    private Double origTxnAmt;

    /**
     * 应答码
     */
    private String respCode;

    /**
     * 响应信息
     */
    private String respMsg;

    /**
     * 扣账币种
     */
    private String cdhdCurrCd;

    /**
     * 扣账汇率
     */
    private String cdhdConvRt;

    /**
     * 扣账金额
     */
    private Double cdhdAmt;

    /**
     * 清算币种
     */
    private String settleCurrCode;

    /**
     * 清算汇率
     */
    private String settleConvRate;

    /**
     * 清算金额
     */
    private Double settleAmt;

    /**
     * 兑换日期
     */
    private Date convDate;

    /**
     * EMV 二维码
     */
    private String emvQrCode;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 授权标识应答码
     */
    private String authIdRespCd;

    /**
     * 收款方附加数据
     */
    private String acpAddnData;

    /**
     * 创建时间
     */
    private Date createTime;
}
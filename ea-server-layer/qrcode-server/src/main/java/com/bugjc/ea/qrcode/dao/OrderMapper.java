package com.bugjc.ea.qrcode.dao;

import com.bugjc.ea.qrcode.dao.provider.OrderProvider;
import com.bugjc.ea.qrcode.model.Order;
import org.apache.ibatis.annotations.*;

/**
 *
 * @author aoki
 */
@Mapper
public interface OrderMapper {

    /**
     * 插入数据
     * @param order
     * @return
     */
    @InsertProvider(type = OrderProvider.class,method = "insert")
    @Options(keyColumn="id",useGeneratedKeys=true)
    int insert(Order order);

    /**
     * 查询会员 C2B码 交易记录
     * @param qrNo
     * @return
     */
    @SelectProvider(type = OrderProvider.class,method = "selOrderByQrNo")
    Order selOrderByQrNo(@Param("qrNo") String qrNo);
}
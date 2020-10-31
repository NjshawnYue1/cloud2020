package cn.ga.dao;

import cn.ga.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年10月31日 13:15:00
 */
public interface PaymentDao {
    /**
     * 新增
     * @param payment
     * @return
     */
    public boolean addPayment(Payment payment);

    /**
     * id查询
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);

    /**
     * 查所有
     * @return
     */
    public List<Payment> getAll();
}

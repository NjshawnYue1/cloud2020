package cn.ga.service.impl;

import cn.ga.dao.PaymentDao;
import cn.ga.entity.Payment;
import cn.ga.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年10月31日 13:35:00
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;
    @Override
    public boolean addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentDao.getAll();
    }
}

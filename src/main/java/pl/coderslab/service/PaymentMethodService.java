package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.PaymentMethodDao;
import pl.coderslab.model.PaymentMethod;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodService {
    private final PaymentMethodDao pm;

    public void insert(PaymentMethod paymentMethod) {
        pm.insert(paymentMethod);
    }
    public void update (PaymentMethod paymentMethod) {
        pm.update(paymentMethod);
    }
    public void delete(PaymentMethod paymentMethod) {
        pm.delete(paymentMethod);
    }
    public PaymentMethod getPaymentMethod(int id) {
        return  pm.findObject(id);
    }
    public List<PaymentMethod> getPaymentMethodList() {
        return pm.paymentMethodList();
    }
}

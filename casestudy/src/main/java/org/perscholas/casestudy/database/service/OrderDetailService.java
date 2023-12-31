package org.perscholas.casestudy.database.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.OrderDAO;
import org.perscholas.casestudy.database.dao.OrderDetailDAO;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.OrderDetail;
import org.perscholas.casestudy.formbean.CreateOrderDetailFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderDetailService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    public OrderDetail createOrderDetail(Integer productId, Integer orderId, Integer quantityOrdered) {
        log.debug("orderId: " + orderId);
        log.info("productId: " + productId);
        log.info("quantityOrdered: " + quantityOrdered);

        OrderDetail orderDetail = orderDetailDAO.findByOrderIdAndProductId(orderId, productId);

        if (orderDetail != null) {
            orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered() + 1);
            orderDetailDAO.save(orderDetail);
        } else {
            orderDetail = new OrderDetail();

            orderDetail.setProduct(productDAO.findById(productId));
            orderDetail.setOrder(orderDAO.findById(orderId));
            orderDetail.setQuantityOrdered(quantityOrdered);
        }

        return orderDetailDAO.save(orderDetail);
    }
}




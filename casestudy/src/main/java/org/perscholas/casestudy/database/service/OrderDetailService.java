package org.perscholas.casestudy.database.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.OrderDAO;
import org.perscholas.casestudy.database.dao.OrderDetailDAO;
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
    private OrderDetailDAO orderDetailDAO;

    public OrderDetail createOrderDetail(CreateOrderDetailFormBean form) {
        log.debug("id: " + form.getId());
        log.debug("orderId: " + form.getOrderid());
        log.info("productId: " + form.getProductid());
        log.info("quantityOrdered: " + form.getQuantityordered());
        log.info("priceEach: " + form.getPriceeach());

        OrderDetail orderDetail = orderDetailDAO.findByOrderIdAndProductId(form.getOrderid(), form.getProductid());

        if (orderDetail != null) {
            // orderDetail = new OrderDetail();
           orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered() + 1);
           // orderDetail.setQuantityOrdered(quantityordered);
        } else {
            orderDetail = new OrderDetail();
            orderDetail.setProduct(form.getProduct());
            orderDetail.setOrder(form.getOrder());
            orderDetail.setQuantityOrdered(form.getQuantityordered()+1);
            orderDetail.setPriceEach(form.getPriceeach());
        }

            return orderDetailDAO.save(orderDetail);
        }


    }



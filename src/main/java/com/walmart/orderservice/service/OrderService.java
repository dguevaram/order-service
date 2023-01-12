package com.walmart.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.walmart.orderservice.dto.OrderLineItemDto;
import com.walmart.orderservice.model.OrderEntity;
import com.walmart.orderservice.model.OrderLineItemEntity;
import com.walmart.orderservice.repository.OrderRepository;
import com.walmart.orderservice.request.OrderRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        List<OrderLineItemEntity> orderLineItemEntityList = orderRequest.getOrderLineItemsDto()
                                                                        .stream()
                                                                        .map(this::mapOrderLineItemDtoToEntity)
                                                                        .toList();
        OrderEntity orderEntity = OrderEntity.builder().orderNumber(UUID.randomUUID().toString())
                                                    .orderLineItems(orderLineItemEntityList)
                                                    .build();
        
        orderRepository.save(orderEntity);
    }

    private OrderLineItemEntity mapOrderLineItemDtoToEntity(OrderLineItemDto orderLineItemDto) {
        return OrderLineItemEntity.builder()
                                  .id(orderLineItemDto.getId())
                                  .skuCode(orderLineItemDto.getSkuCode())
                                  .price(orderLineItemDto.getPrice())
                                  .quantity(orderLineItemDto.getQuantity()).build();
    }

}

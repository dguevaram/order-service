package com.walmart.orderservice.request;

import java.util.List;

import com.walmart.orderservice.dto.OrderLineItemDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemDto> orderLineItemsDto;
    
}

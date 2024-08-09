package com.ordermangement.dto;

import java.util.List;





import com.ordermangement.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequest {

	private List<OrderLineItemsDto> orderLineItemsDtoList ;
	

	
}

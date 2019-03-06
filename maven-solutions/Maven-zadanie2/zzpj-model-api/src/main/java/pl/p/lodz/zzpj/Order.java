package pl.p.lodz.zzpj;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {

    private OrderId orderId;
    private List<Product> productList;
    private Client client;
}

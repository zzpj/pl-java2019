package pl.p.lodz.zzpj;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class OrderId {

    private String prefix;
    private Long identifier;
    private Boolean temporary;
}

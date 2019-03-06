package pl.p.lodz.zzpj;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {

    private Long id;
    private String name;
}

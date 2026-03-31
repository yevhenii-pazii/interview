import assets.ClientResponse;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Date;

public class ClientController {

    @PostMapping("/use")
    public ClientResponse use() {
        PricingManager pricingManager = new PricingManager();
        var date = new Date();
        date.setMonth(3);
        date.setDate(3);
        pricingManager.setpromoDate(date);

        try {
            pricingManager.apply(new ClientResponse());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pricingManager.getResponse();
    }

}

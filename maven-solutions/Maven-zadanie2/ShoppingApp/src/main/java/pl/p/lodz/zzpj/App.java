package pl.p.lodz.zzpj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Properties properties = loadProperties();

        Product product = Product.builder()
                .name("ddd")
                .id(1l)
                .productType(ProductType.DRINKS)
                .build();

        Client client = Client.builder()
                .id(2l)
                .name("ddd")
                .build();

        Order order = Order.builder()
                .orderId(OrderId.builder().prefix(properties.getProperty("order.prefix")).identifier(2l).temporary(Boolean.FALSE).build())
                .client(client)
                .productList(Arrays.asList(product))
                .build();

        System.out.println(product + " " + client + " " + order);


    }

    public static Properties loadProperties() {

        App app = new App();
        Properties prop = app.loadPropertiesFile("config.properties");
        prop.forEach((k, v) -> System.out.println(k + ":" + v));
        return prop;
    }

    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }
        return prop;
    }
}


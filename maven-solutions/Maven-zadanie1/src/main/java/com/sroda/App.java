package com.sroda;

import lombok.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Person p = Person.builder()
                .name("ff")
                .id(3l)
                .build();
        p.setId(1l);
        p.setName("ffff");

    }
}

@Builder
@Data
class Person {

    Long id;
    String name;


}

package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    //@RequiredArgsConstructor 생성자 자동 생성 -> DI에 필요하다.
public class HelloLombok{
    private String hello;
    private int lombok;

    public static void main(String[] args){
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setHello("헬로");
        helloLombok.setLombok(5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());

    }
}
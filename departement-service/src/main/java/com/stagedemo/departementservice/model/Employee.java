package com.stagedemo.departementservice.model;

public record Employee(Long id , Long departementId , String name , int age , String position) {
}

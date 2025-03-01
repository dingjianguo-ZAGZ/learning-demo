package com.su.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginBodyDTO {
    private String username;
    private String password;
}

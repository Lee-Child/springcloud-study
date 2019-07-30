package com.lwc.auth.bo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AuthBo implements Serializable {

    private static final long serialVersionUID = -3196423130290452492L;

    private String authentication;
    private String url;
    private String method;

    public AuthBo() {
    }

    public AuthBo(String authentication, String url, String method) {

        this.authentication = authentication;
        this.url = url;
        this.method = method;
    }
}

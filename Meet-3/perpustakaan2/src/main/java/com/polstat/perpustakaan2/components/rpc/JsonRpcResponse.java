package com.polstat.perpustakaan2.components.rpc;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsonRpcResponse {
    public JsonRpcResponse(Object result, String id) {
        this.result = result;
        this.id = id;
    }

    private String jsonrpc;
    private Object result;
    private Object error;
    private String id;
}
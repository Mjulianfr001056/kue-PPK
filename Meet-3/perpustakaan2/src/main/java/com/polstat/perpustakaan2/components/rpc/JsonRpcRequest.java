package com.polstat.perpustakaan2.components.rpc;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsonRpcRequest {
    private String jsonrpc;
    private String method;
    private JsonNode params;
    private String id;
}
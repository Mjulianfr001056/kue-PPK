/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.polstat.perpustakaan.rpc;

/**
 *
 * @author asus
 */
import com.polstat.perpustakaan.dto.BookDto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class JsonRpcResponse {

    private String jsonrpc;
    private Object result;
    private Object error;
    private String id;
    //tambahkan method getter dan setter

    public JsonRpcResponse(Object books, String id1) {
        result = books;
        id=id1;
    }
}

package kr.co.seop.projecting.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public abstract class ApiResponse<T> {
    private T data;
    private List<String> errors;
    public ApiResponse(T data){
        this.data = data;
    }
}

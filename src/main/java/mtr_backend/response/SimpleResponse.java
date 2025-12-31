package mtr_backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SimpleResponse<T> {

    private final boolean success;
    private final T data;
    private final String message;

    public static <T> SimpleResponse<T> ok(T data) {
        return new SimpleResponse<>(true, data, null);
    }
    public static <T> SimpleResponse<T> error(String message) {
        return new SimpleResponse<>(false, null, message);
    }
    
}

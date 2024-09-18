package py.edu.ucom.models.responses;

public class Respuesta<T> {
    private String message;
    private Integer code;
    private T data;

    // Constructor vacío
    public Respuesta() {
    }

    // Constructor con todos los atributos
    public Respuesta(String message, Integer code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    // Getters y Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // Método toString para fácil visualización
    @Override
    public String toString() {
        return "Respuesta{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}

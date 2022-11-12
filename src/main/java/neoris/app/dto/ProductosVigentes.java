package neoris.app.dto;

public class ProductosVigentes {

    private Integer id_promocion_vigencia;
    private Integer id_promocion_producto;
    private Integer id_producto;
    private String descripcion;


    public Integer getId_promocion_vigencia() {
        return id_promocion_vigencia;
    }

    public void setId_promocion_vigencia(Integer id_promocion_vigencia) {
        this.id_promocion_vigencia = id_promocion_vigencia;
    }

    public Integer getId_promocion_producto() {
        return id_promocion_producto;
    }

    public void setId_promocion_producto(Integer id_promocion_producto) {
        this.id_promocion_producto = id_promocion_producto;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

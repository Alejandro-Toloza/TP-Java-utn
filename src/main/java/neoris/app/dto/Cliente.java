package neoris.app.dto;

public class Cliente extends ProductoCliente{

    private Integer id_cliente;
    private Integer id_usuario;
    private String nombre;
    private String direccion;
    private Integer id_tipo_cliente;

    @Override
    public Integer getId_cliente() {
        return id_cliente;
    }

    @Override
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId_tipo_cliente() {
        return id_tipo_cliente;
    }

    public void setId_tipo_cliente(Integer id_tipo_cliente) {
        this.id_tipo_cliente = id_tipo_cliente;
    }
}

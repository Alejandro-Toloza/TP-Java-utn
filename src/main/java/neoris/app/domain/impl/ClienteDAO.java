package neoris.app.domain.impl;

import neoris.app.domain.Facade;
import neoris.app.dto.*;
import neoris.app.jdbc.MiJdbc;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements Facade {

    @Override
    public List<Cliente> obtenerClientesQueAdquirieron(int idProducto) {

        MiJdbc jdbc = MiJdbc.getInstance();
        String sql="";
        sql+="SELECT p.id_producto, p.descripcion, o.id_cliente, c.nombre, od.id_orden ";
        sql+="FROM cliente c ";
        sql+="INNER JOIN orden o ON o.id_cliente=c.id_cliente ";
        sql+="INNER JOIN detalle_orden od ON od.id_orden=o.id_orden ";
        sql+="INNER JOIN producto p ON od.id_producto=p.id_producto ";
        sql+="WHERE p.id_producto=? ";


        List<Object[]> list = jdbc.query(sql, idProducto);
        List<Cliente> listDto = new ArrayList<>();
        for(Object[] fila:list){
            Cliente dto = new Cliente();
            dto.setId_producto((Integer) fila[0]);
            dto.setDescripcion((String) fila[1]);
            dto.setId_cliente((Integer) fila[2]);
            dto.setNombre((String) fila[3]);
            dto.setId_orden((Integer) fila[4]);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public List<Cliente> obtenerClientes() {

        MiJdbc jdbc = MiJdbc.getInstance();
        String sql="";
        sql+="SELECT id_cliente, nombre, id_tipo_cliente, direccion, id_usuario FROM ";
        sql+="cliente";

        List<Object[]> list = jdbc.query(sql);
        List<Cliente> listDto = new ArrayList<>();

        for(Object[] fila:list){
            Cliente dto = new Cliente();
            dto.setId_cliente((Integer) fila[0]);
            dto.setNombre((String) fila[1]);
            dto.setId_tipo_cliente((Integer) fila[2]);
            dto.setDireccion((String) fila[3]);
            dto.setId_usuario((Integer) fila[4]);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public List<Producto> obtenerProductos() {
        return null;
    }


    @Override
    public List<Empleado> obtenerEmpleadosQueAntendieron(int idCliente) {
        return null;
    }

    @Override
    public List<Producto> obtenerProductosConPromocionesVigentes() {
        return null;
    }

    @Override
    public List<Promocion> obtenerPromociones(int idProducto) {
        return null;
    }

    @Override
    public List<Categoria> obtenerCategorias() {
        return null;
    }

    @Override
    public List<Proveedor> obtenerProveedores(int idCategoria) {
        return null;
    }

    @Override
    public void generarReposicionProducto() {

    }
}

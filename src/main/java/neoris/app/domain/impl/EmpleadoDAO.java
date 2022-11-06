package neoris.app.domain.impl;

import neoris.app.domain.Facade;
import neoris.app.dto.*;
import neoris.app.jdbc.MiJdbc;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements Facade {

    @Override
    public List<Empleado> obtenerEmpleadosQueAntendieron(int idCliente) {

        MiJdbc jdbc = MiJdbc.getInstance();
        String sql="";
        sql+="SELECT c.id_cliente, c.nombre, o.id_orden, e.id_empleado, e.nombre FROM empleado e ";
        sql+="INNER JOIN orden o ON e.id_empleado=o.id_empleado ";
        sql+="INNER JOIN cliente c ON c.id_cliente=o.id_cliente ";
        sql+="WHERE c.id_cliente=? ";

        List<Object[]> list = jdbc.query(sql,idCliente);
        List<Empleado> listDto = new ArrayList<>();

        for(Object[] fila:list){
            Empleado dto = new Empleado();
            dto.setId_cliente((Integer) fila[0]);
            dto.setNombreCliente((String) fila[1]);
            dto.setId_orden((Integer) fila[2]);
            dto.setId_empleado((Integer) fila[3]);
            dto.setNombre((String) fila[4]);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public List<Producto> obtenerProductos() {
        return null;
    }

    @Override
    public List<Cliente> obtenerClientesQueAdquirieron(int idProducto) {
        return null;
    }

    @Override
    public List<Cliente> obtenerClientes() {
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

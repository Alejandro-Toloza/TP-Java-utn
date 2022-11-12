package neoris.app.domain.impl;

import neoris.app.domain.Facade;
import neoris.app.dto.*;
import neoris.app.jdbc.MiJdbc;

import java.util.ArrayList;
import java.util.List;

public class ProveedoresDAO implements Facade {

    @Override
    public List<Proveedor> obtenerProveedores(int idCategoria) {
        MiJdbc jdbc = MiJdbc.getInstance();
        String sql="";
        sql+="SELECT po.id_proveedor, po.contacto, po.empresa, p.id_producto, p.descripcion, c.id_categoria, c.descripcion FROM proveedor po ";
        sql+="INNER JOIN proveedor_categoria pc ON pc.id_proveedor=po.id_proveedor ";
        sql+="INNER JOIN categoria c ON c.id_categoria=pc.id_categoria ";
        sql+="INNER JOIN producto p ON p.id_categoria=c.id_categoria ";
        sql+="WHERE p.id_categoria=?";

        List<Object[]> list = jdbc.query(sql,idCategoria);
        List<Proveedor> listDto = new ArrayList<>();

        for(Object[] fila:list){
            Proveedor dto = new Proveedor();
            dto.setId_proveedor((Integer) fila[0]);
            dto.setContacto((String) fila[1]);
            dto.setEmpresa((String) fila[2]);
            dto.setId_producto((Integer) fila[3]);
            dto.setDescripcionProducto((String) fila[4]);
            dto.setId_categoria((Integer) fila[5]);
            dto.setDescripcion((String) fila[6]);
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
    public void generarReposicionProducto() {

    }
}

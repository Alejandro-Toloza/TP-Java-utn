package neoris.app.domain.impl;

import neoris.app.domain.Facade;
import neoris.app.dto.*;
import neoris.app.jdbc.MiJdbc;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements Facade {

    @Override
    public List<Categoria> obtenerCategorias() {
        MiJdbc x = MiJdbc.getInstance();
        List<Object[]> list = x.query("SELECT * FROM categoria");

        List<Categoria> listDto = new ArrayList<>();
        for(Object[] fila:list){
            Categoria dto = new Categoria();
            dto.setId_categoria((Integer) fila[0]);
            dto.setDescripcion((String) fila[1]);
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
    public List<Proveedor> obtenerProveedores(int idCategoria) {
        return null;
    }
    @Override
    public void generarReposicionProducto() {

    }


}

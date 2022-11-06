package neoris.app.domain.impl;

import neoris.app.dto.*;

import java.util.List;

public class FacadeImpl {

    public List<Categoria> listCategoria(){
        CategoriaDAO dao = new CategoriaDAO();
        return dao.obtenerCategorias();
    }

    public List<Producto> listProducto(){
        ProductoDAO dao = new ProductoDAO();
        return dao.obtenerProductos();
    }

    public List<Cliente> listClienteProducto(int id){
        ClienteDAO dao = new ClienteDAO();
        return dao.obtenerClientesQueAdquirieron(id);
    }

    public List<Cliente> listCliente(){
        ClienteDAO dao = new ClienteDAO();
        return dao.obtenerClientes();
    }

    public List<Empleado> listEmpleadosQueAntendieron(int id){

        EmpleadoDAO empleado = new EmpleadoDAO();
        return empleado.obtenerEmpleadosQueAntendieron(id);

    }
}

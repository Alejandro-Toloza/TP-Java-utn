package neoris.app.domain.impl;

import neoris.app.dto.*;

import java.util.List;

public class FacadeImpl {

    public List<Categoria> listCategoria(){
        CategoriaDAO dao = new CategoriaDAO();
        return dao.obtenerCategorias();
    }

    public List<Producto> obtenerProductos(){
        ProductoDAO dao = new ProductoDAO();
        return dao.obtenerProductos();
    }

    public List<Cliente> obtenerClientesQueAdquirieron(int id){
        ClienteDAO dao = new ClienteDAO();
        return dao.obtenerClientesQueAdquirieron(id);
    }

    public List<Cliente> obtenerClientes(){
        ClienteDAO dao = new ClienteDAO();
        return dao.obtenerClientes();
    }

    public List<Empleado> obtenerEmpleadosQueAntendieron(int id){

        EmpleadoDAO empleado = new EmpleadoDAO();
        return empleado.obtenerEmpleadosQueAntendieron(id);

    }

    public List<Producto> listPromocionesVigentes(){
        PromocionVigenteDAO dao = new PromocionVigenteDAO();
        return dao.obtenerProductosConPromocionesVigentes();
    }

    public List<Promocion> obtenerPromociones(int id){
        PromocionDAO dao = new PromocionDAO();
        return dao.obtenerPromociones(id);
    }

    public List<Proveedor> obtenerProveedores(int id){
        ProveedoresDAO dao = new ProveedoresDAO();
        return dao.obtenerProveedores(id);
    }

}

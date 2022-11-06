package neoris.app.domain.impl;

import neoris.app.dto.Categoria;
import neoris.app.dto.Cliente;
import neoris.app.dto.Producto;
import neoris.app.dto.ProductoCliente;

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

    public List<Cliente> listCliente(int id){
        ClienteDAO dao = new ClienteDAO();
        return dao.obtenerClientesQueAdquirieron(id);
    }

}

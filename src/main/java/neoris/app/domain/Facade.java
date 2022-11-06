package neoris.app.domain;

import java.util.List;

import neoris.app.dto.Categoria;
import neoris.app.dto.Cliente;
import neoris.app.dto.Empleado;
import neoris.app.dto.Producto;
import neoris.app.dto.Promocion;
import neoris.app.dto.Proveedor;

public interface Facade{

    // Caso de uso #1: CLIENTES QUE ADQUIRIERON UN PRODUCTO
    // Se debe mostrar por pantalla el listado de clientes que
    // adquirieron, al menos en una oportunidad, un producto especificado.
    public List<Producto> obtenerProductos(); //TODO: HECHO
    public List<Cliente> obtenerClientesQueAdquirieron(int idProducto); //TODO: HECHO

    // Caso de uso #2: EMPLEADOS QUE ATENDIERON A UN CLIENTES
    // Se debe mostrar por pantalla el listado de empleados que
    // atendieron, al menos en una oportunidad, un cliente especificado.
    public List<Cliente> obtenerClientes();//TODO: HECHO
    public List<Empleado> obtenerEmpleadosQueAntendieron(int idCliente);//TODO: HECHO

    // Caso de uso #3: LISTADO DE LOS PRODUCTOS QUE TIENEN PROMOCIONES EN VIGENCIA
    // Se debe mostrar por pantalla el listado de los productos que
    // tienen al menos una promocion en vigencia.
    public List<Producto> obtenerProductosConPromocionesVigentes();

    // Caso de uso #4: LISTADO DE LAS PROMOCIONES PARA UN PRODUCTO
    // Se debe mostrar por pantalla el listado de TODAS las promociones
    // aplicables a un producto especificado.
    public List<Promocion> obtenerPromociones(int idProducto);

    // Caso de uso #5: PROVEEDORES POR CATEOGORIA
    // Se debe mostrar por pantalla el listado de los proveedores que
    // proveen productos de una categoria especificada.
    public List<Categoria> obtenerCategorias();
    public List<Proveedor> obtenerProveedores(int idCategoria);

    // THREAD
    // Verifica que productos deben ser encargados para mantener el stock, y
    // genera una fila en la tabla de REPOSICION
    public void generarReposicionProducto();
}
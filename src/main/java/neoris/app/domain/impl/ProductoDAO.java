package neoris.app.domain.impl;

import neoris.app.domain.Facade;
import neoris.app.dto.*;
import neoris.app.jdbc.MiJdbc;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements Facade {

    @Override
    public List<Producto> obtenerProductos() {
        MiJdbc jdbc = MiJdbc.getInstance();
        String sql="";
        sql+="SELECT ";
        sql+="id_producto, ";
        sql+="descripcion ";
        sql+="FROM producto";

        /*
        sql+="SELECT id_producto, ";
        sql+="descripcion, ";
        sql+=" id_proveedor, ";
        sql+="id_categoria, ";
        sql+="precio_unitario, ";
        sql+="unidades_stock ";
        sql+="unidades_reposicion ";
        sql+="FROM producto";*/

        /*sql+="flg_discontinuo ";
        sql+="unidades_stock_maximo ";
        sql+="unidades_stock_minimo ";*/

        /*sql+="SELECT id_producto, ";
        sql+="descripcion, ";
        sql+="id_categoria, ";
        sql+="precio_unitario, ";
        sql+="unidades_stock ";
        sql+="FROM producto WHERE id_categoria=? ";*/


        //List<Object[]> list = jdbc.query(sql, Producto.getIdAux());
        List<Object[]> list = jdbc.query(sql);
        List<Producto> listDto = new ArrayList<>();
        for(Object[] fila:list){
            Producto dto = new Producto();
            dto.setId_producto((Integer) fila[0]);
            dto.setDescripcion((String) fila[1]);
            /*dto.setId_categoria((Integer) fila[2]);
            dto.setPrecio_unitario((Double) fila[3]);;
            dto.setUnidades_stock((Integer) fila[4]);*/
            listDto.add(dto);
        }
        return listDto;
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
    public List<Proveedor> obtenerProveedores(int idCategoria) {
        return null;
    }

    @Override
    public void generarReposicionProducto() {

    }

}

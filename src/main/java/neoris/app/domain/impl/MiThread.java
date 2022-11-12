package neoris.app.domain.impl;

import neoris.app.domain.Facade;
import neoris.app.dto.*;
import neoris.app.jdbc.MiJdbc;

import java.util.ArrayList;
import java.util.List;

public class MiThread implements Facade {

    @Override
    public void generarReposicionProducto() {

        MiJdbc jdbc = MiJdbc.getInstance();
        String sql="";
        sql+="INSERT INTO reposicion (id_producto, cantidad,fecha)" ;
        sql+="SELECT P.id_producto, (P.unidades_stock_maximo - P.unidades_stock) AS cantidad, CURRENT_DATE ";
        sql+="FROM producto AS P ";
        sql+="WHERE (P.unidades_stock < P.unidades_stock_minimo)  AND NOT EXISTS (SELECT id_producto FROM reposicion WHERE id_producto=?)";


        List<Object[]> list = jdbc.query(sql, Producto.getIdAux());
        List<Producto> listDto = new ArrayList<>();
        for(Object[] fila:list){
            Producto dto = new Producto();
            dto.setId_producto((Integer) fila[0]);
            dto.setDescripcion((String) fila[1]);
            dto.setId_categoria((Integer) fila[2]);
            dto.setPrecio_unitario((Double) fila[3]);;
            dto.setUnidades_stock((Integer) fila[4]);
            listDto.add(dto);
        }

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
    public List<Proveedor> obtenerProveedores(int idCategoria) {
        return null;
    }


}

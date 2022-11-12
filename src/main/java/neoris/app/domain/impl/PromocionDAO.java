package neoris.app.domain.impl;

import neoris.app.domain.Facade;
import neoris.app.dto.*;
import neoris.app.jdbc.MiJdbc;

import java.util.ArrayList;
import java.util.List;

public class PromocionDAO implements Facade {

    @Override
    public List<Promocion> obtenerPromociones(int idProducto) {
        MiJdbc jdbc = MiJdbc.getInstance();
        String sql="";
        sql+="SELECT pr.id_promocion, pr.descripcion, pv.id_promocion_vigencia, pp.id_promocion_producto, ";
        sql+="p.id_producto, p.descripcion FROM producto p ";
        sql+="INNER JOIN promocion_producto pp ON p.id_producto=pp.id_producto ";
        sql+="INNER JOIN promocion_vigencia pv ON pv.id_promocion_vigencia=pp.id_promocion_vigencia ";
        sql+="INNER JOIN promocion pr ON pr.id_promocion=pv.id_promocion ";
        sql+="WHERE p.id_producto=?";

        List<Object[]> list = jdbc.query(sql,idProducto);
        List<Promocion> listDto = new ArrayList<>();

        for(Object[] fila:list){
            Promocion dto = new Promocion();
            dto.setId_promocion((Integer) fila[0]);
            dto.setDescripcion((String) fila[1]);
            dto.setId_promocion_vigencia((Integer) fila[2]);
            dto.setId_promocion_producto((Integer) fila[3]);
            dto.setId_producto((Integer) fila[4]);
            dto.setDescripcion((String) fila[5]);
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

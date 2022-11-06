package neoris.app.domain.impl;

import neoris.app.dto.*;
import neoris.app.jdbc.MiJdbc;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public List<Producto> obtenerProductos() {

        MiJdbc jdbc = MiJdbc.getInstance();
        String sql="";
        sql+="SELECT id_producto, ";
        sql+="descripcion, ";
        sql+="id_categoria, ";
        sql+="precio_unitario, ";
        sql+="unidades_stock ";
        sql+="FROM producto WHERE id_categoria=? ";


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
        return listDto;
    }




}

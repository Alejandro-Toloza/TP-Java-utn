package neoris;

import neoris.app.domain.impl.FacadeImpl;
import neoris.app.dto.Categoria;
import neoris.app.dto.Cliente;
import neoris.app.dto.Producto;
import neoris.app.dto.ProductoCliente;
import neoris.app.jdbc.MiShutdownHook;

import java.util.List;
import java.util.Scanner;

public class Main {

    static
    {
        Runtime.getRuntime().addShutdownHook(new MiShutdownHook());
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FacadeImpl facade = new FacadeImpl();
        double precio_unitario;
        int idCat;
        int id_producto_sc;

        //PRIMERA PANTALLA -----------------------------------------
        System.out.println("-- SELECCIONES CATEGORIA --");
        List<Categoria> listDtoCategoria = facade.listCategoria();
        for (Categoria dto : listDtoCategoria) {
            System.out.println(dto.getId_categoria() + " : " + dto.getDescripcion());
        }

        idCat = scanner.nextInt();

        // SEGUNDA PANTALLA -------------------------------------
        Producto.setIdAux(idCat);
        String nombreCategoria = (idCat == 1 ? "COMPUTACION" : idCat == 2 ? "TELEFONIA" : idCat == 3 ? "VIDEOJUEGOS" : "-");

        System.out.println("-- SELECCIONE PRODUCTO DE " + nombreCategoria);
        List<Producto> productoDTOList = facade.listProducto();
        //List<ProductoDTO> list2 = new ArrayList<>();

        for (Producto dto : productoDTOList) {
            System.out.println("Producto: " + dto.getId_producto() + ", descripcion: " + dto.getDescripcion() + ",  id categoria: " +
                    dto.getId_categoria() + " - (" + nombreCategoria + ")" + ".\nunidades en stock: " + dto.getUnidades_stock() + "\nprecio unitario:$" + dto.getPrecio_unitario());
            System.out.println("--------------------------------------");
            //list2.add(dto);
        }

        //TERCERA PANTALLA: -----------------------------
        System.out.println("SELECCIONE EL N° DE ID del producto");
        int id_producto = scanner.nextInt();

        for (Producto dto : productoDTOList) {
            if (id_producto == dto.getId_producto()) {
                precio_unitario = dto.getPrecio_unitario();
                System.out.println("Nombre Prudcto seleccionado: " + dto.getDescripcion());
                System.out.println("Precio unitario: $" + precio_unitario);
            }

        }

        System.out.println("Datos de productos del cliente: ");
        List<Cliente> productoClienteList = facade.listCliente(id_producto);
        for (Cliente dto : productoClienteList ) {
            System.out.println("Id_cliente: " + dto.getId_cliente() + ", Nombre: " + dto.getNombre() + ",  id producto: " +
                    dto.getId_producto()  + " Descripcion: " + dto.getDescripcion() + " id_orden: " + dto.getId_orden());
            System.out.println("--------------------------------------");
            //list2.add(dto);
        }

    }




}
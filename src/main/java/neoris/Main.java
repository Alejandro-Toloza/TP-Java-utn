package neoris;

import neoris.app.domain.impl.FacadeImpl;
import neoris.app.dto.*;
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
        int id_producto;
        Integer id_cliente;

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
        id_producto = scanner.nextInt();

        for (Producto dto : productoDTOList) {
            if (id_producto == dto.getId_producto()) {
                precio_unitario = dto.getPrecio_unitario();
                System.out.println("Nombre Prudcto seleccionado: " + dto.getDescripcion());
                System.out.println("Precio unitario: $" + precio_unitario);
            }

        }

        System.out.println("Datos de productos del cliente: ");
        List<Cliente> productoClienteList = facade.listClienteProducto(id_producto);
        for (Cliente dto : productoClienteList ) {
            System.out.println("Id_cliente: " + dto.getId_cliente() + ", Nombre: " + dto.getNombre() + ",  id producto: " +
                    dto.getId_producto()  + " Descripcion: " + dto.getDescripcion() + " id_orden: " + dto.getId_orden());
            System.out.println("--------------------------------------");
            //list2.add(dto);
        }

        System.out.println("-----PUREBA MOSTRANDOI LIOSTA CLIENTE: ");
        List<Cliente> clienteList = facade.listCliente();
        for (Cliente dto : clienteList ) {
            System.out.println("Id_Cliente: "+dto.getId_cliente()+" Nombre: "+dto.getNombre()
            +" direccio: "+dto.getDireccion()+" id_tipo_cliente: "+dto.getId_tipo_cliente()
            +" Usuario: "+dto.getId_usuario());
            //list2.add(dto);
        }

        System.out.println("EMPLEADOS QUE ATENDIERON UN CLIENTE SERGUN ID CLIENTE");
        System.out.println("insertar id_cliente: ");
        id_cliente=scanner.nextInt();
        List<Empleado> empleadoList = facade.listEmpleadosQueAntendieron(id_cliente);
        for(Empleado dto: empleadoList){
            //id_cliente | nombre | id_orden | id_empleado | nombre
                System.out.println("id_cliente: "+dto.getId_cliente()+
                        " Nombre Empleado: "+dto.getNombre()+
                        " id orden: "+dto.getId_orden()+
                        " id empleado: "+dto.getId_empleado()+
                        " Nombre Cliente: "+dto.getNombreCliente());
            }
        }

    }
import neoris.app.domain.impl.FacadeImpl;
import neoris.app.dto.Cliente;
import neoris.app.dto.Empleado;
import neoris.app.dto.Producto;
import neoris.app.jdbc.MiJdbc;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestApp {

    @Test
    public void testJdbc(){
        MiJdbc j1 = MiJdbc.getInstance();
        MiJdbc j2 = MiJdbc.getInstance();
        assertEquals(j1,j2);
    }

    @Test
    public void testQuery()
    {
        MiJdbc jdbc = MiJdbc.getInstance();

        String sql = "";
        sql+="SELECT COUNT(*) FROM categoria ";
        List<Object[]> x = jdbc.query(sql);

        // verifico que haya traido 1 fila, 1 columna
        assertEquals(x.size(),1);
        Object fila[] = x.get(0);
        assertEquals(fila.length,1);

        long n = (Long)fila[0];

        sql = "";
        sql+="SELECT id_categoria,descripcion ";
        sql+="FROM categoria ";
        x = jdbc.query(sql);

        // verifico que haya traido 3 filas
        assertEquals(x.size(),n);

        // verifico que las filas tienen dos columnas
        fila = x.get(0);
        assertEquals(fila.length,2);
    }

    @Test
    public void testObtenerProductos()
    {
        //Facade f = MiFactory.getInstance("facade");
        //ProductoDAO f = new ProductoDAO();
        FacadeImpl f = new FacadeImpl();
        List<Producto> lst = f.obtenerProductos();
        // 18 productos
        assertEquals(lst.size(),18);
    }

    @Test
    public void testClientesQueAdquirieron()
    {
        //Facade f = MiFactory.getInstance("facade");
        FacadeImpl f = new FacadeImpl();
        List<Cliente> lst = f.obtenerClientesQueAdquirieron(2);

        // 2 clientes
        assertEquals(lst.size(),2);
    }

    @Test
    public void testObtenerClientes()
    {
        //Facade f = MiFactory.getInstance("facade");
        FacadeImpl f = new FacadeImpl();
        List<Cliente> lst = f.obtenerClientes();

        // 7 clientes
        assertEquals(lst.size(),7);
    }

    @Test
    public void testEmpleadosQueAtendieron()
    {
        //Facade f = MiFactory.getInstance("facade");
        FacadeImpl f = new FacadeImpl();

        // 2 empleados
        List<Empleado> lst = f.obtenerEmpleadosQueAntendieron(1);
        assertEquals(lst.size(),2);

        // 2 empleados tambien

        lst = f.obtenerEmpleadosQueAntendieron(2);
        assertEquals(lst.size(),2);
    }

}

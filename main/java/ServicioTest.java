import org.junit.jupiter.api.Test;

import com.app.web.entidad.OrdenTrabajo;
import com.app.web.entidad.Servicio;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class ServicioTest {

    @Test
    public void testCrearServicio() {
        // Datos de prueba
        String nombre = "Cambio de aceite";
        String descripcion = "Cambiar el aceite del motor";
        BigDecimal precio = new BigDecimal("50.00");

        // Crear instancia de Servicio
        Servicio servicio = new Servicio(nombre, descripcion);
        servicio.setPrecio(precio);

        // Verificar valores
        assertEquals(nombre, servicio.getNombre());
        assertEquals(descripcion, servicio.getDescripcion());
        assertEquals(precio, servicio.getPrecio());
    }

    @Test
    public void testActualizarPrecio() {
        // Datos de prueba
        BigDecimal precioInicial = new BigDecimal("50.00");
        BigDecimal nuevoPrecio = new BigDecimal("60.00");

        // Crear instancia de Servicio
        Servicio servicio = new Servicio("Cambio de aceite", "Cambiar el aceite del motor");
        servicio.setPrecio(precioInicial);

        // Actualizar el precio
        servicio.actualizarPrecio(nuevoPrecio);

        // Verificar que el precio se haya actualizado correctamente
        assertEquals(nuevoPrecio, servicio.getPrecio());
    }

    @Test
    public void testAgregarOrdenTrabajo() {
        // Datos de prueba
        Servicio servicio = new Servicio("Cambio de aceite", "Cambiar el aceite del motor");
        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();

        // Agregar la orden de trabajo al servicio
        servicio.getOrdenesTrabajo().add(ordenTrabajo);

        // Verificar que la orden de trabajo se haya agregado correctamente
        assertTrue(servicio.getOrdenesTrabajo().contains(ordenTrabajo));
    }

    // Puedes agregar más pruebas según la lógica específica de tu aplicación.
}

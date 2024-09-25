package edu.pe.cibertec.demo_back_mautino.controlador;

import edu.pe.cibertec.demo_back_mautino.dto.VehiculoRequest;
import edu.pe.cibertec.demo_back_mautino.dto.VehiculoResponse;
import edu.pe.cibertec.demo_back_mautino.service.VehiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class vehiculoControlador {

    @Autowired
    VehiService vehiculoServicio;

    @PostMapping
    public VehiculoResponse buscarVehiculo(@RequestBody VehiculoRequest vehiculoRequest) {
        try {
            String[] datosAutos = vehiculoServicio.buscarVehiculo(vehiculoRequest);
            if (datosAutos == null) {
                return new VehiculoResponse("01", "Error: Auto no encontrado", "", "",
                        "", "", "");
            }
            return new VehiculoResponse("00", "", datosAutos[0], datosAutos[1],
                    datosAutos[2], datosAutos[3], datosAutos[4]);
        } catch (Exception e) {
            return new VehiculoResponse("99", "Error: Ocurrió un problema", "",
                    "", "", "", "");
        }
    }
}

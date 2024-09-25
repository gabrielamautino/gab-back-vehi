package edu.pe.cibertec.demo_back_mautino.service;

import edu.pe.cibertec.demo_back_mautino.dto.VehiculoRequest;

import java.io.IOException;

public interface VehiService {
    String[] buscarVehiculo(VehiculoRequest vehiculoRequest) throws IOException;
}

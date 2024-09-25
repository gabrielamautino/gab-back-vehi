package edu.pe.cibertec.demo_back_mautino.service.impl;

import edu.pe.cibertec.demo_back_mautino.dto.VehiculoRequest;
import edu.pe.cibertec.demo_back_mautino.service.VehiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class VehiculoServiceImpl implements VehiService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public String[] buscarVehiculo(VehiculoRequest vehiculoRequest) throws IOException {
        String[] datosVehiculos = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (vehiculoRequest.placa().equals(datos[1])) {
                    datosVehiculos = new String[5];
                    datosVehiculos[0] = datos[2];
                    datosVehiculos[1] = datos[3];
                    datosVehiculos[2] = datos[4];
                    datosVehiculos[3] = datos[5];
                    datosVehiculos[4] = datos[6];
                }
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
        return datosVehiculos;

    }
}


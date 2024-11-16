package org.rigo.test.springboot.app.Cntrollers;

import org.rigo.test.springboot.app.models.Cuenta;
import org.rigo.test.springboot.app.models.TransaccionDto;
import org.rigo.test.springboot.app.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/cuenta")
public class CuentaControllers {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cuenta> getCuentas() {
        return cuentaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cuenta guadar(@RequestBody Cuenta cuenta) {
        return cuentaService.save(cuenta);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cuenta detalleCuenta(@PathVariable Long id) {
        return cuentaService.findById(id);
    }

    @PostMapping("/transferir")
    public ResponseEntity<?> transferir(@RequestBody TransaccionDto dto) {

        cuentaService.tranferir(dto.getCuentaOrigenId(), dto.getCuentaDestinoId(), dto.getMonto(), dto.getBandoId());

        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", HttpStatus.CREATED);
        response.put("message", "Transfer completo");
        response.put("data", dto);

        return ResponseEntity.ok(response);

    }


}

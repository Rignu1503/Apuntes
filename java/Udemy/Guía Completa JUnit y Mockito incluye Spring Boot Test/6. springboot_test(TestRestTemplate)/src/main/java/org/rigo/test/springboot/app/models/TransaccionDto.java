package org.rigo.test.springboot.app.models;

import java.math.BigDecimal;

public class TransaccionDto {
    private Long cuentaOrigenId;
    private Long cuentaDestinoId;
    private BigDecimal monto;
    private Long bandoId;

    public Long getCuentaOrigenId() {
        return cuentaOrigenId;
    }

    public void setCuentaOrigenId(Long cuentaOrigenId) {
        this.cuentaOrigenId = cuentaOrigenId;
    }

    public Long getCuentaDestinoId() {
        return cuentaDestinoId;
    }

    public void setCuentaDestinoId(Long cuentaDestinoId) {
        this.cuentaDestinoId = cuentaDestinoId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Long getBandoId() {
        return bandoId;
    }

    public void setBandoId(Long bandoId) {
        this.bandoId = bandoId;
    }
}

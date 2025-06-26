package lucas.dev.itau.model;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

    private static Long idCounter = 1L;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final Long id;

    private Double valor;
    private OffsetDateTime dataHora;

    public Transaction(Double valor, OffsetDateTime dataHora){
        this.id = idCounter++;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public void setValor(Double valor){this.valor = valor;}
    public void setDataHora(OffsetDateTime dataHora){this.dataHora = dataHora;}

    public Double getValor(){return valor;}
    public OffsetDateTime getDataHora(){return dataHora;}
    public Long getId(){return id;}
}

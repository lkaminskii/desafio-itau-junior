package lucas.dev.itau.model;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Transaction {

    private static Long idCounter = 1L;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final Long id;

    @JsonFormat(pattern = "0.00")
    private Double valor;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime dataHora;

    public Transaction(Double valor){
        this.id = idCounter++;
        this.valor = valor;
        this.dataHora = OffsetDateTime.now();
    }

    public void setValor(Double valor){this.valor = valor;}

    public Double getValor(){return valor;}
    public OffsetDateTime getDataHora(){return dataHora;}
    public Long getId(){return id;}
}

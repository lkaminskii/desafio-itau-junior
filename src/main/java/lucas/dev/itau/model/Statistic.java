package lucas.dev.itau.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistic {

    private static Long idCounter = 1L;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final Long id;

    private Double count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;

    public Statistic(Double count, Double sum, Double avg, Double min, Double max){
        this.id = idCounter++;
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    public Double getCount(){return count;}
    public Double getSum(){return sum;}
    public Double getAvg(){return avg;}
    public Double getMin(){return min;}
    public Double getMax(){return max;}

    public void setCount(Double count){this.count = count;}
    public void setSum(Double sum){this.sum = sum;}
    public void setAvg(Double avg){this.avg = avg;}
    public void setMin(Double min){this.min = min;}
    public void setMax(Double max){this.max = max;}
}

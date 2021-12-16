package pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ssq {
    private String ssqtext;
    private Integer ssqId;

    @Override
    public String toString() {
        return "Ssq{" +
                "ssqtext='" + ssqtext + '\'' +
                ", ssqId=" + ssqId +
                '}';
    }

    public String getSsqtext() {
        return ssqtext;
    }

    public void setSsqtext(String ssqtext) {
        this.ssqtext = ssqtext;
    }

    public Integer getSsqId() {
        return ssqId;
    }

    public void setSsqId(Integer ssqId) {
        this.ssqId = ssqId;
    }
}

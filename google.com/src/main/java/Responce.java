import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Responce {
    private Integer id;

    private Integer pageSize;

    private Integer totalPageCount;

    private Wkda wkda;

    public Integer getId() {
        return new Random().nextInt(10000);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPageSize() {
        return new Random().nextInt();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPageCount() {
        return new Random().nextInt(1000);
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Wkda getWkda() {
        return new Wkda(RandomStringUtils.randomAlphabetic(10));
    }

    public void setWkda(Wkda wkda) {
        this.wkda = wkda;
    }
}

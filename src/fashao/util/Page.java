package fashao.util;

/**
 * @author ayorfree
 * @create 2018-04-21-上午10:11
 */

public class Page {
    int start;
    int count;
    int total;
    String param;

    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public String getParam() {
        return param;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public boolean isHasNext() {
        if (start == getLast())
            return false;
        return true;
    }

    public int getTotalPage() {
        int totalPage;

        if (0 == total % count)
            totalPage = total / count;
        else
            totalPage = total / count + 1;

        if (0 == totalPage)
            totalPage = 1;
        return totalPage;
    }

    public int getLast() {
        int last;

        if (0 == total / count)
            last = total - count;
        else
            last = total - total / count;

        last = last < 0 ? 0 : last;
        return last;
    }
}

public class Close_key {
    private long close_exhibitor;
    private long derivative;

    public Close_key(long close_exhibitor, long derivative){
        this.close_exhibitor = close_exhibitor;
        this.derivative = derivative;
    }

    public long getClose_exhibitor() {
        return close_exhibitor;
    }
    public long getDerivative(){
        return derivative;
    }

    @Override
    public String toString() {
        return "Close_key{" +
                "закрытая экспонента=" + close_exhibitor +
                ", произведение=" + derivative +
                '}';
    }
}


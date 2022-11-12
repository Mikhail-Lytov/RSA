public class Open_key {
    private long open_exhibitor;
    private long derivative;

    public Open_key(long open_exhibitor, long derivative){
        this.open_exhibitor = open_exhibitor;
        this.derivative = derivative;
    }

    public long getOpen_exhibitor(){
        return open_exhibitor;
    }

    public  long getDerivative(){
        return derivative;
    }

    @Override
    public String toString() {
        return "Open_key{" +
                "откртыая экспонента=" + open_exhibitor +
                ", произведение=" + derivative +
                '}';
    }
}

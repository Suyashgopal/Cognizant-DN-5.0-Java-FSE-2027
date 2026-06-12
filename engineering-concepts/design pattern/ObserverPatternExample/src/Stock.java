public interface Stock {

    void addobserver(Observer obj);

    void removeobserver(Observer obj);

    void notifyobserver();
}
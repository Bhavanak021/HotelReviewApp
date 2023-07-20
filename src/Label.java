public enum Label {
    PLUS(100),
    NORMAL(99);
    int priority;

    Label(int priority) {
        this.priority = priority;
    }
}
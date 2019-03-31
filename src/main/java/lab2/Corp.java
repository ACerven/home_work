package lab2;

abstract class Corp {
    private int wide;
    private int hide;

    public Corp(int var1, int var2) {
        this.wide = var1;
        this.hide = var2;
    }

    public int getWide() {
        return this.wide;
    }

    public int getHide() {
        return this.hide;
    }
}

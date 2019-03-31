package lab2;

class Stove extends Corp {
    private int hob;

    public Stove(int var1, int var2, int var3) {
        super(var2, var3);
        this.hob = var1;
    }

    public int getHob() {
        return this.hob;
    }

    public int getPerson() {
        return this.hob * 4;
    }
}

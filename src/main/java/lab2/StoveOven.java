package lab2;

class StoveOven extends Stove {
    private int shelf;

    public StoveOven(int var1, int var2, int var3, int var4) {
        super(var1, var2, var3);
        this.shelf = var4;
    }

    public int getShelf() {
        return this.shelf;
    }

    public int getPerson() {
        return this.shelf * 6 + super.getPerson();
    }

    public String toString() {
        return "On this stove you can cooked for" + this.getPerson() + "persons";
    }
}

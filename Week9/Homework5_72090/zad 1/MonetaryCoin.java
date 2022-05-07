package fmi.poop.zad1;

public class MonetaryCoin extends Coin
{
    private int value;

    MonetaryCoin()
    {
        this.value = 0;
    }

    MonetaryCoin(int value)
    {
        this.setValue(value);
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int value) {
        if (value > 0)
            this.value = value;

        else
            this.value = 0;
    }
}

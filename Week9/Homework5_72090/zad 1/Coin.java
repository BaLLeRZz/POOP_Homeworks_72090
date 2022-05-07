package fmi.poop.zad1;

import java.util.Random;

public class Coin {
    private Random rand;
    private Face face;

    Coin()
    {
        this.rand = new Random();
        this.face = Face.HEAD;
    }

    Coin(Face face)
    {
        this.rand = new Random();
        this.setFace(face);
    }

    final Face getFace()
    {
        return this.face;
    }

    final void setFace(Face face)
    {
        if (face != Face.HEAD && face != Face.TAIL)
        {
            System.out.println("Invalid coin face!");
            return;
        }

        this.face = face;
    }

    public void flip()
    {
        int side = this.rand.nextInt(2);
        if (side == 0)
            this.face = Face.HEAD;

        else
            this.face = Face.TAIL;
    }

    boolean isHeads()
    {
        return this.face == Face.HEAD;
    }

    @Override
    public String toString() {
        return "Coin{" + "face = " + this.face + '}';
    }
}

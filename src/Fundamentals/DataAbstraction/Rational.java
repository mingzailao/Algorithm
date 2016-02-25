package Fundamentals.DataAbstraction;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by apple on 16/2/25.
 */
public class Rational implements Comparable<Rational> {
    private static Rational zero = new Rational(0, 1);
    private long num;
    private long den;

    @Override
    public String toString() {
        if (den == 1) return num + "";
        else          return num + "/" + den;
    }

    public long getNum() {
        return num;
    }
    public boolean equals(Object y) {
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Rational b = (Rational) y;
        return compareTo(b) == 0;
    }
    public Rational times(Rational that) {

        // reduce p1/q2 and p2/q1, then multiply, where a = p1/q1 and b = p2/q2
        Rational c = new Rational(this.num, that.den);
        Rational d = new Rational(that.num, this.den);
        return new Rational(c.num * d.num, c.den * d.den);
    }
    public Rational plus(Rational that) {

        // special cases
        if (this.compareTo(zero) == 0) return that;
        if (that.compareTo(zero) == 0) return this;

        // Find gcd of numerators and denominators
        long f = gcd(this.num, that.num);
        long g = gcd(this.den, that.den);

        // add cross-product terms for numerator
        Rational s = new Rational((this.num / f) * (that.den / g) + (that.num / f) * (this.den / g),
                lcm(this.den, that.den));

        // multiply back in
        s.num *= f;
        return s;
    }


    public Rational(long numerator, long denominator) {

        // deal with x/0
        if (denominator == 0) {
            throw new RuntimeException("Denominator is zero");
        }

        // reduce fraction
        long g = gcd(numerator, denominator);
        num = numerator   / g;
        den = denominator / g;

        // only needed for negative numbers
        if (den < 0) { den = -den; num = -num; }

    }

    private static long gcd(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);

    }


    public long getDen() {
        return den;
    }

    @Override
    public int compareTo(Rational o) {
        long lhs = this.num * o.den;
        long rhs = this.den * o.num;
        if (lhs < rhs) return -1;
        if (lhs > rhs) return +1;
        return 0;
    }
    private static long lcm(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        return m * (n /gcd(m, n));    // parentheses important to avoid overflow
    }
    public Rational negate() {
        return new Rational(-num, den);
    }

    // return this - that
    public Rational minus(Rational that) {
        return this.plus(that.negate());
    }


    public Rational reciprocal() { return new Rational(den, num);  }

    // return this / that
    public Rational divides(Rational that) {
        return this.times(that.reciprocal());
    }
    public static void main(String[] args) {
        Rational x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

        // 1/200000000 + 1/300000000 = 1/120000000
        x = new Rational(1, 200000000);
        y = new Rational(1, 300000000);
        z = x.plus(y);
        StdOut.println(z);

        // 1073741789/20 + 1073741789/30 = 1073741789/12
        x = new Rational(1073741789, 20);
        y = new Rational(1073741789, 30);
        z = x.plus(y);
        StdOut.println(z);

        //  4/17 * 17/4 = 1
        x = new Rational(4, 17);
        y = new Rational(17, 4);
        z = x.times(y);
        StdOut.println(z);

        // 3037141/3247033 * 3037547/3246599 = 841/961
        x = new Rational(3037141, 3247033);
        y = new Rational(3037547, 3246599);
        z = x.times(y);
        StdOut.println(z);

        // 1/6 - -4/-8 = -1/3
        x = new Rational(1, 6);
        y = new Rational(-4, -8);
        z = x.minus(y);
        StdOut.println(z);
    }
}

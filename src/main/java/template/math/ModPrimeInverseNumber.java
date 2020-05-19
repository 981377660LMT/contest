package template.math;

/**
 * Find all inverse number
 */
public class ModPrimeInverseNumber implements InverseNumber {
    int[] inv;

    public ModPrimeInverseNumber(int[] inv, int limit, Modular modular) {
        this.inv = inv;
        inv[1] = 1;
        int p = modular.getMod();
        for (int i = 2; i <= limit; i++) {
            int k = p / i;
            int r = p % i;
            inv[i] = modular.mul(-k, inv[r]);
        }
    }

    public ModPrimeInverseNumber(int limit, Modular modular) {
        this(new int[limit + 1], limit, modular);
    }

    public int inverse(int x) {
        return inv[x];
    }
}
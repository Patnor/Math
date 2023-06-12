public class QuadraticFormula {
    public static void main(String[] args) {
        // Test the quadratic equation solver
        solveQuadraticEquation(1, -5, 6); // Example: solve x^2 - 5x + 6 = 0

        // Test the quadratic equation solver
        QuadraticEquation equation = new QuadraticEquation(1, -5, 6); // Example: solve x^2 - 5x + 6 = 0
        EquationRoots roots = solveQuadraticEquation(equation);
        System.out.println(roots);
    }

    /**
     * Solves a quadratic equation and prints the roots.
     *
     * @param a the coefficient of the quadratic term
     * @param b the coefficient of the linear term
     * @param c the constant term
     */
    public static void solveQuadraticEquation(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two distinct real roots:");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real root:");
            System.out.println("Root: " + root);
        } else {
            System.out.println("No real roots. Complex roots exist.");
        }
    }

    /**
     * Solves a quadratic equation and returns the roots.
     *
     * @param equation the quadratic equation to solve
     * @return an {EquationRoots} object containing the roots of the equation
     */
    public static EquationRoots solveQuadraticEquation(QuadraticEquation equation) {
        double a = equation.getA();
        double b = equation.getB();
        double c = equation.getC();
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new EquationRoots(root1, root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new EquationRoots(root);
        } else {
            return new EquationRoots(); // No real roots
        }
    }
}

/**
 * Represents the roots of a quadratic equation.
 */
class EquationRoots {
    private double root1;
    private double root2;

    /**
     * Constructs an EquationRoots object with two distinct real roots.
     *
     * @param root1 the first root
     * @param root2 the second root
     */
    public EquationRoots(double root1, double root2) {
        this.root1 = root1;
        this.root2 = root2;
    }

    /**
     * Constructs an EquationRoots object with one real root.
     *
     * @param root the real root
     */
    public EquationRoots(double root) {
        this.root1 = root;
        this.root2 = root;
    }

    /**
     * Constructs an EquationRoots object indicating no real roots.
     * Complex roots exist.
     */
    public EquationRoots() {
        this.root1 = Double.NaN; // Indicates no real roots
        this.root2 = Double.NaN;
    }

    /**
     * Returns a string representation of the EquationRoots object.
     *
     * @return a string describing the roots of the quadratic equation
     */
    @Override
    public String toString() {
        if (Double.isNaN(root1) && Double.isNaN(root2)) {
            return "No real roots. Complex roots exist.";
        } else if (root1 == root2) {
            return "One real root: " + root1;
        } else {
            return "Two distinct real roots: " + root1 + ", " + root2;
        }
    }
}

/**
 * Represents a quadratic equation of the form ax^2 + bx + c = 0.
 */
class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    /**
     * Constructs a QuadraticEquation object with the given coefficients.
     *
     * @param a the coefficient of the quadratic term (a != 0)
     * @param b the coefficient of the linear term
     * @param c the constant term
     */
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Returns the coefficient of the quadratic term (a).
     *
     * @return the coefficient of the quadratic term
     */
    public double getA() {
        return a;
    }

    /**
     * Returns the coefficient of the linear term (b).
     *
     * @return the coefficient of the linear term
     */
    public double getB() {
        return b;
    }

    /**
     * Returns the constant term (c).
     *
     * @return the constant term
     */
    public double getC() {
        return c;
    }
}

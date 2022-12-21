package javaapplication26;


import java.util.*;


public class RobotNavigation {

    public static void main(String[] fd) {
        Scanner s = new Scanner(System.in);
        System.out.println("Source:");
        int xs = s.nextInt();
        int ys = s.nextInt();
        char ds = s.next().charAt(0);
        System.out.println("Destination:");
        int xd = s.nextInt();
        int yd = s.nextInt();
        char dd = s.next().charAt(0);
        steps(xs, ys, ds, xd, yd, dd);
    }

    public static int rotate(int xs, int ys, char ds, char to) {
        char[] direction = {'N', 'W', 'S', 'E', 'N', 'W', 'S', 'E'};
        int ini = 0;
        for (int i = 0; i < direction.length; i++) {
            if (direction[i] == ds) {
                ini = i;
                break;
            }
        }
        int c = 0;
        for (int i = ini + 1; i < direction.length; i++) {
//			System.out.println(direction[i]+"----------");
            System.out.println("Turn left:  " + xs + " " + ys + " " + direction[i]);
            c++;
            if (direction[i] == to) {
                return c;
            }

        }
        return 'N';
    }

    static void steps(int xs, int ys, char ds, int xd, int yd, char dd) {
        char[] direction = {'N', 'W', 'S', 'E'};
        if ((xs >= 0 && ys >= 0 && xd >= 0 && yd >= 0 && (!(new String(direction).indexOf(ds) == -1)) && (!(new String(direction).indexOf(dd) == -1)))) {

            int fc = 0, lc = 0;
            while (xs != xd || ys != yd || dd != ds) {
                if (ys < yd) {
                    if (ds == 'N') {

                    } else {
                        lc += rotate(xs, ys, ds, 'N');
                        ds = 'N';
                    }
                    while (ys != yd) {
                        ys++;
                        fc++;
                        System.out.println("Move forward: " + xs + " " + ys + " " + ds);
                    }
                }
                if (ys > yd) {
                    if (ds == 'S') {

                    } else {
                        lc += rotate(xs, ys, ds, 'S');
                        ds = 'S';
                    }
                    while (ys != yd) {
                        ys--;
                        fc++;
                        System.out.println("Move forward: " + xs + " " + ys + " " + ds);
                    }
                }

                if (xs < xd) {
                    if (ds == 'E') {

                    } else {
                        lc += rotate(xs, ys, ds, 'E');
                        ds = 'E';
                    }
                    while (xs != xd) {
                        xs++;
                        fc++;
                        System.out.println("Move forward: " + xs + " " + ys + " " + ds);
                    }
                }
                if (xs > xd) {
                    if (ds == 'W') {

                    } else {
                        lc += rotate(xs, ys, ds, 'W');
                        ds = 'W';
                    }
                    while (xs != xd) {
                        xs--;
                        fc++;
                        System.out.println("Move forward: " + xs + " " + ys + " " + ds);
                    }
                }
                if (ds != dd) {
                    lc += rotate(xs, ys, ds, dd);
                    ds = dd;
                }
            }

            System.out.println("Summary:");
            int count = lc + fc;
            System.out.println("Total steps: " + count);
            System.out.println("Move forward: " + fc);
            System.out.println("turn left: " + lc);
        } else {
            System.out.println("Invalid input");
        }

    }
}
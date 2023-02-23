package utils;
import java.util.*;

public class UserInput {
    private static String fixString(String message) {
        if (message.endsWith(" ")) {
            return message;
        } else {
            return message + ' ';
        }
    }

    //
    // Doubles
    //

    public static double inputDouble(Scanner sc, String message) {
        double num;
        boolean ok = false;

        message = fixString(message);
        System.out.print(message);

        do {
            try {
                num = Double.parseDouble(sc.nextLine());
                ok = true;
            } catch (Exception e) {
                num = 0; // Dummy
                System.out.print("You didn't input a number. Try again: ");
            }
        } while (!ok);

        return num;
    }

    public static double inputDoublePositive(Scanner sc, String message) {
        double num;

        message = fixString(message);
        System.out.print(message);
        do {
            try {
                num = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                num = 0; // Dummy
                System.out.print("You didn't input a number. Try again: ");
                continue;
            }
            
            if (!(num > 0)) {
                System.out.print("The value you inputted isn't positive. Input a new one: ");
            }
        } while (!(num > 0));
        
        return num;
    }

    public static double inputDoubleRange(Scanner sc, String message, double min, double max, boolean exclusive_left, boolean exclusive_right) {
        double num;
        boolean ok = false;

        message = fixString(message);
        System.out.print(message);
        do {
            try {
                num = Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                num = 0; // Dummy
                System.out.print("You didn't input a number. Try again: ");
                continue;
            }

            if (exclusive_left) {
                if (exclusive_right) {
                    if (num <= min || num >= max) {
                        if (max == Double.POSITIVE_INFINITY) {
                            System.out.printf("The value you inputted isn't in range ]%f, Infinity[. Input a new one: ", min);
                        } else if (min == Double.POSITIVE_INFINITY * -1) {
                            System.out.printf("The value you inputted isn't in range ]Infinity, %f[. Input a new one: ", max);
                        } else {
                            System.out.printf("The value you inputted isn't in range ]%f, %f[. Input a new one: ", min, max);
                        }
                    } else {
                        ok = true;
                    }

                } else {
                    if (num <= min || num > max) {
                        if (min == Double.POSITIVE_INFINITY * -1) {
                            System.out.printf("The value you inputted isn't in range ]Infinity, %f]. Input a new one: ", max);
                        } else {
                            System.out.printf("The value you inputted isn't in range ]%f, %f]. Input a new one: ", min, max);
                        }
                    } else {
                        ok = true;
                    }
                }
            } else {
                if (exclusive_right) {
                    if (num < min || num >= max) {
                        if (max == Double.POSITIVE_INFINITY) {
                            System.out.printf("The value you inputted isn't in range [%f, Infinity[. Input a new one: ", min);
                        } else {
                            System.out.printf("The value you inputted isn't in range [%f, %f[. Input a new one: ", min, max);
                        }
                    } else {
                        ok = true;
                    }
                } else {
                    if (num < min || num > max) {
                        System.out.printf("The value you inputted isn't in range [%f, %f]. Input a new one: ", min, max);
                    } else {
                        ok = true;
                    }
                }
            }
        } while (!ok);

        return num;
    }

    public static double inputDoubleRangeMin(Scanner sc, String message, double min, boolean exclusive_left) {
        return inputDoubleRange(sc, message, min, Double.POSITIVE_INFINITY, exclusive_left, true);
    }

    public static double inputDoubleRangeMax(Scanner sc, String message, double max, boolean exclusive_right) {
        return inputDoubleRange(sc, message, Double.POSITIVE_INFINITY * -1, max, true, exclusive_right);
    }

    
    //
    // Integers
    //

    public static int inputInt(Scanner sc, String message) {
        int num;
        boolean ok = false;

        message = fixString(message);
        System.out.print(message);

        do {
            try {
                num = Integer.parseInt(sc.nextLine());
                ok = true;
            } catch (Exception e) {
                num = 0; // Dummy
                System.out.print("You didn't input a number. Try again: ");
            }
        } while (!ok);

        return num;
    }

    public static int inputIntPositive(Scanner sc, String message) {
        int num;

        message = fixString(message);
        System.out.print(message);
        do {
            try {
                num = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                num = 0; // Dummy
                System.out.print("You didn't input a number. Try again: ");
                continue;
            }

            if (!(num > 0)) {
                System.out.print("The value you inputted isn't positive. Input a new one: ");
            }
        } while (!(num > 0));
        
        return num;
    }

    public static int inputIntRange(Scanner sc, String message, int min, int max, boolean exclusive_left, boolean exclusive_right) {
        int num;
        boolean ok = false;

        message = fixString(message);
        System.out.print(message);
        do {
            try {
                num = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                num = 0; // Dummy
                System.out.print("You didn't input a number. Try again: ");
                continue;
            }

            if (exclusive_left) {
                if (exclusive_right) {
                    if (num <= min || num >= max) {
                        if (max == Integer.MAX_VALUE) {
                            System.out.printf("The value you inputted isn't in range ]%f, Infinity[. Input a new one: ", min);
                        } else if (min == Integer.MIN_VALUE) {
                            System.out.printf("The value you inputted isn't in range ]Infinity, %f[. Input a new one: ", max);
                        } else {
                            System.out.printf("The value you inputted isn't in range ]%f, %f[. Input a new one: ", min, max);
                        }
                    } else {
                        ok = true;
                    }

                } else {
                    if (num <= min || num > max) {
                        if (min == Integer.MIN_VALUE) {
                            System.out.printf("The value you inputted isn't in range ]Infinity, %f]. Input a new one: ", max);
                        } else {
                            System.out.printf("The value you inputted isn't in range ]%f, %f]. Input a new one: ", min, max);
                        }
                    } else {
                        ok = true;
                    }
                }
            } else {
                if (exclusive_right) {
                    if (num < min || num >= max) {
                        if (max == Integer.MAX_VALUE) {
                            System.out.printf("The value you inputted isn't in range [%f, Infinity[. Input a new one: ", min);
                        } else {
                            System.out.printf("The value you inputted isn't in range [%f, %f[. Input a new one: ", min, max);
                        }
                    } else {
                        ok = true;
                    }
                } else {
                    if (num < min || num > max) {
                        System.out.printf("The value you inputted isn't in range [%f, %f]. Input a new one: ", min, max);
                    } else {
                        ok = true;
                    }
                }
            }
        } while (!ok);

        return num;
    }

    public static double inputIntRangeMin(Scanner sc, String message, double min, boolean exclusive_left) {
        return inputDoubleRange(sc, message, min, Integer.MAX_VALUE, exclusive_left, true);
    }

    public static double inputIntRangeMax(Scanner sc, String message, double max, boolean exclusive_right) {
        return inputDoubleRange(sc, message, Integer.MIN_VALUE, max, true, exclusive_right);
    }


    //
    // Strings
    //

    public static String inputString(Scanner sc, String message) {
        message = fixString(message);
        System.out.print(message);
        return sc.nextLine();
    }
}
